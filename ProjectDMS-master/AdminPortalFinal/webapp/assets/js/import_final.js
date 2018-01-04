
    $('input[type="submit"]').prop("disabled", true);
var a=0;
//binds to onchange event of your input field
$('#fileUpload').bind('change', function() {
if ($('input:submit').attr('disabled',false)){
	$('input:submit').attr('disabled',true);
	}
var ext = $('#fileUpload').val().split('.').pop().toLowerCase();
if ($.inArray(ext, ['xls']) == -1){
	$('#error1').slideDown("slow");
	$('#error2').slideUp("slow");
	a=0;
	}else{
	var fileSize = (this.files[0].size);
	if (fileSize > 16000000){
	$('#error2').slideDown("slow");
	a=0;
	}else{
	a=1;
	$('#error2').slideUp("slow");
	}
	$('#error1').slideUp("slow");
	if (a==1){
		$('input:submit').attr('disabled',false);
		}
}
});

