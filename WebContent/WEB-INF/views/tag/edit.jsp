<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:template>
	<form action="<c:url value="/tag/edit"/>" method="POST">
		<input type="hidden" class="form-control" id="id" name="id"
			value="${tag.id}">
		<div class="form-group">
			<label for="nome">Nome</label> <input type="text"
				class="form-control" id="nome" name="nome" value="${tag.nome}">
		</div>
		<button type="submit" class="btn btn-primary">Salvar</button>
	</form>
</tags:template>