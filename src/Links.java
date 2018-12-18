import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class Links implements LinksInterface{
	
	private HashMap<String, HashSet<String>> map;
	
	public Links(String filename) {
		this.map = new HashMap<String, HashSet<String>>();
		fileInput(filename);
	}
	
	private void fileInput(String filename) {
		ArrayList<String> tempList = new ArrayList<String>();
		File file  = new File(filename);
		try {
			Scanner s = new Scanner(file);
			while (s.hasNext()) {
				tempList.add(s.next());
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Iterator<String> it = tempList.iterator();
		while (it.hasNext()) {
			String temp = it.next();
			HashSet<String> builder = new HashSet<String>();
			for (String t : tempList) {
				if (t != temp && t.length() == temp.length()) {
					char[] ch1 = t.toCharArray();
					char[] ch2 = temp.toCharArray();
					int count = 0;
					for (int i = 0; i < t.length(); i++) {
						if (ch1[i] != ch2[i]) {
							count++;
						}
						if (count >= 2) {
							break;
						}
					}
					if (count < 2) {
						builder.add(t);
					}
				}
			}
			this.map.put(temp, builder);
		}
	}
	
	public Set<String> getCandidates(String s) {
		if (!this.map.containsKey(s) || this.map.get(s).isEmpty()) {
			return null;
		}
		return this.map.get(s);
	}

	@Override
	public boolean exists(String word) {
		// TODO Auto-generated method stub
		return false;
	}
	
}

