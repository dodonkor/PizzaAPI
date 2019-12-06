/**
 * 
 */
package strategy;

import protocol.*;
import wrapper.PizzeriaConfigAPI;
import comms.*;

/**
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * @author Derrick Odonkor
 * 
 */
public class Context {

	private StrategyHandler strategy;
	ProtocolOne<Object> one = null;
	
	/**
	 * Constructor for the Strategy
	 * @param one
	 */
	public Context(ProtocolOne<Object> one) {
		this.one = one;
		strategy = getStrategy(((Command) one.getGencmd()).getCommand());
	}

	/**
	 * Getter for the Strategy
	 * @param cmd
	 * @return StrategyHandler
	 */
	public StrategyHandler getStrategy(CommandList cmd) {
		switch (cmd) {
		case UPL:
			return (new FileStrategy());
		case SHOWPIZZERRIAS:
			return (new ShowPizzeriaStrategy());

		case PRINTPIZZERIA:
			return (new PrintStrategy());

		case DEL:
			return (new DelPizzeriaStrategy());

		case CONFIG:
			return (new ConfigPizzeriaStrategy());
			
		case BASEPRICE:
			return (new BasePriceStrategy());
			
		case OPTIONSET:
			return (new GetOptionSetStrategy());
			
		case ADDOPTION:
			return (new AddOptionStrategy());
			
		case DISPLAYBASEPRICE:
			return (new PrintStrategy());

		default:
			return null;
		}
	}

	/**
	 * Executes the strategy
	 * @return
	 */
	public Response executeStrategy() {
		Command cmd = (Command) one.getGencmd();
		PizzeriaConfigAPI api = (PizzeriaConfigAPI) one.getGenapi();
		return strategy.execute(cmd, api);
	}
}
