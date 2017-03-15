package CaesarCipher;

 
import org.junit.Test;
import edu.duke.FileResource;

/**
 * Caesar Cypher Test
 * 
 * @author Eduardo Geralde Neto 
 * 
 */
public class CaesarCipherTwoTest {

    @Test
    public void simpleTest() {
        FileResource fr = new FileResource();
        CaesarCipherTwo cc = new CaesarCipherTwo(1,3);
        
        String encrypted = cc.encrypt(fr.asString());
        String decrypted = CaesarCipherTwo.breakCipher(encrypted);
        
        System.out.println(encrypted);
        System.out.println(decrypted);
        
    }
    
    @Test 
    public void quiz1() {
        FileResource fr = new FileResource();
        String decrypted = CaesarCipherTwo.breakCipher(fr.asString());
        System.out.println(decrypted);
    }

    
}
