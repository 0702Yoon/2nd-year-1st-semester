package control;

import model.MFind;
import valueObject.VUserInfo;

public class CFind {

	public VUserInfo run(VUserInfo vUserInfo, int answer) {
		MFind mFind = new MFind();
		vUserInfo= mFind.run(vUserInfo,answer, "account/account");
		return vUserInfo;
	}



}
