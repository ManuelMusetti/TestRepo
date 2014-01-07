package trainingRoom;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MyCompsCheckBox extends JFrame implements ActionListener {

	private static final long serialVersionUID = -998813024733676553L;

	public MyCompsCheckBox() {
        
        initUI();
    }

    public final void initUI() {

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(Box.createRigidArea(new Dimension(15, 20)));

        JCheckBox checkbox = new JCheckBox("Show Title", true);
        checkbox.setFocusable(false);
        checkbox.addActionListener(this);
        add(checkbox);

//        add(Box.createRigidArea(new Dimension(15, 20)));

        JCheckBox checkbox2 = new JCheckBox("Show Title2", true);
        checkbox2.setFocusable(false);
        checkbox2.addActionListener(this);
        add(checkbox2);

//        add(Box.createRigidArea(new Dimension(15, 20)));

        JCheckBox checkbox3 = new JCheckBox("Show Title3", true);
        checkbox3.setFocusable(false);
        checkbox3.addActionListener(this);
        add(checkbox3);

        JCheckBox checkbox4 = new JCheckBox("Show Title4", true);
        checkbox4.setFocusable(false);
        checkbox4.addActionListener(this);
        add(checkbox4);

        setSize(280, 200);
        setTitle("JCheckBox example");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JCheckBox source = (JCheckBox) e.getSource();
        boolean state = source.isSelected();

        if (state) {
        	System.out.println("Selezionato");
            this.setTitle("JCheckbox example");
        } else {
        	System.out.println("Non Selezionato");
            this.setTitle("");
        }

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyCompsCheckBox ex = new MyCompsCheckBox();
                ex.setVisible(true);
            }
        });

    }
}