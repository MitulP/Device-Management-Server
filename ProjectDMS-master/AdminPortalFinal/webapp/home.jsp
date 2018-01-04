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
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css">
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<!-- <script src="assets/js/myapp.js"></script> -->
<script src="assets/js/filter.js"></script>
<script src="assets/js/masterlist.js"></script>
<script
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">DMS Admin</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">My Account <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="profile.jsp">Profile</a></li>
					</ul></li>
				<li><a href="Logout"><span
						class="glyphicon glyphicon-log-in"></span> Logout</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<ul class="nav nav-tabs">
			<li class="active"><a data-toggle="tab" href="#home">Home</a></li>
			<!-- <li><a data-toggle="tab" href="#menu1">Filter Logs</a></li> -->
			<li><a data-toggle="tab" href="#menu2">Master List</a></li>
			<li><a data-toggle="tab" href="#menu3">Import</a></li>
		</ul>

		<div class="tab-content">
						<div id="home" class="tab-pane fade in active">
				<h3>Logs</h3>
				<hr />

				<div class="col-lg-12">
					<div class="col-sm-6 col-lg-4">
						<div class="form-group">
							<input type="text" id="search" class="search form-control" placeholder="Search by username" />
						</div>
					</div>
					<div class="col-sm-6 col-lg-3">
						<select class="form-control" id="status" style="margin-right: 10%">
							<option value="all">All</option>
							<option value="new">NEW</option>
							<option value="register">REGISTER</option>
							<option value="unregister">UNREGISTER</option>
							<option value="not_valid">NOT-VALID</option>
						</select><br />
					</div>
				</div>

				<table id="filterlogs" class="table table-striped table-bordered"
					cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>Event ID</th>
							<th>Time Stamp</th>
							<th>Formated Message</th>
							<th>User ID</th>
							<th>User Name</th>
							<th>Device ID</th>
							<th>Device Status</th>
						</tr>
					</thead>
					
				</table>
				 <ul class="pager">
					<li><button type="button" class="btn btn-success" id="prev">prev</button></li>
					<li><button type="button" class="btn btn-success" id="next">next</button></li>
				</ul>

			</div>
			<div id="menu2" class="tab-pane fade">
				<h3>Master List</h3>
				<hr />
				<table id="masterlist" class="table table-striped table-bordered"
					cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>User ID</th>
							<th>User Name</th>
							<th>Device ID</th>
							<th>Status</th>
							<th>Valid Till</th>
						</tr>
					</thead>
					

				</table>
				<ul class="pager">
					<li style=""><button type="button" class="btn btn-success"
							id="prevMaster">prev</button></li>
					<li><button type="button" class="btn btn-success"
							id="nextMaster">next</button></li>
				</ul>
			</div>

			<div id="menu3" class="tab-pane fade">
				<h3>Import File</h3>
				<hr />

				<form ENCTYPE="multipart/form-data" ACTION="uploadExcel" METHOD=POST
					style="margin: auto; width: 50%;">
					<br> <br> <br>

					<table border="2">
						<tr>
							<td colspan="2"><p align="center">
									<B>UPLOAD THE FILE</B></td>
						</tr>
						<tr>
							<td><b>Choose the file To Upload:</b></td>
							<td><input id="fileUpload" name="file" type="file" accept=".xls" required/> <br /></td>
						</tr>
						<tr>
							<td colspan="2">
							<p id="error1" style="display:none; color:#FF0000;">
							Invalid File Format! File Format Must Be Either .xls.
							</p>
							<p id="error2" style="display:none; color:#FF0000;">
							Maximum File Size Limit is 16MB.
							</p>
						<p align="right">
							<input type="submit" id="btnUpload" class="btn btn-primary"
										value="Upload" />
								</p></td>
						</tr>
					</table>

					<h5>
						Note: Please upload file having <b>.xls </b> extension and size <b>
							less than 16 MB </b>
					</h5>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
