import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { createStore } from 'vuex'

const app = createApp(App)

app.use(router)

const store = createStore({
    state () {
      return {
        username: '',
        loggedIn: false
      }
    },
    getters: {
        getUsername: state => state.username,
        getLoggedIn: state => state.loggedIn
    },
    mutations: {
        setUsername(state, payload){
            state.username = payload;
            state.loggedIn = true;
            console.log(state.loggedIn);
        }
    }
})

app.use(store)

app.mount('#app')
