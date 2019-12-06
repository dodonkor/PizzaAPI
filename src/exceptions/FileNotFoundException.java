/**
 * 
 */
package exceptions;

/**
 * @author dodonkor
 *
 */
public class FileNotFoundException extends Exception implements
		CustomExceptionHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see exceptions.CustomExceptionHandler#fix()
	 */
	@Override
	public void fix() {
		

	}

	/* (non-Javadoc)
	 * @see exceptions.CustomExceptionHandler#printMessage()
	 */
	@Override
	public void printMessage() {
	}

}
