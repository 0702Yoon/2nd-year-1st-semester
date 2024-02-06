package presentation;

import java.util.Scanner;

import valueObject.VUserInfo;

public class PHaksaGwanri {
	private int answer;
	public int run(VUserInfo vUserInfo, Scanner keyboard) {
		if(vUserInfo==null) {
		System.out.println("명지대 학사관리입니다. \n무엇을 하시겠습니까? \n수강신청하기: 1번 로그인 및 계정 관련 업무: 2번 학사관리 종료하기: 9번");
		answer = keyboard.nextInt();
		}
		
		else {
			System.out.println("명지대 학사관리입니다. \n무엇을 하시겠습니까? \n수강신청하기: 1번 로그아웃: 2번 학사관리 종료하기: 9번");
		 answer = keyboard.nextInt();
		 System.out.println();
		}
		return answer;
	}

}
