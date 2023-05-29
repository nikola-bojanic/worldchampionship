package home.nikolabojanic.worldchampionship.service.impl;
import home.nikolabojanic.worldchampionship.model.Team;
import home.nikolabojanic.worldchampionship.repository.TeamRepository;
import home.nikolabojanic.worldchampionship.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class JpaTeamService implements TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Override
    public List<Team> getAll() {
        return teamRepository.findAll();
    }
    @Override
    public Team getOne(Long id) {
        return teamRepository.getOne(id);
    }
}