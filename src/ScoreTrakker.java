import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ScoreTrakker {

	public static ArrayList<Student> studentArray = new ArrayList<>();

	public static void loadDataFile(String fileName) {

		try {
			File dataFile = new File(fileName);
			Scanner dataReader = new Scanner(dataFile);

			while (dataReader.hasNext()) {
				Student currentStudent = new Student();

				currentStudent.name = dataReader.nextLine();
				currentStudent.score = dataReader.nextInt();

				if (dataReader.hasNext()) {
					dataReader.nextLine();
				}

				studentArray.add(currentStudent);
			}

			dataReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error opening file.");
			e.printStackTrace();
		}
	}

	public static ArrayList<Student> printInOrder() {
		
		Collections.sort(studentArray, Student.CompareByScore);
		for (Student s : studentArray) {
			System.out.print(s.name);
			System.out.print(s.score);
			System.out.println();
		}

		return studentArray;
	}
	
	public static void processFiles() {
		loadDataFile("scores.txt");
		printInOrder();
	}

	public static void main(String[] args) {
		processFiles();
	}
}