public class BST {

	static class Node{
		Node left,right;
		int data;
		Node(int d){this.data = d;}
	}
	
	public static Node insert(Node root , int val) {
		if (root == null) {
			root = new Node(val);
			return root;
		}	
		
		else if (root.data > val) {
			root.left = insert(root.left, val);
		}
		else {
			root.right = insert(root.right, val);
		}
		
		return root;
	}
	
	public static void inOrder(Node root ) {
		if (root == null) {
			return;
		}
		
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
		
	}
	
	
	public static Node delete(Node root, int val) {
		if (root.data > val) {
			root.left = delete(root.left, val);
		}
		
		else	if (root.data < val) {
			root.right = delete(root.right, val);
		}
		
		else {
			if (root.left == null && root.right == null) {
				return null;
			}
			else if (root.left == null) {
				return root.right;
			}
			else if(root.right==null) {
				return root.left;
			}
			
			Node Is= inOderSuccessor(root.right);
			root.data = Is.data;
			delete(root.right, Is.data);
			
			
		}
		
		return root;
	}
	
	
	public static Node inOderSuccessor(Node root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}
	public static Node inOderPredecessor(Node root) {
		while (root.right != null) {
			root = root.right;
		}
		return root;
	}
	
	
	
	public static void main(String[] args) {
		int[] arr = {5,1,3,4,2,7};
		Node r = null;
		for (int i = 0; i < arr.length; i++) {
			r = insert(r, arr[i]);
		}
		
		inOrder(r);
		System.out.println();
		delete(r, 1);
		inOrder(r);
		
		

		
	}
}
