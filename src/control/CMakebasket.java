package control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CMakebasket {

	public void run(String name) {
		try {
		File miriBasket = new File("list/"+name+"미리담기");
		File SinchengBasket = new File("list/"+name+"수강신청");
			FileWriter fw = new FileWriter(miriBasket,true);
			FileWriter fw2 = new FileWriter(SinchengBasket,true);
			fw.close();
			fw2.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
