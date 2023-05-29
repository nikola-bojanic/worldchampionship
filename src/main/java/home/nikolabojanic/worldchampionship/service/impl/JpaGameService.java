package home.nikolabojanic.worldchampionship.service.impl;
import home.nikolabojanic.worldchampionship.model.Game;
import home.nikolabojanic.worldchampionship.repository.GameRepository;
import home.nikolabojanic.worldchampionship.service.GameService;
import home.nikolabojanic.worldchampionship.support.GameDtoToGame;
import home.nikolabojanic.worldchampionship.web.dto.GameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class JpaGameService implements GameService {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GameDtoToGame toGame;
    @Override
    public Page<Game> getAll(int pageNo, int pageSize) {
        return gameRepository.findAll(PageRequest.of(pageNo, pageSize));
    }
    @Override
    public Optional<Game> getOne(Long id) {
        return gameRepository.findById(id);
    }

    @Override
    public Game save(GameDto dto) {
        return gameRepository.save(toGame.convert(dto));
    }
    @Override
    public void delete(Long id) {
        gameRepository.deleteById(id);
    }
}