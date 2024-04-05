
<%@ include file="common/header.jspf"%>

<header>
	<%@ include file="common/navigation.jspf"%>
</header>

<hr>
<main class="container">
	<hr>
	<h2 class="text-center">Add Your Todo</h2>
	<hr>

	<section
		class="d-flex justify-content-center align-items-center flex-column">
		<form:form method="POST" modelAttribute="todo">
			<fieldset class="mb-3 d-flex flex-column">
				<form:label path="description">Description:</form:label>
				<form:input type="text" required="required" path="description" />
				<form:errors path="description" cssClass="text-warning" />
			</fieldset>

			<fieldset class="mb-3 d-flex flex-column">
				<form:label path="targetDate">Target Date:</form:label>
				<form:input type="date" required="required" path="targetDate" />
				<form:errors path="targetDate" cssClass="text-warning" />
			</fieldset>

			<form:input type="hidden" path="id" />
			<form:input type="hidden" path="isDone" />

			<button class="btn btn-success container-fluid mt-4">Submit</button>
		</form:form>
	</section>

</main>
<hr>

<%@ include file="common/footer.jspf"%>