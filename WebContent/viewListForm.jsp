 <%@ page language="java" pageEncoding="ISO-8859-1"%>
  <%@ page import="java.util.*"%>
  <%@ page import="com.acit.csam.model.CSAMInfo"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View List Status</title>
        <link href="lib/css/bootstrap.css" rel="stylesheet">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <%
            String err=" ";
            String userName=null;
            if(request.getSession().getAttribute("userName")!=null){
            	userName =request.getSession().getAttribute("userName").toString();
            }else{
            	response.sendRedirect("LogoutController");
            }
           
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
		<a class="menu-links" href="#"><img src="images/icon_menu.png"></a>
	</div>
	<div class="col-lg-10 col-md-10 col-sm-9 txt-right">
		<p class="logged-user">Kunchala, Sridhar</p>
		<a href="/" class="logout">Logout</a>
	</div>
</div>
</div>
    <body>
<%String addFlag;
if(request.getAttribute("addFlag")!=null) {
	addFlag=(String)request.getAttribute("addFlag");
	if(addFlag.equalsIgnoreCase("addSuccess")){
%>
<div>Cloud Service Aquisition request has been successfully logged</div>
<%
}
}%>    
<form method="POST" action="createRequestController" name="requestForm" class="form-horizontal">
	<div>
  	<div class="col-lg-2 col-md-2 col-sm-3 left-menus">
  		<div class="active"><img src="images/icon_View_Active.png">View Status
  			<div class="arrow-right" style="margin-top: 0px !important;"></div>
  		</div>
  		<div><a href="createRequestForm.jsp"><img src="images/icon_Create_normal.png">Create New Request</a></div>
	</div>
	<div class="col-lg-10 col-md-10 col-sm-9">
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
<%
   				List<CSAMInfo> reqList=null; 				
 				if(request.getAttribute("RequestList")!=null){
 					reqList = (List)request.getAttribute("RequestList");
 					System.out.println("reqList  ##"+reqList.toString());
	 			   Iterator itr=reqList.iterator();
	 			   while(itr.hasNext()){
	 				  CSAMInfo csamInfo=(CSAMInfo)itr.next();
	 				  //System.out.println("from list cluodService@@"+csamInfo.getCloudService());
	 				// System.out.println("from list cardId@@"+csamInfo.getCardId());
   %>
			      <tr>
			        <td><%=csamInfo.getCloudService()%></td>
			        <td><%=csamInfo.getLob()%></td>
			        <td><%=csamInfo.getBusinessDesc()%></td>
			        <td><span><%=csamInfo.getPriority()%></span></td>
			        <td><%=csamInfo.getCos()%></td>
			        <td><a href="CSARRequest?req=carddetails&cardid=<%=csamInfo.getCardId()%>">Status Details</a></td>
			      </tr>
			       <%}
   } %>
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
<footer style="background: #b8b8b8">
         	<div class="footer" style="color: #4b4b4b">
        		Copyright &#169; 2004 - 2017 Accenture. All rights reserved.
        	</div>
        </footer>
     <script src="lib/js/jquery-1.11.3.min.js"></script>
                <script src="lib/js/bootstrap.min.js"></script>
                <script src="scripts/main.js"></script>
</body>
</html>
