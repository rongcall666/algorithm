package 杭电.第三页;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/**
 * 并查集
 * @author rong
 *
 */
public class Test1213 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		while (n-- > 0) {
			int size = cin.nextInt();
			int c = cin.nextInt();
			UnionFind unionFind = new UnionFind(size);
			while (c-- > 0) {
				unionFind.union(cin.nextInt(), cin.nextInt());
			}
			System.out.println(unionFind.count());
		}
	}
}

class UnionFind {

	private int value[];

	public UnionFind(int n) {
		value = new int[n + 1];
		for (int i = 1; i < n; i++) {
			value[i] = i;
		}
	}

	public void union(int x, int y) {
		int xV = value[x];
		int yV = value[y];
		if (xV != yV) {
			for (int i = 1; i < value.length; i++) {
				if (value[i] == xV) {
					value[i] = yV;
				}
			}
		}
	}

	public int find(int x) {
		return value[x];
	}

	public int count() {
		Set set = new HashSet();
		for (int i = 1; i < value.length; i++) {
			set.add(value[i]);
		}
		return set.size();
	}
}
