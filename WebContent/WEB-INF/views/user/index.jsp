<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
 
<tags:template>
<h1>Usuários</h1>
<a class="btn btn-primary" href="<c:url value = "/user/add"/>">Novo</a>
<table class="table table-striped table-bordered">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Nome</th>
      <th scope="col">e-mail</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
	<c:forEach var="user" items="${users}">
        <tr>
          <th scope='row'>${user.id}</th>
          <td>${user.nome}</td>
          <td>${user.email}</td>
          <td>
            <a class='btn btn-success' href="<c:url value="/user/edit"/>?id=${user.id}">Editar</a>
            <a class='btn btn-danger' href="<c:url value="/user/delete"/>?id=${user.id}">Excluir</a>
          </td>
        </tr>
	</c:forEach>	
  </tbody>
</table>
</tags:template>