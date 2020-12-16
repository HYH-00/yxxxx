<template>
	<div class="wraper">
		<el-row>
			<template>
				<el-backtop target=".wraper">
					<div style="{height: 100%;width: 100%;background-color: #f2f5f6;box-shadow: 0 0 6px rgba(0,0,0, .12);text-align: center;line-height: 40px;color: #1989fa;}">
						UP
					</div>
				</el-backtop>
			</template>
			<!-- <div class="infinite-list-wrapper" style="overflow:auto"> -->
				<!-- <ul class="list" v-infinite-scroll="load" infinite-scroll-disabled="disabled"> -->
					<el-col :span="24" v-for="(item,id) in wechatmoments" :key="id">
						<el-card class="box-card" style="margin-top: 10px;">
							<div slot="header" class="clearfix">
								<span>{{item.userNickName}}</span>
								<el-dropdown trigger="click" style="float: right; padding: 3px 0" @command="handleCommand($event,item.wechatmomentsId,item.userNickName,item.fabulousNick)">
									<i class="el-icon-more"></i>
									<el-dropdown-menu slot="dropdown">
										<el-dropdown-item command="点赞"><i class="el-icon-trophy" /></el-dropdown-item>
										<!-- <el-dropdown-item v-else command="取赞"><i class="el-icon-trophy" />取赞</el-dropdown-item> -->
										<el-dropdown-item command="评论"><i class="el-icon-chat-dot-square" /></el-dropdown-item>
									</el-dropdown-menu>
								</el-dropdown>
								<br />
								<span>{{item.content}}</span>
								<br />
								<span>{{item.date}}</span>
							</div>
							<el-tag v-if="item.fabulousNick.length>0" type="info">
								<i class="el-icon-trophy"></i>
								<i v-for="(o,id) in item.fabulousNick" :key="id" class="text item">
									<i v-if="id>0">,</i>
									{{o}}
								</i>
							</el-tag>
							<el-divider v-if="item.fabulousNick.length>0 && item.comment.length>0"></el-divider>
							<div>
								<!-- <i v-if="item.comment.length>0" class="el-icon-chat-dot-square"></i> -->
								<div v-for="(it,id) in item.comment" :key="id">
									{{it.respondents}} 回复 {{it.recipient}} : {{it.content}}
								</div>
							</div>
						</el-card>
					</el-col>
				<!-- </ul> -->
				<!-- <p v-if="loading">加载中...</p>
				<p v-if="noMore">没有更多了</p> -->
			<!-- </div> -->
			<el-drawer :visible.sync="drawer" size="50%" :direction="direction">
				<div style="margin-left: 80px;margin-right: 80px;">
					<el-input type="textarea" :rows="6" placeholder="评论内容" v-model="textarea">
					</el-input>
					<div style="margin-top: 15px;">
						<el-row style="float: right;">
							<el-button @click="submitComments" type="success" icon="el-icon-check" circle></el-button>
						</el-row>
					</div>
				</div>
			</el-drawer>
		</el-row>
	</div>
</template>
<script>
	export default {
		props: ['userinfo'],
		data() {
			return {
				wechatmoments: [],
				drawer: false,
				direction: 'btt',
				textarea: '',
				CommentsId: '',
				NickName: '',
				userinfo_: this.userinfo,
				count: 7,
				loading: false
			};
		},
		computed: {
			// noMore() {
			// 	// alert(this.count+"  "+this.getRowNum());
			// 	return this.count >= this.getRowNum();
			// },
			// disabled() {
			// 	return this.loading || this.noMore
			// }
		},
		mounted() {
			this.getWechatmoments();
		},
		methods: {
			async getWechatmoments() {
				var that = this;
				// alert(this.count);
				this.$axios.post("http://localhost:8088/springboot/getWechatmoments")
					.then(function(res) {
						console.log(res);
						that.wechatmoments = res.data;
						// alert(that.wechatmoments.)
					}).catch(function(err) {
						console.log(err);
					})
			},
			handleCommand(command, wechatmomentsId, userNickName, list) {
				//alert(command + " " + wechatmomentsId)
				// console.log(list[0]);
				this.CommentsId = wechatmomentsId;
				this.NickName = userNickName;
				if (command == "点赞") {
					this.juFabulous(list, this.CommentsId, this.userinfo_.userNickName);
				} else {
					this.drawer = true;
					this.textarea = "";
				}
			},
			submitComments() {
				// alert("xxx")
				//this.CommentsId->朋友圈的编号
				//this.textarea->评论内容
				//userinfo.userNickName->评论者昵称
				//this.NickName->被评论者昵称
				//alert(this.CommentsId+"  "+this.textarea);
				//alert("http://localhost:8088/springboot/insertComment/"+this.textarea+"/"+this.CommentsId+"/"+this.userinfo_.userNickName+"/"+this.NickName)
				var that = this;
				this.$axios.post("http://localhost:8088/springboot/insertComment/" + this.textarea + "/" + this.CommentsId + "/" +
						this.userinfo_.userNickName + "/" + this.NickName)
					.then(function(res) {
						console.log(res.data);
						//alert("添加成功"+res.data)
						that.drawer = false;
						that.getWechatmoments();
					}).catch(function(err) {
						console.log(err);
					})
			},
			juFabulous(xx, id, x) {
				var lx = xx.length;
				var flag = true;
				// alert(xx);
				// alert(xx+" "+id+" "+x);
				// alert(lx);
				for (var i = 0; i < lx; ++i) {
					if (xx[i] == x) {
						// alert(xx[i]);
						flag = false;
						break;
					}
				}
				// alert(xx+"   "+x);
				// alert("----"+flag);
				var that = this;
				if (flag) {
					this.$axios.post("http://localhost:8088/springboot/insertFabulous/" + id + "/" + x)
						.then(function(res) {
							console.log(res.data);
							that.getWechatmoments();
							that.$message("点赞");
						}).catch(function(err) {
							console.log(err);
						})
				} else {
					this.$axios.post("http://localhost:8088/springboot/deleteFabulousBywIdAndNick/" + id + "/" + x)
						.then(function(res) {
							console.log(res.data);
							that.getWechatmoments();
							that.$message("取消赞");
						}).catch(function(err) {
							console.log(err);
						})
				}
			},
			// load() {
				//alert(this.noMore);
				// if(this.noMore()){
				// 	return;
				// }
				// this.loading = true
				// setTimeout(() => {
				// 	this.count += 2
				// 	this.loading = false
				// 	this.getWechatmoments();
				// }, 2000)
			// },
			getRowNum() {
				var num = 0;
				this.$axios.post("http://localhost:8088/springboot/getRowNum")
					.then(function(res) {
						console.log(res.data);
						num = res.data;
					}).catch(function(err) {
						console.log(err);
					})
				// alert(this.count+" "+num);
				return num;
			}
		}
	}
</script>

<style>
	.wraper {
		height: 100vh;
		overflow-x: hidden;
	}

	::-webkit-scrollbar {
		width: 0 !important;
	}

	::-webkit-scrollbar {
		width: 0 !important;
		height: 0;
	}
</style>
