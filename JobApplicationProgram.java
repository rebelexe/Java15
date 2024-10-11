package Java15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TooEarlyToApply extends Exception {
    public TooEarlyToApply() {
        super("Too Early to Apply");
    }
}

class TooLateToApply extends Exception {
    public TooLateToApply() {
        super("Too Late to Apply");
    }
}

class JobApplication {
    String name;
    String role;
    int age;
}

public class JobApplicationProgram {

    JobApplicationProgram() {
        JFrame f = new JFrame("Job Application");
        f.setSize(400, 350);

        JLabel l1 = new JLabel("Enter your Name: ");
        l1.setBounds(50, 50, 150, 25);
        f.add(l1);
        JTextField t1 = new JTextField();
        t1.setBounds(200, 50, 150, 25);
        f.add(t1);

        JLabel l2 = new JLabel("Enter the role: ");
        l2.setBounds(50, 90, 150, 25);
        f.add(l2);
        JTextField t2 = new JTextField();
        t2.setBounds(200, 90, 150, 25);
        f.add(t2);

        JLabel l3 = new JLabel("Enter your Age: ");
        l3.setBounds(50, 130, 150, 25);
        f.add(l3);
        JTextField t3 = new JTextField();
        t3.setBounds(200, 130, 150, 25);
        f.add(t3);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel resName = new JLabel("Name: ");
        panel.add(resName);
        JLabel resNameVal = new JLabel();
        panel.add(resNameVal);

        JLabel resRole = new JLabel("Role: ");
        panel.add(resRole);
        JLabel resRoleVal = new JLabel();
        panel.add(resRoleVal);

        JLabel resAge = new JLabel("Age: ");
        panel.add(resAge);
        JLabel resAgeVal = new JLabel();
        panel.add(resAgeVal);

        JButton bApply = new JButton("Apply");
        bApply.setBounds(100, 180, 100, 30);
        f.add(bApply);

        // Cancel button
        JButton bCancel = new JButton("Cancel");
        bCancel.setBounds(220, 180, 100, 30);
        f.add(bCancel);

        bApply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JobApplication jobApp = new JobApplication();
                jobApp.name = t1.getText();
                jobApp.role = t2.getText();
                try {
                    jobApp.age = Integer.parseInt(t3.getText());
                    if (jobApp.age < 18) {
                        throw new TooEarlyToApply();
                    } else if (jobApp.age > 40) {
                        throw new TooLateToApply();
                    } else {
                        resNameVal.setText(jobApp.name);
                        resRoleVal.setText(jobApp.role);
                        resAgeVal.setText(String.valueOf(jobApp.age));

                        JOptionPane.showMessageDialog(null, panel, "Application Successful", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(f, "Error"+ex, "Application Unsuccessful", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Cancel button action
        bCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new JobApplicationProgram();
    }
}
