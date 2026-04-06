document.addEventListener('DOMContentLoaded', function () {
    const menuToggle = document.getElementById('mobile-menu');
    const navBar = document.querySelector('.nav-bar');

//    menuToggle.addEventListener('click', function () {
//        menuToggle.classList.toggle('active');
//        navBar.classList.toggle('active');
//    });

    // Get the cancel booking modal
    var cancelModal = document.getElementById("custom-alert"); //For order summary
//    var cancelModalBook = document.getElementById("custom-alert-book") //For confirm booking 

    // Get the button that opens the cancel booking modal
    var cancelBtn = document.getElementById("cancel-booking");
//    var cancelBtnBook = document.getElementById("cancel-booking-book");

    // Get the <span> element that closes the modals
    var cancelSpan = document.getElementsByClassName("close")[0];
//    var cancelSpanBook = document.getElementsByClassName("closeBook")[1];

    // Get the buttons inside the cancel booking modal
    //Order Summary
    var confirmCancel = document.getElementById("confirm-cancel");
    var cancel = document.getElementById("cancel");
    
    //Confirm Book
//    var confirmCancelBook = document.getElementById("confirm-cancel-book");
//    var cancelBook = document.getElementById("cancel-book");

    // When the user clicks the cancel booking button, open the cancel booking modal 
    //Order Summary page
    cancelBtn.onclick = function(event) {
        event.preventDefault(); // Prevent the default action
        cancelModal.style.display = "block";
    }
    
    //Confirm booking page
//    cancelBtnBook.onclick = function(event) {
//        event.preventDefault(); // Prevent the default action
//        cancelModalBook.style.display = "block";
//    }

    // When the user clicks on <span> (x) in cancel booking modal, close the modal
    //Order summary page
    cancelSpan.onclick = function() {
        cancelModal.style.display = "none";
    }
    
    //Confirm Order Page
//    cancelSpanBook.onclick = function() {
//        cancelModalBook.style.display = "none";
//    }

    // When the user clicks on "No" in cancel booking modal, close the modal
    //Order Summary Page
    cancel.onclick = function() {
        cancelModal.style.display = "none";
    }
    
//    //Confirm Order Page 
//    cancelBook.onclick = function() {
//        cancelModalBook.style.display = "none";
//    }
    
    // When the user clicks on "Yes" in cancel booking modal, redirect to CancelBookingServlet with information
    //Order Summary Page
    confirmCancel.onclick = function() {
        var rentalId = document.getElementById("rentalId").value;
        var userId = document.getElementById("userId").value;
        window.location.href = 'cancelBookingServlet?rentalId=' + rentalId + "&userId=" + userId;
    }
    
    //Confirm order Page
//    confirmCancelBook.onclick = function() {
//        var userId = document.getElementById("userId").value;
//        window.location.href = 'cancelBookingServlet?userId='+ userId;
//    }

    // When the user clicks anywhere outside of the cancel booking modal, close it
    //Order Summary Page
    window.onclick = function(event) {
        if (event.target == cancelModal) {
            cancelModal.style.display = "none";
        }
    }
    
    //Confirm Order Page
//    window.onclick = function(event) {
//        if (event.target == cancelModalBook) {
//            cancelModalBook.style.display = "none";
//        }
//    }
});
