package 杭电.第一页;

import java.math.BigDecimal;
import java.util.Scanner;
/**
 * 大数 ，等差数列和
 * @author rong
 *
 */
public class Test1001 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int a = cin.nextInt();
			BigDecimal bigDecimal = new BigDecimal(a);
			BigDecimal cheng = bigDecimal.multiply(bigDecimal.add(new BigDecimal(-1))).divide(new BigDecimal(2));
			BigDecimal result = bigDecimal.add(cheng);
			System.out.println(result);
			System.out.println();
		}
	}
}
