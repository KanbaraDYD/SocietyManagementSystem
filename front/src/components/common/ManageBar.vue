<template>
    <el-menu
        mode="horizontal"
        background-color="rgba(0,0,0,0.8)"
        active-text-color="#ff5f5f"
    >
        <el-image
            :src="SRICNavLogo"
            class="NavMenu-SRIC-Navlogo-style"
            @click="switchSetting()"
        ></el-image>
    </el-menu>
</template>

<script>
export default
{
    name: 'ManageBar',
    data()
    {
        return{
            SRICNavLogo: require('@/assets/images/logo.png'),
        }
    },
    methods:
    {
        switchSetting()
        {
            this.$router.push('/')
        },
    },
}
</script>

<style>
.el-menu
{
    z-index: 99;
}

.NavMenu-SRIC-Navlogo-style
{
    height: 50px;
    margin: 5px 10px 5px 10px;
}

.NavMenu-right-div-style
{
    flex-grow: 1;
}

.NavMenu-el-readio
{
    font-weight: bold;
}

.NavMenu-menu-text-style
{
    font-size: 16px;
    font-weight: bold;
}

.NavMenu-el-button-style
{
    margin-top: 10px;
}

.NavMenu-tooltip-p-style
{
    text-align: center;
    margin: 0;
    font-size: 12px;
    font-weight: bold;
}

.NavMenu-el-icon-style
{
    color: #000000;
}

.NavMenu-float-div-style
{
    color: rgba(0, 0, 0, 0.5);
    font-weight: bold;
    position: absolute;
    z-index: 100;
}

html.dark .el-menu
{
    background-color: rgba(0,0,0,0.64);
}

html.dark .NavMenu-menu-text-style
{
    color: #ffffff;
}

html.dark .NavMenu-el-icon-style
{
    color: #ffffff;
}

html.dark .NavMenu-float-div-style
{
    color: #ffffff;
}

.el-affix
{
    height: 0;
}

.el-radio__input.is-checked + .el-radio__label 
{
    color: #ff5f5f !important;
}

.el-radio__input.is-checked .el-radio__inner 
{
    background: #ff5f5f !important;
    border-color: #ff5f5f !important;
}

.el-radio-group
{
    display: flex;
    flex-flow: column nowrap;
    align-items: flex-start;
}

.common-with-back-el-card-style .el-card__body
{
    background: url("@/assets/webp/background/warma-lie.webp"),rgba(255,255,255,0);
    background-size: 100px 100px;
    background-repeat: no-repeat;
    background-position: right top;
}

.common-with-back-el-card-style
{
    margin-top: 10px;
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

</style>