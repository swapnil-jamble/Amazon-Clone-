function chkPassword() {
    const password = document.getElementById('password').value;
    const passwordCheck = document.getElementById('passwordCheck').value;

    if (password !== passwordCheck) {
        alert('Passwords do not match. Please try again.');
        return false;  // Prevent form submission
    }
    return true;  // Allow form submission
}