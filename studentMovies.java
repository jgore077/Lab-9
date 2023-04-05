import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class studentMovies {
	
	private Map<String, TreeSet<String>> studentMovies = new TreeMap<>(); 
	
	
	public studentMovies(String fileName) throws FileNotFoundException {
	File file = new File(fileName);
	Scanner scanner = new Scanner(file);
		while (scanner.hasNext()) {
			TreeSet<String> movies = new TreeSet<>();
			String line = scanner.nextLine();
			String name = (String) line.subSequence(0, line.indexOf(":"));
			studentMovies.put(name, movies);
			line = line.substring(line.indexOf(":") + 2);
			String[] a = line.split("\\s*,\\s");
			
			for(int i = 0; i < a.length; i++) {
				studentMovies.get(name).add(a[i]);
			}
	
		}
		System.out.println(studentMovies.entrySet());
	
	}
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		studentMovies a = new studentMovies("Movies.txt");
	}

}
