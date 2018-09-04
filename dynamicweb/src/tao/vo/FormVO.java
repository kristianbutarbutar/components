package tao.vo;

public class FormVO extends Object{
	private long id = 1982373466l;
	private String formCode;
	private String formLabel;
	private String formDescription;
	private String formURL;
	private String formName;
	private String tableName;
	private String tid;
	private ColumnVO[] columns;
	
	
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public ColumnVO[] getColumns() {
		return columns;
	}
	public void setColumns(ColumnVO[] columns) {
		this.columns = columns;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFormCode() {
		return formCode;
	}
	public void setFormCode(String formCode) {
		this.formCode = formCode;
	}
	public String getFormLabel() {
		return formLabel;
	}
	public void setFormLabel(String formLabel) {
		this.formLabel = formLabel;
	}
	public String getFormDescription() {
		return formDescription;
	}
	public void setFormDescription(String formDescription) {
		this.formDescription = formDescription;
	}
	public String getFormURL() {
		return formURL;
	}
	public void setFormURL(String formURL) {
		this.formURL = formURL;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	
	
}
