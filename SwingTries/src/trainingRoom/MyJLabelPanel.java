package trainingRoom;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
public class MyJLabelPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel textLabel;
	private int textWidth=0;
	private Graphics lastGraphic=null;

	MyJLabelPanel(String text){
		setLayout(new BorderLayout());
//		setLayout(null);
		textLabel=new JLabel(text);
		add(textLabel);
	}
	
	@Override
	public void paint(Graphics g) {
		lastGraphic=g;
		textWidth = g.getFontMetrics().stringWidth(textLabel.getText());
//		System.out.println("g.getFontMetrics().stringWidth(textLabel.getText()) = "
//	    +g.getFontMetrics().stringWidth(textLabel.getText()));
		System.out.println("textLabel.getText() = "+textLabel.getText());
		System.out.println("1)g.getFontMetrics().stringWidth(textLabel.getText()) = "+textWidth);
		System.out.flush();

		setSize(g.getFontMetrics().stringWidth(textLabel.getText()), 50);

		System.out.println("2)getSize() = "+getSize());
//		setSize(textWidth, 50);
		super.paint(g);
		System.out.println("2)getSize() = "+getSize());

		textWidth = g.getFontMetrics().stringWidth(textLabel.getText());
		System.out.println("4)g.getFontMetrics().stringWidth(textLabel.getText()) = "+textWidth);
		
	}

	public int getLabelWidth(){
		return textWidth;
	}

	public String getLabelText(){
		return textLabel.getText();
	}

	public Graphics getLastGraphics(){
		return lastGraphic;
	}
}
