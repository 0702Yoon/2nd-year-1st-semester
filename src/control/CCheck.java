package control;

import model.MCheck;
import valueObject.VLecture;

public class CCheck {
	private MCheck mCheck;
	
	public CCheck() {
		mCheck = new MCheck();
	}
	
	public int check(VLecture vLecture, String basket) {
		return mCheck.check(vLecture,basket);
		
	}

}
