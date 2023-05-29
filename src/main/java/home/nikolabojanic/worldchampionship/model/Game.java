package home.nikolabojanic.worldchampionship.model;
import javax.persistence.*;
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "team_a_id")
    private Team teamA;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "team_b_id")
    private Team teamB;
    @Column(name = "goals_a")
    private int goalsA;
    @Column(name = "goals_b")
    private int goalsB;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Team getTeamA() {
        return teamA;
    }
    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }
    public Team getTeamB() {
        return teamB;
    }
    public void setTeamB(Team teamB) {
        this.teamB = teamB;
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