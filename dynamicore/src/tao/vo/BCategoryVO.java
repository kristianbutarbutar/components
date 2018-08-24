package tao.vo;

import java.util.List;

public class BCategoryVO extends BaseVO{
	private long id = 988275521l;
	private String name;
	private String code;
	private String cid;
	private String parentCid;
	private String description;
	private List<BCategoryVO> list;
	
	
	public List<BCategoryVO> getList() {
		return list;
	}
	public void setList(List<BCategoryVO> list) {
		this.list = list;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getParentCid() {
		return parentCid;
	}
	public void setParentCid(String parentCid) {
		this.parentCid = parentCid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
