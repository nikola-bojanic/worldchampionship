package home.nikolabojanic.worldchampionship.repository;
import home.nikolabojanic.worldchampionship.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}