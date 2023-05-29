package home.nikolabojanic.worldchampionship.repository;
import home.nikolabojanic.worldchampionship.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}