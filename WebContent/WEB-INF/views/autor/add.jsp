<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:template>
	<form action="<c:url value="/autor/add"/>" method="POST">
		<div class="form-group">
			<label for="nome">Nome</label> <input type="text"
				class="form-control" id="nome" name="nome">
		</div>
		<div class="form-group">
			<label for="email">E-mail</label> <input type="email"
				class="form-control" id="email" name="email">
		</div>

		<div class="form-group">
			<label for="exampleFormControlFile1">Foto</label> <input
				type="file" class="form-control-file" id="imagem">
		</div>

		<button type="submit" class="btn btn-primary">Salvar</button>
	</form>
</tags:template>