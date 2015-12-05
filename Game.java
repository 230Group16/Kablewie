/**
* @file    -Game.java
* @author  -Rabidra Thapa
* @date    -28/11/2015
* @see     -Board.java
* @see	    -Scoreboard.java
*
* A simple frame that can contain panels
*
*/

package kablewie;

import java.awt.Dimension;
import java.util.Timer;

import javax.swing.*;

public class Game extends JPanel {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int getHeight() {
		return m_height;
	}
	
	public int getWidth() {
		return m_width;
	}
	
	public Board getBoard() {
		return m_board;
	}
	
	public Scoreboard getScoreboard() {
		return m_scoreboard;
	}
    
    static Timer timer = new Timer();
    static int seconds = 0;
    public static boolean running = true;
    
    
    public Game(int size, int mines) {
    	m_board = new Board(size, mines);
    	m_scoreboard = new Scoreboard();
    	
    	m_height = m_board.getSideLength() + SCOREBOARD_HEIGHT;
    	m_width = m_board.getSideLength();
    	
    	m_scoreboard.setPreferredSize(new Dimension(m_width, SCOREBOARD_HEIGHT));
    	
    	//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    	/* add boardPanel and scoreboardPanel to frame */
    	
    	add(m_scoreboard);
        add(m_board);

        setPreferredSize(new Dimension(m_width, m_height));
    }
    
    public void endGame(boolean tf) {
    	//Stop timer
    	removeAll();
    	
    	if (tf) {
    		//Win
    	} else {
    		//Loss and display animation
    	}
    }

    
    private Board m_board;
    private Scoreboard m_scoreboard;
    public static final int SCOREBOARD_HEIGHT = 100; 
    private int m_height;
    private int m_width;
}
