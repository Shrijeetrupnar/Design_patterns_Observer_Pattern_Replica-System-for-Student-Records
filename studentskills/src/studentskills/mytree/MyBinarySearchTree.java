package studentskills.mytree;


import java.util.ArrayList;
import java.util.List;

/**
 * MyBinarySearchTree is class 
 * which will insert,search and print  Node in to BST
 * I have refereed this link : http://www.newthinktank.com/2013/03/binary-tree-in-java/
 * @author  Shrijeet Rupnar
 * @version 1.0
 * @since   07-10-2020
 */

public class MyBinarySearchTree {
	public StudentRecord root;
	final int uniqueID;

	/**
	 * MyBinarySearchTree is the parameterized constructor to assign id
	 * @param uniqueIDIn
	 * @return no
	 * @author  Shrijeet Rupnar
	 * @version 1.0
	 * @since   07-10-2020
	 */
	public MyBinarySearchTree(int uniqueIDIn) {
		uniqueID = uniqueIDIn;
	}

	/**
	 * getUniqueID is the getter method
	 * @param no
	 * @return uniqueID
	 * @author  Shrijeet Rupnar
	 * @version 1.0
	 * @since   07-10-2020
	 */
	public int getUniqueID() {
		return uniqueID;
	}
	
	
	
	/**
	 * insertNode is the  method used to inser a node into BST
	 * @param node of type StudentRecord
	 * @return no
	 * @author  Shrijeet Rupnar
	 * @version 1.0
	 * @since   07-10-2020
	 */
	public void insertNode(StudentRecord newNode) {

		if(root == null) {
			root = newNode;
		}
		else {
			StudentRecord focusNode = root;
			StudentRecord parent;

			while(true) {
				parent = focusNode;

				if(newNode.getBNumber() < focusNode.getBNumber()) {
					focusNode = focusNode.leftChild;

					if(focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				}
				else {
					focusNode = focusNode.rightChild;

					if(focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	
	
	/**
	 * searchNode is the  method used to search a node into BST
	 * @param bNumber
	 * @return StudentRecord
	 * @author  Shrijeet Rupnar
	 * @version 1.0
	 * @since   07-10-2020
	 */
	public StudentRecord searchNode(int bNumber) {
		if(root == null) return null;

		StudentRecord focusNode = root;
		
		while(focusNode.getBNumber() != bNumber) {

			
			if(focusNode.getBNumber() > bNumber) {
				focusNode = focusNode.leftChild;
			}
			else {
				focusNode = focusNode.rightChild;
			}
			
			
			if(focusNode == null) return null;
			
		}
		return focusNode;
	}
	
	
	/**
	 * printNodes is the  method used to print a node into BST
	 * @param StudentRecord node
	 * @return List<StudentRecord> List of StudentRecord
	 * @author  Shrijeet Rupnar
	 * @version 1.0
	 * @since   07-10-2020
	 */
	
	public List<StudentRecord> printNodes(StudentRecord focusNode) {
		List<StudentRecord> output = new ArrayList<StudentRecord>();
		if(focusNode == null) return output;

		if(focusNode.leftChild != null) {
			List<StudentRecord> left = printNodes(focusNode.leftChild);
			output.addAll(left);
		}
		
		output.add(focusNode);
		if(focusNode.rightChild != null) {
			List<StudentRecord> right = printNodes(focusNode.rightChild);
			output.addAll(right);
		}

		return output;
	}
	
	/**
	 * toString method 
	 * @author Shrijeet Rupnar
	 * @version 1.0.
	 * @since   07-10-2020
	 */
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "";
	}
}

