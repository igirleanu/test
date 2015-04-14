package testProject3;
import java.util.*; 

public class DB2 {
	private java.sql.Connection con;
	private java.sql.Statement s;
	private java.sql.ResultSet rs;
	private java.sql.PreparedStatement pst;
	private List<mFile> files = new ArrayList<mFile>();
	
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
	
	
	public List<mFile> getFiles(){
		
		String sql = "select * from files";
		try{
		s = con.createStatement();
		rs = s.executeQuery(sql);
		
			while( rs.next() ){
				mFile file = new mFile(); 
				file.id = Integer.parseInt(rs.getString("id"));
				file.userId = Integer.parseInt(rs.getString("user_id"));
				file.fileName = rs.getString("name");
				file.fileBody = rs.getString("body");
				files.add(file);
			}			
		}
		catch(Exception e){e.printStackTrace();}
		finally{
			try{
				if(rs!=null) rs.close();
				if(s!=null) s.close();
				if(con!=null) con.close();
			}catch(Exception e){}
		}
		return files;
	}	
}



