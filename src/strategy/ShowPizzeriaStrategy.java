/**
 * 
 */
package strategy;

import java.util.ArrayList;

import wrapper.PizzeriaConfigAPI;
import comms.Command;
import comms.Response;
import exceptions.CustomExceptionFactory;
/**
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * @author Derrick Odonkor
 * 
 */
public class ShowPizzeriaStrategy implements StrategyHandler {

	/* (non-Javadoc)
	 * @see strategy.StrategyHandler#execute(comms.Command)
	 */
	@Override
	public Response execute(Command cmd, PizzeriaConfigAPI api) {
		try {
			ArrayList<String> list = api.showPizzerias();
			return new Response(cmd.getCommand(),"List of pizzerias are:", list, null);
		} catch (CustomExceptionFactory e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
