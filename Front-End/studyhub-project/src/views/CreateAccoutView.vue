<template>
  <div class="about-container">
    <section class="about">
      <div class="content">
        <router-link to="/account">Back</router-link>
        <h1>CREATE ACCOUNT</h1>
        <form @submit.prevent="createAccount">
          <label for="username">User Name</label>
          <input type="text" v-model="user.username" id="username" placeholder="Enter your username" required>
          
          <label for="password">Password</label>
          <input type="password" v-model="user.password" id="password" placeholder="Enter your password" required>
          
          <label for="email">Email</label>
          <input type="email" v-model="user.email" id="email" placeholder="Enter your email" required>
          
          <label for="fullname">Full Name</label>
          <input type="text" v-model="user.fullName" id="fullname" placeholder="Enter your fullname" required>
          
          <label for="role">Role</label>
          <select v-model="user.role" required>
            <option value="" disabled selected>Select role</option>
            <option value="Admin">Admin</option>
            <option value="Teacher">Teacher</option>
            <option value="Student">Student</option>
          </select>
          
          <button type="submit">Create Account</button>
        </form>
      </div>
    </section>
  </div>
</template>

<script>
import axios from 'axios';
import { useToast } from "vue-toastification";

export default {
  data() {
    return {
      user: {
        username: '',
        password: '',
        email: '',
        fullName: '',
        role: ''
      }
    };
  },
  methods: {
    async createAccount() {
      const toast = useToast();
      try {
        const response = await axios.post('http://localhost:8080/user/create', this.user);
        toast.success('Tạo account thành công!');
        console.log('User created:', response.data);

      } catch (error) {
        toast.error('Tạo account thất bại: ' + error.response.data.message);
        console.error('Error creating user:', error);
      }
    }
  }
};
</script>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  font-family: Arial, sans-serif;
  background-color: #5eb7b3; 
}

.about-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh; 
  padding: 20px; 
}

.about {
  background-color: #ffffff; 
  padding: 40px; 
  border-radius: 10px; 
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
  width: 100%;
  max-width: 800px; 
}

h1 {
  color: #087129; 
  margin-bottom: 20px; 
  text-align: center; 
}

form {
  display: flex;
  flex-direction: column; 
}

label {
  margin-bottom: 10px; 
  color: #555; 
}

input, select {
  width: 100%; 
  padding: 10px; 
  margin-bottom: 20px;
  border: 1px solid #ddd; 
  border-radius: 5px; 
  font-size: 16px; 
}

button {
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

/* Responsive adjustments */
@media (min-width: 1024px) {
  .about {
    min-height: 30vh;
    margin-left: 100px;
  }
}
</style>
