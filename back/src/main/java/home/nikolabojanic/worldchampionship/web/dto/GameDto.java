package home.nikolabojanic.worldchampionship.web.dto;
public class GameDto {
    private Long id;
    private Long teamAId;
    private Long teamBId;
    private String teamAName;
    private String teamBName;
    private int goalsA;
    private int goalsB;
    public GameDto() {
    }
    public GameDto(Long id, Long teamAId, Long teamBId, String teamAName, String teamBName, int goalsA, int goalsB) {
        this.id = id;
        this.teamAId = teamAId;
        this.teamBId = teamBId;
        this.teamAName = teamAName;
        this.teamBName = teamBName;
        this.goalsA = goalsA;
        this.goalsB = goalsB;
    }
    public String getTeamAName() {
        return teamAName;
    }
    public void setTeamAName(String teamAName) {
        this.teamAName = teamAName;
    }
    public String getTeamBName() {
        return teamBName;
    }
    public void setTeamBName(String teamBName) {
        this.teamBName = teamBName;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getTeamAId() {
        return teamAId;
    }
    public void setTeamAId(Long teamAId) {
        this.teamAId = teamAId;
    }
    public Long getTeamBId() {
        return teamBId;
    }
    public void setTeamBId(Long teamBId) {
        this.teamBId = teamBId;
    }
    public int getGoalsA() {
        return goalsA;
    }
    public void setGoalsA(int goalsA) {
        this.goalsA = goalsA;
    }
    public int getGoalsB() {
        return goalsB;
    }
    public void setGoalsB(int goalsB) {
        this.goalsB = goalsB;
    }
}