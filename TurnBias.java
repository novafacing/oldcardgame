import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.PrintStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

public class TurnBias extends JPanel implements ActionListener {
   public JTextField cardNumber;
   public JTextField cardCopies;
   public JTextField cardBias;
   public JButton    calculateButton;
   public JButton    calculateFinal;
   public double totalCards;
   public double numCopies;
   public double numBias;
   public double i;
   public double v;
   public int x;
   public int y;
   public GridBagConstraints c = new GridBagConstraints();
   JDialog window;
   public JTextField finalBias;
   
   public TurnBias() {
      super (new GridBagLayout());
      c.fill = GridBagConstraints.HORIZONTAL;
      c.weightx = .5;
      c.weighty = .5;
      
      cardNumber = new JTextField();
      cardNumber.setText("0");
      
      finalBias = new JTextField();   
      
      cardCopies = new JTextField();
      cardCopies.setText("0");
      
      cardBias   = new JTextField();
      cardBias.setText("0");
      
      calculateButton = new JButton("Add Card");
      calculateButton.addActionListener(new ActionListener() {
         public void actionPerformed (ActionEvent e) {
            i = i + (((Double.valueOf(cardBias.getText()))*(Double.valueOf(cardCopies.getText())))/(Double.valueOf(cardNumber.getText())));
            System.out.println(i);
            
         }
      });
      calculateFinal = new JButton("Calculate Bias");
      calculateFinal.addActionListener(new ActionListener() {
         public void actionPerformed (ActionEvent e) {
            v = i;
            finalBias.setText(Double.toString(v));
         }
      });
      
      addGB(cardNumber, x = 0, y = 0);
      addGB(cardCopies, x = 1, y = 0);
      addGB(cardBias, x = 2, y = 0);
      addGB(calculateButton, x = 0, y = 1);
      addGB(calculateFinal, x = 1, y = 1);
      addGB(finalBias, x = 2, y = 1);
   }
   public static void createAndShowGUI() {
        JFrame frame = new JFrame("We Tell You To Go First!");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new TurnBias());
        frame.pack();
        frame.setVisible(true);
     
   }
   
   public void actionPerformed(ActionEvent ae) {
     System.out.println("This is a placeholder method");
   }
   void addGB( Component component, int x, int y  ) {
        c.gridx = x;  
        c.gridy = y;
        add ( component, c );
    }
   public static void MCOPY() {  
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }
}
     
      


   
  