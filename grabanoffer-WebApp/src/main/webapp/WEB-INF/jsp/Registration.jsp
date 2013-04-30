<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	
	<link href="./javascript/jquery/development-bundle/themes/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css"/>
  	<script src="./javascript/jquery/js/jquery-1.4.2.min.js"></script>
  	<script src="./javascript/jquery/development-bundle/ui/jquery-ui-1.7.2.custom.js"></script>
	<style>
		.signup-text{
			background-color: seashell;
		    border-radius: 5px 5px 5px 5px;
		    color: #A4A4A4;
		    font-weight: bold;
		    height: 32px;
		    text-align: center;
		    width: 330px;
		    border-left: 5px solid #D20606;
		}
		
		.signupName {
			float: right;
			font-family:'Comic Sans MS',Arial,Helvetica,sans-serif;
			font-size:14px;
			font-weight: bold;
			margin-top: 2px;
			margin-left:4px;
			margin-right:4px;
		    text-shadow: 2px 2px 2px #000000, 2px 2px 4px #FFFFFF;
		}
		
		.signupBtn {
			background: none repeat scroll 0 0 #BF5D9B;
 			border-radius: 80px 80px 0 0 !important;
    		box-shadow: 1px 1px 1px #FFFFFF inset !important;
    		font-family: Verdana,Arial,Helvetica,sans-serif;
    		font-size: 11px;
    		font-weight: bold;
    		width:100px;
    		height:30px;
		}
	</style>
	<script type="text/javascript">
		var regFormFlag = true;
		function toggleRegistrationForm(){
			//$("#login-form-div").toggle("slow");
			if(regFormFlag){
				$("#reg-frm-div").show("slide", { direction: "up" }, 1000);
				$("#video-div").hide();
				regFormFlag = false;
			}else{
				$("#reg-frm-div").hide("slide", { direction: "up" }, 1000);
				$("#video-div").show();
				regFormFlag = true;				
			}
		}
		
		// Javascript: removes Default text when textbox is focused.
		$(document).ready(function(){
			$('input[class=signup-text]').focus(function () {
				if ($(this).val() == $(this).attr("title")) {
					$(this).val("");
				}
			}).blur(function () {
				if ($(this).val() == "") {
					$(this).val($(this).attr("title"));
				}
			});
		});
	</script>
</head>	
<body>
	<div id="fb-root"></div>
	<script>
		(function(d, s, id) {
	  		var js, fjs = d.getElementsByTagName(s)[0];
		  	if (d.getElementById(id)) return;
		  	js = d.createElement(s); js.id = id;
		  	js.src = "//connect.facebook.net/en_US/all.js#xfbml=1&appId=507377362651971";
		  	fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>
	<br/>
	<div id="reg-frm-div" align="center" style="">
		<!-- <div id="reg-options-div">
			<div id="fb-signup">
				<div class="fb-login-button" data-show-faces="true" data-width="500" data-size="xlarge" data-max-rows="1">Sign up</div>
			</div>
			<div id="reg-signup">
			</div>
		</div> -->
		
		<form method="POST" action="reg.htm">
			<input class="signup-text" type="text" value="Firstname" title="Firstname"/><br/><br/>
			<input class="signup-text" type="text" value="Lastname" title="Lastname"/><br/><br/>
			<input class="signup-text" type="text" value="Email" title="Email"/><br/><br/>
			<input class="signup-text" type="password" value="Password" title="Password"/><br/><br/>
			<input class="signup-text" type="text" value="Phone" title="Phone"/><br/><br/>
			<input class="signupBtn" type="submit" value="Sign Up" title="Sign Up"/>
		</form>
	</div>
</body>
</html>