package presentation;

import java.util.Scanner;
import java.util.Vector;

import control.Basket;
import control.CCheck;
import control.CCheckCredit;
import control.CModify;
import valueObject.VLecture;
import valueObject.VUserInfo;

public class PBasket {
	private PLectureSelection pLectureSelection;
	private Vector<VLecture> vLectureVector;
	private CModify cModify;
	private int answer; 
	private Basket SinchengBasket;
	private PSaveBasket pSaveBasket;
	private VUserInfo vUserInfo;
	private CCheck cCheck;
	private CCheckCredit cCheckCredit; 
	
	public PBasket(VUserInfo vUserInfo, String field) {
		this.vLectureVector = new Vector<VLecture>();
		this.pLectureSelection = new PLectureSelection();
		this.cModify = new CModify();
		this.SinchengBasket = new Basket();
		this.pSaveBasket = new PSaveBasket();
		this.vLectureVector = pSaveBasket.load(vUserInfo.getName()+field);
		this.vUserInfo = vUserInfo;
		this.cCheck = new CCheck();
		this.cCheckCredit = new CCheckCredit(vUserInfo);
		
	}
	public void add(VLecture vLecture) {
		this.vLectureVector.add(vLecture);
		
	}
	
	public void Damgi(String message, VLecture vLecture, Scanner keyboard) {
		//여기다가 그 선택지 집어넣고 하나에 통합시키면 되겠다.
		try {
		if(cCheck.check(vLecture,vUserInfo.getName()+message)==1) {
			System.out.println("중복된 강좌입니다!\n");
		}
		else if(cCheckCredit.run(vLectureVector)+ vLecture.getCredit()>vUserInfo.getCredit()) {
			System.out.println("학점을 초과하셔서 "+message+"에 못담으십니다!\n현재 남은 학점수: "+(vUserInfo.getCredit()-cCheckCredit.run(vLectureVector)+"\n"));
		}
		else {
		System.out.println(message+"에 담겠다: 0, "+message+"에 안담겠다: 1");
		 answer = keyboard.nextInt();
		 if(answer==0) {
			vLectureVector.add(vLecture);
			 vLecture=null;
		 }
		 else {
			 vLecture=null;
		 }
		 SinchengBasket.run("list/"+vUserInfo.getName()+message,vLectureVector);	 
		}
		}
		catch (NullPointerException e) {
			
		}
		}
	
	public void show(VUserInfo vUserInfo,String message) {
		System.out.println(vUserInfo.getName()+"님의 "+message+" 목록입니다.\n");
		int i =1;
		int totalGrade =0;
		for(VLecture vLecture:vLectureVector ) {
			System.out.print(i+++"번 ");
			vLecture.show();
			//객체 안에서 보여주는 게 좋지 그걸 끄집어 내는 건 좋지 않다. 그건 별로 안좋은 방법이다. 
			totalGrade+=vLecture.getCredit();
		}
		System.out.println("총 학점: "+totalGrade+" 남은 학점:"+(vUserInfo.getCredit()-totalGrade)+"\n");
		
	}
	
	public void pModify(Scanner keyboard, Vector<VLecture> vLectureVector,String message) {
		show(vUserInfo,message);
		System.out.println("한 개의 위치바꾸기: 0 두 개의 위치바꾸기: 1 삭제하기: 2");
		answer = keyboard.nextInt();
		vLectureVector = cModify.run(answer,vLectureVector,keyboard);
		show(vUserInfo,message);
		SinchengBasket.run("list/"+vUserInfo.getName()+message,vLectureVector);
	}
	
	public Vector<VLecture> miriDamgilist(){
		return vLectureVector;
		
	}
	

	
	public void menu(String message,Scanner keyboard) {
		
		System.out.println(message+" 담기: 0 "+ message+" 확인: 1 "+message+" 수정: 2");
		answer =keyboard.nextInt();
		
		switch(answer) {
		case 0:
			VLecture vLecture = null;
			vLecture = pLectureSelection.selectLecture(keyboard);
			
			Damgi(message, vLecture, keyboard);
			break;
		case 1:
			show(vUserInfo, message);
			break;
		case 2:
			pModify(keyboard,vLectureVector,message);
			break;
		}
	}
		public void menu(String message,Scanner keyboard, PBasket pMiridamgiBasket) {
			System.out.println(message+" 담기: 0 "+ message+" 확인: 1 "+message+" 수정: 2");
			answer =keyboard.nextInt();
			
			switch(answer) {
			case 0:
				System.out.println("검색해서 담으시겠습니까?: 0번 미리담기에서 담으시겠습니까? 1번");
				answer = keyboard.nextInt();
				if(answer ==0) {
					VLecture vLecture = null;
					vLecture = pLectureSelection.selectLecture(keyboard);
					if(vLecture!=null) {
					Damgi("수강신청", vLecture, keyboard);
					}
					else {
						return;
					}
				}
				else if(answer == 1) {
					pMiridamgiBasket.show(vUserInfo, "미리담기");
					System.out.println("몇 번을 담으시겠습니까?");
					answer = keyboard.nextInt();
					VLecture vLecture = null;
					vLecture = pMiridamgiBasket.miriDamgilist().get(answer-1);
					Damgi("수강신청",vLecture,keyboard);
				}
				 
				break;
			case 1:
				show(vUserInfo,message);
				break;
			case 2:
				pModify(keyboard,vLectureVector,message);
				 
				break;
			}
		
		
		
	}
}
