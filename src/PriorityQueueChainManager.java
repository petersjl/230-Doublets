import java.util.PriorityQueue;


public class PriorityQueueChainManager extends ChainManager {
	
	private PriorityQueue<ChainWithPriority> pq;
	private String end;
	
	public PriorityQueueChainManager(String end) {
		pq = new PriorityQueue<ChainWithPriority>();
		this.end = end;
	}

	@Override
	public void add(Chain chain) {
		char[] c1 = chain.getLast().toString().toCharArray();
		char[] c2 = end.toCharArray();
		int counter = 0;
		//count the difference
		for (int i = 0; i < c1.length; i++) {
			if (c1[i] != c2[i]) {
				counter++;
			}
		}
		//calculate and pass in the value 
		this.pq.offer(new ChainWithPriority(counter+chain.length(), chain));
		if(this.pq.size() > super.maxSize()){
			super.updateMax(this.pq.size());
			}
	}

	@Override
	public Chain next() {
		this.incrementNumNexts();
		if (pq.isEmpty()) {
			return null;
		}
		return pq.poll().chain;
	}

	@Override
	public boolean isEmpty() {
		if(this.pq.isEmpty()){
			return true;
		}
		return false;
	}

}
