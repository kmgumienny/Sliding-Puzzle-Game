package sliding.model;

import java.util.LinkedList;

public class Puzzle {

	LinkedList<PuzzlePiece> board = new LinkedList<PuzzlePiece>();
	LinkedList<PuzzlePiece> original = new LinkedList<PuzzlePiece>();

	PuzzlePiece selected;

	
	/*
	 * The board is split into the size (5x4) of the play board.
	 * Elements are added to where they exist, multiple times
	 * and when the board is drawn, pieces are drawn as they are 
	 * iterated through and stored in a separate linkedlist 
	 * in order to make drawing elements and moving them easier
	 * Board appears as
	 *  |0 1 1 2|
	 *  |3 1 1 4|
	 *  |3 5 x 4|
	 *  |6 5 x 7|
	 *  |8 8 9 9|
	 */
	public Puzzle(boolean isOneMoveAway) {
		
		
		selected = null;
		//PuzzlePiece constructor (int width, int height)
		
		
		
		//1x1 piece
		PuzzlePiece piece0 = new PuzzlePiece(1, 1);
		PuzzlePiece piece2 = new PuzzlePiece(1, 1);
		PuzzlePiece piece6 = new PuzzlePiece(1, 1);
		PuzzlePiece piece7 = new PuzzlePiece(1, 1);

		//1x2 piece
		PuzzlePiece piece3 = new PuzzlePiece(1,2);
		PuzzlePiece piece4 = new PuzzlePiece(1,2);
		PuzzlePiece piece5 = new PuzzlePiece(1,2);

		//2x1 piece
		PuzzlePiece piece8 = new PuzzlePiece(2,1);
		PuzzlePiece piece9 = new PuzzlePiece(2,1);

		//Key piece
		PuzzlePiece piece1 = new PuzzlePiece(2, 2);
		
		if(isOneMoveAway) {
			//fifth row
			board.add(piece8);
			board.add(piece8);
			board.add(piece9);
			board.add(piece9);
			
			//Fourth row
			board.add(piece6);
			board.add(piece5);
			board.add(null);
			board.add(piece7);
			
			//Third row
			board.add(piece3);
			board.add(piece5);
			board.add(null);
			board.add(piece4);
			
			//Second row
			board.add(piece3);
			board.add(piece1);
			board.add(piece1);
			board.add(piece4);

			//First row
			board.add(piece0);
			board.add(piece1);
			board.add(piece1);
			board.add(piece2);
			
			board.add(null);
			board.add(null);
			board.add(null);
			board.add(null);

			
			//Fifth row
			original.add(piece8);
			original.add(piece8);
			original.add(piece9);
			original.add(piece9);
					
			//Fourth row
			original.add(piece6);
			original.add(piece5);
			original.add(null);
			original.add(piece7);
					
			//Third row
			original.add(piece3);
			original.add(piece5);
			original.add(null);
			original.add(piece4);
							
			//Second row
			original.add(piece3);
			original.add(piece1);
			original.add(piece1);
			original.add(piece4);
					
			//First row
			original.add(piece0);
			original.add(piece1);
			original.add(piece1);
			original.add(piece2);
			
			original.add(null);
			original.add(null);
			original.add(null);
			original.add(null);
		}else {
		
			//First row
			board.add(piece0);
			board.add(piece1);
			board.add(piece1);
			board.add(piece2);
		
			//Second row
			board.add(piece3);
			board.add(piece1);
			board.add(piece1);
			board.add(piece4);
			
			//Third row
			board.add(piece3);
			board.add(piece5);
			board.add(null);
			board.add(piece4);
		
			//Fourth row
			board.add(piece6);
			board.add(piece5);
			board.add(null);
			board.add(piece7);
		
			//Fourth row
			board.add(piece8);
			board.add(piece8);
			board.add(piece9);
			board.add(piece9);
		
			board.add(null);
			board.add(null);
			board.add(null);
			board.add(null);
		
			//First row
			original.add(piece0);
			original.add(piece1);
			original.add(piece1);
			original.add(piece2);
				
			//Second row
			original.add(piece3);
			original.add(piece1);
			original.add(piece1);
			original.add(piece4);
				
			//Third row
			original.add(piece3);
			original.add(piece5);
			original.add(null);
			original.add(piece4);
		
			//Fourth row
			original.add(piece6);
			original.add(piece5);
			original.add(null);
			original.add(piece7);
				
			//Fourth row
			original.add(piece8);
			original.add(piece8);
			original.add(piece9);
			original.add(piece9);

			original.add(null);
			original.add(null);
			original.add(null);
			original.add(null);
		
		}
	}
	
	
	//TODO
	public PuzzlePiece cell(int r, int c) {
		return this.board.get((r*4)+c);
	}
	
	public LinkedList<PuzzlePiece> getBoard(){
		return this.board;
	}
	
	public void setSelected(int location) {
		this.selected = board.get(location);
	}
	
	public PuzzlePiece getSelected() {
		return this.selected;
	}
	
	public void resetPuzzle() {
		this.board.clear();
		for(PuzzlePiece x : original) {
			this.board.add(x);
		}
	}
	public LinkedList<Integer> getInstanceOfPiece(PuzzlePiece aPiece){
		LinkedList<Integer> instances = new LinkedList<Integer>();
		for(int i = 0; i <20; i++) {
			if(this.board.get(i) == aPiece)
				instances.add(i);
		}
		return instances;
	}
	
}
