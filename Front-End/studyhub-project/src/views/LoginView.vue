<!-- src/views/LoginView.vue -->
<template>
  <div class="login-container">
    <div class="login">
      <h1>LOGIN</h1>
      <form id="loginForm" @submit.prevent="handleLogin">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="username" placeholder="Enter your username">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="password" placeholder="Enter your password">
        <button type="submit">Login</button>
        <div class="remember-me">
          <input type="checkbox" id="remember" v-model="remember">
          <label for="remember">Remember me</label>
        </div>
        <h3>Click here if you <a href="#">Forgot Password</a></h3>
      </form>     
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      password: '',
      remember: false,
    };
  },
  methods: {
    handleLogin() {
      // Redirect to the home page after login
      this.$router.push('/home');
    }
  }
};
</script>

<style>
/* Your existing styles */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  font-family: Arial, sans-serif;
  background-color: #f4f4f9;
}

.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-color: #5eb7b3;
}

.login {
  background-color: #ffffff;
  padding: 40px;
  border-radius: 10px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
  width: 100%;
  max-width: 500px;
  text-align: center;
}

h1 {
  margin-bottom: 20px;
  color: #333;
}

label {
  display: block;
  margin: 10px 0 5px;
  text-align: left;
  color: #555;
}

input[type="text"], input[type="password"] {
  width: 100%;
  padding: 10px;
  margin-bottom: 20px;
  border: 1px solid #ddd;
  border-radius: 5px;
  font-size: 16px;
}

button {
  width: 100%;
  padding: 10px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 5px;
  font-size: 16px;
  cursor: pointer;
}

button:hover {
  background-color: #0056b3;
}

.remember-me {
  display: flex;
  align-items: center;
  margin-bottom: 20px;
}

.remember-me input[type="checkbox"] {
  margin-right: 10px;
}

.remember-me label {
  margin-bottom: 0;
  color: #555;
}

@media (min-width: 1024px) {
  .login {
    min-height: 30vh;
    margin-left: 100px;
  }
}
</style>
