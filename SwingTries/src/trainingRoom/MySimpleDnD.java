package trainingRoom;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.TransferHandler;

public class MySimpleDnD {
  public static void main(String[] args) {
    JTextField field = new JTextField(10);
    JButton button = new JButton("Button");
    JFrame f = new JFrame();
    f.setTitle("Simple Drag & Drop");

    f.setLayout(new FlowLayout());
    f.add(button);
    f.add(field);

    field.setDragEnabled(true);
    button.setTransferHandler(new TransferHandler("text"));

    f.setSize(330, 150);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}