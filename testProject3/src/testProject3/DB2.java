package testProject3;

public class DB2 {
	public java.sql.Connection con;
	public java.sql.Statement s;
	public java.sql.ResultSet rs;
	public java.sql.PreparedStatement pst;

	public DB2(){
		con=null;
		s=null;
		pst=null;
		rs=null;
		String url="jdbc:jtds:sqlserver://localhost/test";
		String id= "sa";
		String pass = "Password!";
		try{

			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			con = java.sql.DriverManager.getConnection(url, id, pass);

			}catch(ClassNotFoundException cnfex){
			cnfex.printStackTrace();
			}
			catch(Exception r){}
	}

	public String getUsers(){
		String outText = "";
	
		String sql = "select * from users";
		try{
		s = con.createStatement();
		rs = s.executeQuery(sql);
		outText = outText + "<table>";
		while( rs.next() ){
			outText = outText + "<tr>";
			outText = outText + "<td>" + rs.getString("id")   + "</td>";
			outText = outText + "<td>" + rs.getString("nume") + "</td>";
			outText = outText + "<td>" + rs.getString("password") + "</td>";
			outText = outText + "</tr>";

		}
		outText = outText + "</table>";

		}
		catch(Exception e){e.printStackTrace();}
		finally{
			try{
				if(rs!=null) rs.close();
				if(s!=null) s.close();
				if(con!=null) con.close();
			}catch(Exception e){}
		}

		return outText;

	}
	
	
	public String getFiles(){
		String outText = "";
	
		String sql = "select * from files";
		try{
		s = con.createStatement();
		rs = s.executeQuery(sql);
		outText = outText + "<table>";
		while( rs.next() ){
			outText = outText + "<tr>";
			outText = outText + "<td>" + rs.getString("id")   + "</td>";
			outText = outText + "<td>" + rs.getString("nume") + "</td>";
			outText = outText + "<td>" + rs.getString("password") + "</td>";
			outText = outText + "</tr>";

		}
		outText = outText + "</table>";

		}
		catch(Exception e){e.printStackTrace();}
		finally{
			try{
				if(rs!=null) rs.close();
				if(s!=null) s.close();
				if(con!=null) con.close();
			}catch(Exception e){}
		}

		return outText;

	}
	
	
	
	
	
	
	
	
}


