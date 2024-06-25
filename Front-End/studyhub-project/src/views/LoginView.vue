<template>
    <div class="login-container">
      <div class="login">
        <h1>LOGIN</h1>
        <form id="loginForm" method="post">
          <label for="username">Username</label>
          <input type="text" id="username" placeholder="Enter your username">
          <label for="password">Password</label>
          <input type="password" id="password" placeholder="Enter your password">
          <button type="submit">Login</button>
          <div class="remember-me">
            <input type="checkbox" id="remember">
            <label for="remember">Remember me</label>
          </div>
          <h3>Click here if you <a>Forgot Password</a></h3>
        </form>     
      </div>
    </div>
  </template>
  
  <style>
  /* General reset for padding and margin */
  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }
  
  body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f9; /* Light background for contrast */
  }
  
  h1 {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    font-size: 36px;
    font-style: inherit;
  }
  
  h3 {
    color: #000000;
  }
  
  .login-container {
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh; /* Full height */
    background-color: #5eb7b3; /* Light background for the whole container */
  }
  
  .login {
    background-color: #ffffff; /* White background for the login box */
    padding: 40px; /* Padding around the login box */
    border-radius: 10px; /* Rounded corners */
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1); /* Light shadow for depth */
    width: 100%;
    max-width: 500px; /* Max width for the login box */
    text-align: center;
  }
  
  h1 {
    margin-bottom: 20px; /* Space below the heading */
    color: #333; /* Darker text color */
  }
  
  label {
    display: block; /* Make labels block elements */
    margin: 10px 0 5px; /* Space around labels */
    text-align: left; /* Left-align labels */
    color: #555; /* Medium text color */
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    font-style: inherit;
  }
  
  input[type="text"], input[type="password"] {
    width: 100%; /* Full width inputs */
    padding: 10px; /* Padding inside the inputs */
    margin-bottom: 20px; /* Space below the inputs */
    border: 1px solid #ddd; /* Light border */
    border-radius: 5px; /* Rounded corners for inputs */
    font-size: 16px; /* Larger font size for inputs */
  }
  
  button {
    width: 100%; /* Full width button */
    padding: 10px; /* Padding inside the button */
    background-color: #007bff; /* Blue background color */
    color: white; /* White text color */
    border: none; /* No border */
    border-radius: 5px; /* Rounded corners for the button */
    font-size: 16px; /* Larger font size for the button */
    cursor: pointer; /* Pointer cursor on hover */
  }
  
  button:hover {
    background-color: #0056b3; /* Darker blue on hover */
  }
  
  .remember-me {
    display: flex; /* Use flexbox to align items horizontally */
    align-items: center; /* Center vertically */
    margin-bottom: 20px; /* Space below the checkbox */
  }
  
  .remember-me input[type="checkbox"] {
    margin-right: 10px; /* Space between checkbox and label */
    margin-top: 15px;
  }
  
  .remember-me label {
    margin-bottom: 0; /* Remove bottom margin of label */
    color: #555; /* Medium text color for the label */
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  }
  
  /* Responsive adjustments */
  @media (min-width: 1024px) {
    .login {
      min-height: 30vh;
      margin-left: 100px;
    }
  }
  </style>
  