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
		//����ٰ� �� ������ ����ְ� �ϳ��� ���ս�Ű�� �ǰڴ�.
		try {
		if(cCheck.check(vLecture,vUserInfo.getName()+message)==1) {
			System.out.println("�ߺ��� �����Դϴ�!\n");
		}
		else if(cCheckCredit.run(vLectureVector)+ vLecture.getCredit()>vUserInfo.getCredit()) {
			System.out.println("������ �ʰ��ϼż� "+message+"�� �������ʴϴ�!\n���� ���� ������: "+(vUserInfo.getCredit()-cCheckCredit.run(vLectureVector)+"\n"));
		}
		else {
		System.out.println(message+"�� ��ڴ�: 0, "+message+"�� �ȴ�ڴ�: 1");
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
		System.out.println(vUserInfo.getName()+"���� "+message+" ����Դϴ�.\n");
		int i =1;
		int totalGrade =0;
		for(VLecture vLecture:vLectureVector ) {
			System.out.print(i+++"�� ");
			vLecture.show();
			//��ü �ȿ��� �����ִ� �� ���� �װ� ������ ���� �� ���� �ʴ�. �װ� ���� ������ ����̴�. 
			totalGrade+=vLecture.getCredit();
		}
		System.out.println("�� ����: "+totalGrade+" ���� ����:"+(vUserInfo.getCredit()-totalGrade)+"\n");
		
	}
	
	public void pModify(Scanner keyboard, Vector<VLecture> vLectureVector,String message) {
		show(vUserInfo,message);
		System.out.println("�� ���� ��ġ�ٲٱ�: 0 �� ���� ��ġ�ٲٱ�: 1 �����ϱ�: 2");
		answer = keyboard.nextInt();
		vLectureVector = cModify.run(answer,vLectureVector,keyboard);
		show(vUserInfo,message);
		SinchengBasket.run("list/"+vUserInfo.getName()+message,vLectureVector);
	}
	
	public Vector<VLecture> miriDamgilist(){
		return vLectureVector;
		
	}
	

	
	public void menu(String message,Scanner keyboard) {
		
		System.out.println(message+" ���: 0 "+ message+" Ȯ��: 1 "+message+" ����: 2");
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
			System.out.println(message+" ���: 0 "+ message+" Ȯ��: 1 "+message+" ����: 2");
			answer =keyboard.nextInt();
			
			switch(answer) {
			case 0:
				System.out.println("�˻��ؼ� �����ðڽ��ϱ�?: 0�� �̸���⿡�� �����ðڽ��ϱ�? 1��");
				answer = keyboard.nextInt();
				if(answer ==0) {
					VLecture vLecture = null;
					vLecture = pLectureSelection.selectLecture(keyboard);
					if(vLecture!=null) {
					Damgi("������û", vLecture, keyboard);
					}
					else {
						return;
					}
				}
				else if(answer == 1) {
					pMiridamgiBasket.show(vUserInfo, "�̸����");
					System.out.println("�� ���� �����ðڽ��ϱ�?");
					answer = keyboard.nextInt();
					VLecture vLecture = null;
					vLecture = pMiridamgiBasket.miriDamgilist().get(answer-1);
					Damgi("������û",vLecture,keyboard);
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
