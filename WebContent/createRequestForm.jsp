<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Request Page</title>
    </head>
    <body>
user logged in successfully:
<form method="POST" action="CreateRequestController" name="loginForm" class="form-horizontal" style="margin-top: 0; padding: 25px 10% 0 10%;">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-3 control-label">Cloud Service</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="cloudService" name="cloudService">
    </div>
  </div>
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-3 control-label">Line of Business</label>
    <div class="col-sm-9">
      <input type="text" class="form-control" id="lob" name="lob">
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
  </div>
</form>
</body>
</html>