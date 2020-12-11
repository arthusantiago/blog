<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:template>
	<form action="<c:url value="/nivel-acesso/add"/>" method="POST">
		<div class="row">
			<div class="col-sm-4 form-group">
				<label for="nome">Nome</label> <input type="text" class="form-control" id="nome" name="nome" required>
			</div>
			
			
		</div>
		

		<button type="submit" class="btn btn-primary">Salvar</button>
	</form>
</tags:template>