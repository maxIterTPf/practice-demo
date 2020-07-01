<template>
  <el-container>
    <el-header>
      <el-link @click="back()"><i class="el-icon-back"></i>回退</el-link>
    </el-header>

    <el-main>
      <p class="title">登录页面</p>
      <div style="margin: 50px;"></div>
      <el-select v-model="value" clearable placeholder="您的身份">
        <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>
      <el-form class="el-form" :label-position="labelPosition" label-width="80px" :model="formLogin">
        <p>
          <el-input class="login-input"
                    v-model="formLogin.account"
                    placeholder="请输入账号"
                    clearable>
          </el-input>
        </p>
        <el-input class="login-input"
                  v-model="formLogin.password"
                  placeholder="请输入密码"
                  clearable></el-input>
      </el-form>
      <el-button class="login_button" @click="loginSubmit(), rememberUser()" type="success">登 录</el-button>
    </el-main>

    <el-footer>
      <el-checkbox v-model="checked" style="margin-right: 65px">记住账户</el-checkbox>
      <el-link type="_black" style="margin-right: 65px">忘记密码</el-link>
      <el-link type="_black" @click="registerDialogVisible = true">新用户注册</el-link>
      <el-dialog
        title="注册"
        :visible.sync="registerDialogVisible"
        width="30%"
        center>
        <el-form :label-position="labelPosition" label-width="80px" :model="formRegister">
          <el-form-item label="姓名">
            <el-input v-model="formRegister.name"></el-input>
          </el-form-item>
          <el-form-item label="账号">
            <el-input v-model="formRegister.account"></el-input>
          </el-form-item>
          <el-form-item label="密码">
            <el-input v-model="formRegister.password"></el-input>
          </el-form-item>
          <el-form-item label="性别">
            <el-input v-model="formRegister.sex"></el-input>
          </el-form-item>
          <el-form-item label="积分">
            <el-input v-model="formRegister.grade"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="registerDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="registerDialogVisible = false, submitRegister()">确 定</el-button>
        </span>
      </el-dialog>
    </el-footer>
  </el-container>
</template>

<script>
    export default {
        name: "Login",
        data() {
            return {
                checked: true,
                registerDialogVisible: false,
                labelPosition: 'right',
                formLogin: {
                    account: '',
                    password: ''
                },
                formRegister: {
                    name: '',
                    account: '',
                    password: '',
                    sex: '',
                    grade: ''
                },

                options: [{
                    value: '选项1',
                    label: '普通用户'
                }, {
                    value: '选项2',
                    label: '会员'
                }, {
                    value: '选项3',
                    label: '管理员'
                }],
                value: ''
            };
        },
        mounted() {
            this.getCookie()
        },
        methods: {
            // 回退到上个页面
            back() {
                this.$router.back()
            },
            // 登陆
            loginSubmit() {
                let that = this;
                that.$axios
                    .post('/option/login', {
                        account: that.formLogin.account,
                        password: that.formLogin.password
                    })
                    .then(res => {
                        console.log(res);
                        if ("" == res.data) {
                            console.log("登陆成功");
                            this.$message({
                                message: '欢迎登陆系统',
                                type: 'success'
                            });
                        }
                        this.$router.push({path: 'index'});
                    })
                    .catch(function (err) {
                        console.log(err);
                    })
            },

            // 记住用户
            rememberUser() {
                const that = this;
                //判断复选框是否被勾选 勾选则调用配置cookie方法
                if (that.checked == true) {
                    //传入账号名，密码，和保存天数三个参数
                    that.setCookie(that.formLogin.account, that.formLogin.password, 7);
                } else {
                    //清空Cookie
                    that.clearCookie();
                }
            },
            //设置cookie
            setCookie(c_name, c_pwd, exdays) {
                let exdate = new Date(); //获取时间
                exdate.setTime(exdate.getTime() + 24 * 60 * 60 * 1000 * exdays); //保存的天数
                //字符串拼接cookie
                window.document.cookie =
                    "account" + "=" + c_name + ";path=/;expires=" + exdate.toGMTString();
                window.document.cookie =
                    "password" + "=" + c_pwd + ";path=/;expires=" + exdate.toGMTString();
            },
            // 读取cookie
            getCookie: function() {
                let that = this;
                if (document.cookie.length > 0) {
                    let arr = document.cookie.split("; "); //这里显示的格式需要切割一下自己可输出看下
                    for (let i = 0; i < arr.length; i++) {
                        let arr2 = arr[i].split("="); //再次切割
                        //判断查找相对应的值
                        if (arr2[0] == "account") {
                            that.formLogin.account = arr2[1]; //保存到保存数据的地方
                        } else if (arr2[0] == "password") {
                            that.formLogin.password = arr2[1];
                        }
                    }
                }
            },
            //清除cookie
            clearCookie: function() {
                this.setCookie("", "", -1); //修改两个值都为空，天数为-1天就好了
            },


            // 注册用户
            submitRegister() {
                let that = this;
                let params = {
                    name: that.formRegister.name,
                    account: that.formRegister.account,
                    password: that.formRegister.password,
                    sex: that.formRegister.sex,
                    grade: that.formRegister.grade
                };
                this.$axios
                    .post('/option/register', params)
                    .then(res => {
                        console.log(res);

                        that.formRegister = {};
                    })
                    .catch(function (err) {
                        console.log(err)
                    });
                console.log('注册成功！');
            }
        }
    }

</script>


<style scoped>
  .title {
    font-size: 46px;
  }

  .login_button {
    width: 360px;
    margin-top: 20px;
    font-size: 20px;
  }

  .login-input {
    width: 360px;
  }
</style>
