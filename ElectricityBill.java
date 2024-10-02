package Java15;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class Electricity {
   int consumer_number;
   String consumer_name;
   int previous_reading;
   int current_reading;
   String connection_type;
   int units = 0;
   double amount = 0.0;


   void computeBill() {
      this.units = this.current_reading - this.previous_reading;
      if (this.connection_type.equals("domestic")) {
         if (units <= 100) {
            this.amount = 100.0;
         } else if (units < 200) {
            this.amount = 100.0 + (double)(units - 100) * 2.5;
         } else if (units < 500) {
            this.amount = 350.0 + (double)((units - 200) * 4);
         } else if (units > 500) {
            this.amount = 1650.0 + (double)((units - 500) * 6);
         }
      } else if (this.connection_type.equals("commercial")) {
         if (units <= 100) {
            this.amount = 200.0;
         } else if (units < 200) {
            this.amount = 200.0 + (double)(units - 100) * 4.5;
         } else if (units < 500) {
            this.amount = 650.0 + (double)((units - 200) * 6);
         } else if (units > 500) {
            this.amount = 2550.0 + (double)((units - 500) * 7);
         }
      }
   }

   void prepBill(JRadioButton b1, JRadioButton b2) {
      if (b1.isSelected()) {
         this.connection_type = "domestic";
      } else if (b2.isSelected()) {
         this.connection_type = "commercial";
      }
      computeBill();
   }
}

public class ElectricityBill {
   ElectricityBill() {
      Electricity eb = new Electricity();
      JFrame f = new JFrame("Electricity Bill");
      f.setSize(400, 400);

      // Input fields and labels
      JLabel l1 = new JLabel("Consumer No. : ");
      l1.setBounds(50, 50, 125, 25);
      f.add(l1);
      JTextArea t1 = new JTextArea();
      t1.setBounds(200, 50, 125, 25);
      f.add(t1);

      JLabel l2 = new JLabel("Consumer Name : ");
      l2.setBounds(50, 80, 125, 25);
      f.add(l2);
      JTextArea t2 = new JTextArea();
      t2.setBounds(200, 80, 125, 25);
      f.add(t2);

      JLabel l3 = new JLabel("Previous Reading : ");
      l3.setBounds(50, 110, 125, 25);
      f.add(l3);
      JTextArea t3 = new JTextArea();
      t3.setBounds(200, 110, 125, 25);
      f.add(t3);

      JLabel l4 = new JLabel("Current Reading : ");
      l4.setBounds(50, 140, 125, 25);
      f.add(l4);
      JTextArea t4 = new JTextArea();
      t4.setBounds(200, 140, 125, 25);
      f.add(t4);

      JLabel l5 = new JLabel("Connection Type : ");
      l5.setBounds(50, 165, 125, 25);
      f.add(l5);

      JRadioButton b1 = new JRadioButton("Domestic");
      b1.setBounds(175, 165, 100, 25);
      f.add(b1);
      JRadioButton b2 = new JRadioButton("Commercial");
      b2.setBounds(275, 165, 100, 25);
      f.add(b2);
      ButtonGroup g1 = new ButtonGroup();
      g1.add(b1);
      g1.add(b2);

      // Panel for output
      JPanel panel = new JPanel();
      panel.setLayout(new GridLayout(7, 2, 10, 10));

      JLabel l6 = new JLabel("Consumer No. : ");
      l6.setBounds(400, 50, 125, 25);
      panel.add(l6);
      JLabel t6 = new JLabel();
      t6.setBounds(550, 50, 125, 25);
      panel.add(t6);

      JLabel l7 = new JLabel("Consumer Name : ");
      l7.setBounds(400, 80, 125, 25);
      panel.add(l7);
      JLabel t7 = new JLabel();
      t7.setBounds(550, 80, 125, 25);
      panel.add(t7);

      JLabel l8 = new JLabel("Previous Reading : ");
      l8.setBounds(400, 110, 125, 25);
      panel.add(l8);
      JLabel t8 = new JLabel();
      t8.setBounds(550, 110, 125, 25);
      panel.add(t8);

      JLabel l9 = new JLabel("Current Reading : ");
      l9.setBounds(400, 140, 125, 25);
      panel.add(l9);
      JLabel t9 = new JLabel();
      t9.setBounds(550, 140, 125, 25);
      panel.add(t9);

      JLabel l10 = new JLabel("Connection Type : ");
      l10.setBounds(400, 170, 125, 25);
      panel.add(l10);
      JLabel t10 = new JLabel();
      t10.setBounds(550, 170, 125, 25);
      panel.add(t10);

      JLabel l11 = new JLabel("Consumed Units : ");
      l11.setBounds(400, 200, 125, 25);
      panel.add(l11);
      JLabel t11 = new JLabel();
      t11.setBounds(550, 200, 125, 25);
      panel.add(t11);

      JLabel l12 = new JLabel("Bill amount : ");
      l12.setBounds(400, 230, 125, 25);
      panel.add(l12);
      JLabel t12 = new JLabel();
      t12.setBounds(550, 230, 125, 25);
      panel.add(t12);

      // Display bill button
      JButton b3 = new JButton("Display Bill");
      b3.setBounds(50, 200, 150, 25);
      f.add(b3);
      b3.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) 
         {
            
            eb.consumer_number = Integer.parseInt(t1.getText());
            eb.consumer_name = t2.getText();
            eb.previous_reading = Integer.parseInt(t3.getText());
            eb.current_reading = Integer.parseInt(t4.getText()); 
            
            eb.prepBill(b1, b2);

            t6.setText(String.valueOf(eb.consumer_number));
            t7.setText(eb.consumer_name);
            t8.setText(String.valueOf(eb.previous_reading));
            t9.setText(String.valueOf(eb.current_reading));
            t10.setText(eb.connection_type);
            t11.setText(String.valueOf(eb.units));
            t12.setText(String.valueOf(eb.amount));

            JOptionPane.showMessageDialog(null, panel, "Electricity Bill", JOptionPane.INFORMATION_MESSAGE);
         }
      });

      JButton b4 = new JButton("Cancel");
      b4.setBounds(200, 200, 150, 25);
      f.add(b4);
      b4.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            f.dispose();
         }
      });

      f.setLayout(null);
      f.setVisible(true);
   }
}