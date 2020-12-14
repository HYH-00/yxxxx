<template>
	<div>
		<el-contain>
			<el-header>
				<Top v-on:Navigation_bar_selection="Navigation_bar_selection" v-bind:userinfo="userinfo"></Top>
			</el-header>
			<el-main>
				<component :is="comName" v-bind:userinfo="userinfo"></component>
			</el-main>
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
				userinfo:{
					userId: this.$route.params.userId,
					userPassword: this.$route.params.userPassword,
					userBalance: this.$route.params.userBalance,
					userName: this.$route.params.userName,
					userSex: this.$route.params.userSex,
					userLocation: this.$route.params.userLocation,
					userDocumentType: this.$route.params.userDocumentType,
					userIdentificationNumber: this.$route.params.userIdentificationNumber,
					userNickName: this.$route.params.userNickName
				},
				comName: 'TreeHole'
			};
		},
		methods: {
			Navigation_bar_selection(data) {
				if (data == "树洞") this.comName = "TreeHole";
				else if (data == "朋友圈") this.comName = "CircleOfFriends";
				else if (data == "在线心理按摩") this.comName = "PsychologicalMassage";
			}
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
