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
		System.out.println("Loading Links...");
		double elapsedTime;
		double startTime = System.currentTimeMillis();
		Links link = new Links("english.cleaned.all.35.txt");
		elapsedTime = (System.currentTimeMillis() - startTime);
		System.out.println("Loaded Links in " + elapsedTime/1000.0 + " seconds");
		Doublets d = new Doublets(link);
		Scanner s = new Scanner(System.in);
		String start, end, man;
		ChainManager manager = new StackChainManager();
		System.out.println("Welcome to Doublets, a game of \" verbal torture\"");
		while(true) {
			start = "owo";
			end = "iwi";
			man = "uwu";
			System.out.print("Enter starting word: ");
			start = s.next().toLowerCase();
			while(link.getCandidates(start) == null){
				System.out.print(start + " is not a known word\nEnter starting word: ");
				start = s.next().toLowerCase();
			}
			System.out.print("Enter ending word: ");
			end = s.next().toLowerCase();
			while(link.getCandidates(end) == null) {
				System.out.print(end + " is not a known word\nEnter ending word: ");
				end = s.next().toLowerCase();
			}
			System.out.print("Enter chain manager (s: stack, q: queue, p: priority queue, x: exit): ");
			man = s.next().toLowerCase();
			while(!"qsxp".contains(man)) {
				System.out.print(man + " is not a valid command\nEnter chain manager (s: stack, q: queue, p: priority queue, x: exit): ");
				man = s.next().toLowerCase();
			}
			if(man.equals("x"))break;
			else if(man.equals("s")) manager = new StackChainManager();
			else if(man.equals("q")) manager = new QueueChainManager();
			else if(man.equals("p")) manager = new PriorityQueueChainManager(end);
			Chain c = d.findChain(start, end, manager);
			if(c == null) {
				System.out.println("There is no chain between these words");
				continue;
			}
			System.out.println("Chain: " + c.toString());
			System.out.println("Length: " + c.length());
			System.out.println("Candidates: " + manager.getNumberOfNexts());
			System.out.println("Max size: " + manager.maxSize());
		}
		s.close();
	}

	public Chain findChain(String start, String end, ChainManager manager) {
		if(start.length() != end.length()) return null;
		Chain c = new Chain();
		c = c.addLast(start);
		manager.add(c);
		int i = 0;
		while(!manager.isEmpty() && i < 1000) {
			Chain next = manager.next();
			if (next == null) {
				System.out.println("asdhjekjxucg7");
			}
			if(next.getLast().equals(end)) return next;
			Set cand = links.getCandidates((String)next.getLast());
			try {
				Iterator<String> it = cand.iterator();
				while(it.hasNext()) {
//					manager.add(next.addLast(it.next()));
					c = next.addLast(it.next());
					if(c != null) {
						manager.add(c);
					}
				}
			}catch(NullPointerException e) {
				
			}
			i++;
		}
		return null;
	}

}
