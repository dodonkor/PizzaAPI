/**
 * 
 */
package server;

/**
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor received unauthorized assistance on this work.
 * @author Derrick Odonkor
 * 
 */
public class ServerMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		(new Thread(new PizzeriaServer(9999))).start();
		
	}

}
