package presentation;

import java.util.Scanner;

import valueObject.VUserInfo;

public class PLoginTema {
	private int answer;
	private PLogin pLogin;
	private PGaip pGaip;
	private PFindAccount pFindAccount;
	
	public PLoginTema() {
		pLogin = new PLogin();
		pGaip = new PGaip();
		pFindAccount = new PFindAccount();
	}
	
	public VUserInfo run(Scanner keyboard) {
		System.out.println("�α����ϱ�: 1�� ȸ������: 2�� ����ã��: 3�� �л����: 4��");
		answer = keyboard.nextInt();
		
		switch(answer) {
		case 1:
			VUserInfo vUserInfo = pLogin.login(keyboard);
			return vUserInfo;
		case 2:
			pGaip.run(keyboard);
			break;
		case 3:
			pFindAccount.run(keyboard);
		break;
		}
		
			
		return null;
		
	}
}
