
package moviesApp;
//import the required java packages 
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
//2.Statistics window 
public class StatisticsFrame extends JFrame {
    
    ArrayList<Movie> StatMovieList = new ArrayList<Movie>();
    JTextArea statisticsArea;
    JPanel exitBtnPanel;
    JLabel statisticsLbl;
    JButton exitBtn; 
    
    public StatisticsFrame(){
        //create JLabel
        statisticsLbl = new JLabel("<html><h3>Statistics</h3></html>"); 
        
        //create JTextArea
        statisticsArea = new JTextArea();
        statisticsArea.setEditable(false);
        
        //create JButton 
        exitBtn = new JButton("Exit");
        
        //create JPanel 
        exitBtnPanel = new JPanel();

        //add exitBtn to exitBtnPanel 
        exitBtnPanel.add(exitBtn);
        
        //add statisticsLbl, statisticsArea and exitBtnPanel to StatisticsFrame 
        this.add(statisticsLbl,BorderLayout.NORTH);
        this.add(statisticsArea,BorderLayout.CENTER);
        this.add(exitBtnPanel,BorderLayout.SOUTH);
        
        //set up & show the frame 
        this.setSize(400,200);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Statistics");
        this.setVisible(true);
        
        //create exitBtn listener 
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitStatisticsPanel();
            }
        });
        
        //create windowClosing listener 
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitStatisticsPanel();
            }
        });
       
        int regMovies=registeredMovies();
        
        statisticsArea.setText("Total number of registered movies:" +  regMovies
                             + "\nCategory with most movies(times):" + categoryWithMostMovies(regMovies)
                             + "\nOldest movie from all categories:" + oldestMovie(regMovies)
                             + "\nNewest movie(Year):" + newestMovie(regMovies));
    }
    
    private ArrayList<Movie> readFiles(){
        List<String> categoryList = new ArrayList<String>();
        
        StatMovieList.clear();
        
        categoryList.add("Action");
        categoryList.add("Comedy");
        categoryList.add("Fantasy");
        categoryList.add("Horror");
        
        int i;
        int size = categoryList.size();
        //for all categories
        for(i=0; i<size; i++){
            //create fileName 
            String fileName = categoryList.get(i) + ".txt";
             try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName)); 
                String line = "";
                String[] token;
                while (reader.ready()) {
                    //read from file line by line 
                    line = reader.readLine();
                    //split line to tokens seperated by \t
                    token = line.split("\t");
                    if (token.length == 9) {
                            //create Movie
                            Movie movie = new Movie(token[0], token[1], token[2], token[3], token[4], token[5], token[6], token[7],token[8] );
                            //add movie to StatMovieList 
                            StatMovieList.add(movie);
                    }  
                }
                reader.close();
            }catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(StatisticsFrame.this,"Can't access file " ,"File not found error",JOptionPane.ERROR_MESSAGE);
            }catch (IOException ex) {
                JOptionPane.showMessageDialog(StatisticsFrame.this,"Can't access file " ,"File not found error",JOptionPane.ERROR_MESSAGE);
            }
        } 
        return StatMovieList;
    }  
    
    private int registeredMovies(){
        readFiles();
        //get StatMovieList size 
        int i = StatMovieList.size();
        return i;
    }
    
    private String categoryWithMostMovies(int regMovies){
        String categoryWithMostMovies = "";
        int actionCount=0, fantasyCount=0, horrorCount=0, comedyCount=0;
        int j;
        //for all the movies in StatMovieList
        for(j=0;j<regMovies;j++){
            //increase counter for each movie from the corresponding category 
            switch (StatMovieList.get(j).getCategory()) {
                case "Action":
                    actionCount++;
                    break;
                case "Fantasy":
                    fantasyCount++;
                    break;
                case "Horror":
                    horrorCount++; 
                    break;
                case "Comedy":
                    comedyCount++;
                    break;
                default:
                    break;
            }
        }    
        //get category with most movies and the number of movies 
        if(actionCount>=fantasyCount || actionCount>=horrorCount || actionCount>=comedyCount){
            categoryWithMostMovies = "Action(" + Integer.toString(actionCount) + ")";
        }else if(fantasyCount>=actionCount || fantasyCount>=horrorCount || fantasyCount>=comedyCount){
            categoryWithMostMovies =  "Fantasy(" + Integer.toString(fantasyCount) + ")";
        }else if(horrorCount>=actionCount || horrorCount>=fantasyCount || horrorCount>=comedyCount){
            categoryWithMostMovies =  "Horror(" + Integer.toString(horrorCount) + ")";
        }else if(comedyCount>=actionCount || comedyCount>=horrorCount || comedyCount>=fantasyCount){
            categoryWithMostMovies =  "Comedy(" + Integer.toString(comedyCount) + ")";
        } 
        return categoryWithMostMovies;
    }
    
    private String oldestMovie(int regMovies){
        //set year of first movie from Statovielist as oldest
        int oldest = Integer.parseInt(StatMovieList.get(0).getYear().toString());
        int temp,i,pos=0;
        //for all the movies in StatMoviList
        for(i=1;i<regMovies;i++){
            //get next movie from StatMovieList 
            temp=Integer.parseInt(StatMovieList.get(i).getYear().toString());
            if(temp<oldest){
                //if temp is older than oldest then set temp as oldest and save posision in pos
                oldest= temp;
                pos=i;
            }
        }
        //return title and year of oldest movie 
        String oldestMovie=StatMovieList.get(pos).getTitle().toString() + "(" + StatMovieList.get(pos).getYear().toString() + ")" ;
        return oldestMovie;
    }
    
    private String newestMovie(int regMovies){
        //set year of first movie from Statovielist as newest
        int newest = Integer.parseInt(StatMovieList.get(0).getYear().toString());
        int temp,i,pos=0;
        //for all the movies in StatMoviList
        for(i=0;i<regMovies;i++){
            //get next movie from StatMovieList 
            temp=Integer.parseInt(StatMovieList.get(i).getYear().toString());
            if(temp>newest){
                //if temp is newer than newest then set temp as newest and save posision in pos
                newest= temp;
                pos=i;
            }
        }
        //return title and year of newest movie 
        String newestMovie=StatMovieList.get(pos).getTitle().toString() + "(" + StatMovieList.get(pos).getYear().toString() + ")" ;
        return newestMovie;
    }
    
    private void exitStatisticsPanel(){
        //close Abut Window and return to previous window 
        StatMovieList.clear();
        this.setVisible(false);
        this.dispose();
    }
}