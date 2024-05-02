$(document).ready(function() {
    $("#login").click(function(event) {
        event.preventDefault(); // Prevent form submission
		var Username= $("#uname").val(),
        $.ajax({
            type: "POST",
            url: "login",
            data: {
                Username: $("#uname").val(),
                Password: $("#pwd").val()
            },
            success: function(result) {
				if(result.response===1){
					document.cookie = "loggedIn=true; path=/;";
					document.cookie = "Username=Username,; path=/;"
                	alert("login success");
                	window.location.href = 'homepage.html';
                } else {
                    alert("Login unsuccessful");
                }
            },
            error: function(xhr, status, error) {
                console.error("Error occurred:", status, error);
                alert("An error occurred while processing your request.");
            }
        });
    });
});
