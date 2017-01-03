<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="lib/css/bootstrap.css" rel="stylesheet">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
<div class="top-big-header-new sub-pages-head">

<div class="top-bar-new row">
	<div class="col-lg-8 col-md-8 col-sm-8 mob-fix">
		<a class="logo-links" href="#"><img src="images/Logo.png"></a>
		<span class="header-h3">Cloud Service Acquisition Manager</span>
	</div>
	<div class="col-lg-4 col-md-4 col-sm-2 txt-right">
		<img src="images/Poweredby_ACIT.png">
	</div>
</div>
</div>
                        
    	<div class="main-p-container">

						
						<div class="container">
    	
   				
   				<div class="login-container">
<%
String inValidUser=null;
if(request.getAttribute("loginMassage")!=null){
	inValidUser = (String)request.getAttribute("loginMassage");
	System.out.println("message recieved::"+inValidUser);
%>	<div class="login-error"><%=inValidUser%></div>
<%} %>

<%
String sessionExpired=null;
if(request.getAttribute("LoginError")!=null){
	sessionExpired = (String)request.getAttribute("LoginError");
	System.out.println("message recieved::"+sessionExpired);
%>	<div class="login-error"><%=sessionExpired%></div>
<%} %>
<%
if(session!=null){
	session.invalidate();
}
 %>
<form method="POST" action="LoginController" name="loginForm" class="form-horizontal" style="margin-top: 0; padding: 25px 10% 0 10%;">
  <p class="login-head-p">LOGIN</p>
  <p class="ln-brk">&nbsp;</p>
  <div class="form-group">
  	<label for="inputEmail3">User Name</label>
    <input type="text" class="form-control" id="username" name="userName" placeholder="User Name">
  </div>
  <div class="form-group">
  	<label for="inputPassword3">Password</label>
    <input type="text" class="form-control" id="password" name="password" placeholder="Password">
  </div>
  <button type="submit" class="btn btns">Login</button>
</form>
        </div></div>
        </div>
        </div>
    </body>
    <script>
   					var errormsgs="";
   					var updateErr = "";
    			 </script>
     <script src="lib/js/jquery-1.11.3.min.js"></script>
                <script src="lib/js/bootstrap.min.js"></script>
                <script src="scripts/main.js"></script>
</html>