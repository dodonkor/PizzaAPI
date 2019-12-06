/**
 * 
 */
package wrapper;

/**
 * On my honor, as a Carnegie-Mellon Africa student, I have neither given nor
 * received unauthorized assistance on this work.
 * 
 * @author Derrick Odonkor This class runs all the test classes
 */
public class PizzeriaConfigAPI extends ProxyPizzerias implements
		CreatePizzeria, UpdatePizzeria, DeletePizzeria {
	private static final PizzeriaConfigAPI pizzeria = new PizzeriaConfigAPI();

	// private constructor to avoid client applications to use constructor
	private PizzeriaConfigAPI() {
	}

	public static PizzeriaConfigAPI getInstance() {
		return pizzeria;
	}

}
