package 杭电.第一页;
import java.math.BigDecimal;
import java.util.Scanner;
/**
 * 大数处理
 * @author rong
 *
 */
public class Test1042 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int n = cin.nextInt();
			BigDecimal sum = new BigDecimal(1);
			for (int i = 1; i <= n; i++) {
				BigDecimal temp = new BigDecimal(i);
				sum = sum.multiply(temp);
			}
			System.out.println(sum);
		}
	}
}
