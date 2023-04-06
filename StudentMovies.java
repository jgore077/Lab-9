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
    
    /* Contributor: Kyrin Kalonji
     * This method validates the functionality of the movieToWatch method by running 10 
     * predefined test cases with different sets of students. 
     * It compares the returned movie name with the expected result(s), 
     * and prints the test result for each case. Finally, 
     * it displays the total number of tests passed out of the total number of tests executed.
     */
    public void runTests() {
        int passedTests = 0;
        int totalTests = 10;

        String[][] testCases = {
                {"Abbas", "Thomas", "Seth"},
                {"Liban", "Jonathan", "Megan", "Benjamin", "Anusha", "Jimmy", "Nikki", "Abbas", "Kyrin", "William", "Ahmad", "Esther", "Dylan", "Thomas", "Thad", "Seth"},
                {"Ahmad", "William", "Benjamin"},
                {"Kyrin", "Anusha"},
                {"Dylan", "Thomas", "Thad"},
                {"Seth", "Liban", "Jonathan", "Megan"},
                {"Benjamin", "Anusha", "Jimmy", "Nikki"},
                {"Abbas", "Kyrin", "William"},
                {"Ahmad", "Esther", "Dylan", "Thomas"},
                {"Thad", "Seth", "Liban"}
        };
        
        //Expected result that corresponds to each of the test case arrays above.
        String[][] expectedResults = {{"Braveheart"}, {"The Shinning"}, {}, {"Die Hard"}, {"Fight Club", "The Shining", " The Terminator"},
                                     {"Joker", "Inception"}, {"Scarface"}, {"Braveheart", "Room", "Die Hard"}, {"The Shining"}, {"The Godfather", "The Shinning"}};

        for (int i = 0; i < totalTests; i++) {
            String result = movieToWatch(testCases[i]);
            
            //Converts the 2D array into a list in case there are more than 1 common songs
            List<String> expectedResultList = Arrays.asList(expectedResults[i]);

            if (expectedResultList.contains(result)) {
                passedTests++;
                System.out.println("Test " + (i + 1) + " PASSED: Expected one of " + expectedResultList + ", Actual = " + result);
            } else {
                System.out.println("Test " + (i + 1) + " FAILED: Expected one of " + expectedResultList + ", Actual = " + result);
            }
        }

        System.out.println("Total tests passed: " + passedTests + " out of " + totalTests);
    }
    
	public static void main(String[] args) throws FileNotFoundException {
	    try {
	        StudentMovies studentMovies = new StudentMovies("Movies.txt");
	        studentMovies.runTests();
	    } catch (FileNotFoundException e) {
	        System.out.println("Error: File not found.");
	    }

}
