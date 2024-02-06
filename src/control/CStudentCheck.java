package control;

import model.MFind;
import valueObject.VStudent;

public class CStudentCheck {
	
	public VStudent check(VStudent vStudent) {
		MFind mFind = new MFind();
		vStudent = mFind.check(vStudent,"account/studentId");
	
		return vStudent;
	}

}
