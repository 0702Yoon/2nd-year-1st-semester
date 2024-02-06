package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VLecture;

public class MSaveBasket {

	public Vector<VLecture> load(String message) {
		Vector<VLecture> vLectureVector= new Vector<VLecture>();
		try {
			Scanner fileSc = new Scanner(new File("list/"+message));
			while(fileSc.hasNext()) {
				VLecture vLecture = new VLecture();
				vLecture.load(fileSc);
				vLectureVector.add(vLecture);
			}
			fileSc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vLectureVector;
	}

}
