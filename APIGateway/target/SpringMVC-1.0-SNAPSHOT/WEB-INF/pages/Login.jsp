<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1"
	crossorigin="anonymous">

<style>
#search {
	float: right;
	width: 350px;
}

.search {
	padding: 5px 0;
	width: 230px;
	height: 30px;
	position: relative;
	left: 10px;
	float: left;
	line-height: 22px;
}

.search input {
	position: absolute;
	width: 200px;
	float: Left;
	margin-left: 210px;
	-webkit-transition: all 0.7s ease-in-out;
	-moz-transition: all 0.7s ease-in-out;
	-o-transition: all 0.7s ease-in-out;
	transition: all 0.7s ease-in-out;
	height: 30px;
	line-height: 18px;
	padding: 0 2px 0 2px;
	border-radius: 1px;
	top: 10px;
	right: 50px;
}

.search:hover input, .search input:focus {
	width: 200px;
	margin-left: 0px;
}

.btn {
	height: 30px;
	position: absolute;
	right: 10px;
	top: 7px;
	border-radius: 1px;
	color: white;
	background-color: #2f2f2f;
}
</style>
<style>
body {
	font-family: "Lato", sans-serif;
	font-size: 22;
	background-image: url(airport2.jpg);
	background-attachment: fixed;
	background-position: center;
	background-size: cover;
	background-repeat: no-repeat;
}

.mySlides {
	display: none
}
</style>
<style>
.form-wrap {
	padding: 30px;
	border: 1px solid #ddd;
	border-radius: 3px;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
	-webkit-box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
	-moz-box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
	background-color: #ffffff;
	width: 450px;
	margin-bottom: 10%;
}

.form-wrap button {
	font-family: "Roboto", sans-serif;
	text-transform: uppercase;
	outline: 0;
	background: #c00;
	border: 0;
	color: #FFFFFF;
	font-size: 14px;
	-webkit-transition: all 0.3 ease;
	transition: all 0.3 ease;
	cursor: pointer;
	border: 0;
}

.form-wrap button:hover, .form-wrap button:active, .form-wrap button:focus
	{
	background: #900;
}

.form-wrap .message {
	margin: 15px 0 0;
	color: #c00;
	font-size: 14px;
	text-align: right;
}

.form-wrap .message a {
	color: #c00;
	text-decoration: none;
	text-align: center;
}

.form-wrap .section-title {
	margin-top: -5px;
	font-weight: normal;
	text-align: center;
	font-weight: normal;
	font-weight: normal;
	color: #696969;
}
</style>
<style>
input[type="email"]:valid {
	color: green;
}

input[type="email"]:valid  ~ .input-email::before {
	content: "\2713";
	color: green;
}

input[type="email"]:invalid {
	color: red;
}

input[type="text"]:valid {
	content: "\2713";
	color: green;
}

input[type="text"]:invalid {
	color: red;
}

input[id="user"]:valid  ~ .input-user::before {
	content: "\2713";
	color: green;
}

input[id="employee"]:valid  ~ .input-employee::before {
	content: "\2713";
	color: green;
}

input[id="password"]:valid  ~ .input-pass::before {
	content: "\2713";
	color: green;
}
</style>

</head>
<body>
	<!-- Navbar -->
	<div class="w3-top">
		<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid" style="background-color: #2f2f2f">
			<div class="navbar-header">
				<a class="navbar-brand" href="#" style="color: white">please
					Login</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a class="navbar-brand" href="#" style="color: white"></a></li>
			</ul>
		</div>
		</nav>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<div class="container-FLUID">
		<div class="row">
			<div class="col-md-12 col-md-offset-7 form-wrap">
				<!-- Nav tabs -->
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#login"
						aria-controls="login" role="tab" data-toggle="tab">LOGIN</a></li>
					<li role="presentation"><a href="#register"
						aria-controls="register" role="tab" data-toggle="tab">SIGN UP</a></li>
				</ul>

				<!-- Tab panes -->
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane active" id="login">
						<h3>LOGIN</h3>
						<hr>
						<form action="/login">
							<label class="sr-only" for="user">Username</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<input type="text" class="form-control" id="j_username"
									name="j_username" placeholder="Username" data-original-title=""
									title="" required>
							</div>
							<br> <label class="sr-only" for="inputPassword">Password</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-lock"></i></span>
								<input type="password" class="form-control" id="j_password"
									placeholder="Password" name="j_password" required>
							</div>
							<div>
								<span style>
									<p class="message">${data }</p>
								</span>
							</div>
							<div class="checkbox">
								<label> <input type="checkbox"> Remember my
									password
								</label>
							</div>
							<input type="hidden" name="hidd" value="login">
							<button type="submit" class="btn btn-primary">LOGIN</button>

						</form>
					</div>
					<div role="tabpanel" class="tab-pane" id="register">
						<h3>SIGN UP</h3>
						<hr>
						<form role="form" action="/j_spring_security_check" method="post">
							<label class="sr-only" for="user">Name</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<input type="text" class="form-control" id="user"
									onkeypress="return isAlphabet(event)" minlength="3"
									placeholder="Name" data-original-title="" title="" name="name"
									required>
							</div>
							<br> <label class="sr-only" for="user">Employee Id</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<input type="text" class="form-control" id="employee"
									placeholder="Employee id" minlength="5" data-original-title=""
									title="Employee Id cannot be blank" name="employee_id" required>
							</div>
							<br> <label class="sr-only" for="email">E-mail</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
								<input type="email" class="form-control" id="email_id"
									pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"
									placeholder="E-mail" data-original-title=""
									title="Enter Valid Email-Address" name="email_id" required>
							</div>
							<br> <label class="sr-only" for="inputPassword">Password</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-lock"></i></span>
								<input type="password" class="form-control" id="password"
									placeholder="Password"
									pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
									title="Must contain at least one number and one uppercase and 
									lowercase letter, and at least 8 or more characters"
									name="password" required>
							</div>
							<br> <label class="sr-only" for="inputPassword">Re-enter
								Password</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-lock"></i></span>
								<input type="password" class="form-control" id="verification"
									placeholder="Re-enter Password"
									pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
									title="Enter the same password as above" required>
							</div>
							<br> <label class="sr-only" for="user">Authentication
								Code</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<input type="text" class="form-control" name="code"
									placeholder="Authentication Code" data-original-title=""
									title="" required>
							</div>
							<br> <input type="hidden" name="hidd" value="register">
							<button type="submit" class="btn btn-primary">SIGN UP</button>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>