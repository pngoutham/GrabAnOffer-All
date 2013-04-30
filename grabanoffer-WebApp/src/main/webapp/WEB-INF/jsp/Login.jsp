<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

	<link href="./javascript/jquery/development-bundle/themes/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css"/>
  	<script src="./javascript/jquery/js/jquery-1.4.2.min.js"></script>
  	<script src="./javascript/jquery/development-bundle/ui/jquery-ui-1.7.2.custom.js"></script>
  	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
	<link href="./css/login.css" rel="stylesheet" type="text/css" media="screen" />
	<script>
		$(function() {
		    var button = $('#loginButton');
		    var box = $('#loginBox');
		    var form = $('#loginForm');
		    button.removeAttr('href');
		    button.mouseup(function(login) {
		        box.toggle();
		        button.toggleClass('active');
		    });
		    form.mouseup(function() { 
		        return false;
		    });
		    $(this).mouseup(function(login) {
		        if(!($(login.target).parent('#loginButton').length > 0)) {
		            button.removeClass('active');
		            box.hide();
		        }
		    });
		});
	</script>
</head>
<body>
	<div id="bar">
	    <div id="container">
	        <!-- Login Starts Here -->
	        <div id="loginContainer">
	            <a href="#" id="loginButton"><span>Login</span></a>
	            <div style="clear:both"></div>
	            <div id="loginBox">                
	                <form id="loginForm">
	                    <fieldset id="body">
	                        <fieldset>
	                            <label for="email">Email Address</label>
	                            <input type="text" name="email" id="email" />
	                        </fieldset>
	                        <fieldset>
	                            <label for="password">Password</label>
	                            <input type="password" name="password" id="password" />
	                        </fieldset>
	                        <input type="submit" id="login" value="Sign in"  style="background-color:#107710;color: #FFFFFF;"/>
	                        <label for="checkbox"><input type="checkbox" id="checkbox" />Remember me</label>
	                    </fieldset>
	                    <span><a href="#">Forgot your password?</a></span>
	                </form>
	            </div>
	        </div>
	        <!-- Login Ends Here -->
	    </div>
	</div>
</body>
</html>