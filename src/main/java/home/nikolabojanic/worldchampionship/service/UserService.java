package home.nikolabojanic.worldchampionship.service;
import home.nikolabojanic.worldchampionship.model.User;
import home.nikolabojanic.worldchampionship.web.dto.UserPasswordChangeDto;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.Optional;
public interface UserService {
    Optional<User> one(Long id);
    List<User> all();
    Page<User> all(int pageNo);
    User save(User user);
    void delete(Long id);
    Optional<User> findbyKorisnickoIme(String username);
	boolean changePassword(Long id, UserPasswordChangeDto userPasswordChangeDto);
}