package bin;

import java.util.Arrays;

public class Transposition {

	//����λ������
	public static String encrypt(String plain,String key){
		//1.��Կ���ȼ�Ϊ�������������ȡ��Կ����
		Integer keylength=key.length();
		//2.������Կ������������,�γ����ľ���
		char [][]result=null;
		int textlength=plain.length();
		    //���������
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
		    //����һ��һ�еķ�
		result=new char[textlength/keylength+1][keylength];
		for(int i=0;i<lines;i++)
		{
			//���ÿһ��
			for(int j=0;j<keylength;j++)
			{
				result[i][j]=plain.charAt(i*keylength+j);
			}
		}
		//Ҳ��������
		//��keyֵȷ����Կ����
		char [] key1=new char[keylength];
		char [] key2=new char[keylength];
		for(int i=0;i<keylength;i++){
			key1[i]=key.charAt(i);
			key2[i]=key.charAt(i);
		}
		//��k2������������˳��ȡ������
		Arrays.sort(key2);
		char[] cipher=new char[textlength+fillnum];
		int index=0;
		for(int i=0;i<keylength;i++){
			//�ҵ���key2��ͬ��key1ֵ��ͨ��key1ֵȷ����ֵ��i��ȡ�����ľ����жԵĵ�i��
			int colomn=-1;
			for(int counter=0;counter<keylength;counter++){
				if(key2[i]==(key1[counter])){
					colomn=counter;
				}
			}
			//ȡ�����ľ����colomn��
			//��ֵ�д��󣬰���������������ѽ
			for(int j=0;j<lines;j++){
				
			    cipher[index]=result[j][colomn];
				index++;
			}
		}
		String ciphertext=new String(cipher);
		return ciphertext;
		
	}
	
	

	
	//�����û�������
	public static String decrypt(String cipher,String key){
		//1.��Կ���ȼ�Ϊ�������������ȡ��Կ����
		Integer keylength=key.length();
		//2.������Կ������������,�γ����ľ���
		char [][]result=null;
		int textlength=cipher.length();
		    //���������
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
		//����һ��һ�еķ�
		result=new char[textlength/keylength+1][keylength];
		int indexofcipher=0;
		for(int j=0;j<keylength;j++)
		{
			//���ÿһ��
			for(int i=0;i<lines;i++)
			{
				result[i][j]=cipher.charAt(indexofcipher);
				indexofcipher++;				
			}
		}
		
			//��key1,key2ȷ����ȡ��һ��
			//��keyֵȷ����Կ����
		char [] key1=new char[keylength];
		char [] key2=new char[keylength];
		for(int i=0;i<keylength;i++){
		key1[i]=key.charAt(i);
		key2[i]=key.charAt(i);
		}
				//��k2������������˳��ȡ������
		Arrays.sort(key2);
		char[] plain=new char[textlength+fillnum];
		int index=0;
				
				//����һ��һ�е�ȡ
		for(int l=0;l<lines;l++){
			for(int i=0;i<keylength;i++){
				//�ҵ���key2��ͬ��key1ֵ��ͨ��key1ֵȷ����ֵ��i��ȡ�����ľ����жԵĵ�i��
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
