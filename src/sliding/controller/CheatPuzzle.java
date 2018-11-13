package sliding.controller;

import sliding.boundary.SlidingPuzzleApp;
import sliding.model.Model;

public class CheatPuzzle {

	SlidingPuzzleApp app;
	Model model;
	
	public CheatPuzzle(Model model, SlidingPuzzleApp app) {
		this.model = model;
		this.app = app;
	}
	
	/*
	 * resets the puzzle to the cheat configuration and removes
	 * the selected piece
	 */
	public void cheat() {
		this.model.newPuzzle(true);
		this.model.getPuzzle().setSelected(-1);
		this.app.reset();
		this.app.repaint();
	}
}
