/**
 * 
 */
package client;

import comms.Command;

/**
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * @author Derrick Odonkor
 * 
 */
public interface PizzeriaClient {
	/**
	 * @param filepath
	 * @return
	 */
	Command readPropFile(String filepath);

	/**
	 * 
	 */
	void showPizzerias();

	/**
	 * @param name
	 */
	void printPizzeria(String name);
	
	/**
	 * @param name
	 */
	void delPizzeria(String name);
	
	/**
	 * 
	 */
	void configPizzeria();
}
