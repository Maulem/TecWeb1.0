<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="java.util.*,br.maulem.pone.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista dos posts</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
</head>
<body>
<a href="newPost" class="button">Novo</a>
<a href="Fcinco" class="button">Editar</a>
<a href="Del" class="button">Apagar</a>
<h1>Posts</h1>
<table>
<tr>
<td>ID</td>
<td>Texto</td>
<td>Criador</td>
</tr>
<c:forEach var="aPost" items="${posts}">
		<tr>
			<td>${aPost.getId()}</td>
			<td>${aPost.getTexto()}</td>
			<td>${aPost.getCriador()}</td>
		</tr>
</c:forEach>
</table>
</body>
</html>