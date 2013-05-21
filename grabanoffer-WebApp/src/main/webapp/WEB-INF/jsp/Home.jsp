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
<link href="./javascript/jquery/development-bundle/themes/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css"/>
<script src="./javascript/jquery/js/jquery-1.4.2.min.js"></script>
<script src="./javascript/jquery/development-bundle/ui/jquery-ui-1.7.2.custom.js"></script>
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
	#collapse {
	    background: url("./images/loginArrow.png") no-repeat scroll 53px 7px transparent;
	    display: block;
	    font-weight: bold;
	    padding: 7px 29px 9px 10px !important;
	    text-shadow: 1px 1px #FFFFFF;
	}
	.hide-sidebar2{
		background: none repeat scroll 0 0 #107710;
	    border: 1px solid #E7DFD7;
	    border-radius: 0 10px 10px 0;
	    color: #FFFFFF;
	    font-weight: bold;
	    margin-left: -31px;
	    width: 36px;
	}
	
.mn-dwn-arw {
    border-color: #FFFFFF teal;
    border-style: solid;
    border-width: 4px 4px 0;
    height: 0;
    margin-left: 2px;
    margin-top: 10px;
    position: absolute;
    width: 0;
    background-color: #000;
}
.hdtb-mn-o, .hdtb-mn-c {
    background: none repeat scroll 0 0 #FFFFFF;
    border: 1px solid #D6D6D6;
    box-shadow: 0 2px 4px #D6D6D6;
    color: #333333;
    left: 943px;
    line-height: 17px;
    padding-bottom: 5px;
    padding-top: 5px;
    position: absolute;
    top: 97px;
    width: 100px;
    z-index: 103;
}

.hdtb_mitem:hover {
    background: none repeat scroll 0 0 #CCC;
    color: #333333;
}
</style>
<script>
	function hideDiv(id){
		$("#small-sidebar").show("slow");
		$("#sidebar").hide("slow");
	}
	var heightSB;
	function hideRecentOffersJS(id,btnId){
		if(btnId == 'hideBtn'){
			heightSB = $("#sidebar2").width();
						 
			$("#sidebar2").css("width","10px");
			$("#sidebar2 li").css("transform","rotate(90deg)");
			$("#"+id).hide();
			$("#hideBtn").hide();
			$("#showBtn").show();
		}else if(btnId == 'showBtn'){
			$("#"+id).show();	
			$("#sidebar2").css("width",heightSB);
			$("#sidebar2 li").css("transform","none");
			$("#hideBtn").show();
			$("#showBtn").hide();
		}
	}
	function showMoreOptionsJs(moreDiv){
		$("#"+moreDiv).show();
	}
	function moreOptionsJs(id,moreDiv){
		$("#displayOption").html($("#"+id).html()+'&nbsp;&nbsp;');
		$('<img class="plain-div" width="12px;" height="12px;" src="./images/close.png"/>').appendTo($("#displayOption"));
		$("#displayOption").show();
		$("#"+moreDiv).hide();
	}
</script>
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
									<input class="btnStyle" type="button" onclick="hideDiv(this.id);" value="Search"></input>
								</div>
							</form>
						</div>
					</div>
					<div id="search-categories">
						<div class="current_page_item" style="float:left"><a href="#">By&nbsp;Vendor</a></div>
						<div  style="float:left"><a href="#">By&nbsp;Location</a></div>
						<div  style="float:left"><a href="#">Others</a></div>
						<div  style="float:right">
				            <a href="#" id="collapse" ></a>
					    </div>
					</div>
				</div>
				
				<div id="small-sidebar" style="display:none;">
					<div id="small-search">
						<form method="post" action="#">
							<div style="width: 810px;float:left;padding: 6px 20px;">
								<input class="small-txtStyle" type="text" name="s" value=""></input>
								<input class="small-btnStyle" type="submit" value="Search"></input>&nbsp;&nbsp;
								<label id="displayOption" style="display:none;color: #000000;font-weight: bold;border:1px solid #CCC;background:#CCC;margin-right:20px;padding:2px 2px 0 5px;border-radius:5px;">
								</label>
								<a style="float:right;padding: 6px 20px;" >
									<span class="mn-hd-txt" onclick="showMoreOptionsJs('hdtb_more_mn');">More</span>
									<span class="mn-dwn-arw"></span>
								</a>
								<div id="hdtb_more_mn" class="hdtb-mn-o" style="display:none;">
									<div class="hdtb_mitem">
										<a id="byLocation" onclick="moreOptionsJs(this.id,'hdtb_more_mn');">By Location</a>
									</div>
									<div class="hdtb_mitem">
										<a id="byVendor" onclick="moreOptionsJs(this.id,'hdtb_more_mn');">By Vendor</a>
									</div>
									<div class="hdtb_mitem">
										<a id="other" onclick="moreOptionsJs(this.id,'hdtb_more_mn');">Other</a>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div style="clear: both;">&nbsp;</div>
				<div style="width:500px;height:600px;">
				
				</div>				
		</div>
	</div>
</div>
	<div style="clear: both;">&nbsp;</div>
</div>
 
<div id="sidebar2" style="margin-top:10px;">
		<div><input id="hideBtn" type="button" class="hide-sidebar2" value="&gt;&gt;" onclick="hideRecentOffersJS('recent-offers-table',this.id);"/></div>
		<div><input id="showBtn" type="button" class="hide-sidebar2" style="display:none;" value="&lt;&lt;" onclick="hideRecentOffersJS('recent-offers-table',this.id);"/></div>
		<div style="clear: both;">&nbsp;</div>
		<ul>
			<li>
				<h2>Recent&nbsp;Offers</h2>
			</li>
		</ul>
		<table id="recent-offers-table" cellspacing="10" style="margin-left:-20px;"  width="240px">
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