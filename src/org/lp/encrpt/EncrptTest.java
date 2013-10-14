package org.lp.encrpt;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class EncrptTest {
	
	String str = " advanced internetwork! encrpt chaptor.";
	
	// KeyGenerator 提供对称密钥生成器的功能，支持各种算法  
    private KeyGenerator keygen;  
    // SecretKey 负责保存对称密钥  
    private SecretKey deskey;  
    // Cipher负责完成加密或解密工作  
    private Cipher c;  
    // 该字节数组负责保存加密的结果  
    private byte[] cipherByte;  
  
    public void EncrypDES() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {  
    //    Security.addProvider(new com.sun.crypto.provider.SunJCE());  
       
        keygen = KeyGenerator.getInstance("DES");  
        // 生成密钥  
        deskey = keygen.generateKey();  
        // 生成Cipher对象,指定其支持的DES算法  
        c = Cipher.getInstance("DES");  
        c.init(Cipher.ENCRYPT_MODE, deskey);  
        byte[] src = str.getBytes();  
        // 加密，结果保存进cipherByte  
        cipherByte = c.doFinal(src);  
        //return cipherByte;  
        System.out.println("DES encpyt: "+cipherByte);
    }  
    
    public void EncrypDES3() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {  
        //    Security.addProvider(new com.sun.crypto.provider.SunJCE());  
            // 实例化支持DES算法的密钥生成器(算法名称命名需按规定，否则抛出异常)  
            keygen = KeyGenerator.getInstance("DESede");  
            // 生成密钥  
            deskey = keygen.generateKey();  
            // 生成Cipher对象,指定其支持的DES算法  
            c = Cipher.getInstance("DESede");  
            c.init(Cipher.ENCRYPT_MODE, deskey);  
            byte[] src = str.getBytes();  
            // 加密，结果保存进cipherByte  
            cipherByte = c.doFinal(src);  
            //return cipherByte;  
            System.out.println("3DES encpyt: "+cipherByte);
        } 
    
    public void EncrypAES() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {  
        //    Security.addProvider(new com.sun.crypto.provider.SunJCE());  
             
            keygen = KeyGenerator.getInstance("AES");  
            // 生成密钥  
            deskey = keygen.generateKey();  
            // 生成Cipher对象,指定其支持的DES算法  
            c = Cipher.getInstance("AES");  
            c.init(Cipher.ENCRYPT_MODE, deskey);  
            byte[] src = str.getBytes();  
            // 加密，结果保存进cipherByte  
            cipherByte = c.doFinal(src);  
            //return cipherByte;  
            System.out.println("AES encpyt: "+cipherByte);
        } 
    
    public void EncrypRSA() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {  
      
    	KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");  
        //初始化密钥对生成器，密钥大小为1024位  
        keyPairGen.initialize(1024);  
        //生成一个密钥对，保存在keyPair中  
        KeyPair keyPair = keyPairGen.generateKeyPair();  
        //得到私钥  
        RSAPrivateKey privateKey = (RSAPrivateKey)keyPair.getPrivate();               
        //得到公钥  
        RSAPublicKey publicKey = (RSAPublicKey)keyPair.getPublic();  
          
        //用公钥加密  
        byte[] srcBytes = str.getBytes(); 
    	
        Cipher cipher = Cipher.getInstance("RSA");  
        //根据公钥，对Cipher对象进行初始化  
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);  
        byte[] resultBytes = cipher.doFinal(srcBytes); 
              
            System.out.println("RSA encpyt: "+resultBytes);
        } 
    
    public void encrptMD5() throws NoSuchAlgorithmException{
    	 MessageDigest md5 = MessageDigest.getInstance("MD5");  
    	 md5.update(str.getBytes()); 
    	 byte[] resultBytes = md5.digest();  
    	 System.out.println("MD5 encrpt: "+resultBytes);
    }
    
    public void encrptSHA() throws NoSuchAlgorithmException{
    	 MessageDigest sha = MessageDigest.getInstance("SHA");  
    	 sha.update(str.getBytes()); 
    	 byte[] resultBytes = sha.digest();  
    	 System.out.println("SHA encrpt: "+resultBytes);
   }
    
    

}
