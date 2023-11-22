<template>
    <body id="ManageBody-body-id">
        <div id="echarts-background-text"></div>
        <manage-bar />
        <manage-menu />
        <div>
        <router-view />
        </div>

    </body>
</template>

<script>
import ManageBar from '@/components/common/ManageBar'
import ManageMenu from '@/components/common/ManageMenu'

export default
    {
        name: 'ManageBody',
        components: { ManageBar,ManageMenu },
        data() {
            return {

            }
        },
        mounted() {
            this.drawEcharts()
        },
        methods:
        {
            drawEcharts() {
                let echartsBackground = this.$echarts.init(document.getElementById('echarts-background-text'))
                echartsBackground.setOption({
                    graphic: {
                        elements: [
                            {
                                type: 'text',
                                left: 'center',
                                top: 'center',
                                style: {
                                    text: '社团管理系统 管理面板',
                                    fontSize: 100,
                                    fontWeight: 'bold',
                                    lineDash: [0, 200],
                                    lineDashOffset: 0,
                                    fill: 'transparent',
                                    stroke: '#ff8f8f',
                                    lineWidth: 1
                                },
                                keyframeAnimation: 
                                {
                                    duration: 20000,
                                    loop: true,
                                    keyframes: 
                                    [
                                        {
                                            percent: 0,
                                            style: {
                                                lineDashOffset: 0,
                                                lineDash: [0, 200]
                                            }
                                        },
                                        {
                                            percent: 0.6,
                                            style: {
                                                fill: 'rgba(255,255,255,0)',
                                                lineDashOffset: 200,
                                                lineDash: [200, 0]
                                            }
                                        },
                                        {
                                            percent: 0.65,
                                            style: {
                                                fill: 'rgba(255,255,255,0)'
                                            }
                                        },
                                        {
                                            percent: 0.7,
                                            style: {
                                                fill: '#ff8f8f',
                                            }
                                        },
                                        {
                                            percent: 0.85,
                                            style: {
                                                fill: '#ff8f8f',
                                                stroke: '#ff8f8f',
                                            }
                                        },
                                        {
                                            percent: 0.9,
                                            style: {
                                                fill: 'rgba(255,255,255,0)',
                                                stroke: 'rgba(255,255,255,0)',
                                            }
                                        },
                                        {
                                            percent: 1,
                                            style: {
                                                fill: 'rgba(255,255,255,0)',
                                            }
                                        },
                                    ]
                                }
                            }
                        ]
                    }
                })
            }
        },
    }
</script>

<style>
#ManageBody-body-id
{
    height: 100%;
    width: 100%;
    background-size: cover;
    position: fixed;
}

body
{
  margin: 0;
}

#echarts-background-text
{
    height: 100%;
    width: 100%;
    position: absolute;
    background: #ffffff;
    z-index: -1;
}

html.dark #echarts-background-text
{
    background: #333333;
}
</style>