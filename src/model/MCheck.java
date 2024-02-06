package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import valueObject.VLecture;

public class MCheck {

	public int check(VLecture vLecture, String basket) {
		try {
			Scanner fileSc = new Scanner(new File("list/"+basket));
			
			loap:while(fileSc.hasNext()) {
				VLecture vLecture2 = new VLecture();
				vLecture2.load(fileSc);
				if(vLecture2.getCode()==vLecture.getCode()) {
					
					return 1;
				}
			}
			fileSc.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
		
	}

}
