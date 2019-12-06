/**
 * 
 */
package io;

import model.*;

import java.io.*;
import java.util.Properties;

import exceptions.CustomExceptionFactory;
import wrapper.PizzeriaConfigAPI;
import wrapper.ProxyPizzerias;

/**
 * @author dodonkor
 * 
 */
public class FileConfig {
	PizzeriaConfigAPI pizzeria;

	/**
	 * 
	 */
	public FileConfig() {
		pizzeria = PizzeriaConfigAPI.getInstance();
	}

	/**
	 * Reads the list of pizzerias from a file and passes the data to another
	 * function to configure the pizzeria
	 * 
	 * @param filename
	 * @throws IOException
	 */
	public void buildPizzaConfig(String filename) throws IOException {

		BufferedReader buff = null;

		try {
			FileReader file = new FileReader(filename);
			buff = new BufferedReader(file);
			String line;

			line = buff.readLine();
			while (line != null) {
				String[] temp = line.split("\\*\\*");

				if (temp[0] != null) {
					determinate(temp);
				}
				line = buff.readLine();
			}

		} catch (IOException e) {
			System.out.println("Error " + e.toString());
		} finally {
			buff.close();
		}

	}

	/**
	 * Reads the list of pizzerias from a file and passes the data to another
	 * function to configure the pizzeria
	 * 
	 * @param filename
	 * @throws IOException
	 */
	public Properties buildPizzaConfigProp(String filename) throws IOException  {
		Properties props = new Properties();
		FileInputStream in = new FileInputStream(filename);
		props.load(in);

		return props;
	}

	public PizzaConfig readPropfile() {
		Properties props = null;
		 try
	        {    
	            // Reading the object from a file 
	            FileInputStream file = new FileInputStream("pizzaconfig.dat"); 
	            ObjectInputStream in = new ObjectInputStream(file); 
	              
	            // Method for deserialization of object 
	            props = (Properties)in.readObject(); 
	              
	            in.close(); 
	            file.close();
	        } 
	          
	        catch(IOException ex) 
	        { 
	            System.out.println("IOException is caught"); 
	        } 
	          
	        catch(ClassNotFoundException ex) 
	        { 
	            System.out.println("ClassNotFoundException is caught"); 
	        } 

		String pizzaConfigname = props.getProperty("Pizzeria");
		PizzaConfig pizzaconfig = null;
		if (!pizzaConfigname.equals(null)) {
			double baseprice = Double.parseDouble(props.getProperty("BasePrice"));
			String optionset1 = props.getProperty("1stOptionSet");
			String optionValue1a = props.getProperty("OptionValue1a");
			String OptionValue1b = props.getProperty("OptionValue1b");

			String optionset2 = props.getProperty("2ndOptionSet");
			String optionValue2a = props.getProperty("OptionValue2a");
			String OptionValue2b = props.getProperty("OptionValue2b");

			String optionset3 = props.getProperty("3rdOptionSet");
			String optionValue3a = props.getProperty("OptionValue3a");
			String OptionValue3b = props.getProperty("OptionValue3b");

			String optionset4 = props.getProperty("4thOptionSet");
			String optionValue4a = props.getProperty("OptionValue4a");
			String OptionValue4b = props.getProperty("OptionValue4b");

			pizzaconfig = new PizzaConfig(pizzaConfigname, baseprice);
			

			try {
				pizzaconfig.addOptionSet(optionset1);

				pizzaconfig.addOptionSetOptions(optionset1, optionValue1a);
				pizzaconfig.addOptionSetOptions(optionset1, OptionValue1b);

				pizzaconfig.addOptionSet(optionset2);
				pizzaconfig.addOptionSetOptions(optionset2, optionValue2a);
				pizzaconfig.addOptionSetOptions(optionset2, OptionValue2b);

				pizzaconfig.addOptionSet(optionset3);
				pizzaconfig.addOptionSetOptions(optionset3, optionValue3a);
				pizzaconfig.addOptionSetOptions(optionset3, OptionValue3b);

				pizzaconfig.addOptionSet(optionset4);
				pizzaconfig.addOptionSetOptions(optionset4, optionValue4a);
				pizzaconfig.addOptionSetOptions(optionset4, OptionValue4b);
			} catch (CustomExceptionFactory e) {
				e.printStackTrace();
			}
		}

		return pizzaconfig;
	}

	/**
	 * Configures the linkedhashmap of pizzerias by checking the first item in
	 * the array and then performing the right functionalities
	 * 
	 * @param array
	 */
	private void determinate(String array[]) {

		switch (array[0]) {
		case "PizzeriaName":
			try {
				if (pizzeria.findPizzeriaName(array[2]) == null) {
					ProxyPizzerias.getConfigs().put(
							array[1],
							new PizzaConfig(array[2], Double
									.parseDouble(array[3])));
				}
			} catch (NumberFormatException e) {

			}
			break;
		case "Optionset":
			try {
				pizzeria.createOptionSet(array[1], array[2]);
			} catch (CustomExceptionFactory e) {
				// TODO Auto-generated catch block
				e.getException("OptionsetDuplicate").printMessage();
			}
			break;
		case "Option":
			try {
				pizzeria.addOptions(array[1], array[2], array[3],
						Double.parseDouble(array[4]));
			} catch (CustomExceptionFactory e) {
				// TODO Auto-generated catch block
				e.getException("NotFound").printMessage();
			}
			break;

		}
	}
}
