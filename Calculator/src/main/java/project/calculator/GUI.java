package project.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] operationButtons = new JButton[9];
    JButton addButton;
    JButton subtractButton;
    JButton divideButton;
    JButton multiplyButton;
    JButton decimalButton;
    JButton equalsButton;
    JButton negativeButton;
    JButton deleteButton;
    JButton clearButton;
    JPanel window;
    Font font = new Font("Garamond", Font.BOLD, 20);
    char operation;
    double num1 =0, num2 = 0, result = 0;
    protected void setupGUI() {
        initializeFrame();
        initializeTextField();
        initializeOperationButtons();
        setupOperationButtons();
        setupNumberButtons();
        initializeButtonWindow();
        setupFrame();
    }

    protected void setupFrame() {
        deleteButton.setBounds(50,530,145,40);
        clearButton.setBounds(205,530,145,40);

        frame.add(window);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    protected void initializeFrame() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,650);
        frame.setLayout(null);
    }

    protected void setupNumberButtons() {
        for (int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setFocusable(false);
        }
    }

    protected void setupOperationButtons() {
        for (int i = 0; i < 9; i++)
        {
            operationButtons[i].addActionListener(this);
            operationButtons[i].setFont(font);
            operationButtons[i].setFocusable(false);
        }
    }

    protected void initializeTextField() {
        textField = new JTextField();
        textField.setBounds(10, 25, 400, 50);
        textField.setFont(font);
        textField.setEditable(false);
    }

    protected void initializeOperationButtons() {
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        decimalButton = new JButton(".");
        equalsButton = new JButton("=");
        deleteButton = new JButton("DELETE");
        clearButton = new JButton("CLEAR");
        negativeButton = new JButton("(-)");

        operationButtons[0] = addButton;
        operationButtons[1] = subtractButton;
        operationButtons[2] = multiplyButton;
        operationButtons[3] = divideButton;
        operationButtons[4] = decimalButton;
        operationButtons[5] = equalsButton;
        operationButtons[6] = deleteButton;
        operationButtons[7] = clearButton;
        operationButtons[8] = negativeButton;
    }

    protected void initializeButtonWindow() {
        window = new JPanel();
        window.setBounds(10, 100, 400, 400);
        window.setLayout(new GridLayout(4, 4, 10, 10));
        window.setBackground(Color.GRAY);
        for (int i = 1; i < 10; i++)
        {
            window.add(numberButtons[i]);
        }
        window.add(numberButtons[0]);
        window.add(addButton);
        window.add(subtractButton);
        window.add(multiplyButton);
        window.add(negativeButton);
        window.add(divideButton);
        window.add(decimalButton);
        window.add(equalsButton);
    }


    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++){
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decimalButton){
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operation = '+';
            textField.setText("");
        }
        if (e.getSource() == subtractButton){
            num1 = Double.parseDouble(textField.getText());
            operation = '-';
            textField.setText("");
        }
        if (e.getSource() == multiplyButton){
            num1 = Double.parseDouble(textField.getText());
            operation = '*';
            textField.setText("");
        }
        if (e.getSource() == divideButton){
            num1 = Double.parseDouble(textField.getText());
            operation = '/';
            textField.setText("");
        }
        if (e.getSource() == equalsButton){
            num2 = Double.parseDouble(textField.getText());
            switch (operation){
                case '+':
                    result = num1+num2;
                    break;
                case '-':
                    result = num1-num2;
                    break;
                case '*':
                    result = num1*num2;
                    break;
                case '/':
                    result = num1/num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clearButton){
            textField.setText("");
        }
        if (e.getSource() == deleteButton){
            String value = textField.getText();
            textField.setText("");
            for (int i = 0; i < value.length()-1; i++){
                textField.setText(textField.getText()+ value.charAt(i));
            }
        }
        if (e.getSource() == negativeButton){
            double value = Double.parseDouble(textField.getText());
            value *= -1;
            textField.setText(String.valueOf(value));
        }
    }
}
