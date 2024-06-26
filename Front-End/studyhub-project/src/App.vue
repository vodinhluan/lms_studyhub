<!-- src/App.vue -->
<template>
  <div id="app">
    <!-- Conditionally render the navigation menu based on the current route -->
    <nav v-if="showNav">
      <ul>
        <li><router-link to="/home">Home</router-link></li>
        <li><router-link to="/account">Account</router-link></li>
        <li><router-link to="/test">Test</router-link></li>
        <li><a href="#" @click.prevent="handleLogout">Logout</a></li>
      </ul>
    </nav>
    <router-view></router-view>
  </div>
</template>

<script>
import { computed } from 'vue';
import { useRoute, useRouter } from 'vue-router';

export default {
  name: 'App',
  setup() {
    const route = useRoute();
    const router = useRouter();
    
    const showNav = computed(() => route.meta.showNav);

    const handleLogout = () => {
      alert('Bạn có chắc muốn đăng xuất khỏi tài khoản?');
      router.push('/'); // Navigate to the login view
    };

    return { showNav, handleLogout };
  }
};
</script>

<style>
/* Your existing styles */
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

#app {
  padding: 5px 5px;
}

nav {
  width: 100%;
  background-color: #ffffff;
  padding: 12px 0;
  box-shadow: 0 0 10px rgba(2, 123, 66, 0.836);
  display: flex;
  justify-content: center;
  align-items: center;
}

nav ul {
  display: flex;
  justify-content: center;
  list-style-type: none;
  padding: 0;
  margin: 0;
  width: 100%;
}

nav li {
  margin-right: 20px;
}

nav li:last-child {
  margin-right: 0;
}

nav a {
  text-decoration: none;
  color: #075c44;
}

nav a:hover {
  text-decoration: underline;
}
</style>
