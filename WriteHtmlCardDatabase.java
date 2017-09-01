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

public class WriteHtmlCardDatabase extends JPanel implements ActionListener {
   protected JTextField textField;
   protected JTextArea textArea;
   //public JButton close;
   public String overall = "";
   public String text = "";
   public String text2 = "";
   public String htmlCode = "<html>";
   public String endHtmlCode = "</html>";
   public String deckname = "";
   private final static String newline = "\n";
         
   public WriteHtmlCardDatabase() {
      super (new GridBagLayout());
 
      textField = new JTextField(30);
      textField.addActionListener(this);
      
      /*
      close = new JButton("CLOSE");
      close.addActionListener(new ActionListener() {
         public void actionPerformed (ActionEvent e) {
            System.exit(1);
         }
      });
      */
      
      textArea = new JTextArea(10,30);
      textArea.setEditable(false);
      JScrollPane scrollPane = new JScrollPane(textArea);
      Font font = new Font("Veranda", Font.BOLD, 12);
      textArea.setFont(font);
      textField.setFont(font);
     
      GridBagConstraints c = new GridBagConstraints();
      c.gridwidth = GridBagConstraints.REMAINDER;
      c.fill = GridBagConstraints.HORIZONTAL;
      c.fill = GridBagConstraints.BOTH;
      c.weightx = 1.0;
      c.weighty = 1.0;
      add(scrollPane, c);
      add(textField, c);
      //add(close, c);
         try {
            System.setOut(new PrintStream(new File("" + System.getProperty("user.dir") + "/HTMLCardRulingDeckRef.html")));
                  } catch (Exception e) {
                     e.printStackTrace();
                  }
      } 
      public void actionPerformed (ActionEvent evt) {
         text = textField.getText();
         text2 = text.replace(" ","_");
         System.out.println("<b>" + text + " - </b>" + "<a href=\"http://www.yugioh.wikia.com/wiki/Card_Rulings:" + text2 + "\"> http://www.yugioh.wikia.com/wiki/Card_Rulings:" + text2 + "</a>");
         System.out.println("<br");
         textField.selectAll(); 
         textArea.append(text);
         textArea.append("\n");
         textArea.setCaretPosition(textArea.getDocument().getLength());
      }   
      public static void createAndShowGUI() {
        JFrame frame = new JFrame("We Make Your Deck!");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new WriteHtmlCardDatabase());
        frame.pack();
        frame.setVisible(true);
     
      }
      
      public static void MCOPY() {  
         javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               createAndShowGUI();
            }
         });
      } 
   }
