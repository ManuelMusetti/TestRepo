package trainingRoom;


import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FirstJFrame extends JFrame {

	private static final long serialVersionUID = 2035170485753682251L;


	public FirstJFrame() {
        
       setTitle("Mio Primo Esempio");
       setSize(600, 200);
       setBackground(Color.CYAN);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);        
    }
    

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	FirstJFrame ex = new FirstJFrame();
                ex.setVisible(true);
            }
        });
    }
}