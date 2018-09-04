package tao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import tao.vo.FormVO;

import com.mysql.jdbc.Statement;

public class DB {
	private static Connection connection = null;
	private static Statement st;
	private static ResultSet rs;
	
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return null;
		}
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/toba","toba", "toba");
			System.out.println("Connection has been established!");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}
		return connection;
	}
	
	public static boolean closeConnection(){
		try{
			if(connection != null){
				connection.close(); connection = null;
			}
			return true;
		}catch(Exception e){
			System.out.println("Error in [DB.closeConnection] : " + e.getMessage());
		}
		return false;
	}
	
	public static PreparedStatement executeSQL(StringBuffer sql){
		try{
			System.out.println("SQL Statement : " + sql.toString());
			PreparedStatement ps =  DB.getConnection().prepareStatement(sql.toString());
			return ps;
		}catch(SQLException e){
			System.out.println("SQLException Error at DB.executeSQL : " + e.getMessage());
		}catch(Exception e){
			System.out.println("Exception Error at DB.executeSQL : " + e.getMessage());
		}
		return null;
	}
	
	public static ResultSet getRecords(StringBuffer sql){		
		try{
			st = (Statement) DB.getConnection().createStatement();
			rs = st.executeQuery(sql.toString());
			if(rs!=null){
				return rs;
			}			
		}catch(Exception e){
			System.out.println("Error in [DB.getRecords] : " + e.getMessage());
		}
		return null;
	}
	
	public static boolean closeRecords(){
		try{
			if(rs!=null){
				rs.close(); rs = null; return true;
			}			
		}catch(Exception e){
			System.out.println("Error in [DB.closeRecords] : " + e.getMessage());
		}
		return false;
	}
	
	public static void main(String[] args){
		System.out.println("Start Test DB Connection");
		Connection conn = DB.getConnection();
		if(conn != null){
			System.out.println("DB Connected.");
		}
		System.out.println("End Test DB Connection");
	}
	public static void testQuery(){
		StringBuffer sqlFields = new StringBuffer("select a.id,a.name,a.label,a.description,a.datatype,a.defaultval,a.htmltype,"
						+ "b.formid,b.fieldid,b.seqno,b.editable,b.urllist,b.comboid "
						+ "from tbl_fields a inner join tbl_form_fields b on a.id = b.fieldid");
		
		StringBuffer sqlForms = new StringBuffer("select id,name,description,label,url,urldetail from tbl_forms");

		try{
			Statement st = (Statement) DB.getConnection().createStatement();
			ResultSet rs = st.executeQuery(sqlForms.toString());
			if(rs!=null){
				while(rs.next()){
					FormVO f = new FormVO();
					f.setFormCode(rs.getString(1));
					f.setFormName(rs.getString(2));
					f.setFormDescription(rs.getString(3));
					f.setFormLabel(rs.getString(4));
				}
			}
		}catch(Exception ex){
			System.out.println("Error in [DB.testQuery] : " + ex.getMessage());
		}
	}
}
