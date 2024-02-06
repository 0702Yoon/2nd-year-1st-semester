package presentation;

import java.util.Scanner;

import valueObject.VLecture;
import valueObject.VUserInfo;

public class PSugangsincheng {
	
	private PLectureSelection pLectureSelection;
	private PBasket pMiriBasket;
	private PBasket pSugangBasket;
	
	public PSugangsincheng(VUserInfo vUserInfo) {
		this.pLectureSelection = new PLectureSelection();
		this.pMiriBasket = new PBasket(vUserInfo,"미리담기");
		this.pSugangBasket = new PBasket(vUserInfo,"수강신청");
		
	}
	public void run(VUserInfo vUserInfo, Scanner keyboard) {
		VLecture vLecture = null;
		boolean bRunning = true;
		
		while(bRunning){
		System.out.println("강좌 선택: 0, 미리담기: 1, 수강신청: 2, 수강신청 종료: 9");	
		
		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode);
		
		switch(iCode) {
		case 0:
			vLecture = pLectureSelection.selectLecture(keyboard);
			break;
		case 1:
			if(vLecture!=null) {
				//null이 아닌 경우에만 담는 선택지가 나왔으면
				pMiriBasket.Damgi("미리담기",vLecture,keyboard);
				vLecture=null;
			}
			else if(vLecture==null) {
				pMiriBasket.menu("미리담기",keyboard);

			}
			
			//초기화 시켜버림
			break;
		case 2:
			if(vLecture!=null) {
				//null이 아닌 경우에만 담는 선택지가 나왔으면
				pSugangBasket.Damgi("수강신청",vLecture,keyboard);
				vLecture=null;
			}
			else if(vLecture==null) {
				pSugangBasket.menu("수강신청",keyboard, pMiriBasket);

			}
			vLecture=null;
			break;
		case 9:
			System.out.println("수강신청이 종료되었습니다.\n");
			bRunning=false;
			break;
		default:
			break;
		}
		//else if보다 빠른 건 이거다. 딱딱 간다.
		//프로그램을 어떻게 객체로 나눌지 생각하는 것이다. 이건 얘한테 얼마만큼 일을 줄 것인진 트레이드 오프이다? 관리가 복잡해진다. 

		
		}
	}
}

