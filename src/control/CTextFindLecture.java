package control;

import model.MTextFindLecture;
import valueObject.VLecture;

public class CTextFindLecture {

	public VLecture find(int findCode) {
		MTextFindLecture mTextFindLecture = new MTextFindLecture();
		VLecture vLecture = mTextFindLecture.find(findCode);
		return vLecture;
	}

}
