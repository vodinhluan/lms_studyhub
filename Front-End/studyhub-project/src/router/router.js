import { createRouter, createWebHistory } from 'vue-router';
import Home from './components/Home.vue';
import Login from './components/Login.vue';
import Test from './components/Test.vue';
import AccountDetail from './components/AccountDetail.vue';
import CreateAccount from './components/CreateAccount.vue'; 

const routes = [
  { path: '/home', component: Home, meta: { requiresAuth: true } },
  { path: '/account', component: AccountDetail, meta: { requiresAuth: true } },
  { path: '/', component: Login, meta: { requiresAuth: false } },
  { path: '/class', component: Class, meta: { requiresAuth: true } },
  { path: '/createaccount', component: CreateAccount, meta: { requiresAuth: true } },
  { path: '/detail/:userId', component: AccountDetail, meta: { requiresAuth: true } }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
