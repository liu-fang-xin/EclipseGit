package com.atguigu.sort.itheime.quick;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickTest {

	public static void main(String[] args) {
		Integer[] arr = new Integer[8000000];
		for (int i = 0; i < 8000000; i++) {
			arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
		}

		System.out.println("快速排序之前");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("插入排序前的时间是=" + date1Str);
		
		Quick2.sort(arr);//调用插入排序算法
		
		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("排序前的时间是=" + date2Str);

	}

}
