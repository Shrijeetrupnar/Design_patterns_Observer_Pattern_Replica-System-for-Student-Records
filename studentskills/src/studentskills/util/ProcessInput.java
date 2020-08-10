package studentskills.util;

import studentskills.mytree.TreeHelper;

import java.io.IOException;

/**
 * ProcessInput is class 
 * which will read input file and modify file line by line and send to TreeHelper * 
 * @author  Shrijeet Rupnar
 * @version 1.0
 * @since   07-10-2020
 */
public class ProcessInput {
    private FileProcessor inputFP = null;
    private FileProcessor modifyFP = null;
    private TreeHelper tHelper = null;
    private ErrorHandlerClass errorHandlerObj=null;

    
    /**
     * ProcessInput is parametrized constructor
     * @author  Shrijeet Rupnar
     * @version 1.0
     * @since   07-10-2020
     */
    public ProcessInput(FileProcessor inputFPIn, FileProcessor modifyFPIn, TreeHelper tHelperIn,ErrorHandlerClass errorHandlerObjIn) {
        inputFP = inputFPIn;
        modifyFP = modifyFPIn;
        tHelper = tHelperIn;
        errorHandlerObj=errorHandlerObjIn;
    }
    
    /**
     * run method read input file and modify file line by
     *  line and send to TreeHelper * 
     * @author  Shrijeet Rupnar
     * @version 1.0
     * @since   07-10-2020
     */

    public void run() {
        try {

            String line=null;
            String line2=null;
            do {
                line = inputFP.poll();
                if(line != null) {
                    tHelper.executeInput(line);
                }
                else {
                    //EOF
                }
            } while(line != null);
            
           
            

            do {
                line2 = modifyFP.poll();
                
                if(line2 != null) {
                    tHelper.executeModify(line2);
                }
                else {
                    //EOF
                }
            } while(line2 != null);
            
            
        } catch (IOException e) {
            e.printStackTrace();
            errorHandlerObj.printErrorMessage("IOException - in ProcessInput");
            System.exit(0);

        } finally {

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