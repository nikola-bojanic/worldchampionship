package home.nikolabojanic.worldchampionship.web.dto;
public class PlayerDto {
    private Long id;
    private String name;
    private String lastName;
    private int goals;
    private Long teamId;
    public PlayerDto() {
    }
    public PlayerDto(Long id, String name, String lastName, int goals, Long teamId) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.goals = goals;
        this.teamId = teamId;
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
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getGoals() {
        return goals;
    }
    public void setGoals(int goals) {
        this.goals = goals;
    }
    public Long getTeamId() {
        return teamId;
    }
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}