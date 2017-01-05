  <%@ page import="com.acit.csam.model.CSAMInfo"%>
  <%@ page import="java.util.*"%>
  <%@ page import="com.acit.csam.model.Comments"%>
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
        <title>Status Details</title>
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
		<a href="login.jsp" class="logout">Logout</a>
	</div>
</div>
</div>
    <body onload="changes();">
	<div>
  	<div class="col-lg-2 col-md-2 col-sm-3 left-menus">
  		<div><a href="CSARRequest?req=view"><img src="images/icon_View_Normal.png">View Status</a>
  		</div>
  		<div><a href="createRequestForm.jsp"><img src="images/icon_Create_normal.png">Create New Request</a></div>
	</div>
	<div class="col-lg-10 col-md-10 col-sm-9">
		<div class="row pad-adju">
		<p class="title-head "><label>Status Details </label><span class='back-span'><a href="CSARRequest?req=view"> < Back</a></span><span class='feedback-span'><a class="right-btn btn btns" href='feedback.jsp'>Feedback</a></span></p>
  		<%
    if(request.getAttribute("cardDeatils")!=null){
    	CSAMInfo csamInfo=(CSAMInfo)request.getAttribute("cardDeatils");
    
    %>
  		<div class="col-lg-12 col-md-12 col-sm-12 details-page">  			
  			
  			<table class=""table>
  			<tr>
  				<td width="50%"><label>Cloud Service</label></td>
  				<td width="50%"><span class="colons">:</span><span><%=csamInfo.getCloudService()%></span</td>
  			</tr>
  			<tr>
  				<td width="50%"><label>Description</label></td>
  				<td width="50%"><span class="colons">:</span><span><%=csamInfo.getBusinessDesc()%></span</td>
  			</tr>
  			<tr>
  				<td width="50%"><label>Line of Business</label></td>
  				<td width="50%"><span class="colons">:</span><span><%=csamInfo.getLob()%></span</td>
  			</tr>
  			<tr>
  				<td width="50%"><label>Priority</label></td>
  				<td width="50%"><span class="colons">:</span><span><%=csamInfo.getPriority()%></span</td>
  			</tr>
  			<tr>
  				<td width="50%"><label>Class of Service</label></td>
  				<td width="50%"><span class="colons">:</span><span><%=csamInfo.getCos()%></span</td>
  			</tr>
  			<tr>
  				<td width="50%"><label>Status</label></td>
  				<td width="50%"><span class="colons">:</span><span><%=csamInfo.getCardStatus()%></span</td>
  			</tr>
  			<tr>
  				<td width="50%"><label>Last Updated Date</label></td>
  				<td width="50%"><span class="colons">:</span><span><%=csamInfo.getLastUpdatedDate()%></span</td>
  			</tr>
  			<tr>
  				<td width="50%"><label>Assigned To</label></td>
  				<td width="50%"><span class="colons">:</span><span><%=csamInfo.getAssignedTo()%></span</td>
  			</tr>
  		</table>
  			<p><label>Comments</label></p>
  			<div class="comments-box" style="margin-bottom: 40px;">
  			<table class="table">
  				
  				<tr>
  					<td class="col-lg-3 col-md-3 col-sm-3"><p class='small-title'>Post Date</p></td>
  					<td class="col-lg-4 col-md-4 col-sm-4"><p class='small-title'>Posted By</p></td>
  					<td class="col-lg-5 col-md-5 col-sm-5"><p class='small-title'>Comments</p></td>
  				</tr>
  				<%
  				List<Comments> commentList=(List<Comments>)request.getAttribute("CommentsList"); 
	 			   Iterator itr=commentList.iterator();
	 			   while(itr.hasNext()){
	 				  Comments comment=(Comments)itr.next();
  				%>
  				<tr>
  					<td class="col-lg-3 col-md-3 col-sm-3"><%=comment.getPostDate()%></td>
  					<td class="col-lg-4 col-md-4 col-sm-4"><%=comment.getPostedBy()%></td>
  					<td class="col-lg-5 col-md-5 col-sm-5"><%=comment.getComment()%></td>
  				</tr>
  				<%}  				
  				%>
  			</table> 			
  			</div>
  		</div>
  		<%
			}
		%>
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
