
public class Main {

	static DFA myDFA;
	
	public static void main(String[] args) {
		myDFA = new DFA();
		try {
			// Add states to DFA
			myDFA.addState("0");
			myDFA.addState("1");
			myDFA.addState("2");
			myDFA.addState("3");
			myDFA.addState("4");
			myDFA.addState("5");
			myDFA.addState("6");
			
			// Add alphabet to DFA
			myDFA.addAlphabet("a");
			myDFA.addAlphabet("b");
			
			// Add Final states to DFA
			myDFA.addFinal("6");
			
			// Set start state
			myDFA.setStartState("0");
			
			// Add transition table
			myDFA.addTransition("0", "a", "6");
			myDFA.addTransition("0", "b", "2");
			myDFA.addTransition("1", "a", "0");
			myDFA.addTransition("1", "b", "2");
			myDFA.addTransition("2", "a", "3");
			myDFA.addTransition("2", "b", "0");
			myDFA.addTransition("3", "a", "5");
			myDFA.addTransition("3", "b", "4");
			myDFA.addTransition("4", "a", "6");
			myDFA.addTransition("4", "b", "5");
			myDFA.addTransition("5", "a", "2");
			myDFA.addTransition("5", "b", "4");
			myDFA.addTransition("6", "a", "1");
			myDFA.addTransition("6", "b", "5");
			
			if(myDFA.isValid()){
				DFAMinimizator dfaMin = new DFAMinimizator(myDFA);
				dfaMin.minimize();
			}else{
				System.out.println("DFA is not valid");
			}
		} catch (NameAlreadyExistsException e) {
			e.printStackTrace();
		} catch (WrongState e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
