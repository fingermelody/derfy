import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.lp.algrithms.Algorithm;
import org.lp.algrithms.CleanDirt;
import org.lp.algrithms.DFS;
import org.lp.algrithms.OneTouchDraw;
import org.lp.encrpt.EncrptTest;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Algorithm a = new DFS(); 
//		Algorithm a = new OneTouchDraw();
		Algorithm a = new CleanDirt(); 
		a.run();
		
		
		
		/*System.out.println("plaintext is :' advanced internetwork! encrpt chaptor.' following is the  ciphertext encrpted by different methods.\n");
		EncrptTest encrpt  = new EncrptTest();
		try {
			
			encrpt.EncrypDES();
			encrpt.EncrypDES3();
			encrpt.EncrypAES();
			encrpt.EncrypRSA();
			encrpt.encrptMD5();
			encrpt.encrptSHA();
			
		} catch (InvalidKeyException | NoSuchAlgorithmException
				| NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

}
