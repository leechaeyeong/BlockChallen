import Vue from 'vue'
import VueRouter from 'vue-router'
import ChallengeCreate from '@/views/ChallengeCreate.vue'
import ChallengeDetail from '@/views/ChallengeDetail.vue'
import Home from '@/views/Home.vue'
import ChallengeList from '@/views/ChallengeList.vue'
import MyPage from '@/views/MyPage.vue'
import SignUp from '@/views/SignUp.vue'
import SocialLogin from "@/views/SocialLogin"


Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'home',
        component: Home,
    },
    {
        path: '/challenges',
        name: 'ChallengeList',
        component: ChallengeList
    },
    {
        path: '/mypage',
        name: 'MyPage',
        component: MyPage
    },
    {
        path: '/signup',
        name: 'signup',
        component: SignUp,
        props: true
    },
    {
        path: '/challenges/create',
        name: "ChallengeCreate",
        component: ChallengeCreate
    },
    {
        path: '/challenges/:cid',
        name: "ChallengeDetail",
        component: ChallengeDetail,
        props: true
    },
    {
        path: '/login/:id',
        name: 'SocialLogin',
        component: SocialLogin,
        props: true
    },
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router