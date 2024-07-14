// src/router.js
import { createRouter, createWebHistory } from 'vue-router';
import Home from './components/Home.vue';
import About from './components/About.vue';
import Login from './components/Login.vue';
import Test from './components/Test.vue';
import CreateAccount from '@/components/CreateAccount.vue';

const routes = [
  { path: '/', component: Home },
  { path: '/account', component: Account },
  { path: '/login', component: Login },
  { path: '/test', component: Test },
  { path: '/createaccount', component: CreateAccount}
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
