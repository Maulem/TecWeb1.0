<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="java.util.*,br.maulem.pone.*"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Wishbook</title>
	<link href='css/reset.css' rel='stylesheet'>
	<link href='css/style.css' rel='stylesheet'>
	<link href="https://fonts.googleapis.com/css?family=Noto+Serif&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Spartan&display=swap" rel="stylesheet">
	<style>
		.title {
			font-size: 5rem;
			font-family: 'Noto Serif', serif;
			display: flex;
			text-align: center;
			margin-bottom: -1.5rem;
		}
		body {
			display: flex;
			justify-content: center;
			background-color: #03183d;
			font-family:'Spartan', sans-serif;
		}
		main {
			display: flex;
			flex-direction: column;
			align-items: center;
			background-color: white;
			min-width: 30rem;
			margin: 5rem;
			padding-bottom: 5rem;
			padding-right: 2rem;
			padding-left: 2rem;
			border-style: solid;
			border-color: #1c87c9;
			border-radius: 0.5rem;
			border-width: 0.1rem;
		}
		table, th {
			border: 2px solid black;
			border-collapse: collapse;
		}
		td {
			border: 1px solid black;
			border-collapse: collapse;
			padding: 1rem;
		}
		.botoes {
			display: flex;
			align-self: center;

		}
		.button {
			background-color: #2E7BFF;
			border-style: solid;
			border-color: #1c87c9;
			border-radius: 0.5rem;
			border-width: 0.1rem;
			color: white;
			align-self: center;
			padding-top: 1rem;
			padding-bottom: 1rem;
			font-size: 1rem;
			width: 8rem;
			text-decoration: none;
			align-items: center;
			display: flex;
			cursor: pointer;
			justify-content: center;
			margin: 2rem;
		}
		.button:hover {
			background-color: #6EA3FF;
		}
	</style>
</head>
<body>
	<main>
		<h1 class="title">Wishbook</h1>
		<div class="botoes">
			<a href="new" class="button">New wish</a>
			<a href="f5" class="button">Edit wish</a>
			<a href="del" class="button">Erase wish</a>
		</div>
		<table>
			<tr>
				<th>Wish</th>
				<th>Creator</th>
				<th>Status</th>
				<th>Created on</th>
			</tr>
			<c:forEach var="aPost" items="${posts}">
			<tr>
				<td>${aPost.getTexto()}</td>
				<td>${aPost.getCriador()}</td>
				<td>${aPost.getStatus()}</td>
				<td>${aPost.getData().getTime()}</td>
			</tr>
		</c:forEach>
	</table>
</main>
</body>
</html>