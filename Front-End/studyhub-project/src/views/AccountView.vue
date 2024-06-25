<template>
  <div class="about-container">
    <section class="about">
      <div class="content">
        <h1>About Test User</h1>
        <div>
          <h2>List User</h2>
          <!-- Thay đổi từ danh sách thành bảng -->
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="todo in todos" :key="todo.id">
                <td>{{ todo.id }}</td>
                <td>{{ todo.name }}</td>
                <td>{{ todo.email }}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      todos: []
    };
  },
  mounted() {
    this.fetchTodos();
  },
  methods: {
    fetchTodos() {
      axios.get('http://localhost:8080/user/get-all')
        .then(response => {
          this.todos = response.data;
        })
        .catch(error => {
          console.error('Error fetching todos:', error);
        });
    }
  }
};
</script>

<style>
/* General reset for padding and margin */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

body {
  font-family: Arial, sans-serif;
  background-color: #5eb7b3; /* Light background for the whole container */
}

.about-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh; /* Full height */
  padding: 20px; /* Padding around the content */
}

.about {
  background-color: #ffffff; /* White background for the about section */
  padding: 40px; /* Padding around the about content */
  border-radius: 10px; /* Rounded corners */
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.1); /* Light shadow for depth */
  width: 100%;
  max-width: 800px; /* Max width for the about section */
}

/* Styling for headings */
h1, h2 {
  color: #087129; /* Darker text color */
  margin-bottom: 20px; /* Space below headings */
}

/* Table Styles */
table {
  width: 100%;
  border-collapse: collapse;
  margin-bottom: 20px; /* Space below the table */
}

th, td {
  padding: 12px; /* Padding for table cells */
  border: 1px solid #ddd; /* Light border around cells */
  text-align: left; /* Align text to the left */
}

th {
  background-color: #f4f4f4; /* Light grey background for header cells */
  color: #087129; /* Dark text color for headers */
}

tbody tr:nth-child(odd) {
  background-color: #f9f9f9; /* Light grey background for odd rows */
}

/* Media query for larger screens */
@media (min-width: 1024px) {
  .about {
    min-height: 30vh;
    margin-left: 100px;
  }
}
</style>
