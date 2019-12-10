package ch.ffhs.pa5.latetrain.latetrainserver.model.repository;

import ch.ffhs.pa5.latetrain.latetrainserver.model.UserConnection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserConnectionRepository extends JpaRepository<UserConnection, Long> {}