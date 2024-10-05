package Java15;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//Nawaf's code for home page

public class Main {
   static JMenuBar mb = new JMenuBar();
   static JMenu m1 = new JMenu("Assignment");
   static JMenu m2 = new JMenu("Menu");
   static JMenu m3 = new JMenu("Exit");
   static JMenuItem t1 = new JMenuItem("Electricity Bill");
   static JMenuItem t2 = new JMenuItem("Employee");
   static JMenuItem t3 = new JMenuItem("Calucalator");
   static JMenuItem t4 = new JMenuItem("Binary to decimal");

   public Main() {
   }

   public static void main(String[] args) {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setSize(400, 400);
      mb.add(m1);
      mb.add(m2);
      mb.add(m3);
      m1.add(t1);
      m1.add(t2);
      m2.add(t3);
      m2.add(t4);
      f.setJMenuBar(mb);
      f.setLayout(null);
      f.setVisible(true);


      t1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ElectricityBill ebill = new ElectricityBill();
            }
      });

      t3.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
               Calculator c = new Calculator();
         }
      });
   }
}
