package itheima.quick;

public class Quick2 {
	/*
    �Ƚ�vԪ���Ƿ�С��wԪ��
 */
  private static boolean less(Comparable v, Comparable w) {
      return v.compareTo(w) < 0;
  }



  /*
 ����Ԫ��i��j����λ��
  */
  private static void exch(Comparable[] a, int i, int j) {
      Comparable t = a[i];
      a[i] = a[j];
      a[j] = t;
  }

  //�������ڵ�Ԫ�ؽ�������
  public static void sort(Comparable[] a) {
      int lo = 0;
      int hi = a.length-1;
      sort(a,lo,hi);
  }

  //������a�д�����lo������hi֮���Ԫ�ؽ�������
  private static void sort(Comparable[] a, int lo, int hi) {
      //��ȫ��У��
      if (hi<=lo){
          return;
      }

      //��Ҫ��������lo������hi��������Ԫ�ؽ��з��飨������������飩��
      int partition = partition(a, lo, hi);//���ص��Ƿ���ķֽ�ֵ���ڵ��������ֽ�ֵλ�ñ任�������

      //������������
      sort(a,lo,partition-1);

      //������������
      sort(a,partition+1,hi);
  }

  //������a�У������� lo������ hi֮���Ԫ�ؽ��з��飬�����ط�����޶�Ӧ������
  public static int partition(Comparable[] a, int lo, int hi) {
     //ȷ���ֽ�ֵ
      Comparable key = a[lo];
      //��������ָ�룬�ֱ�ָ����з�Ԫ�ص���С���������������������һ��λ��
      int left=lo;
      int right=hi+1;

      //�з�
      while(true){
          //�ȴ�������ɨ�裬�ƶ�rightָ�룬�ҵ�һ���ȷֽ�ֵС��Ԫ�أ�ֹͣ
          while(less(key,a[--right])){
              if (right==lo){
                  break;
              }
          }

          //�ٴ�������ɨ�裬�ƶ�leftָ�룬�ҵ�һ���ȷֽ�ֵ���Ԫ�أ�ֹͣ
          while(less(a[++left],key)){
              if (left==hi){
                  break;
              }
          }
          //�ж� left>=right,����ǣ���֤��Ԫ��ɨ����ϣ�����ѭ����������ǣ��򽻻�Ԫ�ؼ���
          if (left>=right){
              break;
          }else{
              exch(a,left,right);
          }
      }

      //�����ֽ�ֵ
      exch(a,lo,right);

     return right;
  }

}