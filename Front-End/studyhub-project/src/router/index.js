import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';

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
    // route level code-splitting
    // this generates a separate chunk (About.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
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
    // route level code-splitting
    // this generates a separate chunk (About.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import('../views/TestView.vue'),
    meta: { showNav: true }
  }
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

export default router;
