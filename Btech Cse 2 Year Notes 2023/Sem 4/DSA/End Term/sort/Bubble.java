package com.sort;
import java.util.Arrays;
import java.util.Random;
public class Bubble {

	public static boolean isSorted(int[] arr) {
		boolean f = true;
		for (int i = 0; i < arr.length-1; i++) {
			if (arr[i]>arr[i+1]) {
				f = false;
				break;
			}
			
		}
		
		return f;
	}
	
	
	public static void main(String[] args) {

		Random r = new Random();
		int rand[] = new int[20];
		
		for (int i = 0; i < rand.length; i++) {
			rand[i] = r.nextInt(100);
			
		}
		
		System.out.println(Arrays.toString(rand));
		System.out.println(isSorted(rand));
		
		boolean flag = true;
		while (flag) {
			flag = false;
			for (int i = 0; i < rand.length - 1; i++) {
				if (rand[i] > rand[i + 1]) {
					int temp = rand[i];
					rand[i] = rand[i + 1];
					rand[i + 1] = temp;
					flag = true;
				}

			}
		}
		
		System.out.println(Arrays.toString(rand));
		System.out.println(isSorted(rand));

	}

}
