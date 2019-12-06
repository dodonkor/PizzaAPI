/**
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor
 * received unauthorized assistance on this work.
 * 
 * @author Derrick Odonkor This class runs all the test classes
 */

package exceptions;

public class CustomExceptionFactory extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomExceptionHandler getException(String excepcase) {
		switch (excepcase) {
		case "ZeroBasePrice":
			return new BasePriceException();
		case "BelowZeroBasePrice":
			return new NegBasePriceException();
		case "OptionDuplicate":
			return new OptionDupException();			
		case "OptionsetDuplicate":
			return new OptionSetDupException();			
		case "NotFound":
			return new NotFoundException();
		default:
			return null;
		}
		
	}
}
