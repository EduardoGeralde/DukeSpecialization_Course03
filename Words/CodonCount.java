package DukeSpecializationCourse03;


/**
 * @author Eduardo Geralde Neto 
 * @version 03/2017
 *
 * Write a program to find out how many times each codon occurs in a strand of DNA based on reading frames. 
 *  A strand of DNA is made up of the symbols C, G, T, and A. A codon is three consecutive symbols in a strand of DNA such as ATT or TCC. 
 *  A reading frame is a way of dividing a strand of DNA into consecutive codons. Consider the following strand of DNA = “CGTTCAAGTTCAA”.
 *  There are three reading frames.
 *  The first reading frame starts at position 0 and has the codons: “CGT”, “TCA”, “AGT” and “TCA”. 
 *  Here TCA occurs twice and the others each occur once.
 *  The second reading frame starts at position 1 (ignoring the first C character) and has the codons: “GTT”, “CAA”, “GTT”, “CAA”. 
 *  Here both GTT and CAA occur twice.
 * The third reading frame starts at position 2 (ignoring the first two characters CG) and has the codons: “TTC”, “AAG”, “TTC”. 
 * Here TTC occurs twice and AAG occurs once.
 **/

import edu.duke.*;
import java.util.*;


public class CodonCount {
    private HashMap<String, Integer> map;
    
    public CodonCount() {
        map = new HashMap<String, Integer>();
    }
    
    private void buildCodonMap(int start, String dna) {
        map.clear();
        int k = 0; //number of codons
        int num = 0; //number of iterations
        k = (dna.length()-start)/3;
        String current;
        while (num <= k-1) {
            current = dna.substring(num*3+start, num*3+start+3);
            if (!map.containsKey(current)) map.put(current, 1);
            else map.put(current, map.get(current)+1);
            num = num + 1;
        }
    }
    
    private String getMostCommonCodon() {
        int largest = 0;
        int current = 0;
        String largestone = null;
        for (String index : map.keySet()) {
            current = map.get(index);
            if (largest < current) {
                largest = current;
                largestone = index;
            }
        }
        return largestone;
    }
    
    private void printCodonCounts(int start, int end) {
        int current = 0;
        for (String index : map.keySet()) {
            current = map.get(index);
            if (current >= start && current <= end) 
                System.out.println(index+": "+current+"\t");
        }
    }
    
    public void test() {
        FileResource fr = new FileResource();
        String dna = fr.asString().trim();
        dna = dna.toUpperCase();
        int start = 1;
        int end = 100;
        
        buildCodonMap(0, dna);
        System.out.println("Reading frame starting with 0 results in "+map.size()+" unique codons"+"\t");
        String largest = getMostCommonCodon();
        System.out.println("and most common codon is "+largest+" with count "+map.get(largest)+"\t");  
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
        printCodonCounts(start, end);
        
        buildCodonMap(1, dna);
        System.out.println("Reading frame starting with 1 results in "+map.size()+" unique codons"+"\t");
        largest = getMostCommonCodon();
        System.out.println("and most common codon is "+largest+" with count "+map.get(largest)+"\t");  
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
        printCodonCounts(start, end);
        
        buildCodonMap(2, dna);
        System.out.println("Reading frame starting with 2 results in "+map.size()+" unique codons"+"\t");
        largest = getMostCommonCodon();
        System.out.println("and most common codon is "+largest+" with count "+map.get(largest)+"\t");  
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
        printCodonCounts(start, end);
    }
}
