<template>
    <el-button
        @click="clickBack"
        color="#ff6666"
        class="SafetyPage-back-button-style"
        plain
    >
        <el-icon class="SafetyPage-back-icon-style"><ArrowLeftBold /></el-icon>
        返回
    </el-button>
    <el-row>
        <el-col :span="8"></el-col>
        <el-col :span="8">
            <div :style="paddingTop" @mouseover="mouseOver" @mouseleave="mouseLeave">
                <el-card class="LoginPage-el-card-style" :style="active">
                    <div class="LoginPage-inside-div-style">
                        <h1 class="LoginPage-title-style">登录</h1>
                        <el-form>
                            <el-form-item>
                                <template v-slot:label>
                                    用户
                                </template>
                                <el-input v-model="form.username">
                                    <template #prefix>
                                        <el-icon><User /></el-icon>
                                    </template>
                                </el-input>
                            </el-form-item>
                            <el-form-item>
                                <template v-slot:label>
                                    密码
                                </template>
                                <el-input v-model="form.password" type="password" show-password>
                                    <template #prefix>
                                        <el-icon><Lock /></el-icon>
                                    </template>
                                </el-input>
                            </el-form-item>
                            <el-form-item>
                                <el-button 
                                @click="clickLogin"
                                size="small" 
                                class="LoginPage-submit-button-style" 
                                style="margin-left:40px" 
                                type="danger" 
                                plain>登录</el-button>
                                <el-button 
                                size="small" 
                                class="LoginPage-submit-button-style" 
                                type="danger" 
                                plain>忘记密码</el-button>
                            </el-form-item>
                        </el-form>
                    </div>
                </el-card>
            </div>
        </el-col>
        <el-col :span="8"></el-col>
    </el-row>
</template>

<script>
import { login } from '@/axios/api/user'

export default
{
    name: 'LoginPage',
    data()
    {
        return{
            paddingTop: "padding-top:" + ((window.innerHeight - 360) / 2) + "px;",
            form:
            {
                username: '',
                password: '',
            },
            active: '',
        }
    },
    methods:
    {
        mouseOver()
        {
            this.active = 'background: rgba(255,255,255,0.85);'
        },
        mouseLeave()
        {
            this.active = ''
        },
        clickLogin()
        {
            var _this = this
            login({ username: this.form.username,password: this.form.password }).then(function(resp){
                if(resp.data.code == 200)
                {
                    _this.$message.success({message: "登录成功",})
                    localStorage.setItem('userId',resp.data.id)
                    _this.$router.push('/Personal')
                }
                else if(resp.data.code == 400)
                {
                    _this.$message.error({message: "密码错误",})
                }
                else if(resp.data.code == 401)
                {
                    _this.$message.warning({message: "用户不存在",})
                }
                else
                {
                    _this.$message.error({message: "服务器错误",})
                }
            })
        },
        clickBack()
        {
            this.$router.push('/Personal')
        },
    },
    mounted()
    {
        window.addEventListener('resize',() =>
            this.paddingTop = "padding-top:" + ((window.innerHeight - 360) / 2) + "px;",
        )
    },
}
</script>


<style>
.LoginPage-el-card-style
{
    height: 100%;
    margin-top: 10px;
    background: rgba(255,255,255,0.64);
}

.LoginPage-el-card-style .el-card__body
{
    background: rgba(255,255,255,0);
    background-size: 300px 270px;
    background-repeat: no-repeat;
    background-position: right bottom;
}

.LoginPage-inside-div-style
{
    margin-left: 50px;
    margin-right: 50px;
}

.LoginPage-title-style
{
    text-align: center;
    color:#ff8888;
    text-shadow: 0 0 15px #000000;
}

.el-input__wrapper.is-focus
{
    box-shadow: 0 0 0 1px #ff8f8f;
}

.LoginPage-submit-button-style
{
    box-shadow: 0 0 0 1px #000000;
}

html.dark .LoginPage-el-card-style
{
    background: rgba(0,0,0,0.64);
}

html.dark .el-input__wrapper
{
    background-color: #000000;
}

.vue-auth-box_
{
    top: 50%;
    background: rgba(255,255,255,0.9)
}

html.dark .vue-auth-box_
{
    background: rgba(0,0,0,0.9);
}

.vue-auth-box_ .auth-control_ .range-box
{
    background: #ffffff;
}

html.dark .vue-auth-box_ .auth-control_ .range-box
{
    background: #000000;
}

.vue-auth-box_ .auth-control_ .range-box .range-slider
{
    background: #ff5f5f;
}

.vue-auth-box_ .auth-control_ .range-box .range-slider .range-btn
{
    background-color: #ffffff;
}

html.dark .vue-auth-box_ .auth-control_ .range-box .range-slider .range-btn
{
    background-color: #000000;
}

.SafetyPage-image-anger-style
{
    height: 512px;
    width: 512px;
    position: absolute;
    bottom: 64px;
    transition: 0.5s left;
}

.SafetyPage-inside-card-style
{
    background: rgba(255,255,255,0);
    border: solid;
}

.SafetyPage-inside-card-style .el-card__body
{
    background: rgba(255,255,255,0) !important;
    padding-top: 0px;
    padding-bottom: 10px;
}

.SafetyPage-outside-card-style
{
    height: 100%;
    background: rgba(255,255,255,0.64);
}

.SafetyPage-outside-card-style .el-card__body
{
    background: rgba(255,255,255,0);
    background-size: 300px 270px;
    background-repeat: no-repeat;
    background-position: right bottom;
    padding-top: 5px;
    padding-bottom: 5px;
}

.SafetyPage-h3-style
{
    margin-left: 10px;
    font-weight: bolder;
}

.SafetyPage-button-style
{
    width: 100%;
    background-color: rgba(255,255,255,0.85);
    font-weight: bold;
    color: #ff6666;
}

.SafetyPage-back-button-style
{
    margin-top: 10px;
    margin-left: 10px;
    background-color: rgba(255,255,255,0.64);
    font-weight: bold;
    color: #ff6666;
    position: absolute;
    z-index: 99;
}

.SafetyPage-back-icon-style
{
    margin-right: 10px;
}

html.dark .SafetyPage-outside-card-style
{
    background-color: rgba(0,0,0,0.85);
}

html.dark .SafetyPage-button-style
{
    background-color: rgba(0,0,0,0.85);
}

html.dark .SafetyPage-back-button-style
{
    background-color: rgba(0,0,0,0.64);
}
</style>