  
import Vue from 'vue'
import Router from 'vue-router';
import ViewAppointmentsData from '../components/ViewAppointmentsData';
import Appointments from '../components/Appointments';
Vue.use(Router);

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [{
            path: '/',
            component: Appointments
        },
        {
            path: '/viewAppm',
            component: ViewAppointmentsData
        },
        
    ]
});