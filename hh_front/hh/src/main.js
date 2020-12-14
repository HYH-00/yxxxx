import Vue from 'vue'
import App from './App.vue'
// import Login from './Login.vue'
import axios from 'axios'
Vue.prototype.$axios = axios

import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import router from './router'
Vue.use(ElementUI);

Vue.config.productionTip = false

new Vue({
	router,
	render: h => h(App)
}).$mount('#app')
