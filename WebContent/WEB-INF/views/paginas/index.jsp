<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:template>
	<h1>Páginas</h1>
	<a class="btn btn-primary" href="<c:url value = "/paginas/add"/>">Novo</a>
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Titulo</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="pagina" items="${paginas}">
				<tr>
					<th scope='row'>${pagina.id}</th>
					<td>${pagina.titulo}</td>
					<td>
						<a class='btn btn-success' href="<c:url value="/paginas/edit"/>?id=${pagina.id}">Editar</a> 
						<a class='btn btn-danger' href="<c:url value="/paginas/delete"/>?id=${pagina.id}">Excluir</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</tags:template>