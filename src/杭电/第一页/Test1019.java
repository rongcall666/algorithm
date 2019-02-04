package 杭电.第一页;

import java.util.Scanner;
/**
 * 最小公倍数和最大公约数
 * @author rong
 *
 */
public class Test1019 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		while (n-- > 0) {
			int length = cin.nextInt();
			int b = 1;
			for (int i = 0; i < length; i++) {
				int a = cin.nextInt();
				b = lcm(a,b);
			}
			System.out.println(b);
		}
	}

	public static int lcm(int a, int b) {
		return (a / gcd(a, b)) * b;
	}

	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}
}
