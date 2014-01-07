package trainingRoom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MyRemoveListener extends JFrame {

	private static final long serialVersionUID = -2503369200022897050L;
	private JLabel text;
    private JButton add;
    private JCheckBox active;
    private ButtonListener buttonlistener;
    private static int count = 0;

    public MyRemoveListener() {


        JPanel panel = new JPanel();

        panel.setLayout(null);

        add = new JButton("+");
        add.setBounds(40, 30, 80, 25);
        buttonlistener = new ButtonListener();

        active = new JCheckBox("Active listener");
        active.setBounds(160, 30, 140, 25);

        active.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent event) {
                if (active.isSelected()) {
                    add.addActionListener(buttonlistener);
                } else {
                    add.removeActionListener(buttonlistener);
                }
            }
        });

        text = new JLabel("0");
        text.setBounds(40, 80, 80, 25);

        panel.add(add);
        panel.add(active);
        panel.add(text);

        add(panel);

        setTitle("Remove listener");
        setSize(310, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            text.setText(Integer.toString(++count));
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                MyRemoveListener ex = new MyRemoveListener();
                ex.setVisible(true);
            }
        });
    }
}