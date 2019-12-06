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
public class NegBasePriceException extends Exception implements CustomExceptionHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see exceptions.CustomExceptionHandler#fix()
	 */
	@Override
	public void fix() {
		// TODO Auto-generated method stub
		System.out.println("Negative Base price is fixed");
		
	}
	
	
	@Override
	public void printMessage() {
		// TODO Auto-generated method stub
		System.out.println("Negative Base price");
	}
}
