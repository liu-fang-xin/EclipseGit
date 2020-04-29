package com.atguigu.sort.itheime.quick;

public class Quick {
	
	//�Ƚ�v�Ƿ�С��w
	private static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w)<0;
	}
	
	//����Ԫ�ؽ���λ��
	private static void swap(Comparable[] a ,int i, int j) {
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	
	
	
	
	//�� �����ڵ�Ԫ�ؽ�������
	public static void sort(Comparable[] a) {
		int low=0;
		int high=a.length-1;
		sort(a, low, high);
	}
	
	//�����������l ������h��������
	public static void sort(Comparable[] a,int low, int high) {
		//��ȫ��У��
		if(high<=low) {
			return;
		}
		//������a���з��飨�����飬�����飩
		int partition=partition(a, low, high);
		//���������������
		sort(a,low,partition-1);
		//���������������
		sort(a,partition+1,high);
	}
	//������a������low��high֮���Ԫ�ؽ��з��飬�����ط���Ľ���
	public static int partition(Comparable[] a,int low,int high) {
		//ָ����һ����Ϊ�ֽ�ֵ
		Comparable key = a[low];
		//��������ָ�룬�ֱ�ָ���������С��������������ĺ�һλ
		int left = low;
		int right = high+1;
		
		//�з�
		while(true) {
			//���������ұ�keyС����
			while(less(key, a[--right])) {
				if(right==low) {
					break;
				}
			}
			//���������ұ�key�����
			while(!less(key, a[++left])) {
				if(left==high) {
					break;
				}
			}
			//���left����right��˵���Ѿ�ȫ��ɨ����ϣ�ֹͣѭ��
			if(left>=right) {
				break;
			}else {
				swap(a, left, right);
			}
			
		}//ѭ������
		//���ѷֽ�ֵkey������right�ϣ�����left����Ϊ�����Ѿ���ȣ���ֵ����
		swap(a, low, right);
		return right;
	}
}
