<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Grab An Offer</title>
<link href="http://fonts.googleapis.com/css?family=Arvo|Open+Sans:400,300,600,700" rel="stylesheet" type="text/css" />
<link href="./css/style.css" rel="stylesheet" type="text/css" media="screen" />
<style>
	#search-categories{
		width: 780px;
		height: 55px;
		margin: 0px auto;
		padding: 0px;
	}
	#search-categories a {
		display: block;
		letter-spacing: 1px;
		margin: 0px 10px;
		padding: 10px 20px;
		text-decoration: none;
		text-align: center;
		text-transform: uppercase;
		font-family: 'Arvo', serif;
		font-size: 14px;
		font-weight: normal;
		color: #000;
		border: none;
		border-radius: 5px;
	}
	
	#search-categories a:hover, #search-categories .current_page_item a {
		
		border-radius: 5px;
		text-decoration: none;
		color: #107710;
	}
	
	#search-categories .current_page_item a {
		border-radius: 5px;
		color: #107710;
		font-weight:bold;
	}
	td{
		background: none repeat scroll 0 0 #FFFFFF;
		border: 1px solid #CCCCCC;
		box-shadow: 0 7px 5px #E7DFD7;
	}
</style>
</head>
<body>
<div id="menu-wrapper" style="float:left;">
	<br/>
	<div id="header-wrapper" align="left">
		<div id="header" align="left">
			<div id="logo">
				<h1><a href="#">Grab<span>anoffer</span></a></h1>
			</div>
		</div>
	</div>
	<br/>
	<div style="clear:both;"></div>
	<div id="menu">
		<div class="current_page_item"><a href="#">Search</a></div>
		<div><a href="#">Offers&nbsp;&&nbsp;Deals</a></div>
		<div><a href="#">Mobile&nbsp;App</a></div>
		<div><a href="#">how&nbsp;it&nbsp;works</a></div>
		<div><a href="#">FAQ</a></div>
		<div><a href="#">Contact&nbsp;Us</a></div>
		<div><a href="#">Post&nbsp;an&nbsp;Offer</a></div>
	</div>
	<!-- end #menu --> 
</div>

<div id="wrapper" style="float:left;margin-top:10px;"> 	
	<div id="page">
		<div id="page-bgtop">
			<div id="page-bgbtm">
				<div id="login-bar" align="right">
					<div style="margin-top:-37px;"><jsp:include page="Login.jsp" /></div>
				</div>
				<div style="clear: both;">&nbsp;</div>
				<div id="sidebar">
					<div class="post">
						<h2 class="title"><a href="#">Search&nbsp;&nbsp;&nbsp;for&nbsp;&nbsp;&nbsp;offers </a></h2>
						 <div id="search" >
							<form method="post" action="#">
								<div style="width: 600px;">
									<input class="txtStyle" type="text" name="s" value=""></input>
									<input class="btnStyle" type="submit" value="Search"></input>
								</div>
							</form>
						</div>
					</div>
					<div id="search-categories">
						<div class="current_page_item" style="float:left"><a href="#">By&nbsp;Vendor</a></div>
						<div  style="float:left"><a href="#">By&nbsp;Location</a></div>
						<div  style="float:left"><a href="#">Others</a></div>
					</div>
				</div>				
		</div>
	</div>
</div>
	<div style="clear: both;">&nbsp;</div>
</div> 
<div id="sidebar2" style="margin-top:10px;">
		<ul>
			<li>
				<h2>Recent Offers</h2>
			</li>
		</ul>
		<table cellspacing="10" style="margin-left:-20px;"  width="240px">
			<tr>
				<td valign="middle"><img class="plain-div" width="60px;" height="60px;" src="./images/thumbnails/gao.jpg"/><label style="margin:-7px 3px 2px 16px"> Flat 50% Discount</label></td>
			</tr>
			<tr>
				<td><img class="plain-div" width="60px;" height="60px;" src="./images/thumbnails/thumb1.jpg"/><label style="margin:-7px 3px 2px 16px"> Flat 22% Discount</label></td>
			</tr>
			<tr>
				<td><img class="plain-div" width="60px;" height="60px;" src="./images/thumbnails/thumb2.jpg"/><label style="margin:-7px 3px 2px 16px"> Flat 70% Discount</label></td>
			</tr>
			<tr>
				<td><img class="plain-div" width="60px;" height="60px;" src="./images/thumbnails/thumb3.jpg"/><label style="margin:-7px 3px 2px 16px"> Flat 49% Discount</label></td>
			</tr>
			<tr>
				<td><img class="plain-div" width="60px;" height="60px;" src="./images/thumbnails/thumb4.jpg"/><label style="margin:-7px 3px 2px 16px"> Flat 30% Discount</label></td>
			</tr>
			<tr>
				<td><img class="plain-div" width="60px;" height="60px;" src="./images/thumbnails/thumb5.png"/><label style="margin:-7px 3px 2px 16px"> Flat 62% Discount</label></td>
			</tr>
		</table>
	</div>
<br/>
<!-- <div id="footer">
	<p>&copy; BusinessAdda.com</p>
</div> -->
<!-- end #footer -->
</body>
</html>