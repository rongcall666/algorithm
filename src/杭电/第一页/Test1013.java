package 杭电.第一页;

import java.util.Scanner;

/**
 * 
 * @author rong
 *
 */
public class Test1013 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (true) {
			String str = cin.next();
			if (str.equals("0")) {
				break;
			}
			int sum = 0;
			for (int i = 0; i < str.length(); i++) {
				sum += str.charAt(i) - '0';
			}
			while(sum >= 10) {
				int temp = 0;
				while(sum > 0) {
					temp += sum %10;
					sum /= 10;
				}
				sum = temp;
			}
			System.out.println(sum);
		}
	}
}
