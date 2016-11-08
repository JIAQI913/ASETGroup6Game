<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Game Craft Login</title>
		<link rel="stylesheet" type="text/css" href="resources/css/easyui.css">
		<link rel="stylesheet" type="text/css" href="resources/css/icon.css">
		<link rel="stylesheet" type="text/css" href="resources/css/demo.css">
		<link rel="stylesheet" type="text/css" href="resources/css/flexslider.css" />
		
		<script type="text/javascript" src="resources/js/jquery.min.js"></script>
		<script type="text/javascript" src="resources/js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="resources/js/jquery.flexslider-min.js"></script>
	</head>
	
	<style type="text/css">
			body{
				display: block;
			}
			#container{
				width: 1080px;
				margin: 0 auto;
			}

			
			#logo{

				margin: 100px auto;
				width: 1080px;
				
			}
			#search{
				font: "arial black";
			}
			
			.searchtext{
				font-size: 20px;
				margin:5px auto;				
			}
			
		</style>
	<body>
		
		<div id ="container">
			<div id ="logo" align="center">
				<img  src="resources/img/logo.png" />
			</div>


			<div id="loginform" class="searchtext" style="margin: 100px auto;">
				<form name="form1" action="Login.html" onsubmit="return validate();">
				  	<table align="center">
						<tr>
							<td align="right"/>ID：
							<td><input class="searchtext" type="text" id="username" />
						</tr>
						<tr>
							<td align="right"/>Password：
							<td><input class="searchtext" type="password" id="userpwd" />
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>
								<span ><input class="searchtext" name="submit" type="submit" value="Login" /></span>
								<span><input class="searchtext" style="margin-left: 40px" type="reset" value="Reset" /></span>
								
						</tr>
				  	</table>
				</form>
		</div>
			

		</div>		
	</body>
</html>
