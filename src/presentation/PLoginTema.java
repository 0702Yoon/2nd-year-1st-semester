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
		System.out.println("로그인하기: 1번 회원가입: 2번 계정찾기: 3번 학사관리: 4번");
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
