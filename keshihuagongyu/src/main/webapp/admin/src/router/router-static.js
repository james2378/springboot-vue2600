import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import banji from '@/views/modules/banji/list'
    import daka from '@/views/modules/daka/list'
    import dictionary from '@/views/modules/dictionary/list'
    import fangke from '@/views/modules/fangke/list'
    import jiaofeijilu from '@/views/modules/jiaofeijilu/list'
    import lixiaodengji from '@/views/modules/lixiaodengji/list'
    import sushe from '@/views/modules/sushe/list'
    import susheguanliyuan from '@/views/modules/susheguanliyuan/list'
    import wupinjinchu from '@/views/modules/wupinjinchu/list'
    import xuesheng from '@/views/modules/xuesheng/list'
    import zhusu from '@/views/modules/zhusu/list'
    import dictionaryJiaofei from '@/views/modules/dictionaryJiaofei/list'
    import dictionaryLoudong from '@/views/modules/dictionaryLoudong/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryWupinjinchu from '@/views/modules/dictionaryWupinjinchu/list'
    import dictionaryWupinjinchuZhuangtai from '@/views/modules/dictionaryWupinjinchuZhuangtai/list'
    import dictionaryZhuangtai from '@/views/modules/dictionaryZhuangtai/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryJiaofei',
        name: '缴费类型',
        component: dictionaryJiaofei
    }
    ,{
        path: '/dictionaryLoudong',
        name: '楼栋',
        component: dictionaryLoudong
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryWupinjinchu',
        name: '物品类型',
        component: dictionaryWupinjinchu
    }
    ,{
        path: '/dictionaryWupinjinchuZhuangtai',
        name: '状态',
        component: dictionaryWupinjinchuZhuangtai
    }
    ,{
        path: '/dictionaryZhuangtai',
        name: '状态',
        component: dictionaryZhuangtai
    }


    ,{
        path: '/banji',
        name: '班级',
        component: banji
      }
    ,{
        path: '/daka',
        name: '每日打卡',
        component: daka
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/fangke',
        name: '访客',
        component: fangke
      }
    ,{
        path: '/jiaofeijilu',
        name: '宿舍缴费记录',
        component: jiaofeijilu
      }
    ,{
        path: '/lixiaodengji',
        name: '离校登记',
        component: lixiaodengji
      }
    ,{
        path: '/sushe',
        name: '宿舍',
        component: sushe
      }
    ,{
        path: '/susheguanliyuan',
        name: '宿舍管理员',
        component: susheguanliyuan
      }
    ,{
        path: '/wupinjinchu',
        name: '物品进出登记',
        component: wupinjinchu
      }
    ,{
        path: '/xuesheng',
        name: '学生',
        component: xuesheng
      }
    ,{
        path: '/zhusu',
        name: '住宿信息',
        component: zhusu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
