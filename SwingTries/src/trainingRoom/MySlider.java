package trainingRoom;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class MySlider extends JFrame {

	private static final long serialVersionUID = 6466223832225546507L;
	private JSlider slider;
    private JLabel label;

    private ImageIcon mute;
    private ImageIcon min; 
    private ImageIcon med; 
    private ImageIcon high; 
    private ImageIcon max; 

    public MySlider() {
        loadImages();        
        initUI();
    }
    
    private void loadImages() {
        mute = new ImageIcon(getClass().getResource("mute_vol.png"));
        min = new ImageIcon(getClass().getResource("min_vol.png"));
        med = new ImageIcon(getClass().getResource("med_vol.png"));
        high = new ImageIcon(getClass().getResource("high_vol.png"));        
        max = new ImageIcon(getClass().getResource("max_vol.png"));
    }

    public final void initUI() {
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        setLayout(new BorderLayout());

        panel.add(Box.createHorizontalGlue());
        slider = new JSlider(0, 100, 0);

        slider.setPreferredSize(new Dimension(150, 30));

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent event) {
                int value = slider.getValue();
                if (value == 0) {
                    label.setIcon(mute);
                } else if (value > 0 && value <= 25) {
                    label.setIcon(min);
                } else if (value > 25 && value <= 50) {
                    label.setIcon(med);
                } else if (value > 50 && value < 75) {
                    label.setIcon(high);
                } else {
                    label.setIcon(max);
                }
            }
        });

        panel.add(slider);
        panel.add(Box.createRigidArea(new Dimension(5, 0)));

        label = new JLabel(mute, JLabel.CENTER);
        panel.add(label);
        panel.add(Box.createHorizontalGlue());
        add(panel, BorderLayout.CENTER);

        pack();
        
        setTitle("JSlider");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MySlider ex = new MySlider();
                ex.setVisible(true);
            }
        });
    }
}