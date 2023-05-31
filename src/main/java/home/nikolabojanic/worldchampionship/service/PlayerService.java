package home.nikolabojanic.worldchampionship.service;
import home.nikolabojanic.worldchampionship.model.Player;
import java.util.List;
import java.util.Optional;
public interface PlayerService {
    List<Player> getAll();
    List<Player> topScorer();
    List<Player>getTeamPlayers(Long teamId);
    Optional<Player>getOne(Long id);
    Player scoreGoal(Long id);
}