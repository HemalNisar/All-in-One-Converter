package Converters;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Insets;

public class Distance implements ItemListener, ActionListener {
    JInternalFrame frame;
    JPanel panel;
    JComboBox distC1, distC2;
    JLabel convert, to, enterValue, result, answer;
    JTextField value;
    JButton calculate;
    GridBagConstraints gbc = new GridBagConstraints();
    
    String[] options = {"Kilometers", "Meters", "Feet", "Miles", "Yards"};
    
    public JInternalFrame getFrame() {
        new Distance();
        return frame;
    }
    
    public Distance() {
        frame = new JInternalFrame("Distance Converter", true, true, true, true);
        
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
        formatLabel(convert);
        
        to = new JLabel("to");
        formatLabel(to);
        
        distC1 = new JComboBox(options);
        distC1.addItemListener(this);
        
        distC2 = new JComboBox(options);
        distC2.addItemListener(this);
        
        String selected = String.valueOf(distC1.getSelectedItem()).toLowerCase();
        enterValue = new JLabel("Enter " + selected + ": ");
        formatLabel(enterValue);
        
        value = new JTextField(12);
        
        String selectedResult = String.valueOf(distC2.getSelectedItem()).toLowerCase();
        result = new JLabel("Result: ");
        formatLabel(result);
        answer = new JLabel("0 " + selectedResult);
        formatLabel(answer);
        
        calculate = new JButton("Calculate");
        calculate.addActionListener(this);
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
        panel.add(distC1, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panel.add(to, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panel.add(distC2, gbc);
        
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
    }
    
    public void itemStateChanged(ItemEvent e) {
            // if the distC1 combobox is changed
            if (e.getSource() == distC1) {
                enterValue.setText("Enter " + String.valueOf(distC1.getSelectedItem()).toLowerCase() + ": ");
            } else if (e.getSource() == distC2) {
                answer.setText("0 " + String.valueOf(distC2.getSelectedItem()).toLowerCase());
                formatLabel(answer);
            }
    }
    
    public void actionPerformed(ActionEvent e) {
            calculate();
    }
    
    public void calculate() {
        try {
            double x = Double.parseDouble(value.getText());
            double ans = 0;
            String from = String.valueOf(distC1.getSelectedItem());
            String To = String.valueOf(distC2.getSelectedItem());
            String to = String.valueOf(distC2.getSelectedItem()).toLowerCase();
            String ansString = " ";
            switch (from) {
                case "Kilometers":
                    switch (To) {
                        case "Kilometers":
                            answer.setText(value.getText() + " " + to);
                            break;
                        
                        case "Feet":
                            ans = KMToFeet(x);
    //                        answer.setText(ans + " " + to);
                            ansString = String.format("%.3f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                        
                        case "Meters":
                            ans = KMToMeter(x);
                            ansString = String.format("%.3f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                        
                        case "Miles":
                            ans = KMToMile(x);
                            ansString = String.format("%.3f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                            
                        case "Yards":
                            ans = KMToYards(x);
                            ansString = String.format("%.3f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                        
                        default:
                            answer.setText("Error!");
                            break;
                    }
                    break;
                    
                case "Feet":
                    switch (To) {
                        case "Kilometers":
                            ans = FeetToKM(x);
                            ansString = String.format("%.3f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                        
                        case "Feet":
                            answer.setText(value.getText() + " " + to);
                            break;
                        
                        case "Meters":
                            ans = FeetToMeters(x);
                            ansString = String.format("%.3f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                        
                        case "Miles":
                            ans = FeetToMiles(x);
                            ansString = String.format("%.3f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                            
                        case "Yards":
                            ans = FeetToYards(x);
                            ansString = String.format("%.3f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                        
                        default:
                            answer.setText("Error!");
                            break;
                    }
                    break;
                    
                case "Meters":
                    
                    switch (To) {
                        case "Kilometers":
                            ans = MeterToKM(x);
                            ansString = String.format("%.3f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                        
                        case "Feet":
                            ans = MeterToFeet(x);
                            ansString = String.format("%.3f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                        
                        case "Meters":
                            answer.setText(value.getText() + " " + to);
                            break;
                        
                        case "Miles":
                            ans = MeterToMiles(x);
                            ansString = String.format("%.3f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                            
                        case "Yards":
                            ans = MeterToYards(x);
                            ansString = String.format("%.3f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                        
                        default:
                            answer.setText("Error!");
                            break;
                    }
                    break;
                    
                case "Miles":
                    
                    switch (To) {
                        case "Kilometers":
                            ans = MileToKM(x);
                            ansString = String.format("%.3f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                        
                        case "Feet":
                            ans = MileToFeet(x);
                            ansString = String.format("%.3f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                        
                        case "Meters":
                            ans = MileToMeters(x);
                            ansString = String.format("%.3f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                        
                        case "Miles":
                            answer.setText(value.getText() + " " + to);
                            break;
                            
                        case "Yards":
                            ans = MileToYards(x);
                            ansString = String.format("%.3f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                        
                        default:
                            answer.setText("Error!");
                            break;
                    }
                    break;
                    
                case "Yards":
                    
                    switch (To) {
                        case "Kilometers":
                            ans = YardsToKM(x);
                            ansString = String.format("%.3f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                        
                        case "Feet":
                            ans = YardsToFeet(x);
                            ansString = String.format("%.3f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                        
                        case "Meters":
                            ans = YardsToMeters(x);
                            ansString = String.format("%.3f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                        
                        case "Miles":
                            ans = YardsToMiles(x);
                            ansString = String.format("%.3f", ans);
                            answer.setText(ansString + " " + to);
                            break;
                            
                        case "Yards":
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
    
    public JLabel formatLabel(JLabel l) {
        l.setFont(new Font("SF Pro Display", Font.BOLD, 18));
        l.setForeground(Color.BLACK);
        return l;
    }
    
    /** Calculate functions */
    
    // KM to...
    public double KMToMeter(double KM) {
        double Meters=0;
        Meters = KM * 1000;
        return Meters;
    }
    public double KMToMile(double KM) {
        double Miles = 0;
        Miles = KM * 0.621371;
        return Miles;
    }
    public double KMToFeet(double KM) {
        double Feet=0;
        Feet = KM * 3280.84;
        return Feet;
    }
    public double KMToYards(double KM) {
        double Yards=0;
        Yards = KM * 1093.61;
        return Yards;
    }
    
    // Meters to...
    public double MeterToKM(double Meters) {
        double KM=0;
        KM = Meters / 1000;
        return KM;
    }
    public double MeterToFeet(double Meters) {
        double Feet = 0;
        Feet = Meters * 3.28084;
        return Feet;
    }
    public double MeterToYards(double Meters) {
        double Yards = 0;
        Yards = Meters * 1.09361;
        return Yards;
    }
    public double MeterToMiles(double Meters) {
        double Miles=0;
        Miles = Meters * 0.000621371;
        return Miles;
    }
    
    // Feet to...
    public double FeetToKM(double Feet) {
        double KM=0;
        KM = Feet * 0.0003048;
        return KM;
    }
    public double FeetToMeters(double Feet) {
        double Meters=0;
        Meters = Feet * 0.3048;
        return Meters;
    }
    public double FeetToMiles(double Feet) {
        double Miles=0;
        Miles = Feet * 0.000189394;
        return Miles;
    }
    public double FeetToYards(double Feet) {
        double Yards=0;
        Yards = Feet * 0.333333;
        return Yards;
    }
    
    // Miles to...
    public double MileToKM(double Miles) {
        double KM = 0;
        KM = Miles * 1.60934;
        return KM;
    }
    public double MileToMeters(double Miles) {
        double Meters = 0;
        Meters = Miles * 1609.34;
        return Meters;
    }
    public double MileToFeet(double Miles) {
        double Feet = 0;
        Feet = Miles * 5280;
        return Feet;
    }
    public double MileToYards(double Miles) {
        double Yards = 0;
        Yards = Miles * 1760;
        return Yards;
    }
    
    // Yards to...
    public double YardsToKM(double Yards) {
        double KM = 0;
        KM = Yards * 0.0009144;
        return KM;
    }
    public double YardsToMeters(double Yards) {
        double Meters = 0;
        Meters = Yards * 0.9144;
        return Meters;
    }
    public double YardsToFeet(double Yards) {
        double Feet = 0;
        Feet = Yards * 3;
        return Feet;
    }
    public double YardsToMiles(double Yards) {
        double Miles = 0;
        Miles = Yards * 0.000568182;
        return Miles;
    }
}
