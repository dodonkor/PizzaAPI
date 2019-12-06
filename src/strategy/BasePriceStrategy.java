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
public class BasePriceStrategy implements StrategyHandler {

	/* (non-Javadoc)
	 * @see strategy.StrategyHandler#execute(comms.Command, wrapper.PizzeriaConfigAPI)
	 */
	@Override
	public Response execute(Command cmd, PizzeriaConfigAPI api) {
		try {
			
			api.updateBasePrice(cmd.getArray()[0], cmd.getBasePrice());
			return new Response(cmd.getCommand(), "Baseprice has been updated.", null,
					null);
		} catch (CustomExceptionFactory e) {
			e.printStackTrace();
		}
		return null;
	}

}
