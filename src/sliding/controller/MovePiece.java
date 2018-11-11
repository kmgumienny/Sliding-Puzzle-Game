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
	
	public void movePiece(JButton aButton) {
		PuzzlePiece selected = model.getPuzzle().getSelected();
		if(selected == null) {
			return;
		}else {
			int index; 
			int pieceWidth = selected.getWidth();
			int pieceHeight = selected.getHeight();
			String direction = aButton.getText();
			index = model.getPieceIndex(selected);
			LinkedList<PuzzlePiece> board = this.model.getPuzzle().getBoard();
			LinkedList<Integer> instances = this.model.getPuzzle().getInstanceOfPiece(selected);
			boolean farLeft = (instances.getFirst()%4 == 0);
			boolean farRight = ((instances.getFirst() % 4 == 3) || instances.getLast()  %4 == 3);
			boolean top = instances.getFirst() < 4;
			boolean bottom = instances.getLast() > 15;
			

			if(direction.equals("^")) {
				if(top)
					return;
				else {
					tryMove(selected, board, instances, -4);
				}
					
			}
			if(direction.equals("v")) {
				if(bottom)
					return;
				else {
					tryMove(selected, board, instances, 4);
				}
			}
			if(direction.equals(">")) {
				if(farRight)
					return;
				else {
					tryMove(selected, board, instances, 1);
				}
	
			}
			if(direction.equals("<")) {
				if(farLeft)
					return;
				else {
					tryMove(selected, board, instances, -1);
				}
			}
		}
		}
	public void tryMove(PuzzlePiece selected, LinkedList<PuzzlePiece> board, LinkedList<Integer> instances, int direction) {
		int index;
		int canMove = 1;
		boolean moved = false;
		
		
		for(int i = 0; i < instances.size(); i++) {
			index = instances.get(i);
			if(!(board.get(index+direction) == null || board.get(index+direction) == selected))
				canMove--;
		}
		if(canMove == 1) {
			for(int i = 0; i < instances.size(); i++) {
				index = instances.get(i);
				if(board.get(index+direction) == null || board.get(index+direction) == selected) {
					board.set(index,null);
					board.set(index+direction, selected);
					moved = true;
				}
			}
		}
		if(moved == true) {
			this.model.increaseMoves();
			this.app.repaint();
		}
	}
	
}
