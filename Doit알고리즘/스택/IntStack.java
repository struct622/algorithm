package main;

import java.util.Scanner;

public class IntStack {
	private int max; //������ �뷮
	private int ptr; //���� ������
	private int[] stk; //���� ��ü
	
	//���� �� ����: ������ ��� ����
	public class EmptyIntStackException extends RuntimeException{
		public EmptyIntStackException() {
		}
	}
	
	//���� �� ����: ������ ���� ��
	public class OverflowIntStackException extends RuntimeException{
		public OverflowIntStackException() {
		}
	}
	
	//������
	public IntStack(int capacity) {
		ptr = 0;
		max = capacity;
		
		try {
			stk = new int[max]; //���� ��ü �迭 ����
		}catch (OutOfMemoryError e) { //���� �Ұ�
			max = 0;
		}
	}
	
	//���ÿ� x�� Ǫ��
	public int push(int x) throws OverflowIntStackException{
		if(ptr >= max) { //������ �������� ���� �߻�
			throw new OverflowIntStackException();
		}
		return stk[ptr++] = x;
	}
	
	//������ ���� ���� �ִ� �����͸� ������
	public int pop() throws EmptyIntStackException {
		if(ptr <= 0) { //������ ��������� ���ܹ߻�
			throw new EmptyIntStackException();
		}
		return stk[--ptr];
	}
	
	//������ ���� ���� �ִ� �����͸� ��ȸ
	public int peek() throws EmptyIntStackException {
		if(ptr <= 0) { //������ ��������� ���ܹ߻�
			throw new EmptyIntStackException(); 
		}
		return stk[ptr - 1];
	}
	
	//���ÿ��� x���� ã�� �ε��� ��ȯ
	public int indexOf(int x) {
		for(int i=ptr-1; i>=0; i--) {
			if(stk[i] == x) {
				return i;
			}
		}
		return -1;
	}
	
	//������ ���
	public void clear() {
		ptr = 0;
	}
	
	//������ �뷮�� ��ȯ
	public int capacity() {
		return max;
	}
	
	//���ÿ� �׿��ִ� ������ ���� ��ȯ
	public int size() {
		return ptr;
	}
	
	//������ ����ִ��� �˻�
	public boolean isEmpty() {
		return ptr >= max;
	}
	
	//������ ��� �����͸� �� �Ʒ� �ִ� ������ ���
	public void dump() {
		if(ptr <= 0) {
			System.out.println("������ ��� �ֽ��ϴ�.");
		}else {
			for(int i=0; i<ptr; i++) {
				System.out.print(stk[i] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		IntStack s = new IntStack(64); //64���� �����͸� ���� �� �ִ� ����
		
		while(true) {
			System.out.println("���� ������ ��: " + s.size() + " /" + s.capacity());
			System.out.print("(1)Ǫ�� (2)�� (3)��ũ (4)���� (0)���� : ");
			int menu = sc.nextInt();
			if(menu == 0) break;
			
			int x;
			switch(menu) {
			case 1: //Ǫ��
				System.out.print("������: ");
				x = sc.nextInt();
				try {
					s.push(x);
				}catch (IntStack.OverflowIntStackException e) {
					System.out.println("������ ���� á���ϴ�.");
				}
				break;
				
			case 2: //��
				try {
					x = s.pop();
					System.out.println("���� �����ʹ� " + x + "�Դϴ�.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("������ ����ֽ��ϴ�.");
				}
				break;
				
			case 3: //��ũ
				try {
					x = s.peek();
					System.out.println("��ũ�� �����ʹ� " + x + "�Դϴ�.");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("������ ��� �ֽ��ϴ�.");
				}
				break;
				
			case 4: //����
				s.dump();
				break;
			}
		}
		
		sc.close();
	}
}
