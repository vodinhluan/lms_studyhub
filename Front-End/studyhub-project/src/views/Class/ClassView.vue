<template>
  <div class="about-container">
    <section class="about">
      <div class="content">
        <h1>CLASS</h1>
        <div>
          <router-link to="/createclass">CREATE</router-link>
          <h2>List all class</h2>
          <table>
            <thead>
                <tr>
                  <th>ID</th>
                  <th>Class name</th>
                  <th>Teacher</th>
                  <th>Code</th>
                  <th>Action</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="lop in classes" :key="lop.id">
                <td>{{ lop.id }}</td>
                <td>{{ lop.name }}</td>
                <td>{{ lop.teacher.username }}</td>
                <td>{{ lop.code }}</td>
                <td>
                  <button class="detail-button">
                    Detail
                  </button>
                  <button class="delete-button" @click="confirmDelete(lop.id)">
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
      classes: []
    };
  },
  mounted() {
    this.fetchClass();
  },
  methods: {
    fetchClass() {
      axios.get('http://localhost:8080/class/get-all')
        .then(response => {
          this.classes = response.data;
        })
        .catch(error => {
          console.error('Error fetching classes:', error);
        });
    },
    confirmDelete(classId) {
      Swal.fire({
        title: 'Bạn có chắc chắn muốn xóa?',
        text: "Bạn sẽ không thể hoàn tác điều này!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Xóa',
        cancelButtonText: 'Hủy'
      }).then((result) => {
        if (result.isConfirmed) {
          this.deleteClass(classId);
        }
      });
    },

    async deleteClass(classId) {
      const toast = useToast(); 
      console.log("Class ID = ", classId);
      toast.apply

      try {
        const response = await axios.delete(`http://localhost:8080/class/delete/${classId}`);
        if (response.status === 204) {
          toast.success('Xóa lớp học thành công'); 
          this.fetchClass(); 
        } else {
          toast.error('Xóa lớp học thất bại');
        }
      } catch (error) {
        toast.error('Xảy ra lỗi trong quá trình xóa lớp học'); 
        console.error("Error deleting class:", error); 
      }
    },
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
