/**
 * 
 */
package wrapper;

import model.*;
import exceptions.*;
import java.io.*;
import java.util.*;

/**
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor
 * received unauthorized assistance on this work.
 * 
 * @author Derrick Odonkor This class runs all the test classes
 */
public abstract class ProxyPizzerias {

	/**
	 * 
	 */
	private static LinkedHashMap<String, PizzaConfig> configs = new LinkedHashMap<String, PizzaConfig>();

	int counter = 1;

	public static LinkedHashMap<String, PizzaConfig> getConfigs() {
		return configs;
	}

	/**
	 * @param filename
	 * @throws IOException
	 * @throws Exception
	 */
	// public void configurePizzeria(String filename) throws IOException {
	// FileConfig file = new FileConfig();
	// file.buildPizzaConfig(filename);
	// }

	/**
	 * @param filename
	 * @throws IOException
	 * @throws Exception
	 */
	public boolean configurePizzeria(String pizzerianame, PizzaConfig config) {
		configs.put(pizzerianame, config);
		return true;
	}

	//
	/**
	 * @param pizzeriaName
	 * @throws CustomExceptionFactory
	 */
	public void printPizzeria(String pizzeriaName)
			throws CustomExceptionFactory {
		System.out.println("Searching for " + pizzeriaName);
		PizzaConfig foundConfig = findPizzeriaName(pizzeriaName);
		if (foundConfig != null) {
			foundConfig.displayPizzeria();
		} else {
			throw new CustomExceptionFactory();
		}

	}

	/**
	 * @param pizzeriaName
	 * @throws CustomExceptionFactory
	 */
	public void printPizzerias() throws CustomExceptionFactory {

		Iterator<Map.Entry<String, PizzaConfig>> entry = configs.entrySet()
				.iterator();

		while (entry.hasNext()) {
			Map.Entry<String, PizzaConfig> temp = entry.next();
			temp.getValue().displayPizzeria();
		}

	}

	public ArrayList<String> showPizzerias() throws CustomExceptionFactory {
		ArrayList<String> list = new ArrayList<String>();
		Iterator<Map.Entry<String, PizzaConfig>> entry = configs.entrySet()
				.iterator();

		while (entry.hasNext()) {

			Map.Entry<String, PizzaConfig> temp = entry.next();
			list.add(temp.getValue().getPizzariaName());
			System.out.println("The list of p at Prox "
					+ temp.getValue().getPizzariaName());
		}

		return list;
	}
	
	public ArrayList<String> showOptionsets(String pizzeriaName) throws CustomExceptionFactory {
		ArrayList<String> list = new ArrayList<String>();
		
		PizzaConfig foundConfig = findPizzeriaName(pizzeriaName);
		if (foundConfig != null) {
			foundConfig.displayPizzeria();
			list.addAll(foundConfig.getOptionsets());
		} else {
			throw new CustomExceptionFactory();
		}
		return list;
	}

	/**
	 * @param pizzeriaName
	 * @param name
	 * @throws CustomExceptionFactory
	 */
	public void createOptionSet(String pizzeriaName, String name)
			throws CustomExceptionFactory {
		PizzaConfig foundConfig = findPizzeriaName(pizzeriaName);
		if (foundConfig != null) {
			if (foundConfig.findOptionSet(name) == null) {
				foundConfig.addOptionSet(name); // it throws a
			} else {
				throw new CustomExceptionFactory();
			}

		} else
			throw new CustomExceptionFactory();
	}

	//
	/**
	 * @param pizzeriaName
	 * @throws CustomExceptionFactory
	 */
	public void printOptionSet(String pizzeriaName)
			throws CustomExceptionFactory {
		PizzaConfig foundConfig = findPizzeriaName(pizzeriaName);
		if (foundConfig != null) {
			if (foundConfig.findOptionSet(pizzeriaName) != null) {
				foundConfig.displayOptionSet(); // it throws a
			} else {
				throw new CustomExceptionFactory();

			}

		} else
			throw new CustomExceptionFactory();
	}

	//
	/**
	 * @param pizzeriaName
	 * @param optionSetname
	 * @param optionName
	 * @param optionPrice
	 * @throws CustomExceptionFactory
	 */
	public void addOptions(String pizzeriaName, String optionSetname,
			String optionName, double optionPrice)
			throws CustomExceptionFactory {
		PizzaConfig foundConfig = findPizzeriaName(pizzeriaName);
		if (foundConfig != null) {
			foundConfig.addOptionSetOptions(optionSetname, optionName,
					optionPrice);
		} else
			throw new CustomExceptionFactory();
	}

	//
	/**
	 * @param pizzeriaName
	 * @param optionSetname
	 * @param optionName
	 * @throws CustomExceptionFactory
	 */
	public void addOptions(String pizzeriaName, String optionSetname,
			String optionName) throws CustomExceptionFactory {
		PizzaConfig foundConfig = findPizzeriaName(pizzeriaName);
		if (foundConfig != null) {
			foundConfig.addOptionSetOptions(optionSetname, optionName);
		} else
			throw new CustomExceptionFactory();
	}

	/**
	 * @param pizzeriaName
	 * @param optionSetname
	 * @throws CustomExceptionFactory
	 */
	public void printOptions(String pizzeriaName, String optionSetname)
			throws CustomExceptionFactory {
		PizzaConfig foundConfig = findPizzeriaName(pizzeriaName);
		if (foundConfig != null) {
			foundConfig.displayOption(optionSetname);
		} else
			throw new CustomExceptionFactory();
	}

	//
	/**
	 * @param pizzeriaName
	 * @param newPizzeriaName
	 * @throws CustomExceptionFactory
	 */
	public void updatePizzeriaName(String pizzeriaName, String newPizzeriaName)
			throws CustomExceptionFactory {
		PizzaConfig foundConfig = findPizzeriaName(pizzeriaName);
		if (foundConfig != null) {
			foundConfig.setPizzariaName(newPizzeriaName);
		} else
			throw new CustomExceptionFactory();
	}

	//
	/**
	 * @param pizzeriaName
	 * @param optionSetname
	 * @param newName
	 * @throws CustomExceptionFactory
	 */
	public void updateOptionSetname(String pizzeriaName, String optionSetname,
			String newName) throws CustomExceptionFactory {
		PizzaConfig foundConfig = findPizzeriaName(pizzeriaName);
		if (foundConfig != null) {
			foundConfig.updateOptionSetNameByFind(optionSetname, newName);
		} else
			throw new CustomExceptionFactory();
	}

	//
	/**
	 * @param pizzeriaName
	 * @param newPrice
	 * @throws CustomExceptionFactory
	 */
	public void updateBasePrice(String pizzeriaName, double newPrice)
			throws CustomExceptionFactory {
		PizzaConfig foundConfig = findPizzeriaName(pizzeriaName);
		if (foundConfig != null) {
			foundConfig.setBasePrice(newPrice);
		} else
			throw new CustomExceptionFactory();
	}

	/**
	 * @param pizzeriaName
	 * @param OptionSetname
	 * @param OptionName
	 * @param newPrice
	 * @throws CustomExceptionFactory
	 */
	public void updateOptionPrice(String pizzeriaName, String OptionSetname,
			String OptionName, double newPrice) throws CustomExceptionFactory {
		PizzaConfig foundConfig = findPizzeriaName(pizzeriaName);
		if (foundConfig != null) {
			foundConfig.updateOptionPriceByFind(OptionSetname, OptionName,
					newPrice);
		} else
			throw new CustomExceptionFactory();
	}

	//
	/**
	 * @param pizzeriaName
	 * @param OptionSetname
	 * @param OptionName
	 * @param newOptionName
	 * @throws CustomExceptionFactory
	 */
	public void updateOptionName(String pizzeriaName, String OptionSetname,
			String OptionName, String newOptionName)
			throws CustomExceptionFactory {
		PizzaConfig foundConfig = findPizzeriaName(pizzeriaName);
		if (foundConfig != null) {
			foundConfig.updateOptionNameByFind(OptionSetname, OptionName,
					newOptionName);
		} else
			throw new CustomExceptionFactory();
	}

	public PizzaConfig deletePizzeria(String pizzeriaName)
			throws CustomExceptionFactory {
		PizzaConfig foundConfig = findPizzeriaName(pizzeriaName);
		if (foundConfig != null) {
			
			return configs.remove(pizzeriaName);
		} else
			throw new CustomExceptionFactory();

	}

	/**
	 * @param pizzeriaName
	 * @param optionSetname
	 * @throws CustomExceptionFactory
	 * @throws Exception
	 */
	public void deleteOptionSet(String pizzeriaName, String optionSetname)
			throws CustomExceptionFactory {
		PizzaConfig foundConfig = findPizzeriaName(pizzeriaName);
		if (foundConfig != null) {
			foundConfig.deleteOptionSet(optionSetname);
		} else
			throw new CustomExceptionFactory();

	}

	//
	/**
	 * @param pizzeriaName
	 * @param optionSetname
	 * @param optionName
	 * @throws CustomExceptionFactory
	 */
	public void deleteOption(String pizzeriaName, String optionSetname,
			String optionName) throws CustomExceptionFactory {
		PizzaConfig foundConfig = findPizzeriaName(pizzeriaName);
		if (foundConfig != null) {
			foundConfig.deleteOptionSet(optionSetname);
		} else
			throw new CustomExceptionFactory();
	}

	/**
	 * @param pizzeriaKey
	 * @return
	 */
	public PizzaConfig findPizzeriaKey(String pizzeriaKey) {
		if (configs.containsKey(pizzeriaKey)) {
			return configs.get(pizzeriaKey);
		}
		return null;

	}

	public PizzaConfig findPizzeriaName(String pizzeriaName) {
		PizzaConfig temp = null;

		Iterator<Map.Entry<String, PizzaConfig>> entry = configs.entrySet()
				.iterator();

		while (entry.hasNext()) {
			Map.Entry<String, PizzaConfig> temp2 = entry.next();
			PizzaConfig value = temp2.getValue();
			if (value.getPizzariaName().equals(pizzeriaName)) {
				temp = value;
			}
		}

		return temp;

	}
}
