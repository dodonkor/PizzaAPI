package model;

import java.io.*;
import java.util.*;

/**
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * @author Derrick Odonkor
 * This class creates a set of options 
 */
class OptionSet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private ArrayList<Option> choices;
	private int totalOptionSize;

	/**
	 * Constructor that sets the name through the parameters and a default array size
	 * and total number of options
	 * @param name
	 */
	protected OptionSet(String name)
	{
		this.name = name;
		choices = new ArrayList<Option>();
		totalOptionSize = 0;
	}



	/**
	 * Constructor that sets the name and the array through the parameters 
	 * @param name
	 * @param choice
	 */
	protected OptionSet(String name, ArrayList<Option> choice)
	{
		this.name = name;
		choices = choice;
		totalOptionSize = choice.size();
	}

	/**
	 * This function returns the optionset's name
	 * @return
	 */
	protected String getOptionSetName()
	{
		return name;
	}

	/**
	 * This function returns an option from the optionset using a given index
	 * @param index
	 * @return
	 */
	protected Option getOption(int index)
	{
		return choices.get(index);
	}

	/**
	 * This function returns the total size of options in the optionset
	 * @return
	 */
	protected int getTotalOptionSize()
	{
		return totalOptionSize;
	}

	/**
	 * This function updates the number of options in the optionset
	 * @param newOptionSize
	 */
	protected void setTotalOptionSize(int newOptionSize)
	{
		totalOptionSize = newOptionSize;
	}

	/**
	 * This function updates the name of the name of the optionset
	 * @param name
	 */
	protected void setOptionSetName(String name)
	{
		this.name = name;
	}

	/**
	 * This function updates both the option name and price using the index of the option in the optionset
	 * @param index
	 * @param name
	 * @param price
	 */
	protected void setOption(int index, String name, double price)
	{
		choices.get(index).setOption(name, price);
	}

	/**
	 * This function updates an option name using the index of the option in the optionset
	 * @param index
	 * @param name
	 */
	protected void setOptionNameByIndex(int index, String name)
	{
		choices.get(index).setOptionName(name);
	}

	/**
	 * This function updates an option price using the index of the option in the array
	 * @param index
	 * @param price
	 */
	protected void setOptionPriceByIndex(int index, double price)
	{
		choices.get(index).setOptionPrice(price);
	}

	/**
	* CRUD functions
	*/
	/**
	 * This function adds an option to the list
	 * @param name
	 * @param price
	 */
	protected void addOption(String name, double price)
	{
		choices.add(new Option(name, price));
		totalOptionSize++;
	}

	/**
	 * This function adds an option to the list
	 * @param name
	 */
	protected void addOption(String name)
	{
		choices.add(new Option(name));
		totalOptionSize++;
	}


	/**
	 * This function finds an option by name
	 * @param name
	 * @return
	 */
	protected Option findOption(String name)
	{
		Option found = null;
		for (int i = 0; i<totalOptionSize; i++) 
		{
			if (choices.get(i).getOptionName().equals(name))
			{
				found = choices.get(i);
				break;
			}
		}
		return found;
	}

	/**
	 * This function updates an option name and price
	 * @param oldname
	 * @param newname
	 * @param price
	 */
	protected void updateOptionValuesByFind(String oldname, String newname, double price)
	{
		findOption(oldname).setOption(newname, price);
	}

	/**
	 * This function updates an option price
	 * @param oldname
	 * @param newprice
	 */
	protected void updateOptionPriceByFind(String oldname, double newprice)
	{
		findOption(oldname).setOptionPrice(newprice);
	}

	/**
	 * This function updates an option name
	 * @param oldname
	 * @param newname
	 */
	protected void updateOptionNameByFind(String oldname, String newname)
	{
		findOption(oldname).setOptionName(newname);
	}

	/**
	 * This function deletes an option from the array
	 * @param optname
	 */
	protected void deleteOptionNameByFind(String optname)
	{
		
		//if list is empty 
		if(choices.isEmpty())
		{
			//throw isempty exception			
		}
		else//if not look for the item 
		{
			for (int i = 0; i<totalOptionSize; i++) 
			{
				if (choices.get(i).getOptionName().equals(optname))//if found 
				{
					choices.remove(i); //delete it
					totalOptionSize--; //Decrease the number of options 
					System.out.println("The option \""+optname+"\" has been deleted.");
					break;
				}
				else if (i == totalOptionSize)//if not throw notfound exception and break
				{
					
					break;
				}
			}
		}		
	}


	/**
	 * This function displays all the options in the an optionset
	 */
	protected void displayOptions()
	{
		System.out.println("******************************************");
		System.out.println("Optionset name: "+ getOptionSetName()+".\nIt has "+getTotalOptionSize()+" Option(s)");
		
		if (this.getTotalOptionSize() >0 ) {
			System.out.println("\nThe list of Options are:");
			for (int i = 0; i<totalOptionSize ;i++ ) 
			{
				System.out.println(choices.get(i).toString());
			}
		}
		
		System.out.println("******************************************");
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		StringBuffer opt = new StringBuffer();
		opt.append("Name: " + getOptionSetName());
		return opt.toString();
	}



	/**
	 * 
	 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
	 * @author Derrick Odonkor
	 * This is an inner class which creates an option
	 */
	class Option implements Serializable
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String name;
		private double price;

		/**
		 * Constructor that sets the instance variables name and price
		 * @param name
		 * @param price
		 */
		protected Option(String name, double price)
		{
			this.name = name;
			this.price = price;
		}

		/**
		 * Constructor that sets the instance variable name and sets the price to zero
		 * @param name
		 */
		protected Option(String name)
		{
			this.name = name;
			this.price = 0;
		}

		/**
		 * Get method that returns the name of an option
		 * @return
		 */
		protected String getOptionName()
		{
			return name;
		}

		/**
		 * Get method that returns the price of an option
		 * @return
		 */
		protected double getOptionPrice()
		{
			return price;
		}

		/**
		 * Get method that sets the name of an option
		 * @param name
		 */
		protected void setOptionName(String name)
		{
			this.name = name;
		}

		/**
		 * Get method that sets the price of an option
		 * @param price
		 */
		protected void setOptionPrice(double price)
		{
			this.price = price;
		}
		/**
		 * Get method that sets both the name and price of an option
		 * @param name
		 * @param price
		 */
		protected void setOption(String name, double price)
		{
			this.name = name;
			this.price = price;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		public String toString()
		{
			StringBuffer opt = new StringBuffer();			
			opt.append("Name  : " + getOptionName() + "\nPrice : "+getOptionPrice());
			return opt.toString();
		}
	}
}
