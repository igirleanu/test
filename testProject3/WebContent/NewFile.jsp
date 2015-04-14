 
<html>
 <head><title>Enter to database</title></head>
 <body>
 <%@ page import="testProject3.*" %>
d
 xxx
 <table>
 <% 
 DB2 a = new DB2();
 //a.getUsers();
	
 String sql = "select * from users";
		try{
		a.s = a.con.createStatement();
		a.rs = a.s.executeQuery(sql);
		
		while( a.rs.next() ){
			%>
			<tr>
			<td> <%= a.rs.getString("id")   %> </td>
			<td> <%= a.rs.getString("nume") %> </td>
			<td> <%= a.rs.getString("password") %> </td>
			</tr>
			<%
		}

		}
		catch(Exception e){e.printStackTrace();}
		finally{
			try{
				if(a.rs!=null) a.rs.close();
				if(a.s!=null) a.s.close();
				if(a.con!=null) a.con.close();
			}catch(Exception e){}
		}

 %>
 </table>
 </body>
 </html>