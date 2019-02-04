package 杭电.第一页;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 模拟搜索记录
 * @author rong
 *
 */
public class Test1035 {

	public static void main(String[] args) {

		Scanner cin = new Scanner(System.in);
		while (true) {
			int row = cin.nextInt();
			int column = cin.nextInt();
			if (row == 0 && column == 0) {
				break;
			}
			int start = cin.nextInt();

			char map[][] = new char[row][column];

			for (int i = 0; i < row; i++) {
				String str = cin.next();
				for (int j = 0; j < str.length(); j++) {
					map[i][j] = str.charAt(j);
				}
			}

			List<Node> nodes = new ArrayList<>();

			int x = 0, y = start - 1;
			int sum = 0;
			boolean huan = false;
			nodes.add(new Node(x, y, sum));
			int huanstart = 0, huanend = 0;
			while (x >= 0 && x < row && y >= 0 && y < column && !huan) {
				Node node = null;
				sum++;
				if (map[x][y] == 'E') {
					node = new Node();
					node.x = x;
					y++;
					node.y = y;
					node.count = sum;
				} else if (map[x][y] == 'W') {
					node = new Node();
					node.x = x;
					y--;
					node.y =y;
					node.count = sum;
				} else if (map[x][y] == 'S') {
					node = new Node();
					x++;
					node.x = x;
					node.y = y;
					node.count = sum;
				} else if(map[x][y] == 'N'){
					node = new Node();
					x--;
					node.x = x;
					node.y = y;
					node.count = sum;
				}
				for (int i = 0; i < nodes.size(); i++) {
					if (node.x == nodes.get(i).x && node.y == nodes.get(i).y) {
						huan = true;
						huanstart = nodes.get(i).count;
						huanend = node.count - nodes.get(i).count;
					}
				}
				nodes.add(node);
			}
			if (huan) {
				System.out.println(huanstart + " step(s) before a loop of " + huanend + " step(s)");
			} else {
				System.out.println(nodes.size() - 1 + " step(s) to exit");
			}
		}
	}
}

class Node {
	int x, y, count;

	public Node(int x, int y, int count) {
		super();
		this.x = x;
		this.y = y;
		this.count = count;
	}

	public Node() {
	}
}
