import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class CoinFlip extends JPanel implements ActionListener {
      public Random rand = new Random();
      public JTextField DisplayResult = new JTextField();
      public boolean Result;
      public JButton Flip = new JButton("FLIP");
       
      public CoinFlip() {
         super (new GridBagLayout());
         GridBagConstraints c = new GridBagConstraints();
         c.gridwidth = GridBagConstraints.REMAINDER;
         c.fill = GridBagConstraints.HORIZONTAL;
         c.fill = GridBagConstraints.BOTH;
         c.weightx = 1.0;
         c.weighty = 1.0;
         add(DisplayResult, c);
         add(Flip, c);
         
         Flip.addActionListener(new ActionListener() {
         public void actionPerformed (ActionEvent e) {
            FlipCoin();
         }
      });
         
      }
      
      public void FlipCoin() {
         Result = (rand.nextBoolean());
         if (Result) {
            DisplayResult.setText("HEADS");
         }
         else {
            DisplayResult.setText("TAILS");
         }
      }

      public static void CreateFrame() {
         JFrame frame = new JFrame("Flip a Coin");
         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         frame.add(new CoinFlip());
         frame.pack();
         frame.setVisible(true);
      }
      
      public void actionPerformed(ActionEvent ae) {
         System.out.println("This is a placeholder method");
      }
      
      public static void MCOPY() {
         javax.swing.SwingUtilities.invokeLater(new Runnable() {
              public void run() {
                 CreateFrame();
              }
           });
      }
}