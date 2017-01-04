package src;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bin.Polyalphabetic;
import bin.Transposition;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Trans {
	public Trans(){
		 JFrame frame=new JFrame("Transposition Cipher");
		  Container content=frame.getContentPane();
		  
		  JPanel p_encryption=new JPanel();
		  JPanel p_decryption=new JPanel();
		  JPanel p_plaintext=new JPanel();
		  JPanel p_ciphertext=new JPanel();
		  JPanel p_key=new JPanel();
		  JPanel p_plaintextd=new JPanel();
		  JPanel p_ciphertextd=new JPanel();
		  JPanel p_keyd=new JPanel();
		  //初始化控件
		  GridLayout grid=new GridLayout(1,2);
		  GridLayout fourline=new GridLayout(5,1);
		  GridLayout twocolomn=new GridLayout(1,2);

	      //设置布局管理器
		  content.setLayout(grid);
		  p_encryption.setLayout(fourline);
		  p_decryption.setLayout(fourline);
		  p_plaintext.setLayout(twocolomn);
		  p_ciphertext.setLayout(twocolomn);
		  p_key.setLayout(twocolomn);
		  p_plaintextd.setLayout(twocolomn);
		  p_ciphertextd.setLayout(twocolomn);
		  p_keyd.setLayout(twocolomn);
		  
		  JLabel label_encryption=new JLabel("Encryption");
		  final JTextField text_plain=new JTextField();
		  final JTextField text_key=new JTextField();
		  final JTextField text_cipher=new JTextField();
		  JLabel label_plain=new JLabel("PlainText");
		  JLabel label_key=new JLabel("Secret key");
		  JLabel label_cipher=new JLabel("Ciphertext");
		  JButton encrypt=new JButton("Encrypt");
		  encrypt.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e){
				  String S_plain=text_plain.getText();
				  String S_key=text_key.getText();
				  String S_cipher=Transposition.encrypt(S_plain, S_key);
				  text_cipher.setText(S_cipher);
			   }
		  });
		  
		  JLabel label_decryption=new JLabel("Decryption");
		  final JTextField text_plaind=new JTextField();
		  final JTextField text_keyd=new JTextField();
		  final JTextField text_cipherd=new JTextField();
		  JLabel label_plaind=new JLabel("PlainText");
		  JLabel label_keyd=new JLabel("Secret key");
		  JLabel label_cipherd=new JLabel("Ciphertext");
		  JButton decrypt=new JButton("Decrypt");
		  decrypt.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e){
				  String S_cipher=text_cipherd.getText();
				  String S_key=text_keyd.getText();
				  String S_plain=Transposition.decrypt(S_cipher, S_key);
				  text_plaind.setText(S_plain);
			   }
		  });
		  
		  //开始组装，从下层到上层吧
		  p_plaintext.add(label_plain);
		  p_plaintext.add(text_plain);
		  p_plaintext.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		  p_key.add(label_key);
		  p_key.add(text_key);
		  p_key.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		  p_ciphertext.add(label_cipher);
		  p_ciphertext.add(text_cipher);
		  p_ciphertext.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		  p_encryption.add(label_encryption);
		  label_encryption.setBorder(BorderFactory.createEmptyBorder(0,100,0,0));
		  p_encryption.add(p_plaintext);
		  p_encryption.add(p_key);
		  p_encryption.add(encrypt);
		  p_encryption.add(p_ciphertext);
		  
		  p_plaintextd.add(label_plaind);
		  p_plaintextd.add(text_plaind);
		  p_plaintextd.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		  p_keyd.add(label_keyd);
		  p_keyd.add(text_keyd);
		  p_keyd.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		  p_ciphertextd.add(label_cipherd);
		  p_ciphertextd.add(text_cipherd);
		  p_ciphertextd.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		  p_decryption.add(label_decryption);
		  label_decryption.setBorder(BorderFactory.createEmptyBorder(0,100,0,0));
		  p_decryption.add(p_ciphertextd);
		  p_decryption.add(p_keyd);
		  p_decryption.add(decrypt);
		  p_decryption.add(p_plaintextd);
		   
		  p_encryption.setBorder(BorderFactory.createEmptyBorder(30,10,30,10));
		  p_decryption.setBorder(BorderFactory.createEmptyBorder(30,10,30,10));
		  
		  content.add(p_encryption);
		  content.add(p_decryption);
		  
		  frame.setSize(600,400);
		  frame.setVisible(true);
	}

}
