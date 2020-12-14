<template>
	<el-header id="st">
		<el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
			<el-menu-item index="树洞">树洞</el-menu-item>
			<el-submenu index="解压游戏">
				<template slot="title">解压游戏</template>
				<el-menu-item index="选项1">选项1</el-menu-item>
				<el-menu-item index="选项2">选项2</el-menu-item>
				<el-menu-item index="选项3">选项3</el-menu-item>
				<el-submenu index="选项4">
					<template slot="title">选项4</template>
					<el-menu-item index="选项1">选项1</el-menu-item>
					<el-menu-item index="选项2">选项2</el-menu-item>
					<el-menu-item index="选项3">选项3</el-menu-item>
				</el-submenu>
			</el-submenu>
			<el-menu-item index="朋友圈">朋友圈</el-menu-item>
			<el-menu-item index="在线心理按摩">在线心理按摩</el-menu-item>
			<!-- <el-menu-item index="订单管理"><a href="https://www.ele.me" target="_blank">订单管理</a></el-menu-item> -->
			<div class="block" style="margin-top: 5px;">
				<div style="float: right;">
					<el-dropdown @command="handleCommand">
						<span class="el-dropdown-link">
							<el-avatar :size="45" :src="headUrl"></el-avatar>
						</span>
						<el-dropdown-menu slot="dropdown">
							<el-dropdown-item command="个人信息">个人信息</el-dropdown-item>
							<el-dropdown-item command="帮助">帮助</el-dropdown-item>
							<el-dropdown-item command="退出">退出</el-dropdown-item>
							<el-dropdown-item command="设置" divided>设置</el-dropdown-item>
						</el-dropdown-menu>
					</el-dropdown>
				</div>
			</div>
		</el-menu>
		<el-dialog :visible.sync="infoVisible" width="50%" :before-close="handleClose">
			<span>昵称：{{userinfo.userNickName}}</span>
			<br/>
			<span>账号：{{userinfo.userId}}</span>
			<br/>
			<span>密码：{{userinfo.userPassword}}</span>
			<br/>
			<span>姓名：{{userinfo.userName}}</span>
			<br/>
			<span>余额：{{userinfo.userBalance}}</span>
			<br/>
			<span>性别：{{userinfo.userSex}}</span>
			<br/>
			<span>地址：{{userinfo.userLocation}}</span>
			<br/>
			<span>证件类型：{{userinfo.userDocumentType}}</span>
			<br/>
			<span>证件号：{{userinfo.userIdentificationNumber}}</span>
			<span slot="footer" class="dialog-footer">
				<el-button @click="infoVisible = false">取 消</el-button>
				<el-button type="primary" @click="infoVisible = false">确 定</el-button>
			</span>
		</el-dialog>
	</el-header>
</template>
<script>
	export default {
		props:['userinfo'],
		data() {
			return {
				activeIndex: '处理中心',
				activeIndex2: '1',
				headUrl: 'https://s3.ax1x.com/2020/12/11/rAAung.jpg',
				infoVisible: false
			};
		},
		methods: {
			handleSelect(key, keyPath) {
				console.log(key, keyPath);
				this.$emit("Navigation_bar_selection", key);
			},
			handleCommand(data) {
				if(data=="个人信息")this.infoVisible=true;
				
				this.$message(data);
			}
		}
	}
</script>

<style>
	#st {
		font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
	}
</style>
