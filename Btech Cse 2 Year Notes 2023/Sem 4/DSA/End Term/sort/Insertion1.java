
import java.util.Arrays;
public class Insertion1
{

	public static void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j=i-1;
			int curr = arr[i];
			while (j>=0 && curr<arr[j]) {
				arr[j+1] = arr[j];
				j--;
				}
			
			arr[j+1] = curr;	
		}
	}
	

	public static void main(String[] args) {

		int[] arr = {3,2,1,0,100};
		System.out.println("UnSorted Array "+Arrays.toString(arr));
		sort(arr);
		System.out.println("Sorted Array "+Arrays.toString(arr));

	}

}
