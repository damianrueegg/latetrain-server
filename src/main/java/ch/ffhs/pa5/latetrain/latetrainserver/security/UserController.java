package ch.ffhs.pa5.latetrain.latetrainserver.security;

import ch.ffhs.pa5.latetrain.latetrainserver.model.User;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserManagementService userManagementService;

    @Autowired
    SecurityContextService securityContextService;

    @PostMapping("/register")
    public void register(@RequestBody User user, HttpServletResponse response) throws ValidationException {
        userManagementService.register(user);
        securityContextService.autologin(user.getUsername(), user.getPasswordConfirm());
        try {
            response.sendRedirect("/api/userConnection/all");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable Long id) {userManagementService.deleteUserById(id);
    }
}
