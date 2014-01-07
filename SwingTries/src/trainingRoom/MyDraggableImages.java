package trainingRoom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyDraggableImages {
	
	private static OrderedList visibleOrderDraggables = null;
	private static int lastPositionX=-1;//X coordinate of last click
	private static int lastPositionY=-1;//Y coordinate of last click
	
	private static JFrame frameRoot = null;//frame root		
	private static JPanel lastPanelFocused=null;//last panel clicked
	private static boolean isDragging=false;

	public static void main(String[] args){
		OrderedListNode tmpNode=null;
		BufferedImage myPicture=null;
		
		frameRoot=new JFrame();
		
		String label[]={"Questo è un nome lungo per una Feature!", "Questo è un nome ammodo", "Corto!"};


		visibleOrderDraggables =new OrderedList();
		
		//creo i draggables
		for(int i=0; i<label.length; ++i) visibleOrderDraggables.addToTop(getDraggableImage(myPicture, label[i], i*100, i*100));
		
		frameRoot.setLayout(null);		
		frameRoot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameRoot.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frameRoot.setLocation(0, 0);

		//aggiungo i draggables al frame root
		tmpNode=visibleOrderDraggables.getFirst();
		while(tmpNode!=null){
			frameRoot.getContentPane().add((JPanel)tmpNode.getElement());
			tmpNode=tmpNode.getNext();
		}
		
		frameRoot.addMouseListener(getMyMouseListener());
		frameRoot.addMouseMotionListener(getMyMouseMotionListener());
//		frame.pack();
		frameRoot.setVisible(true);

	}

	private static JPanel getDraggableImage(BufferedImage myPicture, String label, int x, int y) {
		try { myPicture = ImageIO.read(new File("/home/natan/Immagini/ICONE/balzac.jpg"));
		} catch (IOException e) { e.printStackTrace();}

		JPanel imagePanel=new JPanel();
		JLabel imageLabel = new JLabel(new ImageIcon(myPicture));

//		imagePanel.setLayout(new BorderLayout());
		imagePanel.add(imageLabel);
		imagePanel.setBackground(Color.BLACK);
		imagePanel.setOpaque(true);
		imagePanel.setBounds(0, 0, myPicture.getWidth(), myPicture.getHeight());

		JPanel textPanel = new JPanel();
//		textPanel.setLayout(new BorderLayout());
		textPanel.add(new JLabel(label));
		textPanel.setBounds(0, myPicture.getHeight(), myPicture.getWidth(), 50);
		textPanel.setBackground(Color.BLACK);
		textPanel.setOpaque(true);
		
		JPanel container = new JPanel();
		container.setName(label);
		container.setLayout(null);
		container.setBounds(x,  y,  myPicture.getWidth(), myPicture.getHeight()+50);

		container.setOpaque(true);
		container.setBackground(Color.BLACK);
		  
		container.add(imagePanel);
		container.add(textPanel);
		return container;
	}

	private static MouseMotionListener getMyMouseMotionListener() {
		MouseMotionListener list= new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
//			  OrderedListNode tmpNode=visibleOrderDraggables.getFirst();
//			  JPanel dragged=null;
			  int moveX=0, moveY=0;
//			  while(tmpNode!=null){
//				if (((JPanel)tmpNode.getElement()).getBounds().contains(e.getX(), e.getY())){
////					System.out.println("Hai cliccato su "+((JPanel)tmpNode.getElement()).getName()+"!");						
//					dragged=((JPanel)tmpNode.getElement()); break;
//				}
//				tmpNode=tmpNode.getNext();
//			  }
			  
//				  if(dragged==null) return;

			  if(lastPanelFocused==null) return;

			  isDragging=true;
			  moveX = e.getX()-lastPositionX;
			  moveY = e.getY()-lastPositionY;

			  System.out.println("oldPosX: "+lastPositionX+"\toldPosY: "+lastPositionY);
			  System.out.println("newPosX: "+e.getX()+"\tnewPosY: "+e.getY());
			  System.out.println("moveX: "+moveX+"\tmoveY: "+moveY);
			  
			  lastPositionX=e.getX();
			  lastPositionY=e.getY();
			  
			  lastPanelFocused.setLocation(lastPanelFocused.getX()+moveX, lastPanelFocused.getY()+moveY);
//			  dragged.setLocation(dragged.getX()+moveX, dragged.getY()+moveY);
			  frameRoot.repaint();
			  
//			  JPanel toDraw=null;
//			  OrderedListNode tmp=visibleOrderDraggables.getLast();
//			  while(tmp!=null){
//				toDraw=(JPanel)tmp.getElement();
//				/**/
//			  }

			}
		};
		return list;
	}

	private static MouseListener getMyMouseListener() {
		MouseListener listener= new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if (isDragging){
				  isDragging=false;
				  visibleOrderDraggables.moveToTop(lastPanelFocused);
				}
//				lastPositionX=-1;
//				lastPositionY=-1;
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				  /*if (lastPositionX<0)*/ lastPositionX=e.getX();
				  /*if (lastPositionY<0)*/ lastPositionY=e.getY();
				  OrderedListNode tmpNode=visibleOrderDraggables.getFirst();
				  JPanel found=null;
				  while(tmpNode!=null){
					if (((JPanel)tmpNode.getElement()).getBounds().contains(e.getX(), e.getY())){
//						System.out.println("Hai cliccato su "+((JPanel)tmpNode.getElement()).getName()+"!");						
//						found=((JPanel)tmpNode.getElement()); break;
						lastPanelFocused=((JPanel)tmpNode.getElement()); break;
					}
					tmpNode=tmpNode.getNext();
				  }
//				  if (found!=null){ 
//					visibleOrderDraggables.moveToTop(found);
//					lastPanelFocused=found;
//				  }
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
//				OrderedListNode tmpNode=visibleOrderDraggables.getFirst();
//				while(tmpNode!=null){
//					if (((JPanel)tmpNode.getElement()).getBounds().contains(e.getX(), e.getY())){
//						System.out.println("Sei passato su "+((JPanel)tmpNode.getElement()).getName()+"!");
//						return;
//					}
//					tmpNode=tmpNode.getNext();
//				}
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				OrderedListNode tmpNode=visibleOrderDraggables.getFirst();
				while(tmpNode!=null){
					if (((JPanel)tmpNode.getElement()).getBounds().contains(e.getX(), e.getY())){
						System.out.println("Hai cliccato su "+((JPanel)tmpNode.getElement()).getName()+"!");						
						return;
					}
					tmpNode=tmpNode.getNext();
				}
			}
		};
		
		return listener;
	}

}
