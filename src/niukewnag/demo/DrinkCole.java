package niukewnag.demo;

import java.util.Scanner;

public class DrinkCole {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int n = sc.nextInt();
			int a=drinkNumber(n);
			System.out.println(a);
		}

	}
	public static int drinkNumber(int n) {
		int i = n % 3;
		int j = n / 3;
		int m = i + j;
		if (m<2) {
			return j;
		}
		if (m==2) {
			
			return j+1;
		}else {
			return j+drinkNumber(m);
		}
			
		
			
	}
}
