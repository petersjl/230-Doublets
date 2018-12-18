import java.util.Stack;

@SuppressWarnings("rawtypes")
public class StackChainManager extends ChainManager {
	
	
	Stack<Chain> stack;
	
	public StackChainManager() {
		stack = new Stack<Chain>();
	}

	@Override
	public void add(Chain chain) {
		stack.push(chain);
		this.updateMax(stack.size());
	}

	@Override
	public Chain next() {
		this.incrementNumNexts();
		return stack.pop();
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

}
