package dragTries;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;


public class MyDraggableImages {
	
	private static OrderedList visibleOrderDraggables = null;
	private static int lastPositionX=-1;//X coordinate of last click
	private static int lastPositionY=-1;//Y coordinate of last click
	
	/**top level frame*/
	private static JFrame frameRoot = null;//frame root		

	/**the panel containing the diagram */
	private static JPanel diagramPanel=null;

	/**the panel containing the tools */
	private static JPanel toolsPanel=null;
	
	private static JPanel lastPanelFocused=null;//last panel clicked
	private static boolean isDragging=false;

	public static void main(String[] args){
		OrderedListNode tmpNode=null;
		BufferedImage myPicture=null;
		
		//creating root frame
		frameRoot=new JFrame();
		frameRoot.setLayout(new BorderLayout());		
		frameRoot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		//icons for toolspanel
		
		
		//stupid tries panels
		JPanel tryGreen= new JPanel();
		tryGreen.setBackground(Color.green);
		tryGreen.setSize(50, 50);
		JPanel tryOrange= new JPanel();
		tryOrange.setBackground(Color.orange);
		tryOrange.setSize(50, 50);
		JPanel tryPink= new JPanel();
		tryPink.setBackground(Color.pink);
		tryPink.setSize(50, 50);
		
		//creating tools panel
		toolsPanel = new JPanel();		
		toolsPanel.setLayout(new GridLayout(0, 2));		
		toolsPanel.setPreferredSize(new Dimension(300, Toolkit.getDefaultToolkit().getScreenSize().height));
		toolsPanel.setBackground(Color.black);
//		toolsPanel.setBorder(BorderFactory.createCompoundBorder(
//				BorderFactory.createEtchedBorder(EtchedBorder.RAISED), 
//						BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)));

//		toolsPanel.add(getToolIcon("/New Feature.png", "New Feature"));
//		toolsPanel.add(getToolIcon("/New Feature.png", "New Feature"));
//		toolsPanel.add(getToolIcon("/Connector Line.png", "Connector Line"));
//		toolsPanel.add(getToolIcon("/Connector Line.png", "Connector Line"));

		toolsPanel.add(tryPink);
		toolsPanel.add(tryGreen);
		toolsPanel.add(tryOrange);

		
		//creating diagram panel, which will fit the rest of the root frame
		diagramPanel = new JPanel();
		diagramPanel.setBackground(Color.RED);
		diagramPanel.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width-320,
		Toolkit.getDefaultToolkit().getScreenSize().height));
		diagramPanel.setLayout(null);		
		diagramPanel.setMinimumSize(new Dimension((Toolkit.getDefaultToolkit().getScreenSize().width-320)/4,
				Toolkit.getDefaultToolkit().getScreenSize().height));
		
		JSplitPane splitterPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
//		splitterPanel.setOneTouchExpandable(true);
		splitterPanel.setDividerLocation(0.5);
		splitterPanel.setDividerSize(6);
//		splitterPanel.setDoubleBuffered(true);
		splitterPanel.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width,
				Toolkit.getDefaultToolkit().getScreenSize().height));
		splitterPanel.setContinuousLayout(true);
//		splitterPanel.setResizeWeight(0.5);
		
		splitterPanel.add(diagramPanel);
		splitterPanel.add(toolsPanel);

		frameRoot.add(splitterPanel);

		String label[]={"Questo è un nome lungo per una Feature!", "Questo è un nome ammodo", "Corto!"};

		visibleOrderDraggables =new OrderedList();
		
		//creo i draggables
		for(int i=0; i<label.length; ++i) visibleOrderDraggables.addToTop(getDraggableFeature(myPicture, label[i], i*100, i*100));
				
		//aggiungo i draggables al diagram panel
		tmpNode=visibleOrderDraggables.getFirst();
		while(tmpNode!=null){

			// ***VERBOSE***
			System.out.println("(JPanel)tmpNode.getElement()="+(JPanel)tmpNode.getElement());
			// ***VERBOSE***
			
			diagramPanel.add((JPanel)tmpNode.getElement());
			tmpNode=tmpNode.getNext();
		}

		splitterPanel.addMouseListener(getMyMouseListener());
		splitterPanel.addMouseMotionListener(getMyMouseMotionListener());
//		frameRoot.addMouseListener(getMyMouseListener());
//		frameRoot.addMouseMotionListener(getMyMouseMotionListener());

		frameRoot.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		frameRoot.setLocation(0, 0);

//		frameRoot.repaint();
//		frameRoot.validate();
		frameRoot.setVisible(true);
		
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//            	frameRoot.setVisible(true);
//            }
//        });

	}

	private static JPanel getDraggableFeature(BufferedImage myPicture, String label, int x, int y) {
		try { myPicture = ImageIO.read(new File("/home/natan/Immagini/ICONE/balzac.jpg"));
		} catch (IOException e) { e.printStackTrace();}

	    // find the file in the file system.. probably not a good idea
	    File f = new File("images/balzac.jpg");
	    try {
			System.out.println("images/balzac.jpg: "+f.getCanonicalPath()+" "+f.exists());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	    URL url = MyDraggableImages.class.getResource("resources/balzac.jpg");
//	    System.out.println("resources/balzac.jpg: "+url);
//		
//	    url = MyDraggableImages.class.getResource("/resources/balzac.jpg");
//	    System.out.println("/resources/balzac.jpg: "+url);
//		
//	    url = MyDraggableImages.class.getResource("/balzac.jpg");
//	    System.out.println("/balzac.jpg: "+url);
		
		JPanel imagePanel=new JPanel();
		System.out.println("Cartella attuale"+System.getProperty("user.dir"));
		JLabel imageLabel = new JLabel(new ImageIcon(MyDraggableImages.class.getResource("/balzac.jpg")));

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
	
	/**
	 * Returns a JPanel named name and containing the icon image having the path iconPath.
	 * 
	 * @param iconPath - resource path of the icon image
	 * @param name - the name of the new JPanel
	 * @return - the new JPanel with the icon, or null if a problem occurrs.
	 */
	private static JPanel getToolIcon(String iconPath, String name) {
		JPanel toolPanel=null;
		ImageIcon toolImage=null;
		
		try{
			toolImage = new ImageIcon(MyDraggableImages.class.getResource(iconPath));			
		}catch(Exception e){
			System.out.println("Eccezione "+e.getMessage());
			e.printStackTrace();
			return null;
		}
		
		toolPanel= new JPanel();
		toolPanel.add(new JLabel(toolImage));

		toolPanel.setBounds(0, 0, toolImage.getIconWidth(), toolImage.getIconHeight());

		toolPanel.setOpaque(true);
		toolPanel.setBackground(Color.DARK_GRAY);
		toolPanel.setName(name);
		  
		return toolPanel;
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

//			  System.out.println("oldPosX: "+lastPositionX+"\toldPosY: "+lastPositionY);
//			  System.out.println("newPosX: "+e.getX()+"\tnewPosY: "+e.getY());
//			  System.out.println("moveX: "+moveX+"\tmoveY: "+moveY);
			  
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
				  lastPanelFocused=null;
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
				System.out.println("Non hai cliccato su nulla di utile");						
			}
		};
		
		return listener;
	}

}
