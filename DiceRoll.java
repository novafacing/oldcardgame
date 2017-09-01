import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class DiceRoll extends JPanel implements ActionListener {
      public Random rand = new Random();
      public JTextField DisplayResult = new JTextField();
      public int Result;
      public JButton Roll = new JButton("ROLL");
       
      public DiceRoll() {
         super (new GridBagLayout());
         GridBagConstraints c = new GridBagConstraints();
         c.gridwidth = GridBagConstraints.REMAINDER;
         c.fill = GridBagConstraints.HORIZONTAL;
         c.fill = GridBagConstraints.BOTH;
         c.weightx = 1.0;
         c.weighty = 1.0;
         add(DisplayResult, c);
         add(Roll, c);
         
         Roll.addActionListener(new ActionListener() {
         public void actionPerformed (ActionEvent e) {
            RollDice();
         }
      });
         
      }
      
      public void RollDice() {
         Result = rand.nextInt(6) + 1;
         DisplayResult.setText(Integer.toString(Result));
      }

      public static void CreateFrame() {
         JFrame frame = new JFrame("Roll a Die");
         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         frame.add(new DiceRoll());
         frame.pack();
         frame.setVisible(true);
         frame.getContentPane().setBackground(Color.BLACK);
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