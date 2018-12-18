import java.util.Iterator;
import java.util.LinkedHashSet;


public class Chain implements Iterable<String>{

	LinkedHashSet<String>chain;
	String chainString = "";
	
	public Chain(){
		this.chain= new LinkedHashSet<String>();
	}
	public Chain(String seed){
		this();
		this.chain.add(seed);
	}
	public Chain(LinkedHashSet<String> input){
		this.chain=input;
	}
	public Chain addLast(String string) {
		//make a new chain with new LinkedHashSet with new element
		if(this.contains(string)){
			return this;
		}
		LinkedHashSet<String> temperory = new LinkedHashSet<>();
		for(String s: this.chain){
			temperory.add(s);
		}
		temperory.add(string);
		return new Chain(temperory);
	}
	public String getLast() {
		//get the last string
		Iterator iterOf = this.iterator();
		String current = "";
		while(iterOf.hasNext()){
			current = iterOf.next().toString();
		}
		return current;
	}

	public int length() {
		return this.chain.size();
	}

	public boolean contains(String string) {
		for (String s: this.chain){
			if(s.equals(string)){
				return true;
			}
		}
		return false;
	}

	public Iterator<String> iterator() {
		Iterator<String> iterator = this.chain.iterator();
		return iterator;
	}
	
	@Override
	public String toString(){
		Iterator<String> iter = iterator();
		String ret = "[";
		while(iter.hasNext()){
			ret += iter.next() + ", ";
		}
		return ret.substring(0, ret.length() - 2) + "]";
	}

}
