package studentskills.driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import studentskills.mytree.MyBinarySearchTree;
import studentskills.mytree.TreeHelper;
import studentskills.util.ErrorHandlerClass;
import studentskills.util.FileProcessor;
import studentskills.util.ProcessInput;
import studentskills.util.Results;


/**
 * Driver class 
 * The Driver program implements the application,
 * It reads input, creates different objects, class and display result
 * from result class ,perform the write to output file and console write operation.
 * @author Shrijeet Rupnar
 * @version 1.0.
 * @since   07-10-2020
 */
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if ((args.length != 7) || (args[0].equals("${input}")) || (args[1].equals("${modify}")) || (args[2].equals("${out1}")) || (args[3].equals("${out2}")) || (args[4].equals("${out3}")) || (args[5].equals("${error}")) || (args[6].equals("${debug}"))) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 7 arguments.");
			System.exit(0);
		}


		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("--------------------------- Design Patterns -------------------------------------------------");
		System.out.println("--------------------- Assignment-3 - Summer - 2020 ------------------------------------------");
		System.out.println("----------- Design and Implementation of Replica System for Student Records -----------------");
		System.out.println("---------------------------------------------------------------------------------------------\n");


		String inpuFilePath= args[0];
		String modifyFilePath=args[1];
		String output1FilePath=args[2];
		String output2FilePath=args[3];
		String output3FilePath=args[4];
		String errorFilePath=args[5];
		int debugLevel=Integer.parseInt(args[6]);
		FileProcessor fileProcessorInputObj=null;
		FileProcessor fileProcessorModifyObj=null;
		ErrorHandlerClass errorHandlerObj= new ErrorHandlerClass(errorFilePath);

		MyBinarySearchTree tree0= new MyBinarySearchTree(0);
		MyBinarySearchTree tree1= new MyBinarySearchTree(1);
		MyBinarySearchTree tree2= new MyBinarySearchTree(2);

		TreeHelper th= new TreeHelper(tree0, tree1, tree2);



		try {
			fileProcessorInputObj =new FileProcessor(inpuFilePath);

			fileProcessorModifyObj=new FileProcessor(modifyFilePath);
            Results resultclassObj= new Results(errorHandlerObj);


			ProcessInput processInputobj = new ProcessInput(fileProcessorInputObj,fileProcessorModifyObj,th,errorHandlerObj);

			processInputobj.run();

			Results resultClassObjZero= new Results(tree0,output1FilePath);
			resultClassObjZero.store();
			resultClassObjZero.writeToFileOne();

			Results resultClassObjOne= new Results(tree1,output2FilePath);
			resultClassObjOne.store();
			resultClassObjOne.writeToFileOne();



			Results resultClassObjTwo= new Results(tree2,output3FilePath);
			resultClassObjTwo.store();
			resultClassObjTwo.writeToFileOne();

			resultClassObjTwo.display();


		}catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
			errorHandlerObj.printErrorMessage("NullPointerException - in Driver");
			System.out.println("Exiting...");
			System.exit(0);

		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			System.out.println("\nPlease check Input File...");
			errorHandlerObj.printErrorMessage("Please check Input File... - in Driver");
			System.out.println("Exiting...");
			System.err.println(e.getMessage());
			System.exit(0);

		} 
		catch(SecurityException e)
		{
			System.out.println(e.getMessage());
			errorHandlerObj.printErrorMessage("SecurityException... - in Driver");
			System.out.println("\n Not valid Input file...");
			System.exit(0);
		}
		catch (InvalidPathException e)
		{
			// TODO Auto-generated catch block
			System.out.println("\nPlease check Input File...");
			errorHandlerObj.printErrorMessage("Please check Input File... - in Driver");
			System.out.println("Exiting...");
			System.err.println(e.getMessage());
			System.exit(0);

		}
		catch(IOException e)
		{
			System.err.println(e.getMessage());
			errorHandlerObj.printErrorMessage("IOException... - in Driver");
			System.out.println("\n Input Output Exception...");
			System.exit(0);
		}
		catch(Exception e)// Any other exceptions
		{
			System.err.println(e.getMessage());
			errorHandlerObj.printErrorMessage("Exception... - in Driver");
			System.out.println("\nException...");
			System.exit(0);
		}

		finally {
			
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("Thank you ....");
			System.out.println("Exiting....");
			System.out.println("------------------------------- End of Application ------------------------------------------");

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
