<template>
    <el-row>
        <el-col :span="1"></el-col>
        <el-col :span="5">
            <el-card class="NotesAside-el-card-style" :style="active">
                <h1 class="common-text-style" style="margin-top: 64px">分类</h1>
                <el-divider class="common-el-divider-style" />
                <el-card v-for="(item, i) in category" :key="i" shadow="never" class="NotesAside-item-card-style"
                    :style="item.backgrounds" @mouseover="over(i)" @mouseleave="leave(i)" @click="choose(i)">
                    <el-icon size="20px" style="float:right">
                        <component :is="item.icon"></component>
                    </el-icon>
                    {{ item.content }}
                </el-card>
            </el-card>
        </el-col>
        <el-col :span="17">
            <el-scrollbar :height="scrollHeight">
                <el-card v-for="(item, i) in resources" :key="i" class="common-with-back-el-card-style" @click="clickCard(i)">
                    <h1 class="common-text-style">{{ item.title }}</h1>
                    <div>
                        <el-icon size="10px" class="NotesCard-el-icon-style">
                            <Histogram />
                        </el-icon>
                        <span class="NotesCard-tag-text-style">访问次数： {{ item.visited }}</span>
                    </div>
                    <el-divider class="common-el-divider-style" />
                    <p class="common-text-style">{{ item.description }}</p>
                </el-card>
            </el-scrollbar>

        </el-col>
        <el-col :span="1"></el-col>
    </el-row>
</template>

<script>
export default
    {
        name: 'ResourcesPage',
        data() {
            return {
                scrollHeight: window.innerHeight - 75,
                active: '',
                category:
                    [
                        {
                            id: 0,
                            content: "全部",
                            icon: "Menu",
                        },
                        {
                            id: -1,
                            content: "未分类",
                            icon: "QuestionFilled",
                        },
                    ],
                categoryNeed: '',
                resources: [
                    {
                        id: 1,
                        title: '资源1',
                        visited: 114514,
                        description: '资源1的奇妙描述',
                    },
                    {
                        id: 1,
                        title: '资源2',
                        visited: 114514,
                        description: '资源2的奇妙描述',
                    },
                    {
                        id: 1,
                        title: '资源3',
                        visited: 114514,
                        description: '资源3的奇妙描述',
                    },
                    {
                        id: 1,
                        title: '资源4',
                        visited: 114514,
                        description: '资源4的奇妙描述',
                    },
                    {
                        id: 1,
                        title: '资源5',
                        visited: 114514,
                        description: '资源5的奇妙描述',
                    },
                    {
                        id: 1,
                        title: '资源6',
                        visited: 114514,
                        description: '资源6的奇妙描述',
                    },
                    {
                        id: 1,
                        title: '资源7',
                        visited: 114514,
                        description: '资源7的奇妙描述',
                    },
                ],
            }
        },
        methods:
        {
            mouseOver() {
                this.active = 'background: rgba(255,255,255,0.85);'
            },
            mouseLeave() {
                this.active = ''
            },
            over(i) {
                this.category[i].backgrounds = "background: #ffcccc"
            },
            leave(i) {
                this.category[i].backgrounds = ''
            },
            choose(i) {
                if (this.category[i].id == 0) {
                    this.$emit('loadAllNotesFormAside')
                }
                else {
                    this.categoryNeed = this.category[i].id
                    this.$emit('loadNotesFromAside')
                }
            },
            clickCard(i) {
                localStorage.setItem('societyId', this.resources[i].id)
                this.$router.push('/societyShow')
            },
        },
        created() {
            // var _this = this
            // getAllNotesCategory().then(function(resp){
            //         for(let i = 0;i < resp.data.length;i++)
            //         {
            //             _this.category.push(resp.data[i])
            //         }
            // })
        },
        mounted()
        {
            window.onresize = () => 
            {
                this.scrollHeight = window.innerHeight - 75
            }
        }
    }
</script>
