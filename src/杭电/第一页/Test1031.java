package 杭电.第一页;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 贪心，排序
 * @author rong
 *
 */
public class Test1031 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while(cin.hasNext()) {
			int N = cin.nextInt();
			int M = cin.nextInt();
			int K = cin.nextInt();
			double arr[] = new double[M];
			List<tes> o = new ArrayList<>();
			for(int i = 0;i < N;i++) {
				for(int j = 0;j < M;j++) {
					arr[j] += cin.nextDouble();
					if(i == N - 1) {
						tes temp = new tes();
						temp.index = j;
						temp.sum = arr[j];
						o.add(temp);
					}
				}
			}
			Collections.sort(o, new Comparator<tes>() {
				@Override
				public int compare(tes o1, tes o2) {
					if(o1.sum.compareTo(o2.sum) == 0) {
						return o2.index - o1.index;
					}
					return o1.sum.compareTo(o2.sum);
				}
			});
			int index[] = new int[K];
			for(int i = 0;i < K;i++) {
				index[i] = o.get(o.size() - i - 1).index + 1;
			}
			Arrays.sort(index);
			for(int i = index.length - 1;i >= 0 ;i--) {
				System.out.print(index[i]);
				if(i != 0) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
class tes{
	public int index;
	public Double sum;
}
