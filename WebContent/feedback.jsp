<!DOCTYPE html>
<%
            String err=" ";
            String userName="";
            if(request.getSession().getAttribute("userName")!=null){
            	userName =request.getSession().getAttribute("userName").toString();
            }else{
            	//response.sendRedirect("LogoutController");
            }
            //System.out.println("userName @@"+userName);
           
      %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Feedback Details</title>
        <link href="lib/css/bootstrap.css" rel="stylesheet">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <div class="top-big-header-new sub-pages-head container-fluid">

<div class="top-bar-new row">
	<div class="col-lg-2 col-md-2 col-sm-2">
		<a class="logo-links" href="#"><img src="images/Logo.png"></a>
		
	</div>
	<div class="col-lg-6 col-md-6 col-sm-6">
	<p class="header-h3">Cloud Service Acquisition Manager</p>
	</div>
	<div class="col-lg-4 col-md-4 col-sm-4 txt-right" style="margin-top: 20px;">
		<img src="images/Poweredby_ACIT.png">
	</div>
</div>
<div class="top-bar-next row">
	<div class="col-lg-2 col-md-2 col-sm-3">
		<a class="menu-links" href="#"><img src="images/icon_menu.png"></a>
	</div>
	<div class="col-lg-10 col-md-10 col-sm-9 txt-right">
		<p class="logged-user"><%=userName%></p>
		<a href="/" class="logout">Logout</a>
	</div>
</div>
</div>
    <body>
	<div>
  	<div class="col-lg-2 col-md-2 col-sm-3 left-menus">
  		<div><a href="CSARRequest?req=view"><img src="images/icon_View_Normal.png">View Status</a>
  		</div>
  		<div><a href="createRequestForm.jsp"><img src="images/icon_Create_normal.png">Create New Request</a></div>
	</div>
	<div class="col-lg-10 col-md-10 col-sm-9">
		<div class="row pad-adju">
		<p class="title-head "><label>Customer Satisfaction Survey </label><span class='back-span'><a href="CSARRequest?req=view"> < Back</a></span><span class='feedback-span'><a class="right-btn btn btns" href=''>Submit</a></span></p>
  		<div class="table-responsive feedback-forms">
  				<br />
  		<table class="table borderless">
  			<tr>
  				<td><p>Has CCSC staff improved your experience with SaaS onboarding process?</p></td>
  				<td>
  					<ul>
		  				<li title='Very Satisfied'><a href = ''><span class="round-box">5</span></a></li>
		  				<li title='Somewhat Satisfied'><a href = ''><span class="round-box">4</span></a></li>
		  				<li title='Neither Satisfied nor dissatisfied'><a href = ''><span class="round-box">3</span></a></li>
		  				<li title='Somewhat Dissatisfied'><a href = ''><span class="round-box">2</span></a></li>
		  				<li title='Very Dissatisfied'><a href = ''><span class="round-box">1</span></a></li>
		  			</ul>
  				</td>
  			</tr>
  			<tr>
  				<td><p>Are you satisfied with how your request was handled?</p></td>
  				<td>
  					<ul>
		  				<li title='Very Satisfied'><a href = ''><span class="round-box">5</span></a></li>
		  				<li title='Somewhat Satisfied'><a href = ''><span class="round-box">4</span></a></li>
		  				<li title='Neither Satisfied nor dissatisfied'><a href = ''><span class="round-box">3</span></a></li>
		  				<li title='Somewhat Dissatisfied'><a href = ''><span class="round-box">2</span></a></li>
		  				<li title='Very Dissatisfied'><a href = ''><span class="round-box">1</span></a></li>
		  			</ul>
  				</td>
  			</tr>
  			<tr>
  				<td><p>Do feel that the CCSC staff helped you better understand the SaaS onboarding process?</p></td>
  				<td>
  					<ul>
		  				<li title='Very Satisfied'><a href = ''><span class="round-box">5</span></a></li>
		  				<li title='Somewhat Satisfied'><a href = ''><span class="round-box">4</span></a></li>
		  				<li title='Neither Satisfied nor dissatisfied'><a href = ''><span class="round-box">3</span></a></li>
		  				<li title='Somewhat Dissatisfied'><a href = ''><span class="round-box">2</span></a></li>
		  				<li title='Very Dissatisfied'><a href = ''><span class="round-box">1</span></a></li>
		  			</ul>
  				</td>
  			</tr>
  			<tr>
  				<td><p>Have you found the CCSC team to be friendly and good communicators?</p></td>
  				<td>
  					<ul>
		  				<li title='Very Satisfied'><a href = ''><span class="round-box">5</span></a></li>
		  				<li title='Somewhat Satisfied'><a href = ''><span class="round-box">4</span></a></li>
		  				<li title='Neither Satisfied nor dissatisfied'><a href = ''><span class="round-box">3</span></a></li>
		  				<li title='Somewhat Dissatisfied'><a href = ''><span class="round-box">2</span></a></li>
		  				<li title='Very Dissatisfied'><a href = ''><span class="round-box">1</span></a></li>
		  			</ul>
  				</td>
  			</tr>
  			
  		</table>
  		</div>
  	</div>
	</div>
	</div>
	<style>
		.left-menus {
			min-height: 1000px;
		}
	</style>
     <script src="lib/js/jquery-1.11.3.min.js"></script>
                <script src="lib/js/bootstrap.min.js"></script>
                <script src="scripts/main.js"></script>
                <footer style="background: #b8b8b8">
         	<div class="footer" style="color: #4b4b4b">
        		Copyright &#169; 2004 - 2017 Accenture. All rights reserved.
        	</div>
        </footer>
</body>
</html>