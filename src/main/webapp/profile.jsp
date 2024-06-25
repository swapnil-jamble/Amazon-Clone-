<%
   String name = (String) session.getAttribute("name");
   String email = (String) session.getAttribute("email");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Profile</title>
<link rel="stylesheet" href="./profile.css">
</head>
<body>

	<form action="myProfileURL" method="post" onsubmit="return chkProfile()">
		<div id="main">
			<div id="container">
				<h1>Add Profile</h1>
				<hr>
				<input type="text" name="name" id="name" placeholder="Enter the Name" value="<%= name != null ? name : "" %>" required><br>
				<input type="text" name="email" id="email" placeholder="Enter Email ID" value="<%= email != null ? email : "" %>"  required><br>
				<input type="text" name="phoneno" id="phoneno" placeholder="Enter Phone Number" required><br>
				<input type="text" name="city" id="city" placeholder="Enter City" required><br>
				<input type="text" name="pincode" id="pincode" placeholder="Enter City Pincode" required><br>
				<input type="submit" value="Submit Info">
			</div>
		</div>
	</form>
    <script src="chkProfile.js"></script>
</body>
</html>

