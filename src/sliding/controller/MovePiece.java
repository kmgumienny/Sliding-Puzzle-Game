package sliding.controller;

import java.util.LinkedList;

import javax.swing.JButton;

import sliding.boundary.SlidingPuzzleApp;
import sliding.model.Model;
import sliding.model.PuzzlePiece;

public class MovePiece {

	SlidingPuzzleApp app;
	Model model;
	
	public MovePiece(Model model, SlidingPuzzleApp app) {
		this.model = model;
		this.app = app;
	}
	
	public boolean movePiece(JButton aButton) {
		PuzzlePiece selected = model.getPuzzle().getSelected();
		if(selected == null) {
			return false;
		}else {
			
			String direction = aButton.getText();
			LinkedList<PuzzlePiece> board = this.model.getPuzzle().getBoard();
			LinkedList<Integer> instances = this.model.getPuzzle().getInstanceOfPiece(selected);
			boolean farLeft = (instances.getFirst()%4 == 0);
			boolean farRight = ((instances.getLast() % 4 == 3) || instances.getLast()  %4 == 3);
			boolean top = instances.getFirst() < 4;
			boolean bottom = instances.getLast() > 15;
			

			if(direction.equals("^")) {
				if(top)
					return false;
				else {
					tryMove(selected, board, instances, -4, false);
				}
					
			}
			if(direction.equals("v")) {
				if((selected.getHeight() == 2 && selected.getWidth() == 2) && instances.getFirst() == 13) {
					makeMove(selected, board, instances, 4, true);
					app.gameWin();
					return true;
					
				}else if(selected.getHeight() == 2 && selected.getWidth() == 2)
					return false;
				if(bottom) {
					return false;
				}
				else {
					tryMove(selected, board, instances, 4, true);
				}
			}
			if(direction.equals(">")) {
				if(farRight)
					return false;
				else {
					tryMove(selected, board, instances, 1, true);
				}
	
			}
			if(direction.equals("<")) {
				if(farLeft)
					return false;
				else {
					tryMove(selected, board, instances, -1, false);
				}
			}
			return true;
		}
		}
	public void tryMove(PuzzlePiece selected, LinkedList<PuzzlePiece> board, LinkedList<Integer> instances, int direction, boolean downOrRight) {
		int index;
		int canMove = 1;
		
		
		for(int i = 0; i < instances.size(); i++) {
			index = instances.get(i);
			if(!(board.get(index+direction) == null || board.get(index+direction) == selected)) {
				canMove--;
			}
		}
		
		if(canMove == 1) {
			makeMove(selected, board, instances, direction, downOrRight);
		}
		
	}
	
	public void makeMove(PuzzlePiece selected, LinkedList<PuzzlePiece> board, LinkedList<Integer> instances, int direction, boolean downOrRight) {
		if(!downOrRight)	
			for(int i = 0; i < instances.size(); i++) {
				int index = instances.get(i);
				if(board.get(index+direction) == null || board.get(index+direction) == selected) {
					board.set(index,null);
					board.set(index+direction, selected);
				}
			}
		else
			for(int i = instances.size()-1; i >= 0; i--) {
				int index = instances.get(i);
				if(board.get(index+direction) == null || board.get(index+direction) == selected) {
					board.set(index,null);
					board.set(index+direction, selected);
				}
			}
		this.model.increaseMoves();
		this.app.updateMoves();
		this.app.repaint();
			
	}
	
	
}
