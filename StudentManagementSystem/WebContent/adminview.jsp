<html>
<head>
<title>Admin Login Page</title>
</head>
<body style="background-color: lightpink; text-align: center;">
	<h1>ADMIN LOGIN</h1>
	<form action="AdminController" method="post">
		<table align="center" cellpadding="5">
			<tr>
				<td>Admin Id</td>
				<td><input type="text" name="adminid"
					placeholder="Enter admin name" required></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="adminpassword"
					placeholder="Enter admin password" required></td>
			</tr>
			<tr>
				<td align="center" colspan="5"><button>Login</button>
		</table>
	</form>
</body>
</html>