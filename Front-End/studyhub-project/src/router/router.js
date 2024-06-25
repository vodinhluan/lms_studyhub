// src/router.js
import { createRouter, createWebHistory } from 'vue-router';
import Home from './components/Home.vue';
import About from './components/About.vue';
import Login from './components/Login.vue';
import Test from './components/Test.vue';

const routes = [
  { path: '/', component: Home },
  { path: '/account', component: Account },
  { path: '/login', component: Login },
  { path: '/test', component: Test }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
