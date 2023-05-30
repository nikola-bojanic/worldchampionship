package home.nikolabojanic.worldchampionship.repository;
import home.nikolabojanic.worldchampionship.model.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Page<Game> findByTeamAIdEqualsAndTeamBIdEquals(Long aId, Long bId, Pageable pageable);
    Page<Game> findByTeamAIdEquals(Long aId, Pageable pageable);
    Page<Game> findByTeamBIdEquals(Long bId, Pageable pageable);
}