package studentCoursesBackup.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//https://stackoverflow.com/questions/13185727/reading-a-txt-file-using-scanner-class-in-java
public class FileProcessor {
	Scanner scan;
	int check = 1;
	String line = "";

	public String ReadLine(String file_name) throws FileNotFoundException {
		if (check == 1) {
			scan = new Scanner(new File(file_name));
			check++;
		}
		try {

			if (scan.hasNext()) {
				String line;
				line = scan.nextLine();
				return line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

}
