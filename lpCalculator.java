import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class lpCalculator extends JPanel implements ActionListener {
         JTextArea log = new JTextArea(20,30);
         JScrollPane pane = new JScrollPane(log);
         JButton player1Add = new JButton("+");
         JButton player2Add = new JButton("+");
         JButton player1Sub = new JButton("-");
         JButton player2Sub = new JButton("-");
         JTextField player1LP = new JTextField("8000");
         JTextField player2LP = new JTextField("8000");
         JTextField player1AMT = new JTextField("0");
         JTextField player2AMT = new JTextField("0");
         GridBagConstraints c = new GridBagConstraints();
         public String P1LP; //String of player 1s LP amount
         public int P1LPI; //Int of player 1s LP amount
         public String P2LP; //String of Player 2s LP amount
         public int P2LPI; //Int of player 2s LP amount
         public String P1CH; //String of the change in LP for player 1
         public int P1CHI; //Int of the change in LP for player 1
         public String P2CH; //String of the change in LP for player 2
         public int P2CHI; //Int of the change in LP for player 2
         
    void addGB( Component component, int x, int y  ) {
        c.gridx = x;  
        c.gridy = y;
        add ( component, c );
    }
    
    //Get the text from Player1AMT, convert to int, add to P1LP, settext of Player1LP to P1LP.
    public void AddLpForPlayer1() {
       P1CH = player1AMT.getText(); //set change LP temp to the value in the textfield.
       P1CHI = Integer.parseInt(P1CH); //change LP temp value to an integer.
       P1LP = player1LP.getText(); //get the text from the current LP block.
       P1LPI = Integer.parseInt(P1LP); //change current LP value to integer.
       log.append("Player 1 LP From: " + P1LP + "\n");
       P1LPI = P1LPI + P1CHI; //set the current LP value to the current value + the change in LP.
       P1LP = Integer.toString(P1LPI); //change the current LP value back to string.
       player1LP.setText(P1LP); //set the textField to display the current LP value.
       log.append("To: " + P1LPI + "\n");
       
    }
    public void SubLpForPlayer1() {
      P1CH = player1AMT.getText();
      P1CHI = Integer.parseInt(P1CH);
      P1LP = player1LP.getText();
      P1LPI = Integer.parseInt(P1LP);
      log.append("Player 1 LP From: " + P1LP + "\n");
      P1LPI = P1LPI - P1CHI;
      P1LP = Integer.toString(P1LPI);
      player1LP.setText(P1LP);
      log.append("To: " + P1LPI + "\n");
    }
    public void AddLpForPlayer2() {
       P2CH = player2AMT.getText(); //set change LP temp to the value in the textfield.
       P2CHI = Integer.parseInt(P2CH); //change LP temp value to an integer.
       P2LP = player2LP.getText(); //get the text from the current LP block.
       P2LPI = Integer.parseInt(P2LP); //change current LP value to integer.
       log.append("Player 2 LP From: " + P2LP + "\n");
       P2LPI = P2LPI + P2CHI; //set the current LP value to the current value + the change in LP.
       P2LP = Integer.toString(P2LPI); //change the current LP value back to string.
       player2LP.setText(P2LP); //set the textField to display the current LP value.
       log.append("To: " + P2LPI + "\n");
       
    }
    public void SubLpForPlayer2() {
      P2CH = player2AMT.getText();
      P2CHI = Integer.parseInt(P2CH);
      P2LP = player2LP.getText();
      P2LPI = Integer.parseInt(P2LP);
      log.append("Player 2 LP From: " + P2LP + "\n");
      P2LPI = P2LPI - P2CHI;
      P2LP = Integer.toString(P2LPI);
      player2LP.setText(P2LP);
      log.append("To: " + P2LPI + "\n");
    }
 

 
    public lpCalculator() {
        super (new GridBagLayout());
           int x, y;  // for clarity
           c.weightx = 1.0;
           c.weighty = 1.0;
           c.fill = GridBagConstraints.BOTH;
           c.gridwidth = 3;
           addGB(pane, x = 0, y = 0);
           c.fill = GridBagConstraints.HORIZONTAL;
           c.gridwidth = 1;
           c.weightx = .1;
           c.weighty = .1;
           addGB(player1Add, x = 0, y = 3);
           addGB(player2Add, x = 2, y = 3);
           addGB(player1Sub, x = 0, y = 4);
           addGB(player2Sub, x = 2, y = 4);
           addGB(player1LP, x = 0, y = 1);
           addGB(player2LP, x = 2, y = 1);
           addGB(player1AMT, x = 0, y = 2);
           addGB(player2AMT, x = 2, y = 2);
           player1Add.addActionListener(new ActionListener() {
               public void actionPerformed (ActionEvent e) {
                  AddLpForPlayer1();
               }
           });
           player1Sub.addActionListener(new ActionListener() {
               public void actionPerformed (ActionEvent e) {
                  SubLpForPlayer1();
               }
           });
           player2Add.addActionListener(new ActionListener() {
               public void actionPerformed (ActionEvent e) {
                  AddLpForPlayer2();
               }
           });
           player2Sub.addActionListener(new ActionListener() {
               public void actionPerformed (ActionEvent e) {
                  SubLpForPlayer2();
               }
           });
  
      }
      public static void createAndShowGUI() {
        JFrame frame = new JFrame("LP Calculator");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new lpCalculator());
        frame.setSize(400,800);
        frame.pack();
        frame.setVisible(true);
     
      }

      public void actionPerformed (ActionEvent evt) {
      }  
      
      public static void MCOPY() {  
         javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               createAndShowGUI();
            }
         });
      } 
}
         

        
         