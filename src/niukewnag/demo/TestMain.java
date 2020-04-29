package niukewnag.demo;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

public class TestMain {
	/*
	 * ��һ������a[N]˳����0~N-1��Ҫ��ÿ��������ɾ��һ��������ĩβʱѭ������ͷ�������У�
	 * �����һ����ɾ��������ԭʼ�±�λ�á�
	 * ��8����(N=7)Ϊ��:��0��1��2��3��4��5��6��7����0->1->2(ɾ��)->3->4->5(ɾ��)->6->7->0(ɾ��),
	 * ���ѭ��ֱ�����һ������ɾ����
	 */
	@Test
	public void demo1() {
		Scanner sc=new Scanner(System.in);
		
		while(sc.hasNext()) {
			int n=sc.nextInt();
			if (n>1000) {
				n=999;
			}
			
			List<Integer> list=new ArrayList<>();
			for(int i=0;i<n;i++) {
				list.add(i);
			}
			int i=0;
			while(list.size()>1) {
				i=(i+2) % list.size();
				list.remove(i);
			}
			System.out.println(list.get(0));
		}
		
	}
	//����һ���ַ�����������ַ����������ַ�����
	@Test
	public void demo2() {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()) {
			char[] cs=sc.next().toCharArray();
			
			Set<Character> set=new HashSet<>();
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<cs.length;i++) {
				if (set.add(cs[i])) {
					sb.append(cs[i]);
				}
			}
			
			System.out.println(sb.toString());
		}
		
	}
	/*
	 * ��Ŀ����
	�����ַ������һ�����ʵĳ��ȣ������Կո������
	��������:
	һ���ַ������ǿգ�����С��5000��

	�������:
	����N�����һ�����ʵĳ��ȡ�

	ʾ��1
	����
	����
	hello world
	���
	����
	5
	 */
	public static boolean checkZhiShu(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i==0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		int n = 7;
		
		System.out.println(checkZhiShu(n));
	}
	
	@Test 
	public void demo4(){
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()) {
			String s = sc.next();
			System.out.println(s);
			String s1=sc.next();
			System.out.println(s1);
		}
	}
}
