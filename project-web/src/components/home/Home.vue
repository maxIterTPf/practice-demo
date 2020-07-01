<template>
  <el-container>
    <el-header>
      欢迎来到魑魅魍魉网
    </el-header>
    <el-main>
      <el-link type="primary" @click="toClick()">去登陆</el-link>
    </el-main>

    <el-footer>
    </el-footer>

  </el-container>
</template>

<script>
    export default {
        name: "Home",
        data() {
            return {
            }
        },

        methods: {
            toClick() {
                this.$router.push({path:'Login'});
            }
        }
    }
</script>

<style scoped>
  .el-container {
    font-size: 60px;
    color: rgba(255, 56, 51, 0.68);
    margin-top: 150px;
  }
  .el-link {
    margin-top: 60px;
    font-size: 32px;
  }
</style>
