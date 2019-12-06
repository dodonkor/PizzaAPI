/**
 * 
 */
package strategy;

import wrapper.PizzeriaConfigAPI;
import comms.Command;
import comms.Response;

/**
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * @author Derrick Odonkor
 * 
 */
public interface StrategyHandler {
	public Response execute(Command cmd, PizzeriaConfigAPI api);
}
