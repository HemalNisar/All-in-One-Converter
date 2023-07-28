package Converters;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Insets;

public class Time implements ItemListener, ActionListener {
    JInternalFrame frame;
    JPanel panel;
    JComboBox timeC1, timeC2;
    JLabel convert, to, enterValue, result, answer;
    JTextField value;
    JButton calculate;
    GridBagConstraints gbc = new GridBagConstraints();
    
    String[] options = {"Days", "Hours", "Minutes", "Seconds"};
    
    public JInternalFrame getFrame() {
        new Time();
        return frame;
    }
    
    public Time() {
        frame = new JInternalFrame("Time Converter", true, true, true, true);
        
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        
        createPanel();
        
        setGBCLayout();
    
        frame.add(panel);
        frame.setSize(400, 700);
        frame.setVisible(true);
//        frame.getRootPane().setDefaultButton(calculate);
    }
    
    public void createPanel() {
        convert = new JLabel("Convert:");
        formatLabel(convert);
        
        to = new JLabel("to");
        formatLabel(to);
        
        timeC1 = new JComboBox(options);
        timeC1.addItemListener(this);
        
        timeC2 = new JComboBox(options);
        timeC2.addItemListener(this);
        
        String selected = String.valueOf(timeC1.getSelectedItem());
        enterValue = new JLabel("Enter time in " + selected + ": ");
        formatLabel(enterValue);
        
        value = new JTextField(12);
        
        String selectedResult = String.valueOf(timeC2.getSelectedItem());
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
        panel.add(timeC1, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panel.add(to, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panel.add(timeC2, gbc);
        
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
            // if the timeC1 combobox is changed
            if (e.getSource() == timeC1) {
                enterValue.setText("Enter time in " + timeC1.getSelectedItem() + ": ");
            } else if (e.getSource() == timeC2) {
                answer.setText("0 " + timeC2.getSelectedItem());
                formatLabel(answer);
            }
    }
    
    public void actionPerformed(ActionEvent e) {
            calculate();
    }
    
    public JLabel formatLabel(JLabel l) {
        l.setFont(new Font("SF Pro Display", Font.BOLD, 18));
        l.setForeground(Color.BLACK);
        return l;
    }

    public void calculate() {
        try {
            double x = Double.parseDouble(value.getText());
            double ans = 0;
            String from = String.valueOf(timeC1.getSelectedItem());
            String to = String.valueOf(timeC2.getSelectedItem());
            switch (from) {
                case "Days":
                    switch (to) {
                        case "Days":
                            answer.setText(value.getText() + " " + timeC2.getSelectedItem());
                            break;
                            
                        case "Hours":
                            ans = DayToHr(x);
                            answer.setText(ans + " " + timeC2.getSelectedItem());
                            break;
                        
                        case "Minutes":
                            ans = DayToMin(x);
                            answer.setText(ans + " " + timeC2.getSelectedItem());
                            break;
                        
                        case "Seconds":
                            ans = DayToSec(x);
                            answer.setText(ans + " " + timeC2.getSelectedItem());
                            break;
                        
                        default:
                            answer.setText("Error!");
                            break;
                    }
                    break;
                    
                case "Hours":
                    String ansString = "";
                    switch (to) {
                        case "Days":
                            ansString = HrToDay(x);
                            answer.setText(ansString);
                            break;
                        
                        case "Hours":
                            answer.setText(value.getText() + " " + timeC2.getSelectedItem());
                            break;
                        
                        case "Minutes":
                            ans = HrToMin(x);
                            answer.setText(ans + " " + timeC2.getSelectedItem());
                            break;
                        
                        case "Seconds":
                            ans = HrToSec(x);
                            answer.setText(ans + " " + timeC2.getSelectedItem());
                            break;
                        
                        default:
                            answer.setText("Error!");
                            break;
                    }
                    break;
                    
                case "Minutes":
                    ansString = "";
                    switch (to) {
                        case "Days":
                            ansString = MinToDay(x);
                            answer.setText(ansString);
                            break;
                        
                        case "Hours":
                            ans = MinToHour(x);
                            ansString = String.format("%.2f", ans);
                            answer.setText(ansString + " " + timeC2.getSelectedItem());
                            break;
                        
                        case "Minutes":
                            answer.setText(value.getText() + " " + timeC2.getSelectedItem());
                            break;
                        
                        case "Seconds":
                            ans = MinToSec(x);
                            ansString = String.format("%.2f", ans);
                            answer.setText(ansString + " " + timeC2.getSelectedItem());
                            break;
                        
                        default:
                            answer.setText("Error!");
                            break;
                    }
                    break;
                    
                case "Seconds":
                    ansString = "";
                    switch (to) {
                        case "Days":
                            ansString = SecToDay(x);
                            answer.setText(ansString);
                            break;
                        
                        case "Hours":
                            ans = SecToHour(x);
                            ansString = String.format("%.2f", ans);
                            answer.setText(ansString + " " + timeC2.getSelectedItem());
                            break;
                        
                        case "Minutes":
                            ans = SecToMin(x);
                            ansString = String.format("%.2f", ans);
                            answer.setText(ansString + " " + timeC2.getSelectedItem());
                            break;
                        
                        case "Seconds":
                            answer.setText(value.getText() + " " + timeC2.getSelectedItem());
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
    
    
    
    /** Calculate Functions */
    public double DayToHr(double Day) {
        double hours = 0;
        hours = Day * 24;
        return hours;
    }
    
    public double DayToMin(double Day) {
        double minutes = 0;
        minutes = Day * 24 * 60;
        return minutes;
    }
    
    public double DayToSec(double Day) {
        double seconds = 0;
        seconds = Day * 24 * 60 * 60;
        return seconds;
    }
    
    public String HrToDay(double Hours) {
        double days = 0;
        days = Hours / 24; // 2.3333333
        int daysInt = (int)days; // 2
        double daysDecimal = days-daysInt; // 2.33333-2 = 0.3333333
        int remainingHours = (int)(daysDecimal*24); // 7.999999 --> (int)7.9999 == 8
        
        String daysString = "";
        
        if (daysInt == 1 && remainingHours == 1) {
            daysString = String.valueOf(daysInt) + " day and " + String.valueOf(remainingHours) + " hour";
        } else if (daysInt == 1) {
            daysString = String.valueOf(daysInt) + " day and " + String.valueOf(remainingHours) + " hours";
        } else if (remainingHours == 1) {
            daysString = String.valueOf(daysInt) + " days and " + String.valueOf(remainingHours) + " hour";
        } else {
            daysString = String.valueOf(daysInt) + " days and " + String.valueOf(remainingHours) + " hours";
        }
        
        return daysString;
    }
    
    public double HrToMin(double Hours) {
        double Minutes = 0;
        Minutes = Hours * 60;
        return Minutes;
    }
    
    public double HrToSec(double Hours) {
        double Seconds = 0;
        Seconds= Hours * 3600;
        return Seconds;
    }
    
    public String MinToDay(double Minutes) {
        double days = 0;
        days = Minutes / (24*60) ;
        int daysInt = (int)days;
        double daysDecimal = days-daysInt;
        
        int remainingHours = (int)(daysDecimal*24);
        
        String daysString = "";
        
        if (daysInt == 1 && remainingHours == 1) {
            daysString = String.valueOf(daysInt) + " day and " + String.valueOf(remainingHours) + " hour";
        } else if (daysInt == 1) {
            daysString = String.valueOf(daysInt) + " day and " + String.valueOf(remainingHours) + " hours";
        } else if (remainingHours == 1) {
            daysString = String.valueOf(daysInt) + " days and " + String.valueOf(remainingHours) + " hour";
        } else {
            daysString = String.valueOf(daysInt) + " days and " + String.valueOf(remainingHours) + " hours";
        }
        
        if (daysInt == 0 && remainingHours == 0) {
            daysString += " " + value.getText() + " minutes";
        }
        return daysString;
    }
    
    public double MinToHour(double Minutes) {
        double Hours = 0;
        Hours= Minutes / 60;
        return Hours;
    }
    
    public double MinToSec(double Minutes) {
        double Seconds = 0;
        Seconds = Minutes * 60;
        return Seconds;
    }
    
    public String SecToDay(double Seconds) {
        double days = 0;
        days = Seconds / (24*60*60) ;
        int daysInt = (int)days;
        double daysDecimal = days-daysInt;
        
        int remainingHours = (int)(daysDecimal*24);
        
        String daysString = "";
        
        if(daysInt == 0 && remainingHours == 0) {
            double minutes = Seconds/60;
            int minuteInt = (int)minutes;
            double minuteDecimal = minutes-minuteInt;
            
            int remainingSeconds = (int)(minuteDecimal*60);
            daysString = "0d 0h " + String.valueOf(minuteInt) + " minutes and " + String.valueOf(remainingSeconds) + " seconds";
            return daysString;
        }
        
        if (daysInt == 1 && remainingHours == 1) {
            daysString = String.valueOf(daysInt) + " day and " + String.valueOf(remainingHours) + " hour";
        } else if (daysInt == 1) {
            daysString = String.valueOf(daysInt) + " day and " + String.valueOf(remainingHours) + " hours";
        } else if (remainingHours == 1) {
            daysString = String.valueOf(daysInt) + " days and " + String.valueOf(remainingHours) + " hour";
        } else {
            daysString = String.valueOf(daysInt) + " days and " + String.valueOf(remainingHours) + " hours";
        }
        return daysString;
    }
    
    public double SecToHour(double Seconds) {
        double Hours = 0;
        Hours= Seconds / 3600;
        return Hours;
    }
    
    public double SecToMin(double Seconds) {
        double Minutes = 0;
        Minutes = Seconds / 60;
        return Minutes;
    }
}
