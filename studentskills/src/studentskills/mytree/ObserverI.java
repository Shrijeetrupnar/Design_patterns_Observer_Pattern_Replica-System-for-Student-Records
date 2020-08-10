package studentskills.mytree;

import studentskills.event.Event;


/**
 * ObserverI is an Interface  
 * has declaration of update method
 * @author Shrijeet Rupnar
 * @version 1.0.
 * @since   07-10-2020
 */
public interface ObserverI {
	
	public void update(Event e, String line);

}
