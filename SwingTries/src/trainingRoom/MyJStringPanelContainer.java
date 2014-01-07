package trainingRoom;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;


class MyJStringPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel textLabel=null;
	private int textWidth=0;

	MyJStringPanel(String text){
		setLayout(new BorderLayout());
		textLabel=new JLabel(text);
		add(textLabel);
	}
	
	@Override
	public void paint(Graphics g) {
		textWidth = g.getFontMetrics().stringWidth(textLabel.getText());
//		System.out.println("g.getFontMetrics().stringWidth(textLabel.getText()) = "
//	    +g.getFontMetrics().stringWidth(textLabel.getText()));
		System.out.println("textLabel.getText() = "+textLabel.getText());
		System.out.println("1)g.getFontMetrics().stringWidth(textLabel.getText()) = "+textWidth);
		System.out.flush();

		setSize(g.getFontMetrics().stringWidth(textLabel.getText()), 50);
//		setSize(textWidth, 50);
		super.paint(g);
		textWidth = g.getFontMetrics().stringWidth(textLabel.getText());
		System.out.println("2)g.getFontMetrics().stringWidth(textLabel.getText()) = "+textWidth);
		
	}
	
	public int getTextWidth(){
		return textWidth;
	}
}


public class MyJStringPanelContainer {

}
