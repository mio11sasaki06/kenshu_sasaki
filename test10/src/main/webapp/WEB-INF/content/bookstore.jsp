<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ page import="bookstore.pbean.BookDB" %>
    <%@ page import="bookstore.pbean.TBook" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>オンラインショップ</title>
</head>
<body>
<s:form action="/AddToCart" method="post" >
<table border="1">
<tr><th>作品名</th><th>著作名</th><th>価格</th><th>選択</th></tr>
<s:iterator value="lblist">
<tr>
<td>
<s:property value="title" />
</td>
<td>
<s:property value="author" />
</td>
<td>
<s:property value="price" />
</td>
<td>
<s:set name="select_isbn" value="%{isbn}" />
<s:if test="%{#session.CART != null && !#session.CART.isEmpty() && #session.CART.contains(#selected_isbn)}">
<s:checkbox name="selecteditems" fildValue="%{isbn}" theme="simple" value='true' />
</s:if>
<s:else>
<s:checkbox name="selecteditems" fildValue="%{isbn}" theme="simple" value='false' />
</s:else>
</td>
</tr>
</s:iterator>
</table>
<s:submit value="カートに追加" method="AddToCart" theme="simple" />
<s:submit value="会計" method="checkout" theme="simple" />
</s:form>
</body>
</html>