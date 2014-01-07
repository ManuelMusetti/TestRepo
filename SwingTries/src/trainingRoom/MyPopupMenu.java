package trainingRoom;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;


public class MyPopupMenu extends JFrame {

	private static final long serialVersionUID = 6709075097464242391L;
	private JPopupMenu menu;
    private Toolkit toolkit;

    public MyPopupMenu(String title) {
        super(title);
        this.initUI();
    }

    private void initUI() {
        toolkit = this.getToolkit();
//        toolkit = Toolkit.getDefaultToolkit();

        menu = new JPopupMenu();
        JMenuItem menuItemBeep = new JMenuItem("Beep");

        menuItemBeep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                toolkit.beep();                
            }
        });

        menu.add(menuItemBeep);

        JMenuItem menuItemClose = new JMenuItem("Close");
        menuItemClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.add(menuItemClose);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                //if (e.getButton() == MouseEvent.BUTTON1) {
                    menu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(250, 200);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MyPopupMenu pm = new MyPopupMenu("JPopupMenu");
                pm.setVisible(true);
            }
        });
    }
}