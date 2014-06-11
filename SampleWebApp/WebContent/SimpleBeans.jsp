<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>サーブレットで作成したJavaBeansの表示</title>
</head>
<body>
<%-- userの名称で作成されたJavaBeansをスコープから取得してそれぞれの値を表示 --%>
username： <c:out value="${user.username} " /> <br />
address： <c:out value="${user.address} " /> <br />
phone： <c:out value="${user.phone} " /> <br />
</body>
</html>