package tao.dao.core;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import tao.vo.BCategoryVO;
import tao.vo.BColumnVO;
import tao.vo.BFormVO;

public class BaseCategoryDAO extends BaseDAO{
	private static final Logger logger = Logger.getLogger(BaseCategoryDAO.class);
	private PreparedStatement ps = null;	
	public String addCategory(BCategoryVO vo){
		try{
			StringBuffer sql = new StringBuffer("");
			sql.append("INSERT INTO T_C_CATEGORY(id,name,code,description,parent_id,created_by,created_date,updated_by,updated_date) ");
			sql.append("VALUES (?,?,?,?,?,?,?,?,?)");
			ps = addRecord(sql);
			ps.setString(1, vo.getCid());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getCode());
			ps.setString(4, vo.getDescription());
			ps.setString(5, vo.getParentCid());
			ps.setString(6, vo.getCreatedBy());
			ps.setDate(7, convertUtilToSql(vo.getCreatedDate()));
			ps.setString(8, vo.getUpdatedBy());
			ps.setDate(9, convertUtilToSql(vo.getUpdatedDate()));
			ps.execute();closePS();
			return "success";
		} catch(Exception e){
			logger.info("Error at BaseCategoryDAO.addCategory : " + e.getMessage());
		}
		return null;
	}
	public String updateCategory(BCategoryVO vo){
		try{
			StringBuffer sql = new StringBuffer("");
			sql.append("UPDATE T_C_CATEGORY");
			sql.append("SET name=?,code=?,description=?,parent_id=?,updated_by=?,updated_date=?");
			sql.append("WHERE ID = ?");
			ps = updateRecord(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getCode());
			ps.setString(3, vo.getDescription());
			ps.setString(4, vo.getParentCid());
			ps.setString(5, vo.getUpdatedBy());
			ps.setDate(6, convertUtilToSql(vo.getUpdatedDate()));
			ps.setString(7, vo.getCid());
			ps.execute();closePS();
			return "success";
		} catch(Exception e){
			logger.info("Error at BaseCategoryDAO.addCategory : " + e.getMessage());
		}
		return null;
	}
	public String deleteCategory(BCategoryVO vo){
		try{
			StringBuffer sql = new StringBuffer("");
			sql.append("DELETE T_C_CATEGORY ");
			sql.append("WHERE ID = ?");			
			ps = deleteRecord(sql);
			ps.setString(1, vo.getCid());			
			ps.execute();closePS();
			return "success";
		} catch(Exception e){
			logger.info("Error at BaseCategoryDAO.addCategory : " + e.getMessage());
		}
		return null;
	}
	
	public BCategoryVO getCategories(String n){
		try{
			StringBuffer sql = new StringBuffer("");
			sql.append("select id,name,code,description,parent_id,created_by,created_date,updated_by,updated_date from t_c_category");
			if(n!=null){
				if(IsById(n)){
					sql.append(" where id like ? ");
				}
				else sql.append(" where name like ? ");
			}
			ps = setSQLRecords(sql);		
			if(n!=null){
				ps.setString(1,"%"+n+"%");
			}
			BCategoryVO vo = new BCategoryVO();
			vo = (BCategoryVO) getRecords(this); closePS();
			return vo;
		}catch(SQLException e){
			logger.info("Error at BaseFormsDAO.getForms : " + e.getMessage());
		}
		return null;
	}
	
	@Override
	public BCategoryVO setRecordsInVO(ResultSet rs) {
		//---id,name,code,description,parent_id,created_by,created_date,updated_by,updated_date--
		try{
			if(rs!=null){
				BCategoryVO vo = new BCategoryVO();
				vo.setList(new ArrayList(0));
				while(rs.next()){
					BCategoryVO vl = new BCategoryVO();
					vl.setCid(rs.getString(1));
					vl.setName(rs.getString(2));
					vl.setCode(rs.getString(3));
					vl.setDescription(rs.getString(4));
					vl.setParentCid(rs.getString(5));
					vl.setCreatedBy(rs.getString(6));
					vl.setCreatedDate(rs.getDate(7));
					vl.setUpdatedBy(rs.getString(8));
					vl.setUpdatedDate(rs.getDate(9));
					vo.getList().add(vl);
				}
				return vo;
			}
		}catch(SQLException e){
			logger.info("SQLException at BaseCategoryDAO.setRecordsInVO : " + e.getMessage());
		}
		return null;
	}

}
