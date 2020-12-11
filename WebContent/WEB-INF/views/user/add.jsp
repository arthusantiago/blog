<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:template>
	<form action="<c:url value="/user/add"/>" method="POST">
		<div class="row">
			<div class="col-sm-4 form-group">
				<label for="nome">Nome</label> <input type="text" class="form-control" id="nome" name="nome" required>
			</div>
			<div class="col-sm-4 form-group">
				<label for="nome">E-mail</label> <input type="email" class="form-control" id="email" name="email" required>
			</div>
			<div class="form-group">
				<label for="nivel_acesso_id">Nivel de acesso</label> 
				<select class="form-control" id="nivel_acesso_id" name="nivel_acesso_id">
				</select>
			</div>
			
				<div class="form-group">
			<label for="tag_id">Tag do post</label> <select class="form-control"
				id="tag_id" name="tag_id">
				<c:forEach var="nivel" items="${niveis}">
					<option value="${nivel.id}">${tag.nome}</option>
				</c:forEach>
			</select>
		</div>
			
			
		</div>
		<div class="row">
			<div class="col-sm-4 form-group">
				<label for="password">Senha(Mínimo 8 caracteres)</label>
				<input type="password" class="form-control" id="password" name="password" minlength="8" required>
			</div>
		</div>

		<button type="submit" class="btn btn-primary">Salvar</button>
	</form>
</tags:template>