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
public interface UpdatePizzeria {
	/**
	 * @param pizzeriaName
	 * @param newPizzeriaName
	 * @throws Exception
	 */
	void updatePizzeriaName(String pizzeriaName, String newPizzeriaName)throws Exception;
	/**
	 * @param pizzeriaName
	 * @param optionSetname
	 * @param newName
	 * @throws Exception
	 */
	void updateOptionSetname(String pizzeriaName, String optionSetname, String newName)throws Exception;
	/**
	 * @param pizzeriaName
	 * @param newPrice
	 * @throws Exception
	 */
	void updateBasePrice(String pizzeriaName, double newPrice)throws Exception;
	/**
	 * @param pizzeriaName
	 * @param OptionSetname
	 * @param OptionName
	 * @param newPrice
	 * @throws Exception
	 */
	void updateOptionPrice(String pizzeriaName, String OptionSetname, String OptionName, double newPrice)throws Exception;
	/**
	 * @param pizzeriaName
	 * @param OptionSetname
	 * @param OptionName
	 * @param newOptionName
	 * @throws Exception
	 */
	void updateOptionName(String pizzeriaName, String OptionSetname, String OptionName, String newOptionName)throws Exception;
	
}
