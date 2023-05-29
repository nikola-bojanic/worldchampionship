package home.nikolabojanic.worldchampionship.web.dto;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;
public class TeamDto {
    private Long id;
    @NotBlank
    private String name;
    @Length(min = 3, max = 3)
    private String code;
    public TeamDto(Long id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }
    public TeamDto() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
}