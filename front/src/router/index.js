import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/messages/my/:id',
      name: 'messages',
      component: () => import('../views/ConversationsView.vue')
    },
    {
      path: '/messages/id/:id',
      name: 'conversation',
      component: () => import('../views/ConversationView.vue')
    },
    {
      path: '/offer',
      name: 'Offer',
      component: () => import('../components/Offer.vue')
    }
  ]
})

export default router
