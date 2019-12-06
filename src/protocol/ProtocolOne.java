/**
 * 
 */
package protocol;

import wrapper.PizzeriaConfigAPI;
import comms.Command;

/**
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * @author Derrick Odonkor
 * 
 */
public class ProtocolOne<T> implements PizzeriaInterface<T> {
	private T gencmd;
	private T genapi;
	
	@SuppressWarnings("unchecked")
	public ProtocolOne (Command cmds, PizzeriaConfigAPI api)
	{
		setGencmd((T) cmds);
		setGenapi((T) api);
	}
	/* (non-Javadoc)
	 * @see protocol.ProtocolHandler#getProtocol(comms.Command, wrapper.PizzeriaConfigAPI)
	 */
	@Override
	public T getProtocol() {
		
		return null;
	}
	/**
	 * @return the gencmd
	 */
	public T getGencmd() {
		return gencmd;
	}
	/**
	 * @param gencmd the gencmd to set
	 */
	public void setGencmd(T gencmd) {
		this.gencmd = gencmd;
	}
	/**
	 * @return the genapi
	 */
	public T getGenapi() {
		return genapi;
	}
	/**
	 * @param genapi the genapi to set
	 */
	public void setGenapi(T genapi) {
		this.genapi = genapi;
	}

}
