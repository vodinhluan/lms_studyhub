<template>
    <div class="about-container">
      <section class="about">
        <div class="content">
          <router-link to="/class">Back</router-link>
          <h1>CREATE CLASS</h1>
          <form @submit.prevent="createClass">
            <label for="username">Class Name</label>
            <input type="text" v-model="lop.name" id="classname" placeholder="Enter your classname" required>
            
            <label for="teacher">Teacher (Select a Teacher for Class)</label>
            <select v-model="lop.teacher" id="teacher" required>
              <option disabled selected value="">Select a teacher</option>
              <option v-for="teacher in teachers" :key="teacher.id" :value="teacher">
                {{ teacher.username }}
              </option>
            </select>
            
            <button type="submit">Create Class</button>
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
      lop: {
        name: '',
        teacher: null
      },
      teachers: []
    };
  },
  mounted() {
    this.fetchTeachers();
  },
    methods: {
      async fetchTeachers() {
      try {
        const response = await axios.get('http://localhost:8080/user/teachers');
        this.teachers = response.data;
      } catch (error) {
        console.error('Error fetching teachers:', error);
      }
    },
  
      async createClass() {
        const toast = useToast();
  
        // Validation checks
        // if (!this.validateUserName(this.user.username)) {
        //   toast.error('Username gồm các ký tự viết thường');
        //   return;
        // }
  
        // if (!this.validateEmail(this.user.email)) {
        //   toast.error('Email không hợp lệ');
        //   return;
        // }
  
        // if (!this.validatePassword(this.user.password)) {
        //   toast.error('Password ít nhất có 6 ký tự bao gồm các ký tự đặc biệt');
        //   return;
        // }
  
        // // Check username and email existence
        // const isInValid = await this.validateUsernameAndEmail();
        // if (!isInValid) {
        //   return;
        // }
  
        try {
          const response = await axios.post('http://localhost:8080/class/create', this.lop);
  
          if (response.status === 200 || response.status === 201) {
            toast.success('Tạo Lớp Học Thành Công');
          } else {
            toast.error('Tạo Lớp Học Thất Bại');
          }
        } catch (error) {
          toast.error('Xảy ra lỗi trong quá trình tạo Lớp Học');
        }
      },
      
      // validateUserName(username) {
      //   const re = /^[a-z]+$/;
      //   return re.test(username);
      // },
  
      // validateEmail(email) {
      //   const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
      //   return re.test(email);
      // },
  
      // validatePassword(password) {
      //   const re = /^(?=.*[!@#$%^&*(),.?":{}|<>]).{6,}$/;
      //   return re.test(password);
      // }
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
  