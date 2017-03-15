package DukeSpecializationCourse03;
import edu.duke.*;

/**
 * Count the length of the giving words
 * 
 * @author Eduardo Geralde Neto
 * 
 */
public class WordLenghts {
    
    public int [] countWordLengths(FileResource resource, int []  counts) {
        for (String word: resource.words()) {
            int n = word.length();
            int len = 0;
            for (int i = 0; i < n; i++) {
                if (Character.isLetter(word.charAt(i))) len += 1;
            }
            if (len <= counts.length & len != 0) counts[len-1] += 1;
            else System.out.println("The length of ARRAY counts is not enough!");
        }
        return counts;
    }

    public void testcountWordLengths() {
        URLResource resource = new URLResource("http://www.dukelearntoprogram.com/java/manywords.txt");
        int [] counts = new int[31];
        int [] result = countWordLengths(resource, counts);
        for (int i = 0; i < 31; i++) {
            System.out.println(result[i] + " words of length "+ (i+1));
        }
        int maxlength = indexofMax(result);
        System.out.println("The most common word length in the file is "+maxlength);
    }

    // Write a method indexOfMax that has one parameter named values that is an integer array. 
    // This method returns the index position of the largest element in values. 
    // Then add code to the method testCountWordLengths to call indexOfMax to determine the most common word length in the file.

    public int indexOfMax(int [] values) {
        int maxvalue = 0;
        int position = 0;
        for (int i = 0; i < values.length; i++) {
            if (maxvalue == 0) maxvalue = values[i];
            else {
                if (maxvalue < values[i]) {
                    maxvalue = values[i];
                    position = i;
                }
            }
        }
        return position+1;
    }

}
