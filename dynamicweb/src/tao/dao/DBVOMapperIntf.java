package tao.dao;

import java.sql.ResultSet;

import tao.vo.EntityVO;

public interface DBVOMapperIntf {
	public EntityVO getAllEntity();
	public EntityVO getDBToVO(String entityCode);
	public StringBuffer getVOToDB(EntityVO vo);
	public EntityVO getFormToVO();
	public StringBuffer getFormToDB(EntityVO vo);
}
