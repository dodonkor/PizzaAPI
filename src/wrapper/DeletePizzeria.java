/**
 * 
 */
package wrapper;

/**
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor
 * received unauthorized assistance on this work.
 * 
 * @author Derrick Odonkor This class runs all the test classes
 */
public interface DeletePizzeria {
	/**
	 * @param pizzeriaName
	 * @param optionSetname
	 * @throws Exception
	 */
	void deleteOptionSet(String pizzeriaName, String optionSetname) throws Exception;
	/**
	 * @param pizzeriaName
	 * @param optionSetname
	 * @param optionName
	 * @throws Exception
	 */
	void deleteOption(String pizzeriaName, String optionSetname, String optionName)throws Exception;
}
