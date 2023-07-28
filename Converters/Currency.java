package Converters;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Insets;

public class Currency implements ItemListener, ActionListener {
    JInternalFrame frame;
    JPanel panel;
    JComboBox currC1, currC2;
    JLabel convert, to, enterValue, result, answer, disclaimer;
    JTextField value;
    JButton calculate;
    GridBagConstraints gbc = new GridBagConstraints();
    
    String[] options = {"AED", "AUD", "CAD", "EUR", "GBP", "INR", "KWD", "LKR", "QAR", "SGD", "USD"};
    
    public JInternalFrame getFrame() {
        new Currency();
        return frame;
    }
    
    public Currency() {
        frame = new JInternalFrame("Currency Converter", true, true, true, true);
        
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        
        createPanel();
        
        setGBCLayout();
    
        frame.add(panel);
        frame.setSize(600, 700);
        frame.setVisible(true);
//        frame.getRootPane().setDefaultButton(calculate);
    }
    
    public void createPanel() {
        convert = new JLabel("Convert:");
        formatLabel(convert, 18);
        
        to = new JLabel("to");
        formatLabel(to, 18);
        
        currC1 = new JComboBox(options);
        currC1.addItemListener(this);
        
        currC2 = new JComboBox(options);
        currC2.addItemListener(this);
        
        String selected = String.valueOf(currC1.getSelectedItem());
        enterValue = new JLabel("Enter " + selected + ": ");
        formatLabel(enterValue, 18);
        
        value = new JTextField(12);
        
        String selectedResult = String.valueOf(currC2.getSelectedItem());
        result = new JLabel("Result: ");
        formatLabel(result, 18);
        answer = new JLabel("0 " + selectedResult);
        formatLabel(answer, 18);
        
        calculate = new JButton("Calculate");
        calculate.addActionListener(this);
        
        disclaimer = new JLabel("Exchange rates are taken from Google Finance and are subject to change.");
        formatLabel(disclaimer, 12);
    }
    
    public void setGBCLayout() {
        gbc.insets = new Insets(10, 20, 10, 10);
        gbc.anchor = gbc.LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panel.add(convert, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panel.add(currC1, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panel.add(to, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panel.add(currC2, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panel.add(enterValue, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(value, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panel.add(result, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panel.add(answer, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panel.add(calculate, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        panel.add(disclaimer, gbc);
    }
    
    public void itemStateChanged(ItemEvent e) {
            // if the currC1 combobox is changed
            if (e.getSource() == currC1) {
                enterValue.setText("Enter " + String.valueOf(currC1.getSelectedItem()) + ": ");
            } else if (e.getSource() == currC2) {
                answer.setText("0 " + String.valueOf(currC2.getSelectedItem()));
                formatLabel(answer, 18);
            }
    }
    
    public void actionPerformed(ActionEvent e) {
            calculate();
    }
    
    public JLabel formatLabel(JLabel l, int size) {
        l.setFont(new Font("SF Pro Display", Font.BOLD, size));
        l.setForeground(Color.BLACK);
        return l;
    }
    
    public void calculate() {
        try {
            double x = Double.parseDouble(value.getText());
            double ans = 0;
            String from = String.valueOf(currC1.getSelectedItem());
            String To = String.valueOf(currC2.getSelectedItem());
            String to = String.valueOf(currC2.getSelectedItem());
            String ansString = " ";
            switch (from) {
                case "AED":
                    switch (To) {
                        case "AED":
                            answer.setText(value.getText() + " " + to);
                            break;

                        case "AUD":
                            ans = convert(x, 0.39);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "CAD":
                            ans = convert(x, 0.35);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "EUR":
                            ans = convert(x, 0.24);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "GBP":
                            ans = convert(x, 0.21);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                            
                        case "INR":
                            ans = convert(x, 20.48);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "KWD":
                            ans = convert(x, 0.082);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "LKR":
                            ans = convert(x, 54.96);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "QAR":
                            ans = convert(x, 0.99);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                            
                        case "SGD":
                            ans = convert(x, 0.37);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "USD":
                            ans = convert(x, 0.27);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        default:
                            answer.setText("Error!");
                            break;
                    }
                    break;

                case "AUD":
                    switch (To) {
                        case "AED":
                            ans = convert(x, 2.57);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "AUD":
                            answer.setText(value.getText() + " " + to);
                            break;

                        case "CAD":
                            ans = convert(x, 0.90);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "EUR":
                            ans = convert(x, 0.62);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "GBP":
                            ans = convert(x, 0.53);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                            
                        case "INR":
                            ans = convert(x, 52.72);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "KWD":
                            ans = convert(x, 0.21);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "LKR":
                            ans = convert(x, 141.46);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "QAR":
                            ans = convert(x, 2.55);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                            
                        case "SGD":
                            ans = convert(x, 0.96);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "USD":
                            ans = convert(x, 0.70);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        default:
                            answer.setText("Error!");
                            break;
                    }
                    break;

                case "CAD":
                    switch (To) {
                        case "AED":
                            ans = convert(x, 2.86);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "AUD":
                            ans = convert(x, 1.11);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "CAD":
                            answer.setText(value.getText() + " " + to);
                            break;

                        case "EUR":
                            ans = convert(x, 0.69);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "GBP":
                            ans = convert(x, 0.59);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                            
                        case "INR":
                            ans = convert(x, 58.56);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "KWD":
                            ans = convert(x, 0.24);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "LKR":
                            ans = convert(x, 157.13);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "QAR":
                            ans = convert(x, 2.83);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                            
                        case "SGD":
                            ans = convert(x, 1.07);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "USD":
                            ans = convert(x, 0.78);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        default:
                            answer.setText("Error!");
                            break;
                    }
                    break;

                case "EUR":
                    switch (To) {
                        case "AED":
                            ans = convert(x, 4.16);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "AUD":
                            ans = convert(x, 1.62);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "CAD":
                            ans = convert(x, 1.46);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "EUR":
                            answer.setText(value.getText() + " " + to);
                            break;

                        case "GBP":
                            ans = convert(x, 0.86);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                            
                        case "INR":
                            ans = convert(x, 85.13);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "KWD":
                            ans = convert(x, 0.34);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "LKR":
                            ans = convert(x, 228.41);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "QAR":
                            ans = convert(x, 4.12);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                            
                        case "SGD":
                            ans = convert(x, 1.55);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "USD":
                            ans = convert(x, 1.13);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        default:
                            answer.setText("Error!");
                            break;
                    }
                    break;

                case "GBP":
                    switch (To) {
                        case "AED":
                            ans = convert(x, 4.86);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "AUD":
                            ans = convert(x, 1.89);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "CAD":
                            ans = convert(x, 1.70);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "EUR":
                            ans = convert(x, 1.17);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "GBP":
                            answer.setText(value.getText() + " " + to);
                            break;
                            
                        case "INR":
                            ans = convert(x, 99.56);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "KWD":
                            ans = convert(x, 0.40);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "LKR":
                            ans = convert(x, 267.15);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "QAR":
                            ans = convert(x, 4.82);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                            
                        case "SGD":
                            ans = convert(x, 1.82);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "USD":
                            ans = convert(x, 1.32);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        default:
                            answer.setText("Error!");
                            break;
                    }
                    break;
                    
                case "INR":
                    switch (To) {
                        case "AED":
                            ans = convert(x, 0.049);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "AUD":
                            ans = convert(x, 0.019);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "CAD":
                            ans = convert(x, 0.017);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "EUR":
                            ans = convert(x, 0.012);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "GBP":
                            ans = convert(x, 0.01);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                            
                        case "INR":
                            answer.setText(value.getText() + " " + to);
                            break;

                        case "KWD":
                            ans = convert(x, 0.004);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "LKR":
                            ans = convert(x, 2.68);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "QAR":
                            ans = convert(x, 0.048);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                            
                        case "SGD":
                            ans = convert(x, 0.018);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "USD":
                            ans = convert(x, 0.01336);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        default:
                            answer.setText("Error!");
                            break;
                    }
                    break;
                    
                case "KWD":
                    switch (To) {
                        case "AED":
                            ans = convert(x, 12.15);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "AUD":
                            ans = convert(x, 4.63);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "CAD":
                            ans = convert(x, 4.22);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "EUR":
                            ans = convert(x, 2.92);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "GBP":
                            ans = convert(x, 2.48);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                            
                        case "INR":
                            ans = convert(x, 247.62);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "KWD":
                            answer.setText(value.getText() + " " + to);
                            break;

                        case "LKR":
                            ans = convert(x, 668.66);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "QAR":
                            ans = convert(x, 12.05);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                            
                        case "SGD":
                            ans = convert(x, 4.51);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "USD":
                            ans = convert(x, 3.31);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        default:
                            answer.setText("Error!");
                            break;
                    }
                    break;
                    
                case "LKR":
                    switch (To) {
                        case "AED":
                            ans = convert(x, 0.018);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "AUD":
                            ans = convert(x, 0.0071);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "CAD":
                            ans = convert(x, 0.0064);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "EUR":
                            ans = convert(x, 0.0044);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "GBP":
                            ans = convert(x, 0.0037);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                            
                        case "INR":
                            ans = convert(x, 0.37);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "KWD":
                            ans = convert(x, 0.0015);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "LKR":
                            answer.setText(value.getText() + " " + to);
                            break;

                        case "QAR":
                            ans = convert(x, 0.018);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                            
                        case "SGD":
                            ans = convert(x, 0.0068);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "USD":
                            ans = convert(x, 0.005);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        default:
                            answer.setText("Error!");
                            break;
                    }
                    break;
                    
                case "QAR":
                    switch (To) {
                        case "AED":
                            ans = convert(x, 1.01);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "AUD":
                            ans = convert(x, 0.39);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "CAD":
                            ans = convert(x, 0.35);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "EUR":
                            ans = convert(x, 0.24);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "GBP":
                            ans = convert(x, 0.21);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                            
                        case "INR":
                            ans = convert(x, 21.67);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "KWD":
                            ans = convert(x, 0.083);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "LKR":
                            ans = convert(x, 55.45);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "QAR":
                            answer.setText(value.getText() + " " + to);
                            break;
                            
                        case "SGD":
                            ans = convert(x, 0.38);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "USD":
                            ans = convert(x, 0.27);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        default:
                            answer.setText("Error!");
                            break;
                    }
                    break;
                    
                case "SGD":
                    switch (To) {
                        case "AED":
                            ans = convert(x, 2.68);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "AUD":
                            ans = convert(x, 1.04);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "CAD":
                            ans = convert(x, 0.94);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "EUR":
                            ans = convert(x, 0.64);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "GBP":
                            ans = convert(x, 0.55);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                            
                        case "INR":
                            ans = convert(x, 54.82);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "KWD":
                            ans = convert(x, 0.22);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "LKR":
                            ans = convert(x, 147.09);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "QAR":
                            ans = convert(x, 2.65);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                            
                        case "SGD":
                            answer.setText(value.getText() + " " + to);
                            break;

                        case "USD":
                            ans = convert(x, 0.73);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        default:
                            answer.setText("Error!");
                            break;
                    }
                    break;
                    
                case "USD":
                    switch (To) {
                        case "AED":
                            ans = convert(x, 3.67);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "AUD":
                            ans = convert(x, 1.43);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "CAD":
                            ans = convert(x, 1.28);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "EUR":
                            ans = convert(x, 0.88);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "GBP":
                            ans = convert(x, 0.76);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                            
                        case "INR":
                            ans = convert(x, 75.24);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "KWD":
                            ans = convert(x, 0.30);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "LKR":
                            ans = convert(x, 201.89);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "QAR":
                            ans = convert(x, 3.64);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                            
                        case "SGD":
                            ans = convert(x, 1.37);
                            ansString = String.format("%.4f", ans);
                            answer.setText(ansString + " " + to);
                            break;

                        case "USD":
                            answer.setText(value.getText() + " " + to);
                            break;

                        default:
                            answer.setText("Error!");
                            break;
                    }
                    break;

                default:
                    answer.setText("default");
                    break;
            }
        } catch(NumberFormatException e) {
            answer.setText("Error!");
        }
        
    }
    
    public double convert(double amount, double exchange) {
        double answer = 0;
        answer = amount * exchange;
        return answer;
    }
}
