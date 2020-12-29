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
			<el-timeline>
				<el-timeline-item v-for="(item,i) in treehole" :timestamp="item.time" placement="top" :key="i">
					<el-card @click.native="get(item)">
						<h4>{{item.title}}</h4>
						<p>{{item.content}}</p>
					</el-card>
				</el-timeline-item>
			</el-timeline>
		</el-row>
	</div>
</template>
<script>
	export default {
		props:['userinfo','treehole'],
		data() {
			return {
				list: []
			};
		},
		mounted() {
			this.getTreeHoleData()
		},
		methods: {
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
			sub(s){
				if(s.length>30)
					return s.substring(0,30)+".....";
				return s;
			},
			get(item){
				this.$emit("edittreeSelect",item);
			}
		},
		components: {}
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
