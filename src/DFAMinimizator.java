import java.util.ArrayList;
import java.util.Hashtable;


public class DFAMinimizator {
	
	private DFA myDFA;
	
	public DFAMinimizator(DFA inputDFA) {
		this.myDFA = inputDFA;
	}

	public void minimize() {
		
		ArrayList<String> Q = myDFA.getStates();
		ArrayList<Integer> F = myDFA.getFinalStates();
		ArrayList<DFATransition> d = myDFA.getTransitions();
		
		int[] current_parts = new int[Q.size()];
		int[] next_parts = new int[Q.size()];
		int prev_num_parts = 0;
		int cur_num_parts = 2;
		
		// Initialize array current_parts
		// if i is a final state, current_parts[i] = 1
		// otherwise it is 0
		int j =0;
		for (int i = 0; i < current_parts.length; i++) {
			if(j<F.size() && F.get(j) == i){
				current_parts[i] = 1;
				j++;
			}else{
				current_parts[i] = 1;
			}
		}
		
		// Initialize array nex_parts to all 0
		for (int i = 0; i < next_parts.length; i++) { next_parts[i] = 0;}
		
		while (prev_num_parts < cur_num_parts){
			prev_num_parts = cur_num_parts;
			for (DFATransition dfaTransition : d) {
				Hashtable<Integer, String> parts = new Hashtable<>();
				int next_id = 0;
				for (int i = 0; i < Q.size(); i++) {
					
				}
			}
		}
	}
}
