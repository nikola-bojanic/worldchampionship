package home.nikolabojanic.worldchampionship.repository;
import home.nikolabojanic.worldchampionship.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findFirstByUsername(String username);
    Optional<User> findFirstByUsernameAndPassword(String username,String password);
}