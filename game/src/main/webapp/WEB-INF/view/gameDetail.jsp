<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title></title>
<link rel="stylesheet" type="text/css" href="resources/css/easyui.css">
<link rel="stylesheet" type="text/css" href="resources/css/icon.css">
<link rel="stylesheet" type="text/css" href="resources/css/demo.css">
<link rel="stylesheet" type="text/css"
	href="resources/css/flexslider.css" />

<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="resources/js/jquery.flexslider-min.js"></script>

<style>
.container {
	width: 100%;
	margin: 0 auto;
	overflow: hidden;
	height: 100%;
}

.north, .west, .center, .east, .south, .w-top, .w-center, .w-bottom,
	.left, .right {
	
}

.north {
	width: 1200px;
	margin: 0 auto;
	height: 600px;
}

.parallax-container {
	position: absolute;
	left: 0;
	height: 442px;
	width: 100%;
	margin-top: -442px;
	overflow: hidden;
}

.parallax-background {
	background: url(img/1.png);
	height: 300px;
	width: 1200px;
}

.gamepage-header-info {
	margin-top: -180px;
	margin-left: auto;
	width: 1100px;
	height: 260px;
}

.gamepage-cover {
	float: left;
	width: 264px;
	margin-left: -40px;
}

.btn {
	display: inline-block;
	margin-bottom: 0;
	font-weight: normal;
	text-align: center;
	vertical-align: middle;
	touch-action: manipulation;
	cursor: pointer;
	background-image: none;
	border: 1px solid transparent;
	white-space: nowrap;
	padding: 6px 12px;
	font-size: 14px;
	line-height: 1.42857143;
	border-radius: 4px;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

.btn-group-justified {
	display: table;
	width: 100%;
	table-layout: fixed;
	border-collapse: separate;
}

.hide {
	display: none !important;
}

.gamepage-header-info .gamepage-title-container {
	position: relative;
	margin-top: -10px;
}

.gamepage-header-info .gamepage-title-wrapper {
	position: absolute;
	bottom: 0;
	width: 750px;
	min-height: 188px;
}

.banner-title {
	font-size: 60px;
	font-weight: bold;
}

.banner-subheading {
	font-size: 25px;
	opacity: 0.8;
}

.banner-title, .banner-subheading, .banner-subsubheading {
	font-weight: 600;
	color: white;
	text-shadow: 0 1px 1px rgba(0, 0, 0, 0.4);
}

.gamepage-status {
	position: absolute;
	bottom: 15px;
	right: 0;
	margin-right: 280px;
	color: white;
	font-weight: bold;
}

.gamepage-summary {
margin-top: 110px;
	float: left;
	width: 560px;
}

.gamepage-tabs {
	padding-right: 15px;
	margin-top: 1px;
	/*margin-left: -15px;*/
}

.text-semibold {
	font-weight: 600;
	margin-left: 20px;
}

.text-semibold1 {
	font-weight: 600;
}

.information-content{
	margin-left: 20px;
	color: #27AE60;
}

.gamepage-gauge {
	float: left;
	margin-left: 5px;
	width: 268px;
}

.pad {
	padding: 5px;
}

.gauge-info {
	overflow: hidden;
	font-size: 12px;
	text-align: center;
	margin-bottom: 15px;
}

.gauge-single-info {
	width: 134px;
	padding: 0 5px;
	float: left;
}

.gauge-twin-info {
	width: 96px;
	float: left;
}

.media-thumbs {
	background-color: #fff;
	/*position: absolute;*/
	width: 100%;
	margin: 5px auto;
}

.mar-md-bottom {
	margin-bottom: 10px !important;
}

.rating {
	position: relative;
	unicode-bidi: bidi-override;
	/*direction: rtl;*/
	display: inline-block;
	width: 260px;
}

.rating>div {
	display: inline-block;
	cursor: pointer;
}

.rating-star {
	background: url(resources/img/logo-bw.svg);
	width: 22px;
	height: 26px;
	margin-right: 4px;
}

p {
	padding: 5px 20px;
	word-break: break-all;
}

.slides li {
	align-content: center;
}

.pagebody {
	width: 1200px;
	margin: 0 auto;
	border: 1px solid red;
}

.south {
	width: 1200px;
	margin: 0 auto;
}

.left {
	width: 69%;
	float: left;
}

.right {
	width: 30%;
	float: right;
}

.w-bottom, .w-center, .w-top {
	width: 100%;
}

.flexslider {
	box-shadow: none;
}

.footer {
	height: 50px;
	width: 100%;
	position: fixed;
	bottom: 0px;
	left: 0px;
	background-color: #A4E9C1;
}
/*关键*/
.clearfix:after {
	visibility: hidden;
	display: block;
	font-size: 0;
	content: " ";
	clear: both;
	height: 0;
}

.clearfix {
	*zoom: 1;
}
</style>
<script>
	$(window)
			.load(
					function() {
						$("#gameSName").html("${gameS.name }");
						$("#gameSFRD").html("${gameS.first_release_date }");
						if ("${gameS.summary}" != "") {
							$("#summary").html("Summary: ");
							$("#gameSSummary").html("${gameS.summary}");
						}
						document.getElementById("gameSCover").src = "${gameS.cover.cloudinary_id}";
						if ("${gameS.storyline}"!= "") {
							$("#storyline").html("Storyline: ");
							$("#gameSStoryline").html("${gameS.storyline}");

						} 
						if ("${gameS.category}"!= "") {
							$("#category").html("Game Category: ");
							$("#gameSCategory").html("${gameS.category}");
							$("#gameSCategory").append("<p></p>");

						}
						<c:forEach items="${gameS.screenshots}" var="img">
						/* 						var tt="${img.cloudinary_id}"; */
						var temp = "<li><img src=${img.cloudinary_id} /></li>"
						$("#gameSScreenshot").append(temp);
						</c:forEach>
						$(titleImg).css("backgroundImage","url(${gameS.screenshots[0].cloudinary_id})");
						/* 						for (var i = 0; i < ${fn:length(gameS.screenshots)}; i++) {
						 var t=${gameS.screenshots[i].cloudinary_id};
						 var temp = "<li><img src="" /></li>"
						 $("#gameSScreenshot").append(temp);
						 } */
						<c:forEach items="${gameS.videos}" var="video">
						/* 						var tt="${img.cloudinary_id}"; */
						var temp = "<li><iframe id='ytplayer' type='text/html' width='420' height='315' src='${video.video_id}' frameborder='0' ></li>"
						//						var temp = "<li><video style='height: 320px;' width='280px' poster='resources/img/game_craft_logo.png' controls> <source src=${video.video_id} type='video/webm'></video></li>"
						$("#gameSVideo").append(temp);
						</c:forEach>

						$(".flexslider").flexslider({
							animation : "slide",
							animationLoop : false,
							controlNav : false,
							itemWidth : 500,
							itemMargin : 10,
							minItems : 2,
							maxItems : 4,
						//pausePlay: true
						});
						$
								.ajax({
									type : "get",
									url : "/game/showGameDetail",
									dataType : "json",
									success : function(data) {
										if (data.genres != null) {
											$("#genre").html("Genre: ");
											for (var i = 0; i < data.genres.length; i++) {
												$("#gameGenres").append(
														data.genres[i] + "</br>");
											}
										}
										if (data.developers!= null) {
											$("#developers").html("Developers: ");
											for (var i = 0; i < data.developers.length; i++) {
												$("#gameADevelopers").append(
														data.developers[i] + "</br>");
											}
											$("#gameADevelopers").append("<p></p>");
										}
										if (data.developers != null) {
											$("#publishers").html("Publishers: ");
											for (var i = 0; i < data.publishers.length; i++) {
												$("#gameAPublishers").append(
														data.publishers[i] +"</br>");
											}
											$("#gameAPublishers").append("<p></p>");
										}
										if (data.game_modes!= null) {
											$("#modes").html("Game modes: ");
											for (var i = 0; i < data.game_modes.length; i++) {
												$("#gameAModes").append(
														data.game_modes[i] + "</br>");
											}
											$("#gameAModes").append("<p></p>");
										}
										if (data.game_engines!=null ) {
											$("#engines").html("Game engines: ");
											for (var i = 0; i < data.game_engines.length; i++) {
												$("#gameAEngines").append(
														data.game_engines[i] + "</br>");
											}
											$("#gameAModes").append("<p></p>");
										}
										if (data.themes != null) {
											$("#themes").html("Game themes: ");
											for (var i = 0; i < data.themes.length; i++) {
												$("#gameAThemes").append(
														data.themes[i] + "</br>");
											}
											$("#gameAThemes").append("<p></p>");
										}
										if (data.keywords != null) {
											$("#keywords").html("Keywords: ");
											for (var i = 0; i < data.keywords.length; i++) {
												$("#gameAKeywords").append(
														data.keywords[i] + "</br>");
											}
											$("#gameAKeywords").append("<p></p>");
										}
									},
									error : function() {
										alert("Failed");
									}
								});
					});
</script>
</head>
<body>
	<div class="container">
		<div class="north clearfix">
			<div id="head" align="left">
				<div>
					<img src="resources/img/logo.jpg" />
				</div>
			</div>

			<div id="parallax-container">
				<div id=titleImg class="parallax-background"
					style="background-image: url(resources/img/Loading.gif); background-size:300%;"></div>
			</div>

			<div class="gamepage-header-info">
				<div class="gamepage-cover">
					<img id=gameSCover src="resources/img/Loading.gif" />
					<!-- <form class="wpp btn-group btn-group-justified" data-remote="true"
						action="" accept-charset="UTF-8" method="post">

						<label class="btn "> <input type="radio" name="list" value="want_to_play" class="radio">
							<div class="material-icons">schedule</div>
							<div class="text-uppercase">Want</div>
							<div class="text-muted">0</div>
						</label> <label class="btn "> <input type="radio" name="list" value="playing" class="radio">
							<div class="material-icons">games</div>
							<div class="text-uppercase">Playing</div>
							<div class="text-muted">0</div>
						</label> <label class="btn "> <input type="radio" name="list" value="played" class="radio">
							<div class="material-icons">check_circle</div>
							<div class="text-uppercase">Played</div>
							<div class="text-muted">0</div>
						</label> <input type="radio" name="list" value="remove" class="hide">

					</form> -->

				</div>

				<div class="gamepage-summary">
					<div class="gamepage-title-container" style="height: 88px;">
						<div class="gamepage-title-wrapper">
							<h1 class="banner-title">
								<span id=gameSName> </span>
							</h1>
							<h2 class="banner-subheading" style="padding-left: 5px;">
								<span id=gameSFRD> </span>
							</h2>
						</div>
					</div>


					<div class="gamepage-tabs">

						<div class="easyui-tabs" style="width: 550px; height: 180px;">
							<div title="About" style="padding: 10px">

								<div class="" data-reactid="36">
									<p class="text-semibold1" id=genre></p>
									<p style="color: #27AE60" id=gameGenres></p>
									<p class="text-semibold1" id=summary></p>
									<p style="color: #27AE60" id=gameSSummary></p>
									<p class="text-semibold1" id=storyline></p>
									<p style="color: #27AE60" id=gameSStoryline></p>
								</div>
							</div>
						</div>
					</div>
				</div>

				<%-- <div class="gamepage-gauge" style="margin-top: 20px;">
					<svg class="gauge " viewBox="0 0 110 110" width="136px"
						height="136px" style="width: 136px; text-align: center;"
						data-reactid="69">
						<circle cx="55" cy="55" r="55" fill="#FFFFFF" data-reactid="70"></circle>
						<path stroke-linecap="round" stroke-width="6" stroke="#F3F3F3"
							fill="none" stroke-dasharray="251.2, 251.2"
							d="M55 15 a 40 40 0 0 1 0 80 a 40 40 0 0 1 0 -80"
							data-reactid="71"></path>
						<text x="55" y="60" text-anchor="middle" dy="7" fill="#34373b"
							font-size="30" data-reactid="72">N/A</text>
					</svg>

					<svg class="gauge gauge-twin" viewBox="0 0 110 110" width="105px"
						height="105px" style="width: 105px; text-align: center;"
						data-reactid="73">
						<circle cx="55" cy="55" r="55" fill="#FFFFFF" data-reactid="74"></circle>
						<path stroke-linecap="round" stroke-width="7" stroke="#F3F3F3"
							fill="none" stroke-dasharray="251.2, 251.2"
							d="M55 15 a 40 40 0 0 1 0 80 a 40 40 0 0 1 0 -80"
							data-reactid="75">
						</path>
						<text x="55" y="60" text-anchor="middle" dy="7" fill="#34373b"
							font-size="30" data-reactid="76">N/A</text>
					</svg>

					<div class="pad gauge-info" data-reactid="77">
						<div class="gauge-single-info text-muted" data-reactid="78">Need
							more ratings</div>
						<div class="gauge-twin-info text-muted" data-reactid="79">Critic
							Score Unavailable</div>
					</div>

					<hr data-reactid="80">
					<br data-reactid="81">
					<div data-reactid="82">
						<strong class="block mar-md-bottom" data-reactid="83">Your
							Rating:</strong>
						<div class="rating " data-reactid="84">
							<div class="" data-reactid="85">
								<div class="rating-star " data-reactid="86"></div>
							</div>
							<div class="" data-reactid="85">
								<div class="rating-star " data-reactid="86"></div>
							</div>
							<div class="" data-reactid="85">
								<div class="rating-star " data-reactid="86"></div>
							</div>
							<div class="" data-reactid="85">
								<div class="rating-star " data-reactid="86"></div>
							</div>
							<div class="" data-reactid="85">
								<div class="rating-star " data-reactid="86"></div>
							</div>

						</div>
					</div>
				</div> --%>
			</div>

		</div>

		<div class="south clearfix">
			<div class="left">
				<div class="w-top clearfix">
					<div class="media-thumbs">
						<div class="flexslider" style="margin: 1px;">
							<ul class="slides" id=gameSScreenshot>
							</ul>
						</div>
					</div>
				</div>
				<div class="w-center">
					<div class="media-thumbs">
						<div class="flexslider" style="margin: 1px;">
							<ul class="slides" id=gameSVideo>
								<!-- 
								<li><video style="height: 320px;" width="280px"
										poster="resources/img/game_craft_logo.png" controls>
										<source src="resources/img/anim_card_flip.mp4" type="resources/video/mp4">
									</video></li>
								<li><video style="height: 320px;" width="280px"
										poster="resources/img/game_craft_logo.png" controls>
										<source src="resources/img/anim_card_flip.mp4" type="resources/video/mp4">
									</video></li>
								<li><video style="height: 320px;" width="280px"
										poster="resources/img/game_craft_logo.png" controls>
										<source src="resources/img/anim_card_flip.mp4" type="resources/video/mp4">
									</video></li>
								<li><video style="height: 320px;" width="280px"
										poster="resources/img/game_craft_logo.png" controls>
										<source src="resources/img/anim_card_flip.mp4" type="resources/video/mp4">
									</video></li>
								<li><video style="height: 320px;" width="280px"
										poster="resources/img/game_craft_logo.png" controls>
										<source src="resources/img/anim_card_flip.mp4" type="video/mp4">
									</video></li> -->
							</ul>
						</div>
					</div>
				</div>
				
			</div>
			<div class="right">
				<h3 style="padding: 5px 20px; font-family: charcoal; font-size:200%; font-weight:bold">Information</h3>
				<div class="text-semibold" id=category ></div>
				<div class="information-content" id=gameSCategory></div>
				<div class="text-semibold" id=developers></div>
				<div class="information-content" id=gameADevelopers></div>
				<div class="text-semibold" id=publishers></div>
				<div class="information-content" id=gameAPublishers></div>
				<div class="text-semibold" id=modes></div>
				<div class="information-content" id=gameAModes></div>
				<div class="text-semibold" id=engines></div>
				<div class="information-content" id=gameAEngines></div>
				<div class="text-semibold" id=themes></div>
				<div class="information-content" id=gameAThemes></div>
				<div class="text-semibold" id=keywords></div>
				<div class="information-content" id=gameAKeywords></div>
			</div>
			
		</div>
		<div style="padding-left: 180px">
					<h1 style="padding: 10px 20px; ">Comments</h1>

					<div>
				<table width="100%">
					<tr style="font-size: 150%;">
						<td width="70%">2016.11.10 18:26</td>
						<td width="30%">Ben</td>
					</tr>
					<tr>
						<td style="font-family: 'times new roman'; font-size: 140%;" colspan="2">This game is amazing!</td>
					</tr>
					<tr width="100%"></tr>
					<tr style="font-size: 150%;">
						<td width="70%">2016.11.11 20:25</td>
						<td width="30%">Jiaqi</td>
					</tr>
					<tr>
						<td style="font-family: 'times new roman'; font-size: 140%;" colspan="2">It is the most fantastic game I've ever played~</td>
					</tr>
					<tr width="100%"></tr>
					<tr style="font-size: 150%;">
						<td width="70%">2016.11.12 10:26</td>
						<td width="30%">Haha</td>
					</tr>
					<tr>
						<td style="font-family: 'times new roman'; font-size: 140%;" colspan="2">lol~</td>
					</tr>
				</table>		
            </div>


				</div>
</body>

<footer>
	<div>

		<table width="100%" bgcolor="#555555">
			<tr>
				<th align="left" width="100%"
					style="color: #C0A16B; font-family: 'times new roman';">Game's
					information are provided by igdb.com by free</th>
			</tr>
		</table>
	</div>
</footer>
</html>
