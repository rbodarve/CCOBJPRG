//initialize the java methods
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class Calculator extends JFrame {
    
    //initialize and encapsulate the components
    private JPanel panel1, panel2;
    private JRadioButton addition, multiplication, subtraction, division;
    private JTextField input1, input2;
    private JButton answer, reset;
    private ButtonGroup group;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calculator();
            }
        });
    }
     
    public Calculator() {
        super("Basic Arithmetic Operation: +,-,*,/");
        initializeUI();
    }
 
    private void initializeUI() {
        //initialize the frame
        setSize(475, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //initialize the JRadioButtons
        addition = new JRadioButton("Addition[+]", false);
        multiplication = new JRadioButton("Multiplication[x]", false);
        subtraction = new JRadioButton("Subtraction[-]", false);
        division = new JRadioButton("Division[/]", false);
        //initialize the Panels
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(1, 4));
        panel1.add(addition);
        panel1.add(multiplication);
        panel1.add(subtraction);
        panel1.add(division);
        //add the radiobuttons to one group
        group = new ButtonGroup();
        group.add(addition);
        group.add(multiplication);
        group.add(subtraction);
        group.add(division);
        //layout the frame
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 4));
        input1 = new JTextField(20);
        input2 = new JTextField(20);
        answer = new JButton("Show Answer");
        reset = new JButton("Reset");
        panel2.add(input1);
        panel2.add(input2);
        panel2.add(answer);
        panel2.add(reset);
 
        Container pane = getContentPane();
        setContentPane(pane);
 
        GridLayout grid = new GridLayout(2, 1);
        pane.setLayout(grid);
        //what happens when show answer button is pressed
        answer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                performOperation();
            }
        });
        //what happens when reset button is pressed
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                input1.setText(null);
                input2.setText(null);
            }
        });
 
        pane.add(panel1);
        pane.add(panel2);
 
        setVisible(true);
        setResizable(false);
    }
    //encapsulation of the operations
    private void performOperation() {
        //no operator was chosen
        if (!isOperatorSelected()) {
            showMessage("Please Select an Arithmetic Operator", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //calculation with a try catch for no input
        try {
            double a = Double.parseDouble(input1.getText());
            double b = Double.parseDouble(input2.getText());
            double ans = 0;
            if (addition.isSelected()) {
                ans = a + b;
            } else if (multiplication.isSelected()) {
                ans = a * b;
            } else if (subtraction.isSelected()) {
                ans = a - b;
            } else if (division.isSelected()) {
                if (b != 0) {
                    ans = a / b;
                } else {
                    showMessage("Division by zero is not allowed", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            showMessage("The Answer is: " + ans, "Answer:", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            showMessage("Please Input a Number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    //encapsulation of choosing the operations
    private boolean isOperatorSelected() {
        return addition.isSelected() || multiplication.isSelected() || subtraction.isSelected() || division.isSelected();
    }
    //encapsulation of prompt message
    private void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(null, message, title, messageType);
    }
 
    
}