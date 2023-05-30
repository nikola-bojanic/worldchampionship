package home.nikolabojanic.worldchampionship.web.controller;
import home.nikolabojanic.worldchampionship.model.Game;
import home.nikolabojanic.worldchampionship.model.Team;
import home.nikolabojanic.worldchampionship.service.GameService;
import home.nikolabojanic.worldchampionship.support.GameToGameDto;
import home.nikolabojanic.worldchampionship.web.dto.GameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(value = "api/games", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiGameController {
    @Autowired
    private GameService gameService;
    @Autowired
    private GameToGameDto toDto;
    @GetMapping
    public ResponseEntity<List<GameDto>> getAll(@RequestParam(required = false) Long teamAId,
                                                @RequestParam(required = false) Long teamBId,
                                                @RequestParam(defaultValue = "0") int pageNo,
                                                @RequestParam(defaultValue = "5") int pageSize){
        Page<Game> page = gameService.getAll(teamAId, teamBId, pageNo, pageSize);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
        return new ResponseEntity<>(toDto.convert(page.getContent()), headers, HttpStatus.OK);
    }
    @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<GameDto>getOne(@PathVariable Long id){
        Optional<Game> game = gameService.getOne(id);
        if(!game.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(toDto.convert(game.get()), HttpStatus.OK);
        }
    }
    @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GameDto>add(@Validated @RequestBody GameDto gameDto){
        if(gameDto.getId() != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(toDto.convert(gameService.save(gameDto)), HttpStatus.CREATED);
        }
    }
    @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GameDto>edit(@Validated @RequestBody GameDto gameDto, @PathVariable Long id){
        if(!(id == gameDto.getId())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Game game = gameService.save(gameDto);
        if(game == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(toDto.convert(game), HttpStatus.OK);
        }
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(!gameService.getOne(id).isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            gameService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value = "/teamScore/{id}")
    public ResponseEntity<GameDto> teamScore(@PathVariable Long id, @RequestParam Long teamId){
        Game game = gameService.scoreGoal(id, teamId);
        if(game == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
        return new ResponseEntity<GameDto>(toDto.convert(game), HttpStatus.OK);
        }
    }
}