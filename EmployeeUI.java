package Java15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

abstract class Employee
{
    String Emp_name;
    int Emp_id;
    String Address;
    String Mail_id;
    String Mobile_no;
    double BP,DA,HRA,PF,SF,GP,NP;

    abstract void Calculate();
}


class Professor extends Employee
{
    void Calculate()
    {
        DA = 0.97 * BP;
        HRA = 0.1 * BP;
        PF = 0.12 * BP;
        SF = 0.001 * BP;
        GP = BP+HRA+DA;
        NP = GP-PF-SF;   
    }
}

class Asst_Professor extends Employee
{
    void Calculate()
    {
        DA = 0.60* BP;
        HRA = 0.1 * BP;
        PF = 0.12 * BP;
        SF = 0.001 * BP;
        GP = BP+HRA+DA;
        NP = GP-PF-SF;   
    }
}

class Asso_Professor extends Employee
{
    void Calculate()
    {
        DA = 0.70* BP;
        HRA = 0.1 * BP;
        PF = 0.12 * BP;
        SF = 0.001 * BP;
        GP = BP+HRA+DA;
        NP = GP-PF-SF;   
    }
}

public class EmployeeUI {

    EmployeeUI() {
        JFrame f = new JFrame("Employee Salary Details");
        f.setSize(500, 500);


        JLabel l1 = new JLabel("Employee Name: ");
        l1.setBounds(50, 50, 150, 25);
        f.add(l1);
        JTextArea t1 = new JTextArea();
        t1.setBounds(200, 50, 150, 25);
        f.add(t1);

        JLabel l2 = new JLabel("Employee ID: ");
        l2.setBounds(50, 80, 150, 25);
        f.add(l2);
        JTextArea t2 = new JTextArea();
        t2.setBounds(200, 80, 150, 25);
        f.add(t2);

        JLabel l3 = new JLabel("Address: ");
        l3.setBounds(50, 110, 150, 25);
        f.add(l3);
        JTextArea t3 = new JTextArea();
        t3.setBounds(200, 110, 150, 25);
        f.add(t3);

        JLabel l4 = new JLabel("Mail ID: ");
        l4.setBounds(50, 140, 150, 25);
        f.add(l4);
        JTextArea t4 = new JTextArea();
        t4.setBounds(200, 140, 150, 25);
        f.add(t4);

        JLabel l5 = new JLabel("Mobile Number: ");
        l5.setBounds(50, 170, 150, 25);
        f.add(l5);
        JTextArea t5 = new JTextArea();
        t5.setBounds(200, 170, 150, 25);
        f.add(t5);

        JLabel l6 = new JLabel("Basic Pay: ");
        l6.setBounds(50, 200, 150, 25);
        f.add(l6);
        JTextArea t6 = new JTextArea();
        t6.setBounds(200, 200, 150, 25);
        f.add(t6);

        JLabel l7 = new JLabel("Select Employee Type:");
        l7.setBounds(50, 230, 150, 25);
        f.add(l7);
        
        JRadioButton r1 = new JRadioButton("Professor");
        r1.setBounds(200, 230, 100, 25);
        f.add(r1);

        JRadioButton r2 = new JRadioButton("Asst. Professor");
        r2.setBounds(200, 260, 120, 25);
        f.add(r2);

        JRadioButton r3 = new JRadioButton("Asso. Professor");
        r3.setBounds(200, 290, 120, 25);
        f.add(r3);

        ButtonGroup g1 = new ButtonGroup();
        g1.add(r1);
        g1.add(r2);
        g1.add(r3);


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(15, 2, 10, 10));

        JLabel resName = new JLabel("Employee Name : ");
        panel.add(resName);
        JLabel resNameVal = new JLabel();
        panel.add(resNameVal);

        JLabel resID = new JLabel("Employee ID : ");
        panel.add(resID);
        JLabel resIDVal = new JLabel();
        panel.add(resIDVal);

        JLabel resAddress = new JLabel("Address : ");
        panel.add(resAddress);
        JLabel resAddressVal = new JLabel();
        panel.add(resAddressVal);

        JLabel resMail = new JLabel("Mail ID : ");
        panel.add(resMail);
        JLabel resMailVal = new JLabel();
        panel.add(resMailVal);

        JLabel resMobile = new JLabel("Mobile no : ");
        panel.add(resMobile);
        JLabel resMobileVal = new JLabel();
        panel.add(resMobileVal);

        JLabel resBasic = new JLabel("Basic Pay : ");
        panel.add(resBasic);
        JLabel resBasicVal = new JLabel();
        panel.add(resBasicVal);

        JLabel resDA = new JLabel("DA : ");
        panel.add(resDA);
        JLabel resDAVal = new JLabel();
        panel.add(resDAVal);

        JLabel resHRA = new JLabel("HRA : ");
        panel.add(resHRA);
        JLabel resHRAVal = new JLabel();
        panel.add(resHRAVal);

        JLabel resPF = new JLabel("PF : ");
        panel.add(resPF);
        JLabel resPFVal = new JLabel();
        panel.add(resPFVal);

        JLabel resSF = new JLabel("SF : ");
        panel.add(resSF);
        JLabel resSFVal = new JLabel();
        panel.add(resSFVal);

        JLabel resGross = new JLabel("Gross Pay : ");
        panel.add(resGross);
        JLabel resGrossVal = new JLabel();
        panel.add(resGrossVal);

        JLabel resNet = new JLabel("Net Pay : ");
        panel.add(resNet);
        JLabel resNetVal = new JLabel();
        panel.add(resNetVal);


        JButton b = new JButton("Display Salary");
        b.setBounds(50, 320, 150, 25);
        f.add(b);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Employee emp = null;
                
                if (r1.isSelected()) {
                    emp = new Professor();
                } else if (r2.isSelected()) {
                    emp = new Asst_Professor();
                } else if (r3.isSelected()) {
                    emp = new Asso_Professor();
                }
                
                if (emp != null) {
                    emp.Emp_name = t1.getText();
                    emp.Emp_id = Integer.parseInt(t2.getText());
                    emp.Address = t3.getText();
                    emp.Mail_id = t4.getText();
                    emp.Mobile_no = t5.getText();
                    emp.BP = Double.parseDouble(t6.getText());
                    
                    emp.Calculate();
                    
                    resNameVal.setText(emp.Emp_name);
                    resIDVal.setText(String.valueOf(emp.Emp_id));
                    resAddressVal.setText(emp.Address);
                    resMailVal.setText(emp.Mail_id);
                    resMobileVal.setText(emp.Mobile_no);
                    resBasicVal.setText(String.valueOf(emp.BP));
                    resDAVal.setText(String.valueOf(emp.DA));
                    resHRAVal.setText(String.valueOf(emp.HRA));
                    resPFVal.setText(String.valueOf(emp.PF));
                    resSFVal.setText(String.valueOf(emp.SF));
                    resGrossVal.setText(String.valueOf(emp.GP));
                    resNetVal.setText(String.valueOf(emp.NP));
                    
                    JOptionPane.showMessageDialog(null, panel, "Employee Salary Details", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        JButton bCancel = new JButton("Cancel");
        bCancel.setBounds(200, 320, 150, 25);
        f.add(bCancel);
        bCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        f.setLayout(null);
        f.setVisible(true);
    }

}
