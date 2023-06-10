import React from "react"
import ChampionshipAxios from "../../apis/ChampionshipAxios"
import { Form, Row, Col, Table, Button} from 'react-bootstrap'
import { withNavigation, withParams } from '../../routeconf'
class Games extends React.Component{
    constructor(props){
        super(props)
        const search = {
        teamAId: '',
        teamBId: ''
        }
        this.state = {
            search: search,
            games: [],
            teams: [],
            pageNo: 0, 
            totalPages: 0
        }
    }
    componentDidMount(){
        this.getGames(0);
        this.getTeams()
    }
    getTeams(){
        ChampionshipAxios.get('/teams')
        .then((res) => {
            this.setState({teams: res.data})
        })
        .catch((err) => {
            alert('Unable to retrieve data.')
        }) 
    }
    getGames(newPageNo){
        let config = {
            params: {
                teamAId: this.state.search.teamAId,
                teamBId: this.state.search.teamBId,
                pageNo: newPageNo
            }
        }
        ChampionshipAxios.get('/games', config)
        .then((res) => {
            this.setState({
                games: res.data,
                pageNo: newPageNo,
                totalPages: res.headers['total-pages']
            })
        })
        .catch((err) => {
            alert('Unable to retrieve data.')
        })
    }
    delete(id) {
        ChampionshipAxios.delete('/games/' + id)
            .then(res => {
                console.log(res);
                alert('Game was deleted successfully!');
                this.deleteFromState(id); 
            })
            .catch(error => {
                console.log(error);
                alert('Error occured please try again!');
            });
    }
    deleteFromState(id) {
        var games = this.state.games;
        games.forEach((element, index) => {
            if (element.id === id) {
                games.splice(index, 1);
                this.setState({ games: games });
            }
        });
    }
    addGame(){
        this.props.navigate('/addGame')
    }
    onInputChange(event) {
        const name = event.target.name;
        const value = event.target.value
        let search = this.state.search;
        search[name] = value;
        this.setState({ search })
    }
    goalscorer(teamId){
        this.props.navigate('/goalscorer/' + teamId)
    }
    homeGoal(game){
        let gameDto = game
        gameDto.goalsA = game.goalsA + 1
        ChampionshipAxios.put('/games/' + game.id, gameDto)
        .then((ress) => {
            this.goalscorer(gameDto.teamAId)
        })
        .catch((err) => {
            alert('An error occurred')
        })
    }
    awayGoal(game){
        let gameDto = game
        gameDto.goalsB = game.goalsB + 1
        ChampionshipAxios.put('/games/' + game.id, gameDto)
        .then((ress) => {
            this.goalscorer(gameDto.teamBId)
        })
        .catch((err) => {
            alert('An error occurred')
        })
    }
    renderSearchForm() {
            return(
                <div>
                   <Form>
                  <Form.Group>
                    <Form.Label>Home team</Form.Label>
                    <Form.Control
                      onChange={(e) => this.onInputChange(e)}
                      name="teamAId"
                      as="select"
                    >
                      <option></option>
                      {this.state.teams.map((team) => {
                        return (
                          <option value={team.id} key={team.id}>
                            {team.code}
                          </option>
                        );
                      })}
                    </Form.Control>
                  </Form.Group>
                  <Form.Group>
                    <Form.Label>Away team</Form.Label>
                    <Form.Control
                      onChange={(e) => this.onInputChange(e)}
                      name="teamBId"
                      as="select"
                    >
                      <option></option>
                      {this.state.teams.map((team) => {
                        return (
                          <option value={team.id} key={team.id}>
                            {team.code}
                          </option>
                        );
                      })}
                    </Form.Control>
                  </Form.Group>                 
                <Button className="mt-3" onClick={() => this.getGames(0)}>Search</Button>
                </Form>    
              </div>
            );
        }
    renderGames(){
        return this.state.games.map((game) => {
            return(
                <tr key = {game.id}>
                    <td>{game.teamAName}</td>
                    <td>{game.teamBName}</td>
                    <td>{game.goalsA}</td>
                    <td>{game.goalsB}</td>
                    {window.localStorage['role'] == 'ROLE_ADMIN' ?
                        <td><Button variant="danger" onClick={() => this.delete(game.id)}>Delete</Button></td> : null}
                    <td><Button variant="success" onClick={() => this.homeGoal(game)}>Home scores!</Button></td>
                    <td><Button variant="info" onClick={() => this.awayGoal(game)}>Away scores!</Button></td>
                </tr>
            )
        })
    }
    render(){
        return(
        <Col>
            <Row>
                {this.renderSearchForm()}
            </Row>
            <br/>
            <Row>
                {window.localStorage['role']=='ROLE_ADMIN'? 
                <Col>
                    <Button onClick={() => this.addGame() }>Add game</Button>
                </Col> : null}
                <Col style={{display:'flex', justifyContent:'right'}}>
                    <Button disabled={this.state.pageNo===0} 
                      onClick={() => this.getGames (this.state.pageNo - 1)}
                      className="mr-3">Prev</Button>
                    <Button disabled = {this.state.pageNo == this.state.totalPages - 1} 
                    onClick={() => this.getGames(this.state.pageNo + 1)}>Next</Button>
                    </Col>
            </Row>
        <Row><Col>
        <Table style = {{marginTop: 5}}>
        <thead>
            <tr>
                <th>
                    Home team
                </th>
                <th>
                    Away team
                </th>
                <th>
                    Home goals
                </th>
                <th>
                    Away goals
                </th>
            </tr>
        </thead>
        <tbody>
            {this.renderGames()}
        </tbody>
        </Table>
        </Col></Row>
        </Col>
        )
    }
}
export default withNavigation(withParams(Games))