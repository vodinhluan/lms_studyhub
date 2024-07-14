import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import CreateAccountView from '../views/CreateAccoutView.vue';
const routes = [
  {
    path: '/',
    name: 'login',
    component: () => import('../views/LoginView.vue'),
    meta: { showNav: false }
  },
  {
    path: '/account',
    name: 'account',
    component: () => import('../views/AccountView.vue'),
    meta: { showNav: true }
  },
  {
    path: '/home',
    name: 'home',
    component: HomeView,
    meta: { showNav: true }
  },
  {
    path: '/test',
    name: 'test',
    component: () => import('../views/TestView.vue'),
    meta: { showNav: true }
  },
  {
    path: '/createaccount',
    name: 'createaccount',
    component: CreateAccountView,
    meta: { showNav: true }
  }

];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

export default router;
