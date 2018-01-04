(function ($) {

    $.fn.maxlength = function (options) {
        var settings = jQuery.extend({
		    events: [], // Array of events to be triggerd
		    maxCharacters: 10, // Characters limit
		    status: true, // True to show status indicator bewlow the element
		    statusClass: "status", // The class on the status div
		    statusText: "character left", // The status text
		    notificationClass: "notification", // Will be added to the emement when maxlength is reached
		    showAlert: false, // True to show a regular alert message
		    alertText: "You have typed too many characters.", // Text in the alert message
		    slider: false // Use counter slider
		}, options);

        // Add the default event
        $.merge(settings.events, ['keyup']);

        return this.each(function () {
            var item = $(this);
            var charactersLength = item.val().length;

            // Update the status text
            function updateStatus() {
                var charactersLeft = settings.maxCharacters - charactersLength;

                charactersLeft = charactersLeft < 0 ? 0 : charactersLeft;

                item.next("div").html(charactersLeft + " " + settings.statusText);
            }

            function checkChars() {
                var valid = true;

                // Too many chars?
                if (charactersLength >= settings.maxCharacters) {
                    // Too may chars, set the valid boolean to false
                    valid = false;
                    // Add the notification class when we have too many chars
                    item.addClass(settings.notificationClass);
                    // Cut down the string
                    item.val(item.val().substr(0, settings.maxCharacters));
                    // Show the alert dialog box, if its set to true
                    showAlert();
                }
                else if (item.hasClass(settings.notificationClass)) {
                    item.removeClass(settings.notificationClass);
                }

                if (settings.status) {
                    updateStatus();
                }
            }

            // Shows an alert msg
            function showAlert() {
                if (settings.showAlert) {
                    alert(settings.alertText);
                }
            }

            // Check if the element is valid.
            function validateElement() {
                return item.is('textarea') || item.filter("input[type=text]") || item.filter("input[type=password]");
            }

            // Validate
            if (!validateElement()) {
                return false;
            }

            // Loop through the events and bind them to the element
            $.each(settings.events, function (i, n) {
                item.bind(n, function (e) {
                    charactersLength = item.val().length;
                    checkChars();
                });
            });

            // Insert the status div
            if (settings.status) {
                item.after($("<div/>").addClass(settings.statusClass).html('-'));
                updateStatus();
            }

            // Remove the status div
            if (!settings.status) {
                var removeThisDiv = item.next("div." + settings.statusClass);

                if (removeThisDiv) {
                    removeThisDiv.remove();
                }
            }

            // Slide counter
            if (settings.slider) {
                item.next().hide();

                item.focus(function () {
                    item.next().slideDown('fast');
                });

                item.blur(function () {
                    item.next().slideUp('fast');
                });
            }
        });
    };
})(jQuery);