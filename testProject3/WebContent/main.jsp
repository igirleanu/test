<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Files</title>
</head>
<body>
 <%@ page import="testProject3.*" %>
  
<br>
<b>Files</b>
<table>
	<tr>		
		<td>
			<label for="male">Author</label>
		</td>
		<td>
			<label for="male">File Name</label>
		</td>
		<td>
			<label for="male">Download original format</label>
		</td>			
		<td>
			<label for="male">Download archive</label>
		</td>			
	</tr>
	<%
	 DB2 a = new DB2();
	 mFiles files = a.getFiles();
					
	for(mFiles file : files){
	%>		
	<tr>		
		<td align="right">
			<label for="male"><%=file.userId %></label>
		</td>
		<td align="center">
			<label for="male"><%=file.fileName %></label>
		</td>
		<td align="center">
			<input type="submit" style="width: 60px; " value="Original">
		</td>
		<td align="center">
			<input type="submit" style="width: 60px; " value="ZIP">
		</td>			
	</tr>
	<%
	}
	%>
</table>
<br>
<b>Load your file</b>
	<div style="height: 40px; "><form>
			<input>
			<input type="submit" style="width: 60px; " value="Browse">
			<input type="submit" style="width: 60px; " value="Load">
			</form>
	</div>
	

	
</body>
</html>