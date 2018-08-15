package airportSecurityState.util;

import java.io.IOException;
import java.io.PrintWriter;

import airportSecurityState.util.MyLogger.DebugLevel;

public class Result implements StdoutDisplayInterface, FileDisplayInterface {
	public void writeToStdout(String str) {
		MyLogger.writeMessage("In result before writing to console", DebugLevel.FROM_RESULTS);
		// System.out.println("In writeToStdout " + storedResult.size());
		System.out.println(str);
		MyLogger.writeMessage("In result After writing to console", DebugLevel.FROM_RESULTS);

	}

	/*
	 * To write in output.txt - syntax of PrintWriter
	 * https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-
	 * to-it-in-java
	 */
	public void writeToFile(String output, String str) {
		try {
			PrintWriter writer = new PrintWriter(output, "UTF-8");
			writer.println(str);
			MyLogger.writeMessage("\n\n\nOutput written to output.txt", DebugLevel.FROM_RESULTS);

			writer.close();
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("File not found");
		}
	}

}
