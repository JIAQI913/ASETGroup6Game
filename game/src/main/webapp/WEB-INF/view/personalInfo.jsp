<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Game Craft</title>
		<link rel="stylesheet" type="text/css" href="css/easyui.css">
		<link rel="stylesheet" type="text/css" href="css/icon.css">
		<link rel="stylesheet" type="text/css" href="css/demo.css">
		<link rel="stylesheet" type="text/css" href="css/flexslider.css" />
		
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/jquery.flexslider-min.js"></script>
		
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
			
			.basicform{
				margin: 50px auto;
				width: 900px;
			}
			.basicinfo{
				font-family: "arial";
				font-size: 20px;
				margin: 0 auto;
				line-height: 40px;
			}
			.searchtext{
				font-size: 20px;
				margin:5px auto;				
			}
			
			#preference{
				margin: 50px auto;
			}
		</style>
	</head>
	<body>
		<div id="container">
			<div id="head">
				<div >	<img src="img/logo.png" />
				</div>	
			</div>
			
			<h1>Personal Information</h1>
			<div class="basicform"  >
				<form name="form1" action="Login.html" onsubmit="return validate();">
					<table class="basicinfo">
							<tr >
								<td width="40%">ID:</td>
								<td>
								<input type="text"  class="searchtext" placeholder="Please Input your ID." name="search"/>
								</td>
							</tr>
							<tr>
								<td width="30%">Email:</td>
								<td>
									<input type="text"  class="searchtext" placeholder="Please Input your Email." name="search"/>
								</td>
							</tr>
							<tr>
								<td width="30%">Gender:</td>
								<td>
									<span><input type="radio" name="gender" value="0">Male</span> 
									<span><input type="radio" name="gender" value="1">Female</span> 
								</td>
							</tr>
							<tr style="height: 20px;"></tr>
							<tr style="line-height: 30px;">
								<td width="30%" style="vertical-align: top;">Preference:</td>
								<td>
									<input class="searchtext" type="checkbox" name= "preference" value="">
									<span style="padding-left:10px;">Action</span></br>
									<input class="searchtext" type="checkbox" name= "preference" value="">
									<span style="padding-left:10px;">Fighting</span></br>
									<input class="searchtext" type="checkbox" name= "preference" value="">
									<span style="padding-left:10px;">Adventure</span></br>
									<input class="searchtext" type="checkbox" name= "preference" value="">
									<span style="padding-left:10px;">Role Play</span></br>
									
								</td>
							</tr>
							<tr >
								<td width="30%"></td>
								<td>
								<input class="searchtext" name="submit" type="submit" value="Submit" />	
								</td>
							</tr>
					</table>
				</form>
			</div>
			
			
		</div>
		
	</body>
</html>
