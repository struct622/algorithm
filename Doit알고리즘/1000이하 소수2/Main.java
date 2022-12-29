package main;

public class Main {
    public static void main(String[] args) {
    	int counter = 0; //������ ���� Ƚ��
    	int ptr = 0; //ã�� �Ҽ��� ����
    	int[] prime = new int[500]; //�Ҽ� ���� �迭
    	
    	prime[ptr++] = 2; //�Ҽ� 2�� prime �迭�� ����
    	
    	for(int n=3; n<=1000; n+=2) { //¦�� �� �Ҽ��� 2���̹Ƿ� Ȧ���� �Ǵ�
    		int i;
    		for(i=1; i<ptr; i++) { //���� ã�� �Ҽ� ������ŭ �ݺ�
    			counter++;
    			if(n % prime[i] == 0) { //�̹� ã�� �Ҽ��� ������ �������� �Ҽ� �ƴϹǷ� �ݺ� ����
    				break;
    			}
    		}
    		if(ptr == i) { //i�� ptr���� �����ϸ�  ��� �Ҽ��� ������ �������� �ʾ����Ƿ� prime �迭�� ����
    			prime[ptr++] = n;
    		}
    	}
    	
    	for(int i=0; i<ptr; i++) { //prime �迭�� ����ִ� ��� �Ҽ� ���
    		System.out.println(prime[i]);
    	}
    	
    	System.out.println("�������� ������ Ƚ��: " + counter);
    }
}