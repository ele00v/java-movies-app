package moviesApp;
//import the required java packages 
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//3.About window 
public class AboutFrame extends JFrame {
    public AboutFrame(){
        //crete JLabel 
        JLabel aboutLbl = new JLabel();
        
        //create exitBtn
        JButton exitBtn = new JButton("Exit");
        
        //cteare exitBntPanel
        JPanel exitBtnPanel = new JPanel();
        
        //set border for aboutLbl 
        aboutLbl.setBorder(new EmptyBorder(0,10,0,10));
        
        //add movie logo 
        aboutLbl.setIcon(new ImageIcon("movieLogo.jpg"));
        
        //set Text for aboutLbl
        aboutLbl.setText( "<html><h2>Movies App</h2>"
                        + "<br>This application  is the final project of the Java lab subject.</br>"
                        + "<br>With this application you can register movies and save them to files based on the category"
                        + " and view the statistics of the movies.</br><br>"
                        + "<br><strong><u>Developer Information</u><strong>"
                        + "<br>Full Name: Eleni Vera"
                        + "<br>Registration Number: 18390152"
                        + "<br>Development Period: 01/06/2022 - 09/06/2022</html>");
        
        //add exitBtn to exitBtnPanel
        exitBtnPanel.add(exitBtn,BorderLayout.SOUTH);
        
        //add aboutLbl to AboutFrame 
        this.add(aboutLbl,BorderLayout.NORTH);
        
        //add exitBtnPanel to aboutFrame 
        this.add(exitBtnPanel,BorderLayout.SOUTH);
        
        //set up & show the frame
        this.setSize(650,300);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setTitle("About");
        this.setVisible(true);
        
        //create exitBtn Listener 
        exitBtn.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitAboutPanel();
            }
        });
        
        //create WindowClosing listener 
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitAboutPanel();
            }
        });
    }
    
    private void exitAboutPanel(){
        //close Abut Window and return to previous window 
        this.setVisible(false);
        this.dispose();
    }
    
}