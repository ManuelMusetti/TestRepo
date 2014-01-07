package trainingRoom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;


public class MyColorChooser extends JFrame {

	private static final long serialVersionUID = -2174800095912448374L;
	private JPanel panel;
    private JPanel display;

    public MyColorChooser() {

        initUI();
    }

    public final void initUI() {

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        ImageIcon open = new ImageIcon(
                getClass().getResource("color.png"));

        JToolBar toolbar = new JToolBar();
        JButton openb = new JButton(open);

        openb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
//                JColorChooser clr = new JColorChooser();
                Color color = /*clr*/JColorChooser.showDialog(panel, "Choose Color", Color.white);
                display.setBackground(color);
            }
        });

        toolbar.add(openb);

        display = new JPanel();
        display.setBackground(Color.WHITE);

//        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

//        display.add(panel);
//        add(display);
//        add(toolbar, BorderLayout.NORTH);
        panel.add(display);
        add(panel);
        add(toolbar, BorderLayout.NORTH);

        setTitle("ColorChooserDialog");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                MyColorChooser ccd = new MyColorChooser();
                ccd.setVisible(true);
            }
        });
    }
}