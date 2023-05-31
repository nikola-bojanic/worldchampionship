package home.nikolabojanic.worldchampionship.web.dto;
public class GameDto {
    private Long id;
    private Long teamAId;
    private Long teamBId;
    private int goalsA;
    private int goalsB;
    public GameDto() {
    }
    public GameDto(Long id, Long teamAId, Long teamBId, int goalsA, int goalsB) {
        this.id = id;
        this.teamAId = teamAId;
        this.teamBId = teamBId;
        this.goalsA = goalsA;
        this.goalsB = goalsB;
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