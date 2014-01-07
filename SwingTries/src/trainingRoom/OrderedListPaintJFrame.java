package trainingRoom;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class OrderedListPaintJFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private OrderedList paintList= null;
	
	public OrderedListPaintJFrame(OrderedList list){
		super();
		paintList=list;
	}
	
	public OrderedList getPaintList(){
		return paintList;
	}
	
	public void setPaintList(OrderedList list){
		paintList=list;
	}
	
	@Override
	public void repaint(){
		OrderedListNode tmp=paintList.getFirst();
		while(tmp!=null){
		  ((JPanel)tmp.getElement()).setVisible(false);
		  tmp=tmp.getNext();
		}
		super.repaint();
		tmp=paintList.getLast();
		while(tmp!=null){
		  ((JPanel)tmp.getElement()).setVisible(true);
		  tmp=tmp.getPrev();
		}
		
	}

}
