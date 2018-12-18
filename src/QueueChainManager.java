import java.util.LinkedList;

@SuppressWarnings({"unchecked","rawtypes"})
public class QueueChainManager extends ChainManager {
	
	private LinkedList list;
	
	public QueueChainManager() {
		list = new LinkedList();
	}

	@Override
	public void add(Chain chain) {
		list.add(chain);
		this.updateMax(list.size());
	}

	@Override
	public Chain next() {
		this.incrementNumNexts();
		return (Chain) list.remove();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

}
