package trainingRoom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyJTransparentButton extends JButton {

    public MyJTransparentButton (String text){
        super(text);
        setBorder(null);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Cliccato!");
			}
		});
    }

    // sample test method
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel pane = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane.add(new MyJTransparentButton("HI!!!!"));
        frame.add(pane);
        frame.pack();
        frame.setVisible(true);
    }
}