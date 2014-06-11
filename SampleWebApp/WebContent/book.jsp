<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*, javax.naming.*, javax.sql.*, java.text.*" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bookテーブル</title>
</head>
<body>
    <table border="1">
    <tr>
    <th>ISBNコード</th><th>署名</th><th>価格</th>
    <th>出版社</th><th>刊行年月日</th>
    </tr>
    <%

    Connection db = null;
    PreparedStatement ps =null;
    ResultSet rs = null;
    try{
    Context context = new InitialContext();
    DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/dbtest");
    db = ds.getConnection();
    ps=db.prepareStatement("SELECT * FROM book");
    rs = ps.executeQuery();
    while(rs.next()){
    %>
    <tr>
    <td><%=rs.getString("isbn") %></td>
    <td><%=rs.getString("title") %></td>
    <td><%=rs.getString("price") %></td>
    <td><%=rs.getString("publish") %></td>
    <td><%=rs.getString("published") %></td>
    </tr>
    <%

    }

    }catch(Exception e){
    	throw new ServletException(e);
    }finally{
    	try{
    		if(rs != null){rs.close();}
    		if(ps != null){ ps.close();}
    		if(db != null){db.close();}

    	}catch(Exception e){}
    	}



%>

    </table>
    </body>
    </head>
    </html>