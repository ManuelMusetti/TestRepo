package trainingRoom;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class QuitButtonExample extends JFrame {

	private boolean clicked=false;
	
	private static final long serialVersionUID = -3266338734272872056L;

	public QuitButtonExample() {
        
        initUI();
    }

    private void initUI() {

      setTitle("Bottone Quit");
      setSize(300, 200);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
        
      JPanel panel = new JPanel();
      getContentPane().add(panel);

      panel.setLayout(null);
      panel.setBackground(Color.GREEN);
      panel.setForeground(Color.ORANGE);
      panel.setToolTipText("Ciao, sono un pannello!");

      JButton quitButton = new JButton("Quit2");
      quitButton.setBounds(this.getWidth()-81, this.getHeight()-58, 80, 30);
      quitButton.setBackground(Color.RED);
      quitButton.setForeground(Color.BLUE);
      quitButton.setToolTipText("Ciao, sono un bottone!");
       
      quitButton.addActionListener(new ActionListener() {
    	@Override
    	public void actionPerformed(ActionEvent event) {
    		if (clicked) System.exit(0);
//    		else {setTitle("Evento: "+event.getSource()); clicked=true;}
    		else {setTitle("Evento: "+event.getActionCommand()); clicked=true;}
        }
       });

       panel.add(quitButton);

       System.out.println("JFrame(x,y): ("+this.getX()+", "+this.getY()+")"
    		   			 +"\nWidth: "+this.getWidth()+"\tHeight: "+this.getHeight());
       System.out.println("JPanel(x,y): ("+panel.getX()+", "+panel.getY()+")"
    		   			 +"\nWidth: "+panel.getWidth()+"\tHeight: "+panel.getHeight());
       System.out.println("JButton(x,y): ("+quitButton.getX()+", "+quitButton.getY()+")"
    		   			 +"\nWidth: "+quitButton.getWidth()+"\tHeight: "+quitButton.getHeight());
       
    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                QuitButtonExample ex = new QuitButtonExample();
                ex.setVisible(true);
            }
        });
    }
}