package com.JabezMacs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class ReadSortTextFile {

	
	public static void main(String[] args) throws IOException {
		
		//File file = new File("C:\\Users\\tracy\\Downloads\\shuffledwords.txt");
		File file = new File("C:\\Users\\tracy\\OneDrive\\Documents\\myfile.txt");
		//txt array
		String [] words = null;
		//word count
		int count = 0;
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String s;
		// for the length of array
		while((s=br.readLine())!=null)    //Reading Content from the file
	      {
	         words=s.split(" ");   //Split the word using space
	         count=count+words.length;   //increase the word count for each word
	      }
	      fr.close();
	      // check word count
	      // System.out.println("Words Count:" + count);
	      
	    // to store the words in the array
	    Scanner scan = new Scanner(file);
	    String [] myTxt = new String[count];
	    int i = 0; 
		 while(scan.hasNextLine()){ 
		    myTxt[i++] = scan.nextLine(); 
		 } 
		 scan.close();
		// check myTxt
		// System.out.print(myTxt[0]);
		// System.out.print(myTxt[8]);
		bubbleSort(myTxt, count);
	//	 gNomeSort(myTxt);
	//	 combSort(myTxt);
	//	 bogoSort(myTxt);
	//	 stoogeSort(myTxt);
		// check sorted myTxt
	//	System.out.println(myTxt);
		 //printing the sorted words
		 for(i=0; i<count; i++) {
			 System.out.println(myTxt[i]);
		 }
		
		//System.out.println(myTxt[8]);
		
		// create a new txt file for the sorted array
	/*	String outputFile = "mySortedWords1.txt";
		FileWriter fileWriter = new FileWriter(outputFile);
		PrintWriter out = new PrintWriter(fileWriter);
		for (String outputLine : myTxt) {
			out.println(outputLine);
		}
		out.flush();
		out.close();   
		fileWriter.close(); */
	     
	}
	
	//----------------BUBBLE SORT IMPLEMENTATION -------------
	
	 public static void bubbleSort(String[] arr, int n)
	    {
	        String temp;
	 
	        // Sorting strings using bubble sort
	        for (int j = 0; j < n - 1; j++)
	        {
	            for (int i = j + 1; i < n; i++)
	            {
	                if (arr[j].compareTo(arr[i]) > 0)
	                {
	                    temp = arr[j];
	                    arr[j] = arr[i];
	                    arr[i] = temp;
	                }
	            }
	        }
	    }
	 
	//----------------GNOME SORT IMPLEMENTATION -------------
	
	 public static void gNomeSort(String[] arr)
	 {
	   int i=1;
	   int j=2;
	  
	   while(i < arr.length) {
	    // if ( a[i-1] <= a[i] ) {
		   if (arr[i-1].compareTo(arr[i]) < 0){
	       i = j; j++;
	     } else {
	       String tmp = arr[i-1];
	       arr[i-1] = arr[i];
	       arr[i--] = tmp;
	       i = (i==0) ? j++ : i;
	     }
	   }
	 }
	 
	//----------------COMB SORT IMPLEMENTATION -------------
	 
	    // To find gap between elements
	   public static int getNextGap(int gap)
	    {
	        // Shrink gap by Shrink factor
	        gap = (gap*10)/13;
	        if (gap < 1)
	            return 1;
	        return gap;
	    }
	 
	    // Function to sort arr[] using Comb Sort
	   public static void combSort(String arr[])
	    {
	        int n = arr.length;
	 
	        // initialize gap
	        int gap = n;
	 
	        // Initialize swapped as true to make sure that
	        // loop runs
	        boolean swapped = true;
	 
	        // Keep running while gap is more than 1 and last
	        // iteration caused a swap
	        while (gap != 1 || swapped == true)
	        {
	            // Find next gap
	            gap = getNextGap(gap);
	 
	            // Initialize swapped as false so that we can
	            // check if swap happened or not
	            swapped = false;
	 
	            // Compare all elements with current gap
	            for (int i=0; i<n-gap; i++)
	            {
	                if (arr[i].compareTo(arr[i+gap]) > 0)
	                {
	                    // Swap arr[i] and arr[i+gap]
	                    String temp = arr[i];
	                    arr[i] = arr[i+gap];
	                    arr[i+gap] = temp;
	 
	                    // Set swapped
	                    swapped = true;
	                }
	            }
	        }
	    }
	   
	 //----------------BOGO SORT IMPLEMENTATION -------------
	   
	   public static final Random generator = new Random();  
	   
	   public static void bogoSort(String[] array)  {  
	     while (!isSorted(array)) {  
	       for (int i = 0; i < array.length; i++){  
	         int randomPosition = generator.nextInt(array.length);  
	         String temp = array[i];  
	         array[i] = array[randomPosition];  
	         array[randomPosition] = temp;  
	       }  
	     }  
	   }  
	  
	   private static boolean isSorted(String[] array)  {  
	     for (int i = 1; i < array.length; i++){
	       if (array[i].compareTo(array[i - 1]) < 0) {
	         return false;  
	       }
	     }
	     return true;  
	   }

	   //----------------STOOGE SORT IMPLEMENTATION -------------
	   public static void stoogeSort(String[] arr) {
	        stoogeSort(arr, 0, arr.length - 1);
	    }
	 
	    public static void stoogeSort(String[] arr, int i, int j) {
	        if (arr[j].compareTo(arr[i]) < 0) {
	            String tmp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = tmp;
	        }
	        if (j - i > 1) {
	            int t = (j - i + 1) / 3;
	            stoogeSort(arr, i, j - t);
	            stoogeSort(arr, i + t, j);
	            stoogeSort(arr, i, j - t);
	        }
	    }
}