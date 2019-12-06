/**
 * 
 */
package protocol;

import strategy.*;
import wrapper.PizzeriaConfigAPI;
import comms.Command;
import comms.Response;

/**
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * @author Derrick Odonkor
 * 
 */
public class ProtocolFactory {
	


	public Response getProtocol(int id, Command cmd, PizzeriaConfigAPI api) {
		switch (id) {
		case 1:
			Context fs = new Context(new ProtocolOne<Object>(cmd, api));
			return fs.executeStrategy();

		default:
			return null;
		}
	}
}
