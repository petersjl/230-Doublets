import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class Links implements LinksInterface {

	public Links(String filename){
		Scanner sc = null;
		File f= new File(filename);
		try{
			sc = new Scanner(f);
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		while(sc.hasNextLine()){
			String word = sc.next();
			System.out.println(word);
		}
	}
	@Override
	public Set<String> getCandidates(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(String word) {
		// TODO Auto-generated method stub
		return false;
	}

}
