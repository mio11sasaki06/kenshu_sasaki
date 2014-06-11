<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>フォーム送信を行う</title>
</head>
<body>
<form method="insert_member1" action="insert_member2.jsp">
次のフォームから入力してください<br />
名前
<input type = "text" name="nam" /><br />
性別
<input type = "text" name="sex" /><br />
年齢
<input type = "text" name="old" /><br />
入力
<input type = "text" name="enter" /><br />
メモ
<input type = "text" name="memo" /><br />
<input type = "submit" value = "送信" />
</form>
</body>
</html>