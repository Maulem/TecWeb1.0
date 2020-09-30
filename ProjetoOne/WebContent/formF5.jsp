<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="java.util.*,br.maulem.pone.*"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Editing a wish</title>
	<link href="https://fonts.googleapis.com/css?family=Noto+Serif&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Spartan&display=swap" rel="stylesheet">
	<style>
		.title {
			font-size: 5rem;
			font-family: 'Noto Serif', serif;
			display: flex;
			text-align: center;
			margin-bottom: 0rem;
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
		form {
			display: flex;
			justify-content: flex-end;
			flex-direction: column;
			width: 12rem;
			margin-top: 1rem;
		}

		p {
			text-align: center;
			font-size: 1.5rem;
			margin-top: -0.5rem;
		}
		.input {
			width: 10rem;
			align-self: center;
			margin-top: -1.5rem;
			font-size: 1.1rem;
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
		
	</style>
</head>
<body>
	<main>
		<h1 class="title">Wishbook</h1>
		<form method="post">
			<input class="input" type="hidden" name="id" value="${id}"><br>
			<p>New wish:</p> <input class="input" type="text" name="texto" required="required" value="${text}"><br>
			<p>New status:</p> <input class="input" type="text" name="status" required="required" placeholder="Previous: ${stat}"><br>
			<input class="buttonlist" type="submit" value="Submit">
			<datalist id="status">
				<option value="To do">
				<option value="Doing">
				<option value="Done">
			</datalist>
		</form>
	</main>
</body>
</html>