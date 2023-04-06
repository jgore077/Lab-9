import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.text.html.HTMLDocument.Iterator;

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
    public String movieToWatch(String[] studentNames){
		//will throw null pointer exception if given a non-existent name but not adding try catchs for that
        TreeSet<String> startSet = studentMovies.get(studentNames[0]);
		Random rand = new Random();
        for(int i=1;i<studentNames.length-1;i++){
            startSet.retainAll(studentMovies.get(studentNames[i]));
        }
		int retIndex=0;
		if(startSet.size()>=2){
			retIndex = rand.nextInt(startSet.size());
		}
        return (String)((startSet.toArray())[retIndex]);
    }
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		studentMovies a = new studentMovies("Movies.txt");
		String b= a.movieToWatch(new String[]{"Kyrin","Jimmy","Dylan"});
		System.out.println(b);
	}

}
