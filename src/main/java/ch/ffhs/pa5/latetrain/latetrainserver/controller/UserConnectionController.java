package ch.ffhs.pa5.latetrain.latetrainserver.controller;

import ch.ffhs.pa5.latetrain.latetrainserver.model.UserConnection;
import ch.ffhs.pa5.latetrain.latetrainserver.service.UserConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserConnectionController {
    @Autowired
    UserConnectionService userConnectionService;

    @PostMapping("/userConnection")
    public UserConnection createUserConnection(){
        return userConnectionService.createUserConnection(null);
    }
}
