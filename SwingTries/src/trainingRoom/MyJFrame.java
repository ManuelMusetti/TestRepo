package trainingRoom;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyJFrame extends JFrame {

	public static enum MyColors{Rosso, Blu, Verde, Nessuno};
	private static final long serialVersionUID = 8480441190566654046L;

	public MyJFrame() {
	  setTitle("MyJFrame");
	  setSize(600, 300);
	  setLocationRelativeTo(null);
	  setDefaultCloseOperation(EXIT_ON_CLOSE);   
	}

	public static MyJFrame getMyJFrame(MyColors color) {
	  System.out.println("1"); System.out.flush();
	  MyJFrame frame = new MyJFrame();
	  System.out.println("1");
	  JPanel jpan= new JPanel();	  
	  switch(color){
	  	case Rosso: jpan.setBackground(Color.RED); break;  
	  	case Blu: jpan.setBackground(Color.BLUE); break;  
	  	case Verde: jpan.setBackground(Color.GREEN); break;
	  	case Nessuno: jpan.setBackground(null); jpan.setOpaque(false); break;
	  	default: jpan.setBackground(Color.BLACK); break;  
	  }
	  
	  frame.getContentPane().add(jpan);	  
	  return frame;
	}

}