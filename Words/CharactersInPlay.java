package DukeSpecializationCourse03;

import edu.duke.*;
import java.util.ArrayList;

/**
 * Write a description of CharactersInPlay here.
 * 
 * @author Eduardo Geralde Neto
 * 
 */
public class CharactersInPlay {
    
    private ArrayList <String> charNames;
    private ArrayList <Integer> charCount;
    
    public CharactersInPlay(){
        charNames = new ArrayList <String> ();
        charCount = new ArrayList <Integer> ();
    }
    
    public void update(String person){
        int index = charNames.indexOf(person);
        if (index == -1) {
            charNames.add(person);
            charCount.add(1);
        }
        else {
            int freq = charCount.get(index);
            charCount.set(index,freq+1);
        }
    }
    
    public void findAllCharacters(){
        FileResource resource = new FileResource();
        for (String line : resource.lines()){
            for (int k = 0; k < line.length(); k++){
                if (line.charAt(k) == '.'){
                    String found = line.substring(0, k);
                    System.out.println(found);
                    update(found);
                    break;
                }
            }
        }
    }
    
    public void tester(){
        findAllCharacters();
        for (int k = 0; k < charNames.size(); k++){
            if (charCount.get(k) < 15 && charCount.get(k) >= 10){
                System.out.print("Main character: "+ charNames.get(k));
                System.out.println (" with "+ charCount.get(k) + " speaking parts");
            }
        }
    }
    
    public void charactersWithNumParts(int num1, int num2){
        for (int k = 0; k < charNames.size(); k++){
            if (charCount.get(k) >= num1 && charCount.get(k) <= num2){
                System.out.print (charNames.get(k)+" appears "+charCount.get(k)+" times.");
                System.out.println ("Greater or equal to "+num1+" and less or equal to "+num2);
            }
        }
    }
}
