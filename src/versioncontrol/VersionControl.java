/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package versioncontrol;

import java.util.ArrayList;
import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.IOException; 
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.HashMap;
import java.util.HashSet; 
import java.util.Map;
import java.util.Scanner; 
import java.util.Set;

/**
 *
 * @author Mausam
 */

public class VersionControl {
public static ArrayList<String> arrayword = new ArrayList<String>(); // We create this arraylist for  storing unique words.
public static ArrayList<String> arrayallwords = new ArrayList<String>(); // store all words from a input file. 
    /**6
     * @param args the command line arguments
     */
public static boolean isValidFilePath(String filePath) // check the entered filepath is correct or not.
{
        File file = new File(filePath);
        if (file.exists() && !file.isDirectory()) {
            return true;
        } else {
            return false;
        }
    }

    public static void Getfilepath() throws FileNotFoundException // This methode will ask user to enter filepath.
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input file name with extention .txt :: ");
        String filepath = sc.next();
        if (!isValidFilePath(filepath)) {
            System.out.println("Please enter valid file path");
            Getfilepath();
        } else {
            Readfiledata(filepath);
        }
    }
    
    public static void Readfiledata(String filepath) throws FileNotFoundException // This methode will seprates words from file and add into the arraylist. If there is any special character in the files then there will be ignored.
    {
        File inputFile = new File(filepath);
        Scanner sc = new Scanner(inputFile);
        while (sc.hasNext()) {
            String words = sc.next();
            arrayword.add(words);
        }
        for (int i = 0; i < arrayword.size(); i++)
            arrayword.set(i,arrayword.get(i).replaceAll("[^a-zA-Z0-9]",""));
        
        while(arrayword.contains("")) 
              arrayword.remove("");
        Getuniquewords();
    }
    
     public static void Getuniquewords() // This methode will find the unique words and print those words.
     {
        Set<String> uniqueWords = new HashSet<String>(arrayword);
        arrayallwords.addAll(arrayword);
        arrayword.removeAll(arrayword);
        arrayword.addAll(uniqueWords);
        Collections.sort(arrayword);
        System.out.println("\n1. List Of unique word : \n ");
        for (String repeatation : arrayword) {
            if (Collections.frequency(arrayallwords, repeatation) == 1) {
                System.out.println(repeatation);
            }
        }
        Getcountofwords();
    }
     
   public static void Getcountofwords() // This methode will find the count of occurence of each word and print those words with their count of occurence.
   {
        System.out.println("\n2. count of occurrences of each word : \n ");
        for (String repeatation : arrayword) {
            System.out.println(repeatation + " " + " " + Collections.frequency(arrayallwords, repeatation));
        }
        Getwordslength();
    }
    
    public static void Getwordslength() // This methode will find the length of each words and print those words with their lenght.
    {
        System.out.println("\n3. Show number of letters in each word : \n ");
        for (int i=0; i<arrayword.size(); i++) {
            System.out.println(arrayword.get(i) + " : " + arrayword.get(i).length());
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException 
    {
        // TODO code application logic here
         Getfilepath();
    }
    
}

