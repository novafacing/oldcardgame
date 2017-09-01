import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.PrintStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.*;
import javax.swing.event.HyperlinkListener;

public class ReadHtmlCardDatabase extends JPanel {
      protected JTextField field = new JTextField(1);
      //public JButton close;
      
      public ReadHtmlCardDatabase() {
         super (new GridBagLayout());
         JEditorPane pane = new JEditorPane();
         pane.setContentType("text/html");
         pane.setEditable(false);
         pane.setPreferredSize(new Dimension(800,400));
         pane.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
         File htmlfile = new File("" + System.getProperty("user.dir") + "/HTMLCardRulingDeckRef.html");
            try {
               pane.setPage(htmlfile.toURI().toURL());
            } catch (MalformedURLException e) {
               System.err.println("MalformedURLException: " + e.getMessage());
            } catch (IOException e) {
               System.err.println("IOException: " + e.getMessage());
            }
            pane.addHyperlinkListener(new HyperlinkListener() {
               public void hyperlinkUpdate(HyperlinkEvent e) {
                   if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                       if (Desktop.isDesktopSupported()) {
                           try {
                               Desktop.getDesktop().browse(e.getURL().toURI());
                           } catch (IOException e1) {
                               e1.printStackTrace();
                           } catch (URISyntaxException e1) {
                               e1.printStackTrace();
                           }
                       }
                   }
               }
            });            
         JScrollPane jsp = new JScrollPane(pane);
         field.setText("THIS SPACE INTENTIONALLY LEFT BLANK");
         field.setEditable(false);
         
         /*
         close = new JButton("CLOSE");
         close.addActionListener(new ActionListener() {
            public void actionPerformed (ActionEvent e) {
              System.exit(1);
            }
         });
         */
         
         GridBagConstraints c = new GridBagConstraints();
         c.gridwidth = GridBagConstraints.REMAINDER;
         c.fill = GridBagConstraints.HORIZONTAL;
         c.fill = GridBagConstraints.BOTH;
         c.weightx = 1.0;
         c.weighty = 1.0;
         add(jsp, c);
         add(field, c);
         //add(close, c);
         
      }
      public static void CreateFrame() {
         JFrame frame = new JFrame("We Read Your Deck!");
         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         frame.add(new ReadHtmlCardDatabase());
         frame.pack();
         frame.setVisible(true);
      }
      
      public static void MCOPY() {
         javax.swing.SwingUtilities.invokeLater(new Runnable() {
              public void run() {
                 CreateFrame();
              }
           });
      }
         
}