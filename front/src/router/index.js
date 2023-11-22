import { createRouter, createWebHistory } from 'vue-router'

const routes = 
[
  {
    name: "AppBody",
    path: '/AppBody',
    component: () => import('@/components/AppBody'),
    redirect: '/index',
    children:
    [
      {
        name: 'index',
        path: '/',
        component: () => import('@/components/home/AppIndex'),
      },
      {
        name: 'SocietyPage',
        path: '/society',
        component: () => import('@/components/home/SocietyPage')
      },
      {
        name: 'SocietyShow',
        path: '/societyShow',
        component: () => import('@/components/home/SocietyShow')
      },
      {
        name: 'ResourcesPage',
        path: '/resources',
        component: () => import('@/components/home/ResourcesPage')
      },
      {
        name: 'ResourcesShow',
        path: '/resourcesShow',
        component: () => import('@/components/home/ResourcesShow')
      },
      {
        name: 'PersonalPage',
        path: '/personal',
        component: () => import('@/components/home/PersonalIndex')
      },
      {
        name: 'ForumPage',
        path: '/forum',
        component: () => import('@/components/home/ForumPage')
      },
      {
        name: 'LoginPage',
        path: '/login',
        component: () => import('@/components/home/LoginPage')
      },
      {
        name: 'SignupPage',
        path: '/signup',
        component: () => import('@/components/home/SignupPage')
      },
    ]
  },
  {
    name: 'manageBody',
    path: '/manageBody',
    component: () => import('@/components/manage/ManageBody'),
    redirect: '/manageIndex',
    children:
    [
      {
        name: 'manageIndex',
        path: '/manageIndex',
        component: () => import('@/components/manage/ManageIndex'),
      },
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
