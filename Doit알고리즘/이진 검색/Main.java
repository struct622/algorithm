package main;

import java.util.Scanner;

public class Main {
	static int binSearch(int[] a, int n, int key) { //a: �˻��� �迭, n:�迭�� ����, key: ã���� �ϴ� ������
		int pl = 0; //�˻� ������ ù �ε���
		int pr = n - 1; //�˻� ������ ������ �ε���
		
		do {
			int pc = (pl + pr) / 2; //�迭 �߾��� �ε���
			
			if(a[pc] == key) { //�˻� ����
				return pc;
			}else if(a[pc] < key) { //ã���� �ϴ� ���� �߾Ӱ����� Ŭ ��� �˻��� ������ �߾Ӻ��� ū ����� ����
				pl = pc + 1;
			}else { //ã���� �ϴ� ���� �߾Ӱ����� ���� ��� �˻��� ������ �߾Ӻ��� ���� ����� ����
				pr = pc - 1;
			}
		}while(pl <= pr);
		
		return -1; //�˻� ����
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("��ڼ�: ");
		int num = sc.nextInt(); //�迭 ���� �Է�
		int[] x = new int[num]; //�迭 ����
		
		System.out.println("������������ �Է��ϼ���.");
		
		System.out.print("x[0]: "); //ù ��� �Է�
		x[0] = sc.nextInt();
		
		for(int i=1; i<num; i++) {
			do {
				System.out.print("x[" + i + "]: ");
				x[i] = sc.nextInt();
			}while(x[i] < x[i-1]);
		}
		
		System.out.print("�˻��� ��: "); //Ű ���� �Է�
		int ky = sc.nextInt();
		
		int idx = binSearch(x, num, ky); //�迭 x���� Ű ���� ky�� ��� �˻�
		
		if(idx == 1) {
			System.out.println("�� ���� ��Ұ� �����ϴ�.");
		}else {
			System.out.println(ky + "�� ��ġ: " + idx);
		}
		
		sc.close();
	}
}