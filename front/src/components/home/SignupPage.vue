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
            <div :style="paddingTop">
                <el-card class="LoginPage-el-card-style">
                    <h1 class="SettingPage-setting-title-style">
                        注册
                    </h1>
                    <el-form :model="form" :rules="rules" ref="form">
                        <el-form-item prop="username">
                            <template v-slot:label>
                                用户
                            </template>
                            <el-input v-model="form.username">
                                <template #prefix>
                                    <el-icon><User /></el-icon>
                                </template>
                            </el-input>
                        </el-form-item>
                        <el-form-item prop="phoneNumber">
                            <template v-slot:label>
                                手机
                            </template>
                            <el-input v-model="form.phoneNumber">
                                <template #prefix>
                                    <el-icon><User /></el-icon>
                                </template>
                            </el-input>
                        </el-form-item>
                        <el-form-item prop="email">
                            <template v-slot:label>
                                邮箱
                            </template>
                            <el-input v-model="form.email">
                                <template #prefix>
                                    <el-icon><User /></el-icon>
                                </template>
                            </el-input>
                        </el-form-item>
                        <el-form-item prop="password">
                            <template v-slot:label>
                                密码
                            </template>
                            <el-input
                                v-model="form.password"
                                type="password"
                                show-password
                            >
                                <template #prefix>
                                    <el-icon><Lock /></el-icon>
                                </template>
                            </el-input>
                        </el-form-item>
                    </el-form>
                    <div class="SettingPage-input-div-style">
                        <el-row>
                            <el-col :span="16"></el-col>
                            <el-col :span="6">
                                <el-button
                                    class="SettingPage-input-button-style"
                                    type="danger"
                                    @click="switchSubmit"
                                >
                                    注册
                                </el-button>
                            </el-col>
                            <el-col :span="2"></el-col>
                        </el-row>
                    </div>
                </el-card>
            </div>
        </el-col>
        <el-col :span="8"></el-col>
    </el-row>
</template>

<script>
import { sign } from '@/axios/api/user'

export default
{
    name: 'SignupPage',
    data()
    {
        return{
            paddingTop: "padding-top:" + ((window.innerHeight - 360) / 2) + "px;",
            form:
            {
                username: '',
                phoneNumber: '',
                email: '',
                password: '',
            },
            submitDialogVisible: false,
            mailInput: '',
            codeInput: '',
            rules:
            {
                username: [{required: true, message: '不能为空'}],
                phoneNumber: 
                [
                    {required: true, message: '不能为空'},
                    {pattern: /^1[3-9]\d{9}$/, message: '请输入正确的手机号', trigger: ['blur', 'change']}
                ],
                email:
                [
                    {required: true, message: '不能为空'},
                    {type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change']}
                ],
                password: [{required: true, message: '不能为空'}],
            },
        }
    },
    mounted()
    {
        window.addEventListener('resize',() =>
            this.paddingTop = "padding-top:" + ((window.innerHeight - 360) / 2) + "px;",
        )
    },
    methods:
    {
        switchSubmit()
        {
            this.$refs['form'].validate((valid) => {
                if(valid)
                {
                    sign({ username: this.form.username,password: this.form.password }).then(function(resp){
                        if(resp.data.code == 200)
                        {
                            _this.$message.success({message: "注册成功",})
                            _this.$router.push('/Login')
                        }
                        else if(resp.data.code == 400)
                        {
                            _this.$message.error({message: "用户名已被注册",})
                        }
                        else
                        {
                            _this.$message.error({message: "服务器错误",})
                        }
                    })
                }
                else
                {
                    return
                }
            })
        },
        clickBack()
        {
            this.$router.push('/Personal')
        },
    },
    created()
    {
        setTimeout( () => { this.bottomData = 'bottom: 60px' },100)
    }
}
</script>

<style>
.SettingPage-image-anger-style
{
    width: 256px;
    position: absolute;
    left: 0px;
    transition: 0.5s bottom;
}

.el-input__wrapper.is-focus
{
    box-shadow: 0 0 0 1px #ff8f8f;
}

.el-input-group__append
{
    box-shadow: 0 0 0 1px #ff8f8f;
}

.SettingPage-input-div-style
{
    margin-top: 20px;
}

.SettingPage-input-button-style
{
    width: 100%;
    background-color: rgba(255,255,255,0.85);
    font-weight: bold;
    color: #ff6666;
}

.SettingPage-setting-title-style
{
    color: #ff6666;
    margin-left: 50px;
    font-weight: bolder;
    font-size: 36px;
    -webkit-text-stroke: 1px #000000;

}

html.dark .SettingPage-input-button-style
{
    background-color: rgba(0,0,0,0.85);
}

html.dark .SettingPage-setting-title-style
{
    -webkit-text-stroke: 1px #ffffff;
}

.SignupPage-input-div-style
{
    margin-top: 10px;
}

.SignupPage-image-anger-style
{
    width: 300px;
    position: absolute;
    left: 64px;
    transition: 0.5s bottom;
}

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