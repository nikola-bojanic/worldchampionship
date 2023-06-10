import React from "react"
import { Button, Form } from "react-bootstrap"
import { withNavigation } from "../../routeconf"
import ChampionshipAxios from "../../apis/ChampionshipAxios"
class AddGame extends React.Component{
    constructor(props){
        super(props)
        const game = {
            teamAId: '',
            teamBId: ''
        }
        this.state = {
            teams: [],
            game : game
        }
        this.create = this.create.bind(this)
    }
    componentDidMount(){
        this.getTeams()
    }
    onChange(e){
        let name = e.target.name
        let value = e.target.value
        let game = this.state.game
        game[name] = value
        this.setState(game)
    }
    getTeams(){
        ChampionshipAxios.get('/teams')
        .then((res) => {
            this.setState({teams: res.data})
        })
        .catch((err) => {
            alert('Unable to retrieve data')
        })
    }
    create(){
        ChampionshipAxios.post('/games', this.state.game)
        .then((res) => {
            this.props.navigate('/games')
        })
        .catch((err) => {
            alert('An error occurred')
        })
    }
    render(){
        return(
            <div>
                <Form id='add'>
              <Form.Group>
                <Form.Label>Home team</Form.Label>
                <Form.Control
                  onChange={(e) => this.onChange(e)}
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
                  onChange={(e) => this.onChange(e)}
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
              <Button hidden={this.state.game.teamAId == this.state.game.teamBId}statvariant="primary" onClick={this.create}>
                Add game
              </Button>
            </Form>
            </div>
        )
    }
}
export default withNavigation(AddGame)