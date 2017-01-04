package src;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Cipher {
	public static void main(String[] args){
		

		   JFrame frame=new JFrame("Cipher");
		   Container contentPane=frame.getContentPane();
		   
		   GridLayout grid=new GridLayout(2,1);
		   JPanel jp=new JPanel();
		   jp.setLayout(grid);
		   
		   JButton pol=new JButton("Polyalphabetic Cipher");
		   JButton tran=new JButton("Transposition Cipher");
		   
		   
		   //ÉèÖÃ¼àÌýÊÂ¼þ
		   pol.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e){
				  Polyal pol=new Polyal();
			   }
		   });
		   
		   tran.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e){
					  Trans tran=new Trans();
				   }
		   });
		   
		   
		   jp.add(pol);
		   jp.add(tran);
		   jp.setBorder(BorderFactory.createEmptyBorder(100,30,100,30));
		   
		   contentPane.add(jp);
		   frame.setSize(600,400);
		   frame.setVisible(true);
	}

}
