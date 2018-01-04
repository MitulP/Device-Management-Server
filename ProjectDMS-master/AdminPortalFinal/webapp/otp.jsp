<%@page language="java" %>
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
  <%
  response.setHeader("Cache-control","no-store"); //HTTP 1.1 
 response.setHeader("Pragma","no-cache"); //HTTP1.0 
 response.setDateHeader("Expire",0); //prevents caching at the proxy server 
 
 %>
  
  </head>
<body>
  <nav class="navbar navbar-inverse">
    <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index.jsp">DMS Admin</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <li class="dropdown">
	  <style>
	  .be-detail-header { border-bottom: 1px solid #edeff2; margin-bottom: 50px; }

	  </style>

	  <style type="text/css">
		 .error {
		color: red;
		margin-left:25px;
		}
		form { 
<!--padding-top:50px; 
margin-top: 20px;
align: center;-->


margin-top:250px;
}
</style>

  </div>
  </nav>
  
  							
						
								
    <div class="row">
        <div class="col-sm-6 col-sm-offset-3">
            <br>
            <img src="https://cdn2.iconfinder.com/data/icons/luchesa-part-3/128/SMS-512.png" class="img-responsive" style="width:200px; height:200px;margin:0 auto;"><br>
           
            <h1 class="text-center">Verify your mobile number</h1><br>
            <p class="lead" style="align:center"></p><p> An OTP has been sent to your Mobile Number. Please enter the 6 digit OTP below to change password successfully.</p>  <p></p>
        <br>
       
            <form method="post" id="veryfyotp" name="veryfyotp" action=verifyOTP>
                
                <div class="row">  
                <table>
			<%
			String s=request.getParameter("status");
			if(s!=null&&s!=""){
			out.println("<center><tr style='color:red;font-weight:bold;'><td>"+s+"<td></tr><center>");	
				
			}
			%>
                <div class="form-group col-sm-8">
                	                
					 <input type="text" class="form-control" name="otp" id="password" placeholder="Enter your OTP number" required="">
                </div>
                <button type="submit" class="btn btn-primary  pull-right col-sm-3">Verify</button>
                </div>
            </form>
        <br><br>
        </div>
    </div>        
</div>

							</div><!-- /.col -->
						</div><!-- /.row -->
							<script src="assets/js/jquery-2.1.4.min.js"></script>
					<script src="assets/js/jquery.validate.min.js"></script>

	
	

</body>
</html>

<script>

$(function() {
  $("form[name='veryfyotp']").validate({
	  
	 
    rules: {
     
    	otp: {
        required: true,
		digits: true,
		minlength: 6,
		maxlength: 6
      }
    },
    messages: {
     
    	otp: {
        required: "Please enter password",
		digits: "Only digits are allowed",
        minlength: "Your password must be 6 digits long",
		maxlength: "Your password must be 6 digits long only"
		
      },
    },
	submitHandler: function(form) {
      form.submit();
    }
	
  });
});
</script>