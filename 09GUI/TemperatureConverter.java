import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;


public class TemperatureConverter extends JFrame{
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
        pane.add(b);
        pane.add(c);
    }


    public static void main(String[]args){
	TemperatureConverter a= new TemperatureConverter();
	a.setVisible(true);
    }
	/*
	try{
	    if (args[1].equals("ftc")){
		System.out.println(a.FtoC(Double.parseDouble(args[0])));
	    }else System.out.println(a.CtoF(Double.parseDouble(args[0])));
	}
	catch (ArrayIndexOutOfBoundsException e){
	    System.out.println("Fields not inputed");
	}
	*/

    /*public void actionPerformed(ActionEvent e){
	String s= e.getActionCommand();
	System.out.println(s);
	if (c.isSelected() && b.equals("Submit")){
		System.out.println(this.FtoC(Double.parseDouble(t.getText())));
	    }else if (b.equals("Submit")){
		System.out.println(this.CtoF(Double.parseDouble(t.getText())));
	    }else System.out.println("Impossible value to reach");
    }
    */
    
    public static double FtoC(double f){
	System.out.println(f+ " in Fahrenheit to:");
	return (f-32)*5/9;
    }	

    public static double CtoF(double cel){
	System.out.println(cel+ " in Celcius to:");
	return ((9/5)*cel)+32;
    }	    
}  
