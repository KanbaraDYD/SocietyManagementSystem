<template>
    <el-image class="AppIndex-backTop-image-style" :src="backTop" @click="backToTop()" :style="bottomData"></el-image>
        <el-row>
            <el-col :span="1"></el-col>
            <el-col :span="5">
                    <el-card
                        class="NotesAside-el-card-style"
                        :style="describeBackgrounds"
                        @mouseover="describeOver()"
                        @mouseleave="describeLeave()"
                    >
                        <h1 class="common-text-style" style="margin-top: 64px">
                            社团
                        </h1>
                        <el-divider class="common-el-divider-style" />
                        <h1>{{ societyTitle }}</h1>
                        <h5>访问次数： {{ societyVisited }}</h5>
                        <h3>{{ societyDescription }}</h3>
                    </el-card>
            </el-col>
            <el-col :span="12">
                <el-scrollbar
                    @scroll="handleScroll($event)"
                    ref="indexScroll"
                    :height="indexHeight"
                >
                    <el-card
                        class="common-with-back-el-card-style"
                        :style="backgrounds"
                        @mouseover="over()"
                        @mouseleave="leave()"
                    >
                    <h1>内容</h1>
                    <p>我应该在这里说点什么</p>
                    <p>因为这里是搞机社的页面</p>
                    <p>但是什么都没有</p>
                    <el-divider></el-divider>
                    <h1>fahuifhasuif</h1>
                    <p>dwadawdasd</p>
                    <p>fafwafwafwwafafawf</p>
                    <p>dadfwfw</p>
                    <p>fabfjnbfiwjfiojfioakf</p>
                    <el-divider></el-divider>
                    <h1>fahuifhasuif</h1>
                    <p>dwadawdasd</p>
                    <p>fafwafwafwwafafawf</p>
                    <p>dadfwfw</p>
                    <p>fabfjnbfiwjfiojfioakf</p>
                    </el-card>
                </el-scrollbar>
            </el-col>
            <el-col :span="5">
                <el-card
                        class="NotesAside-el-card-style"
                        :style="describeBackgrounds"
                        @mouseover="describeOver()"
                        @mouseleave="describeLeave()"
                    >
                    <h1>成员分布</h1>
                    <div id="echarts-visit-chart" />
                    </el-card>
            </el-col>
            <el-col :span="1"></el-col>
        </el-row>
    </template>
    
    <script>
let isMore = 0;

export default
{
    name: 'NotesShow',
    data()
    {
        return{
            indexHeight: (window.innerHeight - 70) + 'px',
            backgrounds: '',
            describeBackgrounds: '',
            societyTitle: '搞机社',
            societyDescription: '搞机社的奇妙描述',
            societyVisited: '1145',
            backTop: require('@/assets/webp/background/backTop.webp'),
            data: 0,
            bottomData: 'bottom: ' + (window.innerHeight + 100) + 'px',
        }
    },
    methods:
    {
        over()
        {
            this.backgrounds = "background: rgba(255,255,255,0.85);"
        },
        leave()
        {
            this.backgrounds = ''
        },
        describeOver()
        {
            this.describeBackgrounds = "background: rgba(255,255,255,0.85);"
        },
        describeLeave()
        {
            this.describeBackgrounds = ''
        },
        backToTop()
        {
            this.$refs.indexScroll.scrollTo({top: 0, behavior: 'smooth'})
            this.bottomData = 'bottom: ' + (window.innerHeight + 100) + 'px'
        },
        handleScroll(e)
        {
            this.data = e.scrollTop
            if(this.data > 300 && isMore == 0)
            {
                this.bottomData = 'bottom: 75px'
                isMore = 1
            }
            if(this.data < 300)
            {
                this.bottomData = 'bottom: ' + (window.innerHeight + 100) + 'px'
                isMore = 0;
            }
        },
        drawEcharts() {
            let echartsBackground = this.$echarts.init(document.getElementById('echarts-visit-chart'))
            echartsBackground.setOption({
                tooltip: {
                    trigger: 'item'
                  },
                  series: [
                    {
                      type: 'pie',
                      radius: ['40%', '70%'],
                      avoidLabelOverlap: false,
                      itemStyle: {
                        borderRadius: 10,
                        borderColor: '#fff',
                        borderWidth: 2
                      },
                      label: {
                        show: false,
                        position: 'center'
                      },
                      emphasis: {
                        label: {
                          show: true,
                          fontSize: 32,
                          fontWeight: 'bold'
                        }
                      },
                      labelLine: {
                        show: false
                      },
                      data: 
                      [
                        { value: 1, name: '社长' },
                        { value: 2, name: '副社长' },
                        { value: 4, name: '管理员' },
                        { value: 15, name: '成员' },
                      ]
                    }
                  ]  
            })
        },
    },
    mounted()
    {
        window.onresize = () => 
        {
            this.indexHeight = (window.innerHeight - 70) + 'px'
        }
        this.drawEcharts()
    },
}
    </script>
    
    <style>
    .common-with-back-el-card-style .el-card__body
{
    background: rgba(255,255,255,0);
    background-size: 100px 100px;
    background-repeat: no-repeat;
    background-position: right top;
}

.common-with-back-el-card-style
{
    height: 100%;
    margin-top: 10px;
    margin-right: 10px;
    background: rgba(255,255,255,0.64);
}

.common-text-style
{
    color: #333333;
    font-weight: bold;
    margin: 5px auto;
    margin-left: 10px;
    white-space: pre-wrap;
}

.common-el-divider-style
{
    border: 0px;
    background-color: #888888;
    padding-top: 1px;
}

html.dark .common-with-back-el-card-style
{
    background: rgba(0,0,0,0.64);
}

html.dark .common-text-style
{
    color: #ffffff;
}

html.dark .common-el-divider-style
{
    background-color: #ffffff;
}

.el-main
{
    padding: 0%;
}

.container
{
    width: 100%;
    height: 200px;
    position: fixed;
    z-index: -1;
    opacity: 0.37;
    bottom: 0;
    left: 0;
}

.AppIndex-backTop-image-style
{
    height: 150px;
    width: 150px;
    position: absolute;
    right: 10px;
    z-index: 99;
    transition: 0.5s bottom ease;
}

.AppIndex-tooltip-p-style
{
    text-align: center;
    margin: 0;
    font-size: 5px;
    font-weight: bold;
}

.NotesAside-el-card-style
{
    margin-top: 10px;
    margin-right: 10px;
    background: rgba(255,255,255,0.64);
}

.NotesAside-el-card-style .el-card__body
{
    background: rgba(255,255,255,0);
    background-size: 138px 145px;
    background-repeat: no-repeat;
    background-position: right top;
}

.NotesAside-item-card-style
{
    background: rgba(255,255,255,0);
    border: solid;
    color: #333333;
    margin-bottom: 10px;
    font-weight: bold;
}

.NotesAside-item-card-style .el-card__body
{
    background: rgba(255,255,255,0);
    padding: 10px;
}

html.dark .NotesAside-el-card-style
{
    background: rgba(0,0,0,0.64);
}

html.dark .NotesAside-el-card-style .el-card__body
{
    background: rgba(255,255,255,0);
    background-size: 138px 145px;
    background-repeat: no-repeat;
    background-position: right top;
}

html.dark .NotesAside-item-card-style
{
    background: rgba(255,255,255,0);
    border: solid;
    color: #ffffff;
    margin-bottom: 10px;
}

html.dark .NotesAside-item-card-style .el-card__body
{
    background: rgba(255,255,255,0);
}

.v-md-editor
{
    background: rgba(255,255,255,0);
}

.v-md-pre-wrapper
{
    background-color: rgba(255,255,255,0.85) !important;
    border-radius: 10px;
}

.github-markdown-body h1
{
    border-bottom: 0;
}

.github-markdown-body h2
{
    border-bottom: 0;
}

#echarts-visit-chart
{
    height: 240px;
}
    </style>