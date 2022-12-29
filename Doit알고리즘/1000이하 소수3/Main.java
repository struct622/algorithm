package main;

public class Main {
    public static void main(String[] args) {
    	int counter = 0; //������ ���� Ƚ��
    	int ptr = 0; //ã�� �Ҽ��� ����
    	int[] prime = new int[500]; //�Ҽ� ���� �迭
    	
    	prime[ptr++] = 2; //�Ҽ� 2�� prime �迭�� ����
    	prime[ptr++] = 3; //�Ҽ� 3�� prime �迭�� ����
    	
    	for(int n=5; n<=1000; n+=2) {
    		boolean flag = false; //������ ���������� �Ǻ��ϴ� ����
    		for(int i=1; prime[i] * prime[i] <= n; i++) {
    			counter += 2;
    			if(n % prime[i] == 0) { //������� ã�� �Ҽ��� ������ �������� �Ҽ� �ƴ�
    				flag = true;
    				break;
    			}
    		}
    		
    		if(!flag) { //���������� ������ �������� ���� ��� �Ҽ�
    			prime[ptr++] = n; //prime �迭�� �Ҽ��� ����
    			counter++;
    		}
    	}
    	
    	for(int i=0; i<ptr; i++) {
    		System.out.println(prime[i]);
    	}
    	
    	System.out.println("������ ������ ���� Ƚ��: " + counter);
    }
}