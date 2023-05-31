package home.nikolabojanic.worldchampionship.support;
import home.nikolabojanic.worldchampionship.model.Team;
import home.nikolabojanic.worldchampionship.web.dto.TeamDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class TeamToTeamDto implements Converter<Team, TeamDto> {
    @Override
    public TeamDto convert(Team team) {
        TeamDto dto = new TeamDto();
        dto.setId(team.getId());
        dto.setName(team.getName());
        dto.setCode(team.getCode());
        return dto;
    }
    public List<TeamDto> convert(List<Team> teams){
        List<TeamDto> dtos = new ArrayList<>();
        for(Team team : teams){
            dtos.add(convert(team));
        }
        return dtos;
    }
}