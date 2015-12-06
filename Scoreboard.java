package kablewie;

import java.awt.Component;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class Scoreboard extends JPanel {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /* Initialisation of variables */
    static int m_time;
    int m_minesDiffused;
    int m_numberOfTilesRevealed;
	private String m_playerName = "";
	private String gameState = "Good luck!";
	int LblSpace = 90;
    JLabel lblName;
    JLabel lblTime;
    JLabel minesDlbl;
    JLabel tilesRlbl;
    JLabel lblGameState;
    final static long MS_IN_SECOND = 1000L;
    public final int SECS_MINS = 60;
    

    
    public int getGameTime() {
        return m_time;
    }
    
    public int getMinesDiffused() {
        return m_minesDiffused;
    }
    
    public int getNumberOfRevealed() {
        return m_numberOfTilesRevealed;
    }
    
    public String getGameState() {
        return gameState;
    }
    
    public Scoreboard() {
        /*Sets grid layout for scoreboard */
    	SpringLayout layout = new SpringLayout();
        setLayout(layout);
        
        m_playerName = JOptionPane.showInputDialog("Enter your name: ", "New Challenger");
        if(m_playerName.length() > 20){
        	m_playerName = JOptionPane.showInputDialog("Sorry character limit is 20.\n Enter your name: ", "New Challenger");
        }
        
        
        lblName = new JLabel("Name - " + m_playerName);
        lblTime = new JLabel("Game time - " + (getGTime()/3600) + ":" + (getGTime()/60) + ":" + (getGTime() % SECS_MINS));
        minesDlbl = new JLabel("Mines diffused - " + getMinesDiffused());
        tilesRlbl = new JLabel("Tiles Revealed - " + getNumberOfRevealed());
        lblGameState = new JLabel(getGameState());
        
        addComponent(lblName);
        addComponent(lblTime);
	    addComponent(minesDlbl);
        addComponent(lblGameState);
        addComponent(tilesRlbl);
        
        /* Layout */
	      layout.putConstraint(SpringLayout.WEST, lblName,
	              10,
	              SpringLayout.WEST, this);
		  layout.putConstraint(SpringLayout.NORTH, lblName,
	              0,
	              SpringLayout.NORTH, this);
		  
		  layout.putConstraint(SpringLayout.EAST, lblTime,
	    		  -10,
	    		  SpringLayout.EAST, this);
	      layout.putConstraint(SpringLayout.NORTH, lblTime,
	    		  0,
	    		  SpringLayout.NORTH, this);
		  
		  layout.putConstraint(SpringLayout.WEST, tilesRlbl,
	    		  10,
	    		  SpringLayout.WEST, this);
	      layout.putConstraint(SpringLayout.NORTH, tilesRlbl,
	    		  5,
	    		  SpringLayout.SOUTH, lblName);
	      
	      layout.putConstraint(SpringLayout.EAST, minesDlbl,
	    		  -10,
	    		  SpringLayout.EAST, this);
	      layout.putConstraint(SpringLayout.NORTH, minesDlbl,
	    		  5,
	    		  SpringLayout.SOUTH, lblTime);
	      
	      layout.putConstraint(SpringLayout.WEST, lblGameState,
	    		  10,
	    		  SpringLayout.WEST, this);
	      layout.putConstraint(SpringLayout.NORTH, lblGameState,
	    		  5,
	    		  SpringLayout.SOUTH, tilesRlbl);
	      
    }
    
    private void addComponent(Component x){
        this.add(x);
    }
    
    public String getPlayerName(){
        return m_playerName;
    }
    
    public static int getGTime(){
        return m_time;
    }
    

    public void setGameState(String message) {
    	gameState = message;
        
    }
    

    public void setGameStateLabel() {
    	lblGameState.setText(gameState);
        
    }
    
    
    public void setGTime() {
    	lblTime.setText(("Game time - " + (getGTime()/(SECS_MINS * SECS_MINS)) + ":" + (getGTime()/SECS_MINS) + ":" + (getGTime() % SECS_MINS)));
        
    }
    
    public void setTilesRevealed() {
    	tilesRlbl.setText("Tiles Revealed - " + getNumberOfRevealed());
        
    }
    
    public void setMinesDiffused() {
    	minesDlbl.setText("Mines diffused - " + getMinesDiffused());
        
    }
    
    public void setPlayerName(String name) {
        m_playerName = name;
    }
    
    public void update() {
    	setGTime();
    	setTilesRevealed();
    	setMinesDiffused();
    }
    
    public static void updatetime(){
        //Creates a timer and sets a task to iterate m_time at every second
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask()
        {
             public void run()
             {
                 Scoreboard.m_time += 1;
                 //System.out.println(Scoreboard.m_time);
             }
        }, MS_IN_SECOND, MS_IN_SECOND);
    }
}
