<%@page import="com.admin.bean.Admin"%>
<%@page import="com.admin.dao.AdminLogin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
 <% 
 response.setHeader("Cache-control","no-store"); //HTTP 1.1 
 response.setHeader("Pragma","no-cache"); //HTTP1.0 
 response.setDateHeader("Expire",0); //prevents caching at the proxy server 
 
	String uname=(String)session.getAttribute("uname");
	String pass	=(String)session.getAttribute("pass");
	Admin a=new Admin();
	a.setUname(uname);
	a.setPassword(pass);
	if(!AdminLogin.checkLogin(a)){
		response.sendRedirect("index.jsp");
	}
%>
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
  <link rel="stylesheet" href="assets/css/ErrorFileUpload.css">
 

 
  
  </head>
<body>
  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp">DMS Admin</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <li class="dropdown">
	  
  </div>
  </nav>
  
  <div id="main_body">
		<center>			
    <h2> Error Occurred!!! </h2>
	        <!-- <img  src="error.png" height="100" width="100"> -->

	<h4> <center> File is not uploaded successfully... Try Again </h4>

		<h4> Please check following instructions for uploading file:</h4> </center>
		
		<div class="center-justified">
	<h5><center> <p  style="text-align:start">File extension should be .xls only  </br> 
					  File size should not be more than 16 MB </br> 
					  Duplicate devices are not allowed </br> 
			          The format of content in the file should be as shown in the picture below only </br> </p>  </h5> 
					  
					  
</div>
<center>
  <img id="borderimg1"src="image\error.png" height="350" width="350" >  
  </center>
  <a class="navbar-brand" href="home.jsp">Go to home page</a>
	  </div>
  	</div><!-- /.col -->
	</div><!-- /.row -->
							
	
	

</body>
</html>
