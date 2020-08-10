package studentskills.mytree;

import java.util.HashSet;
import java.util.Set;

import studentskills.event.Event;


/**
 * TreeHelper class 
 * This class create Different BST
 * It process the input, create replicas,clone them
 * @author Shrijeet Rupnar
 * @version 1.0.
 * @since   07-10-2020
 */
public class TreeHelper {

	MyBinarySearchTree replicaTree0 = null;
	MyBinarySearchTree replicaTree1 = null;
	MyBinarySearchTree replicaTree2 = null;


	/**
	 *  This is the parameterized constructor
	 * @version 1.0.
	 * @since   07-10-2020
	 */
	public TreeHelper(MyBinarySearchTree tree0In, MyBinarySearchTree tree1In, MyBinarySearchTree tree2In) {
		replicaTree0 = tree0In;
		replicaTree1 = tree1In;
		replicaTree2 = tree2In;
	}


	/**
	 *  Method executeInput, takes Input line as parameter
	 *  check whether the given bNumber is present or not,
	 *  if not crate a node and insert corresponding data 
	 *  and clone to other two replica
	 * @param Line
	 * @return no return type
	 * @author  Shrijeet Rupnar
	 * @version 1.0
	 * @since   07-10-2020
	 */
	public void executeInput(String line) {
		String[] s1Temp = line.split(":");
		int bNumber = Integer.parseInt(s1Temp[0]);
		String[] s2Temp = s1Temp[1].split(",");
		String fName = s2Temp[0];
		String lName = s2Temp[1];
		double gpa = Double.parseDouble(s2Temp[2]);
		String major = s2Temp[3];
		Set<String> skills = new HashSet<String>();
		for(int i = 4; i < s2Temp.length; i++) skills.add(s2Temp[i]);

		if(replicaTree0.searchNode(bNumber) != null) {
			StudentRecord node = replicaTree0.searchNode(bNumber);
			if(!fName.equals(node.getFirstName())) node.setFirstName(fName);
			if(!lName.equals(node.getLastName())) node.setLastName(lName);
			if(!major.equals(node.getMajor())) node.setMajor(major);
			Set<String> skillsTemp = node.getSkills();
			for(String skill : skills) {
				skillsTemp.add(skill);
			}
			node.setSkills(skillsTemp);

			node.notifyAll(Event.INSERT, line);
		}
		else {
			StudentRecord replica0 = new StudentRecord(bNumber, fName, lName, gpa, major, skills);
			
			StudentRecord replica1 = (StudentRecord) replica0.clone();
			StudentRecord replica2 = (StudentRecord) replica0.clone();

			replica0.register(replica1, replica2);
			replica1.register(replica0, replica2);
			replica2.register(replica0, replica1);

			replicaTree0.insertNode(replica0);
			replicaTree1.insertNode(replica1);
			replicaTree2.insertNode(replica2);
		}

		
	}
	
	/**
	 *  Method executeModify, takes Input line as parameter
	 *  check whether the given bNumber is present or not,
	 *  perform  corresponding data modification on BST
	 *  and clone to other two replica
	 * @param Line
	 * @return no return type
	 * @author  Shrijeet Rupnar
	 * @version 1.0
	 * @since   07-10-2020
	 */
	public void executeModify(String line) {
        String[] s1Temp = line.split(":");
        String modifiedValue = s1Temp[1];
        String[] s2Temp = s1Temp[0].split(",");
        int uniqueID = Integer.parseInt(s2Temp[0]);
        int bNumber = Integer.parseInt(s2Temp[1]);
        String originalValue = s2Temp[2];

       
        
        StudentRecord node = null;
        if(uniqueID == replicaTree0.getUniqueID()) {
        	
        	
            if(replicaTree0.searchNode(bNumber) != null) {
                node = replicaTree0.searchNode(bNumber);
            }
        }
        else if(uniqueID == replicaTree1.getUniqueID()) {
        	
            if(replicaTree1.searchNode(bNumber) != null) {
                node = replicaTree1.searchNode(bNumber);
               
            }
        }
        else if(uniqueID == replicaTree2.getUniqueID()) {
            if(replicaTree2.searchNode(bNumber) != null) {
                node = replicaTree2.searchNode(bNumber);
            }
        }

        node.notifyAll(Event.MODIFY,line);
       
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