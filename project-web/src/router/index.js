import Vue from 'vue'
import Router from 'vue-router'
import Login from "../components/login/Login";
import Home from "../components/home/Home";
import index from "../components/page/index"

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: "Home",
      component: Home
    },
    {
      path: '/Login',
      name: 'Login',
      component: Login
    },
    {
      path: '/index',
      name: 'index',
      component: index
    }

  ]
})
