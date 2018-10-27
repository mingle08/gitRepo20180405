package com.imooc.leetCode.question005;

/**
 * ��̬�滮���� 
��������dp[ i ][ j ]��ֵΪtrue����ʾ�ַ���s���±�� i �� j ���ַ���ɵ��Ӵ��ǻ��Ĵ�����ô�����Ƴ��� 
����dp[ i ][ j ] = dp[ i + 1][ j - 1] && s[ i ] == s[ j ]�� 
��������һ��������������Ҫ����i+1, j -1�������п��� i + 1 = j -1, i +1 = (j - 1) -1�������Ҫ�����׼��������������ϵĹ�ʽ�� 
����a. i + 1 = j -1�������ĳ���Ϊ1ʱ��dp[ i ][ i ] = true; 
����b. i +1 = (j - 1) -1�������ĳ���Ϊ2ʱ��dp[ i ][ i + 1] = ��s[ i ] == s[ i + 1]���� 
�����������Ϸ����Ϳ���д�������ˡ���Ҫע����Ƕ�̬�滮��Ҫ�����O(n^2)�Ŀռ䡣
 * @author Administrator
 *
 */
public class LongestPalidromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static String longestPalindrome(String str) {
		if(str == null || str.length() < 2) {
			return str;
		}
		
		int maxLen = 0;
		String longest = null;
		
		int len = str.length();
		boolean[][] table = new boolean[len][len];
		// �����ַ����ǻ����ַ�
		for(int i=0; i < len; i++) {
			table[i][i] = true;longest = str.substring(i, i + 1);
            maxLen = 1;
        }

        // �ж������ַ��Ƿ��ǻ���
        for (int i = 0; i < len - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                longest = str.substring(i, i + 2);
                maxLen = 2;
            }
        }


        // �󳤶ȴ���2���Ӵ��Ƿ��ǻ��Ĵ�
        for (int leng = 3; leng <= len; len++) {
            for (int i = 0, j; (j = i + len - 1) <= len - 1; i++) {
                if (str.charAt(i) == str.charAt(j)) {
                    table[i][j] = table[i + 1][j - 1];
                    if (table[i][j] && maxLen < len) {
                        longest = str.substring(i, j + 1);
                        maxLen = len;
                    }
                } else {
                    table[i][j] = false;
                }
            }
        }
        return longest;
	}
	
	

}
