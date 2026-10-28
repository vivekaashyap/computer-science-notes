
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	TreeNode left,right;
	int data;
	TreeNode(int d) { data = d;}
}

public class BinaryTree {

	 TreeNode root;
	 
	 public void insertInLavel(int data) {
		if (root == null) {
			root = new  TreeNode(data);
			return;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			if (temp.left != null) {
				q.offer(temp.left);
			} else {
				temp.left = new TreeNode(data);
				return;
			}
			
			if (temp.right != null) {
				q.offer(temp.right);
			} else {
				temp.right = new TreeNode(data);
				return;
			}
			
		}
		
	}
	
	 public static void inOrder(TreeNode node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node.data+" ");
			inOrder(node.right);
		}
	}
	 
	 public static ArrayList<Integer> lavelOrder(TreeNode node) {
		if (node == null) {
			return null;
		}
		ArrayList<Integer> al = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		
		q.offer(node);
		while (!q.isEmpty()) {
			TreeNode temp = q.poll();
			al.add(temp.data);
			if (temp.left != null) {
				q.offer(temp.left);
			}
			if (temp.right != null) {
				q.offer(temp.right);
			}
		}
		
		return al;
	}
	 
	 
	 
	 public static int maxVal(TreeNode node) {
			if (node == null) {
				return 0;
			}
			int max  = Integer.MIN_VALUE;
			Queue<TreeNode> q = new LinkedList<>();
			
			q.offer(node);
			while (!q.isEmpty()) {
				TreeNode temp = q.poll();
				if (temp.data>max) {
					max = temp.data;
				}
				if (temp.left != null) {
					q.offer(temp.left);
				}
				if (temp.right != null) {
					q.offer(temp.right);
				}
			}
			
			return max;
		}
	 
	 

	 public static int countLeaf(TreeNode node) {
			if (node == null) {
				return 0;
			}
			int count  = 0;
			Queue<TreeNode> q = new LinkedList<>();
			
			q.offer(node);
			while (!q.isEmpty()) {
				TreeNode temp = q.poll();
				if (temp.left==null&&temp.right == null) {
					count++;
				}
				if (temp.left != null) {
					q.offer(temp.left);
				}
				if (temp.right != null) {
					q.offer(temp.right);
				}
			}
			
			return count;
		}
	 
	 
	 public static boolean search(TreeNode node,int key) {
			if (node == null) {
				return false;
			}
			
			Queue<TreeNode> q = new LinkedList<>();
			
			q.offer(node);
			while (!q.isEmpty()) {
				TreeNode temp = q.poll();
				if (temp.data == key) {
					return true;
				}
				if (temp.left != null) {
					q.offer(temp.left);
				}
				if (temp.right != null) {
					q.offer(temp.right);
				}
			}
			
			return false;
		}
	 
	public static void main(String[] args) {
		BinaryTree t = new BinaryTree();
		t.insertInLavel(10);
		t.insertInLavel(20);
		t.insertInLavel(30);
		t.insertInLavel(400);
		t.insertInLavel(50);
		t.insertInLavel(60);
		t.insertInLavel(70);
		inOrder(t.root);
		System.out.println();
		ArrayList<Integer> aa = lavelOrder(t.root);
		System.out.println(aa);
		System.out.println(maxVal(t.root));
		System.out.println(countLeaf(t.root));
		System.out.println(search(t.root, 500));

	}

}
