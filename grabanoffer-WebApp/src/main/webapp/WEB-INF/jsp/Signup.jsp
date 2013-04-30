<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
		<style>
			.ui-widget-content {
			    background: none !important;
			    border: 0px solid #ffffff !important;
			    color: #222222;
			}
			.ui-state-active, .ui-widget-content .ui-state-active{
				background:#5868b8 !important;
				margin-left:-3px !important;
				
			}
			.ui-widget-header {
			    background: #CCCCCC !important;
			    border: none !important;
			    color: #222222;
			    font-weight: bold;
			     border-radius: 0px !important;
				-moz-border-radius: 0px !important;
				-webkit-border-radius: 0px !important;
			}
			.ui-state-active a, .ui-state-active a:link, .ui-state-active a:visited	{
				background: none !important;
				color:#ffffff !important;
			}
			.popup-header{
			 	background: #D3D3D3;
			    border-radius: 0 10px 0 0;
			    height: 39px;
			    margin-left: -15px;
			    margin-top: -10px;
			    width: 509px;
			}
		</style>
		<script>
		 $(function() {
			 $( "#tabs" ).tabs();
		 });
		</script>
</head>
<body>
	<div align="right" style="width: 50px; margin-left: 463px; margin-top: -28px;"><img src="./images/icons/close.png" style="cursor:pointer;" onclick="closePopup();"/></div>
	<div class="popup-header">
		<br>
		<label style="">Don't have an Account? Sign up with us.!!!</label>
	</div>
	<br/>
	<div style="clear:both;"> </div>
	<div id="tabs" style="margin-top:-20px;border-radius: 0px !important;margin-left: -19px;height:100px;width: 511.5px !important;">
		<ul>
			<li style="border-radius:5px 5px 0px 0px;width: 246px;height:44px;margin-top: -5px;"><a style="margin-left:44px;font-weight:bold;font-size:larger;" href="#tabs-1">Sign Up</a></li>
			<li style="margin-left:-3px;border-radius:5px 10px 0px 0px;width: 246px;height:44px;margin-top: -5px;"><a style="margin-left:44px;font-weight:bold;font-size:larger;" href="#tabs-2">Sign In</a></li>
		</ul>
		<div id="tabs-1">
			<p><jsp:include page="Registration.jsp" /></p>
		</div>
		<div id="tabs-2">
			<p><jsp:include page="Login.jsp" /></p>
		</div>
	</div>
</body>
</html>