package bin;

import java.util.Arrays;

public class Transposition {

	//矩阵换位法加密
	public static String encrypt(String plain,String key){
		//1.密钥长度即为矩阵的列数，获取密钥长都
		Integer keylength=key.length();
		//2.根据密钥长度排列数组,形成明文矩阵
		char [][]result=null;
		int textlength=plain.length();
		    //补足矩阵数
		int lines;
		if(textlength%keylength==0)
			lines=(textlength/keylength);
		else{
			lines=(textlength/keylength)+1;
		}
		int fillnum=lines*keylength-textlength;
		if(textlength%keylength!=0){
			for(int i=0;i<fillnum;i++){
				plain=plain+"$";
			}
		}
		    //明文一行一行的放
		result=new char[textlength/keylength+1][keylength];
		for(int i=0;i<lines;i++)
		{
			//填充每一行
			for(int j=0;j<keylength;j++)
			{
				result[i][j]=plain.charAt(i*keylength+j);
			}
		}
		//也还对着呢
		//由key值确定密钥数组
		char [] key1=new char[keylength];
		char [] key2=new char[keylength];
		for(int i=0;i<keylength;i++){
			key1[i]=key.charAt(i);
			key2[i]=key.charAt(i);
		}
		//对k2进行排序用于顺序取出明文
		Arrays.sort(key2);
		char[] cipher=new char[textlength+fillnum];
		int index=0;
		for(int i=0;i<keylength;i++){
			//找到与key2相同的key1值，通过key1值确定该值的i，取出明文矩阵中对的第i列
			int colomn=-1;
			for(int counter=0;counter<keylength;counter++){
				if(key2[i]==(key1[counter])){
					colomn=counter;
				}
			}
			//取出明文矩阵第colomn列
			//赋值有错误，啊啊啊啊啊啊，愁呀
			for(int j=0;j<lines;j++){
				
			    cipher[index]=result[j][colomn];
				index++;
			}
		}
		String ciphertext=new String(cipher);
		return ciphertext;
		
	}
	
	

	
	//矩阵置换法解密
	public static String decrypt(String cipher,String key){
		//1.密钥长度即为矩阵的列数，获取密钥长都
		Integer keylength=key.length();
		//2.根据密钥长度排列数组,形成明文矩阵
		char [][]result=null;
		int textlength=cipher.length();
		    //补足矩阵数
		int lines;
		if(textlength%keylength==0)
			lines=(textlength/keylength);
		else{
			lines=(textlength/keylength)+1;
		}
		int fillnum=lines*keylength-textlength;
		if(textlength%keylength!=0){
		    for(int i=0;i<fillnum;i++){
			   cipher=cipher+"$";
			}
		}
		//密文一列一列的放
		result=new char[textlength/keylength+1][keylength];
		int indexofcipher=0;
		for(int j=0;j<keylength;j++)
		{
			//填充每一行
			for(int i=0;i<lines;i++)
			{
				result[i][j]=cipher.charAt(indexofcipher);
				indexofcipher++;				
			}
		}
		
			//用key1,key2确定先取哪一个
			//由key值确定密钥数组
		char [] key1=new char[keylength];
		char [] key2=new char[keylength];
		for(int i=0;i<keylength;i++){
		key1[i]=key.charAt(i);
		key2[i]=key.charAt(i);
		}
				//对k2进行排序用于顺序取出明文
		Arrays.sort(key2);
		char[] plain=new char[textlength+fillnum];
		int index=0;
				
				//密文一行一行的取
		for(int l=0;l<lines;l++){
			for(int i=0;i<keylength;i++){
				//找到与key2相同的key1值，通过key1值确定该值的i，取出明文矩阵中对的第i列
				int colomn=-1;
				for(int counter=0;counter<keylength;counter++){
					if(key2[i]==(key1[counter])){
						plain[index]=result[l][counter];
						index++;
						}
					}
				}}
		String plaintext=new String(plain);
		return plaintext;	
	}
}
