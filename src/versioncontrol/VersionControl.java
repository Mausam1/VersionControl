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
public static ArrayList<String> arrayword = new ArrayList<String>();
public static ArrayList<String> arrayallwords = new ArrayList<String>();
    /**
     * @param args the command line arguments
     */
public static boolean isValidFilePath(String filePath) {
        File file = new File(filePath);
        if (file.exists() && !file.isDirectory()) {
            return true;
        } else {
            return false;
        }
    }

    public static void Getfilepath() throws FileNotFoundException {
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
    
    public static void Readfiledata(String filepath) throws FileNotFoundException {
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
               
        System.out.println(arrayword);
    }
    public static void main(String[] args) throws FileNotFoundException 
    {
        // TODO code application logic here
         Getfilepath();
    }
    
}
