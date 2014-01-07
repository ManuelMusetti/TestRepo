package trainingRoom;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MyMessageBoxes extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = -9004859849010452364L;
	private JPanel panel;

    public MyMessageBoxes() {

        initUI();
    }

    public final void initUI() {

        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JButton error = new JButton("Error");
        JButton warning = new JButton("Warning");
        JButton question = new JButton("Question");
        JButton information = new JButton("Information");

        error.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(panel, "Could not open file",
                        "Nada...", JOptionPane.ERROR_MESSAGE);
            }
        });

        warning.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(panel, "A deprecated call",
                        "Attento!", JOptionPane.WARNING_MESSAGE);
            }
        });

        question.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(panel, "Are you sure to quit?",
                        "Siuro?", JOptionPane.QUESTION_MESSAGE);
            }
        });

        information.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(panel, "Download completed",
                        "E' tutto finito!", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        panel.add(error);
        panel.add(warning);
        panel.add(question);
        panel.add(information);

        add(panel);

        setTitle("Message Boxes");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                MyMessageBoxes mb = new MyMessageBoxes();
                mb.setVisible(true);
            }
        });
    }
}