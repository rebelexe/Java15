package project;

import java.util.*;
import javax.swing.*;
import java.awt.event.*;
class Convert{
	String DecimalToBinary(String n) {
		String bin="";
		int dec=Integer.parseInt(n);
		do {
			bin=(dec%2)+bin;
			dec=dec/2;
		}while(dec>0);
		return bin;
	}
	int BinaryToDecimal(String n) {
		int pow=0;
		int Dec=0;
		int bin=Integer.parseInt(n);
		while(bin>0) {
			if((bin%10)==1) {
				 Dec += Math.pow(2, pow); 
			}
			pow++;
			bin=bin/10;
		}
		
		return Dec;
	
}
}
	
public class test {
	public static void main(String[] args) {
	JFrame frame=new JFrame();
	Convert conv=new Convert();
	String ans;
	frame.setSize(400,400);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLayout(null);
	
	
	JLabel l1=new JLabel("Decimal:");
	l1.setBounds(100,100,50,25);
	frame.add(l1);
	
	JTextField t1=new JTextField();
	t1.setBounds(160,100,100,25);
	frame.add(t1);
									
	
	
	JLabel l2=new JLabel("Binary:");
	l2.setBounds(100,130,50,25);
	frame.add(l2);
	
	
	
	JTextField t2=new JTextField();
	t2.setBounds(160,130,100,25);
	frame.add(t2);
	
	
	JButton b1=new JButton("Convert to Binary");
	b1.setBounds(40,170,145,30);
	frame.add(b1);
	
	b1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			t2.setText(conv.DecimalToBinary(t1.getText()));
		}
	});
	
	JButton b2=new JButton("Convert to Decimal");
	b2.setBounds(190,170,145,30);
	frame.add(b2);
	
	
	b2.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			t1.setText(String.valueOf(conv.BinaryToDecimal(t2.getText())));
		}
	});
	
	frame.setVisible(true);
	
	
}
}

