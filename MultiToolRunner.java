import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MultiToolRunner extends JPanel implements ActionListener {
   public JButton setDeck;
   public JButton checkRuling;
   public JButton lpCalc;
   public JButton checkBias;
   public JTextField field;
   public JButton CoinFlipper;
   public JButton DieRoller;
   
   
   public MultiToolRunner() {
      super (new GridBagLayout());
      field = new JTextField(30);
      field.setText("Welcome to the Yu-Gi-Oh! Multi-Tool Program!");
      
      setDeck = new JButton("Set Deck");
      setDeck.addActionListener(new ActionListener() {
         public void actionPerformed (ActionEvent e) {
            WriteHtmlCardDatabase.MCOPY();
         }
      });
      checkRuling = new JButton("Check Your Deck's Rulings");
      checkRuling.addActionListener(new ActionListener() {
         public void actionPerformed (ActionEvent e) {
            ReadHtmlCardDatabase.MCOPY();
         }
      });
      checkBias = new JButton ("Check Your Deck's Turn Bias");
      checkBias.addActionListener(new ActionListener() {
         public void actionPerformed (ActionEvent e) {
            TurnBias.MCOPY();
         }
      });
      lpCalc = new JButton("LP Counter");
      lpCalc.addActionListener(new ActionListener() {
         public void actionPerformed (ActionEvent e) {
            lpCalculator.MCOPY();
         }
      });
      CoinFlipper = new JButton ("Coin Flip");
      CoinFlipper.addActionListener(new ActionListener() {
         public void actionPerformed (ActionEvent e) {
            CoinFlip.MCOPY();
         }
      });
      DieRoller = new JButton ("Die Roll");
      DieRoller.addActionListener(new ActionListener() {
         public void actionPerformed (ActionEvent e) {
            DiceRoll.MCOPY();
         }
      });
      
            
      
      GridBagConstraints c = new GridBagConstraints();
      c.gridwidth = GridBagConstraints.REMAINDER;
      c.fill = GridBagConstraints.HORIZONTAL;
      c.fill = GridBagConstraints.BOTH;
      c.weightx = 1.0;
      c.weighty = 1.0;
      add(field, c);
      add(setDeck, c);
      add(checkRuling, c);
      add(checkBias, c);
      add(lpCalc, c);
      add(CoinFlipper, c);
      add(DieRoller, c);
   }
   public static void createAndShowGUI() {
        JFrame frame = new JFrame("Welcome on Yugioh");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MultiToolRunner());
        frame.pack();
        frame.setVisible(true);
   }
   public void actionPerformed(ActionEvent ae) {
     System.out.println("This is a placeholder method");
   }
   public static void main(String args[]) {
           
           javax.swing.SwingUtilities.invokeLater(new Runnable() {
              public void run() {
                 createAndShowGUI();
              }
           });
      }
}
      
      