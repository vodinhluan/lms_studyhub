<template>
  <div class="about-container">
    <section class="about">
      <div class="content">
        <h1>CLASS</h1>
        <div>
          <h2>List all class</h2>
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="todo in todos" :key="todo.id">
                <td>{{ todo.id }}</td>
                <td>{{ todo.name }}</td>
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

h1, h2 {
  color: #087129; 
  margin-bottom: 20px; 
}

table {
  width: 100%;
  border-collapse: collapse;
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
