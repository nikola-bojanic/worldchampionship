package home.nikolabojanic.worldchampionship.service.impl;
import home.nikolabojanic.worldchampionship.model.Player;
import home.nikolabojanic.worldchampionship.repository.PlayerRepository;
import home.nikolabojanic.worldchampionship.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class JpaPlayerService implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    @Override
    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    @Override
    public Player topScorer() {
        return playerRepository.topScorer();
    }
}