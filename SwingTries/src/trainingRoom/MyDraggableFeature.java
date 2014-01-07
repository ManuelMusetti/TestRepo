package trainingRoom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;


//	textLabel.getText()



public class MyDraggableFeature {

  public static void main(String[] a) {

	BufferedImage myPicture=null;
	
	try { myPicture = ImageIO.read(new File("/home/natan/Immagini/ICONE/balzac.jpg"));
	} catch (IOException e) { e.printStackTrace();}

	JPanel imagePanel=new JPanel();
	JLabel imageLabel = new JLabel(new ImageIcon(myPicture));

//	imagePanel.setLayout(null);
	imagePanel.setLayout(new BorderLayout());
	imagePanel.add(imageLabel);
//	imagePanel.setSize(myPicture.getWidth(), myPicture.getHeight());
//	imagePanel.setLocation(0,  0);
	imagePanel.setBackground(Color.BLACK);
//	imagePanel.setMaximumSize(new Dimension(10000, 10000));
	
	String label="Questo è un nome lungo per una Feature!";
	MyJLabelPanel textPanel = new MyJLabelPanel(label);
//	JLabel textLabel=new JLabel(label);
//	MyJStringLabel textLabel=new MyJStringLabel(label);
//	textLabel.setLayout(new BorderLayout());

//	textPanel.setLayout(new BorderLayout());
//	textPanel.add(textLabel);
	
//	textPanel.setBounds(0, 300, 100, 100);
//	textPanel.setSize(textLabel.getSize());
//	textPanel.setLocation(0, imageLabel.getHeight());

	System.out.println("myPicture.getHeight(): "+myPicture.getHeight());
	System.out.println("myPicture.getWidth(): "+myPicture.getWidth());

	System.out.println("imageLabel.getHeight(): "+imageLabel.getHeight());
	System.out.println("imageLabel.getWidth(): "+imageLabel.getWidth());
	
//	System.out.println("textLabel.getWidth(): "+textLabel.getWidth());
	System.out.println("textPanel.getWidth(): "+textPanel.getWidth());

	
//			labelPanel.setBounds(0,  myPicture.getHeight(),  myPicture.getWidth(),  100);
//	labelPanel.setBounds(0,  myPicture.getHeight(),  label.getWidth(),  100);
//	labelPanel.setBounds(0,  myPicture.getHeight(),  width,  100);
	
	JPanel container = new JPanel();
//	container.setMaximumSize(new Dimension(300,  300));
	
//	container.setSize(width, myPicture.getHeight()+100);
//	container.setSize(myPicture.getWidth(), myPicture.getHeight()+100);
	container.setLayout(null);
//	container.setLayout(new BorderLayout());
//	container.setLocation(0,  0);
	container.setBounds(5,  5,  500,  500);

//	container.setLayout(null);

//	container.add(imageLabel);
//	container.add(textLabel);
	container.add(imagePanel);
	container.add(textPanel);
//	container.setSize(500,  500);


//	container.setBorder(BorderFactory.createCompoundBorder(
//			BorderFactory.createEtchedBorder(EtchedBorder.RAISED), 
//					BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)));

	container.setOpaque(true);
	container.setBackground(Color.BLACK);
	  
	JFrame frame = new JFrame();
	
	frame.setLayout(null);
	frame.getContentPane().add(container);
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
	frame.setLocation(0, 0);
//	frame.setBounds(30, 30, 800, 800);
//	frame.getContentPane().add(container);

	System.out.println("textPanel.getTextWidth(): "+textPanel.getLabelWidth());
	System.out.println("textPanel.getLabelText(): "+textPanel.getLabelText());
//	textPanel.setSize(1, 1);
	
//	imageLabel.setLocation(0,  0);
//	textLabel.setLocation(0,  myPicture.getHeight());
//	textLabel.setMaximumSize(new Dimension(10000, 10000));

//	textLabel.setSize(800, 800);
	frame.setVisible(true);
	
//	System.out.println("textLabel.getWidth(): "+textLabel.getWidth());
	System.out.println("textPanel.getWidth(): "+textPanel.getWidth());
	System.out.println("textPanel.getTextWidth(): "+textPanel.getLabelWidth());
	System.out.println("textPanel.getLabelText(): "+textPanel.getLabelText());

	
	
//	JPanel tmp=new JPanel();
//	tmp.add(textLabel);
//	System.out.println("tmp.getWidth(): "+tmp.getWidth());
	imagePanel.setBounds(0,  0, myPicture.getWidth(), myPicture.getHeight());
	textPanel.setLocation(0, myPicture.getHeight());
//	System.out.println("textLabel.getWidth(): "+textLabel.getWidth());

	System.out.println("myPicture.getWidth(): "+myPicture.getWidth());
	System.out.println("textPanel.getTextWidth(): "+textPanel.getLabelWidth());
	System.out.println("textPanel.getLabelText(): "+textPanel.getLabelText());

	int width=Math.max(myPicture.getWidth(), textPanel.getLabelWidth());
//	int width=Math.max(myPicture.getWidth(), textLabel.getWidth());
//	imageLabel.setSize(myPicture.getWidth(), myPicture.getHeight());

//	textPanel.setBounds(0, 400, width, 100);
	textPanel.setBounds(0, myPicture.getHeight(), width, 50);
//	textLabel.setSize(width, 50);
	container.setSize(width, myPicture.getHeight()+50);
//	labelPanel.setSize(width, 100);
	frame.repaint();
	
	System.out.println("myPicture.getWidth(): "+myPicture.getWidth());
	System.out.println("textPanel.getTextWidth(): "+textPanel.getLabelWidth());
	System.out.println("textPanel.getLabelText(): "+textPanel.getLabelText());
//	System.out.println("textPanel.getLastGraphics().getFontMetrics().stringWidth(textPanel.getLabelText()): "
//	  +textPanel.getLastGraphics().getFontMetrics().stringWidth(textPanel.getLabelText()));

	try {
		System.out.println("label.getWidth(): "+textPanel.getWidth());
		System.out.println("Type!");
		System.in.read();
		System.out.println("Is frame visible? "+frame.isVisible());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

//	frame.setVisible(true);
	
  }

		  
}
