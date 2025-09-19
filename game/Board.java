package game;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Board extends JButton {
	

	public ImageIcon [] icons = {OthelloPanel.OPEN, OthelloPanel.BLACK, OthelloPanel.WHITE, OthelloPanel.LEGAL};
	private int row;
	private int col;
	private int colorNum;
	public Board(int row, int col, int colorNum) {
		this.row = row;
		this.col = col;
		this.colorNum = colorNum;
	}

	
	public int getRow() {
		return row;
	}

	
	public int getCol() {
		return col;
	}

	
	public ImageIcon getColors()
	{
		return icons[colorNum];
		
	}


	public void updateColors(int num) 
	{
		colorNum = num;
	}
}


