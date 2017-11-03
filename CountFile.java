package wordcount;//created package as wordcount
/*
 * here we are making a program to count the line,words an character in the file
 */
import java.io.BufferedReader;//import keyword is used to import built-in and user defined package into our java source file. So that our class can refer a class that is in another package by directly 

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
//here we are creating a class
public class CountFile {//class name taken as CountFile
//here we are creating the main method
	public static void main(String[] args) {
		//Here public is a access modifier which defines who can access this method
		//Here static a keyword which identifies class related thing
		//void is used to define return type of the method,void means method wont return any value
		//main is name of method
		//declares method String[]
		//String[]args means arguments will be passed into main method and says that main() as a parameter
		//here we are creating the new file
		File file = new File("E:/File/New1/abc.txt");
		//here we are applying the condition for checking the file exists or not

		if (file.exists()) {
			System.out.println("Total Lines=" + getLineCount(file));//system is used to return code
	        //out is a static member
		  	//Println is used to print text  and gives output
			System.out.println("Total Words=" + getWordCount(file));
			System.out.println("Total Characters=" + getCharacterCount(file));//system is used to return code
	        //out is a static member
		  	//Println is used to print text  and gives output
		} else {
			System.out.println("File does not exists!");//system is used to return code
	        //out is a static member
		  	//Println is used to print text  and gives output
		}
	}

	/**
	 * Use a BufferedReader to read the file line-by-line using readLine(). Then
	 * split each line on whitespace using String.split("\\s") and the size of
	 * the resulting array is the total words count.
	 */
	private static int getWordCount(File file) {
		int count = 0;//initializing 
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);//new bufferreader object

			String line = br.readLine();//readline
			while (line != null) {//tsking lines
				String[] parts = line.split(" ");
				for (String w : parts) {//string 
					count++;
				}
				line = br.readLine();//readsline
			}

		} catch (FileNotFoundException e) {//exception
			e.printStackTrace();
		} catch (IOException e) {//handles input in try catch block
			e.printStackTrace();//prints stack trace for this throwable object
		}

		return count;//returns

	}

	private static int getCharacterCount(File file) {//getscharactercount
		FileReader fr = null;
		int charCount = 0;//initializing charcount value

		try {
			fr = new FileReader(file);//filereader
			while (fr.read() > -1) {//while loop
				charCount++;//charcount
			}

		} catch (FileNotFoundException e1) {//filenotfoundexception
			e1.printStackTrace();//prints stack trace for this throwable object
		} catch (IOException e) {//handles input in try catch block
			e.printStackTrace();//prints stack trace for this throwable object
		}

		finally {
			if (null != fr)
				try {//try block
					fr.close();//close
				} catch (IOException e) {//handles input in try catch block
					e.printStackTrace();//prints stack trace for this throwable object
				}
		}
		return charCount;//returns
	}

	private static int getLineCount(File file) {
		int linenumber = 0;
		FileReader fr = null;//filereader
		try {
			fr = new FileReader(file);

			/*
			 * buffered character-input stream that keeps track of line numbers
			 */
			LineNumberReader lnr = new LineNumberReader(fr);
			while (lnr.readLine() != null) {//readLine
				linenumber++;
			}
			lnr.close();//closes

			return linenumber;
		} catch (FileNotFoundException e) {
			e.printStackTrace();//prints stack trace for this throwable object
		} catch (IOException e) {
			e.printStackTrace();//prints stack trace for this throwable object
		}
		//here we are applying the finally block

		finally {//used to excecute important code
			if (null != fr)
				try {//try block
					fr.close();//closes
				} catch (IOException e) {//handles input in try catch block
					e.printStackTrace();//prints stack trace for this throwable object
				}
		}
		return linenumber;
	}
}