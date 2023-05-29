package home.nikolabojanic.worldchampionship.repository;
import home.nikolabojanic.worldchampionship.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}