package presentation;

import java.util.Scanner;

import valueObject.VUserInfo;

public class PHaksaGwanri {
	private int answer;
	public int run(VUserInfo vUserInfo, Scanner keyboard) {
		if(vUserInfo==null) {
		System.out.println("������ �л�����Դϴ�. \n������ �Ͻðڽ��ϱ�? \n������û�ϱ�: 1�� �α��� �� ���� ���� ����: 2�� �л���� �����ϱ�: 9��");
		answer = keyboard.nextInt();
		}
		
		else {
			System.out.println("������ �л�����Դϴ�. \n������ �Ͻðڽ��ϱ�? \n������û�ϱ�: 1�� �α׾ƿ�: 2�� �л���� �����ϱ�: 9��");
		 answer = keyboard.nextInt();
		 System.out.println();
		}
		return answer;
	}

}
