package tao.dao;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import oracle.jdbc.pool.OracleDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;

public class DBDS {
	public static DataSource getMySQLDataSource() {
		Properties props = new Properties();
		FileInputStream fis = null;
		MysqlDataSource mysqlDS = null;
		try {
			fis = new FileInputStream("db.properties");
			props.load(fis);
			mysqlDS = new MysqlDataSource();
			mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
			mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
			mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mysqlDS;
	}
	
	public static DataSource getOracleDataSource(){
		Properties props = new Properties();
		FileInputStream fis = null;
		OracleDataSource oracleDS = null;
		try {
			fis = new FileInputStream("db.properties");
			props.load(fis);
			oracleDS = new OracleDataSource();
			oracleDS.setURL(props.getProperty("ORACLE_DB_URL"));
			oracleDS.setUser(props.getProperty("ORACLE_DB_USERNAME"));
			oracleDS.setPassword(props.getProperty("ORACLE_DB_PASSWORD"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oracleDS;
	}
	
	public static Connection getConnection(String dbType) {
		DataSource ds = null;
		Connection con = null;
		
		if("mysql".equals(dbType)){
			ds = DBDS.getMySQLDataSource();
		}else if("oracle".equals(dbType)){
			ds = DBDS.getOracleDataSource();
		}else{
			System.out.println("invalid db type");
			return null;
		}
		
		try {
			con =  ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
