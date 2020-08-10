package studentskills.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import studentskills.mytree.MyBinarySearchTree;
import studentskills.mytree.StudentRecord;

/**
 * Result class 
 * It has different method such as store,writeToFileOne, display.
 * @author Shrijeet Rupnar
 * @version 1.0.
 * @since   07-10-2020
 */

public class Results implements StdoutDisplayInterface,FileDisplayInterface {
	
	MyBinarySearchTree replicaTree = null;

	List<Integer> bNumbers = null;
	List<String> skills = null;
	String output1FilePath=null;
	ErrorHandlerClass errorHandlerObj=null;

	
	List<StudentRecord> studentRecordList= null;
	
	Map<Integer,Set<String>> record= new LinkedHashMap<Integer,Set<String>>();
	
	/**
	 * Result is parameterized  constructor
	 * @author Shrijeet Rupnar
	 * @version 1.0.
	 * @since   07-10-2020
	 */
	public Results(ErrorHandlerClass errorHandlerObjIn) {
		
		this.errorHandlerObj=errorHandlerObjIn;
		
	}
	
	
	/**
	 * Result is parameterized  constructor
	 * @author Shrijeet Rupnar
	 * @version 1.0.
	 * @since   07-10-2020
	 */
	public Results(MyBinarySearchTree treeIn,String output1FilePathIn) {
		
		replicaTree = treeIn;
		
		this.output1FilePath=output1FilePathIn;
		
	}
	
	
	/**
	 * store method is used to store Result in to data structure
	 * @author Shrijeet Rupnar
	 * @version 1.0.
	 * @since   07-10-2020
	 */
	@Override
	public void store() {
		// TODO Auto-generated method stub
		
		studentRecordList =replicaTree.printNodes(replicaTree.root);
		
		for(StudentRecord  studentRecordListOne: studentRecordList) {
			
			record.put(studentRecordListOne.getBNumber(), studentRecordListOne.getSkills());
		}
		

	}
	
	/**
	 * writeToFileOne method is used to write Result in to a file
	 * @author Shrijeet Rupnar
	 * @version 1.0.
	 * @since   07-10-2020
	 */

	@Override
	public void writeToFileOne() {
		// TODO Auto-generated method stub
		
		//System.out.println(replicaTree0.printNodes(replicaTree0.root));
		
		
		
		try {
			
			File myObj = new File(output1FilePath);
			
			BufferedWriter br= null;
			br= new BufferedWriter(new FileWriter(myObj));
			
			for(Map.Entry<Integer,Set<String>> entry : record.entrySet()) {
				br.write(entry.getKey()+" : "+entry.getValue() );
				//System.out.println(entry.getKey()+" : "+entry.getValue());
				br.newLine();
			}
			
			
			br.flush();
			br.close();
			
		}catch (NullPointerException e1) {
			// TODO Auto-generated catch block
			System.err.println("Could not create new file");
			errorHandlerObj.printErrorMessage("Could not create new file");
			System.exit(0);
		}
		
		catch (IOException e1) {
			// TODO Auto-generated catch block
			System.err.println("Could not create new file");
			errorHandlerObj.printErrorMessage("Could not create new file");
			System.exit(0);
		}

	}

	/**
	 * display method is used to write Result on to a console
	 * @author Shrijeet Rupnar
	 * @version 1.0.
	 * @since   07-10-2020
	 */


	@Override
	public void display() {
		// TODO Auto-generated method stub
		
		System.out.println("Final Output Ascending Order :\n");
		
		for(Map.Entry<Integer,Set<String>> entry : record.entrySet()) {
			
			System.out.println(entry.getKey()+" : "+entry.getValue());
			
		}
		
		
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
