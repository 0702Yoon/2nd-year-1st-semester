package control;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import valueObject.VLecture;

public class Basket {
	
	private Vector<VLecture> vLectureVector;
	
	
    public void run(String message,Vector<VLecture> vLectureVector) {
    	
    	this.vLectureVector = vLectureVector;	
    	
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(message))) {
            for (VLecture vLecture : this.vLectureVector) {
                // 데이터를 txt 파일에 쓰기
                writer.write(vLecture.getCode() + " " + vLecture.getName() + " " + vLecture.getLecturer()+" "+vLecture.getCredit()+" "+vLecture.getDate());
                writer.newLine(); // 개행 추가
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}