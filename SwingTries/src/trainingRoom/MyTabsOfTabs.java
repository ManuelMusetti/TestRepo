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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;


public class MyTabsOfTabs extends JFrame {

	private static final long serialVersionUID = -5689647765760996586L;
	private Toolkit toolkit;

    public MyTabsOfTabs() {
        
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

        
        String text2=
        "It's way too late to think of<br>" + 
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
        "Sleep in peace"+
        "\nREPEAT\n"+
        "It's way too late to think of<br>" + 
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

        
        
        String lyrics = "<html>"+text2+"</html>";
//        String lyrics = "<html>"+text+"</html>";

        
//        JLabel label = new JLabel(lyrics);
//        label.setFont(new Font("Georgia", Font.ITALIC, 14));
//        label.setForeground(new Color(255, 0, 0));

        
		JTabbedPane tabbed = getTabbedPane(lyrics);
		JTabbedPane tabbed2 = getTabbedPane(lyrics);
		JTabbedPane tabbed3 = getTabbedPane(lyrics);

        
        
        
        JPanel tabbone1 = new JPanel();
        tabbone1.add(tabbed);
        
        JTabbedPane bigTab = new JTabbedPane();
        
        bigTab.add("a", tabbed);
        bigTab.add("b", tabbed2);
        bigTab.add("c", tabbed3);

//        add(tabbed);
//        add(tabbed2);
//        add(tabbed3);

        
        add(bigTab);
//        add(new JPanel().add(tabbedPaneTmp));
//        add(tabbone1);
//        pack();

//        toolkit = getToolkit();
//        Dimension screensize = toolkit.getScreenSize();
//        setLocation((screensize.width - getWidth())/2, 
//                (screensize.height - getHeight())/2);
//        
        setSize(250, 400);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

	private JTabbedPane getTabbedPane(String lyrics) {
		JTabbedPane tabbedPaneTmp=new JTabbedPane();
		tabbedPaneTmp.setBounds(50, 50, 500, 500);

	    JTextArea jta = new JTextArea(lyrics);  
	    JTextArea jta2 = new JTextArea(lyrics);  
	    JTextArea jta3 = new JTextArea(lyrics);  

//	    jta.setLineWrap(true);

	    JScrollPane textScroller = new JScrollPane(jta); //the panel containing the images
	    JScrollPane textScroller2 = new JScrollPane(jta2); //the panel containing the images
	    JScrollPane textScroller3 = new JScrollPane(jta3); //the panel containing the images

        JPanel panel = new JPanel(); 
        panel.setLayout(new BorderLayout(50, 50));
 
        JPanel panel2 = new JPanel(); 
        panel2.setLayout(new BorderLayout(50, 50));
 
        JPanel panel3 = new JPanel(); 
        panel3.setLayout(new BorderLayout(50, 50));
 

	    panel.add(textScroller, BorderLayout.CENTER);
	    panel2.add(textScroller2, BorderLayout.CENTER);
	    panel3.add(textScroller3, BorderLayout.CENTER);
        tabbedPaneTmp.addTab("1", panel);
        tabbedPaneTmp.addTab("2", panel2);
        tabbedPaneTmp.addTab("3", panel3);
		return tabbedPaneTmp;
	}

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	MyTabsOfTabs ex = new MyTabsOfTabs();
                ex.setVisible(true);
            }
        });

    }
}
