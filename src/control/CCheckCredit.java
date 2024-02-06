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
			//��ü �ȿ��� �����ִ� �� ���� �װ� ������ ���� �� ���� �ʴ�. �װ� ���� ������ ����̴�. 
			totalGrade+=vLecture.getCredit();
		}
		return totalGrade;
	}

}
