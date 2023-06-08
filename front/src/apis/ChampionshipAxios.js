import axios from 'axios';
import { logout } from '../services/auth';
import jwt_decode from "jwt-decode";
var ChampionshipAxios = axios.create({
  baseURL: 'http://localhost:8080/api',
});
ChampionshipAxios.interceptors.request.use(
  function success(config){
    const jwt = window.localStorage['jwt'];
    if(jwt){
      const decoded = jwt_decode(jwt)
      console.log(Date.now())
      if(decoded.exp_date<Date.now()){
        alert("JWT has expired")
        logout()
        return false
      }
      config.headers['Authorization'] = 'Bearer ' + jwt;
    }
    return config;
  }
);
ChampionshipAxios.interceptors.response.use(
  function success(response){
      return response;
  },
  function failure(error){
    let jwt = window.localStorage['jwt'];
    if(jwt){
      if(error.response && error.response.status == 403){
        logout();
      }
    }
    throw error;
  }
);
export default ChampionshipAxios;