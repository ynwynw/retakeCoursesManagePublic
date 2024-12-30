<template>
	<div class="menu_wrapper">
		<el-scrollbar wrap-class="scrollbar-wrapper" class="menu_scrollbar">
			<el-menu :default-openeds="[]" :unique-opened="true" default-active="0" class="menu_view"
				:collapse="collapse">
				<el-menu-item class="first-item" :index="0" @click="menuHandler('')">
					<i class="iconfont icon-zhuye2" v-if="collapse?false:true"></i>
					<template #title>
						<span>首页</span>
					</template>
				</el-menu-item>
                <template v-for=" (item,index) in menuList.backMenu">
                    <el-sub-menu   class="first-item" :index="index+2+''">
                        <template #title>
                            <i class="iconfont" :class="item.fontClass" v-if="collapse?false:true"></i>
                            <span>{{ item.menu }}</span>
                        </template>
                        <el-menu-item class="second-item" v-for=" (child,sort) in item.child" :key="sort"
                            :index="(index+2)+'-'+sort"
                            @click="menuHandler(child.classname||child.tableName,child.menuJump)">{{ child.menu }}
                        </el-menu-item>
                    </el-sub-menu>
                </template>
			</el-menu>
		</el-scrollbar>
	</div>
</template>

<script setup>
	import menu from '@/utils/menu'
	import {
		ref,
		toRefs,
		getCurrentInstance,
		nextTick
	} from 'vue';
	import { useStore } from 'vuex'
	const store = useStore()
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	//props
	const props = defineProps({
		collapse: Boolean
	})
	const {
		collapse
	} = toRefs(props)
	//data
	const menuList = ref([])
	const role = ref('')
	//权限验证
	const btnAuth = (e,a)=>{
		return context?.$toolUtil.isAuth(e,a)
	}
	const init = () => {
		const menus = menu.list()
		if (menus) {
			menuList.value = menus
		}
		role.value = context?.$toolUtil.storageGet('role')

		for (let i = 0; i < menuList.value.length; i++) {
			if (menuList.value[i].roleName == role.value) {
				menuList.value = menuList.value[i];
				break;
			}
		}
	}
	const menuHandler = (name,menuJump) => {
        if(name == 'center'){
            context.$router.push(`/${role.value}Center`)
        }else if(name == 'storeup'){
            context.$router.push(`/storeup?type=${menuJump}`)
        }else if(name == 'exampaper' && menuJump == '12'){
            context.$router.push('/exampaperlist')
        }else if(name == 'examrecord' && menuJump == '22'){
            context.$router.push('/examfailrecord')
        }else{
            context.$router.push(`/${name}${menuJump?'?menuJump='+menuJump:''}`)
        }
	}
	init()
</script>

<style lang="scss" scoped>
	// 总盒子
	:deep(.menu_scrollbar) {

		// 菜单盒子-展开样式
		.menu_view {

			// 无二级菜单
			.el-menu-item {
				.iconfont {
				}
			}

			// 无二级悬浮
			.el-menu-item:hover {
			}

			// 无二级选中
			.el-menu-item.is-active {
			}

			// 有二级盒子
			.el-sub-menu {

				// 有二级item
				.el-sub-menu__title {
					.iconfont {
					}
					.el-sub-menu__icon-arrow{
					}
				}

				// 有二级item悬浮
				.el-sub-menu__title:hover {
				}
			}
			//二级选中
			.is-active {
				.el-sub-menu__title {
				}
			}
			// 二级盒子
			.el-menu--inline {
				// 二级菜单
				.second-item {
				}
				// 二级悬浮
				.second-item:hover {
				}
				// 二级选中
				.is-active.second-item {
				}
			}
		}
		// 菜单盒子-关闭样式
		.el-menu--collapse {
			padding: 0;
			background: none;
			height: 100%;

			// 无二级菜单
			.el-menu-item {
				border: none;
				padding: 0 10px;
				color: #ccc;
				background: none;
				line-height: 50px;
				height: 50px;
			}

			// 无二级悬浮
			.el-menu-item:hover {
				padding: 0 10px;
				color: #ccc;
				background: none;
				line-height: 50px;
				height: 50px;
			}

			// 无二级选中
			.el-menu-item.is-active {
				padding: 0 10px;
				color: #ccc;
				background: none;
				line-height: 50px;
				height: 50px;
			}

			// 有二级盒子
			.el-sub-menu {
				cursor: pointer;
				padding: 0 0;
				white-space: nowrap;
				background: none;
				position: relative;

				// 有二级item
				.el-sub-menu__title {
					border: none;
					padding: 0 10px;
					color: #ccc;
					background: none;
					line-height: 50px;
					height: 50px;
					.el-sub-menu__icon-arrow{
						margin: -3px 0 0 8px;
						color: inherit;
						vertical-align: middle;
						font-size: 12px;
						position: static;
					}
				}

				// 有二级item悬浮
				.el-sub-menu__title:hover {
					padding: 0 10px;
					color: #ccc;
					background: none;
					line-height: 50px;
					height: 50px;
				}
			}
			//二级选中
			.is-active {
				.el-sub-menu__title {
					padding: 0 10px;
					color: #ccc;
					background: none;
					line-height: 50px;
					height: 50px;
				}
			}
			// 二级盒子
			.el-menu--inline {
				border: none;
				padding: 0px;
				background: none;
				// 二级菜单
				.second-item {
					padding: 0 40px;
					color: #666;
					background: none;
					line-height: 50px;
					height: 50px;
				}
				// 二级悬浮
				.second-item:hover {
					padding: 0 40px;
					color: #f00;
					background: greenyellow;
					line-height: 50px;
					height: 50px;
				}
				// 二级选中
				.is-active.second-item {
					padding: 0 40px;
					color: #000;
					background: none;
					line-height: 50px;
					height: 50px;
				}
			}
		}
	}
</style>
<style lang="scss">
	.el-menu-item .el-menu-tooltip__trigger {
		padding: 0;
	}
	.el-popper{
		.el-menu--popup-container {
			.el-menu--popup{
				border: none;
				padding: 0px;
				background: none;
				// 二级菜单
				.second-item {
					padding: 0 40px;
					color: #666;
					background: none;
					line-height: 50px;
					height: 50px;
				}
				// 二级悬浮
				.second-item:hover {
					padding: 0 40px;
					color: #f00;
					background: greenyellow;
					line-height: 50px;
					height: 50px;
				}
				// 二级选中
				.is-active.second-item {
					padding: 0 40px;
					color: #000;
					background: none;
					line-height: 50px;
					height: 50px;
				}
			}
		}
	}
</style>
<style>
/* 菜单展开样式 */
/* 中间内容总盒子 */
.main-container{
    margin: 0px 0px 0px 240px;
    padding: 80px 0px 0px !important;
    background: rgba(23,139,23,.1);
    overflow: hidden;
}

/* 总盒子 */
.menu_wrapper{
    width: 240px;
    background: linear-gradient(180deg, rgba(23,139,23,1) 270%, rgba(0,102,0,1) 100%);
    height: 100%;
    overflow: hidden;
    position: fixed;
    top: 80px;
    left: 0px;
    border-width: 0px;
    border-style: solid;
    border-color: rgb(255, 255, 255);
    padding: 0px;
    transition: all 0.3s ease-in-out 0s;
}
/* 菜单盒子 */
.menu_view{
    height: 100%;
    background: none;
    color: rgb(255, 255, 255);
    padding: 0px 0px 100px;
    border: 0px;
    transition: all 0s ease 0s;
}

/* 一级菜单 */
/* 盒子 */
.menu_view li.el-sub-menu{
    padding: 0px;
    cursor: pointer;
    position: relative;
    white-space: nowrap;
    background: none;
    color: rgb(51, 51, 51);
}
/* 图标 */
.menu_view li.el-sub-menu .el-sub-menu__title .el-icon-location{
    vertical-align: middle;
    margin: 0px 5px 0px 0px;
    width: 20px;
    text-align: center;
    font-size: 20px;
    color: inherit;
}
/* item */
.menu_view li.el-sub-menu .el-sub-menu__title{
    height: 40px;
    padding: 0px 10px 0px 20px;
    color: rgb(255, 255, 255);
    background: none;
    line-height: 40px;
    border-width: 0px 0px 1px;
    border-style: solid;
    border-color: rgba(255, 255, 255,.3);
    font-weight: 600;
    margin: 0px;
    transition: all 0s ease 0s;
}
/* 悬浮*/
.menu_view li.el-sub-menu .el-sub-menu__title:hover{
    background: none;
    color: rgb(255, 255, 0);
}
/* 选中 */
.menu_view li.el-sub-menu .el-sub-menu__title.is-active{
    background: none;
    color: rgb(255, 255, 0);
}
/* 箭头*/
.menu_view li.el-sub-menu .el-sub-menu__title .el-sub-menu__icon-arrow{
    position: absolute;
    margin: -6px 0px 0px 8px;
    font-size: 12px;
    vertical-align: middle;
    color: inherit;
    right: 10px;
}
.menu_view li.el-menu-item{
    height: 40px;
    padding: 0px 10px 0px 20px;
    color: rgb(255, 255, 255);
    background: none;
    line-height: 40px;
    border-width: 0 0 1px;
    border-style: solid;
    border-color: rgba(255, 255, 255,.3);
    font-weight: 600;
    margin: 0px;
    transition: all 0s ease 0s;
}
.menu_view li.el-menu-item:hover{
    background: none;
    color: rgb(255, 255, 0);
}
.menu_view li.el-menu-item.is-active{
    background: none;
    color: rgb(255, 255, 0);
}

/* 二级菜单 */
/* 盒子 */
.menu_view li .el-menu--inline{
    border: none;
    padding: 0px;
    background: none;
    width: auto;
    margin: 0px;
    box-sizing: border-box;
}
/* item */
.menu_view li .el-menu--inline .second-item{
    height: 40px;
    line-height: 40px;
    padding: 0px 20px 0px 45px;
    color: rgb(255, 255, 255);
    background: none;
    border-width: 0px;
    border-style: solid;
    border-color: rgb(251, 190, 98);
    display: block;
    margin: 0px;
    box-shadow: none;
    font-weight: 600;
}
/* 悬浮 */
.menu_view li .el-menu--inline .second-item:hover{
    background: rgba(255, 255, 255,.1);
    color: rgb(255, 255, 0);
}
/* 选中 */
.menu_view li .el-menu--inline .second-item.is-active{
    background: rgba(255, 255, 255,.1);
    color: rgb(255, 255, 0);
}

</style>