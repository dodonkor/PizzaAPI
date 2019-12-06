/**
 * 
 */
package strategy;

import wrapper.PizzeriaConfigAPI;
import comms.Command;
import comms.Response;
import exceptions.CustomExceptionFactory;

/**
 * @author dodonkor
 *
 */
public class AddOptionStrategy implements StrategyHandler {

	/* (non-Javadoc)
	 * @see strategy.StrategyHandler#execute(comms.Command, wrapper.PizzeriaConfigAPI)
	 */
	@Override
	public Response execute(Command cmd, PizzeriaConfigAPI api) {
		
		try {
			api.addOptions(cmd.getArray()[0], cmd.getArray()[1], cmd.getArray()[2]);
			return new Response(cmd.getCommand(), "Option has been add to "+cmd.getArray()[1], null,
					null);
		} catch (CustomExceptionFactory e) {
			e.printStackTrace();
		}
		return null;
	}

}
