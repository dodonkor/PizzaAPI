/**
 * 
 */
package comms;

import java.io.*;
import java.util.Properties;

/**
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * @author Derrick Odonkor
 * 
 */
public class Command implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CommandList command = null;
	
	Properties properties = null;
	String[] pizdata = new String[3]; //This is to store any additional data like pizzeria name, optionset name or option name
	double baseprice = 0;
	/**
	 * @param cmd
	 * @param obj
	 * @param pizzerianame
	 * @param optionsetname
	 * @param optionname
	 */
	public Command(CommandList cmd, Properties obj, String pizzerianame, String optionsetname, String optionname, double baseprice) {
		command = cmd;
		properties = obj;
		pizdata[0] = pizzerianame;
		pizdata[1] = optionsetname;
		pizdata[2] = optionname;
		this.baseprice = baseprice;
	}
	
	/**
	 * @return
	 */
	public CommandList getCommand()
	{
		return command;
	}
	
	/**
	 * @return
	 */
	public Properties getProperty()
	{
		return properties;
	}
	
	/**
	 * @return
	 */
	public String[] getArray()//Get array of data
	{
		return pizdata;
	}
	
	public double getBasePrice()
	{
		return baseprice;
	}
	
	/**
	 * @param cmd
	 */
	public void setCommand(CommandList cmd)
	{
		command = cmd;
	}
	
	/**
	 * @param obj
	 */
	public void setProperty(Properties obj)
	{
		properties = obj;
	}
	
	/**
	 * @param nm
	 */
	public void setPName(String nm)
	{
		pizdata[0] = nm;
	}
	
	/**
	 * @param nm
	 */
	public void setOPsetName(String nm)
	{
		pizdata[1] = nm;
	}
	
	/**
	 * @param nm
	 */
	public void setOPName(String nm)
	{
		pizdata[2] = nm;
	}
	
	public void setBasePrice(double b)
	{
		baseprice = b;
	}
}
