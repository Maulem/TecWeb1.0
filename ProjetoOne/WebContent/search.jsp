<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Search result</title>
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
			margin-bottom: 2rem;
			margin-top: 2rem;
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
			margin-top: 2rem;
			
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
		
	</style>
</head>
<body>
	<main>
		<h1 class="title">Wishbook</h1>
		<h2 class="welcome">Welcome ${name}</h2>
		<table>
			<tr>
				<th>Wish</th>
				<th>Creator</th>
				<th>Status</th>
				<th>Created on</th>
			</tr>
			<tr>
				<td class="td">${post.texto}</td>
				<td class="td">${post.criador}</td>
				<td class="td">${post.status}</td>
				<td class="td">${post.data.getTime()}</td>
			</tr>
		</table>
		<form action="search" method="post">
			<input type="hidden" name="username" value="${name}">
			<input class="buttonlist" type="submit" value="Go back">
		</form>
	</main>
</body>
</html>