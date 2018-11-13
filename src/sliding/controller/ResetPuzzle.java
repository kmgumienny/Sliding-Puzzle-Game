package sliding.controller;

import sliding.boundary.SlidingPuzzleApp;
import sliding.model.*;

public class ResetPuzzle {

	SlidingPuzzleApp app;
	Model model;
	
	public ResetPuzzle(Model model, SlidingPuzzleApp app) {
		this.model = model;
		this.app = app;
	}
	
	/*
	 * Resets the puzzle and number of moves. Method sets the board
	 * to the original position and moves are set to 0 
	 */
	public void reset() {
		this.model.newPuzzle(false);
		this.model.getPuzzle().setSelected(-1);
		this.app.reset();
		this.app.repaint();
	}
	
	
}
