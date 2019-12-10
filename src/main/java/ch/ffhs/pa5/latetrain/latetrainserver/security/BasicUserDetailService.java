package ch.ffhs.pa5.latetrain.latetrainserver.security;

import ch.ffhs.pa5.latetrain.latetrainserver.model.repository.UserRepository;
import java.util.HashSet;
import java.util.Set;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@Primary
public class BasicUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        val byUsername = userRepository.findByUsername(username);
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(byUsername.getRole()));
        return new User(byUsername.getUsername(), byUsername.getPassword(), authorities);
    }
}
