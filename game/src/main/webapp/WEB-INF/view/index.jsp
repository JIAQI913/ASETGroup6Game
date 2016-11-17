<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Game Craft</title>
<link rel="stylesheet" type="text/css" href="resources/css/easyui.css">
<link rel="stylesheet" type="text/css" href="resources/css/icon.css">
<link rel="stylesheet" type="text/css" href="resources/css/demo.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/flexslider.css" />

<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="resources/js/jquery.flexslider-min.js"></script>


<style type="text/css">
body {
	margin: 0;
	padding: 0;
	display: block;
}

#container {
	width: 1080px;
	margin: 0 auto;
}

#head {
	margin: 10px auto;
	width: 1080px;
}

#search {
	font: "arial black";
}

.searchtext {
	font-size: 20px;
	height: 40px;
	width: 600px;
	padding: 0px 10px 0 10px;
}

.searchbutton {
	font-size: 20px;
	height: 40px;
}

#banner {
	width: 1080px;
	margin: 0 auto;
}

#content {
	margin: 40px 0 auto;
	border: 10px;
	border-color: #FF0000;
	font-family: arial;
	font-size: 20px;
	line-height: 40px;
}
</style>

<script type="text/javascript">
	//	var temp;
	var gameData;
	var selectGame;
	var gameCount;
	var currentPage = 1;
	function search() {
		$.ajax({
			type : "get",
			url : "/game/Search?gameName=" + $("#searchname").val()
					+ "&currentPage=1&limit=" + $("#pageSize").val(),
			dataType : "json",
			success : function(data) {
				//	temp = data;
				//	alert(data.length);
				gameData = data.gameDetail;
				gameCount = data.gameCount.count;
				$("#resultCount").html(gameCount);
				for (var i = 0; i < data.gameDetail.length; i++) {
					var currentName = "<a href='/game/getGameDetail?json="
							+ JSON.stringify(gameData[i]) + "'>"
							+ data.gameDetail[i].name + "</a></br>";
					/*	var currentName = "<a href='javascript:void(0)' onclick='selectGame="
						+ i
						+ "; getGameDetail();' id='selcetGameNum"
						+ i
						+ "'>"
						+ data.gameDetail[i].name
						+ "</a></br>"; */
					$("#gameList").append(currentName);
				}
				for (var j = 1; j < gameCount / 10 + 1; j++) {
					var page = "<a href='javascript:void(0)'>" + j
							+ "</a>&nbsp;"
					$("#pageList").append(page);
				}
			},
			error : function(msg) {
				alert(msg);
			}
		});
	}
	/* 	function getGameDetail() {
	 document.getElementById("selectGameDetail").value = JSON
	 .stringify(gameData[selectGame]);
	 document.forms.detail.submit();
	 } */
	/* 	function getGameDetail(){
	 var game= "{'RID':'123'}";
	 alert(game);
	 $.ajax({
	 url: "/game/getGameDetail",//ajax提交路径
	 type: "post",//提交方式
	 data: game,//提交参数
	 contentType: "application/json",
	 success: function () {//ajax请求完成时执行，result为返回的结果
	 alert();
	 },
	 error: function () {
	 alert("ajax failed");
	 }
	 });
	 } */
	/* 	$(function(){
	 $(document).click(function (e) {
	 alert($(e.target).attr('id'));
	 })
	 }); */
	/* 	$(document).ready(function(){
	 $("#gameList").click(function(e){
	 temp=this;
	 alert($(e.target).attr('id'));
	 })
	 }); */
	$(function() {
		$(".flexslider").flexslider({
			slideshowSpeed : 4000, //展示时间间隔ms
			animationSpeed : 400, //滚动时间ms
		});
	});
</script>

</head>
<body>
	<!-- 	<form action="getGameDetail" method="post" name="detail">
		<input type="hidden" name="selectGameDetail" id="selectGameDetail"
			value="">
	</form> -->
	<div id="container">
		<div id="head" align="left">
			<div>
				<img src="resources/img/logo.png" />
			</div>
		</div>
		<div id="search" style="margin-bottom: 20px">
			<div class="easyui-tabs"
				style="width: 1080px; height: 120px; color: #AAAAAA">
				<div title="Name" style="margin: 20px">
					<form class="form">
						<div>
							<input type="text" class="searchtext" id="searchname"
								placeholder="Search for Game Name" name="searchtext" />
								Page Size:<select id="pageSize"><option value="10">10</option><option value="20">20</option><option value="50">50</option></select>
						</div>
						<div>
							<input type="button" onclick="search()" class="searchbutton"
								value="Search" />
						</div>
					</form>
				</div>

				<div title="Type" style="margin: 20px">
					<form action="" method="post" id="searchForm" class="form">
						<div>
							<input type="text" class="searchtext"
								placeholder="Search for Game Type" name="search" /> <input
								type="submit" class="searchbutton" value="Search" />
						</div>
					</form>
				</div>

				<div title="Score" style="margin: 20px">
					<form action="" method="post" id="searchForm" class="form">
						<div>
							<input type="text" class="searchtext"
								placeholder="Search for Game Score" name="search" /> <input
								type="submit" class="searchbutton" value="Search" />
						</div>
					</form>
				</div>

				<div title="Date" style="margin: 20px">
					<form action="" method="post" id="searchForm" class="form">
						<div>
							<input type="text" class="searchtext"
								placeholder="Search for Game Date" name="search" /> <input
								type="submit" class="searchbutton" value="Search" />
						</div>
					</form>
				</div>

			</div>
		</div>

		<div id="banner">
			<div class="flexslider" style="margin: 0 auto">
				<ul class="slides">
					<li><img src="resources/img/1.png" /></li>
					<li><img src="resources/img/2.png" /></li>
					<li><img src="resources/img/3.png" /></li>
			</div>
		</div>

		<div id="content">
			<div style="font-size: 30px; line-height: 40px;">
				Search Result: <span id="resultCount"> </span>
			</div>
			<div id="gameList"></div>
			<div id="pageList"></div>
		</div>
</body>
</html>
