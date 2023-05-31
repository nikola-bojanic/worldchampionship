package home.nikolabojanic.worldchampionship.service.impl;
import home.nikolabojanic.worldchampionship.model.Player;
import home.nikolabojanic.worldchampionship.repository.PlayerRepository;
import home.nikolabojanic.worldchampionship.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class JpaPlayerService implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    @Override
    public List<Player> getAll() {
        return playerRepository.findAll();
    }
    @Override
    public List<Player> topScorer() {
        return playerRepository.topScorer();
    }
    @Override
    public List<Player> getTeamPlayers(Long teamId) {
        return playerRepository.teamPlayers(teamId);
    }
    @Override
    public Optional<Player> getOne(Long id) {
        return playerRepository.findById(id);
    }
    @Override
    public Player scoreGoal(Long id) {
        Optional<Player> existing = playerRepository.findById(id);
        if(existing.isPresent()){
            Player p = existing.get();
            p.setGoals(p.getGoals() + 1);
            playerRepository.save(p);
            return p;
        }else {
            return null;
        }
    }
}