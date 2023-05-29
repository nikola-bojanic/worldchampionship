package home.nikolabojanic.worldchampionship.service;
import home.nikolabojanic.worldchampionship.model.Team;
import java.util.List;
public interface TeamService {
    List<Team> getAll();
    Team getOne(Long id);
}