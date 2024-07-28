import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import CreateAccountView from '../views/Account/CreateAccoutView.vue';
import CreateClassView from '../views/Class/CreateClassView.vue';
import AccountDetail from '../components/AccountDetail.vue';
import Swal from 'sweetalert2';
const routes = [
  {
    path: '/',
    name: 'login',
    component: () => import('../views/Authenticate/LoginView.vue'),
    meta: { showNav: false }
  },
  {
    path: '/account',
    name: 'account',
    component: () => import('../views/Account/AccountView.vue'),
    meta: { showNav: true, requiresAuth: true,role: 'Admin' }
  },
  {
    path: '/home',
    name: 'home',
    component: HomeView,
    meta: { showNav: true, requiresAuth: true }
  },
  {
    path: '/class',
    name: 'class',
    component: () => import('../views/Class/ClassView.vue'),
    meta: { showNav: true, requiresAuth: true }
  },
  {
    path: '/createaccount',
    name: 'createaccount',
    component: CreateAccountView,
    meta: { showNav: true , requiresAuth: true,role: 'Admin'}
  },
  {
    path: '/createclass',
    name: 'createclass',
    component: CreateClassView,
    meta: { showNav: true , requiresAuth: true}
  },
  {
    path: '/detail/:id',
    name: 'User Detail',
    component: AccountDetail,
    meta: { showNav: true, requiresAuth: true ,role: 'Admin'}
  }

];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});
router.beforeEach((to, from, next) => {
  const token = localStorage.getItem('token'); 
  const isAuthenticated = !!token; 
  const userRole = localStorage.getItem('role'); 

  if (to.meta.requiresAuth && !isAuthenticated) {
    next('/');
  } else if (to.meta.role && to.meta.role !== userRole) {
     Swal.fire({
      title: 'Cảnh báo truy cập',
      text: 'Bạn không có quyền truy cập vào trang này. Liên hệ trực tiếp với Admin để giải quyết vấn đề.',
      icon: 'error',
      confirmButtonColor: '#3085d6',
      confirmButtonText: 'OK',
    });
    next('/home');
  } else {
    next();
  }
});

export default router;
