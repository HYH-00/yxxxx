<template>
	<div class="login-container">
		<el-form :model="ruleForm2" :rules="rules2" status-icon ref="ruleForm2" label-position="left" label-width="0px" class="demo-ruleForm login-page">
			<h3 class="title">系统登录</h3>
			<el-form-item prop="username">
				<el-input type="text" v-model="ruleForm2.username" auto-complete="off" placeholder="用户名"></el-input>
			</el-form-item>
			<el-form-item prop="password">
				<el-input type="password" v-model="ruleForm2.password" auto-complete="off" placeholder="密码"></el-input>
			</el-form-item>
			<el-checkbox v-model="checked" class="rememberme">记住密码</el-checkbox>
			<el-form-item style="width:100%;">
				<el-button type="primary" style="width:100%;" @click="handleSubmit" :loading="logining">登录</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>
<script>
	export default {
		data() {
			return {
				logining: false,
				ruleForm2: {
					username: '123',
					password: '123',
				},

				rules2: {
					username: [{
						required: true,
						message: 'please enter your account',
						trigger: 'blur'
					}],
					password: [{
						required: true,
						message: 'enter your password',
						trigger: 'blur'
					}]
				},
				checked: false
			}
		},
		methods: {
			handleSubmit() {
				var that = this;
				this.$refs.ruleForm2.validate((valid) => {
					if (valid) {
						this.logining = true;
						var thatt = this;
						that.$axios.post("http://localhost:8088/springboot/queryByidandpwd/" + this.ruleForm2.username + "/" + this.ruleForm2
								.password)
							.then(function(res) {
								console.log(res);
								var dat = res.data;
								// alert(dat.userId);
								if (res.data.userId != null) {
									thatt.logining = false;
									sessionStorage.setItem('userId', dat.userId);
									sessionStorage.setItem('userPassword', dat.userPassword);
									sessionStorage.setItem('userBalance', dat.userBalance);
									sessionStorage.setItem('userName', dat.userName);
									sessionStorage.setItem('userSex', dat.userSex);
									sessionStorage.setItem('userLocation', dat.userLocation);
									sessionStorage.setItem('userDocumentType', dat.userDocumentType);
									sessionStorage.setItem('userIdentificationNumber', dat.userIdentificationNumber);
									sessionStorage.setItem('userNickName', dat.userNickName);
									thatt.$router.push({
										name: 'Main',
										params: {
											userId: dat.userId,
											userPassword: dat.userPassword,
											userBalance: dat.userBalance,
											userName: dat.userName,
											userSex: dat.userSex,
											userLocation: dat.userLocation,
											userDocumentType: dat.userDocumentType,
											userIdentificationNumber: dat.userIdentificationNumber,
											userNickName: dat.userNickName
										}
									});
								} else {
									thatt.logining = false;
									thatt.$alert('username or password wrong!', 'info', {
										confirmButtonText: 'ok'
									})
								}
							}).catch(function(err) {
								console.log(err);
							})


					} else {
						console.log('error submit!');
						return false;
					}
				})
			}
		}
	};
</script>

<style>
	.login-container {
		width: 100%;
		height: 100%;
	}

	.login-page {
		-webkit-border-radius: 5px;
		border-radius: 5px;
		margin: 180px auto;
		width: 350px;
		padding: 35px 35px 15px;
		background: #fff;
		border: 1px solid #eaeaea;
		box-shadow: 0 0 25px #cac6c6;
	}

	label.el-checkbox.rememberme {
		margin: 0px 0px 15px;
		text-align: left;
	}
</style>
