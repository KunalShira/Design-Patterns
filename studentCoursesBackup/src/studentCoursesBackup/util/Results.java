package studentCoursesBackup.util;

import java.io.IOException;
import java.io.PrintWriter;

public class Results implements StdoutDisplayInterface, FileDisplayInterface {

	public void writeToStdout(TreeBuilder tree) {
		// System.out.println("In writeToStdout " + storedResult.size());
		System.out.println(tree.printNodes());

	}

	/*To write in output.txt -  syntax of PrintWriter
https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java
*/
	public void writeToFile(String output,TreeBuilder tree) {
		try {
			PrintWriter writer = new PrintWriter(output, "UTF-8");
				writer.println(tree.printNodes());
			writer.close();
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("File not found");
		} 
	}


}
