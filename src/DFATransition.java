/**
 * A class to store a transition
 * @author iraj
 *
 */
public class DFATransition {
	private int state;
	private int alphabet;
	private int destinationState;
	
	public DFATransition(int state, int alphabet, int destState) {
		this.state = state;
		this.alphabet = alphabet;
		this.destinationState = destState;
	}
}
