<template>
  <div id="app">
    <nav v-if="showNav">
      <ul>
        <li><router-link to="/home">Home</router-link></li>
        <li><router-link to="/account">Account</router-link></li>
        <li><router-link to="/class">Assignment</router-link></li>
        <li><router-link to="/myclass">My Class</router-link></li>
        <li><a href="#" @click.prevent="confirmLogout">Logout</a></li>
        <li v-if="userInfo.fullName">
          <span>Hello, {{ userInfo.fullName }} ({{ userInfo.role }})</span>
        </li>
      </ul>
    </nav>
    <router-view></router-view>
  </div>
</template>

<script>
import { computed, ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import Swal from 'sweetalert2';

export default {
  name: 'App',
  setup() {
    const route = useRoute();
    const router = useRouter();

    const showNav = computed(() => route.meta.showNav);

    const userInfo = ref({
      fullName: localStorage.getItem('fullName'),
      role: localStorage.getItem('role')
    });

    const updateUserInfo = () => {
      userInfo.value.fullName = localStorage.getItem('fullName');
      userInfo.value.role = localStorage.getItem('role');
    };

    const confirmLogout = () => {
      Swal.fire({
        title: 'Bạn có chắc chắn muốn đăng xuất?',
        text: 'Bạn sẽ bị đăng xuất khỏi tài khoản!',
        icon: 'warning',
        showCancelButton: false,
        confirmButtonColor: '#3085d6',
        confirmButtonText: 'Đăng xuất',
      }).then((result) => {
        if (result.isConfirmed) {
          localStorage.removeItem('token'); 
          localStorage.removeItem('fullName');
          localStorage.removeItem('role');
          updateUserInfo(); // Update user info on logout
          router.push('/'); 
        }
      });
    };

    // Initialize user info
    updateUserInfo();

    return { showNav, userInfo, confirmLogout };
  }
};
</script>

<style>
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

nav span {
  color: #075c44;
  font-weight: bold;
}
</style>
