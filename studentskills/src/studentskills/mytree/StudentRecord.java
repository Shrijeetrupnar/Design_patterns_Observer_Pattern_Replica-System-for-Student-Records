package studentskills.mytree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import studentskills.event.Event;


/**
 * StudentRecord is the  class which implements SubjectI, ObserverI, Cloneable
 * interface. has Attribute for StudentRecord, perfrom upadte, notifyAll and clone
 * @param no
 * @return no
 * @author  Shrijeet Rupnar
 * @version 1.0
 * @since   07-10-2020
 */

public class StudentRecord implements SubjectI, ObserverI, Cloneable {

    private final int bNumber;
    private String firstName;
    private String lastName;
    private double gpa;
    private String major;
    private Set<String> skills;

    StudentRecord leftChild;
    StudentRecord rightChild;

    List<StudentRecord> observers = null;
    
    
    /**
     * StudentRecord is the  parameterized constructor
     * @param bNumber,firstName,lastName, gpa, major,  skills
     * @return no
     * @author  Shrijeet Rupnar
     * @version 1.0
     * @since   07-10-2020
     */
    public StudentRecord(int bNumberIn, String firstNameIn, String lastNameIn, double gpaIn, String majorIn, Set<String> skillsIn) {
        bNumber = bNumberIn;
        firstName = firstNameIn;
        lastName = lastNameIn;
        gpa = gpaIn;
        major = majorIn;
        skills = skillsIn;
        observers = new ArrayList<StudentRecord>();
    }
    
    /**
     * getBNumber is the getter method
     * @param no
     * @return bNumber
     * @author  Shrijeet Rupnar
     * @version 1.0
     * @since   07-10-2020
     */

    public int getBNumber() {
        return bNumber;
    }

    
    /**
     * getFirstName is the getter method
     * @param no
     * @return firstName
     * @author  Shrijeet Rupnar
     * @version 1.0
     * @since   07-10-2020
     */
    public String getFirstName() {
        return firstName;
    }

    
    /**
     * getLastName is the getter method
     * @param no
     * @return lastName
     * @author  Shrijeet Rupnar
     * @version 1.0
     * @since   07-10-2020
     */
    public String getLastName() {
        return lastName;
    }
    
    
    /**
     * getGpa is the getter method
     * @param no
     * @return gpa
     * @author  Shrijeet Rupnar
     * @version 1.0
     * @since   07-10-2020
     */

    public double getGpa() {
        return gpa;
    }
    
    /**
     * getMajor is the getter method
     * @param no
     * @return major
     * @author  Shrijeet Rupnar
     * @version 1.0
     * @since   07-10-2020
     */

    public String getMajor() {
        return major;
    }
    
    /**
     * getSkills is the getter method
     * @param no
     * @return skills
     * @author  Shrijeet Rupnar
     * @version 1.0
     * @since   07-10-2020
     */

    public Set<String> getSkills() {
        return skills;
    }

    
    /**
     * setFirstName is the setter method
     * @param firstName
     * @return no
     * @author  Shrijeet Rupnar
     * @version 1.0
     * @since   07-10-2020
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    /**
     * setLastName is the setter method
     * @param lastName
     * @return no
     * @author  Shrijeet Rupnar
     * @version 1.0
     * @since   07-10-2020
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * setMajor is the setter method
     * @param major
     * @return no
     * @author  Shrijeet Rupnar
     * @version 1.0
     * @since   07-10-2020
     */

    public void setMajor(String major) {
        this.major = major;
    }
    
    
    /**
     * setSkills is the setter method
     * @param skills
     * @return no
     * @author  Shrijeet Rupnar
     * @version 1.0
     * @since   07-10-2020
     */

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }
    
    
    /**
     * register is the method used to register node to observer
     * @param StudentRecord... nodes
     * @return no
     * @author  Shrijeet Rupnar
     * @version 1.0
     * @since   07-10-2020
     */

    @Override
    public void register(StudentRecord... nodes) {
        for(StudentRecord node : nodes) {
            observers.add(node);
        }
    }
    
    
    /**
     * update is the method used to update BST node
     * @param Event and String Line
     * @return no
     * @author  Shrijeet Rupnar
     * @version 1.0
     * @since   07-10-2020
     */

    @Override
    public void update(Event e, String line) {
        if(e == Event.INSERT) {
            String[] s1Temp = line.split(":");
            String[] s2Temp = s1Temp[1].split(",");
            String fName = s2Temp[0];
            String lName = s2Temp[1];
            double gpa = Double.parseDouble(s2Temp[2]);
            String major = s2Temp[3];
            Set<String> skillsTemp = new HashSet<String>();
            for(int i = 4; i < s2Temp.length; i++) skillsTemp.add(s2Temp[i]);
            if(!fName.equals(this.getFirstName())) this.setFirstName(fName);
            if(!lName.equals(this.getLastName())) this.setLastName(lName);
            if(!major.equals(this.getMajor())) this.setMajor(major);
            Set<String> sTemp = this.getSkills();
            for(String skill : skills) {
                skillsTemp.add(skill);
            }
            this.setSkills(skillsTemp);
        }
        
        else if(e == Event.MODIFY) {
        	
            String[] s1Temp = line.split(":");
            String modifiedValue = s1Temp[1];
            String[] s2Temp = s1Temp[0].split(",");
            int uniqueID = Integer.parseInt(s2Temp[0]);
            int bNumberTemp = Integer.parseInt(s2Temp[1]);
            String originalValue = s2Temp[2];

            if(originalValue.equals(this.getFirstName())) { this.setFirstName(modifiedValue); }
            else if(originalValue.equals(this.getLastName())) {this.setLastName(modifiedValue); }
            else if(originalValue.equals(this.getMajor())) {this.setMajor(modifiedValue); }
            else {
                Set<String> skillsTemp = this.getSkills();
                if(skillsTemp.contains(originalValue)) {
                    skillsTemp.remove(originalValue);
                    skillsTemp.add(modifiedValue);
                }
                this.setSkills(skillsTemp);
                
               
            }
        }
    }
    
    /**
     * notifyAll is the method used to notify
     * @param Event and String Line
     * @return no
     * @author  Shrijeet Rupnar
     * @version 1.0
     * @since   07-10-2020
     */

    @Override
    public void notifyAll(Event e, String line) {
    	
        for(StudentRecord observer : observers) {
            observer.update(e, line);
        }
    }

    
    /**
     * clone is the method used to clone
     * @param no
     * @return no
     * @author  Shrijeet Rupnar
     * @version 1.0
     * @since   07-10-2020
     */
    @Override
    public Object clone() {
        return new StudentRecord(bNumber, firstName, lastName, gpa, major, skills);
//        return this;
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
