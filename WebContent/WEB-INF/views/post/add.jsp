<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:template>
	<form action="<c:url value="/post/add"/>" method="POST">
		<div class="form-group">
			<label for="nome">Titulo do post</label> <input type="text"
				class="form-control" id="titulo" name="titulo">
		</div>
		<div class="form-group">
			<label for="nome">Texto do post</label>
			<textarea class="form-control" rows="3" cols="3" id="texto"
				name="texto"></textarea>
		</div>
		<div class="form-group">
			<label for="autor_id">Autor do post</label> <select
				class="form-control" id="autor_id" name="autor_id">
				<c:forEach var="autor" items="${autores}">
					<option value="${autor.id}">${autor.nome}</option>
				</c:forEach>
			</select>
		</div>
		
		<div class="form-group">
			<label for="tag_id">Categoria do post</label> <select class="form-control"
				id="categoria_id" name="categoria_id">
				<c:forEach var="categoria" items="${categorias}">
					<option value="${categoria.id}">${categoria.nome}</option>
				</c:forEach>
			</select>
		</div>
		
		<div class="form-group">
			<label for="tag_id">Tag do post</label> <select class="form-control"
				id="tag_id" name="tag_id">
				<c:forEach var="tag" items="${tags}">
					<option value="${tag.id}">${tag.nome}</option>
				</c:forEach>
			</select>
		</div>

		<button type="submit" class="btn btn-primary">Salvar</button>
	</form>
</tags:template>