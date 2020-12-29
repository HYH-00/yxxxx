<template>
	<div>
		<el-contain>
			<el-header>
				<Top v-on:Navigation_bar_selection="Navigation_bar_selection" v-bind:userinfo="userinfo"></Top>
			</el-header>
			<el-contain>
				<el-main>
					<component :is="comName" v-on:edittreeSelect="edittreeSelect" v-bind:userinfo="userinfo" v-bind:treehole="treehole"></component>
				</el-main>
				<el-drawer size="60%" title="编织树枝" :before-close="handleClose" :visible.sync="addtree" direction="ltr" custom-class="demo-drawer"
				 ref="drawer">
					<div class="demo-drawer__content">
						<el-form ref="form" :model="addtreeform" label-width="80px">
							<el-row :gutter="5">
								<el-col :span="23">
									<el-form-item label="标题">
										<el-input v-model="addtreeform.title"></el-input>
									</el-form-item>
								</el-col>
							</el-row>
							<el-row :gutter="5">
								<el-col :span="23">
									<el-form-item label="内容">
										<el-input rows="25" type="textarea" v-model="addtreeform.content"></el-input>
									</el-form-item>
								</el-col>
							</el-row>
						</el-form>
						<div class="demo-drawer__footer" style="float: right;margin-right: 40px;">
							<el-button @click="initaddtreefrom">重 置</el-button>
							<el-button @click="cancelForm">取 消</el-button>
							<el-button type="primary" @click="$refs.drawer.closeDrawer()" :loading="loading">{{ loading ? '提交中 ...' : '确 定' }}</el-button>
						</div>
					</div>
				</el-drawer>
				<el-drawer size="60%" title="我的树枝" :before-close="edithandleClose" :visible.sync="edittree" direction="ltr" custom-class="demo-drawer"
				 ref="drawer1">
					<div class="demo-drawer__content">
						<el-form ref="form" :model="edittreeform" label-width="80px">
							<el-row :gutter="5">
								<el-col :span="23">
									<el-form-item label="标题">
										<el-input v-model="edittreeform.title"></el-input>
									</el-form-item>
								</el-col>
							</el-row>
							<el-row :gutter="5">
								<el-col :span="23">
									<el-form-item label="内容">
										<el-input rows="25" type="textarea" v-model="edittreeform.content"></el-input>
									</el-form-item>
								</el-col>
							</el-row>
						</el-form>
						<div class="demo-drawer__footer" style="float: right;margin-right: 40px;">
							<el-button @click="initedittreefrom">重 置</el-button>
							<el-button @click="editcancelForm">取 消</el-button>
							<el-button type="primary" @click="$refs.drawer1.closeDrawer()" :loading="editloading">{{ editloading ? '提交中 ...' : '确 定' }}</el-button>
						</div>
					</div>
				</el-drawer>
			</el-contain>
		</el-contain>
	</div>
</template>
<script>
	import Top from './components/Top.vue'
	import TreeHole from './components/TreeHole.vue'
	import CircleOfFriends from './components/CircleOfFriends.vue'
	import PsychologicalMassage from './components/PsychologicalMassage.vue'
	export default {
		data() {
			return {
				userinfo: {
					userId: sessionStorage.getItem("userId"),
					userPassword: sessionStorage.getItem("userPassword"),
					userBalance: sessionStorage.getItem("userBalance"),
					userName: sessionStorage.getItem("userName"),
					userSex: sessionStorage.getItem("userSex"),
					userLocation: sessionStorage.getItem("userLocation"),
					userDocumentType: sessionStorage.getItem("userDocumentType"),
					userIdentificationNumber: sessionStorage.getItem("userIdentificationNumber"),
					userNickName: sessionStorage.getItem("userNickName"),
				},
				comName: 'TreeHole',
				addtree: false,
				loading: false,
				edittree: false,
				editloading: false,
				addtreeform: {
					title: '',
					content: ''
				},
				edittreeform:{
					time:'',
					title: '',
					content: ''
				},
				treehole:[]
			};
		},
		mounted() {
			this.getTreeHoleData()	
		},
		methods: {
			Navigation_bar_selection(data) {
				if (data == "树洞") this.comName = "TreeHole";
				else if (data == "朋友圈") this.comName = "CircleOfFriends";
				else if (data == "咨询") {
					this.comName = "PsychologicalMassage";
				} else if (data == "编织树枝") {
					this.addtree = true;
				}else if(data=="我的树洞"){
					this.comName="TreeHole"
				}
			},
			edittreeSelect(data){
				this.edittreeform=data
				this.edittree=true
			},
			handleClose(done) {
				// alert("add")
				if (this.loading) {
					return;
				}
				var that = this;
				this.$confirm('确定要投入树洞吗？')
					.then(function() {
						that.loading = true;
						that.timer = setTimeout(() => {
							done();
							that.$axios.post("http://localhost:8088/springboot/addTreeHole", {
								userId:that.userinfo.userId,
								title:that.addtreeform.title,
								content:that.addtreeform.content
							}).then(function(res) {
								console.log(res);
								that.initaddtreefrom();
								that.getTreeHoleData();
							}).catch(function(err) {
								console.log(err)
							})

							// 动画关闭需要一定的时间
							setTimeout(() => {
								that.loading = false;
							}, 300);
						}, 800);
					})
					.catch(function() {});
			},
			initaddtreefrom() {
				this.addtreeform.title = "";
				this.addtreeform.content = "";
			},
			initedittreefrom(){
				this.edittreeform.title = "";
				this.edittreeform.content = "";
			},
			editcancelForm(){
				this.edittree=false
			},
			cancelForm() {
				this.addtree = false
			},
			getTreeHoleData(){
				var that=this;
				// alert(this.userinfo.userId)
				this.$axios.post("http://localhost:8088/springboot/getTreeHoleByuserId/"+this.userinfo.userId)
				.then(function(res){
					console.log(res.data);
					that.treehole=res.data;
				}).catch(function(err){
					console.log(err);
				})
			},
			edithandleClose(done) {
				// alert("add")
				if (this.editloading) {
					return;
				}
				var that = this;
				this.$confirm('确定要修改树枝吗？')
					.then(function() {
						that.editloading = true;
						that.timer = setTimeout(() => {
							done();
							// that.$axios.post("http://localhost:8088/springboot/updTreeHoleByuserId", {
							// 	time:that.edittreeform.time,
							// 	userId:that.userinfo.userId,
							// 	title:that.edittreeform.title,
							// 	content:that.edittreeform.content
							// }).then(function(res) {
							// 	console.log(res);
								// that.initedittreefrom();
								// that.getTreeHoleData();
							// }).catch(function(err) {
							// 	console.log(err)
							// })
							// 动画关闭需要一定的时间
							setTimeout(() => {
								that.editloading = false;
							}, 300);
						}, 800);
					})
					.catch(function() {});
			}
			// edithandleClose(){
			// 	// alert("---")
			// 	if (this.editloading) {
			// 		return;
			// 	}
			// 	var that = this;
			// 	this.$confirm('确定要修改树枝吗？')
			// 		.then(function() {
			// 			that.editloading = true;
			// 			that.timer = setTimeout(() => {
			// 				done();
			// 				that.$axios.post("http://localhost:8088/springboot/updTreeHoleByuserId", {								
			// 					time:that.edittreeform.time,
			// 					userId:that.userinfo.userId,
			// 					title:that.edittreeform.title,
			// 					content:that.edittreeform.content
			// 				}).then(function(res) {
			// 					console.log(res);
			// 					that.initedittreefrom();
			// 					that.getTreeHoleData();
			// 				}).catch(function(err) {
			// 					console.log(err)
			// 				})
				
			// 				// 动画关闭需要一定的时间
			// 				setTimeout(() => {
			// 					that.editloading = false;
			// 				}, 300);
			// 			}, 800);
			// 		})
			// 		.catch(function() {});
			// }
		},
		components: {
			Top,
			TreeHole,
			CircleOfFriends,
			PsychologicalMassage
		}
	}
</script>
<style>
</style>
