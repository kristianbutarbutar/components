package tao.dao.core;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import tao.vo.BColumnVO;
import tao.vo.BListVO;

public class BaseColumnsDAO  extends BaseDAO {
	private static final Logger logger = Logger.getLogger(BaseColumnsDAO.class);
	private PreparedStatement ps = null;
	public String addColumn(BColumnVO vo){
		try{
			StringBuffer sql = new StringBuffer("");
			sql.append("INSERT INTO T_C_COLUMNS(id,name,label,description,data_type,value_url,checkregex,created_by,created_date,updated_by,updated_date)");
			sql.append("VALUES (?,?,?,?,?,?,?,?,?,?,?)");
			ps = addRecord(sql);
			ps.setString(1, vo.getCid());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getLabel());
			ps.setString(4, vo.getDescription());
			ps.setString(5, vo.getDataType());
			ps.setString(6, vo.getUrl());
			ps.setString(7, vo.getRegex());
			ps.setString(8, vo.getCreatedBy());
			ps.setDate(9, convertUtilToSql(vo.getCreatedDate()));
			ps.setString(10, vo.getUpdatedBy());
			ps.setDate(11, convertUtilToSql(vo.getUpdatedDate()));
			ps.execute();closePS();
			return "success";
			
		} catch(Exception e){
			System.out.println("Error at BaseColumnDAO.addColumn : " + e.getMessage());
		}
		return null;
	}
	public String updateColumn(BColumnVO vo){
		try{
			StringBuffer sql = new StringBuffer("");
			sql.append("UPDATE T_C_COLUMNS ");
			sql.append("SET name=?,label=?,description=?,data_type=?,value_url=?,checkregex=?,updated_by=?,updated_date=? ");
			sql.append("WHERE ID=? ");
			ps = updateRecord(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getLabel());
			ps.setString(3, vo.getDescription());
			ps.setString(4, vo.getDataType());
			ps.setString(5, vo.getUrl());
			ps.setString(6, vo.getRegex());
			ps.setString(7, vo.getUpdatedBy());
			ps.setDate(8, convertUtilToSql(vo.getUpdatedDate()));
			ps.setString(9, vo.getCid());			
			ps.execute();closePS();
			return "success";
			
		} catch(Exception e){
			System.out.println("Error at BaseColumnDAO.addColumn : " + e.getMessage());
		}
		return null;
	}
	public String deleteColumn(BColumnVO vo){
		try{
			StringBuffer sql = new StringBuffer("");
			sql.append("DELETE T_C_COLUMNS ");
			sql.append("WHERE ID = ? ");
			ps = deleteRecord(sql);
			ps.setString(1, vo.getCid());
			ps.execute();closePS();
			return "";
		} catch(Exception e){
			System.out.println("Error at BaseColumnDAO.addColumn : " + e.getMessage());
		}
		return null;
	}
	
	public BColumnVO getColumns(String n){
		StringBuffer sql = new StringBuffer("");
		sql.append("select id,name,label,description,data_type,value_url,checkregex,created_by,created_date,updated_by,updated_date from t_c_columns");
		if(n!=null){
			if(IsById(n)){
				sql.append(" where id like ? ");
			}
			else sql.append(" where label like ? ");
		}
		ps = setSQLRecords(sql);		
		if(n!=null){
			sql.append("%"+n+"%");
		}
		BColumnVO vo = new BColumnVO();
		vo = (BColumnVO) getRecords(this); closePS();
		return vo;
	}
	
	@Override
	public BColumnVO setRecordsInVO(ResultSet rs) {
		//-----id,name,label,description,data_type,value_url,checkregex,created_by,created_date,updated_by,updated_date--
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
			System.out.println("SQLException at BaseColumnDAO.setRecordsInVO : " + e.getMessage());
		}
		return null;
	}
}
