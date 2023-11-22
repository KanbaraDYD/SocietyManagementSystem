<template>
    <div class="ManageIndex-out-div">
        <el-card class="ManageIndex-el-card" @mouseover="mouseOver(0)" @mouseleave="mouseLeave(0)" :style="back0">
            <h1>后台管理页面</h1>
            <p>这里是后台管理页面</p>
        </el-card>
        <el-card class="ManageIndex-el-card">
            <el-row>
                <el-col :span="15">
                    <div class="ManageIndex-number-show-div">
                        <el-row>
                            <el-col :span="12">
                                <el-card @mouseover="mouseOver(1)" @mouseleave="mouseLeave(1)" :style="back1">
                                    <p class="ManageIndex-number-title">访问次数</p>
                                    <p class="ManageIndex-number-text">
                                        {{ visitShowNumber.toFixed(0) }}
                                    </p>
                                    <p class="ManageIndex-number-unit">次</p>
                                </el-card>
                            </el-col>
                            <el-col :span="12">
                                <el-card @mouseover="mouseOver(2)" @mouseleave="mouseLeave(2)" :style="back2">
                                    <p class="ManageIndex-number-title">注册用户</p>
                                    <p class="ManageIndex-number-text">
                                        {{ userShowNumber.toFixed(0) }}
                                    </p>
                                    <p class="ManageIndex-number-unit">人</p>
                                </el-card>
                            </el-col>
                        </el-row>
                        <el-row>
                            <el-col :span="12">
                                <el-card @mouseover="mouseOver(3)" @mouseleave="mouseLeave(3)" :style="back3">
                                    <p class="ManageIndex-number-title">运行时间</p>
                                    <p class="ManageIndex-number-text">
                                        {{ timeShowNumber.toFixed(0) }}
                                    </p>
                                    <p class="ManageIndex-number-unit">天</p>
                                </el-card>
                            </el-col>
                            <el-col :span="12">
                                <el-card @mouseover="mouseOver(4)" @mouseleave="mouseLeave(4)" :style="back4">
                                    <p class="ManageIndex-number-title">菜单点击</p>
                                    <p class="ManageIndex-number-text">
                                        {{ pageShowNumber.toFixed(0) }}
                                    </p>
                                    <p class="ManageIndex-number-unit">次</p>
                                </el-card>
                            </el-col>
                        </el-row>
                    </div>
                </el-col>
                <el-col :span="9">
                    <p class="ManageIndex-chart-show-text">页面访问</p>
                    <div id="echarts-visit-chart" />
                    
                </el-col>
            </el-row>
        </el-card>
    </div>
</template>

<script>
import gsap from "gsap"

export default
{
    name: 'ManageIndex',
    data() {
        return {
            num: 0,
            visitShowNumber: 0,
            userShowNumber: 0,
            timeShowNumber: 0,
            pageShowNumber: 0,
            visitChangeNumber: 0,
            userChangeNumber: 0,
            timeChangeNumber: 0,
            pageChangeNumber: 0,
            chartData: [],
            back0: '',
            back1: '',
            back2: '',
            back3: '',
            back4: '',
        }
    },
    watch:
    {
        visitChangeNumber(newValue)
        {
            gsap.to(this,{
                duration: 1,
                visitShowNumber: newValue,
            })
        },
        userChangeNumber(newValue)
        {
            gsap.to(this,{
                duration: 1,
                userShowNumber: newValue,
            })
        },
        timeChangeNumber(newValue)
        {
            gsap.to(this,{
                duration: 1,
                timeShowNumber: newValue,
            })
        },
        pageChangeNumber(newValue)
        {
            gsap.to(this,{
                duration: 1,
                pageShowNumber: newValue,
            })
        },
    },
    created()
    {
        this.visitChangeNumber = 114514
        this.userChangeNumber = 1145
        this.timeChangeNumber = 66
        this.pageChangeNumber = 191981

        this.chartData = [
            { value: 1048, name: '主页' },
            { value: 735, name: '社团' },
            { value: 580, name: '资源' },
            { value: 484, name: '论坛' },
            { value: 300, name: '个人' }
        ]


    },
    mounted()
    {
        this.drawEcharts()
    },
    methods:
    {
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
                        { value: 1048, name: '主页' },
                        { value: 735, name: '社团' },
                        { value: 580, name: '资源' },
                        { value: 484, name: '论坛' },
                        { value: 300, name: '个人' }
                      ]
                    }
                  ]  
            })
        },
        mouseOver(num)
        {
            if(num == 0)
            {
                this.back0 = "background-color: rgba(255,143,143,0.5);"
            }
            else if(num == 1)
            {
                this.back1 = "background-color: rgba(255,143,143,0.5);"
            }
            else if(num == 2)
            {
                this.back2 = "background-color: rgba(255,143,143,0.5);"
            }
            else if(num == 3)
            {
                this.back3 = "background-color: rgba(255,143,143,0.5);"
            }
            else if(num == 4)
            {
                this.back4 = "background-color: rgba(255,143,143,0.5);"
            }
        },
        mouseLeave(num)
        {
            if(num == 0)
            {
                this.back0 = ''
            }
            else if(num == 1)
            {
                this.back1 = ''
            }
            else if(num == 2)
            {
                this.back2 = ''
            }
            else if(num == 3)
            {
                this.back3 = ''
            }
            else if(num == 4)
            {
                this.back4 = ''
            }
        }
    },

}
</script>

<style scope>
.ManageIndex-out-div 
{
    display: flex;
    flex-wrap: wrap;
}

.ManageIndex-in-div
{
    width: 100%;
}

.ManageIndex-el-card
{
    width: 100%;
    margin: 10px;
    font-weight: bold;
    background-color: rgba(0,0,0,0);
}

.ManageIndex-number-show-div .el-card
{
    background-color: rgba(0,0,0,0);
    margin: 5px;
}

.ManageIndex-number-title
{
    margin: 0;
}

.ManageIndex-number-text
{
    font-size: 32px;
    margin: 0;
    text-align: center;
}

.ManageIndex-number-unit
{
    float: right;
    font-size: 10px;
    margin: 0;
}

#echarts-visit-chart
{
    height: 240px;
}

.ManageIndex-chart-show-text
{
    float: right;
    margin-top: 200px;
}
</style>