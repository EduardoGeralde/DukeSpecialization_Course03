package CaesarCipher;

 

import org.junit.Test;
import edu.duke.FileResource;

/**
 * Testing CaesarCipherOne object oriented version.
 * 
 * @author Eduardo Geralde Neto
 * 
 */
public class CaesarCipherOneTest {
    
    @Test
    public void simpleTest() {
        FileResource fr = new FileResource();
        int testKey = 18;
        CaesarCipherOne cc = new CaesarCipherOne(testKey);
        String encrypted = cc.encrypt(fr.asString());
        System.out.println(encrypted);
        System.out.println(CaesarCipherOne.breakCipher(encrypted));
        
    }
    
}
