<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:template>
	<h1>Autores</h1>
	<a class="btn btn-primary" href="<c:url value = "/autor/add"/>">Novo</a>
	<table class="table table-striped table-bordered">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Foto</th>
	      <th scope="col">Nome</th>
	      <th scope="col">E-mail</th>
	      <th scope="col"></th>
	    </tr>
	  </thead>
	  <tbody>
		<c:forEach var="autor" items="${autores}">
	        <tr>
	          <th scope='row'>${autor.id}</th>
	          <td><img src="..." alt="..." class="img-thumbnail">
	          <td>${autor.nome}</td>
	          <td>${autor.email}</td>
	          <td>
	            <a class='btn btn-success' href="<c:url value="/autor/edit"/>?id=${autor.id}">Editar</a>
	            <a class='btn btn-danger' href="<c:url value="/autor/delete"/>?id=${autor.id}">Excluir</a>
	          </td>
	        </tr>
		</c:forEach>	
	  </tbody>
	</table>
</tags:template>