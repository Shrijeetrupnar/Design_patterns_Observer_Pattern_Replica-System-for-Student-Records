package studentskills.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ErrorHandlerClass is the class
 * which has a method to print error message into file
 * @param no
 * @return no return type
 * @author  Shrijeet Rupnar
 * @version 1.0
 * @since   07-10-2020
 */
public class ErrorHandlerClass {
	
	String errorFilePath =null;
	
	/**
	 * ErrorHandlerClass is the parameterized constructor
	 * which has a write error message into file
	 * @param errorMessage
	 * @return no return type
	 * @author  Shrijeet Rupnar
	 * @version 1.0
	 * @since   07-10-2020
	 */
	
	public ErrorHandlerClass(String ErrorHandlerClassIn ) {
		// TODO Auto-generated constructor stub
		
		this.errorFilePath=ErrorHandlerClassIn;
	}
	
	
	/**
	 * printErrorMessage is the method
	 * which has a write error message into file
	 * @param errorMessage
	 * @return no return type
	 * @author  Shrijeet Rupnar
	 * @version 1.0
	 * @since   07-10-2020
	 */
	public void printErrorMessage(String errorMessage) {
		
        try {
			
			File myObj = new File(errorFilePath);
			
			BufferedWriter br= null;
			br= new BufferedWriter(new FileWriter(myObj));
			
		   br.write(errorMessage);
			
			
			br.flush();
			br.close();
			
		}catch (NullPointerException e1) {
			// TODO Auto-generated catch block
			System.err.println("Could not create new file");
			System.exit(0);
		}
		
		catch (IOException e1) {
			// TODO Auto-generated catch block
			System.err.println("Could not create new file");
			System.exit(0);
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
