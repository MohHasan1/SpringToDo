
<%@ include file="common/header.jspf"%>


<header>
	<%@ include file="common/navigation.jspf"%>
</header>

<hr>
<main class="container">

	<hr>
	<h2 class="text-center">Your Todos</h2>
	<hr>

	<a href="add-todo" class="btn btn-warning my-3 container-fluid">Add
		Todo</a>

	<table class="table" style="color: #F9FCFF;">
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is Done?</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.isDone}</td>

					<td><a href="/update-todo?id=${todo.id}"
						class="btn btn-success">Update</a></td>
					<td><a href="/delete-todo?id=${todo.id}"
						class="btn btn-danger">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</main>
<hr>

<%@ include file="common/footer.jspf"%>