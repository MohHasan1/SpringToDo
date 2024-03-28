<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<html>
<head>

	<title>Todos</title>
	
	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">

</head>
<body style="background-color: #2B4162; color: #F9FCFF; padding: 20px;">

	<header>
		<h1>Add your new Todo</h1>
	</header>
	<hr>

	<main class="container">
		
		<form method="POST">
			<label>Description:</label>
			<input type="text" name="description"/>
			<br><br>
		
			<button class="btn btn-success">Add New ToDo</button>
		</form>
	
	</main>


	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>

</html>