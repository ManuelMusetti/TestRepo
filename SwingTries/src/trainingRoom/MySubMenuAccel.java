package trainingRoom;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;


public class MySubMenuAccel extends JFrame {

	private static final long serialVersionUID = -3583044408753869597L;

    private JPanel jpan= new JPanel();	  

	public MySubMenuAccel() {
        initUI();
    }

    public final void initUI() {
        getContentPane().add(jpan);	  

        JMenuBar menubar = new JMenuBar();
        ImageIcon iconNew = new ImageIcon(getClass().getResource("new.png"));
        ImageIcon iconOpen = new ImageIcon(getClass().getResource("open.png"));
        ImageIcon iconSave = new ImageIcon(getClass().getResource("save.png"));
        ImageIcon iconExit = new ImageIcon(getClass().getResource("exit.png"));

        JMenu imp = new JMenu("Import");
        imp.setMnemonic(KeyEvent.VK_M);

        JMenuItem newsf = new JMenuItem("Import newsfeed list...");
        JMenuItem bookm = new JMenuItem("Import bookmarks...");
        JMenuItem mail = new JMenuItem("Import mail...");

        imp.add(newsf);
        imp.add(bookm);
        imp.add(mail);

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);

        JMenuItem fileNew = new JMenuItem("New", iconNew);
        fileNew.setMnemonic(KeyEvent.VK_N);

        JMenuItem fileOpen = new JMenuItem("Open", iconOpen);
        fileNew.setMnemonic(KeyEvent.VK_O);

        JMenuItem fileSave = new JMenuItem("Save", iconSave);
        fileSave.setMnemonic(KeyEvent.VK_S);

        JMenuItem fileExit = new JMenuItem("Exit", iconExit);
        fileExit.setMnemonic(KeyEvent.VK_C);
        fileExit.setToolTipText("Exit application");
        fileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
            ActionEvent.CTRL_MASK));

        fileExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        ImageIcon iconRed = new ImageIcon(getClass().getResource("red_icon.png"));
        ImageIcon iconBlue = new ImageIcon(getClass().getResource("blue_icon.png"));
        ImageIcon iconGreen = new ImageIcon(getClass().getResource("green_icon.png"));        
        
        JMenu color = new JMenu("Color");
        color.setMnemonic(KeyEvent.VK_C);

        JMenuItem colorRed = new JMenuItem("Red", iconRed);
        colorRed.setMnemonic(KeyEvent.VK_R);
        colorRed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
              jpan.setBackground(Color.RED);	  
            }
        });

        JMenuItem colorBlue = new JMenuItem("Blue", iconBlue);
        colorBlue.setMnemonic(KeyEvent.VK_B);
        colorBlue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
              jpan.setBackground(Color.BLUE);	  
            }
        });

        JMenuItem colorGreen = new JMenuItem("Green", iconGreen);
        colorGreen.setMnemonic(KeyEvent.VK_G);
        colorGreen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
              //jpan.setBackground(Color.GREEN);	  
              Color col = new Color(0, 80, 0);
              jpan.setBackground(col);	  
            }
        });

        color.add(colorRed);
        color.add(colorBlue);
        color.add(colorGreen);
        
        file.add(fileNew);
        file.add(fileOpen);
        file.add(fileSave);
        file.addSeparator();
        file.add(imp);
        file.addSeparator();
        file.add(color);
        file.addSeparator();
        file.add(fileExit);

        menubar.add(file);

        setJMenuBar(menubar);

        setTitle("Submenu");
        setSize(360, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MySubMenuAccel ex = new MySubMenuAccel();
                ex.setVisible(true);
            }
        });
    }
}