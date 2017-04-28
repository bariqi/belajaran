import java.util.ArrayList;
import java.util.Scanner;

public class TemplateLab6 {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String num = in.nextLine();
		int num2 = Integer.parseInt(num);
		
		Tree bst = new Tree();
		
		for(int i = 0; i < num2; i++) {

			Tree.List.clear();
			String command = in.nextLine();
			String[] command2 = command.split(" ");
			int content = Integer.parseInt(command2[1]);

			if(command2[0].equals("ADD")) {
				bst.add(content);	
			}
			
			else if(command2[0].equals("FIND")) {
				bst.find(content);				
			}
			
		}
	}
}

class Tree {
	
	TreeNode root;
	public static ArrayList<Integer> List = new ArrayList<Integer>();

	public Tree() {
		root = null;
	}
	boolean isEmpty() {
		return(root == null);
	}
	public void printInOrder() {
		if( root != null )
			root.printInOrder( );
	}
	public void add(int x){
		if(isEmpty()) {
			root = new TreeNode(x);
		}
		else {
			root = root.add(x,root);
		}
	}
	public void find(int x){
		if(isEmpty()){
					System.out.println("TIDAK DITEMUKAN ANGKA " + x);
		}
		else{
			root.find(x, root);
		}
	}
}

class TreeNode {
	int content;
	TreeNode right;
	TreeNode left;
	
	public TreeNode() {
		content = (Integer) null;
		right = null;
		left = null;
	}

	public TreeNode(int content) {
		this.content = content;
		right = null;
		left = null;
	}
	public TreeNode add(int x, TreeNode t) {
		if (t == null) { 
			t = new TreeNode (x);
		} 
		else if (x < t.content) { 
			t.left = add (x, t.left);
		} 
		else if (x > t.content) { 
			t.right = add (x, t.right);
		} 
		return t;
	}
	void printInOrder() {
		if( left != null )
			left.printInOrder( ); // Left
		System.out.println( content ); // Node
		if( right != null )
			right.printInOrder( ); // Right
	}
	public void find (int x, TreeNode t) {
		if (t == null){
			System.out.println("TIDAK DITEMUKAN ANGKA " + x);
			return;
		}
		else if(t.content == x){
			Tree.List.add(t.content);
			System.out.print(x +" DITEMUKAN DENGAN JALUR");
			for(int tmp : Tree.List){
				System.out.print(" "+ tmp);
			}
			System.out.println();
			return;
		}
		else if(x < t.content) {
			Tree.List.add(t.content);
			find(x, t.left);
			return;
		} 
		else{
			Tree.List.add(t.content);
			find(x, t.right);
			return;
		}
	}
}