import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;

public class Go extends JFrame {
    private Container pane;

    private ImageIcon logo;
    private JLabel logoLabel;
    private JButton b;
    private JLabel l;
    private JTextField t;
    private JCheckBox c;

    public void Go() {
	this.setTitle("Go: The Game");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
	
	try{
	    BufferedImage img = ImageIO.read(new File("./go_logo.png"));
	    logo = new ImageIcon(img);
	    JLabel logoDisp= new JLabel(logo);
	    pane.add(logoDisp);
	}

	catch(IOException ie){
	    System.out.println("Error reading logo img file");
	}

	b = new JButton("Do Nothing");
	l = new JLabel("This is AWESOME! (lies)",null,JLabel.CENTER);
	t = new JTextField(12);
	c = new JCheckBox("Overclock!!!");
	pane.add(l);
	pane.add(b);
	pane.add(t);
	pane.add(c);
    }
    
    //MAIN JUST INSTANTIATES + MAKE VISIBLE
    public static void main(String[] args) {
	Go g = new Go();
	g.setVisible(true);
    }
}
