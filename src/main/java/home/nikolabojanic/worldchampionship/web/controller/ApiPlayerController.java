package home.nikolabojanic.worldchampionship.web.controller;
import home.nikolabojanic.worldchampionship.service.PlayerService;
import home.nikolabojanic.worldchampionship.support.PlayerToPlayerDto;
import home.nikolabojanic.worldchampionship.web.dto.PlayerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity<PlayerDto>topScorer(){
        return new ResponseEntity<>(toDto.convert(playerService.topScorer()), HttpStatus.OK);
    }
//    @PutMapping(value = "/score/{id}")
//    public ResponseEntity<PlayerDto>
}