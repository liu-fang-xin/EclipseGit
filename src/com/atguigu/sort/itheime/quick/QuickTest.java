package com.atguigu.sort.itheime.quick;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickTest {

	public static void main(String[] args) {
		Integer[] arr = new Integer[8000000];
		for (int i = 0; i < 8000000; i++) {
			arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
		}

		System.out.println("��������֮ǰ");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("��������ǰ��ʱ����=" + date1Str);
		
		Quick2.sort(arr);//���ò��������㷨
		
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("����ǰ��ʱ����=" + date2Str);

	}

}
