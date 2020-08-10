package studentskills.mytree;

import studentskills.event.Event;


/**
 * SubjectI is an Interface  
 * has declaration of register,notifyAll method
 * @author Shrijeet Rupnar
 * @version 1.0.
 * @since   07-10-2020
 */
public interface SubjectI {
	
	public void register(StudentRecord... nodes);
	
	public void notifyAll(Event e, String line);

}
