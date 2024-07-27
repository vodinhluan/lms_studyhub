<template>
  <div class="about-container">
    <section class="about">
      <div class="content">
        <h1>LIST USER</h1>
        <div>
          <router-link to="/createaccount">CREATE</router-link>
          <h2>List User</h2>
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Email</th>
                <th>Role</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="user in users" :key="user.id">
                <td>{{ user.id }}</td>
                <td>{{ user.username }}</td>
                <td>{{ user.email }}</td>
                <td>{{ user.role }}</td>
                <td>
                  <button class="detail-button">
                    <router-link :to="`/detail/${user.id}`">Detail</router-link>
                  </button>
                  <button class="delete-button" @click="confirmDelete(user.id)">
                    Delete
                  </button>
                </td>
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
import { useToast } from "vue-toastification";
import Swal from 'sweetalert2';


export default {
  data() {
    return {
      users: []
    };
  },
  mounted() {
    this.fetchUsers();
  },
  methods: {
    fetchUsers() {
      axios.get('http://localhost:8080/user/get-all')
        .then(response => {
          this.users = response.data;
        })
        .catch(error => {
          console.error('Error fetching users:', error);
        });
    },
    
    confirmDelete(userId) {
      Swal.fire({
        title: 'Bạn có chắc chắn muốn xóa?',
        text: "Bạn sẽ không thể hoàn tác điều này!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Xóa!',
        cancelButtonText: 'Hủy'
      }).then((result) => {
        if (result.isConfirmed) {
          this.deleteUser(userId);
        }
      });
    },

    async deleteUser(userId) {
      const toast = useToast(); 
      console.log("User ID = ", userId);
      toast.apply

      try {
        const response = await axios.delete(`http://localhost:8080/user/delete/${userId}`);
        if (response.status === 204) {
          toast.success('Xóa user thành công'); 
          this.fetchUsers(); 
        } else {
          toast.error('Xóa user thất bại');
        }
      } catch (error) {
        toast.error('Xảy ra lỗi trong quá trình xóa user'); 
        console.error("Error deleting user:", error); 
      }
    },
    viewDetails(userId) {

    }
  }
};
</script>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;

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

td {
  color: black;
}

.about {
  background-color: #ffffff; 
  padding: 40px; 
  border-radius: 10px; 
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.1); 
  width: 100%;
  max-width: 800px; 
}

h1, h2, h3 {
  color: #087129; 
  margin-bottom: 20px; 
}

.detail-button {
  background-color: lightyellow;
  border: 2px solid black;

}

.delete-button {
  margin-left: 5px;
  color: #29ae72;
  background-color: lightyellow;
  border: 2px solid black;
}

.delete-button:hover {
  margin-left: 5px;
  color: #29ae72;
  background-color: #cf225f !important;
  border: 2px solid black;
}

table {
  width: 100%;
  border-collapse: collapse;
  margin-bottom: 20px; 
  border: 2px solid black;

}

th, td {
  padding: 12px; 
  border: 1px solid #ddd; 
  text-align: center; 
  border: 1px solid black;

}

th {
  background-color: #f4f4f4; 
  color: #087129; 
  font-size: larger;
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
