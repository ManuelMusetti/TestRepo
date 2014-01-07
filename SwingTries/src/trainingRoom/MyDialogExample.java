package trainingRoom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class MyDialogExample extends JFrame {

	private static final long serialVersionUID = -8380387912186325405L;

	public MyDialogExample() {

        initUI();
    }

    public final void initUI() {

        JMenuBar menubar = new JMenuBar();

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        JMenu help = new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_H);

        JMenuItem about = new JMenuItem("About");
        help.add(about);

        about.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                MyCustomDialog ad = new MyCustomDialog();
                ad.setVisible(true);
            }
        });

        menubar.add(file);
        menubar.add(help);
        setJMenuBar(menubar);

        setTitle("Simple Dialog");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
            	MyDialogExample sd = new MyDialogExample();
                sd.setVisible(true);
            }
        });
    }
}