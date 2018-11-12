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
	
	public void cheat() {
		this.model.newPuzzle(true);
		this.app.reset();
		this.app.repaint();
	}
}