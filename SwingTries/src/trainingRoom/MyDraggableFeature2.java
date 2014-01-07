package trainingRoom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MyDraggableFeature2 {

  public static void main(String[] a) {

	BufferedImage myPicture=null;
	
	try { myPicture = ImageIO.read(new File("/home/natan/Immagini/ICONE/balzac.jpg"));
	} catch (IOException e) { e.printStackTrace();}

	JPanel imagePanel=new JPanel();
	JLabel imageLabel = new JLabel(new ImageIcon(myPicture));

	imagePanel.setLayout(new BorderLayout());
	imagePanel.add(imageLabel);

	imagePanel.setBackground(Color.BLACK);
	
	String label="Questo è un nome lungo per una Feature!";
	MyJLabelPanel textPanel = new MyJLabelPanel(label);

	System.out.println("myPicture.getHeight(): "+myPicture.getHeight());
	System.out.println("myPicture.getWidth(): "+myPicture.getWidth());

	System.out.println("imageLabel.getHeight(): "+imageLabel.getHeight());
	System.out.println("imageLabel.getWidth(): "+imageLabel.getWidth());
	System.out.println("textPanel.getWidth(): "+textPanel.getWidth());

	
	JPanel container = new JPanel();

	container.setLayout(null);
	container.setBounds(5,  5,  500,  500);
	
	container.add(imagePanel);
	container.add(textPanel);

	container.setOpaque(true);
	container.setBackground(Color.BLACK);
	  
	JFrame frame = new JFrame();
	
	frame.setLayout(null);
	frame.getContentPane().add(container);
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
	frame.setLocation(0, 0);

	System.out.println("textPanel.getTextWidth(): "+textPanel.getLabelWidth());
	System.out.println("textPanel.getLabelText(): "+textPanel.getLabelText());

	frame.setVisible(true);
	
	System.out.println("textPanel.getWidth(): "+textPanel.getWidth());
	System.out.println("textPanel.getTextWidth(): "+textPanel.getLabelWidth());
	System.out.println("textPanel.getLabelText(): "+textPanel.getLabelText());
  }
}