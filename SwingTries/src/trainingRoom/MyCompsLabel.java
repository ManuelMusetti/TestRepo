package trainingRoom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class MyCompsLabel extends JFrame {

	private static final long serialVersionUID = -5689647765760996586L;
	private Toolkit toolkit;

    public MyCompsLabel() {
        
        initUI();
    }
    
    private void initUI() {

        setTitle("No Sleep");

        String text="It's way too late to think of<br>" + 
        "Someone I would call now<br>" + 
        "And neon signs got tired<br>" + 
        "Red eye flights help the stars out<br>" + 
        "I'm safe in a corner<br>" + 
        "Just hours before me<br>" + 
        "<br>" + 
        "I'm waking with the roaches<br>" + 
        "The world has surrendered<br>" + 
        "I'm dating ancient ghosts<br>" + 
        "The ones I made friends with<br>" + 
        "The comfort of fireflies<br>" + 
        "Long gone before daylight<br>" + 
        "<br>" + 
        "And if I had one wishful field tonight<br>" + 
        "I'd ask for the sun to never rise<br>" + 
        "If God leant his voice for me to speak<br>" + 
        "I'd say go to bed, world<br>" + 
        "<br>" + 
        "I've always been too late<br>" + 
        "To see what's before me<br>" + 
        "And I know nothing sweeter than<br>" + 
        "Champaign from last New Years<br>" + 
        "Sweet music in my ears<br>" + 
        "And a night full of no fears<br>" + 
        "<br>" + 
        "But if I had one wishful field tonight<br>" + 
        "I'd ask for the sun to never rise<br>" + 
        "If God passed a mic to me to speak<br>" + 
        "I'd say stay in bed, world<br>" + 
        "Sleep in peace";

//        text=text+"<br>"+"<br>"+text;

        
        String lyrics = "<html>"+text+"</html>";

        
        JPanel panel = new JPanel(); 
        panel.setLayout(new BorderLayout(50, 50));
 
        JLabel label = new JLabel(lyrics);
        label.setFont(new Font("Georgia", Font.ITALIC, 14));
        label.setForeground(new Color(255, 0, 0));
//        label.setFont(new Font("Georgia", Font.PLAIN, 14));
//        label.setForeground(new Color(50, 50, 25));


        panel.add(label, BorderLayout.EAST);
        panel.add(label, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(panel);
        pack();

        toolkit = getToolkit();
        Dimension screensize = toolkit.getScreenSize();
        setLocation((screensize.width - getWidth())/2, 
            (screensize.height - getHeight())/2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyCompsLabel ex = new MyCompsLabel();
                ex.setVisible(true);
            }
        });

    }
}
