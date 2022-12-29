package main;

import java.util.Scanner;

public class Main {
	static int seqSearch(int[] a, int n, int key) {
		int i = 0;
		
		a[n] = key; //���ʸ� �߰�
		
		while(true) {
			if(a[i] == key) { //���� �˻����� ���� Ű���� ���ٸ� ����
				break;
			}
			i++;
		}
		
		return i == n ? -1 : i; //���� �ε��� ��ȣ�� �迭�� ������ �ε����� ã���� �ϴ� �� ����. -1 ��ȯ, �ƴ϶�� �˻� ����. �ε��� ��ȣ ��ȯ
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//��� ������ �� ����� �� �Է�
		System.out.print("��ڼ�: ");
		int num = sc.nextInt();
		int[] x = new int[num + 1];
		
		for(int i=0; i<num; i++) {
			System.out.print("x[" + i + "]: ");
			x[i] = sc.nextInt();
		}
		
		//Ű �� �Է�
		System.out.print("�˻��� ��: ");
		int ky = sc.nextInt();
		
		int idx = seqSearch(x, num, ky); //�迭 x���� ���� ky�� ��Ҹ� �˻�
		
		if(idx == -1) {
			System.out.println("�� ���� ��Ұ� �����ϴ�.");
		}else{
			System.out.println(ky + "�� ��ġ: " + idx);
		}
		
		sc.close();
	}
}