package niukewnag.demo;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

public class TestMain {
	/*
	 * 有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，
	 * 求最后一个被删掉的数的原始下标位置。
	 * 以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),
	 * 如此循环直到最后一个数被删除。
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
	//输入一个字符串，求出该字符串包含的字符集合
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
	 * 题目描述
	计算字符串最后一个单词的长度，单词以空格隔开。
	输入描述:
	一行字符串，非空，长度小于5000。

	输出描述:
	整数N，最后一个单词的长度。

	示例1
	输入
	复制
	hello world
	输出
	复制
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
