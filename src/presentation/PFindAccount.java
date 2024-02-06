package presentation;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import control.CFind;
import valueObject.VUserInfo;

public class PFindAccount {

    private int answer;

    public PFindAccount() {

    }

    public void run(Scanner keyboard) {
        CFind cFind = new CFind();
        VUserInfo vUserInfo = new VUserInfo();
        try {
            System.out.println("계정찾기입니다. \n아이디 찾기: 1번 비밀번호 찾기: 2번");
            answer = keyboard.nextInt();
            String message;
            String input = null;
            String output = null;
            switch (answer) {
                case 1:
                    message = "학번";
                    output = "아이디";
                    System.out.println(message + "을 입력해주세요.");
                    input = keyboard.next();
                    vUserInfo.setName(input);
                    break;
                case 2:
                    message = "학번";
                    output = "비밀번호";
                    System.out.println(message + "을 입력해주세요.");
                    input = keyboard.next();
                    vUserInfo.setName(input);
                    System.out.println("아이디를 입력해주세요.");
                    input = keyboard.next();
                    vUserInfo.setName2(input);
                    break;
            }

            vUserInfo = cFind.run(vUserInfo, answer);
            System.out.println(output + "는 " + vUserInfo.getName() + "입니다.\n");
            if(answer==2) {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\n\n\n\n");
                }
            }, 2000); // 3초 후에 실행
            }
        } catch (NullPointerException e) {
            System.out.println("");
        }
    }
}