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
<form method="POST" action="createRequestController" name="requestForm" class="form-horizontal">
	<div>
  	<div class="col-lg-2 col-md-2 col-sm-2 left-menus">
  		<div class="active"><img src="images/icon_View_Active.png">View Status
  			<div class="arrow-right" style="margin-top: 0px !important;"></div>
  		</div>
  		<div><a href="createRequestForm.jsp"><img src="images/icon_Create_normal.png">Create New Request</a></div>
	</div>
	<div class="col-lg-10 col-md-10 col-sm-10">
		<div class="row" style="padding: 30px 60px;">
		<p class="title-head ">View List of Status</p>
  		<div class="col-lg-12 col-md-12 col-sm-12">
  			<table class="table">
			    <thead>
			      <tr>
			        <th>Cloud Service</th>
			        <th>Line of Business</th>
			        <th>Description</th>
			        <th>Priority</th>
			        <th>Class of Service</th>
			        <th>&nbsp;</th>
			      </tr>
			    </thead>
			    <tbody>
			      <tr>
			        <td>Lorem Ipusum</td>
			        <td>Lorem Ipusum</td>
			        <td>Description Going here...</td>
			        <td><span>High</span></td>
			        <td>LoremIpusum</td>
			        <td><a>Status Details</a></td>
			      </tr>
			    </tbody>
  			</table>
  		</div>
  	</div>
	</div>
	<div>
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