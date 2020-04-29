package itheima.quick;

public class Merge {
    //�鲢����Ҫ�ĸ�������
    private static Comparable[] assist;

    /*
       �Ƚ�vԪ���Ƿ�С��wԪ��
    */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w)<0;
    }

    /*
    ����Ԫ��i��j����λ��
     */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    /*
           ������a�е�Ԫ�ؽ�������
        */
    public static void sort(Comparable[] a) {
        //1.��ʼ����������assist��
        assist = new Comparable[a.length];
        //2.����һ��lo��������hi�������ֱ��¼��������С������������������
        int lo=0;
        int hi=a.length-1;
        //3.����sort���ط����������a�У�������lo������hi��Ԫ�ص�����
        sort(a,lo,hi);
    }

    /*
    ������a�д�lo��hi��Ԫ�ؽ�������
     */
    private static void sort(Comparable[] a, int lo, int hi) {
        //����ȫ��У�飻
        if (hi<=lo){
            return;
        }

        //��lo��hi֮������ݽ��з�Ϊ������
        int mid = lo+(hi-lo)/2;//   5,9  mid=7

        //�ֱ��ÿһ�����ݽ�������
        sort(a,lo,mid);
        sort(a,mid+1,hi);

        //�ٰ��������е����ݽ��й鲢
        merge(a,lo,mid,hi);
    }

    /*
    �������У���lo��midΪһ�飬��mid+1��hiΪһ�飬�����������ݽ��й鲢
     */
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        //��������ָ��
        int i=lo;
        int p1=lo;
        int p2=mid+1;

        //�������ƶ�p1ָ���p2ָ�룬�Ƚ϶�Ӧ��������ֵ���ҳ�С���Ǹ����ŵ���������Ķ�Ӧ������
        while(p1<=mid && p2<=hi){
            //�Ƚ϶�Ӧ��������ֵ
            if (less(a[p1],a[p2])){
                assist[i++] = a[p1++];
            }else{
                assist[i++]=a[p2++];
            }
        }

        //���������p1��ָ��û�����꣬��ô˳���ƶ�p1ָ�룬�Ѷ�Ӧ��Ԫ�طŵ���������Ķ�Ӧ������
        while(p1<=mid){
            assist[i++]=a[p1++];
        }
        //���������p2��ָ��û�����꣬��ô˳���ƶ�p2ָ�룬�Ѷ�Ӧ��Ԫ�طŵ���������Ķ�Ӧ������
        while(p2<=hi){
            assist[i++]=a[p2++];
        }
        //�Ѹ��������е�Ԫ�ؿ�����ԭ������
        for(int index=lo;index<=hi;index++){
            a[index]=assist[index];
        }

    }

}