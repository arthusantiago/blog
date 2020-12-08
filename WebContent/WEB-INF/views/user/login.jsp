<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<tags:templateLogin>
	<form action="<c:url value="/user/login"/>" method="POST">
		<div class="row form-group justify-content-md-center">
			<div class="col-4">
				<label for="email">Email</label>
				<input type="email" name="email" class="form-control" id="email"> 		
			</div>
		</div>
		<div class="row form-group justify-content-md-center">
			<div class="col-4">
				<label for="password">Senha</label> 
				<input type="password" name="password" class="form-control" id="password">
			</div>
		</div>
		<div class="row justify-content-md-center">
			<div class="col-4 text-right">
				<button type="submit" class="btn btn-primary">Entrar</button>
			</div>
		</div>
	</form>
</tags:templateLogin>