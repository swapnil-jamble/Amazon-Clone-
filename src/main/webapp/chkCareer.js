function chkCareer() {
    const email = document.getElementById('email').value;

    if (email == null) {
        alert('Please Enter the Email');
        return false;  // Prevent form submission
    }
   
		alert("Your Information Successfully Submitted")
	
    return true;  // Allow form submission
}