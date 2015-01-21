package edu.gatech.oad.antlab.person;

/**
 *  A simple class for person 1
 *  returns their name and a
 *  modified string 
 *  
 *  @author Bob
 *  @version 1.1
 */
public class Person1 {
  /** Holds the persons real name */
  private String name;
  	/**
	 * The constructor, takes in the persons
	 * name
	 * @param pname the person's real name
	 */
  public Person1(String pname) {
    name = pname;
  }
  	/**
	 * This method should take the string
	 * input and return its characters rotated
	 * 2 positions.
	 * given "gtg123b" it should return
	 * "g123bgt".
	 *
	 * @param input the string to be modified
	 * @return the modified string
	 */
	private String calc(String input) {
        //Person 1 put your implementation here
        String str1 = "";
        String str2 = "";
<<<<<<< HEAD
        String cat = "";
        String cat2 = "";
        String add1 = "";
        String add2 = "";
        
        for (int i = 1; i < input.length(); i++) {
            cat =  input.substring(0,0);
            add1 = input.substring(i,i);
            str1 = str1 + add1;
        }
        
        str1 = str1 + cat;
        
        for (int j = 1; j< str1.length(); j++) {
            cat2 = str1.substring(0,0);
            add2 = str1.substring(j,j);
            str2 = str2 + add2;
        } 
        
        str2 = str2 + cat2;
=======
        
        //first rotate
        str1 = input.substring(1, input.length());
        str1 += input.charAt(0);
        
        //second rotate
        str2 = str1.substring(1, str1.length());
        str2 += str1. charAt(0);
>>>>>>> Chelsi
        
        return str2;
	}
	
	/**
	 * Return a string rep of this object
	 * that varies with an input string
	 *
	 * @param input the varying string
	 * @return the string representing the 
	 *         object
	 */
	public String toString(String input) {
	  return name + calc(input);
	}

}
