package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;



import java.awt.Insets;

public class OthelloPanel extends JPanel {

	private JPanel centerPanel;
	
	private int width = 600, height = 500;
	private Board[][] Boards = new Board[8][8];
	
	public static ImageIcon OPEN = new ImageIcon("src/images/blank.png");
	public static ImageIcon BLACK = new ImageIcon("src/images/blackdisc.png");
	public static ImageIcon WHITE = new ImageIcon("src/images/whitedisc.png");
	public static ImageIcon LEGAL = new ImageIcon("src/images/legalmarker.png");
	ImageIcon currentDiscColor = BLACK;
	int number = -1;
	int blackCounter = 0, whiteCounter = 0;
	
	public OthelloPanel() 
	{
		this.setPreferredSize(new Dimension(width, height));
		this.setLayout(new BorderLayout());
//		centerPanel = new JPanel();
		JPanel panelBoard = createBoard();
		this.add(panelBoard, BorderLayout.CENTER);
		JPanel panelTitle = createPanelTitle();
		this.add(panelTitle, BorderLayout.NORTH);

		
		//System.out.print(toConsoleString());
		
	}
	private JPanel createPanelTitle() {
		JPanel panelTitle = new JPanel();
		panelTitle.setLayout(new GridLayout(1, 1, 0, 0));
		{
			JLabel lblOthello = new JLabel("Othello");
			lblOthello.setBorder(new EmptyBorder(20, 0, 10, 0));
			lblOthello.setOpaque(true);
			lblOthello.setForeground(Color.WHITE);
			lblOthello.setBackground(Color.BLACK);
			lblOthello.setFont(new Font("ChunkFive", Font.BOLD, 54));
			lblOthello.setHorizontalAlignment(SwingConstants.CENTER);
			panelTitle.add(lblOthello);
		}
		return panelTitle;
	}

	/**
	 * Creates the play Colors GUI as a sidebar.
	 * 
	 *
	 */
	

	/**
	 * Creates the Game Board play grid.
	 * 
	 * 
	 */
	private JPanel createBoard() {
		JPanel Main = new JPanel();
		Main.setBackground(Color.GRAY);
		Main.setSize(new Dimension(200, 200));
		Main.setPreferredSize(new Dimension(200, 200));
		Main.setMinimumSize(new Dimension(200, 200));
		Main.setBounds(new Rectangle(0, 0, 200, 200));
		Main.setLayout(new GridLayout(0, 8, 0, 0));

		EventHandler eventHandler = new EventHandler();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Boards[i][j] = new Board(i, j,0);
				if ((i == 3 && j == 3) || (i == 4 && j == 4)) {
					Boards[i][j] = new Board(i, j,2);
				}
				if ((i == 4 && j == 3) || (i == 3 && j == 4)) {
					Boards[i][j] = new Board(i, j,1);
				}
				Boards[i][j].setPreferredSize(new Dimension(50, 50));
				Boards[i][j].setOpaque(true);
				Boards[i][j].setMinimumSize(new Dimension(50, 50));
				Boards[i][j].setMaximumSize(new Dimension(50, 50));
				Boards[i][j].setMargin(new Insets(0, 0, 0, 0));
				Boards[i][j].setBorder(new LineBorder(new Color(0, 0, 0)));
				Boards[i][j].setBackground(new Color(51, 204, 102));

				Boards[i][j].addActionListener(eventHandler);
				Boards[i][j].setIcon(Boards[i][j].getColors());
				Main.add(Boards[i][j]);
			}
		}
		findLegalBoardsInEveryDirection(currentDiscColor);
		return Main;
	}

	/**
	 * Determines the possible legal moves for current player.
	 * 
	 * 
	 */
	private void findLegalBoards(ImageIcon currentDiscColor, int rowStep, int colStep) {
		int rowX;
		int colX;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				/* Find current players discs, move in a direction */
				if (Boards[i][j].getColors().equals(currentDiscColor)) {
					rowX = i + rowStep;
					colX = j + colStep;
					
					/* Stay within board boundaries */
					if (rowX < 0 || rowX > 7 || colX < 0 || colX > 7) {
						continue;
					}
					/* If the next Board is opposite, keep moving */
					while (Boards[rowX][colX].getColors().equals(oppositeDisc(currentDiscColor))) {
						rowX = rowX + rowStep;
						colX = colX + colStep;
						
						/* Stay in bounds */
						if (rowX < 0 || rowX > 7 || colX < 0 || colX > 7) {
							break;
						}
						/* Then if the next Board is open, it is legal */
						if (Boards[rowX][colX].getColors().equals(OPEN)) {
							Boards[rowX][colX].updateColors(3);
							
							repaint();
							
						}
					}
				}
			}
		}
	}
	
	/**
	 * Passes 8 directions for findLegalBoards() method.
	 * 
	 * 
	 */
	private void findLegalBoardsInEveryDirection(ImageIcon icon) {
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				findLegalBoards(icon, i, j);
				
			}
		}
		updateGUI();
		repaint();
	}

	/**
	 * Exchanges players turn, if player has no legal moves, current player is
	 * skipped.
	 * 
	 * 
	 */
	public boolean changeTurn(boolean legalMovesPresent, ImageIcon whoseTurn) {
		if (legalMovesPresent) {
			currentDiscColor = oppositeDisc(currentDiscColor);
			return true;
		} else
			return false;
	}
	public void endOfTurn() {
		if (changeTurn(countBoards(LEGAL) > 0, currentDiscColor)) {
			if (currentDiscColor.equals(WHITE))
			{
				System.out.println("White's turn to move");
			}
			else
			{
				System.out.println("Black's turn to move");
			}
			
			
		} else {
			if (currentDiscColor.equals(WHITE))
			{
				System.out.println("No legal moves. White's move again");
			}
			else
			{
				System.out.println("No legal moves. Black's move again");
			}
			
			
		}
	}

	

		/**
		 * Changes ImageIcon labels when there is a winner.
		 */
//		private void setLabelsWinner() {
//			ImageIcon winner = (countBoards(WHITE) > countBoards(BLACK)) ? WHITE : BLACK;
//			String winText = winner + " WON!!!";
//			System.out.println(winText);
//		}

		/**
		 * Notifies the user when they clicked on an invalid Board.
		 */
		private void invalidBoard() {
			System.out.println("Not a valid square.");
			
		}
	

	/**
	 * Changes ImageIcon text according to whether how the turn changed over.
	 */
	

	/**
	 * Updates ImageIcon text on GUI and in console.
	 * 
	 * 
	 */
	

	/**
	 * Runs method othelloFlip() in every direction to flip discs.
	 * 
	 *
	 */
	public void flipDiscs(Board Board) {
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				othelloFlip(Board.getRow(), Board.getCol(), Board.getColors(), i, j);
			}
		}
		updateGUI();
		repaint();
	}

	/**
	 * Cleans up legal markers so that new ones can be placed.
	 */
	public void removeLegalMarkers() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (Boards[i][j].getColors().equals(LEGAL)) {
					
					Boards[i][j].updateColors(0);
					Boards[i][j].setIcon(OPEN);
				}
			}
		}
	}

	/**
	 * Updates the game board with the current ImageIcon of everything.
	 */
	public void updateGUI() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(Boards[i][j].getColors().equals(OPEN))
				{
					number = 0;
				}
				else if (Boards[i][j].getColors().equals(BLACK))
				{
					number = 1;
				}
				else if (Boards[i][j].getColors().equals(WHITE))
				{
					number = 2;
				}
				else if (Boards[i][j].getColors().equals(LEGAL))
				{
					number = 3;
				}
				Boards[i][j].updateColors(number);
				Boards[i][j].setIcon(Boards[i][j].getColors());
			}
		}
	}

	/**
	 * Counts a ImageIcon type, black, white, open, or legal, of each Board.
	 * 
	 */
	public int countBoards(ImageIcon type) {
		int typeCount = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (Boards[i][j].getColors().equals(type))
					typeCount++;
			}
		}
		return typeCount;
	}

	/**
	 * Reference to the console for debug and secondary visual checking.
	 * 
	 */
	

	/**
	 * Switches between the disk options, white or black.
	 * 
	 */
	public ImageIcon oppositeDisc(ImageIcon disc) {
		if (disc.equals(BLACK))
			return WHITE;
		else
			return BLACK;
	}

	/**
	 * Checks for disks to be flipped is an inputted direction. If such a condition
	 * is present, disks are flipped.
	 * 
	 * 
	 */
	public void othelloFlip(int rowStart, int colStart, ImageIcon turnColor, int rowStep, int colStep) {
		int rowX = rowStart + rowStep;
		int colX = colStart + colStep;

		/* Stay in bounds */
		if (rowX < 0 || rowX > 7 || colX < 0 || colX > 7) {
			return;
		}
		/**
		 * We need ImageIcon of Board in the direction we are checking Keep checking until
		 * we hit empty cells
		 */
		while (Boards[rowX][colX].getColors().equals(BLACK)|| Boards[rowX][colX].getColors().equals(WHITE)) {
			/**
			 * Return direction to flip chips Run else statement till we hit a cell with the
			 * same color
			 */
			if (Boards[rowX][colX].getColors() == turnColor) {
				while (!(rowStart == rowX && colStart == colX)) {
					if(turnColor.equals(OPEN))
					{
						number = 0;
					}
					else if (turnColor.equals(BLACK))
					{
						number = 1;
						
					}
					else if (turnColor.equals(WHITE))
					{
						number = 2;
						
					}
					else if (turnColor.equals(LEGAL))
					{
						number = 3;
					}
					Boards[rowX][colX].updateColors(number);
					rowX = rowX - rowStep;
					colX = colX - colStep;
				}
				break;
			}
			/* Moving to next cell in direction to check for chip color change */
			else {
				rowX = rowX + rowStep;
				colX = colX + colStep;
			}

			/* Check to keep us on the board, break when we are off board */
			if (rowX < 0 || rowX > 7 || colX < 0 || colX > 7) {
				break;
			}
		}
	}

	/**
	 * Searches for the ImageIcon of Boards. If neither player has legal moves
	 * available, the game is over. If there are no open Boards, the game is over.
	 * 
	 * 
	 */
	public boolean checkWin() {
		if (countBoards(OPEN) == 0 && countBoards(LEGAL) == 0) {
			return true;
		} else {
			findLegalBoardsInEveryDirection(currentDiscColor);
			if (countBoards(LEGAL) == 0) {
				findLegalBoardsInEveryDirection(oppositeDisc(currentDiscColor));
				if (countBoards(LEGAL) == 0)
					return true;
			}
		}
		return false;
	}
	private class EventHandler implements ActionListener {

		/**
		 * Places a disc when the Board clicked is a legal Board. Then performs some
		 * clean up, flips discs, changes images, updates text, and always checks if the
		 * game has been won. If Board was invalid, it notifies the player.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			Board Board = (Board) e.getSource();
			//lblImageIcon3.setText("");
			if (Board.getColors().equals(LEGAL)) {
				removeLegalMarkers();
				if(currentDiscColor.equals(OPEN))
				{
					number = 0;
				}
				else if (currentDiscColor.equals(BLACK))
				{
					number = 1;
				}
				else if (currentDiscColor.equals(WHITE))
				{
					number = 2;
				}
				else if (currentDiscColor.equals(LEGAL))
				{
					number = 3;
				}
				Board.updateColors(number);
				flipDiscs(Board);
				findLegalBoardsInEveryDirection(oppositeDisc(currentDiscColor));
				endOfTurn();
				
				if (checkWin()) {
					for (int row = 0; row < 8; row++)
					{
						for (int col = 0; col < 8; col++)
						{
							if (Boards[row][col].getColors().equals(WHITE))
							{
								whiteCounter++;
							}
							if (Boards[row][col].getColors().equals(BLACK))
							{
								blackCounter++;
							}
						}
					}
					System.out.println("Win");
					System.out.println("black: " + blackCounter + "   white: " + whiteCounter);
					String winner = "";
					if (blackCounter > whiteCounter)
					{
						winner = "Black";
					}
					if(whiteCounter > blackCounter)
					{
						winner = "White";
					}
					
					int answer = JOptionPane.showConfirmDialog(null, winner + " was the winner! Play Again?", "Game Over",JOptionPane.YES_NO_OPTION);
					 if (answer == 0)
					 {
						 	for (int row = 0; row < 8; row++)
						 	{
						 		for (int col = 0; col < 8; col++)
						 		{
						 			Boards[row][col].updateColors(0);
						 			repaint();
						 		}
						 	}
						 	createBoard();
						 	winner = "";
						 	blackCounter = 0; 
						 	whiteCounter = 0;
						 	
					 }
					 else
					 {
						 System.exit(0);
					 }
				}
			} else {
				invalidBoard();
			}
		}
}

}
