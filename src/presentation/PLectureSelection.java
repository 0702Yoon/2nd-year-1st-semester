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
		System.out.println(message+"코드를 입력하세요");
		Vector<VIndex> vIndexVector = cIndex.getVIndexvector(fileName);
		for(VIndex vIndex: vIndexVector) {
			vIndex.show();
		}
		String sCode = keyboard.next();
		int iCode = Integer.parseInt(sCode);
		// iCode ==>. selectedIndex
		int selectedIndex = iCode-vIndexVector.get(0).getCode();
		
		selectedFileName = vIndexVector.get(selectedIndex).getFileName();
		
		//iCode ==> selectedIndex 로 바꾸는 데 이거 맨 첫번째 입력값-iCode 이렇게 하면 0 번째 1번째 되겠네.
		// 그 다음 Lecture읽는 법.(p수강신청은 냅두네) 
		// 예외처리
		// 미리담기에 집어놓지 못하고 있음. 반복처리가 안된다.? 이건 반복처리 ==> 미리담기/수강신청
		// 이제 그다음에 화면을 만든대. 
		// 일단 과제는 Search( 코드를 selection으로, 그 다음 Lecture까지
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.print("다시 ");
			selectedFileName = findIndex(message, fileName, keyboard);
		}
		return selectedFileName;
		}
	
	private VLecture findLecture(String message, String fileName, Scanner keyboard) {
		VLecture vLecture=null;
		try {
			System.out.println(message+"코드를 입력하세요");
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
			System.out.print("다시 ");
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
		System.out.println("이 맞습니까?\n예: 0번 아니요: 1번");
		int answer = keyboard.nextInt();
		switch (answer) {
		case 0:
			return vLecture;
		case 1:
			return null;
		}
		}
		catch(NullPointerException e) {
			System.out.println("없는 코드입니다.");
		}
		return null;
	}
	
	
	public VLecture selectLecture(Scanner keyboard) {
		
		System.out.println("그냥 찾기: 0번 검색해서 찾기: 1번");
		int answer = keyboard.nextInt();
		VLecture vLecture=null;
		switch(answer) {
		
		case 0:
		String campusFileName = this.findIndex("캠퍼스", "root",keyboard);
		String collegeFileName = this.findIndex("대학", campusFileName, keyboard);
		String departmentFileName = this.findIndex("학과", collegeFileName, keyboard);
		vLecture = this.findLecture("강좌", departmentFileName, keyboard);
		return vLecture;
		case 1:
		vLecture = this.textFindLecture("강좌 코드를 입력해주세요",keyboard);
			return vLecture;
		}
		return vLecture;	
	}



}
