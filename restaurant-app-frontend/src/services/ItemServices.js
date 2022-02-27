import axios from 'axios'

class ItemServices{
    getItems(){
        return axios.get('http://localhost:8080/item/all');
    }
}

export default new ItemServices()