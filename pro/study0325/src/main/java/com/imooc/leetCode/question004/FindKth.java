package com.imooc.leetCode.question004;

/**
 * ���ȼ�������A��B��Ԫ�ظ���������k/2�����ǱȽ�A[k/2-1]��B[k/2-1]����Ԫ�أ�������Ԫ�طֱ��ʾA�ĵ�k/2С��Ԫ�غ�B�ĵ�k/2С��Ԫ�ء�������Ԫ�رȽϹ������������>��<��=�����A[k/2-1]<B[k/2-1]�����ʾA[0]��A[k/2-1]��Ԫ�ض���A��B�ϲ�֮���ǰkС��Ԫ���С����仰˵��A[k/2-1]�����ܴ���������ϲ�֮��ĵ�kСֵ���������ǿ��Խ���������

	��A[k/2-1]>B[k/2-1]ʱ�������ƵĽ��ۡ�
	
	��A[k/2-1]=B[k/2-1]ʱ�������Ѿ��ҵ��˵�kС������Ҳ�������ȵ�Ԫ��.
	
	���A����BΪ�գ���ֱ�ӷ���B[k-1]����A[k-1]��
	���kΪ1������ֻ��Ҫ����A[0]��B[0]�еĽ�Сֵ��
	���A[k/2-1]=B[k/2-1]����������һ����
 * @author Administrator
 *
 */
public class FindKth {

	public static void main(String[] args) {
		int[] x = {2,8};
		int[] y = {4};
		double mid = findMedianSortedArrays(x, y);
		System.out.println(mid);

	}

	public static double findKth(int a[], int begina, int m, int b[], int beginb, int n, int k) {
		if(m > n) // ȷ��������ں���
			return findKth(b, beginb, n, a, begina, m, k);
		
		if(m == 0)
			return b[beginb + k - 1];
		
		if(k == 1)
			return Math.min(a[begina], b[beginb]);
		
		int ma = Math.min(k/2, m), mb = k - ma;  // ��k�ֳ�������
		/**
		 * 1. ��a����ǰ��ma��Ԫ��ȥ������kС��Ԫ�ز�������
		 * 2. ��b����ǰ��mb��Ԫ��ȥ������kС��Ԫ�ز�������
		 * 3. ���ʱ������
		 */
		if(a[begina + ma - 1] < b[beginb + mb - 1])  // 1
			return findKth(a, begina + ma, m - ma, b, beginb, n, k - ma);
		else if(a[begina + ma - 1] > b[beginb + mb - 1])  // 2
			return findKth(a, begina, m, b, beginb + mb, n - mb, k - mb);
		else  // 3
			return a[begina + ma -1];
			
	}
	
	public static double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		int totalLength = m + n;
		if(totalLength % 2 == 1) {
			return findKth(A, 0, m, B, 0, n, totalLength/2+1);
		}else {
			return (findKth(A, 0, m, B, 0, n, totalLength/2) + findKth(A, 0, m, B, 0, n, totalLength/2 + 1)) / 2;
		}
	}
}
