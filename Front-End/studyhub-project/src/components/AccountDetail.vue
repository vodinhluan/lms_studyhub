<template>
    <div class="user-detail-container">
      <section class="detail">
        <router-link to="/account">Back</router-link>
        <h1>CHI TIẾT USER</h1>
        <div v-if="user">
          <label>ID:</label>
          <span>{{ user.id }}</span>
          <br>
          <label>Username:</label>
          <input v-model="user.username" type="text">
          <br>
          <label>Password:</label>
          <input v-model="user.password" type="text">
          <br>
          <label>Email:</label>
          <input v-model="user.email" type="email">
          <br>
          <label>Full Name:</label>
          <input v-model="user.fullName" type="text">
          <br>
          <label>Role:</label>
          <select v-model="user.role" required>
            <option value="" disabled selected>Select role</option>
            <option value="Admin">Admin</option>
            <option value="Teacher">Teacher</option>
            <option value="Student">Student</option>
          </select>          
          <br>
          <button @click="updateUser">Sửa</button>
        </div>
        <div v-else>
          <p>Loading...</p>
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
        user: null
      };
    },
    mounted() {
      const userId = this.$route.params.id; 
      this.fetchUserDetail(userId);
    },
    methods: {
      async fetchUserDetail(userId) {
        try {
          const response = await axios.get(`http://localhost:8080/user/detail/${userId}`);
          this.user = response.data;
        } catch (error) {
          console.error('Error fetching user detail132:', error);
        }
      },
      async updateUser() {
        const toast = useToast();
        try {
          const response = await axios.put(`http://localhost:8080/user/update/${this.user.id}`, this.user);
          if (response.status === 200) {
            toast.success('Cập nhật thông tin người dùng thành công');
          } else {
            toast.error('Cập nhật thông tin người dùng thất bại');
          }
        } catch (error) {
          toast.error('Xảy ra lỗi trong quá trình cập nhật người dùng');
          console.error('Error updating user:', error);
        }
      }
    }
  };
  </script>
  
  

<style scoped>


.user-detail-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh; 
  padding: 20px;
}

.detail {
  background-color: #ffffff; 
  padding: 40px; 
  border-radius: 10px; 
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.1); 
  width: 100%;
  max-width: 800px; 
}


td {
  color: black;
}

h1, h2, h3, span {
  color: #087129; 
  margin-bottom: 20px; 
}
th, td {
  padding: 12px; 
  border: 1px solid #ddd; 
  text-align: left; 
}

th {
  background-color: #f4f4f4;
  color: #087129; 
}

tbody tr:nth-child(odd) {
  background-color: #f9f9f9; 
}

@media (min-width: 1024px) {
  .about {
    min-height: 30vh;
    margin-left: 100px;
  }
}

</style>
