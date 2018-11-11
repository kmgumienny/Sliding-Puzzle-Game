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
		System.out.println("Hit Reset");
		this.model.newPuzzle();
		this.app.updateMoves();
		System.out.println(this.model.getMoves());
		this.app.repaint();
	}
	
	
}
