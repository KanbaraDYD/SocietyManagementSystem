const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,
  publicPath: '/',
  outputDir: 'dist',
  assetsDir: "statics",
  productionSourceMap: process.env.NODE_ENV !== 'production' ? false : true,
  /* webpack-dev-server 相关配置 */
  devServer:
  {
    /* 使用代理 */
    proxy:
    {
      '/api':
      {
        target: 'http://localhost:8088',  // 目标代理服务器地址
        changeOrigin: true,                          // 允许跨域
      },
    },
    port: 8081
  },
})
