<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Domain </title>
</head>
<style>
	#sd-steps-div{
		background:#CCC;
		border-radius:10px;
		height:30px;
	}
	.sd-frm-div{
	    background: -moz-linear-gradient(center bottom , #EAEAEA, #FFFFFF, #EAEAEA) repeat scroll 0 0 transparent;
	    border-bottom: 15px solid #FFFFFF;
	    border-left: 15px solid #FFFFFF;
	    border-right: 15px solid #FFFFFF;
	    box-shadow: 12px 12px 12px #CCCCCC;
	    float: left;
	    height: 400px;
	    width: 60%;
	}
	.stps{
		background:#CCC;
		width:230px;
		float:left;
		height:30px;
	}
	.txt-fld{
	 	border-color: #BDC7D8;
	    border-radius: 5px 5px 5px 5px;
	    margin-left: 30px;
	    width: 250px;
	    height:30px;
	}
	.lbl-txt{
		color:#555581;	
		font-size:larger;
		font-weight:bold;
		font-family: Trebuchet MS;
	}
	.lbl-txt1{
		color:#555581;	
		font-size:x-large;
		font-weight:bold;
		font-family: Trebuchet MS;
	}
</style>
<body>
<div id="sd-main-div">
	<div class="clear-both" ></div>
	<div id="sd-steps-div">
		<div class="stps" >Steps</div>
		<div class="stps" >1.&nbsp;Choose&nbsp;your&nbsp;Domain</div>
		<div class="stps" >2.&nbsp;Choose&nbsp;a&nbsp;Template</div>
		<div class="stps" >3.&nbsp;Setup&nbsp;Mobile&nbsp;App</div>
		<div class="stps" >4.&nbsp;Go&nbsp;Live</div>
	</div>
	<div style="clear:both"></div>
	<div id="sd-content-div">
		<div style="height:800px;width:20%;float:left"></div>
		<div class="sd-frm-div">
		<br/><br/>
			<div class="lbl-txt1">How do you want your Website to be Called?</div><br/><br/><br/><br/>
			<div style="margin-left:50px;" align="left"><label class="lbl-txt">Domain-&nbsp;&nbsp;&nbsp; http://www.</label>&nbsp;<input class="txt-fld" style="margin-left:0px;" type="text" id="domainNameId" />&nbsp;<label class="lbl-txt">.businessadda.com</label></div><br/><br/>
			<div style="margin-left:50px;" align="left"><label class="lbl-txt">Website Title:</label>&nbsp;<input class="txt-fld" style="margin-left:69px;" type="text" id="websiteTitleId" /></div><br/><br/>
			<div style="margin-left:50px;" align="left"><label class="lbl-txt">Keywords:</label>&nbsp;<input class="txt-fld" style="margin-left:93px;" type="text" id="websiteTitleId" /></div><br/>
		</div>
		<div style="height:800px;width:20%;float:left"></div>
	</div>
</div>
</body>
</html>