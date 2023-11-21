<template>
  <body id="AppBody-background-style" :style="fire">
    <nav-menu />
    <div class="AppBody-allBody-div-style">
      <router-view/>
    </div>
  </body>
</template>

<script>
import NavMenu from '@/components/common/NavMenu'
import nightImage from '@/assets/webp/background/night.webp'

export default
{
  name: 'AppBody',
  components:{ NavMenu },
  data()
  {
    return{
      fire: {backgroundImage: 'url(' + nightImage + ')'},
    }
  },
}
</script>

<style>
body
{
  margin: 0;
}

#AppBody-background-style
{
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}

.AppBody-allBody-div-style
{
  width: 100%;
  height: 100%;
  
}
</style>