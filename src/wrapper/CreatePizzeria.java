/**
 * 
 */
package wrapper;

import model.PizzaConfig;

/**
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor
 * received unauthorized assistance on this work.
 * 
 * @author Derrick Odonkor This class runs all the test classes
 */
public interface CreatePizzeria {
	/**
	 * @param filename
	 */
	boolean configurePizzeria(String pizzerianame, PizzaConfig config);
	/**
	 * @param pizzeriaName
	 * @throws Exception
	 */
	void printPizzeria(String pizzeriaName)throws Exception;
	

	/**
	 * @param pizzeriaName
	 * @param name
	 * @throws Exception
	 */
	void createOptionSet(String pizzeriaName, String name)throws Exception;
	/**
	 * @param pizzeriaName
	 * @throws Exception
	 */
	void printOptionSet(String pizzeriaName)throws Exception;
	
	/**
	 * @param pizzeriaName
	 * @param optionSetname
	 * @param optionName
	 * @param optionPrice
	 * @throws Exception
	 */
	void addOptions(String pizzeriaName, String optionSetname, String optionName, double optionPrice)throws Exception;
	/**
	 * @param pizzeriaName
	 * @param optionSetname
	 * @param optionName
	 * @throws Exception
	 */
	void addOptions(String pizzeriaName, String optionSetname, String optionName)throws Exception;
	/**
	 * @param pizzeriaName
	 * @param optionSetname
	 * @throws Exception
	 */
	public void printOptions(String pizzeriaName, String optionSetname)throws Exception;
	
}
