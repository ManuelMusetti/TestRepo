package trainingRoom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MyDerivedListener extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyDerivedListener() {

        initUI();
    }

    public final void initUI() {
        
        JPanel panel = new JPanel();
        panel.setLayout(null);

        MyButton closeButton = new MyButton("Close");
        closeButton.setBounds(40, 50, 80, 25);

        panel.add(closeButton);
        add(panel);

        setTitle("Derived class");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    class MyButton extends JButton implements ActionListener {

        /**
		 * 
		 */
		private static final long serialVersionUID = 5241095098827067817L;

		public MyButton(String text) {
            super.setText(text);
            addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                MyDerivedListener ex = new MyDerivedListener();
                ex.setVisible(true);
            }
        });
    }
}

