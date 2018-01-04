/*$(function() {
	
	
	// code for jquery dataTable
	var $table = $('#filterlogs');
	var count=1;
	
	sendAjaxRequestForMaster($(this),'http://deviceservice-env.us-east-2.elasticbeanstalk.com/AdminService/viewlogs/'+count+'/10');
	// execute the below code only where we have this table
	if ($table.length) {
		
	         $("#prev").click(function(e){
	        	
	        	  count=count-1;
	        	  sendAjaxRequestForMaster($(this),'http://deviceservice-env.us-east-2.elasticbeanstalk.com/AdminService/viewlogs/'+count+'/10');
	              e.preventDefault();
	          });
	          $("#next").click(function(e){
	        	  
	        	  count=count+1;
	        	  sendAjaxRequestForMaster($(this),'http://deviceservice-env.us-east-2.elasticbeanstalk.com/AdminService/viewlogs/'+count+'/10'); 
	              e.preventDefault();
	          });
	}
});
function sendAjaxRequestForMaster(element,urlToSend) {
    var clickedButton = element;
 // code for jquery dataTable	
	var $table = $('#filterlogs');
	// execute the below code only where we have this table
	if ($table.length) {
		
		$table.DataTable({
					"bPaginate": false,
					
					ajax : {
						url : urlToSend,
						dataSrc : '',
						dataType: 'json'
					},
					columns : [
							{
								data : 'event_id'
							},
							{
								data : 'timestmp'
							},
							{
								data : 'formatted_message'
							},
							{
								data : 'arg0'
							},
							{
								data : 'arg1'
							},
							{
								data : 'arg2'
							},
							{
								data : 'arg3'
							},
							],
					"destroy": true
				});
		
	}
}
	*/