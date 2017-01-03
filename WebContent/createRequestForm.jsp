<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Request</title>
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
	<div class="col-lg-4 col-md-4 col-sm-2 txt-right" style="margin-top: 20px;">
		<img src="images/Poweredby_ACIT.png">
	</div>
</div>
<div class="top-bar-next row">
	<div class="col-lg-2 col-md-2 col-sm-2">
		<a class="menu-links" href="#"><img src="images/icon_menu.png"></a>
	</div>
	<div class="col-lg-10 col-md-10 col-sm-10 txt-right">
		<p class="logged-user">Kunchala, Sridhar</p>
		<a href="/" class="logout">Logout</a>
	</div>
</div>
</div>
    <body>
    <%
    String userId=(String)request.getAttribute("userId");
    %>
<form method="POST" action="CSARRequest" name="requestForm" class="form-horizontal">
	<div>
  	<div class="col-lg-2 col-md-2 col-sm-2 left-menus">
  		<div class=""><a href="viewListForm.jsp"><img src="images/icon_View_Normal.png">View Status</a></div>
  		<div class="active"><img src="images/icon_Create_Active.png">Create New Request</div>
	</div>
	<div class="col-lg-10 col-md-10 col-sm-10">
		<div class="row" style="padding: 30px 60px;">
		<p class="title-head ">Cloud Service Acquisition Request (CSAR)</p>
  		<div class="col-lg-5 col-md-5 col-sm-5">
  			<div class="form-group">
		  	<label for="inputEmail3"><span class="astri">*</span>Cloud Service</label>
		     <input type="text" class="form-control" id="cloudService" name="cloudService">
		  </div>
		  <div class="form-group">
		  	<label for="inputEmail3"><span class="astri">*</span>Line of Business</label>
		    <input type="text" class="form-control" id="lob" name="lob">
		  </div>
		  <div class="form-group">
		  	<label for="inputEmail3"><span class="astri">*</span>Priority</label>
		  	<select class="form-control" id="priority" name="priority">
		  		<option value="Low">Low</option>
		  		<option value="Medium">Medium</option>
		  		<option value="High">High</option>
		  		<option value="Normal">Normal</option>
		  	</select>
		  </div>
		  <div class="form-group">
		  	<label for="inputEmail3"><span class="astri">*</span>URL of the Cloud Service</label>
		    <input type="text" class="form-control" id="cloudServiceUrl" name="cloudServiceUrl">
		  </div>
  		</div>
  		<div class="col-lg-5 col-md-5 col-sm-5">
  			<div class="form-group">
		  	<label for="inputEmail3"><span class="astri">*</span>Business Description</label>
		    <textarea class="form-control" id="businessDesc" name="businessDesc"></textarea>
		  </div>
		  <div class="form-group">
		  	<label for="inputEmail3"><span class="astri">*</span>Class of Service</label>
		    <select class="form-control" id="cos" name="cos">
		  		<option value="">Select CoS</option>
		  		<option value="Regulatory">regulatory</option>
		  		<option value="expetite">expetite</option>
		  	</select>
		  	<input type="hidden" name="userId" value="<%=userId%>"/>
		  	<input type="hidden" name="req" value="create"/>
		  </div>
  		</div>
  	</div>
	</div>
	<div>
  <button type="submit" class="btn btns btns-right">Create Request</button>
  <!-- 
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-3 control-label">Cloud Service</label>
    <div class="col-sm-9">
       <textarea class="form-control" id="businessDesc" name="businessDesc"></textarea>
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-3 control-label">Line of Business</label>
    <div class="col-sm-9">
      <textarea class="form-control" id="cos" name="cos"></textarea>
    </div>
  </div>
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-3 control-label">Priority</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="priority" name="priority">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-3 control-label">URL of the Cloud Service</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="cloudServiceUrl" name="cloudServiceUrl">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-3 control-label">Business Description</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="businessDesc" name="businessDesc">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-3 control-label">Class of Service</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="cos" name="cos">
    </div>
  </div>
  
  
  <div class="form-group">
  <div class="col-sm-offset-3" style="padding-left:18px">
  	 <input type="button" value="reset" class="btn btns resetbtn" style="margin-right: 10px;"/>
  	 <button type="submit" class="btn btns">Login</button>
  	 </div>
  </div>-->
</form>
     <script src="lib/js/jquery-1.11.3.min.js"></script>
                <script src="lib/js/bootstrap.min.js"></script>
                <script src="scripts/main.js"></script>
</body>
</html>