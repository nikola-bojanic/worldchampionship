import React from "react";
import { withNavigation, withParams } from "../../routeconf";
import ChampionshipAxios from "../../apis/ChampionshipAxios";
import { Form, Button} from "react-bootstrap";
class Goalscorer extends React.Component{
    constructor(props){
        super(props)
        const player = {
            id: -1,
            name: '',
            lastName: '',
            goals: '',
            teamId: 0

        }
        this.state = {
            player: player,
            players: []
        }
    }
    componentDidMount() {
        this.getData();
    }
    async getData() {
        await this.getPlayers()
    }
    async getPlayers() {
        let config = { 
            params: {
            teamId: this.props.params.id
          } 
        }
        try {
          let result = await ChampionshipAxios.get('/players/team', config);
          if (result && result.status === 200) {
            this.setState({
              players: result.data,
            });
          }
        } catch (error) {
          alert("Unable to retrieve data.");
        }
      }
    async scoreGoal(){
        try{
            await ChampionshipAxios.put('/players/goalscorer/' + this.state.player.id, this.state.player)
            this.props.navigate('/games')
        } catch(error){
            alert('An error occurred.')
        }
    }
    valueInputChange(event) {
        let player = this.state.player
        player[event.target.name] = event.target.value;
        this.setState({ player })
      }
     render(){
        return(
            <div>
            <Form>
                <Form.Group>
                <Form.Label>Goalscorer</Form.Label>
                <Form.Control
                onChange={(event) => this.valueInputChange(event)}
                name="id"
                type="number"
                as="select"
                >
                <option value={-1}></option>
                {this.state.players.map((player) => {
                return (
                <option value={player.id} key={player.id}>
                {player.name} {player.lastName}
                </option>
                );
            })}
            </Form.Control>
            </Form.Group>
            <Button variant="primary" onClick={() => this.scoreGoal()}>
                Score a goal
            </Button>
            </Form>
            </div>             
        )
    }
}
export default withNavigation(withParams(Goalscorer));