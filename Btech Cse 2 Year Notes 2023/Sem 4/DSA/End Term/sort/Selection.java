package com.sort;

import java.util.Arrays;

public class Selection {

	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			int min = i;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[min]>arr[j]) {
					min = j;
				}
				
			}
			
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
	
	public static void main(String[] args) {
int[] ar = {1,4,2,6,4,5,3,2,4,5};
sort(ar);
System.out.println(Arrays.toString(ar));
	}

}
