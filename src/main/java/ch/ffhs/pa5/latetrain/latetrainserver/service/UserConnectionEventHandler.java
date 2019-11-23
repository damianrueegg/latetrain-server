package ch.ffhs.pa5.latetrain.latetrainserver.service;

import ch.ffhs.pa5.latetrain.latetrainserver.model.UserConnection;
import ch.ffhs.pa5.latetrain.latetrainserver.security.SecurityContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler()
public class UserConnectionEventHandler {

    @Autowired
    SecurityContextService securityContextService;

    @HandleBeforeCreate
    public void setUserOnUserConnectionCreate(UserConnection userConnection){
        userConnection.setUser(securityContextService.getLoggedInUser());
    }
}
