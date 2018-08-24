package tao.unit.test;

import java.io.BufferedReader;
import java.io.FileReader;

public class TestSvc implements TestSvcIntf{
	private String dir = "D:\\dynamicore\\";
	 public void recordFileReadInsertToDB(String f, TestSvc t) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(dir+f));
		String line = null;int hdr = 1; //--ignore the header--
		    while ((line = br.readLine()) != null) {
		    	if(hdr==1){
		    		hdr++;
		    	}else{
		    		String[] values = line.split(",");
		    		t.recordFileReadInsertToDB(values);
		    	}
		    }
		br.close();
	}
	@Override
	public void recordFileReadInsertToDB(String... args) {
		// TODO Auto-generated method stub
	}

}
