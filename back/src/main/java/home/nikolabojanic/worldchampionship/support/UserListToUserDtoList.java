package home.nikolabojanic.worldchampionship.support;
import home.nikolabojanic.worldchampionship.model.User;
import home.nikolabojanic.worldchampionship.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
public class UserListToUserDtoList implements Converter<List<User>, List<UserDto>>{
	@Autowired
	private UserToUserDto toDto;
	@Override
	public List<UserDto> convert(List<User> source) {
		List<UserDto> target = new ArrayList<>();
		for(User u : source) {
			UserDto dto = toDto.convert(u);
			target.add(dto);
		}
		return target;
	}
}