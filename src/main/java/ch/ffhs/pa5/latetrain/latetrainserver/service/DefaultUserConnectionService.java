package ch.ffhs.pa5.latetrain.latetrainserver.service;

import ch.ffhs.pa5.latetrain.latetrainserver.model.Route;
import ch.ffhs.pa5.latetrain.latetrainserver.model.RouteResults;
import ch.ffhs.pa5.latetrain.latetrainserver.model.UserConnection;
import ch.ffhs.pa5.latetrain.latetrainserver.model.repository.UserConnectionRepository;
import ch.ffhs.pa5.latetrain.latetrainserver.security.SecurityContextService;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUserConnectionService implements UserConnectionService {

    @Autowired
    UserConnectionRepository repository;
    @Autowired
    SecurityContextService securityContextService;
    @Autowired
    RouteSearchService routeSearchService;

    @Override
    public UserConnection readUserConnectionById(Long id) {
        return repository.getOne(id);
    }

    @Override
    public UserConnection createUserConnection(UserConnection userConnection) {
        userConnection.setUser(securityContextService.getLoggedInUser());
        return repository.save(userConnection);
    }

    @Override
    public List<UserConnection> readAllByCurrentUser() {
        return repository.findAll()
                         .stream()
                         .filter(it -> it.getUser().getUsername().equals(securityContextService.findLoggedInUsername()))
                         .collect(Collectors.toList());
    }

    @Override
    public void deleteUserConnectionById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public RouteResults getEffectiveRoutesForUserConnectionWithId(Long userConnectionId) {
        return routeSearchService.getRouteSearchResult(repository.getOne(userConnectionId));
    }

    @Override
    public UserConnection updateUserConnectionDetailsAccordingToEffectiveRoute(Long id, int routeIndex) {
        Route effectiveRoute = getEffectiveRoutesForUserConnectionWithId(id).getConnections().get(routeIndex);
        UserConnection connection = repository.getOne(id);
        connection.setFrom(effectiveRoute.getFrom());
        connection.setTo(effectiveRoute.getTo());
        connection.setDepartureTimeOfDay(effectiveRoute.getDeparture().toLocalTime());
        return repository.save(connection);
    }
}
