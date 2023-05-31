package home.nikolabojanic.worldchampionship.repository;
import home.nikolabojanic.worldchampionship.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query("SELECT p FROM Player p WHERE p.goals = (SELECT MAX (goals) FROM p)")
    List<Player> topScorer();
    @Query("SELECT p FROM Player p WHERE p.team.id = :teamId")
    List<Player> teamPlayers(@Param("teamId")Long teamId);
}