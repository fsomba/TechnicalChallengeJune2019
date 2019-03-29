/*
This Java Code searches a folder for files with a given character
Compile and run it on command prompt
To compile write this on command prompt: javac WordSearch.java
To run it write: java WordSearch
*/

import java.io.*;
import java.util.*;

class WordSearch{
	public static void main(String args[]){
		//instructions to user
		System.out.println("\nSpecify a folder path in this format: \n");
		System.out.println("C:/Users/Francis/Desktop \n");
		//create scanner reader for obtaining input
		Scanner input=new Scanner(System.in);
		//Prompt User to enter a folder path
		System.out.println("Type folder path now\n");
		String folderPath;
		folderPath=input.nextLine();
		//
		char searchCharacter;
		//ask user to enter letter to search
		System.out.println("\nPsst! Java Characters are case sensitive! A is not a. \n");
		System.out.println("Enter Character To Search For:");

		//get input
		searchCharacter=input.next().charAt(0);
		//print character enetered
		System.out.println("Searching for: "+searchCharacter+"\n");
		//
		//read all files in specified directory
		File folder = new File(folderPath);
		File[] listOfFiles = folder.listFiles();
		//
		int fileCount=1;
		//loop through each file checking for character
		for (File file : listOfFiles) {
			int matchFound=0;
			//
			if (file.isFile()) {
    		System.out.println(fileCount+". Searching in: "+file.getName()+"\n");
    		//create an object of FileInputStream and pass file name to it
		try(FileInputStream fin=new FileInputStream(file.getName())){
			int m;
			//read characters until End Of File
			do{
				//method read() returns int -1 when end of file is reached
				m=fin.read();
				//dertemine if character is uppercase
				if((char)m==searchCharacter) {				
					matchFound=1;
					break;
				}
			}while(m!=-1);
			//
		}catch(IOException exc){
			System.out.println("I/O Error: " + exc);
		}
    	}
    	if(matchFound==1){
    		System.out.println("Match found in: "+file.getName()+"\n");
    	}else{
    		System.out.println("No Match in: "+file.getName()+"\n");
    	}
    	fileCount++;
		}
		
	}
}