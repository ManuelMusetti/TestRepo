package trainingRoom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;


public class MyToolbar extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4077783086954846999L;
    private JPanel jpan= new JPanel();	  

	public MyToolbar() {
        initUI();
    }

    public final void initUI() {

    	JPanel panel = new JPanel();
    	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
 
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");
        menubar.add(file);
        setJMenuBar(menubar);

        JToolBar toolbar1 = new JToolBar();
        toolbar1.setAlignmentX(0);
        JToolBar toolbar2 = new JToolBar();
        toolbar2.setAlignmentX(0);

        ImageIcon icon = new ImageIcon(getClass().getResource("exit.png"));

        JButton exitButton = new JButton(icon);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }

        });

        ImageIcon iconBlue = new ImageIcon(getClass().getResource("blue_icon.png"));
        ImageIcon iconRed = new ImageIcon(getClass().getResource("red_icon.png"));
        ImageIcon iconGreen = new ImageIcon(getClass().getResource("green_icon.png"));        

        JButton colorRed = new JButton("Red", iconRed);
        colorRed.setMnemonic(KeyEvent.VK_R);
        colorRed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	jpan.setBackground(Color.RED);	  
            }
        });

        JButton colorBlue = new JButton("Blue", iconBlue);
        colorBlue.setMnemonic(KeyEvent.VK_B);
        colorBlue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
              jpan.setBackground(Color.BLUE);	  
            }
        });

        JButton colorGreen = new JButton("Green", iconGreen);
        colorGreen.setMnemonic(KeyEvent.VK_G);
        colorGreen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
              //jpan.setBackground(Color.GREEN);	  
              Color col = new Color(0, 80, 0);
              jpan.setBackground(col);	  
            }
        });

        toolbar1.add(exitButton);
        toolbar2.add(colorRed);
        toolbar2.add(colorBlue);
        toolbar2.add(colorGreen);
        
//        add(toolbar1, BorderLayout.NORTH);
        
        panel.add(toolbar1);
        panel.add(toolbar2);

        add(panel, BorderLayout.NORTH);
        add(jpan);

        setTitle("Simple toolbar");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MyToolbar ex = new MyToolbar();
                ex.setVisible(true);
            }
        });
    }
}