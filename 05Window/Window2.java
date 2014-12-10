
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Window2 extends JFrame implements ActionListener{
    private Container pane;

    private JButton b;
    private JButton cel;
    private JLabel l;
    private JTextField t;
    public Window2() {
	this.setTitle("Temperature converter");
	this.setSize(600,100);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);


	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	b = new JButton("Farenheit to Celcius");
	cel = new JButton("Celcius to Farenheit");
	l = new JLabel("hey, buddy, wanna convert temperatures?"+"\n",null,JLabel.CENTER);
	t = new JTextField(12);
	pane.add(l);
	pane.add(b);
	pane.add(cel);
	pane.add(t);
	t.setText("0");
	b.addActionListener(this);
	b.setActionCommand("toCel");
	cel.addActionListener(this);
	cel.setActionCommand("toFar");
    }

    public void actionPerformed(ActionEvent e){
	float x = Float.parseFloat(t.getText());
	if(e.getActionCommand() == "toCel"){
	    t.setText(""+((x - 32)/1.8));
	}
	if(e.getActionCommand() == "toFar"){
	    t.setText(""+((1.8*x) + 32));
	}
    }

    public static void main(String[] args) {
        Window2 g = new Window2();
        g.setVisible(true);
    }
}