package tao.vo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BFormVO extends BaseVO{
	
	private long id = 1000298761l;
	private String cid;
	private String code;
	private String name;
	private String label;
	private String description;
	private String url;
	private String tableName;
	private BColumnVO columns[];
	private List<BFormVO> list;
	
	
	public List<BFormVO> getList() {
		return list;
	}
	public void setList(List<BFormVO> list) {
		this.list = list;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public BColumnVO[] getColumns() {
		return columns;
	}
	public void setColumns(BColumnVO[] columns) {
		this.columns = columns;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
}
