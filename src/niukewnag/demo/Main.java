package niukewnag.demo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=0;
		boolean flag = true;
		while(flag) {
			
			n = sc.nextInt();
			switch (n) {
			case 0:
				System.out.println("end");
				flag=false;
				break;

			default:
				int count=0;
				for(int i = 2;i <= n/2;i++) {
					if (checkZhiShu(i)) {
						if (checkZhiShu(n-i)) {
							count++;
						}
					}
					
				}
				System.out.println(count);
			}
		}

	}
	public static boolean checkZhiShu(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i==0) {
				return false;
			}
		}
		return true;
	}

}
