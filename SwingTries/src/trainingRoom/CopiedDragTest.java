package trainingRoom;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;


public class CopiedDragTest extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel mainpanel, storypanel, imageselect;



    public CopiedDragTest(){

          mainpanel = new JPanel(new BorderLayout());
          storypanel = new JPanel();
          imageselect = new JPanel();
            MouseListener listener = new MouseAdapter(){
            public void mousePressed(MouseEvent e)
        {
            JComponent c = (JComponent) e.getSource();
            TransferHandler handler = c.getTransferHandler();
            handler.exportAsDrag(c, e, TransferHandler.COPY);
        }
        };

            int j = 0;
            JLabel imgselect = new JLabel();
            //myImages[j] = resize(myImages[j]);
            imgselect= new JLabel(new ImageIcon(this.getClass().getResource("/Connector Line.png")));
            System.out.println(j);
            imgselect.addMouseListener(listener);

            Image img=Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Connector Line.png"));
            TransferHandler trans=new TransferHandler("icon");
            imgselect.setTransferHandler(trans);
            imageselect.add(imgselect);
            imageselect.setSize(300, 300);


            int i = 0;
            JLabel storylabel = new JLabel();


            //targetImg = new ImageIcon("lmkpackage/base/TargetImg.jpg");
            //storyimages[i] = resize(storyimages[i]);
            storylabel = new JLabel(new ImageIcon(this.getClass().getResource("/New Feature.png")));
            System.out.println(i);
            storylabel.addMouseListener(listener);
            storylabel.setTransferHandler(new TransferHandler("icon"));

            storypanel.add(storylabel); 
            storypanel.setSize(300, 300);
            
            mainpanel.add(imageselect, BorderLayout.NORTH);
            mainpanel.add(storypanel, BorderLayout.SOUTH);

            getContentPane().add(mainpanel);



        }

        public static void main(String[] args){

        System.out.println("Application Running");
        JFrame mainframe =  new CopiedDragTest();
            mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setSize(1000,1000);
            mainframe.setVisible(true);

        }

    }