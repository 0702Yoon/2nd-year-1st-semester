package presentation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import control.CMakebasket;
import control.CStudentCheck;
import valueObject.VStudent;

public class PGaip {
	
	private CMakebasket cMakeBasket;
	private CStudentCheck cStudentCheck;
	private VStudent vStudent;
	
	public PGaip() {
		cMakeBasket = new CMakebasket();
		cStudentCheck = new CStudentCheck();
		vStudent = new VStudent();
	}
	
	public void run(Scanner keyboard) {
		System.out.println("ȸ�������Դϴ�.");
		
		System.out.println("�й��� �Է��ϼ���.");
		vStudent.setStudentId(keyboard.nextInt());
		
		vStudent = cStudentCheck.check(vStudent);
		
		if(vStudent.getResult()==1) {
		System.out.println("�̸��� �Է��ϼ���");
		String name = keyboard.next();
		System.out.println("����� ���̵� �Է��ϼ���.");
		String id = keyboard.next();
		System.out.println("����� ��й�ȣ�� �Է��ϼ���.");
		String pw = keyboard.next();
		
		try {
		File file = new File("account/account");
		File file2 = new File("account/studentId");
		BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true));
		BufferedWriter fileWriter2 = new BufferedWriter(new FileWriter(file2, true));
		
			Scanner fileScanner = new Scanner(file, "UTF-8");
			while(fileScanner.hasNext()) {
				String line = fileScanner.nextLine();
				String[] part = line.split(" ");
				int studentID = Integer.parseInt(part[3]);
				
				if(studentID==vStudent.getStudentId()) {
					System.out.println("�̹� �й��� ���� ���̵� �����մϴ�.\n");
					return;
				}
				
				else if(part[0].equals(id)) {
					System.out.println("�ߺ��� ���̵��Դϴ�.\n");
					fileScanner.close();
					return;
				}
			}
			fileScanner.close();
			fileWriter.write(id+" "+pw+" "+ name+ " " + vStudent.getStudentId()+" "+vStudent.getCreditLimit());
			fileWriter.newLine();
			fileWriter.close();
			fileWriter2.write(vStudent.getStudentId());
			
			System.out.println(name+"�� ȸ�������� �Ϸ�Ǿ����ϴ�.\n");
			
			cMakeBasket.run(name);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else {
			System.out.println("�ش� �й��� �������� �ʽ��ϴ�.\n");
		}
		
	}
}
