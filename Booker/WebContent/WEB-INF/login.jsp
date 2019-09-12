<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Login" method="post">
		<div>
			ログインID：<input type="text" name="login-id" />
		</div>
		<div>
			パスワード：<input type="password" name="password" />
		</div>
		<div>
			<input type="submit" value=" ログイン">
		</div>
		<div class="error-msg">
			<c:if test="${errorFlg}"><%=request.getAttribute("loginErrorMsg")%></c:if>
		</div>
	</form>
</body>
</html>