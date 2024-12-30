<template>
  <div>
    <div class="login_view">
      <el-form :model="loginForm" class="login_form">
        <div class="title_view">基于SpringBoot的重修课程信息管理系统登录</div>
        <div class="list_item" v-if="loginType == 1">
          <div class="list_label">账号：</div>
          <input
            class="list_inp"
            v-model="loginForm.username"
            placeholder="请输入账号"
            name="username"
          />
        </div>
        <div class="list_item" v-if="loginType == 1">
          <div class="list_label">密码：</div>
          <input
            class="list_inp"
            v-model="loginForm.password"
            type="password"
            placeholder="请输入密码"
            @keydown.enter.native="handleLogin"
          />
        </div>
        <div class="list_type" v-if="userList.length > 1">
          <el-radio
            v-for="(item, index) in userList"
            :key="index"
            v-model="loginForm.role"
            :label="item.roleName"
            >{{ item.roleName }}</el-radio
          >
        </div>
        <div class="remember_view" v-if="loginType == 1">
          <el-checkbox
            v-model="rememberPassword"
            label="记住密码"
            size="large"
            :true-label="true"
            :false-label="false"
          />
        </div>
        <div class="btn_view">
          <el-button
            class="login"
            v-if="loginType == 1"
            type="success"
            @click="handleLogin"
            >登录</el-button
          >
        </div>
      </el-form>
    </div>
    <Vcode
      :show="isShow"
      @success="success"
      @close="close"
      @fail="fail"
    ></Vcode>
  </div>
</template>
<script setup>
import { ref, getCurrentInstance, nextTick, onMounted } from 'vue'
import { useStore } from 'vuex'
const store = useStore()
const userList = ref([])
const menus = ref([])
const loginForm = ref({
  role: '',
  username: '',
  password: '',
})
const tableName = ref('')
const loginType = ref(1)
//是否记住密码
const rememberPassword = ref(true)
const context = getCurrentInstance()?.appContext.config.globalProperties
const handleLogin = () => {
  if (!loginForm.value.username) {
    context?.$toolUtil.message('请输入用户名', 'error')

    return
  }
  if (!loginForm.value.password) {
    context?.$toolUtil.message('请输入密码', 'error')
    return
  }
  if (userList.value.length > 1) {
    if (!loginForm.value.role) {
      context?.$toolUtil.message('请选择角色', 'error')
      verifySlider.value.reset()
      return
    }
    for (let i = 0; i < menus.value.length; i++) {
      if (menus.value[i].roleName == loginForm.value.role) {
        tableName.value = menus.value[i].tableName
      }
    }
  } else {
    tableName.value = userList.value[0].tableName
    loginForm.value.role = userList.value[0].roleName
  }
  login()
}
const login = () => {
  context
    ?.$http({
      url: `${tableName.value}/login?username=${loginForm.value.username}&password=${loginForm.value.password}`,
      method: 'post',
    })
    .then(
      (res) => {
        //是否保存当前账号密码至缓存
        if (rememberPassword.value) {
          let loginForm1 = JSON.parse(JSON.stringify(loginForm.value))
          delete loginForm1.code
          context?.$toolUtil.storageSet('loginForm', JSON.stringify(loginForm1))
        } else {
          context?.$toolUtil.storageRemove('loginForm')
        }
        context?.$toolUtil.storageSet('Token', res.data.token)
        context?.$toolUtil.storageSet('role', loginForm.value.role)
        context?.$toolUtil.storageSet('sessionTable', tableName.value)
        context?.$toolUtil.storageSet('adminName', loginForm.value.username)
        store.dispatch('user/getSession') //vuex中获取用户信息并保存
        context?.$router.push('/')
      },
      (err) => {}
    )
}
//获取菜单
const getMenu = () => {
  let params = {
    page: 1,
    limit: 1,
    sort: 'id',
  }

  context
    ?.$http({
      url: 'menu/list',
      method: 'get',
      params: params,
    })
    .then((res) => {
      menus.value = JSON.parse(res.data.data.list[0].menujson)
      for (let i = 0; i < menus.value.length; i++) {
        if (menus.value[i].hasBackLogin == '是') {
          userList.value.push(menus.value[i])
        }
      }
      //获取缓存是否有保存的账号密码
      let form = context?.$toolUtil.storageGet('loginForm')
      if (form) {
      } else {
        loginForm.value.role = userList.value[0].roleName
      }
      context?.$toolUtil.storageSet('menus', JSON.stringify(menus.value))
    })
}
//初始化
const init = () => {
  getMenu()
  //获取缓存是否有保存的账号密码
  let form = context?.$toolUtil.storageGet('loginForm')
  if (form) {
    loginForm.value = JSON.parse(form)
  }
}
onMounted(() => {
  init()
})
</script>

<style lang="scss" scoped>
.login_view {
  background-image: url('http://localhost:8080/retakeCoursesManage/file/6e183964b38f4ed2bc99134dcb3d9e54.webp');
  // 表单盒子
  .login_form {
  }
  .title_view {
  }
  // item盒子
  .list_item {
    // label
    .list_label {
    }
    // 输入框
    .list_inp {
    }
  }
  // 用户类型样式
  .list_type {
    // 未选中样式
    :deep(.el-radio) {
      // 单选框
      .el-radio__inner {
      }
      // 提示文字
      .el-radio__label {
      }
    }
    // 选中样式
    :deep(.is-checked) {
      // 单选框
      .el-radio__inner {
      }
      // 提示文字
      .el-radio__label {
      }
    }
  }
  // 记住密码样式
  .remember_view {
    // 未选中样式
    :deep(.el-checkbox) {
      // 复选框
      .el-checkbox__inner {
      }
      // 提示文字
      .el-checkbox__label {
      }
    }
    // 选中样式
    :deep(.is-checked) {
      //复选框
      .el-checkbox__inner {
      }
      // 提示文字
      .el-checkbox__label {
      }
    }
  }
  // 按钮盒子
  .btn_view {
    // 登录
    .login {
    }
  }
}
</style>
<style>
.login_view {
  min-height: 100vh;
  position: relative;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  background-image: url(http://localhost:8080/retakeCoursesManage/file/accde26404c0440d8aa6f2281c09fa11.jpg);
  background-position: center center;
  background-size: 100% 100% !important;
  background-repeat: no-repeat;
  background-attachment: initial;
  background-origin: initial;
  background-clip: initial;
  background-color: initial;
}

/*表单盒子*/
.login_form {
  width: 500px;
  margin: 0 auto;
  padding: 30px 50px 40px 50px;
  background: #fff;
  font-size: 16px;
  border-radius: 0px;
  transform: scale(1);
  -webkit-transform: scale(1);
  -ms-transform: scale(1);
  z-index: 5;
}

.login_form:before {
  content: '';
  width: 100%;
  height: 0px;
  border-radius: 10px;
  position: absolute;
  top: -10px;
  background: rgba(255, 255, 255, 0.6);
  left: 0;
  transform: scale(0.95);
  -webkit-transform: scale(0.95);
  -ms-transform: scale(0.95);
  z-index: -1;
}

/*标题*/
.login_form .title_view {
  width: calc(100% + 100px);
  float: left;
  line-height: 46px;
  font-size: 18px;
  font-weight: 600;
  letter-spacing: 0.5px;
  background: #339933;
  color: #fff;
  position: relative;
  margin-bottom: 20px;
  margin-left: -100px;
  padding-left: 40px;
}
.login_form .title_view:before {
  content: '';
  width: 0px;
  height: 100%;
  position: absolute;
  top: 0;
  left: -50px;
  background: #8b5c7e;
}

/*list_item*/
.login_form .list_item {
  display: flex;
  align-items: center;
  width: 100%;
  justify-content: flex-start;
  margin: 10px auto;
}
.login_form .list_item .list_label {
  margin-right: 10px;
  font-size: 16px;
  white-space: nowrap;
}
.login_form .list_item .list_label i {
  font-size: 24px;
  color: #999;
}
.login_form .list_item .list_inp {
  width: 100%;
  border: none;
  border-bottom: 1px solid #ddd;
  height: 40px;
  line-height: 40px;
  font-size: inherit;
}
.login_form .list_item .el-select {
}

/*用户类型*/
.login_form .list_type {
  display: flex;
  align-items: center;
  width: 100%;
  justify-content: center;
  padding: 10px 0px;
  margin-bottom: 10px;
}
.login_form .list_type .el-radio {
  display: flex;
  align-items: center;
}
.login_form .list_type .el-radio .el-radio__label {
  color: #666;
  font-size: 16px;
}
.login_form .list_type .el-radio.is-checked {
}
.login_form .list_type .el-radio.is-checked .el-radio__label {
  color: rgb(51, 153, 51);
  font-size: 16px;
}
.login_form .list_type .el-radio__input {
}
.login_form .list_type .el-radio__input.is-checked {
}
.login_form .list_type .el-radio__input .el-radio__inner {
  background: rgb(255, 255, 255);
  border: 1px solid rgb(220, 223, 230);
}
.login_form .list_type .el-radio__input.is-checked .el-radio__inner {
  background-color: rgb(51, 153, 51);
  border-color: rgb(51, 153, 51);
}

/*记住密码*/
.login_form .remember_view {
  margin-bottom: 20px;
}
.login_form .remember_view .el-checkbox {
  width: 20%;
  margin: 0px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.login_form .remember_view .el-checkbox .el-checkbox__label {
  background: rgb(255, 255, 255);
}
.login_form .remember_view .el-checkbox .el-checkbox__inner {
  color: rgb(153, 153, 153);
}
.login_form .remember_view .el-checkbox.is-checked .el-checkbox__label {
  color: #339933;
  font-size: 15px;
}
.login_form .remember_view .el-checkbox.is-checked .el-checkbox__inner {
  background: #339933;
  border-color: #339933;
  font-size: 16px;
}

/* 按钮 */
.login_form .btn_view {
  text-align: center;
}
.login_form .btn_view .login {
  width: 100%;
  height: 46px;
  line-height: 46px;
  background: #339933;
  border: 0px solid #ccc;
  font-weight: 600;
  font-size: 18px;
  color: #fff;
  margin-bottom: 20px;
  padding: 0;
  border-radius: 0px;
}
.login_form .btn_view .login:hover {
}
.login_form .btn_view .register {
  background: #fff;
  border: 0px solid #ccc;
  font-size: 16px;
  color: #666;
}
.login_form .btn_view .register:hover {
}
.login_form .btn_view .forget {
  background: #fff;
  border: 0px solid #ccc;
  font-size: 16px;
  color: #666;
}
.login_form .btn_view .forget:hover {
}

.login_form .face {
  width: 100%;
  height: 50px;
  line-height: 46px;
  background: #fff;
  border: 0px solid #ccc;
  font-weight: 500;
  font-size: 16px;
  color: #666;
  margin-bottom: 20px;
  text-align: left;
  margin-top: 20px;
  padding: 0;
}
.login_form .face:hover {
}
</style>
