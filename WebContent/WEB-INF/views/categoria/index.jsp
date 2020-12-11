<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
 
<tags:template>
<h1>Categorias</h1>
<a class="btn btn-primary" href="<c:url value = "/categoria/add"/>">Novo</a>
<table class="table table-striped table-bordered">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Nome</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
	<c:forEach var="categoria" items="${categorias}">
        <tr>
          <th scope='row'>${categoria.id}</th>
          <td>${categoria.nome}</td>
          <td>
            <a class='btn btn-success' href="<c:url value="/categoria/edit"/>?id=${categoria.id}">Editar</a>
            <a class='btn btn-danger' href="<c:url value="/categoria/delete"/>?id=${categoria.id}">Excluir</a>
          </td>
        </tr>
	</c:forEach>	
  </tbody>
</table>
</tags:template>