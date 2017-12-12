import javax.swing.*;
import java.awt.*;
public class Window2 extends JFrame {
    private Container pane;

    private ImageIcon logo;
    private JLabel logoLabel;
    private JButton b;
    private JLabel l;
    private JTextField t;
    private JCheckBox c;

    public void DisplayGUI(){
	

    public Go() {
	this.setTitle("Go: The Game");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
	pane = this.getContentPane()
	pane.setLayout(new FlowLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
	
	logo=new(ImageIcon(getClass().getResource("go_logo.png")


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
	Window2 g = new Window2();
	g.setVisible(true);
    }
}
