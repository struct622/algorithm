package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	int no; //��ȯ �� ����
    	int cd; //���
    	int dno; //��ȯ �� �ڸ���
    	int retry; //�� ���� ����
    	char[] cno = new char[32]; //��ȯ �� �� �ڸ��� ���ڸ� �־�δ� �迭
    	
    	System.out.println("10������ ��� ��ȯ�մϴ�.");
    	do {
    		
    		do {
    			//��ȯ �� ���� �Է�
    			System.out.print("��ȯ�ϴ� ���� �ƴ� ����: ");
    			no = sc.nextInt();
    		}while(no < 0); //�Էµ� ������ ������ �ٽ� �Է�
    		
    		do {
    			//�� ������ ��ȯ���� �Է�
    			System.out.print("� ������ ��ȯ�ұ��? (2~36): ");
    			cd = sc.nextInt();
    		}while(cd < 2 || cd > 36); //�Է� �� ������ 2~36�� �ƴ� ��� �ٽ� �Է�
    		
    		dno = cardConvR(no, cd, cno); //no�� cd������ ��ȯ�Ͽ� cno �迭�� �������� ����, dno���� ��ȯ�� �ڸ��� ����
    		
    		System.out.print(cd + "�����δ� ");
    		for(int i=dno-1; i>= 0; i--) {
    			//�迭�� ���� �� ���� �ڿ������� ����Ͽ� ������ ���
    			System.out.print(cno[i]);
    		}
    		System.out.println("�Դϴ�.");
    		
    		System.out.println("�� �� �� �ұ��(1.��/0.�ƴϿ�): ");
    		retry = sc.nextInt();
    	}while(retry == 1); //retry�� 1�̸� �ٽ� ����
    	
    	
    	sc.close();
    }

	private static int cardConvR(int x, int r, char[] d) {
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		do {
			d[digits++] = dchar.charAt(x % r); //x�� r�� ���� �������� d�� �迭�� ����
			x /= r; //x�� r�� ���� ���� x�� �Ͽ� �ݺ�
		}while(x != 0); //x��  0�� �ƴϸ� ���
		
		return digits; //��ȯ�� ���� �ڸ��� ��ȯ
	}
}