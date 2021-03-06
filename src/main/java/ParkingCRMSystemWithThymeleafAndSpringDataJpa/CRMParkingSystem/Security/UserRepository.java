package ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Security;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
@Query("SELECT u FROM User u WHERE u.userName = :username")
public User getUserByUsername(@Param("username") String username);
}
