package com.ouyang.lesson.utils;



import org.apache.commons.codec.binary.Hex;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;



/**
 * ASE 加密解密
 * @author YUE
 * @date 2013-4-15 上午9:57:30
 */
public class AESUtils{
	
	private static final String AES = "AES";
	
	private static final String KEY = "MQyVUmEfSdNMFdYn";
	
	private static Log log = LogFactory.getLog(AESUtils.class);

	/**
	 * 加密
	 * 
	 * @author YUE
	 * @date 2013-4-12 下午4:50:16
	 * @param value
	 * @return
	 */
	public static String encrypt(String value){
		return encrypt(KEY, value);
	}

	/**
	 * 解密
	 * 
	 * @author YUE
	 * @date 2013-4-12 下午4:51:37
	 * @param value
	 * @return
	 */
	public static String decrypt(String value){
		return decrypt(KEY, value);
	}
	
	/**
	 * 加密
	 * @param key
	 * @param value
	 * @return
	 */
	public static String encrypt(String key,String value){
		try{
			SecretKey secretKey = new SecretKeySpec(key.getBytes(),AES);
			SecretKeySpec keySpec = new SecretKeySpec(secretKey.getEncoded(), AES);
			Cipher cipher = Cipher.getInstance(AES);
			cipher.init(Cipher.ENCRYPT_MODE, keySpec);
			byte[] bs = cipher.doFinal(value.getBytes());
			return Hex.encodeHexString(bs);
		}
		catch (Exception e){
			log.error("encrypt error key="+key+" value="+value);
			throw new RuntimeException(e.getMessage(),e);
		}
	}
	
	/***
	 *解密
	 * @param key
	 * @param value
	 * @return
	 */
	public static String decrypt(String key,String value){
		try{
			SecretKey secretKey = new SecretKeySpec(key.getBytes(),AES);
			SecretKeySpec keySpec = new SecretKeySpec(secretKey.getEncoded(),AES);
			Cipher cipher = Cipher.getInstance(AES);
			cipher.init(Cipher.DECRYPT_MODE, keySpec);
			byte[] decodeHex = Hex.decodeHex(value.toCharArray());
			byte[] bytes = cipher.doFinal(decodeHex);
			return new String(bytes);
		}catch (Exception e){
			//解密失败
			log.error("decrypt error key="+key+" value="+value, e);
			throw new RuntimeException(e.getMessage(),e);
		}
	}

    public static void main(String[] args) {
        System.out.println(encrypt("password"));

    }
}
