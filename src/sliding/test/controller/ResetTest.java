package sliding.test.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import javax.swing.JButton;

import org.junit.Test;

import sliding.boundary.SlidingPuzzleApp;
import sliding.controller.MovePiece;
import sliding.controller.ResetPuzzle;
import sliding.model.Model;

public class ResetTest {
	
	@Test
	public void ResetTest() {
		Model model = new Model();
		SlidingPuzzleApp app = new SlidingPuzzleApp(model);
		//Selects the 1x1 piece in position 15
		model.getPuzzle().setSelected(15);

		JButton button = new JButton("<");
		
		//Test with nothing selected
		MovePiece aMove = new MovePiece(model, app);
		//Moved to position 14
		aMove.movePiece(button);
		
		ResetPuzzle reset = new ResetPuzzle(model,app);
		reset.reset();
		
		assertNull(model.getPuzzle().getBoard().get(14));	
	}
}
