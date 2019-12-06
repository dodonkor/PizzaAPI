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
public class GetOptionSetStrategy implements StrategyHandler {

	/* (non-Javadoc)
	 * @see strategy.StrategyHandler#execute(comms.Command, wrapper.PizzeriaConfigAPI)
	 */
	@Override
	public Response execute(Command cmd, PizzeriaConfigAPI api) {
		try {
			return new Response(cmd.getCommand(), "The List of Options are :", api.showOptionsets(cmd.getArray()[0]),
					null);
		} catch (CustomExceptionFactory e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
