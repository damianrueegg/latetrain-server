package ch.ffhs.pa5.latetrain.latetrainserver.security;

import ch.ffhs.pa5.latetrain.latetrainserver.model.User;
import ch.ffhs.pa5.latetrain.latetrainserver.model.repository.UserRepository;
import javax.xml.bind.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserManagementService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public User register(User user) throws ValidationException {
        if(checkIfUserExists(user.getUsername())){
            throw new ValidationException("User exists");
        }
        if(!user.getPassword().equals(user.getPasswordConfirm())){
            throw new ValidationException("Password missmatch");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    private boolean checkIfUserExists(String username){
        return userRepository.existsByUsername(username);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
