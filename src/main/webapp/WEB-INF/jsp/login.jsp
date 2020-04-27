<html>
	<head>
		<title>
			Login Page
		</title>
	</head>
	<body>
		<form action="login" method="post">
			Username : <input name="username" type="text">
			Password : <input name="password" type="password">
			<input type="submit">
			${errorMessage}
		</form>
	</body>
</html>