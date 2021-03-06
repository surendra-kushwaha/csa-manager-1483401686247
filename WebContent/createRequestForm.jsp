<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge">
        <title>Create Request</title>
        <link href="lib/css/bootstrap.css" rel="stylesheet">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <%
   // String userId=(String)session.getAttribute("userId");
    //Syste.out.println("userid recieved in session"+userId);
    %>
    <%
            String err=" ";
            String userName="";
            if(request.getSession().getAttribute("userName")!=null){
            	userName =request.getSession().getAttribute("userName").toString();
            }else{
            	response.sendRedirect("LogoutController");
            }
            //System.out.println("userName @@"+userName);
           
      %>
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
		<a class="menu-links addCls" href="#"><img src="images/icon_menu.png"></a>
	</div>
	<div class="col-lg-10 col-md-10 col-sm-9 txt-right">
		<p class="logged-user"><%=userName%></p>
		<a href="login.jsp" class="logout">Logout</a>
	</div>
</div>
</div>
    <body onload="validate()">
    
<form method="POST" action="CSARRequest" name="requestForm" class="form-horizontal">
	<div>
  	<div class="col-lg-2 col-md-2 col-sm-3 left-menus">
  		<div class=""><a href="CSARRequest?req=view&userId=<%=userName%>"><img src="images/icon_View_Normal.png">View Status</a></div>
  		<div class="active"><img src="images/icon_Create_Active.png">Create New Request
  			<div class="arrow-right"></div>
  		</div>
	</div>
	<div class="col-lg-10 col-md-10 col-sm-9">
		<div class="row pad-adju">
		<p class="title-head">Cloud Service Acquisition Request (CSAR)</p>
		<%String addFlag;
if(request.getAttribute("addFlag")!=null) {
	addFlag=(String)request.getAttribute("addFlag");
	if(addFlag.equalsIgnoreCase("addSuccess")){
%>
<div class="success-msg">Cloud Service Acquisition request has been successfully logged</div>
<%
}
}%> 
<%String validationFlag;
if(request.getAttribute("validationMsg")!=null) {
	validationFlag=(String)request.getAttribute("validationMsg");
	if(validationFlag.equalsIgnoreCase("validationFailed")){
%>
<div class="login-error" style "float:left;">All fields are mandatory</div>
<%
}
}%>

<%String ApiError;
if(request.getAttribute("APIError")!=null) {
	ApiError=(String)request.getAttribute("APIError");
	if(ApiError.equalsIgnoreCase("InvalidResponse")){
%>
<div class="login-error" style "float:left;">Request could not created as leankit API response is invalid </div>
<%
}
}%>
  		<div class="col-lg-5 col-md-5 col-sm-5">
  			<div class="form-group">
		  	<label for="inputEmail3"><span class="astri">*</span>Cloud Service</label>
		     <input type="text" class="form-control" id="cloudService" name="cloudService" required>
		  </div>
		  <div class="form-group">
		  	<label for="inputEmail3"><span class="astri">*</span>Line of Business</label>
		    <input type="text" class="form-control" id="lob" name="lob" required>
		  </div>
		  <div class="form-group">
		  	<label for="inputEmail3"><span class="astri">*</span>Priority</label>
		  	<select class="form-control" id="priority" name="priority" required>
		  		<option value="">Select Priority</option>		  		
		  		<option value="Critical">Critical</option>
		  		<option value="High">High</option>
		  		<option value="Normal">Normal</option>
		  		<option value="Low">Low</option>
		  	</select>
		  </div>
		  <div class="form-group" style="margin-bottom: 0">
		  	<label for="inputEmail3"><span class="astri">*</span>URL of the Cloud Service</label>
		    <input type="url" class="form-control" id="cloudServiceUrl" name="cloudServiceUrl" placeholder='https://www.any-url.com' required>
		  </div>
  		</div>
  		<div class="col-lg-1 col-md-1 col-sm-1">&nbsp;</div>
  		<div class="col-lg-5 col-md-5 col-sm-5">
  			<div class="form-group">
		  	<label for="inputEmail3"><span class="astri">*</span>Business Description</label>
		    <textarea class="form-control" id="businessDesc" name="businessDesc" required></textarea>
		  </div>
		  <div class="form-group">
		  	<label for="inputEmail3"><span class="astri">*</span>Class of Service</label>
		    <select class="form-control" id="cos" name="cos" required>
		  		<option value="">Select CoS</option>		  		
		  		<option value="Date Dependent">Date Dependent</option>
		  		<option value="Regulatory">Regulatory</option>
		  		<option value="Expedite">Expedite</option>
		  		<option value="Standard">Standard</option>
		  	</select>
		  	<input type="hidden" name="userId" value="<%=userName%>"/>
		  	<input type="hidden" name="req" value="create"/>
		  </div>
  		</div>
  	</div>
	</div>
	</div>
  <button type="submit" class="btn btns btns-right" style="margin-bottom: 80px;">Create Request</button>
</form>
<style>
	.form-horizontal .form-group {
		margin-bottom: 30px;
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
