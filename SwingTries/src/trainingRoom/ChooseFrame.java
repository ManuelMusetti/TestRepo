package trainingRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import trainingRoom.MyJFrame.MyColors;

public class ChooseFrame {

	private static BufferedReader inputBuff = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		MyJFrame frame=null;
		
		System.out.println("Di che colore vuoi la finestra?\n"
						  +"(R)Rosso\t(B)Blu\t\t(V)Verde\t(N)Nessuno ");
		String s="";
		try {
			s = inputBuff.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(s.toUpperCase().startsWith("R")) frame=MyJFrame.getMyJFrame(MyColors.Rosso);
		else if(s.toUpperCase().startsWith("B")) frame=MyJFrame.getMyJFrame(MyColors.Blu);
		else if(s.toUpperCase().startsWith("V")) frame=MyJFrame.getMyJFrame(MyColors.Verde);
		else if(s.toUpperCase().startsWith("N")) frame=MyJFrame.getMyJFrame(MyColors.Nessuno);
		else System.out.println("Il colore indicato per la finestra non esiste");
		if (frame!=null) frame.setVisible(true);
	}

}
