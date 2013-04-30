<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="./themes/2/js-image-slider.css" rel="stylesheet"
	type="text/css" />
<script src="./themes/2/js-image-slider.js" type="text/javascript"></script>
<link href="./css/generic.css" rel="stylesheet" type="text/css" />
<style>
	.thumb-data{
		background:#BF5D9B;
		border-radius: 80px 80px 0px 0px !important;
		width:115px;height:25px;
		box-shadow: 1px 1px 11px #FFFFFF inset !important;
		-moz-box-shadow: 1px 1px 11px #FFFFFF inset !important;
		-webkit-box-shadow: 1px 1px 11px #FFFFFF inset !important;
	}
	.thumb-text{
		position: relative;
		text-decoration: none;
		top: 5px;
		font-weight:bold;
		color:#000000;
	}
	#thumbs{
		width:293px;
	}
	#thumbs .thumb{
		height:52px;
	}
	#thumbs .thumb-content {
	    width: 115px;
	}
	
	/*Custom thunb css*/
	#cthumbs {
	    border-top: 1px solid #CCCCCC;
	    color: #666666;
	    float: left;
	    font: 11px/13px Arial;
	    margin-left: 10px;
	    width: 293px;
	}
	#cthumbs .cthumb {
	    -moz-border-bottom-colors: none;
	    -moz-border-left-colors: none;
	    -moz-border-right-colors: none;
	    -moz-border-top-colors: none;
	    background: none repeat scroll 0 0 #EEEEEE;
	    border-color: #FFFFFF #CCCCCC #CCCCCC;
	    border-image: none;
	    border-right: 1px solid #CCCCCC;
	    border-style: solid;
	    border-width: 1px;
	    padding: 11px 8px;
	    height: 52px;
	}
	#cthumbs .cthumb:hover {
	    background: none repeat scroll 0 0 #FFF;
	}
	#cthumbs .cthumb-content {
	    float: left;
	    padding-left: 18px;
	    width: 115px;
	}
	
	.cthumb-data {
	 	color: #000000;
	    font-family: Trebuchet MS;
	    font-size: 26px;
	    height: 25px;
	    text-decoration: underline;
	    width: 115px;
	}
	
</style>
</head>
<body>
	<div id="sliderFrame" style="width:1103px;height:300px;border-radius: 0px 0px 5px 5px;">
		<div id="slider">


			<img src="./images/1.gif" alt="#cap1"
				style="width: 300px !important; height: 300px !important;" /> <img
				src="./images/2.gif" alt="Lorem ipsum dolor sit amet"
				style="width: 300px !important; height: 300px !important;" /> <img
				src="./images/3.gif" alt="Pure Javascript. No jQuery. No flash."
				style="width: 300px !important; height: 300px !important;" /> <img
				src="./images/4.gif" alt="#cap2"
				style="width: 300px !important; height: 300px !important;" />
		</div>
		<!--thumbnails-->
		<div id="cthumbs">
			<div class="cthumb"  onclick="javascript:createPopup();">
				<div class="cthumb-content">
					<div class="cthumb-data">Sign&nbsp;Up</div>
					Sign up for free.
				</div>
				<div style="clear: both;"></div>
			</div>
			<div class="cthumb">
				<div class="frame">
				</div>
				<div class="cthumb-content">
					<div class="cthumb-data">Sign&nbsp;In</div>
					Sign In and Create your Web site easily.
				</div>
				<div style="clear: both;"></div>
			</div>
			<div class="cthumb" onclick="javascript:loadSelectDomainPage();">
				<div class="frame">
				</div>
				<div class="cthumb-content">
					<div class="cthumb-data">Try&nbsp;Now</div>
					Choose your template that suits you firm.
				</div>
				<div style="clear: both;"></div>
			</div>
			<div class="cthumb">
				<div class="frame">
				</div>
				<div class="cthumb-content">
					<div class="cthumb-data">Quick&nbsp;Tour</div>
					Customize the template according to you.
				</div>
				<div style="clear: both;"></div>
			</div>
		</div>
	</div>
</body>
</html>