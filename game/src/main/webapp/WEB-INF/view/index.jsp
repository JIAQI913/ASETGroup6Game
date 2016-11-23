<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Game Craft</title>
<link rel="stylesheet" type="text/css" href="resources/css/easyui.css">
<link rel="stylesheet" type="text/css" href="resources/css/icon.css">
<link rel="stylesheet" type="text/css" href="resources/css/demo.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/advancedSearch.css">
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

input::-webkit-input-placeholder, textarea::-webkit-input-placeholder {
	color: #ffffff;
}

input:-webkit-autofill {
	-webkit-box-shadow: 0 0 0px 1000px #bdbcbc inset;
}

a:-webkit-any-link {
	color: #6a6a6a;
	text-decoration: none;
	font-family: Baskerville Old Face;
}

DIV.quotes {
	PADDING-RIGHT: 3px;
	PADDING-LEFT: 3px;
	PADDING-BOTTOM: 3px;
	MARGIN: 3px;
	PADDING-TOP: 3px;
	TEXT-ALIGN: center;
}

DIV.quotes A {
	BORDER-RIGHT: #ddd 1px solid;
	PADDING-RIGHT: 5px;
	BORDER-TOP: #ddd 1px solid;
	PADDING-LEFT: 5px;
	PADDING-BOTTOM: 2px;
	BORDER-LEFT: #ddd 1px solid;
	COLOR: #aaa;
	MARGIN-RIGHT: 2px;
	PADDING-TOP: 2px;
	BORDER-BOTTOM: #ddd 1px solid;
	TEXT-DECORATION: none
}

DIV.quotes A:hover {
	BORDER-RIGHT: #a0a0a0 1px solid;
	PADDING-RIGHT: 5px;
	BORDER-TOP: #a0a0a0 1px solid;
	PADDING-LEFT: 5px;
	PADDING-BOTTOM: 2px;
	BORDER-LEFT: #a0a0a0 1px solid;
	MARGIN-RIGHT: 2px;
	PADDING-TOP: 2px;
	BORDER-BOTTOM: #a0a0a0 1px solid
}

DIV.quotes A:active {
	BORDER-RIGHT: #a0a0a0 1px solid;
	PADDING-RIGHT: 5px;
	BORDER-TOP: #a0a0a0 1px solid;
	PADDING-LEFT: 5px;
	PADDING-BOTTOM: 2px;
	BORDER-LEFT: #a0a0a0 1px solid;
	MARGIN-RIGHT: 2px;
	PADDING-TOP: 2px;
	BORDER-BOTTOM: #a0a0a0 1px solid
}

/* footer {
	height: 50px;
	width: 100%;
	bottom: 0px;
	left: 0px;
	position: fixed;
	margin-bottom: 0px;
} */
</style>

<script type="text/javascript">
	//	var temp;
	var gameData;
	var selectGame;
	var gameCount;
	var currentPage = 1;
	function searchPage() {
		search();
	}
	function advancedSearchPage() {
		advancedSearch();
	}
	function advancedSearch() {
		if (IGDB.style.display == 'block')
			IGDB.style.display = 'none';
		else
			IGDB.style.display = 'inline-block';
		//		console.log("123");
		$
				.ajax({
					type : "get",
					url : "/game/AdvancedSearch?name=" + $("#textname").val()
							+ "&platforms=" + $("#platforms").val() + "&years="
							+ $("#years").val() + "&themes="
							+ $("#themes").val() + "&genres="
							+ $("#genres").val() + "&currentPage="
							+ currentPage + "&limit=" + $("#pageSize").val()
							+ "&type=games",
					dataType : "json",
					success : function(data) {
						//	temp = data;
						//	alert(data.length);
						gameData = data.gameDetail;
						gameCount = data.gameCount.count;
						$("#resultCount").html(
								"&nbsp&nbsp" + "There are " + gameCount
										+ " results:");
						$("#gameList").empty();
						for (var i = 0; i < data.gameDetail.length; i++) {

							/* var currentName = "<a href='/game/getGameDetail?json="
									+ JSON.stringify(gameData[i]) + "'>"
									+ data.gameDetail[i].name + "</a></br>"; */
							var currentName = "<a href='javascript:void(0)' onclick='selectGame="
									+ i
									+ "; currentPage=1; getGameDetail();' id='selcetGameNum"
									+ i
									+ "'>"
									+ "&nbsp&nbsp&nbsp&nbsp&nbsp"
									+ data.gameDetail[i].name + "</a></br>";
							$("#gameList").append(currentName);
						}
						$("#pageList").empty();
						for (var j = 1; j < gameCount / 10 + 1; j++) {

							var page = "<a href='javascript:void(0)' onclick='currentPage="
									+ j
									+ "; AdvancedSearchPage();'>"
									+ j
									+ "</a>&nbsp;"
							$("#pageList").append(page);
						}
					},
					error : function(msg) {
						alert(msg);
					}
				});
	}
	function advancedOptions() {
		$("#resultCount").empty();
		$("#gameList").empty();
		$("#pageList").empty();
		IGDB.style.display = 'none';
		currentPage = 1;
		var menu = document.getElementById("menu");
		var banner = document.getElementById("banner");
		if (menu.style.display == 'block')
			menu.style.display = 'none';
		else
			menu.style.display = 'block';
		if (banner.style.display == 'block')
			banner.style.display = 'none';
		else
			banner.style.display = 'block';
		if (searchSpan.style.display == 'inline-block')
			searchSpan.style.display = 'none';
		else
			searchSpan.style.display = 'inline-block';
		if (advancedSearchSpan.style.display == 'inline-block')
			advancedSearchSpan.style.display = 'none';
		else
			advancedSearchSpan.style.display = 'inline-block';
	}
	function search() {
		if (IGDB.style.display == 'block')
			IGDB.style.display = 'none';
		else
			IGDB.style.display = 'inline-block';
		//		console.log("123");
		$
				.ajax({
					type : "get",
					url : "/game/Search?name=" + $("#textname").val()
							+ "&currentPage=" + currentPage + "&limit="
							+ $("#pageSize").val() + "&type=games",
					dataType : "json",
					success : function(data) {
						//	temp = data;
						//	alert(data.length);
						gameData = data.gameDetail;
						gameCount = data.gameCount.count;
						$("#resultCount").html(
								"&nbsp&nbsp" + "There are " + gameCount
										+ " results:");
						$("#gameList").empty();
						for (var i = 0; i < data.gameDetail.length; i++) {

							/* var currentName = "<a href='/game/getGameDetail?json="
									+ JSON.stringify(gameData[i]) + "'>"
									+ data.gameDetail[i].name + "</a></br>"; */
							var currentName = "<a href='javascript:void(0)' onclick='selectGame="
									+ i
									+ "; currentPage=1; getGameDetail();' id='selcetGameNum"
									+ i
									+ "'>"
									+ "&nbsp&nbsp&nbsp&nbsp&nbsp"
									+ data.gameDetail[i].name + "</a></br>";
							$("#gameList").append(currentName);
						}
						$("#pageList").empty();
						for (var j = 1; j < gameCount / 10 + 1; j++) {

							var page = "<a href='javascript:void(0)' onclick='currentPage="
									+ j
									+ "; searchPage();'>"
									+ j
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
	function getGameDetail() {
		$.ajax({
			url : "/game/getGameDetail",
			type : "POST",
			contentType : 'application/json;charset=UTF-8',
			data : JSON.stringify(gameData[selectGame]),
			success : function(data) {
				//				alert(data);
				window.location.href = "/game/GoToGameDetail";
			},
			error : function(e) {
				alert("err");
			}
		});
	}
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
	<div style="height: 50px;"></div>
	<div id="container">
		<div id="head" align="center">
			<div>
				<img src="resources/img/logo.jpg" />
			</div>
			<div style="height: 50px;"></div>
		</div>
		<div id="search" style="margin-bottom: 20px">
			<div style="width: 1080px; height: 80px; color: #AAAAAA">

				<form class="form">
					<div>
						<table width="100%">
							<tr>
								<td align="center"><span style="display: inline-block;"><input
										type="text" class="searchtext" id="textname"
										placeholder="Search for Game Name" name="searchtext"
										style="background-color: #bdbcbc;"
										onkeypress="if(event.keyCode==13) {if(advancedSearchSpan.style.display == 'inline-block') {advancedSearchB.click();return false;} else{searchB.click();return false; }}" />
								</span> <span id="searchSpan" style="display: inline-block;"><input
										type=button id="searchB" value=" " class="searchbutton"
										onclick="search()"
										style="background-image: url(resources/img/search.jpg); background-size: 100%; width: 40px; height: 40px; border-style: ridge;">
								</span> <span id="advancedSearchSpan" style="display: none;"><input
										type=button id="advancedSearchB" value=" " class="searchbutton"
										onclick="advancedSearch()"
										style="background-image: url(resources/img/search.jpg); background-size: 100%; width: 40px; height: 40px; border-style: ridge;">
								</span> <input type="button" onclick="advancedOptions()"
									class="searchbutton" value="Advanced Search"
									style="background-color: #bdbcbc; color: #ffffff; border-style: ridge;" /></td>


							</tr>

							<tr>
								<td align="right">Page Size:<select id="pageSize"><option
											value="10">10</option>
										<option value="20">20</option>
										<option value="50">50</option></select>
								</td>
							</tr>
						</table>
					</div>
				</form>
			</div>
		</div>

		<div id="menu" style="display: none; clear: both;">
			<ul class="nav nav-tabs nav-alt nav-justified">

				<li><a style="font-family: 'Comic Sans MS'; font-size: 180%;">Platforms</a>
					<select id=platforms class="select" onkeypress="if(event.keyCode==13) {advancedSearchB.click();return false;}">
						<option>*</option>
						<option>PC (Microsoft Windows)</option>
						<option>Mac</option>
						<option>Linux</option>
						<option>XBox One</option>
						<option>PS4</option>
						<option>PS3</option>
				</select></li>
				<li><a style="font-family: 'Comic Sans MS'; font-size: 180%;">Years</a>
					<select id=years class="select" onkeypress="if(event.keyCode==13) {advancedSearchB.click();return false;}">
						<option>*</option>
						<option>2018</option>
						<option>2017</option>
						<option>2016</option>
						<option>2015</option>
						<option>2014</option>
						<option>2013</option>
						<option>2012</option>
						<option>2011</option>
						<option>2010</option>
						<option>2009</option>
						<option>2008</option>
						<option>2007</option>
						<option>2006</option>
						<option>2005</option>
						<option>2004</option>
						<option>2003</option>
						<option>2002</option>
						<option>2001</option>
						<option>2000</option>
						<option>1999</option>
						<option>1998</option>
						<option>1997</option>
						<option>1996</option>
						<option>1995</option>
						<option>1994</option>
						<option>1993</option>
						<option>1992</option>
						<option>1991</option>
						<option>1990</option>
						<option>1989</option>
						<option>1988</option>
						<option>1987</option>
						<option>1986</option>
						<option>1985</option>
						<option>1984</option>
						<option>1983</option>
						<option>1982</option>
						<option>1981</option>
						<option>1980</option>
						<option>1979</option>
						<option>1978</option>
						<option>1977</option>
						<option>1976</option>
						<option>1975</option>
						<option>1974</option>
						<option>1973</option>
						<option>1972</option>
						<option>1971</option>
						<option>1970</option>
						<option>1969</option>
						<option>1968</option>
						<option>1967</option>
						<option>1966</option>
						<option>1965</option>
						<option>1964</option>
						<option>1963</option>
						<option>1962</option>
						<option>1961</option>
						<option>1960</option>
						<option>1959</option>
						<option>1958</option>
				</select></li>
				<li><a style="font-family: 'Comic Sans MS'; font-size: 180%;">Genres</a>
					<select id=genres class="select" onkeypress="if(event.keyCode==13) {advancedSearchB.click();return false;}">
						<option>*</option>
						<option>Arcade</option>
						<option>Adventure</option>
						<option>Point-and-coptionck</option>
						<option>Fighting</option>
						<option>Shooter</option>
						<option>Puzzle</option>
						<option>Platform</option>
						<option>Music</option>
						<option>Strategy</option>
						<option>Turn-based strategy(TBS)</option>
						<option>Tactical</option>
						<option>Racing</option>
						<option>Real Time Strategy</option>
						<option>Role-playing(RPG)</option>
						<option>Simselectator</option>
						<option>Sport</option>
						<option>Quiz/Trivia</option>
						<option>Pinball</option>
						<option>Indie</option>

				</select></li>
				<li><a style="font-family: 'Comic Sans MS'; font-size: 180%;">Themes</a>
					<select id=themes class="select" onkeypress="if(event.keyCode==13) {advancedSearchB.click();return false;}">
						<option>*</option>
						<option>Action</option>
						<option>Fantasy</option>
						<option>Science fiction</option>
						<option>Horror</option>
						<option>Thriller</option>
						<option>Survival</option>
						<option>Stealth</option>
						<option>Comedy</option>
						<option>Business</option>
						<option>Drama</option>
						<option>Sandbox</option>
						<option>Educational</option>
						<option>Kids</option>
						<option>Open world</option>
						<option>Warfare</option>
						<option>Party</option>
						<option>Erotic</option>
						<option>Mystery</option>
				</select></li>
			</ul>
		</div>

		<div id="banner" style="display: block;">
			<div class="flexslider" style="margin: 0 auto">
				<ul class="slides">
					<li><img src="resources/img/1.png" /></li>
					<li><img src="resources/img/2.png" /></li>
					<li><img src="resources/img/3.png" /></li>
				</ul>
			</div>
		</div>

		<div id="content">
			<div style="clear: both;">
				<h1 id="resultCount"
					style="font-family: 'Baskerville Old Face'; font-size: 120%; color: #1a0dab"></h1>
			</div>
			<div id="gameList"></div>
			<div id="pageList" class="quotes"></div>
		</div>
</body>
<footer>
	<div id=IGDB style="display: none;">
		<table>
			<tr>
				<th align="left" width="100%"
					style="color: #C0A16B; font-family: 'times new roman'; background-color: #555555">Search
					results are provided by igdb.com by free</th>
			</tr>
		</table>
	</div>
</footer>
</html>
