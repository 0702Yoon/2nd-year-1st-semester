package model;

import valueObject.VLecture;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;

public class MTextFindLecture {

	public VLecture find(int findCode) {
		VLecture vLecture = null;
		try {
		Scanner fileSc;
			fileSc = new Scanner(new File("treeData/findtext.txt"));
		 int i =0;
		while(fileSc.hasNext()) {
			String line = fileSc.nextLine();
			String[] token = line.split(" ");
			int code = Integer.parseInt(token[0]);
			
			if(code==findCode) {
				vLecture = new VLecture();
				vLecture.lineLoad(token);
			}
			
		}
		fileSc.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vLecture;
	}

}
	