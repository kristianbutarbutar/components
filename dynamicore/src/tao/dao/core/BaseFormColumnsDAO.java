package tao.dao.core;

import java.sql.PreparedStatement;

import org.apache.log4j.Logger;

import tao.vo.BColumnVO;
import tao.vo.BFormVO;

/**
 * 
 * @author kristian
 * form base columns will be able to add new column linked to the form
 * and can only delete as well
 * update function can only be done by delete first and add the respective columns
 */
public class BaseFormColumnsDAO extends BaseDAO{
	private static final Logger logger = Logger.getLogger(BaseFormColumnsDAO.class);
	private PreparedStatement ps = null;
	public String addFormColumns(BFormVO vo){
		try{
			for(BColumnVO cvo: vo.getColumns())
			{
				StringBuffer sql = new StringBuffer("");
				sql.append("INSERT INTO T_C_FORM_COLUMNS(formid,columnid,listid,seqno) ");
				sql.append("VALUES (?,?,?,?)");
				ps = addRecord(sql);
				ps.setString(1, vo.getCid());
				ps.setString(2, cvo.getCid());
				ps.setString(3, cvo.getListId());
				ps.setInt(4, cvo.getSeqNo());
				ps.execute();closePS();
			}			
			
			return "success";
		} catch(Exception e){
			System.out.println("Error at BaseFormColumnsDAO.addFormColumns : " + e.getMessage());
		}
		return null;
	}
	
	public String deleteFormColumns(BFormVO vo){
		try{
			StringBuffer sql = new StringBuffer("");
			sql.append("DELETE T_C_FORM_COLUMNS");
			sql.append("WHERE ID = ?");
			ps = deleteRecord(sql);
			ps.setString(1, vo.getCid());
			ps.execute();closePS();
			return "success";
		} catch(Exception e){
			System.out.println("Error at BaseFormColumnsDAO.addFormColumns : " + e.getMessage());
		}
		return null;
	}
}
