package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import valueObject.VStudent;
import valueObject.VUserInfo;

public class MFind {

	public VUserInfo run(VUserInfo vUserInfo, int answer, String message) {
		try {
		File file = new File(message);
		Scanner fileSc;
		
			fileSc = new Scanner(file);
			while(fileSc.hasNext()) {
				String line = fileSc.nextLine();
				String[] part =line.split(" ");
				if(answer==1) {
					if(vUserInfo.getName().equals(part[3])){
						vUserInfo.setName(part[0]);
						return vUserInfo;
					}
					
				}
				else if(answer==2) {
					if(vUserInfo.getName().equals(part[3])) {
						if(vUserInfo.getName2().equals(part[0])) {
						vUserInfo.setName(part[1]);
						return vUserInfo;
						}
					}
				}
			}
			switch(answer){
			case 1:
				System.out.println("해당 학번은 존재하지않습니다.");
				break;
			case 2:	
				System.out.println("해당 학번 혹은 아이디가 존재하지않습니다.");
				break;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("해당 고객의 정보가 존재하지 않습니다.");
		}
		
		
		return null;
}
	public VStudent check(VStudent vStudent, String message) {
	
		
		try {
		File file = new File(message);
		Scanner fileSc;
		
			fileSc = new Scanner(file);
			
			while(fileSc.hasNext()) {
				String line = fileSc.nextLine();
				String[] part =line.split(" ");
				
				int id = Integer.parseInt(part[0]);
				
				if(vStudent.getStudentId()==id) {
					int CreditLimit = Integer.parseInt(part[1]);
					vStudent.setCreditLimit(CreditLimit);
					vStudent.setResult(1);
					return vStudent;
				}
				
			}
			vStudent.setResult(0); 
		return vStudent;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ArrayIndexOutOfBoundsException e) {
		
		}
		
		
		return vStudent;
}
	
	
}
