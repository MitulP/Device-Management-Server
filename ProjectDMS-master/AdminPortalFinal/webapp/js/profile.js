

$(function() {
  // Initialize form validation on the registration form.
  // It has the name attribute "registration"
  $("form[name='registration']").validate({
    // Specify validation rules
	 
    rules: {
      // The key name on the left side is the name attribute
      // of an input field. Validation rules are defined
      // on the right side
      firstname: "required",
      password: {
        required: true,
        minlength: 5
      },
	  
     
      newpassword: {
        required: true,
        minlength: 5
      },
	  
	  confirmpassword: {
        required: true,
		equalTo: "#newpassword",
        minlength: 5
      }
    },
    // Specify validation error messages
    messages: {
      firstname: "Please enter your username",
	   password: {
        required: "Please provide a password",
        minlength: "Your password must be at least 5 characters long",
		
      },
	   newpassword: {
        required: "Please provide a new password",
        minlength: "Your password must be at least 5 characters long"
      },
      confirmpassword: {
        required: "Please confirm password",
        minlength: "Your password must be at least 5 characters long",
		equalTo: "Passwords do not match"

      },
    },
	submitHandler: function(form) {
      form.submit();
    },
	 highlight: function(element) {
        $(element).css('element', '#ffdddd');
    }
	
  });
});
	
	