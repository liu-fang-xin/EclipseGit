package itheima.quick;

public class Quick {
	
	//比较v是否小于w
	private static boolean less(Comparable v,Comparable w) {
		return v.compareTo(w)<0;
	}
	
	//数组元素交换位置
	private static void swap(Comparable[] a ,int i, int j) {
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	
	
	
	
	//对 数组内的元素进行排序
	public static void sort(Comparable[] a) {
		int low=0;
		int high=a.length-1;
		sort(a, low, high);
	}
	
	//对数组从索引l 到索引h进行排序
	public static void sort(Comparable[] a,int low, int high) {
		//安全性校验
		if(high<=low) {
			return;
		}
		//对数组a进行分组（左子组，右子组）
		int partition=partition(a, low, high);
		//对左子组进行排序
		sort(a,low,partition-1);
		//对右子组进行排序
		sort(a,partition+1,high);
	}
	//对数组a从索引low到high之间的元素进行分组，并返回分组的界限
	public static int partition(Comparable[] a,int low,int high) {
		//指定第一个数为分界值
		Comparable key = a[low];
		//定义两个指针，分别指向数组的最小索引和最大索引的后一位
		int left = low;
		int right = high+1;
		
		//切分
		while(true) {
			//从右往左找比key小的数
			while(less(key, a[--right])) {
				if(right==low) {
					break;
				}
			}
			//从左往右找比key大的数
			while(!less(key, a[++left])) {
				if(left==high) {
					break;
				}
			}
			//如果left大于right，说明已经全部扫描完毕，停止循环
			if(left>=right) {
				break;
			}else {
				swap(a, left, right);
			}
			
		}//循环结束
		//最后把分界值key与索引right上（或者left，因为两者已经相等）的值交换
		swap(a, low, right);
		return right;
	}
}
