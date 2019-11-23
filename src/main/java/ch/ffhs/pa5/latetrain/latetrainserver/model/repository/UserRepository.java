package ch.ffhs.pa5.latetrain.latetrainserver.model.repository;

import ch.ffhs.pa5.latetrain.latetrainserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
