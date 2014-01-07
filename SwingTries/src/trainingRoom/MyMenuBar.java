package trainingRoom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class MyMenuBar extends JFrame {

	private static final long serialVersionUID = 2034173426319950685L;

	public MyMenuBar() {
        initUI();
    }

    public final void initUI() {

        JMenuBar menubar = new JMenuBar();
        System.out.println("Qui ci sono");

        Class<? extends MyMenuBar> c=getClass();
        URL iconUrl=c.getResource("exit.png");
		System.out.println("iconUrl= "+iconUrl);
		System.out.println((new File(System.getProperty("user.dir"))).getParent());
		System.out.println(new File(System.getProperty("user.dir")));

        if (iconUrl==null){
        	System.out.println("L'icona è null, chiudo..."); System.exit(ERROR);
        }
        else System.out.println("L'icona c'è");

        ImageIcon icon = new ImageIcon(getClass().getResource("exit.png"));


        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        System.out.println("Qui ci sono");

        JMenuItem eMenuItem = new JMenuItem("Exit", icon);
        eMenuItem.setMnemonic(KeyEvent.VK_E);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        JMenu altro = new JMenu("Altro");
        altro.setMnemonic(KeyEvent.VK_A);

        JMenuItem bMenuItem = new JMenuItem("Boh", icon);
        bMenuItem.setMnemonic(KeyEvent.VK_E);
        bMenuItem.setToolTipText("Si esce anche qui");
        bMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        
        file.add(eMenuItem);
        altro.add(bMenuItem);

        menubar.add(file);
        menubar.add(altro);

        setJMenuBar(menubar);

        setTitle("Simple menu");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MyMenuBar ex = new MyMenuBar();
                ex.setVisible(true);
            }
        });
    }
}
