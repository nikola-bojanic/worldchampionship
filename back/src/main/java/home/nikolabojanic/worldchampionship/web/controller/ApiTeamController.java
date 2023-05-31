package home.nikolabojanic.worldchampionship.web.controller;
import home.nikolabojanic.worldchampionship.service.TeamService;
import home.nikolabojanic.worldchampionship.support.TeamToTeamDto;
import home.nikolabojanic.worldchampionship.web.dto.TeamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping(value = "api/teams", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiTeamController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private TeamToTeamDto toDto;
    @GetMapping
    public ResponseEntity<List<TeamDto>>getTeams(){
        return new ResponseEntity<>(toDto.convert(teamService.getAll()), HttpStatus.OK);
    }
}