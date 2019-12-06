/**
 * 
 */
package exceptions;

/**
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor
 * received unauthorized assistance on this work.
 * 
 * @author Derrick Odonkor This class runs all the test classes
 */
public class OptionDupException extends Exception implements CustomExceptionHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see exceptions.CustomExceptionHandler#fix()
	 */
	public void fix() {
		// TODO Auto-generated method stub
		System.out.println("Option duplicates found please rename");
	}
	
	@Override
	public void printMessage() {
		// TODO Auto-generated method stub
		System.out.println("Duplicates in option list.");
	}
	

}
