package tao.vo;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class EntityVO {
	private long id = 1092873654l;
	private ColumnVO[] fields;
	private String entityCode;
	private String entityName;
	private String entityLabel;
	private EntityVO[] records;
	
	public EntityVO[] getRecords() {
		return records;
	}
	public void setRecords(EntityVO[] records) {
		this.records = records;
	}
	public List getFieldsInList(){
		List l = new ArrayList();
		if(fields != null){			
			l = Arrays.stream(fields).collect(Collectors.toList());
		}
		return l;
	}
	public int getRecordsNo(){
		return (fields != null ? fields.length:0);
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ColumnVO[] getFields() {
		return fields;
	}
	public void setFields(ColumnVO[] fields) {
		this.fields = fields;
	}
	public String getEntityCode() {
		return entityCode;
	}
	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getEntityLabel() {
		return entityLabel;
	}
	public void setEntityLabel(String entityLabel) {
		this.entityLabel = entityLabel;
	}
	
}
