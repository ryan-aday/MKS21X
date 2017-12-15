import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConverter extends JFrame implements ActionListener{
    private Container pane;
    // private JButton b;
    private JTextField input;
    private JTextField output;

    private ButtonGroup conversions = new ButtonGroup();
    private JRadioButton FC;
    private JRadioButton CF;
    

    public TemperatureConverter(){
	this.setTitle("Temperature Converter");
        this.setSize(600,400);
        this.setLocation(100,100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        pane = this.getContentPane();
        pane.setLayout(new FlowLayout());

        //b = new JButton("Submit");
        input = new JTextField(20);
	FC = new JRadioButton("Fahrenheit to Celcius");
	CF = new JRadioButton("Celcius to Fahrenheit");
	output= new JTextField(20);

	pane.add(input);
	//input.setText("Please input a number:");
	input.addActionListener(this);
	
        pane.add(FC);
	FC.addActionListener(this);

	pane.add(CF);
	CF.addActionListener(this);

	conversions.add(FC);
	conversions.add(CF);
	
        pane.add(output);
	//	output.setText("Answer:");
	output.addActionListener(this);
    }


    public static void main(String[]args){
	TemperatureConverter a= new TemperatureConverter();
	a.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
	String s= e.getActionCommand();
	//System.out.println(s);
	try {
	    if (FC.isSelected()){
		output.setText(Double.toString(FtoC(Double.parseDouble(input.getText())))+ " C");
	    }else if (CF.isSelected()){
		output.setText(Double.toString(CtoF(Double.parseDouble(input.getText())))+ " F");
	    }
	}catch(NumberFormatException nfe){
	    output.setText("Missing numbers for input");
	}
    }
    
    public static double FtoC(double f){
	return (f-32)*5/9;
    }	

    public static double CtoF(double cel){
	return ((9/5)*cel)+32;
    }	    
}
