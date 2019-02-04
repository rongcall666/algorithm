package 杭电.第一页;

import java.util.Scanner;
/**
 * 贪心，排序
 * @author rong
 *
 */
public class Test1051 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		while (n-- > 0) {
			int m = cin.nextInt();
			int w[] = new int[m];
			int l[] = new int[m];
			for (int i = 0; i < m; i++) {
				w[i] = cin.nextInt();
				l[i] = cin.nextInt();
			}
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < m - 1; j++) {
					if (l[j] > l[j + 1]) {
						swap(w, j, j + 1);
						swap(l, j, j + 1);
					} else if (l[j] == l[j + 1]) {
						if (w[j] > w[j + 1]) {
							swap(w, j, j + 1);
							swap(l, j, j + 1);
						}
					}
				}
			}
			int sum = 0;
			boolean vis[] = new boolean[m];
			for (int i = 0; i < m; i++) {
				if (!vis[i]) {
					vis[i] = true;
					sum++;
					int weight = w[i];
					for(int j = i + 1;j < m;j++) {
						if(!vis[j] && w[j] >= weight) {
							vis[j] = true;
							weight = w[j];
						}
					}
				}
			}
			System.out.println(sum);
		}
	}

	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
