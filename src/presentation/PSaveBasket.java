package presentation;

import java.util.Vector;

import model.MSaveBasket;
import valueObject.VLecture;

public class PSaveBasket {

	public Vector<VLecture> load(String message) {
		MSaveBasket mSaveBasket = new MSaveBasket();
		
		Vector<VLecture> vLectureVector = mSaveBasket.load(message);
		
		return vLectureVector;
	}

}
