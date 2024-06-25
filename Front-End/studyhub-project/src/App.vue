<template>
  <div id="app">
    <nav>
      <ul>
        <li><router-link to="/">Home</router-link></li>
        <li><router-link to="/account">Account</router-link></li>
        <li><router-link to="/login">Login</router-link></li>
        <li><router-link to="/test">Test</router-link></li>

      </ul>
    </nav>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'App',
};
</script>

<style>
/* Reset default margin and padding */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

/* Style for the app container */
#app {
  padding: 5px 5px; /* Adjust the top padding to reduce the gap */
}

/* Ensure the nav spans full width and its contents are centered */
nav {
  width: 100%; /* Full width */
  background-color: #ffffff; /* Optional: background color for the nav */
  padding: 12px 0; /* Optional: padding for the nav */
  box-shadow: 0 0 10px rgba(2, 123, 66, 0.836); /* Optional: shadow for the nav */
  display: flex; /* Flexbox to align items */
  justify-content: center; /* Center the nav contents horizontally */
  align-items: center; /* Center vertically */
}

/* Ensure the ul element is centered */
nav ul {
  display: flex; /* Ensure ul is a flex container */
  justify-content: center; /* Center the ul contents horizontally */
  list-style-type: none;
  padding: 0;
  margin: 0; /* Remove default margin */
  width: 100%;
}

/* Style for the li elements */
nav li {
  margin-right: 20px; /* Space between the items */
}

nav li:last-child {
  margin-right: 0; /* Remove margin on the last item */
}

/* Style for the anchor elements */
nav a {
  text-decoration: none;
  color: #075c44;
}

nav a:hover {
  text-decoration: underline;
}
</style>
