package model;

import java.io.*;
import java.util.*;

import exceptions.*;

/**
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor
 * received unauthorized assistance on this work.
 * 
 * @author Derrick Odonkor This class creates a pizza configuration making use
 *         of the optionset class
 */
public class PizzaConfig implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private double basePrice;
	private ArrayList<OptionSet> options;
	private int numOptionSet = 0;

	
	/**
	 * Constructor that sets the name and array size through the parameters and
	 * initializes the base price to 2000
	 * 
	 * @param n
	 * @param maxOptionSets
	 */
	public PizzaConfig(String n, int maxOptionSets) {
		name = n;
		basePrice = 0;
		options = new ArrayList<OptionSet>(maxOptionSets);
	}

	/**
	 * Constructor that sets the name, array, and base price through the
	 * parameters
	 * 
	 * @param n
	 * @param baseprice
	 * @param maxOptionSets
	 */
	public PizzaConfig(String n, double baseprice) {
		name = n;
		basePrice = baseprice;
		options = new ArrayList<OptionSet>();
	}

	/**
	 * Getter that returns the name of the pizzaria
	 * 
	 * @return
	 */
	public String getPizzariaName() {
		return name;
	}

	/**
	 * Getter that returns the base price of the pizzaria
	 * 
	 * @return
	 */
	public double getBasePrice() {
		return basePrice;
	}

	/**
	 * Getter that returns the number of optionsets in the array
	 * 
	 * @return
	 */
	public int getNumOptionSet() {
		return numOptionSet;
	}
	
	public ArrayList<String> getOptionsets()
	{
		ArrayList<String> list = new ArrayList<String>();
		
		for (int i = 0; i<options.size(); i++) 
		{
			list.add(options.get(i).getOptionSetName());
			
		}
		
		return list;
	}

	/**
	 * Setter that updates the name of the pizzaria
	 * 
	 * @param newname
	 */
	public void setPizzariaName(String newname) {
		name = newname;
	}

	/**
	 * Setter that updates the base price of the pizzaria
	 * 
	 * @param newbprice
	 * @throws Exception
	 * @throws WrongBasePriceException
	 */
	public void setBasePrice(double newbprice) throws CustomExceptionFactory {
		if (newbprice > 0)
			basePrice = newbprice;
		else
			throw new CustomExceptionFactory();
	}

	/**
	 * Setter that updates the number of optionsets available in the pizzaria
	 * 
	 * @param numset
	 */
	public void setNumOptionSet(int numset) {
		numOptionSet = numset;
	}



	/**
	 * The function adds a new optionset to the list
	 * 
	 * @param name
	 * @throws CustomExceptionFactory 
	 */
	public void addOptionSet(String name) throws CustomExceptionFactory {
		if (findOptionSet(name) == null) {
			options.add(new OptionSet(name));
			numOptionSet++;
		} else {
			 throw new CustomExceptionFactory();
		}

	}

	/**
	 * The function adds a new option to the an optionset
	 * 
	 * @param optset
	 * @param optname
	 * @param price
	 * @throws OptionDupException
	 * @throws NotFoundException
	 */
	public synchronized void addOptionSetOptions(String optset, String optname, double price)
			throws CustomExceptionFactory {
		OptionSet optsetname = findOptionSet(optset);
		if (optsetname != null) {
			if (optsetname.findOption(optname) == null) {
				optsetname.addOption(optname, price);
				System.out.println("An option \"" + optname
						+ "\" has been added with price " + price);
			} else {
				throw new CustomExceptionFactory();
			}
		} else {
			throw new CustomExceptionFactory();
		}
	}

	/**
	 * The function adds a new option to the an optionset
	 * 
	 * @param optset
	 * @param optname
	 * @throws OptionDupException
	 * @throws NotFoundException
	 */
	public synchronized void addOptionSetOptions(String optset, String optname)
			throws CustomExceptionFactory {
		OptionSet optsetname = findOptionSet(optset);
		if (optsetname != null) {
			if (optsetname.findOption(optname) == null) {
				optsetname.addOption(optname);
				System.out.println("An option \"" + optname
						+ "\" has been added with a default price of 0");
			} else {
				throw new CustomExceptionFactory();
			}
		} else {
			throw new CustomExceptionFactory();
		}
	}

	/**
	 * The function finds an optionset by name
	 * 
	 * @param name
	 * @return
	 */
	public synchronized OptionSet findOptionSet(String name) {
		OptionSet found = null;
		for (int i = 0; i < numOptionSet; i++) {
			if (options.get(i).getOptionSetName().equals(name)) {
				found = options.get(i);
				break;
			}
		}
		return found;
	}

	/**
	 * The function updates the name of an optionset
	 * 
	 * @param oldname
	 * @param newname
	 * @throws NotFoundException
	 */
	public synchronized void updateOptionSetNameByFind(String oldname, String newname)
			 {
		OptionSet temp = findOptionSet(oldname);
		if (temp != null) {
			temp.setOptionSetName(newname);
			System.out.println("The optionset's name has been updated with \""
					+ newname + "\"");
		} else {
//			throw new CustomExceptionFactory();
		}
	}

	/**
	 * The function updates an option's price of a particular optionset
	 * 
	 * @param optset
	 * @param optname
	 * @param newprice
	 * @throws NotFoundException
	 */
	public synchronized void updateOptionPriceByFind(String optset, String optname,
			double newprice) throws CustomExceptionFactory {
		OptionSet temp = findOptionSet(optset);
		if (temp != null) {
			if (temp.findOption(optname) != null) {
				temp.findOption(optname).setOptionPrice(newprice);
				System.out.println("The option \"" + optname
						+ "\" has been updated with new price; " + newprice);
			} else {
				 throw new CustomExceptionFactory();
			}
		} else {
			 throw new CustomExceptionFactory();
		}
	}

	/**
	 * The function updates an option's name of a particular optionset
	 * 
	 * @param optset
	 * @param optname
	 * @param newname
	 * @throws NotFoundException
	 */
	public void updateOptionNameByFind(String optset, String optname,
			String newname) throws CustomExceptionFactory {
		OptionSet temp = findOptionSet(optset);
		if (temp != null) {
			if (temp.findOption(optname) != null) {
				temp.findOption(optname).setOptionName(newname);
				System.out.println("The option \"" + optname
						+ "\" has been updated the new name; " + newname);
			} else {
				 throw new CustomExceptionFactory();
			}
		} else {
			 throw new CustomExceptionFactory();
		}
	}

	/**
	 * The function deletes a particular optionset
	 * 
	 * @param optset
	 * @throws NotFoundException
	 * @throws CustomExceptionFactory 
	 */
	public synchronized void deleteOptionSet(String optset) throws CustomExceptionFactory {
		// Check if the list is empty
		if (options.isEmpty()) {
			// throw is empty exception
			 throw new CustomExceptionFactory();
		} else {
			for (int i = 0; i < numOptionSet; i++) {
				if (options.get(i).getOptionSetName().equals(optset)) {

					options.remove(i);
					numOptionSet--;
					System.out.println("The optionset \"" + optset
							+ "\" has been deleted.");
					break;
				} else if (i == numOptionSet) {
					// throw not found exception to custom exception
					 throw new CustomExceptionFactory();
				}
			}
		}

	}

	/**
	 * The function deletes an option of a particular optionset
	 * 
	 * @param optset
	 * @param optname
	 * @throws NotFoundException
	 */
	public synchronized void deleteOption(String optset, String optname)
			throws CustomExceptionFactory {
		OptionSet temp = findOptionSet(optset);
		if (temp != null) {
			temp.deleteOptionNameByFind(optname);
		} else {
			throw new CustomExceptionFactory();
		}

	}

	/**
	 * The function displays the optionset of a Pizzaria
	 * @throws CustomExceptionFactory 
	 * 
	 * @throws NotFoundException
	 */
	public void displayOptionSet() throws CustomExceptionFactory  {
		System.out.println("******************************************");
		if (this.getNumOptionSet() > 0) {
			System.out.println("\nThese are :");
			for (int i = 0; i < numOptionSet; i++) {
				System.out.println(options.get(i).toString());
				displayOption(options.get(i).getOptionSetName());
			}
		}
		System.out.println("******************************************");
	}

	/**
	 * The function displays all the options of a particular optionset
	 * 
	 * @param name
	 * @throws CustomExceptionFactory 
	 * @throws NotFoundException
	 */
	public void displayOption(String name) throws CustomExceptionFactory  {
		OptionSet temp = findOptionSet(name);
		if (temp != null) {
			temp.displayOptions();
		} else {
			 throw new CustomExceptionFactory();
		}
	}

	public void displayPizzeria() throws CustomExceptionFactory {
		if (this != null) {
			System.out.println(toString());
			displayOptionSet();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuffer opt = new StringBuffer();
		opt.append("Pizzaria name: " + getPizzariaName() + "\nBase price: "
				+ getBasePrice() + "\nNumber of Options: " + getNumOptionSet());
		return opt.toString();
	}

}
