/**
 * 
 */
package comms;

import java.io.Serializable;
import java.util.*;

import model.PizzaConfig;

/**
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * @author Derrick Odonkor
 * 
 */
public class Response implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CommandList confirmcom = null;
	String feedback = null;
	ArrayList<String> piz = null;
	PizzaConfig pizzaconfig = null;

	/**
	 * @param cmd
	 * @param response
	 * @param list
	 * @param pC
	 */
	public Response(CommandList cmd, String response, ArrayList<String> list, PizzaConfig pC) {
		confirmcom = cmd;
		feedback = response;
		piz = list;
		pizzaconfig = pC;
	}

	/**
	 * @return
	 */
	public CommandList getCommand() {
		return confirmcom;
	}

	/**
	 * @return
	 */
	public String getFeedback() {
		return feedback;
	}

	/**
	 * @return
	 */
	public ArrayList<String> getList() {
		return piz;
	}
	
	/**
	 * @return
	 */
	public PizzaConfig getPizzaConfig() {
		return pizzaconfig;
	}

	/**
	 * @param cmd
	 */
	public void setCommand(CommandList cmd) {
		confirmcom = cmd;
	}

	/**
	 * @param fedb
	 */
	public void setFeedback(String fedb) {
		feedback = fedb;
	}

	/**
	 * @param list
	 */
	public void setList(ArrayList<String> list) {
		piz = list;
	}
	
	/**
	 * @param pC
	 */
	public void setPizzaConfig(PizzaConfig pC) {
		pizzaconfig = pC;
	}
}
