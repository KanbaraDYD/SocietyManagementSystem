<template>
    <div class="ManageMenu-menu-div">
        <el-menu
            router
            class="ManageMenu-el-menu"
            background-color="rgba(255,255,255,0.5)"
            text-color="#ffffff"
            active-text-color="#ff8f8f"
            :default-active="defaultActive"
            :collapse="isCollapse"
        >
            <el-menu-item @click="clickChange()" class="ManageMenu-menu-text-style">
                <el-icon class="ManageMenu-el-icon">
                    <component :is="buttonIcon"></component>
                </el-icon>
                <template #title>菜单折叠</template>
            </el-menu-item>
            <el-menu-item
                v-for="(item, i) in navList"
                :index="item.name"
                :key="i"
                class="ManageMenu-menu-text-style"
            >
                <el-icon>
                    <component :is="item.icon"></component>
                </el-icon>
                <template #title>{{ item.navItem }}</template>
            </el-menu-item>
        </el-menu>
    </div>
</template>

<script>
export default
{
    name: 'ManageMenu',
    data()
    {
        return{
            isCollapse: false,
            defaultActive: '',
            buttonIcon: 'ArrowLeftBold',
            navList: 
            [
                {
                    id: 0,
                    name: 'manageIndex',
                    navItem: '后台管理',
                    icon: 'Menu',
                },
            ],
        }
    },
    methods:
    {
        clickChange()
        {
            if(this.isCollapse == false)
            {
                this.isCollapse = true
                this.buttonIcon = 'ArrowRightBold'
            }
            else
            {
                this.isCollapse = false
                this.buttonIcon = 'ArrowLeftBold'
            }

        }
    },
    created()
    {
        this.defaultActive = this.$route.name;
    },
}
</script>

<style scope>
.ManageMenu-el-menu:not(.el-menu--collapse) 
{
    width: 200px;
}

.ManageMenu-el-menu
{
    min-height: 1000px;
    float: left;
}

.ManageMenu-menu-div .el-menu 
{
    background-color: rgba(0,0,0,0.05);
}

html.dark .ManageMenu-menu-div .el-menu 
{
    background-color: rgba(0,0,0,0.32);
}

.ManageMenu-menu-text-style
{
    font-size: 16px;
    font-weight: bold;
}

.el-icon.ManageMenu-el-icon
{
    color: black;
}

html.dark .el-icon.ManageMenu-el-icon
{
    color: white;
}

.el-popper
{
    font-weight: bold;
}

.el-menu-item
{
    color: black;
}

html.dark .el-menu-item
{
    color: white;
}

.el-menu-item.is-active {
    color: var(--el-menu-active-color) !important;
}
</style>