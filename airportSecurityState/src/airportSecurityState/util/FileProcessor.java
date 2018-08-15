package airportSecurityState.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//https://stackoverflow.com/questions/13185727/reading-a-txt-file-using-scanner-class-in-java
public class FileProcessor {
	Scanner scan;
	int check = 1;
	String line = "";

	public String ReadLine(String file_name)  {
		if (check == 1) {
			try {
				scan = new Scanner(new File(file_name));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.err.println("File Not Found");
				System.exit(0);
				e.printStackTrace();
			}
			check++;
		}	
		
		try {

			if (scan.hasNext()) {
				String line;
				line = scan.nextLine();
				return line;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
}
