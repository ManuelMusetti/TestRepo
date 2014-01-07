package trainingRoom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;


public class MyScrollablePanels extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4077783086954846999L;
	private JPanel panel= null;	  

	public MyScrollablePanels() {
		initUI();
	}

	public final void initUI() {

		JPanel tmp=null;

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(30,10,510,260);
		panel.setLayout(new GridLayout(0, 1));
		panel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEtchedBorder(EtchedBorder.RAISED), 
						BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)));

		ImageIcon icon = new ImageIcon(getClass().getResource("exit.png"));
		JButton exitButton = null;

		for (int i=0; i<10; ++i){
			tmp=new JPanel();
			tmp.add(new JCheckBox("CheckBox#"+i));
			exitButton=new JButton(icon);
			tmp.add(exitButton);
			panel.add(tmp);
		}


		add(panel);

		setTitle("Simple toolbar");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MyScrollablePanels ex = new MyScrollablePanels();
				ex.setVisible(true);
			}
		});
	}
}