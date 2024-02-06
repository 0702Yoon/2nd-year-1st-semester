package main;

import java.io.FileNotFoundException;
import java.util.Scanner;


import presentation.PGaip;
import presentation.PHaksaGwanri;
import presentation.PLogin;
import presentation.PLoginTema;
import presentation.PSugangsincheng;
import valueObject.VUserInfo;


public class Main {
	// constructor
	private Scanner keyboard;
	private PLogin pLogin;
	private PSugangsincheng pSugangsincheong;
	private PLoginTema pLoginTema;
	private VUserInfo vUserInfo;
	public Main() {
		keyboard = new Scanner(System.in);
		 pLogin = new PLogin();
		 pLoginTema = new PLoginTema();
		 vUserInfo = new VUserInfo();
		 vUserInfo=null;
	}
	
private void run() throws FileNotFoundException {
		
		loop: while(true) {	
			if(vUserInfo==null) {
		System.out.println("명지대 학사관리입니다. \n무엇을 하시겠습니까?\n수강신청하기: 1번 로그인 및 계정 관련 업무: 2번 학사관리 종료하기: 9번");
			}
			else {
				System.out.println("명지대 학사관리입니다. \n무엇을 하시겠습니까?\n수강신청하기: 1번 로그아웃: 2번 학사관리 종료하기: 9번");
			}
			int a =keyboard.nextInt();
			
		switch(a) {
		case 1:
			if(vUserInfo==null) {
				vUserInfo = pLogin.login(keyboard);
				
			if(vUserInfo!=null) {
				pSugangsincheong = new PSugangsincheng(vUserInfo);
				pSugangsincheong.run(vUserInfo,keyboard);	
			}
			} else {
				pSugangsincheong = new PSugangsincheng(vUserInfo);
				pSugangsincheong.run(vUserInfo,keyboard);	
			}
			break;
		case 2:	
			if(vUserInfo==null) {
			vUserInfo=pLoginTema.run(keyboard);}
			else if (vUserInfo!=null){
			vUserInfo = null;	
			}
			break;
		case 3:
			vUserInfo = null;
			break;
			
		default:
			System.out.println("학사관리 종료되었습니다.");
			keyboard.close();
			break loop;
		}
	}
	}
	
		
	public static void main(String[] args) throws FileNotFoundException {
		// object name declaration
		// memory allocation
		// invoke constructor
		// object name and memory address binding
		Main main = new Main();
		main.run();
	
	}
}
