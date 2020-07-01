<template>
  <div id="app">
<!--    <img src="./assets/logo.png">-->
    <router-view/>  <!--自动去加载路由，加载的路由渲染到此处-->
  </div>

</template>

<script>
export default {
  name: 'App',
    mounted() {
        // document.body.style.backgroundColor="#a5ffff";
        document.body.style.backgroundColor="rgba(171, 224, 224, 0.98)";
    },
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 2px;
}
</style>
