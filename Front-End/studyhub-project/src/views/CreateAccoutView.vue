<template>
  <div class="about-container">
    <section class="about">
      <div class="content">
        <router-link to="/account">Back</router-link>
        <h1>CREATE ACCOUNT</h1>
        <form id="createAccountForm" method="post">
          <label for="username">User Name</label>
          <input type="text" id="username" placeholder="Enter your username" required>
          
          <label for="password">Password</label>
          <input type="password" id="password" placeholder="Enter your password" required>
          
          <label for="email">Email</label>
          <input type="email" id="email" placeholder="Enter your email" required>
          
          <label for="fullname">Full Name</label>
          <input type="text" id="fullname" placeholder="Enter your fullname" required>
          
          <label for="role">Role</label>
          <select id="role" required>
            <option value="" disabled selected>Select role</option>
            <option value="admin">Admin</option>
            <option value="student">Student</option>
            <option value="teacher">Teacher</option>
          </select>
          
          <button type="submit">Create Account</button>
        </form>
      </div>
    </section>
  </div>
</template>

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
