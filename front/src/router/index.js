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
        path: '/index',
        component: () => import('@/components/home/AppIndex'),
      },
      {
        name: 'SocietyPage',
        path: '/society',
        component: () => import('@/components/home/SocietyPage')
      },
      {
        name: 'ResourcesPage',
        path: '/resources',
        component: () => import('@/components/home/ResourcesPage')
      }
    ]
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
