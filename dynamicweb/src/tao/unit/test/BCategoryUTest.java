package tao.unit.test;

import java.io.UnsupportedEncodingException;

import tao.dao.core.BaseCategoryDAO;
import tao.vo.BCategoryVO;

public class BCategoryUTest extends TestSvc {
	public static void main(String... args) throws Exception {
		BCategoryUTest t =  new BCategoryUTest();
		t.recordFileReadInsertToDB("category.txt", t);
	}

	@Override
	public void recordFileReadInsertToDB(String... args) {
		try{
			BCategoryVO vo = new BCategoryVO();
			BaseCategoryDAO d = new BaseCategoryDAO();
			System.out.println(args[0]);
			vo.setCid(d.genCid("C"));
			vo.setCode(args[0]);
			vo.setName(args[1]);
			vo.setDescription(args[2]);
			vo.setParentCid("");
			vo.setCreatedBy("test");
			vo.setCreatedDate(new java.util.Date());
			vo.setUpdatedBy("");
			vo.setUpdatedDate(new java.util.Date());			
			d.addCategory(vo);
			
		} catch(UnsupportedEncodingException e){
			System.out.println("Error at BCategoryUTest.recordFileReadInsertToDB : " + e.getMessage());
		}	
	}
}
