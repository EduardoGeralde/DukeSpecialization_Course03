package DukeSpecialization_Course03.VigenereCipher;


import edu.duke.FileResource;

/**
 * 
 * @author Eduardo Geralde Neto
 * 
 */
public class KnownLanguageKeyLengthQuiz {
	public static void main(String[] args) {
		// Quiz 1
		VigenereBreaker v = new VigenereBreaker();
		FileResource fr = new FileResource("/Users/Eduardo/Desktop/Courses/Duke/JavaCourse03/data_Vigenere/secretmessage1.txt");
		String message = fr.asString();
		int [] key = v.tryKeyLength(message, 4, 'e');
		for (Integer i: key) {
			System.out.print(i + " ");
        }
		System.out.println();
		// Quiz 2
		VigenereCipher vc = new VigenereCipher(key);
    	String decrypt = vc.decrypt(message);
    	System.out.println(decrypt);
	}
}