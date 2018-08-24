package tao.unit.test;

import java.io.UnsupportedEncodingException;

import tao.dao.core.BaseFormsDAO;
import tao.dao.core.BaseListsDAO;
import tao.vo.BFormVO;
import tao.vo.BListVO;

public class BListUTest extends TestSvc {
	public static void main(String... args) throws Exception{
		BListUTest t=new BListUTest();
		t.recordFileReadInsertToDB("list.txt", t);
	}
	
	@Override
	public void recordFileReadInsertToDB(String... args) {
		try{
			BListVO vo = new BListVO();
			BaseListsDAO d = new BaseListsDAO();
			
			vo.setCid(d.genCid("L"));
			vo.setCategoryCid("GenderId");
			vo.setName("Male");
			vo.setCode("M");
			vo.setDescription("Male");
			vo.setCreatedBy("test");
			vo.setCreatedDate(new java.util.Date());
			vo.setUpdatedBy("");
			vo.setUpdatedDate(new java.util.Date());
					
			d.addList(vo);
			
		} catch(UnsupportedEncodingException e){
			System.out.println("Error at BCategoryUTest.recordFileReadInsertToDB : " + e.getMessage());
		}	
	}
}
