import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author <<TODO>>
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class Doublets {
	private LinksInterface links;
	
	public Doublets(LinksInterface links) {
		this.links = links;
	}

	public static void main(String[] args) {
		Links link = new Links("english.cleaned.all.35.txt");
		Doublets d = new Doublets(link);
		Scanner s = new Scanner(System.in);
		String start;
		String end;
		String man = "";
		ChainManager manager = new StackChainManager();
		System.out.println("Welcome to Doublets, a game of \" verbal torture\"");
		System.out.print("Enter starting word: ");
		//start = s.next();
		System.out.print("Enter ending word: ");
		//end = s.next();
		System.out.print("Enter chain manager (s: stack, q: queue, x: exit): ");
		man = s.next();
		if(man.equals("s")) manager = new StackChainManager();
		else if(man.equals("q")) manager = new QueueChainManager();
		System.out.println(link.getCandidates("flour"));
	//	Chain c = d.findChain("flour", "bread", manager);
		//Chain c = d.findChain(start, end, manager);
//		System.out.println("Chain: " + c.toString());
//		System.out.println("Length: " + c.length());
		System.out.println("Candidates: " + manager.getNumberOfNexts());
		System.out.println("Max size: " + manager.maxSize());
	}

	public Chain findChain(String start, String end, ChainManager manager) {
		if(start.length() != end.length()) return null;
		Chain c = new Chain();
		c = c.addLast(start);
		manager.add(c);
		while(!manager.isEmpty()) {
			Chain next = manager.next();
			if (next == null) {
				System.out.println("asdhjekjxucg7");
			}
			if(next.getLast().equals(end)) return next;
			Set cand = links.getCandidates((String)next.getLast());
			try {
				Iterator<String> it = cand.iterator();
				while(it.hasNext()) {
					manager.add(next.addLast(it.next()));
//					c = next.addLast(it.hasNext());
//					if(c != null) {
//						manager.add(c);
//					}
				}
			}catch(NullPointerException e) {
				
			}
		}
		return null;
	}

}
