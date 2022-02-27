import axios from 'axios'

const restaurant_api_url = 'http://localhost:8080'

class LoginCredsService{
    addLoginCreds(loginCreds){
        return axios.post('http://localhost:8080/loginCreds/add',loginCreds);
    }

    getLoginCreds(username, password){
        return axios.get(`http://localhost:8080/loginCreds/find/${username}`,{params:{password}});
    }
}

export default new LoginCredsService()