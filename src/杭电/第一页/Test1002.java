package 杭电.第一页;

import java.math.BigDecimal;
import java.util.Scanner;
/**
 * 大数加法
 * @author rong
 *
 */
public class Test1002 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		for (int i = 1; i <= n; i++) {
			String a = cin.next();
			String b = cin.next();
			BigDecimal b1 = new BigDecimal(a);
			BigDecimal b2 = new BigDecimal(b);
			System.out.println("Case " + i + ":");
			System.out.println(b1 + " + " + b2 + " = " + b1.add(b2));
			if (i != n) {
				System.out.println();
			}
		}
	}
}
