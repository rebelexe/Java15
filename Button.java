package Java15;

import javax.swing.*;
import java.awt.event.*;
import java.util.Stack;

public class Button extends JButton{

    public final static int EXPRESSION_LABEL = 0;
    public final static int RESULT_LABEL = 1;

    int type;
    String text;
    String expression;
    JLabel label;

    public Button(){
        super();
        this.type = EXPRESSION_LABEL;
    }

    public Button(String text){
        super(text);
        this.type = EXPRESSION_LABEL;
    }

    public Button(String text, JLabel label){
        super(text);
        this.type = EXPRESSION_LABEL;
        this.label = label;
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(type == EXPRESSION_LABEL) changeExpressionText();
                else if(type == RESULT_LABEL) changeResultText(); 
                else throw new RuntimeException("ButtonTypeInvalid");
            }
        });
    }

    public Button(String text, JLabel label, JLabel expressionLabel){
        super(text);
        this.type = EXPRESSION_LABEL;
        this.label = label;
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(type == EXPRESSION_LABEL) changeExpressionText();
                else if(type == RESULT_LABEL) {
                    changeExpression(expressionLabel.getText());
                    changeResultText();
                }
                else throw new RuntimeException("ButtonTypeInvalid");
            }
        });
    }

    //Methods
    public void changeLabel(JLabel label){
        this.label = label;
    }

    public void setType(int type){
        this.type = type;
    }

    public int getType(){
        return this.type;
    }

    //Button Actions
    void changeExpression(String expression){
        this.expression = expression;
    }

    void changeExpressionText(){
        String label_text = label.getText();
        label.setText(label_text.concat(getText()));
    }

    void changeResultText(){
        label.setText("Result: " + evaluateExpression(expression));
    }

    double evaluateExpression(String expression)
    {
      if(expression.isEmpty()) return 0.00;
      char[] tokens = expression.toCharArray();

      Stack<Double> values = new Stack<>();
      Stack<Character> operators = new Stack<>();

        
      for (int i = 0; i < tokens.length; i++) {
        if (tokens[i] == ' ') continue;

        if ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '.') {
          StringBuilder sb = new StringBuilder();
          while (i < tokens.length && (Character.isDigit(tokens[i]) || tokens[i] == '.')) {
            sb.append(tokens[i]);
              i++;
            }
            values.push(
              Double.parseDouble(sb.toString()));
              i--; 
        }

        else if (tokens[i] == '(') {
          operators.push(tokens[i]);
        }

        else if (tokens[i] == ')') {
          while (operators.peek() != '(') {
            values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
          }
          operators.pop(); 
        }
        else if (tokens[i] == '+' || tokens[i] == '-'|| tokens[i] == '*'|| tokens[i] == '/') {
          while (!operators.isEmpty() && hasPrecedence(tokens[i], operators.peek())) {
            values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
          }
          operators.push(tokens[i]);
          }
        }

        while (!operators.isEmpty()) {
          values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    boolean hasPrecedence(char operator1, char operator2)
    {
      if (operator2 == '(' || operator2 == ')')
        return false;
        return (operator1 != '*' && operator1 != '/') || (operator2 != '+' && operator2 != '-');
    }

    double applyOperator(char operator, double b, double a)
    {
      switch (operator) {
        case '+': return a + b;
        case '-': return a - b;
        case '*': return a * b;
        case '/':
          if (b == 0) throw new ArithmeticException("Cannot divide by zero");
          return a / b;
        }
        return 0;
    }
}
