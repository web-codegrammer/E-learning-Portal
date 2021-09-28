<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Details Form</title>
</head>
<body>
	<h2>Contact Details</h2>
	<hr>
	<form action="contact_details" method="post">
		<pre>
		User ID			:	<input type="number" name="id"><br>
		Name			:	<input type="text" name="name"><br>
		Email			:	<input type="text" name="email"><br>
		Phone			:	<input type="number" name="phone"><br>
		Message			:	<input type="text" name="message"><br>
		<input type="submit" name="Message" value="SUBMIT"> | <input type=reset name="reset" value="RESET"><br>
		</pre>
	</form>
</body>
</html-->

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-color: black;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #04AA6D;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>
<title>Contact Form</title>
</head>
<body>

<form action="contact_details" method="post">
  <div class="container">
    <h1>Connect and Link</h1>
    <p>Kindly fill all the details.</p>
    <hr>

    <label for="user_id"><b>ID</b></label>
    <input type="text" placeholder="Enter ID in 100 to 150" name="id" id="id" required>

    <label for="name"><b>Name</b></label>
    <input type="text" placeholder="Enter Name" name="name" id="name" required>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" id="email" required>

    <label for="phone"><b>Phone</b></label>
    <input type="text" placeholder="Enter Phone" name="phone" id="phone" required>

    <label for="message"><b>Message</b></label>
    <input type="text" placeholder="Enter Message" name="message" id="message" required>
    <hr>

    <button type="submit" class="registerbtn">Submit</button>
  </div>
  
</form>

</body>
</html>
