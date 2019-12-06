/**
 * 
 */
package strategy;

import java.util.Properties;
import model.PizzaConfig;
import wrapper.PizzeriaConfigAPI;
import comms.Command;
import comms.Response;
import exceptions.CustomExceptionFactory;

/**
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * @author Derrick Odonkor
 * 
 */
public class FileStrategy implements StrategyHandler {

	
	/* (non-Javadoc)
	 * @see strategy.StrategyHandler#execute(comms.Command)
	 */
	@Override
	public Response execute(Command cmd, PizzeriaConfigAPI api) {
		
		Properties props = cmd.getProperty();
		
		String pizzeriaName = props.getProperty("Pizzeria");
		
		if (!pizzeriaName.equals(null)) {
			double baseprice = Double.parseDouble(props.getProperty("BasePrice"));
			String optionset1 = props.getProperty("1stOptionSet");
			String optionValue1a = props.getProperty("OptionValue1a");
			String OptionValue1b = props.getProperty("OptionValue1b");

			String optionset2 = props.getProperty("2ndOptionSet");
			String optionValue2a = props.getProperty("OptionValue2a");
			String OptionValue2b = props.getProperty("OptionValue2b");

			String optionset3 = props.getProperty("3rdOptionSet");
			String optionValue3a = props.getProperty("OptionValue3a");
			String OptionValue3b = props.getProperty("OptionValue3b");

			String optionset4 = props.getProperty("4thOptionSet");
			String optionValue4a = props.getProperty("OptionValue4a");
			String OptionValue4b = props.getProperty("OptionValue4b");

			
			try {
				api.configurePizzeria(pizzeriaName, new PizzaConfig(pizzeriaName, baseprice));
				
				api.createOptionSet(pizzeriaName, optionset1);				
				api.addOptions(pizzeriaName, optionset1, optionValue1a);
				api.addOptions(pizzeriaName, optionset1, OptionValue1b);

				
				api.createOptionSet(pizzeriaName, optionset2);				
				api.addOptions(pizzeriaName, optionset2, optionValue2a);
				api.addOptions(pizzeriaName, optionset2, OptionValue2b);
				
				api.createOptionSet(pizzeriaName, optionset3);				
				api.addOptions(pizzeriaName, optionset3, optionValue3a);
				api.addOptions(pizzeriaName, optionset3, OptionValue3b);
				
				api.createOptionSet(pizzeriaName, optionset4);				
				api.addOptions(pizzeriaName, optionset4, optionValue4a);
				api.addOptions(pizzeriaName, optionset4, OptionValue4b);		
				
				return new Response(cmd.getCommand(),"Pizzeria created", null, null);
				
			} catch (CustomExceptionFactory e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
}
