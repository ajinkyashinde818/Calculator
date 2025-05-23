import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class calculator implements ActionListener {
    JFrame frame;
    JTextField text;
    JButton[] numButtons = new JButton[10];
    JButton addButton, subButton, MulButton, DivButton;
    JButton eqButton, delButton, clrButton, decButton;
    JPanel panel;

    Font myFont = new Font("Ink", Font.BOLD, 30);
    double num1 = 0, num2 = 0, res = 0;
    char operation;

    calculator() {
        frame = new JFrame("My Calculator");
        frame.setLayout(null);
        frame.setSize(420, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        text = new JTextField();
        text.setBounds(50, 25, 300, 50);
        text.setFont(myFont);
        text.setEditable(false);
        frame.add(text);

        addButton = new JButton("+");
        subButton = new JButton("-");
        MulButton = new JButton("*");
        DivButton = new JButton("/");
        eqButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        decButton = new JButton(".");

        JButton[] funButtons = {addButton, subButton, MulButton, DivButton, eqButton, delButton, clrButton, decButton};

        for (JButton btn : funButtons) {
            btn.addActionListener(this);
            btn.setFont(myFont);
            btn.setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
            numButtons[i].setFont(myFont);
            numButtons[i].setFocusable(false);
        }

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.LIGHT_GRAY);

        // Add buttons to panel in calculator order
        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(addButton);
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(subButton);
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(MulButton);
        panel.add(decButton);
        panel.add(numButtons[0]);
        panel.add(eqButton);
        panel.add(DivButton);

        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numButtons[i]) {
                text.setText(text.getText() + i);
            }
        }
        if (e.getSource() == decButton) {
            String current = text.getText();
            if (!current.contains(".")) {
                if (current.isEmpty()) {
                    text.setText("0.");
                } else {
                    text.setText(current + ".");
                }
            }
        }
        if (e.getSource() == addButton) {
            if (!text.getText().isEmpty()) {
                num1 = Double.parseDouble(text.getText());
                operation = '+';
                text.setText("");
            }
        }
        if (e.getSource() == subButton) {
            if (!text.getText().isEmpty()) {
                num1 = Double.parseDouble(text.getText());
                operation = '-';
                text.setText("");
            }
        }
        if (e.getSource() == MulButton) {
            if (!text.getText().isEmpty()) {
                num1 = Double.parseDouble(text.getText());
                operation = '*';
                text.setText("");
            }
        }
        if (e.getSource() == DivButton) {
            if (!text.getText().isEmpty()) {
                num1 = Double.parseDouble(text.getText());
                operation = '/';
                text.setText("");
            }
        }
        if (e.getSource() == eqButton) {
            if (!text.getText().isEmpty()) {
                num2 = Double.parseDouble(text.getText());
                switch (operation) {
                    case '+':
                        res = num1 + num2;
                        break;
                    case '-':
                        res = num1 - num2;
                        break;
                    case '*':
                        res = num1 * num2;
                        break;
                    case '/':
                        if (num2 != 0) {
                            res = num1 / num2;
                        } else {
                            text.setText("Error");
                            return;
                        }
                        break;
                }
                text.setText(String.valueOf(res));
                num1 = res;
            }
        }
        if (e.getSource() == clrButton) {
            text.setText("");
            num1 = num2 = res = 0;
        }
        if (e.getSource() == delButton) {
            String s = text.getText();
            if (s.length() > 0) {
                text.setText(s.substring(0, s.length() - 1));
            }
        }
    }
}