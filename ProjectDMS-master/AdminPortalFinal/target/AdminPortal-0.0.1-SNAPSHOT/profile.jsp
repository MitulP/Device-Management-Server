<%@page import="com.admin.bean.Admin"%>
<%@page import="com.admin.dao.AdminLogin"%>
<!DOCTYPE html>
<html lang="en">
<head>

  <title>Admin Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="assets/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css">
  <script src="assets/js/jquery.min.js"></script>
  <script src="assets/js/bootstrap.min.js"></script>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
  <script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
  <link rel="stylesheet" href="assets/css/profile.css">
  
  <% 
/*   response.setHeader("Cache-control","no-store"); //HTTP 1.1 
  response.setHeader("Pragma","no-cache"); //HTTP1.0 
  response.setDateHeader("Expire",0); //prevents caching at the proxy server 
   */
	String uname=(String)session.getAttribute("uname");
	String pass	=(String)session.getAttribute("pass");
	Admin a=new Admin();
	a.setUname(uname);
	a.setPassword(pass);
	if(!AdminLogin.checkLogin(a)){
		response.sendRedirect("index.jsp");
	}

%>
  
</head>
<body>
  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="home.jsp">DMS Admin</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <li class="dropdown">
	  
	  <a class="dropdown-toggle" data-toggle="dropdown" href="#">My Account
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Profile</a></li>
        </ul>
      </li>
      <li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </ul>
  </div>
  </nav>
  
<div class="row">
							<div class="col-xs-12">
								
								<h1> &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; 
								Admin Profile</h1>
									<%
			String s=request.getParameter("status");
			if(s!=null&&s!=""){
			out.println("<center style='color:red;font-weight:bold;'>"+s+"</center>");	
			 response.setHeader("Cache-control","no-store"); //HTTP 1.1 
			  response.setHeader("Pragma","no-cache"); //HTTP1.0 
			  response.setDateHeader("Expire",0); //prevents caching at the proxy server 	
			}else{
				  response.setHeader("Cache-control","no-store"); //HTTP 1.1 
				  response.setHeader("Pragma","no-cache"); //HTTP1.0 
				  response.setDateHeader("Expire",0); //prevents caching at the proxy server 
			}
			%>
								<form id="formProfile" method="post" name="Profile" action="changepasswordServ" class="form-horizontal" role="form">
								
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> User Name </label>
										
										<div class="col-sm-9">
											<input type="text" value="<%= session.getAttribute("uname") %>" name="firstname" id="firstname"  placeholder="UserName" class="col-xs-10 col-sm-5" readonly />
										</div>
									</div>
			
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> Current Password </label>
										
										<div class="col-sm-9">
											<input type="password" name="password" id="password"  placeholder="Password" class="col-xs-10 col-sm-5" />
											
										</div>
										
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> New Password </label>

										<div class="col-sm-9">
											<input type="password" name="newpassword" id="newpassword" placeholder="Password" class="col-xs-10 col-sm-5" />
											
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-right" for="form-field-2"> Confirm Password </label>

										<div class="col-sm-9">
											<input type="password" name="confirmpassword" id="confirmpassword" placeholder="Password" class="col-xs-10 col-sm-5" />
											
										</div>
									</div>
																
									<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
											<button type="submit" class="btn btn-primary" id="submit">
												<i class="ace-icon fa fa-check bigger-110"></i>
												Submit
											</button>

											&nbsp; &nbsp; &nbsp;
											<button class="btn btn-primary" type="reset">
												<i class="ace-icon fa fa-undo bigger-110"></i>
												Cancel
											</button>
										</div>
									</div>
																		
								</form>
						
							

							</div><!-- /.col -->
						</div><!-- /.row -->
							<script src="assets/js/jquery-2.1.4.min.js"></script>
							<script src="assets/js/jquery.validate.min.js"></script>
							<script src="assets/js/profile.js"></script>

</body>
</html>
