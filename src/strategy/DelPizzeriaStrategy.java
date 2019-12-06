/**
 * 
 */
package strategy;

import wrapper.PizzeriaConfigAPI;
import comms.Command;
import comms.Response;
import exceptions.CustomExceptionFactory;

/**
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * @author Derrick Odonkor
 * 
 */
public class DelPizzeriaStrategy implements StrategyHandler {

	/* (non-Javadoc)
	 * @see strategy.StrategyHandler#execute(comms.Command)
	 */
	@Override
	public Response execute(Command cmd, PizzeriaConfigAPI api) {
		try {
			return new Response(cmd.getCommand(), cmd.getArray()[0]
					+ " has been deleted.", null,
					api.deletePizzeria(cmd.getArray()[0]));
		} catch (CustomExceptionFactory e) {
			e.printStackTrace();
		}
		return null;
	}

}
