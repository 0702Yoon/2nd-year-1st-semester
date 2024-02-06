package valueObject;

import java.util.Scanner;

public class VLecture {
	
	private int code;
	private String name;
	private String lecturer; //교수가 아닐 수도 있다는 걸 알자.
	private int credit;
	private String time;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLecturer() {
		return lecturer;
	}
	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	
}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getDate() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void load(Scanner file) {
		this.setCode(file.nextInt());
		this.setName(file.next()) ;
		this.setLecturer(file.next());
		this.setCredit(file.nextInt());
		this.setTime(file.next());
	}
	public void lineLoad(String[] line) {
		this.setCode(Integer.parseInt(line[0]));
		this.setName(line[1]) ;
		this.setLecturer(line[2]);
		this.setCredit(Integer.parseInt(line[3]));
		this.setTime(line[4]);
	}
	
	public void show() {
		System.out.println(this.getCode()+" "+this.getName()+" "+this.getLecturer()+" "+this.getCredit()+" "+this.getDate());
	}	
	public void show2() {
		System.out.print("\""+this.getCode()+" "+this.getName()+" "+this.getLecturer()+" "+this.getCredit()+" "+this.getDate()+"\"");
	}	
}
