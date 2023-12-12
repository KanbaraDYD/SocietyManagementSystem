<template>
    <el-image
        class="PersonalIndex-image-anger-style"
        :src="game"
        :style="leftData"
    ></el-image>
    <div class="PersonalIndex-affix-div-style">
        <el-affix>
            <el-button 
            v-if="userId == null"
            @click="switchLogin"
            color="#ff6666" 
            class="PersonalIndex-affix-button-style" 
            plain>
            <el-icon class="PersonalIndex-affix-icon-style"><User/></el-icon>
            登录
            </el-button>
            <el-button 
            v-if="userId == null"
            @click="switchSignup"
            color="#ff6666" 
            class="PersonalIndex-affix-button-style" 
            plain>
            <el-icon class="PersonalIndex-affix-icon-style"><EditPen/></el-icon>
            注册
            </el-button>
            <el-button 
            v-if="userId != null"
            @click="switchQuit"
            color="#ff6666" 
            class="PersonalIndex-affix-button-style" 
            plain>
            <el-icon class="PersonalIndex-affix-icon-style"><Operation/></el-icon>
            退出登录
            </el-button>
        </el-affix>
    </div>
    <div class="PersonalIndex-avater-div-style" :style="paddingTop">
        <el-avatar :src="require('@/assets/webp/avatar/' + avatar)" :size="150" fit="scale-down"></el-avatar>
        <p class="PersonalIndex-name-style">{{ username }}</p>
        <el-tag
        v-for="(item,i) in tags"
        :key="i"
        effect="light"
        type="danger"
        size="small"
        class="PersonalIndex-el-tag-style"
        >
        {{ item.content }}
        </el-tag>
        <p class="PersonalIndex-mark-style">{{ mark }}</p>
    </div> 
</template>

<script>
import { getUserById } from '@/axios/api/user'

export default
{
    name: 'RersonalIndex',
    data()
    {
        return{
            game: require('@/assets/webp/background/game.webp'),
            avatar: 'head-main.webp',
            username: '未登录',
            paddingTop: "padding-top:" + ((window.innerHeight - 360) / 2) + "px;",
            tags: [
                {
                    content: "游客",
                },
                {
                    content: "学生",
                },
            ],
            mark: "请先登录以查看个人信息",
            userId: localStorage.getItem('userId'),
            leftData: 'left: -400px',
        }
    },
    methods:
    {
        switchLogin()
        {
            this.leftData = 'left: -500px'
            setTimeout( () => { this.$router.push('/Login') },256)//延迟跳转 播放动画
        },
        switchQuit()
        {
            this.leftData = 'left: -500px'
            localStorage.removeItem('userId')
            this.$message.success({message: "退出成功",})
            this.username = '未登录'
            this.mark = "请先登录以查看个人信息"
            this.userId = null

        },
        switchSignup()
        {
            this.leftData = 'left: -500px'
            setTimeout( () => { this.$router.push('/Signup') },256)//延迟跳转 播放动画
        },
    },
    mounted()
    {
        //visitPage({ page: "personal" })
        window.addEventListener('resize',() =>
            this.paddingTop = "padding-top:" + ((window.innerHeight - 360) / 2) + "px;",
        )
    },
    created()
    {
        if(this.userId != null)
        {
            var _this = this
            getUserById({ id: this.userId }).then(function(resp){
                    _this.username = resp.data.username
                    _this.mark = resp.data.mark
            })
        }
    },
}
</script>

<style>
.PersonalIndex-image-anger-style
{
    height: 256px;
    position: absolute;
    bottom: 60px;
    transition: 0.5s left;
}

.PersonalIndex-affix-div-style
{
    text-align: right;
}

.PersonalIndex-affix-button-style
{
    margin-top: 10px;
    margin-right: 10px;
    margin-left: 0;
    background-color: rgba(255,255,255,0.64);
    font-weight: bold;
    color: #ff6666;
}

.PersonalIndex-affix-div-style .el-button+.el-button
{
    margin-left: 0;
}

.PersonalIndex-affix-icon-style
{
    margin-right: 10px;
}

.PersonalIndex-avater-div-style
{
    text-align: center;
    font-weight: bold;
}

.PersonalIndex-name-style
{
    font-size: 30px;
    margin-top: 10px;
    margin-bottom: 5px;
    color: #ffcccc;
    text-shadow: #000000 0 0 10px;
}

.PersonalIndex-el-tag-style
{
    margin-left: 5px;
    margin-right: 5px;
}

.PersonalIndex-mark-style
{
    margin-top: 10px;
    margin-bottom: 0;
    font-size: 10px;
    color: #ffcccc;
}

html.dark .PersonalIndex-affix-button-style
{
    background-color: rgba(0,0,0,0.64);
}
</style>