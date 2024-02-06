package presentation;

import java.util.Scanner;
import java.util.Vector;

import control.CIndex;
import control.CLecture;
import control.CTextFindLecture;
import valueObject.VIndex;
import valueObject.VLecture;
import valueObject.VUserInfo;

public class PLectureSelection{
	private CIndex cIndex;
	private CLecture cLecture;
	
	public PLectureSelection() {
		this.cIndex = new CIndex();
		this.cLecture = new CLecture();
	}

	private String findIndex(String message, String fileName, Scanner keyboard) {
		String selectedFileName=null;
		try {
		System.out.println(message+"�ڵ带 �Է��ϼ���");
		Vector<VIndex> vIndexVector = cIndex.getVIndexvector(fileName);
		for(VIndex vIndex: vIndexVector) {
			vIndex.show();
		}
		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode);
		// iCode ==>. selectedIndex
		int selectedIndex = iCode-vIndexVector.get(0).getCode();
		
		selectedFileName = vIndexVector.get(selectedIndex).getFileName();
		
		//iCode ==> selectedIndex �� �ٲٴ� �� �̰� �� ù��° �Է°�-iCode �̷��� �ϸ� 0 ��° 1��° �ǰڳ�.
		// �� ���� Lecture�д� ��.(p������û�� ���γ�) 
		// ����ó��
		// �̸���⿡ ������� ���ϰ� ����. �ݺ�ó���� �ȵȴ�.? �̰� �ݺ�ó�� ==> �̸����/������û
		// ���� �״����� ȭ���� �����. 
		// �ϴ� ������ Search( �ڵ带 selection����, �� ���� Lecture����
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.print("�ٽ� ");
			selectedFileName = findIndex(message, fileName, keyboard);
		}
		return selectedFileName;
		}
	
	private VLecture findLecture(String message, String fileName, Scanner keyboard) {
		VLecture vLecture=null;
		try {
			System.out.println(message+"�ڵ带 �Է��ϼ���");
			Vector<VLecture> vLectureVector = cLecture.getVLectureVector(fileName);
			for(VLecture vLecture1: vLectureVector) {
				vLecture1.show();
			}
			String sCode = keyboard.next();
			
			int iCode = Integer.parseInt(sCode);
			int selectedIndex = iCode-vLectureVector.get(0).getCode();
			
			 vLecture = vLectureVector.get(selectedIndex);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.print("�ٽ� ");
			vLecture = findLecture(message, fileName, keyboard);
		}
		return vLecture;
	}
	
	private VLecture textFindLecture(String message, Scanner keyboard) {
		try {
		System.out.println(message);
		int findCode = keyboard.nextInt();
		CTextFindLecture cTextFindLecture = new CTextFindLecture();
		VLecture vLecture = cTextFindLecture.find(findCode);
		vLecture.show2();
		System.out.println("�� �½��ϱ�?\n��: 0�� �ƴϿ�: 1��");
		int answer = keyboard.nextInt();
		switch (answer) {
		case 0:
			return vLecture;
		case 1:
			return null;
		}
		}
		catch(NullPointerException e) {
			System.out.println("���� �ڵ��Դϴ�.");
		}
		return null;
	}
	
	
	public VLecture selectLecture(Scanner keyboard) {
		
		System.out.println("�׳� ã��: 0�� �˻��ؼ� ã��: 1��");
		int answer = keyboard.nextInt();
		VLecture vLecture=null;
		switch(answer) {
		
		case 0:
		String campusFileName = this.findIndex("ķ�۽�", "root",keyboard);
		String collegeFileName = this.findIndex("����", campusFileName, keyboard);
		String departmentFileName = this.findIndex("�а�", collegeFileName, keyboard);
		vLecture = this.findLecture("����", departmentFileName, keyboard);
		return vLecture;
		case 1:
		vLecture = this.textFindLecture("���� �ڵ带 �Է����ּ���",keyboard);
			return vLecture;
		}
		return vLecture;	
	}



}
