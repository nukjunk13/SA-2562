import Vue from 'vue'
import Router from 'vue-router'
import Advertisement from '../components/Advertisement'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      component: Advertisement
    }

  ]
})
