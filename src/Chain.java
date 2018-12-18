import java.util.Iterator;
import java.util.LinkedHashSet;

public class Chain<String> implements Iterable{
	
	private LinkedHashSet<String> list;
	private String last;
	
	public Chain(){
		list = new LinkedHashSet<String>();
		last = null;
	}
	
	@SuppressWarnings("unchecked")
	public Chain(LinkedHashSet<String> hash, String s) {
		this.list = new LinkedHashSet<String>();
		Iterator it = hash.iterator();
		while(it.hasNext()) {
			list.add((String) it.next());
		}
		this.list.add(s);
		this.last = s;
	}
	

	public Chain<String> addLast(String s) {
		return new Chain<String>(this.list, s);
	}
	
	public String getLast() {
		return last;
	}
	
	public int length() {
		return list.size();
	}
	
	public boolean contains(String s) {
		return list.contains(s);
	}
	
	public Iterator iterator() {
		return list.iterator();
	}

}
