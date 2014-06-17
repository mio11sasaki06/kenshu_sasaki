package to.msn.wings.common;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.sql.DataSource;


public class CheckUtil {
	private ArrayList<String> _errs=null;
	public CheckUtil(){
		this._errs = new ArrayList<String>();
	}
		public void requiredCheck(String value, String name){
			if (value == null || value.trim().isEmpty()){
				this._errs.add(name+"�K�{���͂ł��B");
			}
		}
		public void lengthCheck(String value, int max, String name){
			if (value != null && !value.trim().isEmpty()){
			if(value.length() > max){
				this._errs.add(name+"��"+max+"�����ȉ��œ��͂��Ă��������B");
			}
		}
}
public void numberTypeCheck(String value, String name){
	if(value != null && !value.trim().isEmpty()){
      try{
    	  Integer.parseInt(value);
      }catch(NumberFormatException e){
    	  this._errs.add(name+"�͐��l�œ��͂��Ă�������");
      }
	}
}
public void rengeCheck(String value, int max, int min, String name){
	if(value != null && !value.trim().isEmpty()){
		int val = 0;
		try{
			val = Integer.parseInt(value);
		} catch(NumberFormatException e){
			this._errs.add(val+"��"+min+"�ȏ�A����"+max+ "�ȉ��œ��͂��Ă��������B");
		}
	}
}
public void deteTypeCheck(String value, String name){
	if(value != null && !value.equals("")){
		if(value.matches("^[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}$")){
			StringTokenizer token = new StringTokenizer(value, "-");
			int year = Integer.parseInt((String)token.nextToken());
			int month = Integer.parseInt((String)token.nextToken());
			int day = Integer.parseInt((String)token.nextToken());
			Calendar cal = Calendar.getInstance();
			cal.set(year, month- 1, day);
			if(cal.get(Calendar.YEAR) != year || cal.get(Calendar.MONTH) != month-1 || cal.get(Calendar.DATE)!= day){
				this._errs.add(name+"�͐��������t�œ��͂��Ă��������B");
			}
	}else{
		this._errs.add(value + "�͓��t�`���œ��͂��Ă��������B");
	}
}
}
public void regExCheck(String value, String pattern, String name){
	if(value != null && !value.equals("")){
		if(!value.matches(pattern)){
		this._errs.add(name+"�𐳂����`���œ��͂��Ă��������B");
		}
	}
}
public void duplicateCheck(String value, String sql, String name){
	Connection db = null;
	PreparedStatement ps = null;
	ResultSet rs= null;
	try{
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/dbtest");
        db = ds.getConnection();
        ps = db.prepareStatement(sql);
        ps.setString(1,  value);
        rs = ps.executeQuery();
        if(rs.next()){this._errs.add(name+"���d�����Ă��܂��B");}
	} catch (NamingException e) {
		e.printStackTrace();
	} catch(SQLException e){
		e.printStackTrace();
	}finally{
		try{
			if(rs!=null){rs.close();}
			if(ps!=null){ps.close();}
			if(db!=null){db.close();}
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
}
public boolean hasErrors(){
	return !this._errs.isEmpty();
}
public String getErrorList(){
	StringBuffer buf = new StringBuffer();
	buf.append("<ul stayle='color:Red;'>");
	for(String err :this._errs){
		buf.append("<li>"+err+ "</li>");
	}
	buf.append("</ul>");
	return buf.toString();
}
}
