package home.nikolabojanic.worldchampionship.web.controller;
import home.nikolabojanic.worldchampionship.model.Player;
import home.nikolabojanic.worldchampionship.service.PlayerService;
import home.nikolabojanic.worldchampionship.support.PlayerToPlayerDto;
import home.nikolabojanic.worldchampionship.web.dto.PlayerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping(value = "api/players", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiPlayerController {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private PlayerToPlayerDto toDto;
    @GetMapping
    public ResponseEntity<List<PlayerDto>>getPlayers(){
        return new ResponseEntity<>(toDto.convert(playerService.getAll()), HttpStatus.OK);
    }
    @GetMapping("/topScorer")
    public ResponseEntity <List<PlayerDto>>topScorer(){
        return new ResponseEntity<>(toDto.convert(playerService.topScorer()), HttpStatus.OK);
    }
    @GetMapping("/team")
    public ResponseEntity<List<PlayerDto>>getTeamPlayers(@RequestParam Long teamId){
        return new ResponseEntity<>(toDto.convert(playerService.getTeamPlayers(teamId)), HttpStatus.OK);
    }
    @PutMapping(value = "/goalscorer/{id}")
    public ResponseEntity<PlayerDto> goalscorer(@PathVariable Long id, @RequestParam Long playerId){
        if(id != playerId){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Player saved = playerService.scoreGoal(playerId);
        if(saved == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(toDto.convert(saved), HttpStatus.OK);
        }
    }
}