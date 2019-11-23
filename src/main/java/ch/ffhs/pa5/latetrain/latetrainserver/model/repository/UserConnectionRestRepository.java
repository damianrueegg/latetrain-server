package ch.ffhs.pa5.latetrain.latetrainserver.model.repository;

import ch.ffhs.pa5.latetrain.latetrainserver.model.UserConnection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserConnectionRestRepository extends PagingAndSortingRepository<UserConnection, Long> {
}
