package 杭电.第一页;

import java.util.Scanner;
/**
 * 贪心算法
 * @author rong
 *
 */
public class Test1009 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (true) {
			int M = cin.nextInt();
			int N = cin.nextInt();
			if (M == -1)
				break;
			double J[] = new double[N];
			double F[] = new double[N];
			double H[] = new double[N];
			for (int i = 0; i < N; i++) {
				J[i] = cin.nextInt();
				F[i] = cin.nextInt();
				H[i] = J[i] / F[i];
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - 1; j++) {
					if (H[j] < H[j + 1]) {
						swap(J, j, j + 1);
						swap(F, j, j + 1);
						swap(H, j, j + 1);
					}
				}
			}
			int i = 0;
			double sum = 0;
			while (i < N && M > 0) {
				if (F[i] <= M) {
					sum += J[i];
					M -= F[i];
				} else {
					sum += H[i] * M;
					M = 0;
				}
				i++;
			}
			System.out.printf("%.3f", sum);
			System.out.println();
		}
	}

	public static void swap(double arr[], int i, int j) {
		double temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
