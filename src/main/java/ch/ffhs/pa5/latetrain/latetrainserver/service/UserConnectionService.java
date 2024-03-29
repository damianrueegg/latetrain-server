package ch.ffhs.pa5.latetrain.latetrainserver.service;

import ch.ffhs.pa5.latetrain.latetrainserver.model.RouteResults;
import ch.ffhs.pa5.latetrain.latetrainserver.model.UserConnection;
import java.time.LocalTime;
import java.util.List;

public interface UserConnectionService {
    UserConnection readUserConnectionById(Long id);
    UserConnection createUserConnection(UserConnection userConnection);
    List<UserConnection> readAllByCurrentUser();
    void deleteUserConnectionById(Long id);
    RouteResults getEffectiveRoutesForUserConnectionWithId(Long userConnectionId);
    UserConnection updateUserConnectionDetailsAccordingToEffectiveRoute(Long id, int routeIndex);
}
