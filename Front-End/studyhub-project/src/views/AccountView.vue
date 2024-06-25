<template>
    <div class="account-view">
      <h1>Account Management</h1>
  
      <!-- Nút để hiển thị form thêm mới tài khoản -->
      <button @click="showAddForm = true">Add Account</button>
  
      <!-- Form thêm mới tài khoản -->
      <div v-if="showAddForm">
        <h2>Add New Account</h2>
        <form @submit.prevent="addAccount">
          <label>Username:</label>
          <input type="text" v-model="newAccount.username" required>
          <label>Email:</label>
          <input type="email" v-model="newAccount.email" required>
          <button type="submit">Save</button>
        </form>
      </div>
  
      <!-- Danh sách các tài khoản -->
      <ul>
        <li v-for="(account, index) in accounts" :key="account.id">
          <span>{{ account.username }} - {{ account.email }}</span>
          <button @click="editAccount(index)">Edit</button>
          <button @click="deleteAccount(index)">Delete</button>
        </li>
      </ul>
    </div>
  </template>
  
  <script>
  export default {
    name: 'AccountView',
    data() {
      return {
        accounts: [
          { id: 1, username: 'user1', email: 'user1@example.com' },
          { id: 2, username: 'user2', email: 'user2@example.com' },
          { id: 3, username: 'user3', email: 'user3@example.com' },
        ],
        newAccount: {
          username: '',
          email: ''
        },
        showAddForm: false
      };
    },
    methods: {
      addAccount() {
        // Thêm tài khoản mới vào danh sách
        this.accounts.push({
          id: this.accounts.length + 1,
          username: this.newAccount.username,
          email: this.newAccount.email
        });
        // Đặt lại form và ẩn form thêm mới
        this.newAccount.username = '';
        this.newAccount.email = '';
        this.showAddForm = false;
      },
      editAccount(index) {
        // Đang chưa có backend, nên chỉ cập nhật trong client-side
        const newUsername = prompt('Enter new username', this.accounts[index].username);
        const newEmail = prompt('Enter new email', this.accounts[index].email);
        if (newUsername && newEmail) {
          this.accounts[index].username = newUsername;
          this.accounts[index].email = newEmail;
        }
      },
      deleteAccount(index) {
        // Đang chưa có backend, nên chỉ xóa trong client-side
        if (confirm('Are you sure you want to delete this account?')) {
          this.accounts.splice(index, 1);
        }
      }
    }
  };
  </script>
  
  <style>
  .account-view {
    max-width: 800px;
    margin: auto;
    padding: 20px;
  }
  
  ul {
    list-style-type: none;
    padding: 0;
  }
  
  li {
    margin-bottom: 10px;
  }
  
  button {
    margin-left: 10px;
  }
  </style>
  