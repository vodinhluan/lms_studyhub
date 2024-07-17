import { createRouter, createWebHistory } from 'vue-router';
import Home from './components/Home.vue';
import Login from './components/Login.vue';
import Test from './components/Test.vue';
import AccountDetail from './components/AccountDetail.vue';

const routes = [
  { path: '/', component: Home },
  { path: '/account', component: Account },
  { path: '/login', component: Login },
  { path: '/test', component: Test },
  { path: '/createaccount'},
  { path: '/detail/:userId', component: AccountDetail}
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
