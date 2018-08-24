package tao.dao.core;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			logger.info("Error at BaseFormColumnsDAO.addFormColumns : " + e.getMessage());
		}
		return null;
	}
	
	public String deleteFormColumns(String fid, String colid){
		try{
			StringBuffer sql = new StringBuffer("");
			sql.append("DELETE T_C_FORM_COLUMNS");
			sql.append("WHERE formid = ? and columnid = ?");
			ps = deleteRecord(sql);
			ps.setString(1, fid);
			ps.setString(2, colid);
			ps.execute();closePS();
			return "success";
		} catch(Exception e){
			logger.info("Error at BaseFormColumnsDAO.deleteFormColumns : " + e.getMessage());
		}
		return null;
	}
	
	public BColumnVO getFormColumns(String n){
		try{
			StringBuffer sql = new StringBuffer("");
			sql.append("select b.id,b.name,b.label,b.description,b.data_type,b.value_url,b.checkregex,b.created_by,b.created_date,b.updated_by,b.updated_date from t_c_form_columns a inner join t_c_columns b on a.columnid = b.id ");
			sql.append(" where a.formid=? ");
			ps = setSQLRecords(sql);		
			ps.setString(1,"%"+n+"%");
			BColumnVO vo = new BColumnVO();
			vo = (BColumnVO) getRecords(this); closePS();
			return vo;
		}catch(SQLException e){
			logger.info("Error at BaseFormsDAO.getForms : " + e.getMessage());
		}
		return null;
	}
	
	@Override
	public BColumnVO setRecordsInVO(ResultSet rs) {
		//-----id,code,label,description,url,name,tablename,created_by,created_date,updated_by,updated_date--
		try{
			if(rs!=null){
				BColumnVO vo = new BColumnVO();
				vo.setList(new ArrayList(0));
				while(rs.next()){
					BColumnVO vl = new BColumnVO();
					vl.setCid(rs.getString(1));
					vl.setName(rs.getString(2));
					vl.setLabel(rs.getString(3));
					vl.setDescription(rs.getString(4));
					vl.setDataType(rs.getString(5));
					vl.setUrl(rs.getString(6));
					vl.setRegex(rs.getString(7));
					vl.setCreatedBy(rs.getString(8));
					vl.setCreatedDate(rs.getDate(9));
					vl.setUpdatedBy(rs.getString(10));
					vl.setUpdatedDate(rs.getDate(11));
					vo.getList().add(vl);
				}
				return vo;
			}
		}catch(SQLException e){
			logger.info("SQLException at BaseFormDAO.setRecordsInVO : " + e.getMessage());
		}
		return null;
	}
}
