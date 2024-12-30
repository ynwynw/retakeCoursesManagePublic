	import {
		createRouter,
		createWebHashHistory
	} from 'vue-router'
	import shenqingfuhe from '@/views/shenqingfuhe/list'
	import banzhuren from '@/views/banzhuren/list'
	import zhongxiushenqing from '@/views/zhongxiushenqing/list'
	import xuesheng from '@/views/xuesheng/list'
	import zhongxiukecheng from '@/views/zhongxiukecheng/list'
	import kechengchengji from '@/views/kechengchengji/list'
	import systemNotice from '@/views/systemNotice/list'
	import jianyibaogao from '@/views/jianyibaogao/list'
	import banji from '@/views/banji/list'
	import zhuanye from '@/views/zhuanye/list'
	import xueshengCenter from '@/views/xuesheng/center'
	import usersCenter from '@/views/users/center'
	import banzhurenCenter from '@/views/banzhuren/center'

export const routes = [{
		path: '/login',
		name: 'login',
		component: () => import('../views/login.vue')
	},{
		path: '/',
		name: '首页',
		component: () => import('../views/index'),
		children: [{
			path: '/',
			name: '首页',
			component: () => import('../views/HomeView.vue'),
			meta: {
				affix: true
			}
		}, {
			path: '/updatepassword',
			name: '修改密码',
			component: () => import('../views/updatepassword.vue')
		}
		
		,{
			path: '/xueshengCenter',
			name: '学生个人中心',
			component: xueshengCenter
		}
		,{
			path: '/usersCenter',
			name: '管理员个人中心',
			component: usersCenter
		}
		,{
			path: '/banzhurenCenter',
			name: '班主任个人中心',
			component: banzhurenCenter
		}
		,{
			path: '/shenqingfuhe',
			name: '申请复核',
			component: shenqingfuhe
		}
		,{
			path: '/banzhuren',
			name: '班主任',
			component: banzhuren
		}
		,{
			path: '/zhongxiushenqing',
			name: '重修申请',
			component: zhongxiushenqing
		}
		,{
			path: '/xuesheng',
			name: '学生',
			component: xuesheng
		}
		,{
			path: '/zhongxiukecheng',
			name: '重修课程',
			component: zhongxiukecheng
		}
		,{
			path: '/kechengchengji',
			name: '课程成绩',
			component: kechengchengji
		}
		,{
			path: '/systemNotice',
			name: '系统公告',
			component: systemNotice
		}
		,{
			path: '/jianyibaogao',
			name: '建议报告',
			component: jianyibaogao
		}
		,{
			path: '/banji',
			name: '班级',
			component: banji
		}
		,{
			path: '/zhuanye',
			name: '专业',
			component: zhuanye
		}
		]
	},
]

const router = createRouter({
	history: createWebHashHistory(process.env.BASE_URL),
	routes
})

export default router
