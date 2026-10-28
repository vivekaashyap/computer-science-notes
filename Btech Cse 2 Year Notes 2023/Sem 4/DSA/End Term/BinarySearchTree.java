package ds.bst;

public class BinarySearchTree {

	TreeNode root;
	public static TreeNode insert(TreeNode root, int val) {
		if (root == null) {
			root = new TreeNode(val);
			return root;
		}
		
		if (root.data > val) {
			root.left = insert(root.left, val);
		}
		
		if (root.data < val) {
			root.right = insert(root.right, val);
		}
		
		return root;
	}
	
	public static void inOrder(TreeNode node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node.data+"  ");
			inOrder(node.right);
		}
	}
	
	
	public static  TreeNode inOrderSuccessor(TreeNode node){

		while(node.left != null){ node = node.left;}
		return node;

		}
	
	public static TreeNode delete(TreeNode root,int val) {
		
		if (root.data>val) {
			root.left = delete(root.left, val);
		}
		else	if (root.data<val) {
			root.right = delete(root.right, val);
		}
		else {
			if (root.left==null&&root.right==null) {
				return null;
			}
			if (root.left == null) {
				return root.right;
			}
			
			if (root.right == null) {
				return root.left;
			}
			
			
			TreeNode temp = inOrderSuccessor(root.right);
			root.data = temp.data;
			delete(root.right, temp.data);
			
		}
		return root;
	}
	
	
	public static boolean search(TreeNode root,int val) {
		
		if (root == null) {
			return false;
		}
		
		if (root.data == val) {
			return true;
		}
		
		return search(root.left, val) || search(root.right, val);
	}
	

	
	public static boolean searchTwo(TreeNode root, int key)
	{
	     if (root  == null) {
			return false;
		}
		
	    if (root==null || root.data==key)
	        return true;
	 
	    
	    if (root.data < key)
	       return searchTwo(root.right, key);
	 
	    
	    else return searchTwo(root.left, key);
	}
	
	
	public static void main(String[] args) {
		
BinarySearchTree t = new BinarySearchTree();
t.root  =  insert(t.root,50);
t.root  =  insert(t.root,25);
t.root  =  insert(t.root,55);
inOrder(t.root);

t.root =  delete(t.root, 25);
System.out.println();
inOrder(t.root);
System.out.println();
System.out.println(searchTwo(t.root, 50));


	}

}
