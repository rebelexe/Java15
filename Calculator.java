package Java15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class Calculator{

  Calculator()
  {
    JFrame main = new JFrame("Calculator");
    main.setSize(300, 400);
    main.setLayout(new GridLayout(7, 1));

    JLabel expression = new JLabel("Expression: ");
    main.add(expression);

    JLabel result = new JLabel("Result: ");
    main.add(result);

    {
      JPanel num_pad = new JPanel(new GridLayout(1,4));
      num_pad.add(new Button("1", expression));
      num_pad.add(new Button("2", expression));
      num_pad.add(new Button("3", expression));
      num_pad.add(new Button("+", expression));
      main.add(num_pad);

      num_pad = new JPanel(new GridLayout(1,4));
      num_pad.add(new Button("4", expression));
      num_pad.add(new Button("5", expression));
      num_pad.add(new Button("6", expression));
      num_pad.add(new Button("-", expression));
      main.add(num_pad);

      num_pad = new JPanel(new GridLayout(1,4));
      num_pad.add(new Button("7", expression));
      num_pad.add(new Button("8", expression));
      num_pad.add(new Button("9", expression));
      num_pad.add(new Button("*", expression));
      main.add(num_pad);

      num_pad = new JPanel(new GridLayout(1,4));
      num_pad.add(new Button("0", expression));
      num_pad.add(new Button("(", expression));
      num_pad.add(new Button(")", expression));
      num_pad.add(new Button("/", expression));
      main.add(num_pad);
    }

    {
        JPanel temp = new JPanel(new GridLayout(1, 2));

        Button calculate = new Button("Calculate", result, expression);
        calculate.setType(Button.RESULT_LABEL);
        temp.add(calculate);

        JButton clear = new JButton("Clear");
        temp.add(clear);
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                expression.setText("Expression: ");
            }
        });

        main.add(temp);
    }

    main.setVisible(true);
  }
}
