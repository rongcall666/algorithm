package 杭电.第一页;

import java.util.Scanner;
/**
 * 找规律
 * @author rong
 *
 */
public class Test1005 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (true) {
			int A = cin.nextInt();
			int B = cin.nextInt();
			int n = cin.nextInt();
			if (A == 0 && B == 0) {
				break;
			}
			
			int arr[] = new int[49];
			arr[1] = 1;
			arr[2] = 1;
			for (int i = 3; i <= 48; i++) {
				arr[i] = (A * arr[i - 1] + B * arr[i - 2]) % 7;
			}
			System.out.println(arr[n % 48]);
		}
	}
}
