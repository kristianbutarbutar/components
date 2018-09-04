package tao.unit.test;

import java.io.UnsupportedEncodingException;

import tao.dao.core.BaseCategoryDAO;
import tao.dao.core.BaseColumnsDAO;
import tao.vo.BCategoryVO;
import tao.vo.BColumnVO;

public class BColumnUTest extends TestSvc{
	public static void main(String... args) throws Exception {
		BColumnUTest t = new BColumnUTest();
		t.recordFileReadInsertToDB("columns_details.txt", t);
	}
	
	@Override
	public void recordFileReadInsertToDB(String... args) {
		try{
			BColumnVO vo = new BColumnVO();
			BaseColumnsDAO d = new BaseColumnsDAO();
			//System.out.println(args[0]);
			vo.setCid(d.genCid("CL"));
			vo.setName(args[0]);
			vo.setLabel(args[1]);
			vo.setDescription(args[2]);
			vo.setDataType(args[3]);
			vo.setUrl(args[4]);
			vo.setRegex(args[5]);
			vo.setCreatedBy("test");
			vo.setCreatedDate(new java.util.Date());
			vo.setUpdatedBy("");
			vo.setUpdatedDate(new java.util.Date());				
			d.addColumn(vo);
			
		} catch(UnsupportedEncodingException e){
			System.out.println("Error at BCategoryUTest.recordFileReadInsertToDB : " + e.getMessage());
		}	
	}
}
