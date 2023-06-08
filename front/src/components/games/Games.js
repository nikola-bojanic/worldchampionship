import React from "react"
import ChampionshipAxios from "../../apis/ChampionshipAxios"
import { Row, Col, Table} from 'react-bootstrap'
class Games extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            games: [],
            teams: []
        }
    }
    componentDidMount(){
        this.getGames()
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
    getGames(){
        ChampionshipAxios.get('/games')
        .then((res) => {
            this.setState({games: res.data})
        })
        .catch((err) => {
            alert('Unable to retrieve data.')
        })
    }
    renderGames(){
        return this.state.games.map((game) => {
            return(
                <tr key = {game.id}>
                    <td>{game.teamAName}</td>
                    <td>{game.teamBName}</td>
                    <td>{game.goalsA}</td>
                    <td>{game.goalsB}</td>
                </tr>
            )
        })
    }
    render(){
        return(
        <Col>
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
export default Games