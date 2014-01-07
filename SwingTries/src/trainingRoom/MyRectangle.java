package trainingRoom;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

class MyCanvas extends JComponent {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void paint(Graphics g) {
	g.setColor(Color.ORANGE);
//	g.drawS
    g.drawRect (10, 10, 200, 200); 
    g.fillRect(10, 10, 200, 200);
  }
}

public class MyRectangle {
  public static void main(String[] a) {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setBounds(30, 30, 400, 400);
//  window.getContentPane().add(new MyCanvas());
    window.getContentPane().add(new MyShape());
    window.setVisible(true);
  }
}