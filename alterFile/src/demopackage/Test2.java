package demopackage;

import java.io.*;
import java.util.*;

public class Test2 {
	public static void main(String[] args) {

		// The name of the file to open.
	String fileName = "input.txt";
	String line = null;
	String temp = "";

	// The name of the file to write.
	String fileName2 = "ostanfordwithcommafull.txt";

	int x = 1;
	try

	{
		// FileReader reads text files in the default encoding.
		FileReader fileReader = new FileReader(fileName);

		// Always wrap FileReader in BufferedReader.
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		while ((line = bufferedReader.readLine()) != null) {
			int lentab=line.indexOf("\t");
			temp = line.substring(0, lentab) + "," + line.substring(lentab+1, line.length());

			try {

				// Assume default encoding.
				FileWriter fileWriter = new FileWriter(fileName2, true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				if (x == 1) {
					for (int i = 0; i < 4500; i++)

					{
						if (i == 0)
							bufferedWriter.write("MainFriend");
						else
							bufferedWriter.write(",SuggestedFriend" +i);

					}
					bufferedWriter.write("\n");
					x=2;
				}

				// Always wrap FileWriter in BufferedWriter.
				bufferedWriter.write(temp);
				bufferedWriter.write("\n");
				bufferedWriter.close();
			} catch (IOException ex1) {
				System.out.println("Error writing to file '" + fileName + "'");
/*
 * LOAD CSV WITH HEADERS FROM 'file:///home/hadoopuser/eclipse-workspace/alterFile/ostanfordwithcomma(copy).csv' AS line 
CREATE (:fr {Main Friend: line.Main Friend, Suggested Friend 1:line.Suggested Friend 1, Suggested Friend 2: line.Suggested Friend 2})
 */
			
			}

		}

		bufferedReader.close();
	} catch (FileNotFoundException ex) {
		System.out.println("Unable to open file '" + fileName + "'");
	} catch (IOException ex) {
		System.out.println("Error reading file '" + fileName + "'");
		// Or we could just do this:
		// ex.printStackTrace();
		}

	}

}
