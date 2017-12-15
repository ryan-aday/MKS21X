import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConverter extends JFrame implements ActionListener{
    private Container pane;
    private JButton b;
    private JTextField t;
    private JCheckBox c;
    

    public TemperatureConverter(){
	this.setTitle("Temperature Converter");
        this.setSize(600,400);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        pane = this.getContentPane();
        pane.setLayout(new FlowLayout());

        b = new JButton("Submit");
        t = new JTextField(20);
	c = new JCheckBox("FTC?");

	pane.add(t);
	t.addActionListener(this);
	
        pane.add(b);
	b.addActionListener(this);
	
        pane.add(c);
	c.addActionListener(this);
    }


    public static void main(String[]args){
	TemperatureConverter a= new TemperatureConverter();
	a.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
	String s= e.getActionCommand();
	System.out.println(s);
	if (c.isSelected() && s.equals("Submit")){
		System.out.println(this.FtoC(Double.parseDouble(t.getText())));
	    }else if (s.equals("Submit")){
		System.out.println(this.CtoF(Double.parseDouble(t.getText())));
	    }else System.out.println("Impossible value to reach");
    }
    
    public static double FtoC(double f){
	return (f-32)*5/9;
    }	

    public static double CtoF(double cel){
	return ((9/5)*cel)+32;
    }	    
}
