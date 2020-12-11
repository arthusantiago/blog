<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:template>
	<h1>Posts</h1>
	<a class="btn btn-primary" href="<c:url value = "/post/add"/>">Novo</a>
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Titulo</th>
				<th scope="col">Autor</th>				
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="post" items="${posts}">
				<tr>
					<th scope='row'>${post.id}</th>
					<td>${post.titulo}</td>
					<td>${post.autor.nome}</td>					
					<td><a class='btn btn-success'
						href="<c:url value="/post/edit"/>?id=${post.id}">Editar</a> <a
						class='btn btn-danger'
						href="<c:url value="/post/delete"/>?id=${post.id}">Excluir</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</tags:template>