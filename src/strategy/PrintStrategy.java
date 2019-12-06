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
public class PrintStrategy implements StrategyHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategy.StrategyHandler#execute(comms.Command)
	 */
	@Override
	public Response execute(Command cmd, PizzeriaConfigAPI api) {

		return new Response(cmd.getCommand(), cmd.getArray()[0]
				+ " consists of :", null,
				api.findPizzeriaName(cmd.getArray()[0]));

	}

}
