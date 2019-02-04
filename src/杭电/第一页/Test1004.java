package 杭电.第一页;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * 字符串统计 HashMap
 * @author rong
 *
 */
public class Test1004 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (true) {
			int n = cin.nextInt();
			if(n == 0) {
				break;
			}
			HashMap<String, Integer> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				String str = cin.next();
				if (map.get(str) != null) {
					map.put(str, map.get(str) + 1);
				} else {
					map.put(str, 1);
				}
			}

			int sum = 0;
			String str = "";
			for (Entry<String, Integer> entry : map.entrySet()) {
				if (entry.getValue() > sum) {
					sum = entry.getValue();
					str = entry.getKey();
				}
			}
			System.out.println(str);
		}
	}
}
