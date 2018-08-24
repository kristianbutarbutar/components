package tao.unit.test;

import java.io.UnsupportedEncodingException;

import tao.dao.core.BaseColumnsDAO;
import tao.dao.core.BaseFormsDAO;
import tao.vo.BColumnVO;
import tao.vo.BFormVO;

public class BFormUTest extends TestSvc {
	public static void main(String... args) throws Exception{
		BFormUTest t = new BFormUTest();
		t.recordFileReadInsertToDB("forms.txt", t);
	}
	
	@Override
	public void recordFileReadInsertToDB(String... args) {
		try{
			BFormVO vo = new BFormVO();
			BaseFormsDAO d = new BaseFormsDAO();
			System.out.println(args[0]);
			vo.setCid(d.genCid("F"));
			vo.setCode(args[0]);
			vo.setLabel(args[1]);
			vo.setDescription(args[2]);
			vo.setUrl("https://");
			vo.setName(args[3]);
			vo.setTableName(args[4]);
			vo.setCreatedBy("test");
			vo.setCreatedDate(new java.util.Date());
			vo.setUpdatedBy("");
			vo.setUpdatedDate(new java.util.Date());
			d.addForm(vo);
			
		} catch(UnsupportedEncodingException e){
			System.out.println("Error at BCategoryUTest.recordFileReadInsertToDB : " + e.getMessage());
		}	
	}
}
