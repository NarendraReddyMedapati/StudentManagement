<html>
<head>
<title>Student Login Page</title>
</head>
<body style="background-color: skyblue; text-align: center;">
	<h1>STUDENT LOGIN</h1>
	<form action="StudentController" method="post">
		<table align="center" cellpadding="5">
			<tr>
				<td>Roll Number:</td>
				<td><input type="text" name="rollnumber"
					placeholder="Enter your roll number" required></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="studentpassword"
					placeholder="Enter your password" required></td>
			</tr>
			<tr>
				<td align="center" colspan="5"><button>Login</button></td>
			</tr>
		</table>
	</form>
</body>
</html>