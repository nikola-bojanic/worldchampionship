package home.nikolabojanic.worldchampionship.service;
import home.nikolabojanic.worldchampionship.model.Player;
import java.util.List;
public interface PlayerService {
    List<Player> getAll();
    Player topScorer();
}