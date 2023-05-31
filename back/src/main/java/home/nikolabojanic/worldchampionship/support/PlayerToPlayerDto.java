package home.nikolabojanic.worldchampionship.support;
import home.nikolabojanic.worldchampionship.model.Player;
import home.nikolabojanic.worldchampionship.web.dto.PlayerDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class PlayerToPlayerDto implements Converter<Player, PlayerDto> {
    @Override
    public PlayerDto convert(Player player) {
        PlayerDto dto = new PlayerDto();
        dto.setId(player.getId());
        dto.setGoals(player.getGoals());
        dto.setName(player.getName());
        dto.setLastName(player.getLastName());
        dto.setTeamId(player.getTeam().getId());
        return dto;
    }
    public List<PlayerDto> convert(List<Player> players) {
        List<PlayerDto> dtos = new ArrayList<>();
        for(Player player : players){
            dtos.add(convert(player));
        }
        return dtos;
    }
}