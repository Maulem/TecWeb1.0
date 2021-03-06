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
	<link href="https://fonts.googleapis.com/css?family=Noto+Serif&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Spartan&display=swap" rel="stylesheet">
	<style>
		.title {
			font-size: 5rem;
			font-family: 'Noto Serif', serif;
			display: flex;
			text-align: center;
			margin-bottom: -1.5rem;
			margin-top: 1rem;
		}
		
		.welcome {
			font-size: 2rem;
			font-family: 'Noto Serif', serif;
			display: flex;
			text-align: center;
			margin-bottom: -1rem;
			margin-top: 5rem;
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
		
		.td {
			border: 1px solid black;
			border-collapse: collapse;
			padding: 1rem;
			max-width: 35rem;
		}
		
		.tb {
			border: 0px solid black;
			border-collapse: collapse;
			padding: 1rem;
			max-width: 35rem;
			display: flex;
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
			margin-top: 4rem;
		}
		
		.button:hover {
			background-color: #6EA3FF;
		}
		
		.buttonlist {
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
			margin-left: 0.5rem;
			margin-right: 0.5rem;
			
		}
		
		.buttonlist:hover {
			background-color: #6EA3FF;
		}
		
		.filtro {
			display: flex;
			margin-top: 5rem;
		}
		
		.pesquisa {
			margin-top: 5rem;
		}
		
		.p {
			margin-top: 0rem;
		}
		
	</style>
</head>
<body>
	<main>
		<h1 class="title">Wishbook</h1>
		<h2 class="welcome">Welcome ${name}</h2>
		<div class="botoes">
			<div class="filtro">
				<p class="p">Order by:</p>
				<form action="filter" method="post">
					<select name="filter" required>
						<option value="1">Text</option>
				    	<option value="2">Creator</option>
				    	<option value="3">Status</option>
				    	<option value="4">Data</option>
					</select>
					<input type="hidden" name="username" value="${name}">
					<input type="submit" value="Filter">
				</form>
			</div>
			<a href="new" class="button">New wish</a>
			<form class="pesquisa" action="search" method="get">
				<input type="text" name="input" placeholder="search here the exact term">
				<input type="hidden" name="username" value="${name}">
				<input type="submit" value="Search">
			</form>
		</div>
		<table>
			<tr>
				<th>Wish</th>
				<th>Creator</th>
				<th>Status</th>
				<th>Created on</th>
				<th>Change wish</th>
			</tr>
			<c:forEach var="aPost" items="${posts}">
				<tr>
				<td class="td">${aPost.getTexto()}</td>
				<td class="td">${aPost.getCriador()}</td>
				<td class="td">${aPost.getStatus()}</td>
				<td class="td">${aPost.getData().getTime()}</td>
				<td class="tb">
					<form action="attPost" method="get">
						<input type="hidden" name="id" value="${aPost.getId()}">
						<input type="hidden" name="text" value="${aPost.getTexto()}">
						<input type="hidden" name="creator" value="${aPost.getCriador()}">
						<input type="hidden" name="stat" value="${aPost.getStatus()}">
						<input class="buttonlist" type="submit" value="Edit wish">
					</form>
				
				
					<form action="delPost" method="post">
						<input type="hidden" name="id" value="${aPost.getId()}">
						<input class="buttonlist" type="submit" value="Delete wish">
					</form>
				</td>
				</tr>
			</c:forEach>
		</table>
	</main>
</body>
</html>