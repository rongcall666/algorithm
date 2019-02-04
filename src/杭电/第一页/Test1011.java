package 杭电.第一页;

import java.util.Scanner;

public class Test1011 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (true) {
			int n = cin.nextInt();
			int brice = cin.nextInt();
			
			if(n == -1 && brice == -1) {
				break;
			}
			
			double room[] = new double[n];
			double brices[] = new double[n];
			double value[] = new double[n];
			for (int i = 0; i < n; i++) {
				room[i] = cin.nextInt();
				brices[i] = cin.nextInt();
				value[i] = room[i] / brices[i];
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (value[j] < value[j + 1]) {
						swap(value, j, j + 1);
						swap(room, j, j + 1);
						swap(brices, j, j + 1);
					} else if (value[j] == value[j + 1]) {
						if (room[j] > room[j + 1]) {
							swap(value, j, j + 1);
							swap(room, j, j + 1);
							swap(brices, j, j + 1);
						} else if (room[j] == room[j + 1]) {
							if (brices[j] < brices[j + 1]) {
								swap(value, j, j + 1);
								swap(room, j, j + 1);
								swap(brices, j, j + 1);
							}
						}
					}
				}
			}
			int sum = 0;
			int i = 0;
			while (brice > 0 && i < n) {
				if (brice > room[i]) {
					sum += brices[i];
					brice -= room[i];
				} else {
					sum += brice * value[i];
					brice = 0;
				}
				i++;
			}
			System.out.println(sum);
		}
	}

	public static void swap(double arr[], int i, int j) {
		double temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
