<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:template>
	<form action="<c:url value="/post/edit"/>" method="POST">
		<input type="hidden" id="id" name="id" value="${post.id}">
		<div class="form-group">
			<label for="nome">Titulo do post</label> <input type="text"
				class="form-control" id="titulo" name="titulo"
				value="${post.titulo}">
		</div>
		<div class="form-group">
			<label for="nome">Texto do post</label>
			<textarea class="form-control" rows="3" cols="3" id="texto"
				name="texto">${post.texto}</textarea>
		</div>
		<div class="form-group">
			<label for="autor_id">Autor do post</label> <select
				class="form-control" id="autor_id" name="autor_id">
				<c:forEach var="autor" items="${autores}">
					<c:if test="${autor.id == post.autor_id}">
						<option value="${autor.id}" selected>${autor.nome}</option>
					</c:if>
					<c:if test="${autor.id != post.autor_id}">
						<option value="${autor.id}">${autor.nome}</option>
					</c:if>
				</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="tag_id">Tag do post</label> <select class="form-control"
				id="tag_id" name="tag_id">
				<c:forEach var="tag" items="${tags}">
					<c:if test="${tag.id == post.tag_id}">
						<option value="${tag.id}" selected>${tag.nome}</option>
					</c:if>
					<c:if test="${tag.id != post.tag_id}">
						<option value="${tag.id}">${tag.nome}</option>
					</c:if>
				</c:forEach>
			</select>
		</div>
		<button type="submit" class="btn btn-primary">Salvar</button>
	</form>
</tags:template>