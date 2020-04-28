<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>Welcome Page</title>
	</head>
	<body>
			<h3 align="center">Welcome ${user.userName}</h3>
			<a href="add">add Book</a>
		<c:choose>
			<c:when test="${not empty books}">
				<h6>Your Book List</h6>
				<ul>
					<c:forEach items="${books}" var="book">
						<li>${book.bookName} <a href="#">edit</a> <a href="delete/${book.id}" >Delete</a></li>
					</c:forEach>
				</ul>
			</c:when>
			<c:otherwise>
				You have not added any book in your list !!!
			</c:otherwise>
		</c:choose>
	</body>
</html>
