package project.calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] operationButtons = new JButton[8];
    JButton addButton, subtractButton, divideButton, multiplyButton;
    JButton decimalButton, equalsButton, deleteButton, clearButton;
    JPanel window;

    Font font = new Font("Garamond",Font.BOLD, 30);
    double num1 =0, num2 = 0, result = 0;
    char operation;

    calculator(){
        initializeFrame();
        initializeTextField();
        initializeOperationButtons();
        setupOperationButtons();
        setupNumberButtons();

        deleteButton.setBounds(50,530,145,40);
        clearButton.setBounds(205,530,145,40);

        initializeButtonWindow();

        frame.add(window);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(textField);
        frame.setVisible(true);
    }

    private void initializeFrame() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,650);
        frame.setLayout(null);
    }

    private void setupNumberButtons() {
        for (int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setFocusable(false);
        }
    }

    private void setupOperationButtons() {
        for (int i = 0; i < 8; i++){
            operationButtons[i].addActionListener(this);
            operationButtons[i].setFont(font);
            operationButtons[i].setFocusable(false);
        }
    }

    private void initializeTextField() {
        textField = new JTextField();
        textField.setBounds(10,25,400,50);
        textField.setFont(font);
        textField.setEditable(false);
    }

    private void initializeOperationButtons() {
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        decimalButton = new JButton(".");
        equalsButton = new JButton("=");
        deleteButton = new JButton("DELETE");
        clearButton = new JButton("CLEAR");

        operationButtons[0] = addButton;
        operationButtons[1] = subtractButton;
        operationButtons[2] = multiplyButton;
        operationButtons[3] = divideButton;
        operationButtons[4] = decimalButton;
        operationButtons[5] = equalsButton;
        operationButtons[6] = deleteButton;
        operationButtons[7] = clearButton;
    }

    private void initializeButtonWindow() {
        window = new JPanel();
        window.setBounds(10,100,400,400);
        window.setLayout(new GridLayout(4, 4, 10, 10));
        window.setBackground(Color.GRAY);
        for (int i = 1; i < 10; i++) {
            window.add(numberButtons[i]);
        }
        window.add(numberButtons[0]);
        window.add(addButton);
        window.add(subtractButton);
        window.add(multiplyButton);
        window.add(divideButton);
        window.add(decimalButton);
        window.add(equalsButton);
    }

    public void actionPerformed(ActionEvent e) {

    }

    public static void main( String[] args ) {
        calculator Calculator = new calculator();
    }
}
