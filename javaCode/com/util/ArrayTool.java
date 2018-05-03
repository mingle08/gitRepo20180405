package com.util;

public class ArrayTool {

	/**
	 * ѡ������
	 */
	public static void selectSort(int[] arr) {
		for(int x = 0; x < arr.length - 1; x++) {
			for(int y = x + 1; y < arr.length; y++) {
				if(arr[x] > arr[y]) {
					swap(arr,x,y);
				}
			}
		}
	}
	
	/**
	 * ð�ݷ�
	 */
	public static void bubbleSort(int[] arr) {
		for(int x = 0; x < arr.length - 1; x++) {
			for(int y = 0; y < arr.length - 1 - x; y++) {
				if(arr[y] > arr[y+1]) {
					swap(arr, y, y+1);
				}
			}
		}
	}
	
	
	/**
	 * ���������еĶ���Ԫ��
	 * @param arr
	 * @param a
	 * @param b
	 */
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}
