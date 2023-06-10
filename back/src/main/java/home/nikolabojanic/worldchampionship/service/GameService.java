package home.nikolabojanic.worldchampionship.service;
import home.nikolabojanic.worldchampionship.model.Game;
import home.nikolabojanic.worldchampionship.web.dto.GameDto;
import org.springframework.data.domain.Page;
import java.util.Optional;
public interface GameService {
    Page<Game> getAll(Long aId, Long bId, int pageNo, int pageSize);
    Optional<Game> getOne(Long id);
    Game save (GameDto dto);
    void delete(Long id);
}