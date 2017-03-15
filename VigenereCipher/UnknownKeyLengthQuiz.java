package DukeSpecialization_Course03.VigenereCipher;


import java.util.HashSet;

import edu.duke.FileResource;

public class UnknownKeyLengthQuiz {
	public static void main(String[] args) {
		// Quiz 1
		VigenereBreaker v = new VigenereBreaker();
		FileResource fr = new FileResource("/Users/Eduardo/Desktop/Courses/Duke/JavaCourse03/data_Vigenere/secretmessage1.txt");
		String message = fr.asString();
		FileResource fr2 = new FileResource("/Users/Eduardo/Desktop/Courses/Duke/JavaCourse03/data_Vigenere/dictionaries/English");
		HashSet<String> dictionary = v.readDictionary(fr2);
		String decrypt = v.breakForLanguage(message, dictionary);
		
		// Quiz 2
		int count = v.countWords(decrypt, dictionary);
		System.out.println(count + " valid words are in the decrypted String.");
		
		// Quiz 3
		String [] lines = decrypt.split("\\r?\\n");
		System.out.println("The first line of text is " + lines[0]);
		
		// Quiz 4
		int [] key = v.tryKeyLength(message, 4, 'e');
		VigenereCipher vc = new VigenereCipher(key);
    	decrypt = vc.decrypt(message);
    	count = v.countWords(decrypt, dictionary);
    	System.out.println(count + " valid words are in the decrypted String.");
    	
	}
}
