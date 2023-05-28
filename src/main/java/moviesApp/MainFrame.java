package moviesApp;
//import the required java packages 
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
//1. Movie registration window 
public class MainFrame  extends JFrame{
    private JLabel titleLbl;
    private JLabel yearLbl;
    private JLabel durationLbl;
    private JLabel directorLbl;
    private JLabel categoryLbl;
    private JLabel productionLbl;
    private JLabel protagonistLbl;
    private JLabel languageLbl;
    
    private JTextField titleTf;
    private JTextField yearTf;
    private JTextField durationTf;
    private JTextField directorTf;
    private JTextField productionTf;
    private JTextField protagonistTf;
    private JTextField languageTf;
    
    JComboBox categoryComboBox;

    private JTextArea area;
    static ArrayList<Movie> movieList = new ArrayList<Movie>();
    
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu helpMenu;
    private JMenuItem saveItem;
    private JMenuItem statisticsItem;
    private JMenuItem aboutItem;
    private JMenuItem exitItem;
    private JMenuItem clearItem;
    
    private JButton saveBtn;
    private JButton statisticsBtn;
    private JButton aboutBtn;
    private JButton exitBtn;
    private JButton clearBtn;
    
    private int counter=0;
    
    public MainFrame() {
        //create JLabels 
        titleLbl = new JLabel("Title:\t");
        yearLbl = new JLabel("Year:\t");
        durationLbl = new JLabel("Duration:\t");
        directorLbl = new JLabel("Director:\t");
        categoryLbl = new JLabel("Category:\t");
        productionLbl = new JLabel("Production:\t");
        protagonistLbl = new JLabel("Protagonist:\t");
        languageLbl = new JLabel("Language:\t");
        
        //create JTextFields
        titleTf = new JTextField(10);
        yearTf = new JTextField(10);
        durationTf = new JTextField(10);
        directorTf = new JTextField(10);
        productionTf = new JTextField(10);
        protagonistTf = new JTextField(10);
        languageTf = new JTextField(10);
        
        //create JComboBox
        categoryComboBox=new JComboBox();
        
        //add items to categoryCommboBox
        categoryComboBox.addItem("Select option");
        categoryComboBox.addItem("Action");
        categoryComboBox.addItem("Comedy");
        categoryComboBox.addItem("Horror");
        categoryComboBox.addItem("Fantasy");
        
        //create JTextArea 
        area = new JTextArea();
        area.setEnabled(false);
        
        //create JΜenuΒar  and JMenus
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        helpMenu = new JMenu("Help");
        
        //create JMenuItems
        saveItem = new JMenuItem("Save");
        statisticsItem = new JMenuItem("Statistics");
        clearItem = new JMenuItem("Clear fields");
        aboutItem = new JMenuItem("About");
        exitItem = new JMenuItem("Exit");
        
        //add fileMenu and helpMenu to menuBar
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        
        //add items to fileMenu and helpMenu 
        fileMenu.add(saveItem);
        fileMenu.add(statisticsItem);
        fileMenu.add(clearItem);
        helpMenu.add(aboutItem);
        helpMenu.add(exitItem);
        
        //create JButtons
        saveBtn = new JButton("Save");
        statisticsBtn = new JButton("Statistics");
        clearBtn= new JButton("Clear");
        aboutBtn = new JButton("About");
        exitBtn= new JButton("Exit");
        
        //create topPanel and set FlowLayout.LEFT as layout of the topPanel 
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        //create bottomPanel and set FlowLayout.CENTER as layout of the bottomPanel 
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        //add JLabels and JTextFiled to the topPanel 
        topPanel.add(titleLbl);
        topPanel.add(titleTf);
        topPanel.add(yearLbl);
        topPanel.add(yearTf);
        topPanel.add(durationLbl);
        topPanel.add(durationTf);
        topPanel.add(directorLbl);
        topPanel.add(directorTf);
        topPanel.add(categoryLbl);
        topPanel.add(categoryComboBox);
        topPanel.add(productionLbl);
        topPanel.add(productionTf);
        topPanel.add(protagonistLbl);
        topPanel.add(protagonistTf);
        topPanel.add(languageLbl);
        topPanel.add(languageTf);
        
        //add JButtons to the bottomLayout
        bottomPanel.add(saveBtn);
        bottomPanel.add(statisticsBtn);
        bottomPanel.add(clearBtn);
        bottomPanel.add(aboutBtn);
        bottomPanel.add(exitBtn);
        
        //set menuBar as the JMenuBar of the MainFrame 
        this.setJMenuBar(menuBar);
        
        //set GridLayout as the layout of the MainFrame 
        this.setLayout(new GridLayout(3,1));
        
        //add the JPanels and the JTextArea to the MainFrame
        this.add(topPanel);
        this.add(area);
        this.add(bottomPanel);
        
        //set up & show the frame 
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setTitle("Movies App");
        this.setVisible(true);
        
        //create Save Button listener
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               showMovie();
            }
        });
        
        //create Save Item listener
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMovie();
            }
        });
        
        //create Statistics Button listener
        statisticsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StatisticsFrame();
            }
        });
        
        //create Statistics Item listener
        statisticsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StatisticsFrame();
            }
        });
        
        //create Clear Button listener 
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        
        //create Clear Item listener 
        clearItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        
        //create About Button listener 
        aboutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AboutFrame();
            }
        });
        
        //create About Item listener 
        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AboutFrame();
            }
        }); 
        
        //create Exit Button listener 
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitApp();
            }
        });
        
        //create Exit Item listener 
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitApp();
            }
        });
        
        //create windowClosing listener 
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitApp();
            }
        }); 
   }
    
    private void exitApp() {
        //get Text from JTextFields and selectedItem from JComboBox
        String title = titleTf.getText();
        String year = yearTf.getText();
        String duration = durationTf.getText();
        String director = directorTf.getText();
        String category = String.valueOf(categoryComboBox.getSelectedItem());
        String production = productionTf.getText();
        String protagonist = protagonistTf.getText();
        String language = languageTf.getText();
        int i;
         
        if (!title.isEmpty() || !year.isEmpty() || !duration.isEmpty() || !director.isEmpty() 
            || !category.equals("Select option") || !production.isEmpty() || !protagonist.isEmpty() || !language.isEmpty()) {
            //if some or all JTextFields and JComboBox are not empty
            i = JOptionPane.showConfirmDialog(null, "You have unsaved data. Are you sure you want to exit?","Exit",JOptionPane.YES_NO_OPTION);
            if (i ==JOptionPane.YES_OPTION) 
                System.exit(0);
        }else {
            //if all JTextFields and JComboBox are empty
            i = JOptionPane.showConfirmDialog(null, "Do you want to exit the app?","Exit",JOptionPane.YES_NO_OPTION);
            if (i == JOptionPane.YES_OPTION) 
                System.exit(0);
        }
    }   
    
    private void showMovie(){ 
        //getText from JTextFields and selectedItem from JComboBox
        String code;
        String title = titleTf.getText();
        String year = yearTf.getText();
        String duration = durationTf.getText();
        String director = directorTf.getText();
        String category = String.valueOf(categoryComboBox.getSelectedItem());
        String production = productionTf.getText();
        String protagonist = protagonistTf.getText();
        String language = languageTf.getText();
        if (!title.isEmpty() && !year.isEmpty() && !duration.isEmpty() && !director.isEmpty() 
            && !production.isEmpty() && !protagonist.isEmpty() && !language.isEmpty() && !category.equals("Select option")) {
            //if all the fields are fiilled out 
            try {
                //get movie counter from file saveCounter.txt 
                BufferedReader reader = new BufferedReader(new FileReader("saveCounter.txt"));
                counter = reader.read();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            //create code for movie 
            code="M"+counter;
            //increase counter 
            counter++;
            //create Movie 
            Movie movie = new Movie(code, title, year, duration, director, category, production, protagonist, language);
            //add Movie to movieList 
            movieList.add(movie);
            //append movie to JTextarea
            area.append(movie.toString());
            area.append("\n"); 
            //call method saveToFile()
            saveToFile();
            try {
                //save (increased) counter to file saveCounter.txt
                BufferedWriter writer = new BufferedWriter(new FileWriter("saveCounter.txt"));
                writer.write(counter);
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(!title.isEmpty() || !year.isEmpty() || !duration.isEmpty() || !director.isEmpty() 
            || !production.isEmpty() || !protagonist.isEmpty() || !language.isEmpty() || !category.equals("Select option")) {
            //is some of the fields are not fieled out 
            JOptionPane.showMessageDialog(MainFrame.this,"Not all fields are filled-out.", "Save error",JOptionPane.WARNING_MESSAGE);
        }else {
            //if all the fileds are empty 
            JOptionPane.showMessageDialog(MainFrame.this,"Nothing to save.", "Save error",JOptionPane.WARNING_MESSAGE);
        }
    }   
    
    private void clearFields() {
        //clear all the fileds 
        titleTf.setText("");
        yearTf.setText("");
        durationTf.setText("");
        directorTf.setText("");
        productionTf.setText("");
        protagonistTf.setText("");
        languageTf.setText("");
        categoryComboBox.setSelectedIndex(0);    
    }
    
    private void saveToFile(){
        //get selected category from JComboBox
        String category = String.valueOf(categoryComboBox.getSelectedItem());
        if (!category.isEmpty()){
            //create filename 
            String fileName = category + ".txt";
            //get last Movie from MovieList 
            Movie lastMovie = movieList.get(movieList.size() - 1);
            try {
                //append to file 
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true));
                //add movie to file  
                writer.write(lastMovie.toString());
                writer.newLine();
                writer.close();
                //clear JTextFileds and JComboBox 
                clearFields();
                //message for successful save  
                JOptionPane.showMessageDialog(MainFrame.this,"Movie saved in file " + fileName,"Save completed",JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) { 
                JOptionPane.showMessageDialog(saveBtn, "Can't access " + fileName, "File access error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }  
}