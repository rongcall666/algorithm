package 杭电.第一页;

import java.util.Scanner;
/**
 * 数学
 * @author rong
 *
 */
public class Test1008 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (true) {
			int n = cin.nextInt();
			if (n == 0) {
				break;
			}
			int length = 0;
			int time = 0;
			while (n-- > 0) {
				int ceng = cin.nextInt();
				int result = ceng - length;
				if (result > 0) {
					time += result * 6 + 5;
					length = ceng;
				} else {
					time += (-1) * result * 4 + 5;
					length = ceng;
				}
			}
			System.out.println(time);
		}
	}
}
