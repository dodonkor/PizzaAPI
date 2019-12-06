/**
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor
 * received unauthorized assistance on this work.
 * 
 * @author Derrick Odonkor This class runs all the test classes
 */
package exceptions;


public class BasePriceException extends Exception implements CustomExceptionHandler {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	


	@Override
	public void fix() {
		// TODO Auto-generated method stub
		System.out.println("Base price is fixed");
		
	}
	
	
	@Override
	public void printMessage() {
		// TODO Auto-generated method stub
		System.out.println("Invalid Base price for a pizzeria");
	}


}
