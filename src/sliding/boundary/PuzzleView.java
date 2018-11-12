package sliding.boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JPanel;

import sliding.model.*;


/** 
 * Knows how to visually present the puzzle. 
 */
public class PuzzleView extends JPanel {

	Puzzle puzzle;
	int offSet = 10;
	int boxHeight;
	int boxWidth;
	
	public PuzzleView(Puzzle puzzle) {
		this.puzzle = puzzle;
		this.setFont(new Font("MS Comic Sans", Font.PLAIN, 48));
	}
	
	public LinkedList<Integer> getPiecePixelDimenstions(){
		LinkedList<Integer> sizes = new LinkedList<Integer>();
		sizes.add(this.boxWidth);
		sizes.add(this.boxHeight);
		return sizes;
		
	}
	
	public int getOffSet() {
		return this.offSet;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		this.boxHeight = (this.getHeight() - (7*offSet))/5;
		this.boxWidth = (this.getWidth() - (5*offSet))/4;	
		//g.fillRect(0, 0,  400, 500);
		LinkedList<PuzzlePiece> done = new LinkedList<PuzzlePiece>();
		LinkedList<PuzzlePiece> board = this.puzzle.getBoard();
		for (int x =0; x< board.size(); x++) {
			PuzzlePiece aPiece = board.get(x);
			if(done.contains(aPiece) || aPiece == null) 
				continue;
			g.setColor(Color.gray);
			if(aPiece == this.puzzle.getSelected())
				g.setColor(Color.red);
			int column = x % 4;
			int row = (x - column)/4;
			
			int bufferC = ((column+1) * offSet) + (column * this.boxWidth);
			int bufferR = (row+1)*offSet + row * this.boxHeight;

			int pieceWidth = aPiece.getWidth() * this.boxWidth + ((aPiece.getWidth()-1)*offSet);
			int pieceHeight = aPiece.getHeight() * this.boxHeight + ((aPiece.getHeight()-1)*offSet);

			g.fillRect(bufferC, bufferR, pieceWidth, pieceHeight);
			
			done.add(aPiece);
			
		}
	}
	
}
