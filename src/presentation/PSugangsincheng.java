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
		this.pMiriBasket = new PBasket(vUserInfo,"�̸����");
		this.pSugangBasket = new PBasket(vUserInfo,"������û");
		
	}
	public void run(VUserInfo vUserInfo, Scanner keyboard) {
		VLecture vLecture = null;
		boolean bRunning = true;
		
		while(bRunning){
		System.out.println("���� ����: 0, �̸����: 1, ������û: 2, ������û ����: 9");	
		
		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode);
		
		switch(iCode) {
		case 0:
			vLecture = pLectureSelection.selectLecture(keyboard);
			break;
		case 1:
			if(vLecture!=null) {
				//null�� �ƴ� ��쿡�� ��� �������� ��������
				pMiriBasket.Damgi("�̸����",vLecture,keyboard);
				vLecture=null;
			}
			else if(vLecture==null) {
				pMiriBasket.menu("�̸����",keyboard);

			}
			
			//�ʱ�ȭ ���ѹ���
			break;
		case 2:
			if(vLecture!=null) {
				//null�� �ƴ� ��쿡�� ��� �������� ��������
				pSugangBasket.Damgi("������û",vLecture,keyboard);
				vLecture=null;
			}
			else if(vLecture==null) {
				pSugangBasket.menu("������û",keyboard, pMiriBasket);

			}
			vLecture=null;
			break;
		case 9:
			System.out.println("������û�� ����Ǿ����ϴ�.\n");
			bRunning=false;
			break;
		default:
			break;
		}
		//else if���� ���� �� �̰Ŵ�. ���� ����.
		//���α׷��� ��� ��ü�� ������ �����ϴ� ���̴�. �̰� ������ �󸶸�ŭ ���� �� ������ Ʈ���̵� �����̴�? ������ ����������. 

		
		}
	}
}

