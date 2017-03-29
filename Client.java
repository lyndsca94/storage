package assn4;

import java.io.*;
import java.util.Scanner;
//import java.io.File;
//import java.io.IOException;
//import java.util.NoSuchElementException;
//import java.util.Scanner;

/**
 *
 * @author lyndsey arnold
 *         3/2017
 */
public class Client {
    public static void main(String[] args) throws Exception {
        long wordsFound = 0;
        long wordsNotFound = 0;
        long compsFound = 0;
        long compsNotFound = 0;
        int count[] = new int [1];
        MyLinkedList[] dictionary = new MyLinkedList[26];
        for (int i = 0; i < dictionary.length; i++) {
            //MyLinkedList myLinkedList = dictionary[i];
            dictionary[i]= new MyLinkedList<String>();
        }
        
        try {
            File f = new File("random_dictionary.txt");
            Scanner input = new Scanner(f);
            String s = input.nextLine();
            while (input.hasNext()) {
                s = input.nextLine();
                s = s.replaceAll("\\s+","");
                s = s.toLowerCase();
                dictionary[s.charAt(0)-'a'].add(s);
            } //while
        } //try
        catch (IOException e) {
            System.out.println("Exception");
            e.printStackTrace();
        } // catch
        
        //System.out.println(dictionary[0]);
        File f1 = new File("oliver.txt");
        Scanner i1 = new Scanner(f1);
        
            //File f1 = new File("oliver.txt");
            //Scanner i1 = new Scanner(f1);
            while (i1.hasNext()) {
                try {
                String s = i1.next();
                s = s.replaceAll("[^a-zA-Z]","");
                s = s.toLowerCase();
                
                //System.out.println();
               // int index = (s.charAt(0)-'a');
                //dictionary[s.charAt(0)-'a'].add(s);
                count[0]=0;
                if (dictionary[(s.charAt(0)-97)].contains(s,count)){
                    wordsFound++;
                    compsFound += count[0];
                } //if
                else{
                    wordsNotFound++;
                    compsNotFound += count[0];
                } //else
            } //try
            catch (StringIndexOutOfBoundsException ex) {
            // System.out.println("Exception");
            i1.next();
 
            } // catch
            }
         
            
        long avgcompswordsfound = compsFound/wordsFound;
        long avgcompswordsnotfound = compsNotFound/wordsNotFound;
        System.out.println("# of words found: " + wordsFound);
        System.out.println("# of words not found: " + wordsNotFound);
        System.out.println("# of comparisons found: " + compsFound);
        System.out.println("# of comparisons not found: " + compsNotFound);
        System.out.println("Average # of comparisons for words found: " + avgcompswordsfound);
        System.out.println("Average # of comparisons for words not found: " + avgcompswordsnotfound);

}
}
