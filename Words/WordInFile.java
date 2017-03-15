package DukeSpecializationCourse03;


/**
 * Write a description of WordsinFiles here.
 * 
 * @author Eduardo Geralde Neto
 * @version 03/2017
 * Write a program to determine which words occur in the greatest number of files, and for each word, which files they occur in.
**/

import edu.duke.*;
import java.util.*;
import java.io.*;


public class WordInFile {
    private HashMap<String, ArrayList<String>> map;
    //private ArrayList<String> arraylist;
    
    public WordInFile() {
        map = new HashMap<String, ArrayList<String>>();
        //arraylist = new ArrayList<String>();
    }
    
    private void addWordsFromFile(File f) {
        FileResource fr = new FileResource(f.toString());
        String name = f.getName();
        int sad=0;
        for (String word: fr.words()) {
            if (word.equals("sea")) sad = 1;
            if (!map.containsKey(word)) {
                map.put(word, new ArrayList<String>());
                map.get(word).add(name);
            }
            else if (map.containsKey(word)) {
                if (!map.get(word).contains(name)) map.get(word).add(name);
            }
        }
        if (sad == 1) System.out.println(name);
    }
    
    private void buildWordFileMap() {
        map.clear();
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()) {
            addWordsFromFile(f);
        }
        
    }
    
    private int maxNumber() {
        int current = 0;
        int largest = 0;
        
        for (String word: map.keySet()) {
            current = map.get(word).size();
            if (largest < current) largest = current;
        }
        
        return largest;
    }
    
    private ArrayList<String> wordsInNumFiles(int number) {
        int current = 0;
        ArrayList<String> list = new ArrayList<String>();
        for (String word: map.keySet()) {
            current = map.get(word).size();
            if (current==number) list.add(word);
        }
        return list;
    }
    
    private void printFilesIn(String word) {
        System.out.println("The files contain "+word+" are(is): \t");
        ArrayList<String> list = new ArrayList<String>();
        for (String current: map.keySet()) {
            if (current==word) list = map.get(current);
        }
        for (int k = 0; k < list.size(); k++) {
            System.out.println(list.get(k)+"\t");
        }
    }
    
    public void test() {
        buildWordFileMap();
        int max = maxNumber();
        ArrayList<String> list = wordsInNumFiles(max);
        System.out.println("The greatest number of files a word appears in is "+max+", and there are "+list.size()+ " such words: ");
        for (int k = 0; k < list.size(); k++) {
            System.out.println(list.get(k)+" ");
        }
        System.out.println("\t");
        for (int k = 0; k < list.size(); k++) {
            printFilesIn(list.get(k));
        }
        
        
    }
}

