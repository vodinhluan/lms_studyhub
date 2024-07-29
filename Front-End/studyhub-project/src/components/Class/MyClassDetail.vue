<template>
    <div class="class-detail-container">
      <section class="detail">
        <router-link to="/class">Back</router-link>
        <div v-if="myClass">
          <br>
          <label>Class Name:</label>
          <h1>{{ myClass.name }}</h1>
          <br>
          <label>Teacher: </label>
          <span>{{ myClass.teacher.username }}</span>
          <br>
          <label>Code:    </label>
          <span>{{ myClass.code }}</span>
          <br>
          <button @click="updateClass">Giao Bài</button>
          <br>
          <button @click="updateClass">Kiểm tra</button>

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
        myClass: null
      };
    },
    mounted() {
      const classId = this.$route.params.id; 
      this.fetchClassDetail(classId);
    },
    methods: {
      async fetchClassDetail(classId) {
        try {
          const response = await axios.get(`http://localhost:8080/class/detail/${classId}`);
          this.myClass = response.data;
        } catch (error) {
          console.error('Error fetching class detail:', error);
        }
      },
      async updateClass() {
        const toast = useToast();
        try {
          const response = await axios.put(`http://localhost:8080/class/update/${this.myClass.id}`, this.myClass);
          if (response.status === 200) {
            toast.success('Cập nhật thông tin lớp học thành công');
          } else {
            toast.error('Cập nhật thông tin lớp học thất bại');
          }
        } catch (error) {
          toast.error('Xảy ra lỗi trong quá trình cập nhật lớp học');
          console.error('Error updating class:', error);
        }
      }
    }
  };
  </script>
  
  <style scoped>
  .class-detail-container {
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
  