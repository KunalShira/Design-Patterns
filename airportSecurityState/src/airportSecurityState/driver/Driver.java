package airportSecurityState.driver;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Set;

import airportSecurityState.airportSecurityStates.Context;
import airportSecurityState.airportSecurityStates.Helper;
import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.MyLogger;
import airportSecurityState.util.MyLogger.DebugLevel;
import airportSecurityState.util.Result;

public class Driver {

	static FileProcessor fp = new FileProcessor();
	static Driver driver = new Driver();
	static Helper helper = new Helper();
	static Context con = new Context();
	static Result res = new Result();
	static String full_output = "";

	static ArrayList<Integer> alDays = new ArrayList<>();
	static Set<Integer> uniqueDays = null;

	static String str = "";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file = "input.txt";

		// validation for command line arguments numbers
		if (args.length > 3) {
			System.out.println("More files entered.");
			System.exit(0);
		} else if (args.length < 3) {
			System.out.println("Please enter input and output files.");
			System.exit(0);
		}

		// Setting variables with cmd arguments
		String input = "input.txt";
		input = args[0];

		String output = "output.txt";
		output = args[1];

		if ((Integer.parseInt(args[2]) < 0) || Integer.parseInt(args[2]) > 4) {
			System.err.println("Entered input for Logger is incorrect");
		}

		// File names wrongly entered
		if (!(input.equals("input.txt"))) {
			System.out.println("File names wrongly entered.");
			System.exit(0);
		}

		MyLogger.setDebugValue(Integer.parseInt(args[2]));
//	https://stackoverflow.com/questions/13185727/reading-a-txt-file-using-scanner-class-in-java

		while ((str = fp.ReadLine(file)) != null) {
			// driver.tightenOrLoosen();
			int decision = helper.tightenOrLoosen(str);

			if (decision == 1) {
				con.same_State();
				String temp = con.toString();
				full_output = full_output + temp + "\n";
				MyLogger.writeMessage("Partial Output just after Low risk state"+full_output, DebugLevel.IN_RESULTS);
			} else if (decision == 2) {

				con.next_State();
				String temp = con.toString();
				full_output = full_output + temp + "\n";
				MyLogger.writeMessage("Partial Output just after Modeerate risk state"+full_output, DebugLevel.IN_RESULTS);

			} else if (decision == 3) {
				con.prev_State();
				String temp = con.toString();
				MyLogger.writeMessage("Partial Output just after High risk state : "+full_output, DebugLevel.IN_RESULTS);

				full_output = full_output + temp + "\n";
			}
			
			
		}
		MyLogger.writeMessage("Complete Output just after all travellers recorded"+ full_output, DebugLevel.IN_RESULTS);


		res.writeToStdout(full_output);
		res.writeToFile(output, full_output);
		// System.out.println(tot_travellers + "---------Total Travellers");
		// System.out.println(uniqueDays.size() + "---------Tot Days");
		// System.out.println(tot_pro_item + "---------Tot Guns");
	}
}
