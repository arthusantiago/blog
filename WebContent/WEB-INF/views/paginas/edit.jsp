<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:template>
	<form action="<c:url value="/paginas/edit"/>" method="POST">
		<input type="hidden" id="id" name="id" value="${pagina.id}">
		<div class="form-group">
			<label for="nome">Titulo do página</label> <input type="text"
				class="form-control" id="titulo" name="titulo"
				value="${pagina.titulo}">
		</div>
		<div class="form-group">
			<label for="nome">Conteúdo do pagina</label>
			<textarea class="form-control" rows="3" cols="3" id="conteudo"
				name="conteudo">${pagina.titulo}</textarea>
		</div>
		<div class="form-group">
			<label for="autor_id">User</label> <select
				class="form-control" id="user_id" name="user_id">
				<c:forEach var="user" items="${users}">
					<c:if test="${user.id == pagina.user_id}">
						<option value="${user.id}" selected>${user.nome}</option>
					</c:if>
					<c:if test="${user.id != pagina.user_id}">
						<option value="${user.id}">${user.nome}</option>
					</c:if>
				</c:forEach>
			</select>
		</div>	
				
	
		<button type="submit" class="btn btn-primary">Salvar</button>
	</form>
</tags:template>