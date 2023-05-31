package home.nikolabojanic.worldchampionship.support;
import home.nikolabojanic.worldchampionship.model.Game;
import home.nikolabojanic.worldchampionship.service.GameService;
import home.nikolabojanic.worldchampionship.service.TeamService;
import home.nikolabojanic.worldchampionship.web.dto.GameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.util.Optional;
@Component
public class GameDtoToGame implements Converter<GameDto, Game> {
    @Autowired
    private GameService gameService;
    @Autowired
    private TeamService teamService;
    @Override
    public Game convert(GameDto gameDto) {
        Long id = gameDto.getId();
        Game game = null;
        if(id == null){
            game = new Game();
        }else{
            Optional<Game> existing = gameService.getOne(id);
            if(existing.isPresent()){
                game = existing.get();
            }
        }
        if(gameDto.getTeamAId() == gameDto.getTeamBId()){
            throw new IllegalArgumentException();
        }
        if(game != null){
            game.setId(gameDto.getId());
            game.setTeamA(teamService.getOne(gameDto.getTeamAId()));
            game.setTeamB(teamService.getOne(gameDto.getTeamBId()));
            game.setGoalsA(gameDto.getGoalsA());
            game.setGoalsB(gameDto.getGoalsB());
            return game;
        }else{
            return null;
        }
    }
}