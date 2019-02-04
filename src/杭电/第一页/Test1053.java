package 杭电.第一页;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
 
/**
 * 哈夫曼树求解最优wpl
 * @author rong
 *
 */
public class Test1053 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (true) {
			String str = cin.nextLine();
			if (str.equals("END"))
				break;
			Haffman haffman = new Haffman();
			char ch[] = new char[str.length()];
			for (int i = 0; i < str.length(); i++) {
				ch[i] = str.charAt(i);
			}
			haffman.build(ch);
			int sum = 0;
			for (int i = 0; i < ch.length; i++) {
				sum += haffman.getWeight(ch[i]);
			}
			if(sum == 0) sum = str.length();
			double bili = (double) str.length() * 8 / (double) sum;
			System.out.print(str.length() * 8 + " " + sum + " ");
			System.out.printf("%.1f", bili);
			System.out.println();
		}
	}
}
 
class HaffmanNode {
	int val; // 值
	int weight;// 权值
	char ch;// 所放字符串
	HaffmanNode left;// 左孩子
	HaffmanNode right;// 右孩子
 
	public HaffmanNode(int val, char ch) {
		this.val = val;
		this.ch = ch;
	}
}
 
class Haffman {
	HaffmanNode root;
	int count[] = new int[200];
	public void build(char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			count[arr[i] - 'A']++;
		}
		PriorityQueue<HaffmanNode> priorityQueue = new PriorityQueue<>(new Comparator<HaffmanNode>() {
			public int compare(HaffmanNode o1, HaffmanNode o2) {
				return o1.val - o2.val;
			}
		});
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) {
				priorityQueue.offer(new HaffmanNode(count[i], (char) (65 + i)));
			}
		}
		while (priorityQueue.size() != 1) {
			HaffmanNode left = priorityQueue.poll();
			HaffmanNode right = priorityQueue.poll();
			HaffmanNode newHaffmanNode = new HaffmanNode(left.val + right.val, ' ');
			newHaffmanNode.left = left;
			newHaffmanNode.right = right;
			priorityQueue.add(newHaffmanNode);
		}
		root = priorityQueue.poll();
	}
	private Map<Character, Integer> map1 = null;
	private void getWeight() {
		map1 = new HashMap<>();
		count(root, 0);
	}
	public Integer getWeight(char ch) {
		if (map1 == null) {
			getWeight();
		}
		return map1.get(ch);
	}
	public void count(HaffmanNode haffmanNode, int weight) {
		if (haffmanNode != null && haffmanNode.ch != ' ') {
			map1.put(haffmanNode.ch, weight);
		}
		if (haffmanNode.left != null) {
			count(haffmanNode.left, weight + 1);
		}
		if (haffmanNode.right != null) {
			count(haffmanNode.right, weight + 1);
		}
	}
}
