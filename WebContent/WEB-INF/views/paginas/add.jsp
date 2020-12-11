<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:template>
	<form action="<c:url value="/paginas/add"/>" method="POST">
		<div class="form-group">
			<label for="nome">Titulo da página</label> <input type="text"
				class="form-control" id="titulo" name="titulo">
		</div>
		<div class="form-group">
			<label for="nome">Conteudo da página</label>
			<textarea class="form-control" rows="3" cols="3" id="conteudo"
				name="conteudo"></textarea>
		</div>
		<div class="form-group">
			<label for="autor_id">Usuario</label> <select
				class="form-control" id="user_id" name="user_id">
				<c:forEach var="user" items="${users}">
					<option value="${user.id}">${user.nome}</option>
				</c:forEach>
			</select>
		</div>
	

		<button type="submit" class="btn btn-primary">Salvar</button>
	</form>
</tags:template>