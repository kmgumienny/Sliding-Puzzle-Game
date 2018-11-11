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
	
	public void reset() {
		this.model.newPuzzle();
		this.app.reset();
		this.app.repaint();
	}
	
	
}
