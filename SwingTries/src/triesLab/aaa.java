package triesLab;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class aaa {

	private static BufferedReader inputBuff = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		
		System.out.println("Sono in funzione, scrivi qualcosa");
		String s="";
		try {
			s = inputBuff.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hai scritto: '"+s+"'");
		// TODO Auto-generated method stub

	}

}
