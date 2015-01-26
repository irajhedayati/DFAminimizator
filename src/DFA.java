import java.util.ArrayList;

/**
 * A class to store DFA
 * 
 * <p>DFA={Q,S,d,q0,F} in which</p>
 * <ul>
 * <li>Q is set of states</li>
 * <li>S is set of alphabet</li>
 * <li>d is set of transitions</li>
 * <li>q0 is start state</li>
 * <li>F is set of final states</li>
 * </ul>
 * <p>The constraint in d is that all states should have
 * an output with all elements in S</p>
 * 
 * @author iraj
 *
 */
public class DFA {
	
	private ArrayList<String> Q;
	private ArrayList<String> S;
	private ArrayList<DFATransition> d;
	private int q0;
	private ArrayList<Integer> F;
	
	private boolean isValidated;
	private boolean isValid;
	private String validationMessage;
	
	public DFA() {
		Q = new ArrayList<>();
		S = new ArrayList<>();
		d = new ArrayList<>();
		q0 = -1;
		F = new ArrayList<>();
		isValidated = false;
		validationMessage = "";
	}
	
	/**
	 * Adds a new state to state list
	 * @param stateName
	 * @throws NameAlreadyExistsException
	 */
	public void addState(String stateName) throws NameAlreadyExistsException{
		if(!Q.contains(stateName)){
			Q.add(stateName);
		}else{
			throw new NameAlreadyExistsException(stateName + " state already exists!");
		}
	}
	
	/**
	 * Adds a new alphabet to the alphabet universe
	 * @param name
	 * @throws NameAlreadyExistsException
	 */
	public void addAlphabet(String alphabet) throws NameAlreadyExistsException{
		if(!S.contains(alphabet)){
			S.add(alphabet);
		}else{
			throw new NameAlreadyExistsException(alphabet + " state already exists!");
		}
	}
	
	/**
	 * Set one of the states as start state
	 * @param stateName
	 * @throws WrongState 
	 */
	public void setStartState(String stateName) throws WrongState{
		this.q0 = Q.indexOf(stateName);
		if(this.q0==-1){
			throw new WrongState(stateName + " does not exists in states");
		}
	}
	
	/**
	 * Add a state as a final state
	 * @param stateName - to add to the list of final states
	 * @throws WrongState
	 */
	public void addFinal(String stateName) throws WrongState{
		int index = this.Q.indexOf(stateName);
		if(index == -1){
			throw new WrongState(stateName + " doesn't exist in list of states");
		}else{
			this.F.add(index);
		}
	}
	
	/**
	 * Adds a transition to the list of transitions
	 * @param stateName - State name to apply the transitioin
	 * @param alphabet - The input alphabet to the stateName
	 * @param destState - The destination state after applying the alphabet to stateName
	 * @throws WrongState - Throws if the input states or alphabets are wrong
	 */
	public void addTransition(String stateName, String alphabet, String destState) throws WrongState{
		int stateNameIndex = this.Q.indexOf(stateName);
		int alphabetIndex = this.S.indexOf(alphabet);
		int destStateIndex = this.Q.indexOf(stateName);
		
		if( stateNameIndex != -1 &&
			alphabetIndex != -1 &&
			destStateIndex != -1){
			this.d.add(new DFATransition(stateNameIndex, alphabetIndex, destStateIndex));
		}else{
			throw new WrongState("One of the input states or alphabet does not exists in DFA!");
		}
	}

	/**
	 * Check if the DFA has been validated or not.
	 * @return isValid - if it returns false, check the message (DFA.validationMessage())
	 */
	public boolean validate(){
		this.isValidated = true;
		if(this.Q.size()==0){
			// There is no state
			this.validationMessage = "DFA doesn't have any state yet";
			this.isValid = false;
		}else if(q0 < 0){
			// Start state has not been set yet
			this.validationMessage = "The start state has not been set yet";
			this.isValid = false;
		}else if(this.F.size()==0){
			// No final state has been defined yet
			this.validationMessage = "The DFA should have a final state";
			this.isValid = false;
		}else if(this.d.size()!= (this.S.size() * this.Q.size())){
			// Transitions are not correct
			this.validationMessage = "Transition table doesn't set correctly";
			this.isValid = false;
		}
		return this.isValid;
	}
	
	public boolean isValid(){
		return this.isValid;
	}
	
	public String validationMessage(){
		if(this.isValidated && !this.isValid){
			return validationMessage;
		}else if(!this.isValidated){
			return "DFA has not been validated yet";
		}else{
			return "The DFA seems to be valid";
		}
	}

	public ArrayList<String> getStates(){ return this.Q; }
	
	public ArrayList<Integer> getFinalStates(){ return this.F; }

	public ArrayList<DFATransition> getTransitions() { return this.d; }
}
