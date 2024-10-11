package Java15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

abstract class Shape {
    int n1, n2;
    abstract float printArea();
}

class Rectangle extends Shape {
    Rectangle(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    float printArea() {
        return n1 * n2;
    }
}

class Triangle extends Shape {
    Triangle(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    float printArea() {
        return 0.5f * n1 * n2;
    }
}

class Circle extends Shape {
    Circle(int n1) {
        this.n1 = n1;
    }

    float printArea() {
        return 3.14f * n1 * n1;
    }
}

public class ShapeProgram {

    ShapeProgram() {
        JFrame f = new JFrame("Shape Area Calculator");
        f.setSize(400, 400);

        JLabel l1 = new JLabel("Select Shape:");
        l1.setBounds(50, 50, 150, 25);
        f.add(l1);

        JRadioButton r1 = new JRadioButton("Rectangle");
        r1.setBounds(200, 50, 100, 25);
        f.add(r1);

        JRadioButton r2 = new JRadioButton("Triangle");
        r2.setBounds(200, 80, 100, 25);
        f.add(r2);

        JRadioButton r3 = new JRadioButton("Circle");
        r3.setBounds(200, 110, 100, 25);
        f.add(r3);

        ButtonGroup g1 = new ButtonGroup();
        g1.add(r1);
        g1.add(r2);
        g1.add(r3);

        JLabel l2 = new JLabel();
        l2.setBounds(50, 150, 150, 25);
        f.add(l2);
        JTextField t1 = new JTextField();
        t1.setBounds(200, 150, 100, 25);
        f.add(t1);
        t1.setVisible(false);
        
        JLabel l3 = new JLabel();
        l3.setBounds(50, 180, 150, 25);
        f.add(l3);
        l3.setVisible(false);

        JTextField t2 = new JTextField();
        t2.setBounds(200, 180, 100, 25);
        f.add(t2);
        t2.setVisible(false);


        r1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l2.setText("Enter length:");
                l3.setText("Enter breadth:");
                t1.setVisible(true);
                l3.setVisible(true);
                t2.setVisible(true);
            }
        });

        r2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l2.setText("Enter base:");
                l3.setText("Enter height:");
                t1.setVisible(true);
                l3.setVisible(true);
                t2.setVisible(true);
            }
        });

        r3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l2.setText("Enter radius:");
                t1.setVisible(true);
                l3.setVisible(false);
                t2.setVisible(false);
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2, 10, 10));

        JLabel resArea = new JLabel("Area: ");
        panel.add(resArea);
        JLabel resAreaVal = new JLabel();
        panel.add(resAreaVal);

        JButton b = new JButton("Calculate Area");
        b.setBounds(50, 220, 150, 25);
        f.add(b);

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(200, 220, 150, 25);
        f.add(cancelBtn);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Shape shape = null;
                int n1 = 0;
                int n2 = 0;
                n1 = Integer.parseInt(t1.getText());

                if (r1.isSelected()) {
                    n2 = Integer.parseInt(t2.getText());
                    shape = new Rectangle(n1, n2);
                } else if (r2.isSelected()) {
                    n2 = Integer.parseInt(t2.getText());
                    shape = new Triangle(n1, n2);
                } else if (r3.isSelected()) {
                    shape = new Circle(n1);
                }

                if (shape != null) {
                    resAreaVal.setText(String.valueOf(shape.printArea()));
                    JOptionPane.showMessageDialog(null, panel, "Shape Area", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        f.setLayout(null);
        f.setVisible(true);
    }
}
