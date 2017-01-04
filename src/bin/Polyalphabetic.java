package bin;

public class Polyalphabetic {
	
	
	//维吉利亚置换算法加密
   public static String encrypt(String plain,String key){
	   String cipher="";
	   int textlength=plain.length();
	   int keylength=key.length();
	   //双重循环，对明文的每一个字母进行置换
	   for(int i=0;i<textlength;i++){
		  int keyindex=i%keylength;
		  char s=(char) (((int)plain.charAt(i)+(int)key.charAt(keyindex)-194)
				  %26+97);
		  cipher=cipher+s;
	   }
	   return cipher;
   }
	
   //置换算法解密
   public static String decrypt(String cipher,String key){
	   String plain="";
	   int textlength=cipher.length();
	   int keylength=key.length();
	   //双重循环，对明文的每一个字母进行置换
	   for(int i=0;i<textlength;i++){
		  int keyindex=i%keylength;
		  char s=(char) ((((int)cipher.charAt(i)+26)-(int)key.charAt(keyindex))
				  %26+97);
		  plain=plain+s;
	   }
	   return plain;
	}
}
