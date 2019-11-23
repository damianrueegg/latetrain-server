package ch.ffhs.pa5.latetrain.latetrainserver.service;

import ch.ffhs.pa5.latetrain.latetrainserver.model.RouteResults;
import ch.ffhs.pa5.latetrain.latetrainserver.model.UserConnection;
import ch.ffhs.pa5.latetrain.latetrainserver.model.repository.UserConnectionRepository;
import ch.ffhs.pa5.latetrain.latetrainserver.security.SecurityContextService;
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
        return null;
    }

    @Override
    public UserConnection createUserConnection(UserConnection userConnection) {
        userConnection.setUser(securityContextService.getLoggedInUser());
        return repository.save(userConnection);
    }

    @Override
    public List<UserConnection> readAllByCurrentUser() {
        return null;
    }

    @Override
    public void deleteUserConnectionById(Long id) {

    }

    @Override
    public RouteResults getEffectiveRoutesForUserConnectionWithId(Long userConnectionId) {
        return null;
    }

    @Override
    public UserConnection updateUserConnectionDetailsAccordingToEffectiveRoute(Long id, int routeIndex) {
        return null;
    }
}
