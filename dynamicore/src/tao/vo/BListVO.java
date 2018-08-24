package tao.vo;

import java.util.List;

public class BListVO extends BaseVO{
	private long id = 72987522l;
	private String categoryCid;
	private String name;
	private String code;
	private String description;
	private String cid;
	private List<BListVO> list;
	
	
	
	public List<BListVO> getList() {
		return list;
	}
	public void setList(List<BListVO> list) {
		this.list = list;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCategoryCid() {
		return categoryCid;
	}
	public void setCategoryCid(String categoryCid) {
		this.categoryCid = categoryCid;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
