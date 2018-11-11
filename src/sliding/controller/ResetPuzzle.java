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
		Model newModel = new Model();
		this.model = newModel;
		System.out.println("Hit Reset");
		this.app.resetPuzzle(this.model);
		this.app.resetMoves();
		System.out.println(this.model.getMoves());
		this.app.repaint();
	}
	
	
}
