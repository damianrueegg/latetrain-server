package ch.ffhs.pa5.latetrain.latetrainserver.controller;

import ch.ffhs.pa5.latetrain.latetrainserver.model.RouteResults;
import ch.ffhs.pa5.latetrain.latetrainserver.model.UserConnection;
import ch.ffhs.pa5.latetrain.latetrainserver.service.UserConnectionService;
import java.time.LocalTime;
import java.util.List;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserConnectionController {
    @Autowired
    UserConnectionService userConnectionService;

    @PostMapping("/userConnection")
    public UserConnection createUserConnection(@RequestBody UserConnection userConnection){
        return userConnectionService.createUserConnection(userConnection);
    }

    @GetMapping("/userConnection/{id}/effectiveRoute")
    public RouteResults getEffectiveRoutesForConnection(@PathVariable Long id){
        return userConnectionService.getEffectiveRoutesForUserConnectionWithId(id);
    }

    @PatchMapping("/userConnection/{id}/effectiveRoute/{routeIndex}")
    public UserConnection updateAccordingToRoute(@PathVariable Long id, @PathVariable int routeIndex){
        return userConnectionService.updateUserConnectionDetailsAccordingToEffectiveRoute(id, routeIndex);
    }

    @DeleteMapping("/userConnection/{id}")
    public void deleteConnection(@PathVariable Long id){
        userConnectionService.deleteUserConnectionById(id);
    }

    @GetMapping("/userConnection/{id}")
    public UserConnection readById(@PathVariable Long id){
        return userConnectionService.readUserConnectionById(id);
    }

    @GetMapping("/userConnection/all")
    public List<UserConnection> readAll(){
        return userConnectionService.readAllByCurrentUser();
    }
}
