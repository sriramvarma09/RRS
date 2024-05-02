/**
 * 
 */
 // Function to check login status (you can customize this)
        function checkLogin() {
            const isLoggedIn = getCookie("loggedIn"); // Assume you have a cookie named "loggedIn"
            if (isLoggedIn) {
            	console.log("hello");
            	document.getElementById("login").innerHTML="Welcome";
				$("#login").innerHTML="welcome"+getCookie("USername");
            } 
        }
        function login(){
        	const isLoggedIn = getCookie("loggedIn"); // Assume you have a cookie named "loggedIn"
            if (! isLoggedIn)
            	window.location.href = "LoginPage.html";
        }

        // Function to view trains (you can customize this)
        function viewTrains() {
            // Redirect to the view trains page (e.g., viewtrains.html or a servlet)
            window.location.href = "viewtrains.html"; // Change the URL as needed
        }

        // Function to book tickets (you can customize this)
        function bookTickets() {
            // Redirect to the book tickets page (e.g., booktickets.html or a servlet)
            window.location.href = "TicketsBooking.html"; // Change the URL as needed
        }

        // Helper function to get cookie value (you can customize this)
        function getCookie(name) {
            const cookies = document.cookie.split("; ");
            for (const cookie of cookies) {
                const [cookieName, cookieValue] = cookie.split("=");
                if (cookieName === name) {
                    return cookieValue;
                }
            }
            return null;
        }
        window.addEventListener('beforeunload', function (e) {
   		document.cookie = "loggedIn=true; path=/;";
   });
 