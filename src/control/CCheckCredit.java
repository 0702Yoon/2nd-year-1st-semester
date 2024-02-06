package control;

import java.util.Vector;

import valueObject.VLecture;
import valueObject.VUserInfo;

public class CCheckCredit {

	private VUserInfo vUserInfo;
	
	public CCheckCredit(VUserInfo vUserInfo) {
		this.vUserInfo = vUserInfo;
	}

	public int run(Vector<VLecture> vLectureVector) {
		int totalGrade =0;
		for(VLecture vLecture:vLectureVector ) {
			//객체 안에서 보여주는 게 좋지 그걸 끄집어 내는 건 좋지 않다. 그건 별로 안좋은 방법이다. 
			totalGrade+=vLecture.getCredit();
		}
		return totalGrade;
	}

}
