package tao.dao.core;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import tao.vo.BFormVO;

public class BaseFormsDAO extends BaseDAO {
	private static final Logger logger = Logger.getLogger(BaseFormsDAO.class);
	private PreparedStatement ps = null;	
	public String addForm(BFormVO vo){
		try{
			StringBuffer sql = new StringBuffer("");
			sql.append("INSERT INTO T_C_FORMS(id,code,label,description,url,name,tablename,created_by,created_date,updated_by,updated_date)");
			sql.append("VALUES (?,?,?,?,?,?,?,?,?,?,?)");
			ps = addRecord(sql);
			ps.setString(1, vo.getCid());
			ps.setString(2, vo.getCode());
			ps.setString(3, vo.getLabel());
			ps.setString(4, vo.getDescription());
			ps.setString(5, vo.getUrl());
			ps.setString(6, vo.getName());
			ps.setString(7, vo.getTableName());
			ps.setString(8, vo.getCreatedBy());
			ps.setDate(9, convertUtilToSql(vo.getCreatedDate()));
			ps.setString(10, vo.getUpdatedBy());
			ps.setDate(11, convertUtilToSql(vo.getUpdatedDate()));
			ps.execute();closePS();
			return "success";
			
		} catch(Exception e){
			logger.info("Error at BaseFormDAO.addForm : " + e.getMessage());
		}
		return null;
	}
	public String updateForm(BFormVO vo){
		try{
			StringBuffer sql = new StringBuffer("");
			sql.append("UPDATE T_C_FORMS ");
			sql.append("set code=?,label=?,description=?,url,name=?,tablename=?,updated_by=?,updated_date=? ");
			sql.append("WHERE ID = ?");
			ps = updateRecord(sql);
			ps.setString(1, vo.getCode());
			ps.setString(2, vo.getLabel());
			ps.setString(3, vo.getDescription());
			ps.setString(4, vo.getUrl());
			ps.setString(5, vo.getName());
			ps.setString(6, vo.getTableName());
			ps.setString(7, vo.getUpdatedBy());
			ps.setDate(8, convertUtilToSql(vo.getUpdatedDate()));
			ps.setString(9, vo.getCid());
			ps.execute();closePS();
			
			return "sucess";
			
		} catch(Exception e){
			logger.info("Error at BaseFormDAO.addForm : " + e.getMessage());
		}
		return null;
	}
	public String deleteForm(BFormVO vo){
		try{
			StringBuffer sql = new StringBuffer("");
			sql.append("DELETE T_C_FORMS ");
			sql.append("WHERE ID = ? ");
			ps = deleteRecord(sql);
			ps.setString(1, vo.getCid());
			ps.execute();closePS();
			return "success";
		} catch(Exception e){
			logger.info("Error at BaseFormDAO.addForm : " + e.getMessage());
		}
		return null;
	}
	
	public BFormVO getForms(String n) {
		try{
			StringBuffer sql = new StringBuffer("");
			sql.append("select id,code,label,description,url,name,tablename,created_by,created_date,updated_by,updated_date from t_c_forms");
			if(n!=null){
				if(IsById(n)){
					sql.append(" where id like ? ");
				}
				else sql.append(" where label like ? ");
			}
			ps = setSQLRecords(sql);		
			if(n!=null){
				ps.setString(1, "%"+n+"%");
			}
			BFormVO vo = new BFormVO();
			vo = (BFormVO) getRecords(this); closePS();
			return vo;
		}catch(SQLException e){
			logger.info("Error at BaseFormsDAO.getForms : " + e.getMessage());
		}
		return null;
	}
	
	@Override
	public BFormVO setRecordsInVO(ResultSet rs) {
		//-----id,code,label,description,url,name,tablename,created_by,created_date,updated_by,updated_date--
		try{
			if(rs!=null){
				BFormVO vo = new BFormVO();
				vo.setList(new ArrayList(0));
				while(rs.next()){
					BFormVO vl = new BFormVO();
					vl.setCid(rs.getString(1));
					vl.setCode(rs.getString(2));
					vl.setLabel(rs.getString(3));
					vl.setDescription(rs.getString(4));
					vl.setUrl(rs.getString(5));
					vl.setName(rs.getString(6));
					vl.setTableName(rs.getString(7));
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
