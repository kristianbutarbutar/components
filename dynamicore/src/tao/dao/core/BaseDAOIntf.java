package tao.dao.core;

import tao.vo.BaseVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface BaseDAOIntf {
	public PreparedStatement addRecord(StringBuffer sql);
	public PreparedStatement updateRecord(StringBuffer sql);
	public PreparedStatement deleteRecord(StringBuffer sql);
	public PreparedStatement setSQLRecords(StringBuffer sql);
	public BaseVO getRecords(BaseDAO dao);
}
