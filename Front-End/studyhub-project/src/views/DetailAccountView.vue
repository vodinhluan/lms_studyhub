<template>
    <div class="about-container">
      <section class="about">
        <div class="content">
          <router-link to="/account">Back</router-link>
          <h1>DETAIL ACCOUNT</h1>
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
      async validateUsernameAndEmail() {
        const toast = useToast();
        try {
          const usernameResponse = await axios.get(`http://localhost:8080/user/username/exists/${encodeURIComponent(this.user.username)}`);
          const usernameExists = usernameResponse.data;
  
          if (usernameExists) {
            toast.error('Username này đã tồn tại');
          }
  
          const emailResponse = await axios.get(`http://localhost:8080/user/email/exists/${encodeURIComponent(this.user.email)}`);
          const emailExists = emailResponse.data;
  
          if (emailExists) {
            toast.error('Email này đã tồn tại');
          }
  
          return !usernameExists && !emailExists;
  
        } catch (error) {
          console.error('Error checking existence:', error);
          toast.error('Lỗi kiểm tra sự tồn tại');
          return false;
        }
      },
  
      async createAccount() {
        const toast = useToast();
  
        // Validation checks
        if (!this.validateUserName(this.user.username)) {
          toast.error('Username gồm các ký tự viết thường');
          return;
        }
  
        if (!this.validateEmail(this.user.email)) {
          toast.error('Email không hợp lệ');
          return;
        }
  
        if (!this.validatePassword(this.user.password)) {
          toast.error('Password ít nhất có 6 ký tự bao gồm các ký tự đặc biệt');
          return;
        }
  
        // Check username and email existence
        const isInValid = await this.validateUsernameAndEmail();
        if (!isInValid) {
          return;
        }
  
        try {
          const response = await axios.post('http://localhost:8080/user/create', this.user);
  
          if (response.status === 200 || response.status === 201) {
            toast.success('Tạo Tài Khoản Thành Công');
          } else {
            toast.error('Tạo Tài Khoản Thất Bại');
          }
        } catch (error) {
          toast.error('Xảy ra lỗi trong quá trình tạo tài khoản');
        }
      },
      
      validateUserName(username) {
        const re = /^[a-z]+$/;
        return re.test(username);
      },
  
      validateEmail(email) {
        const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(email);
      },
  
      validatePassword(password) {
        const re = /^(?=.*[!@#$%^&*(),.?":{}|<>]).{6,}$/;
        return re.test(password);
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
  