package control;

import java.util.Scanner;
import java.util.Vector;

import valueObject.VLecture;

public class CModify {

	public Vector<VLecture> run(int answer,Vector<VLecture> vLectureVector,Scanner keyboard) {
		int first;
		int second;
		VLecture target;
		switch(answer) {
		case 0:
		System.out.println("�� ���� �� ������ �ű�ðڽ��ϱ�?");
		first = keyboard.nextInt()-1;
		second = keyboard.nextInt()-1;
		target = vLectureVector.remove(first);
		vLectureVector.add(second,target);
		return vLectureVector;
		case 1:
		System.out.println("�� ���� ����� �ٲٽðڽ��ϱ�?");
		first = keyboard.nextInt()-1;
		second = keyboard.nextInt()-1;
		target = vLectureVector.get(first);
		vLectureVector.set(first, vLectureVector.get(second));
		vLectureVector.set(second, target);
		return vLectureVector;
		case 2:
		System.out.println("�� ���� ����ðڽ��ϱ�?");
		first = keyboard.nextInt()-1;
		vLectureVector.remove(first);
	}
		return vLectureVector;
	}
	
	
}
