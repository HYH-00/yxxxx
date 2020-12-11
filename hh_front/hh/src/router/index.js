import Vue from 'vue'
import VueRouter from 'vue-router'
import TreeHole from '../components/TreeHole.vue'
// import App from '../App.vue'
import Login from '../Login.vue'
import Main from '../Main.vue'

Vue.use(VueRouter)

const routes = [{
		path: '/TreeHole',
		name: 'TreeHole',
		component: TreeHole
	},
	{
		path: '/Main',
		name: 'Main',
		component: Main
	},
	{
		path: '/',
		name: 'Login',
		component: Login
	},
	{
		path: '/about',
		name: 'About',
		// route level code-splitting
		// this generates a separate chunk (about.[hash].js) for this route
		// which is lazy-loaded when the route is visited.
		component: () => import( /* webpackChunkName: "about" */ '../views/About.vue')
	}
]

const router = new VueRouter({
	routes
})

export default router
