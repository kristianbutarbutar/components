package tao.dao.core;

import tao.vo.BaseVO;
import tao.dao.DB;

import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.apache.log4j.Logger;

public class BaseDAO implements BaseDAOIntf{
	private static final Logger logger = Logger.getLogger(BaseDAO.class);
	private PreparedStatement ps;
	@Override
	public PreparedStatement addRecord(StringBuffer sql) {
		try{
			ps = DB.executeSQL(sql);
			return ps;
		}catch(Exception e){
			logger.info("Error at BaseDAO.addRecord : " + e.getMessage());
		}
		return null;
	}

	@Override
	public PreparedStatement updateRecord(StringBuffer sql) {
		try{
			ps = DB.executeSQL(sql);
			return ps;
		}catch(Exception e){
			logger.info("Error at BaseDAO.updateRecord : " + e.getMessage());
		}
		return null;
	}

	@Override
	public PreparedStatement deleteRecord(StringBuffer sql) {
		try{
			ps = DB.executeSQL(sql);
			return ps;
		}catch(Exception e){
			logger.info("Error at BaseDAO.deleteRecord : " + e.getMessage());
		}
		return null;
	}
	
	public boolean closePS(){
		try{
			if(ps !=null){
				ps.close(); ps = null;
				DB.closeConnection();
			}
			return true;
		} catch (Exception e) {
			logger.info("Error at BaseDAO.closePS : " + e.getMessage());
		}
		return false;
	}
	 public java.sql.Date convertUtilToSql(java.util.Date uDate) {
	     java.sql.Date sDate = new java.sql.Date(uDate.getTime());
	     return sDate;
	 }
	 
	 public String genCid(String t) throws UnsupportedEncodingException{
		 String uniqueID = UUID.randomUUID().toString();
		 String source = uniqueID + t;
		 byte[] bytes = source.getBytes("UTF-8");
		 UUID uuid = UUID.nameUUIDFromBytes(bytes);
		 return uuid.toString();
	 }

	@Override
	public PreparedStatement setSQLRecords(StringBuffer sql) {
		try{
			ps = DB.executeSQL(sql);
			return ps;
		}catch(Exception e){
			logger.info("Error at BaseDAO.updateRecord : " + e.getMessage());
		}
		return null;
	}

	@Override
	public BaseVO getRecords(BaseDAO dao) {
		try{
			if(ps!=null){
				return dao.setRecordsInVO(ps.executeQuery());
			}
		}catch(SQLException e){
			logger.info("[SQLException] Error at BaseDAO.getRecords : " + e.getMessage());
		}
		return null;
	}
	
	public BaseVO setRecordsInVO(ResultSet rs) {
		return null;
	}
	 
	public boolean IsById(String n){
		return n.matches("^ID:(\\w+)$");
	}
}
