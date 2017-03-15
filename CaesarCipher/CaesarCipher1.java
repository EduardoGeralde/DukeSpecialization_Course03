package DukeSpecializationCourse03;

import edu.duke.*;

/**
 * Caesar Cipher class, encrypt with one and two keys.
 * 
 * @author Eduardo Geralde Neto
 * 
 */
public class CaesarCipher1 {
    
    public String encrypt(String input, int key) {
        //Transform the all String in Upper Case
        String inputUpper = input.toUpperCase();
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(inputUpper);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key)+
        alphabet.substring(0,key);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    
    public void testEncrypt() {
        int key = 23;
        //FileResource fr = new FileResource();
        String message = "FIRST LEGION ATTACK EAST FLANK!";
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
    }
    
    public String encryptTwoKeys(String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetL = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            if(Character.isLetterOrDigit(currChar)){
                if (Character.isLowerCase(currChar)){
                    String shiftedAlphabet1L = alphabetL.substring(key1)+alphabetL.substring(0,key1);
                    String shiftedAlphabet2L = alphabetL.substring(key2)+alphabetL.substring(0,key2);
                    int idx = alphabetL.indexOf(currChar);
                    if(i%2==0){
                        char newCharOdd = shiftedAlphabet1L.charAt(idx);
                        encrypted.setCharAt(i, newCharOdd);
                    } else {
                        char newCharEven = shiftedAlphabet2L.charAt(idx);
                        encrypted.setCharAt(i, newCharEven);
                    }
                } else {
                    String shiftedAlphabet1 = alphabet.substring(key1)+alphabet.substring(0,key1);
                    String shiftedAlphabet2 = alphabet.substring(key2)+alphabet.substring(0,key2);
                    int idx = alphabet.indexOf(currChar);
                    if(i%2==0){
                        char newCharOdd = shiftedAlphabet1.charAt(idx);
                        encrypted.setCharAt(i, newCharOdd);
                    } else {
                        char newCharEven = shiftedAlphabet2.charAt(idx);
                        encrypted.setCharAt(i, newCharEven);
                    }
                }
            }
        }
        return encrypted.toString();
    }
    
    public void testEncryptTwoKeys() {
        int key1 = 21;
        int key2 = 8;
        String message1 = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        //FileResource fr = new FileResource();
        //String message1 = fr.asString();
        String encrypted = encryptTwoKeys(message1, key1, key2);
        System.out.println(encrypted);
    }
    
}