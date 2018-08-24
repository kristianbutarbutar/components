package tao.dao.core;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import tao.vo.BColumnVO;
import tao.vo.BFormVO;
import tao.vo.BListVO;

public class BaseListsDAO extends BaseDAO {
	private static final Logger logger = Logger.getLogger(BaseListsDAO.class);
	private PreparedStatement ps = null;	
	public String addList(BListVO vo){
		try{
			StringBuffer sql = new StringBuffer("");
			sql.append("INSERT INTO T_C_List(id,categoryid,name,code,description,created_by,created_date,updated_by,updated_date) ");
			sql.append("VALUES (?,?,?,?,?,?,?,?,?)");
			ps = addRecord(sql);
			ps.setString(1, vo.getCid());
			ps.setString(2, vo.getCategoryCid());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getCode());
			ps.setString(5, vo.getDescription());
			ps.setString(6, vo.getCreatedBy());
			ps.setDate(7,convertUtilToSql(vo.getCreatedDate()));
			ps.setString(8, vo.getUpdatedBy());
			ps.setDate(9, convertUtilToSql(vo.getUpdatedDate()));
			ps.execute(); closePS();
			return "success";
			
		} catch(Exception e){
			logger.info("Error at BaseListDAO.addList : " + e.getMessage());
		}
		return null;
	}
	public String updateList(BListVO vo){
		try{
			StringBuffer sql = new StringBuffer("");
			sql.append("UPDATE T_C_List");
			sql.append("SET categoryid=?,name=?,code=?,description=?,updated_by=?,updated_date=?");
			sql.append("WHERE ID = ?");
			
			ps = updateRecord(sql);
			
			ps.setString(1, vo.getCategoryCid());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getCode());
			ps.setString(4, vo.getDescription());			
			ps.setString(5, vo.getUpdatedBy());
			ps.setDate(6, convertUtilToSql(vo.getUpdatedDate()));
			ps.setString(7, vo.getCid());
			ps.execute();closePS();
			return "success";
		} catch(Exception e){
			logger.info("Error at BaseListDAO.addList : " + e.getMessage());
		}
		return null;
	}
	public String deleteList(BListVO vo){
		try{
			StringBuffer sql = new StringBuffer("");
			sql.append("DELETE T_C_List ");
			sql.append("WHERE ID = ?");			
			ps = deleteRecord(sql);
			ps.setString(1, vo.getCid());
			ps.execute();closePS();
			return "success";			
		} catch(Exception e){
			logger.info("Error at BaseListDAO.addList : " + e.getMessage());
		}
		return null;
	}
	
	public BListVO getLists(String n){
		try{
			StringBuffer sql = new StringBuffer("");
			sql.append("select id,categoryid,name,code,description,created_by,created_date,updated_by,updated_date from t_c_list");
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
			BListVO vo = new BListVO();
			vo = (BListVO) getRecords(this); closePS();
			return vo;
		}catch(SQLException e){
			logger.info("Error at BaseFormsDAO.getForms : " + e.getMessage());
		}
		return null;
	}
	
	@Override
	public BListVO setRecordsInVO(ResultSet rs) {
		//-----id,categoryid,name,code,description,created_by,created_date,updated_by,updated_date--
		try{
			if(rs!=null){
				BListVO vo = new BListVO();
				vo.setList(new ArrayList(0));
				while(rs.next()){
					BListVO vl = new BListVO();
					vl.setCid(rs.getString(1));
					vl.setCategoryCid(rs.getString(2));
					vl.setName(rs.getString(3));
					vl.setCode(rs.getString(4));
					vl.setDescription(rs.getString(5));
					vl.setCreatedBy(rs.getString(6));
					vl.setCreatedDate(rs.getDate(7));
					vl.setUpdatedBy(rs.getString(8));
					vl.setUpdatedDate(rs.getDate(9));
					vo.getList().add(vl);
				}
				return vo;
			}
		}catch(SQLException e){
			logger.info("SQLException at BaseListsDAO.setRecordsInVO : " + e.getMessage());
		}
		return null;
	}
}
