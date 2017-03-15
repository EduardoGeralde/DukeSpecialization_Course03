package DukeSpecializationCourse03;
/**
 * Testing some features.
 * 
 * @author Eduardo Geralde Neto
 * 
 */
public class WordPlay {
    
    public boolean isVowel1(char ch){
        char chLower = Character.toLowerCase(ch);
        if(chLower=='a'||chLower=='e'||chLower=='i'||chLower=='o'||chLower=='u'){
            return true;
        }
        return false;
    }
    
    public boolean isVowel2(char ch){
        String vowels = "aeiouAEIOU";
        for(int k=0; k<vowels.length(); k++){
            char currChar = vowels.charAt(k);
            if(currChar==ch){
                return true;
            }
        }
        return false;
    }
    
    public void testIsVowel(){
        char a = 'a';
        char E = 'E';
        char g = 'g';
        char H = 'H';
        char hash = '#';
        char nine = '9';
        System.out.println("The letter 'a' is a vowel ? "+ isVowel1(a));
        System.out.println("The letter 'a' is a vowel ? "+ isVowel2(a));
        System.out.println("The letter 'E' is a vowel ? "+ isVowel1(E));
        System.out.println("The letter 'E' is a vowel ? "+ isVowel2(E));
        System.out.println("The letter 'g' is a vowel ? "+ isVowel1(g));
        System.out.println("The letter 'g' is a vowel ? "+ isVowel2(g));
        System.out.println("The letter 'H' is a vowel ? "+ isVowel1(H));
        System.out.println("The letter 'H' is a vowel ? "+ isVowel2(H));
        System.out.println("The symbol '#' is a vowel ? "+ isVowel1(hash));
        System.out.println("The symbol '#' is a vowel ? "+ isVowel2(hash));
        System.out.println("The number '9' is a vowel ? "+ isVowel1(nine));
        System.out.println("The number '9' is a vowel ? "+ isVowel2(nine));
    }
    
    public String replaceVowels(String phrase, char ch){
        StringBuilder encrypted = new StringBuilder (phrase);
        for(int k=0;k<encrypted.length();k++){
            if(isVowel1(encrypted.charAt(k))){
             encrypted.setCharAt(k,ch);
            }
        }
        return encrypted.toString();
    }
    
    public void testReplaceVowels(){
        String phrase = "Hello World";
        char change = '*';
        System.out.println(phrase + " with vowels changed for : "+ change + " is : ");
        System.out.println(replaceVowels(phrase,change));
        
    }
    
    public String emphasize(String phrase, char ch){
        StringBuilder encrypted = new StringBuilder (phrase);
        char chUpper = Character.toUpperCase(ch);
        char chLower = Character.toLowerCase(ch);
        for(int k=0;k<encrypted.length();k++){
            if(encrypted.charAt(k)==chUpper || encrypted.charAt(k)==chLower){
                if(k%2==0){
                    encrypted.setCharAt(k,'*');
                } else {
                    encrypted.setCharAt(k,'+');
                }
            }
        }
        return encrypted.toString();
    }
    
    public void testEmphasize(){
        String phrase1 = "dna ctgaaactga";
        String phrase2 = "Mary Bella Abracadabra";
        char ch = 'a';
        System.out.println(phrase1);
        System.out.println(emphasize(phrase1,ch));
        System.out.println(phrase2);
        System.out.println(emphasize(phrase2,ch));
    }
    
}
