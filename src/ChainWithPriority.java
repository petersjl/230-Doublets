public class ChainWithPriority implements Comparable<ChainWithPriority>{
	public Chain chain;
	public Integer value;
	
	public ChainWithPriority(int value, Chain c) {
		this.value = value;
		this.chain = c;
	}
	//sort while putting in
	@Override
	public int compareTo(ChainWithPriority input) {
		return this.value.compareTo(input.value);
	}
}