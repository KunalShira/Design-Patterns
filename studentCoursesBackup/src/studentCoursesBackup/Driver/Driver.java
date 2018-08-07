package studentCoursesBackup.driver;

import java.io.FileNotFoundException;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;

public class Driver {
	public static void main(String[] args) {

		String str = "";
		FileProcessor fp = new FileProcessor();
		FileProcessor fp1 = new FileProcessor();

		TreeBuilder tree1 = new TreeBuilder();
		TreeBuilder tree2 = new TreeBuilder();
		TreeBuilder tree3 = new TreeBuilder();

		Results res = new Results();

		// validation for command line arguments numbers
		if (args.length > 5) {
			System.out.println("More files entered.");
			System.exit(0);
		} else if (args.length < 5) {
			System.out.println("Please enter input and output files.");
			System.exit(0);
		}

		// Setting variables with cmd arguments
		String input = "input.txt";
		input = args[0];

		String delete = "";
		delete = args[1];

		String output1 = "output1.txt";
		output1 = args[2];

		String output2 = "output2.txt";
		output2 = args[3];

		String output3 = "output3.txt";
		output3 = args[4];

		// File names wrongly entered
		if ((!(input.equals("input.txt"))) || (!(delete.equals("delete.txt")))) {
			System.out.println("File names wrongly entered.");
			System.exit(0);
		}

		// Iterating through input file and inserting
		try {
			while ((str = fp.ReadLine(input)) != null) {
				// System.out.println(str);
				Node[] type1 = new Node[2];
				try {
				type1 = tree1.insert(str);
				}catch(ArrayIndexOutOfBoundsException e) {
					System.err.println("B-Id don't have course");

					
				}
				// Skipping after invalid input course
				try {
					if (type1[0] != null) {
						tree2.insertClone(type1[0]);
						tree3.insertClone(type1[1]);
					}
				} catch (NullPointerException e) {
				}

			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("input.txt File not Found");
			System.exit(0);
			// e.printStackTrace();
		}
		System.out.println("----Tree Before Deletion------");
		res.writeToStdout(tree1);

		// Iterating through delete file and deleting
		try {
			while ((str = fp1.ReadLine(delete)) != null) {
				tree1.delete(str);

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("delete.txt File not Found");
			System.exit(0);

			// e.printStackTrace();
		}
		catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("File is empty\n");
		}

		System.out.println("----Tree1------");
		res.writeToStdout(tree1);

		System.out.println("----Tree2------");

		res.writeToStdout(tree2);

		System.out.println("----Tree3------");

		res.writeToStdout(tree3);

		res.writeToFile(output1, tree1);
		res.writeToFile(output2, tree2);
		res.writeToFile(output3, tree3);
	}

}
