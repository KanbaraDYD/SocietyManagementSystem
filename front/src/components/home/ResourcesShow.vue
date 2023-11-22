<template>
    <el-button @click="clickBack" color="#ff6666" class="SafetyPage-back-button-style" plain>
        <el-icon class="SafetyPage-back-icon-style">
            <ArrowLeftBold />
        </el-icon>
        返回
    </el-button>
    <div>
        <h1 class="ResourcesShow-h1-text" :style="[h1Top, h1Left]">
            {{ resources.title }}
        </h1>
        <div class="ResourcesShow-tag-div" :style="[divTop, divLeft]">
            <el-tag checked size="small" class="ResourcesCard-el-tag-style" type="success" effect="dark">{{ resources.tag
            }}</el-tag>
            <el-icon size="10px" class="ResourcesShow-el-icon-style">
                <Histogram />
            </el-icon>
            <span class="ResourcesShow-tag-text-style">访问次数： {{ resources.visited }}</span>
        </div>
        <h3 class="ResourcesShow-h3-text" :style="[h3Top, h3Left]">
            {{ resources.description }}
        </h3>
        <el-button @click="clickDownload" color="#ff6666" class="ResourcesShow-back-button-style" plain
            :style="[buttonTop, buttonLeft]">
            <el-icon class="ResourcesShow-back-icon-style">
                <Download />
            </el-icon>
            下载
        </el-button>
    </div>
</template>

<script>
export default
    {
        name: 'ResourcesShow',
        data() {
            return {
                resources: [],
                h1Top: 'top:' + (window.innerHeight / 2 - 120) + 'px;',
                h1Left: 'left:' + -500 + 'px',
                divTop: 'top:' + (window.innerHeight / 2 - 120) + 'px;',
                divLeft: 'left:' + window.innerWidth + 'px',
                h3Top: 'top:' + (window.innerHeight / 2 - 110) + 'px;',
                h3Left: 'left:' + -500 + 'px',
                buttonTop: 'top:' + (window.innerHeight / 2 - 100) + 'px;',
                buttonLeft: 'left:' + window.innerWidth + 'px',
                bottomData: 'bottom:' + -480 + 'px;'
            }
        },
        created() {
            this.resources =
                    {
                        id: 1,
                        title: '资源1',
                        visited: 114514,
                        description: '资源1的奇妙描述',
                        tag: '社团资源',
                    },
            setTimeout(() => {
                this.h1Left = 'left:' + (window.innerWidth / 2) + 'px'
                this.divLeft = 'left:' + (window.innerWidth / 2 + 100) + 'px'
                this.h3Left = 'left:' + (window.innerWidth / 2 - 50) + 'px'
                this.buttonLeft = 'left:' + (window.innerWidth / 2 + 300) + 'px'
                this.bottomData = 'bottom:' + 60 + 'px;'
            }, 100)

        },
        methods:
        {
            clickDownload() {

            },
            clickBack() {
                this.h1Left = 'left:' + -500 + 'px'
                this.divLeft = 'left:' + window.innerWidth + 'px'
                this.h3Left = 'left:' + -500 + 'px'
                this.buttonLeft = 'left:' + window.innerWidth + 'px'
                this.bottomData = 'bottom:' + -480 + 'px;'
                setTimeout(() => {
                    this.$router.go(-1)
                }, 450)
            },
        }
    }
</script>

<style scoped>
.NotesCard-el-icon-style
{
    color: #333333;
    margin-right: 5px;
}

.NotesCard-tag-text-style
{
    font-size: 10px;
    color: #333333;
}

html.dark .NotesCard-el-icon-style
{
    color: white;
}

html.dark .NotesCard-tag-text-style
{
    color: white;
}

.el-loading-spinner .path
{
    stroke: #ff5f5f;
}

.el-loading-spinner .el-loading-text
{
    color: #ff5f5f;
    font-weight: bold;
    font-size: 20px;
}

.ResourcesCard-el-tag-style
{
    margin-right: 10px;
    font-weight: bold;
}

.ResourcesShow-image-style
{
    width: 480px;
    position: absolute;
    left: 0px;
    transition: 0.8s bottom;
}

.ResourcesShow-h1-text
{
    position: relative;
    font-size: 50px;
    margin: 0;
    color: #ffffff;
    text-shadow: #ff5f5f 0px 0 10px;
    transition: 1s left ease;
}

.ResourcesShow-tag-div
{
    position: relative;
    transition: 1s left ease;
}

.ResourcesShow-el-icon-style
{
    margin-right: 5px;
    color: #ffffff;
    text-shadow: #ff5f5f 0px 0 10px;
}

.ResourcesShow-tag-text-style
{
    font-size: 10px;
    color: #ffffff;
    text-shadow: #ff5f5f 0px 0 10px;
}

.ResourcesShow-back-icon-style
{
    margin-right: 10px;
}

.ResourcesShow-back-button-style
{
    background-color: rgba(255,255,255,0.64);
    font-weight: bold;
    color: #ff6666;
    position: relative;
    transition: 1s left ease;
}

html.dark .ResourcesShow-back-button-style
{
    background-color: rgba(0,0,0,0.64);
}

.ResourcesShow-h3-text
{
    position: relative;
    font-size: 25px;
    margin: 0;
    color: #ffffff;
    text-shadow: #ff5f5f 0px 0 10px;
    transition: 1s left ease;
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
    background: url("@/assets/webp/background/yiyu.webp"),rgba(255,255,255,0);
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