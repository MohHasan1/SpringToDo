<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<html>
<head>

	<title>Todos</title>
	
	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">

</head>
<body style="background-color: #2B4162; color: #F9FCFF; padding: 20px;">

	<header>
		<h1>Your T0-D0s, ${username}</h1>
	</header>
	<hr>

	<main class="container">
	
		<a href="add-todo" class="btn btn-success">New ToDo</a>
	
		<table class="table" style="color: #F9FCFF;">
			<thead>
				<tr>
					<th>Id</th>
					<th>Description</th>
					<th>Target Date</th>
					<th>Is Done?</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.id}</td>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.isDone}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>


	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>

</html>