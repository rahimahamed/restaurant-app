<template>
  <header>
    <nav class="navbar navbar-light bg-light">
      <form class="container-fluid">
        <div class="justify-content-start">
          <RouterLink to="/" class="btn btn-outline-success me-2" type="button">
            Menu
          </RouterLink>
        </div>
        <h1>My Restaurant</h1>
        <div class="justify-content-end">
          <i v-if="loggedIn">{{ username }} </i>
          <i v-else>Not Logged In </i>
          <RouterLink
            to="/login"
            class="btn btn-outline-success me-2"
            type="button"
          >
            Login
          </RouterLink>
          <RouterLink
            to="/register"
            class="btn btn-sm btn-outline-secondary"
            type="button"
          >
            Register
          </RouterLink>
        </div>
      </form>
    </nav>
  </header>

  <RouterView />
</template>

<script>
import { RouterLink, RouterView } from "vue-router";
export default {
  computed: {
    username() {
      return this.$store.state.username;
    },
    loggedIn() {
      return this.$store.state.loggedIn;
    },
  },
  mounted() {
    this.username = this.$store.getters.getUsername;
    this.loggedIn = this.$store.getters.getLoggedIn;
  },
};
</script>

<style>
</style>