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
            System.out.println("����ã���Դϴ�. \n���̵� ã��: 1�� ��й�ȣ ã��: 2��");
            answer = keyboard.nextInt();
            String message;
            String input = null;
            String output = null;
            switch (answer) {
                case 1:
                    message = "�й�";
                    output = "���̵�";
                    System.out.println(message + "�� �Է����ּ���.");
                    input = keyboard.next();
                    vUserInfo.setName(input);
                    break;
                case 2:
                    message = "�й�";
                    output = "��й�ȣ";
                    System.out.println(message + "�� �Է����ּ���.");
                    input = keyboard.next();
                    vUserInfo.setName(input);
                    System.out.println("���̵� �Է����ּ���.");
                    input = keyboard.next();
                    vUserInfo.setName2(input);
                    break;
            }

            vUserInfo = cFind.run(vUserInfo, answer);
            System.out.println(output + "�� " + vUserInfo.getName() + "�Դϴ�.\n");
            if(answer==2) {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\n\n\n\n");
                }
            }, 2000); // 3�� �Ŀ� ����
            }
        } catch (NullPointerException e) {
            System.out.println("");
        }
    }
}