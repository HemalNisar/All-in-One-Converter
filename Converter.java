import Converters.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class Converter {
    JDesktopPane desk;
    JInternalFrame frame1, frame2, frame3;
    JFrame frame;
    Box titleBox = Box.createVerticalBox();
    
    public static void main(String[] args) {
        Converter d = new Converter();
    }
    
    public Converter() {
        frame = new JFrame("Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        createTitle();
        
        createDesktopPane();
        
        frame.add(desk);
        frame.setSize(1500, 830);
        frame.setVisible(true);
        frame.setLayout(null);
    }
    
    public void createTitle() {
        JLabel homeTitle = new JLabel("Converter");
        formatLabel(homeTitle, 56);
        
        JLabel homeSubtitle = new JLabel("A project by Heena (2003111), Krish (2003117), Hemal (2003126)");
        formatLabel(homeSubtitle, 18);
        
        titleBox.setBounds(225, 0, 1000, 300);
        titleBox.add(homeTitle);
        titleBox.add(homeSubtitle);
    }
    
    public void createDesktopPane() {
        desk = new JDesktopPane();
        
        Time timeConverter = new Time();
        Distance distanceConverter = new Distance();
        Currency currencyConverter = new Currency();
        
        frame1 = timeConverter.getFrame();
        frame1.setBounds(50, 100, 450, 675);
        frame1.setVisible(true);
        
        frame2 = distanceConverter.getFrame();
        frame2.setBounds(500, 100, 450, 675);
        frame2.setVisible(true);
        
        frame3 = currencyConverter.getFrame();
        frame3.setBounds(950, 100, 450, 675);
        frame3.setVisible(true);
        
        desk.add(frame1);
        desk.add(frame2);
        desk.add(frame3);
        desk.add(titleBox);
    }
    
    public JLabel formatLabel(JLabel l, int size) {
        l.setAlignmentX(Component.CENTER_ALIGNMENT);
        l.setFont(new Font("SF Pro Display", Font.BOLD, size));
        l.setForeground(Color.WHITE);
        return l;
    }
}
