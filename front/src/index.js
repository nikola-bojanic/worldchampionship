import React from "react";
import { createRoot } from 'react-dom/client';
import {Route, Link, HashRouter as Router, Routes, Navigate } from "react-router-dom";
import Home from "./components/Home";
import NotFound from "./components/NotFound";
import { Container, Navbar, Nav, Button } from "react-bootstrap";
import Login from "./components/login/Login";
import { logout } from "./services/auth";
import Games from "./components/games/Games";
import AddGame from "./components/games/AddGame";
import Goalscorer from "./components/games/Goalscorer";
class App extends React.Component {
  render() {
    return (
      <div>
        <Router>
          <Navbar bg="dark" variant="dark" expand>
            <Navbar.Brand as={Link} to="/">
              World Championship
            </Navbar.Brand>
            <Nav className="mr-auto">
              <Nav.Link as={Link} to="/games">
                Games
              </Nav.Link>
            </Nav>

            {window.localStorage['jwt'] ? 
                <Button onClick = {()=>logout()}>Log out</Button> :
                <Nav.Link as={Link} to="/login">Log in</Nav.Link>
            }
          </Navbar>
          <Container style={{marginTop:25}}>
            <Routes>
              <Route path="/" element={<Home/>} />
              <Route path="/games" element={<Games/>} />
              <Route path="/addGame" element={<AddGame/>} />
              <Route path="/login" element={<Login/>}/>
              <Route path="/goalscorer/:id" element ={<Goalscorer/>}/>
              <Route path="*" element={<NotFound/>} />
            </Routes>
          </Container>
        </Router>
      </div>
    );
  }
}
const rootElement = document.getElementById('root');
const root = createRoot(rootElement);
root.render(
    <App/>,
);