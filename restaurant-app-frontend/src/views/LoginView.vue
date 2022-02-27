<template>
  <div class="dropdown-menu">
    <form class="px-4 py-3">
      <div class="mb-3">
        <label for="exampleDropdownFormEmail1" class="form-label"
          >Username</label
        >
        <input
          type="email"
          class="form-control"
          id="exampleDropdownFormEmail1"
          placeholder="email@example.com"
          v-model="loginCreds.username"
        />
      </div>
      <div class="mb-3">
        <label for="exampleDropdownFormPassword1" class="form-label"
          >Password</label
        >
        <input
          type="password"
          class="form-control"
          id="exampleDropdownFormPassword1"
          placeholder="Password"
          v-model="loginCreds.password"
        />
      </div>
      <div class="mb-3">
        <div class="form-check">
          <input type="checkbox" class="form-check-input" id="dropdownCheck" />
          <label class="form-check-label" for="dropdownCheck">
            Remember me
          </label>
        </div>
      </div>
      <button type="submit" class="btn btn-primary" @click="login">Sign in</button>
    </form>
    <div class="dropdown-divider"></div>
    <a class="dropdown-item" href="#">New around here? Sign up</a>
    <a class="dropdown-item" href="#">Forgot password?</a>
  </div>
</template>

<script>
import LoginCredsService from '../services/LoginCredsService.js'
export default {
    name: "register-view",
    data() {
        return{
            loginCreds: {
                username: "",
                password: "",
            },
            loggedIn: false
        }
    },

    methods: {
        login(){
            LoginCredsService.getLoginCreds(this.loginCreds.username, this.loginCreds.password).then((response) => {
                console.log(response);
                this.$store.commit('setUsername',response.data.username);
                this.$router.push('/');
            })
            .catch((error) => {
                alert(error);
            });
        }
    }
};
</script>

<style>
.dropdown-menu{
    display:block;
    top: 10%;
}
</style>