package studentCoursesBackup.myTree;

import java.util.ArrayList;

//http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/

public class Node implements Cloneable, SubjectI, ObserverI{

	public int key;
	public ArrayList<String> course = new ArrayList<String>();
	public Node left, right;
	public Node observer2;
	public Node observer3;
	

	public Node(int item, String str) {
		key = item;
		course.add(str);
		left = right = null;
	}

	// stackoverflow.com/questions//17203493
	public  Node clone() {
//	public  Node clone(Node root) {
		Node newNode = null;
		try {
			newNode = (Node) super.clone();


		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newNode;
	}

	@Override
	public void notifyAll(Node typ) {
		// TODO Auto-generated method stub
		update(typ.observer2,typ );
		update(typ.observer3,typ);		
	}

	@Override
	public void update(Node toUpdate, Node typ) {
		// TODO Auto-generated method stub
		toUpdate.course=typ.course;
	}
}
