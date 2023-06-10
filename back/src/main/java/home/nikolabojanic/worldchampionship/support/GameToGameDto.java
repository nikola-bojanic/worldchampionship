package home.nikolabojanic.worldchampionship.support;
import home.nikolabojanic.worldchampionship.model.Game;
import home.nikolabojanic.worldchampionship.web.dto.GameDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class GameToGameDto implements Converter<Game, GameDto> {
    @Override
    public GameDto convert(Game game) {
        GameDto dto = new GameDto();
        dto.setId(game.getId());
        dto.setGoalsA(game.getGoalsA());
        dto.setGoalsB(game.getGoalsB());
        dto.setTeamAId(game.getTeamA().getId());
        dto.setTeamBId(game.getTeamB().getId());
        dto.setTeamAName(game.getTeamA().getName());
        dto.setTeamBName(game.getTeamB().getName());
        return dto;
    }
    public List<GameDto> convert(List<Game> games){
        List<GameDto> dtos = new ArrayList<>();
        for(Game game : games){
            dtos.add(convert(game));
        }
        return dtos;
    }
}