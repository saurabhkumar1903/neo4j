package demopackage;

import java.io.*;
import java.util.*;
public class Test3 {
	public static void main(String[] args) {

		// The name of the file to open.
		String fileName = "ostanfordwithcommafull.txt";
		HashMap<Integer,ArrayList<Integer>> hashmap=new HashMap<>();
		// This will reference one line at a time
		String line = null;
		for (int i = 0; i < 4500; i++) {
			String temp2 = "";
			try {
				// FileReader reads text files in the default encoding.
				FileReader fileReader = new FileReader(fileName);

				// Always wrap FileReader in BufferedReader.
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				ArrayList<Integer> arrayList=new ArrayList<>();
				while ((line = bufferedReader.readLine()) != null) {

					String chline[] = line.split(" ");
					
					if (Integer.parseInt(chline[0]) == i)
						{temp2 = temp2 + chline[1] + ",";
						arrayList.add(Integer.parseInt(chline[0]));
						}//System.out.println(temp2 + "$$$$$$");
				
				}
				hashmap.put(i, arrayList);
				arrayList.clear();
				// Always close files.
				bufferedReader.close();
			} catch (FileNotFoundException ex) {
				System.out.println("Unable to open file '" + fileName + "'");
			} catch (IOException ex) {
				System.out.println("Error reading file '" + fileName + "'");
				// Or we could just do this:
				// ex.printStackTrace();
			}

			// The name of the file to open.
			String fileName2 = "outputwithheaders.txt";

			try {
				
				// Assume default encoding.
				FileWriter fileWriter = new FileWriter(fileName2,true);

				// Always wrap FileWriter in BufferedWriter.
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

				// Note that write() does not automatically
				// append a newline character.
				if(temp2.length()>=1)
					temp2=temp2.substring(0, temp2.length()-1);
				/*version 1
				bufferedWriter.write(i + "\t" + temp2);
				*/
				
				//version 2
				if(i==0)
				{
					for(int j=0;j<4500;j++)
						if(j==0)
						bufferedWriter.write("MainFriend");
						else
							bufferedWriter.write("suggested Friend "+(j));
				}
				
				bufferedWriter.write(i + "," + temp2);
				bufferedWriter.write("\n");

				// Always close files.
				bufferedWriter.close();
			} catch (IOException ex1) {
				System.out.println("Error writing to file '" + fileName + "'");
				// Or we could just do this:
				// ex.printStackTrace();
			}

			System.out.println(i + "->" + temp2);
		}
	}

}
