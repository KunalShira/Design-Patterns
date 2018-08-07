package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;

//http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/

public class TreeBuilder {

	Node root;
	String all = "";
	Node clone2, clone3;

	public TreeBuilder() {
		// TODO Auto-generated constructor stub
		root = null;
	}

	public void search(int key) {
		root = searchRec(root, key);

	}

	public Node searchRec(Node root, int key) {
		// Root is key
		if (root == null || root.key == key) {
			return root;
		}
		// check left
		if (root.key > key)
			return searchRec(root.left, key);
		// check right
		return searchRec(root.right, key);
	}

	// Insert to original tree
	public Node[] insert(String line) {
		String[] words = line.split(":");
		int key = Integer.parseInt(words[0]);

		String newCource = words[1];
		if(key>9999 || key<0000)
		{
			System.err.println(key+" invalid b-id. Hence, Ignored");
			return null;
		}

		if (words[1].length() == 1) {
			// validation no courses other than ABCDEFGHIJK
			if (newCource.matches("A|B|C|D|E|F|G|H|I|J|K")) {
				root = insertRec(root, key, newCource);
				Node[] typ1 = new Node[2];
				// cloning original trees just inserted node
				typ1[0] = root.clone();
				typ1[1] = root.clone();
				// linking observers to just inserted node
				root.observer2 = typ1[0];
				root.observer3 = typ1[1];
				return typ1;
			} else {
				System.err.println(newCource + " is Invalid course. Hence, ignored");
				return null;
			}
		}
		else
		{
			System.err.println("Trying to add multiple cources for b-id "+key+". Hence, ignored.");
//			System.exit(0);
			
		}

		return null;
		// root = insertRec(root, key);
	}

	// Recursive call to original tree node and check weather to go right or left of
	// sub tree
	public Node insertRec(Node root, int key, String newCource) {

		if (root == null) {
			root = new Node(key, newCource);
			return root;
		}

		if (key < root.key)
			root.left = insertRec(root.left, key, newCource);
		else if (key > root.key)
			root.right = insertRec(root.right, key, newCource);
		else if (key == root.key) {
			if (!root.course.contains(newCource)) {
				root.course.add(newCource);
			}
		}
		return root;
	}

	// inserting cloned node as above insert wont work cause it does cloning
	public void insertClone(Node type1) {
		root = insertRecClone(root, type1);
		// emptying the observers of backup tree node
		root.observer2 = null;
		root.observer3 = null;

		// root = insertRec(root, key);
	}

	// Recursive call to backup tree node and check weather to go right or left of
	// sub tree
	public Node insertRecClone(Node root, Node type1) {
		// iterating using root and storing values via type1
		if (root == null) {
			root = type1;
			return root;
		}

		if (type1.key < root.key)
			root.left = insertRecClone(root.left, type1);
		else if (type1.key > root.key)
			root.right = insertRecClone(root.right, type1);
		else if (type1.key == root.key) {
			root = type1;
		}

		return root;
	}

	// This method mainly calls printNodes(Node root)
	public String printNodes() {
		all = "";
		printNodes(root);
		return all;
	}

	// Traversing to BST in inorder give sorted list of node
	public void printNodes(Node root) {
		if (root != null) {
			printNodes(root.left);
			all = all + root.key + ":" + root.course + "\n";
			printNodes(root.right);
		}
	}

	// deleting node's course field element if it exits
	public void delete(String line) {

		String[] words = line.split(":");
		int key = Integer.parseInt(words[0]);

		String delCource = words[1];

		root = deleteRec(root, key, delCource);
		root.notifyAll(root);
	}

	// recursive delete to find and update course if exists
	public Node deleteRec(Node root, int key, String co) {
		if (root == null) {
			return root;
		}
		if (key < root.key) {
			root.left = deleteRec(root.left, key, co);
		} else if (key > root.key) {
			root.right = deleteRec(root.right, key, co);
		} else if (key == root.key) {
			if (root.course.contains(co)) {
				root.course.remove(co);
			}
		}
		return root;
	}
}
