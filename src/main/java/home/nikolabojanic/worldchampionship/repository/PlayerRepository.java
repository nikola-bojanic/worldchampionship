package home.nikolabojanic.worldchampionship.repository;
import home.nikolabojanic.worldchampionship.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query("SELECT p FROM Player p WHERE p.goals = (SELECT MAX (goals) FROM p)")
    Player topScorer();
}