package tao.unit.test;

import java.io.BufferedReader;
import java.io.FileReader;

public class BFileReader {
	 public void read(String f) throws Exception {
		    BufferedReader br = new BufferedReader(new FileReader(f));
		    String line = null;
		    while ((line = br.readLine()) != null) {
		      String[] values = line.split(",");
		      for (String str : values) {
		        System.out.println(str);
		      }
		    }
		    br.close();
		  }
}
