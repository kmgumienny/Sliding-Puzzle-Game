package sliding.test.controller;

import static org.junit.Assert.assertNull;

import javax.swing.JButton;

import org.junit.Test;

import sliding.boundary.SlidingPuzzleApp;
import sliding.controller.CheatPuzzle;
import sliding.controller.MovePiece;
import sliding.controller.ResetPuzzle;
import sliding.model.Model;

public class CheatTest {

	
	@Test
	public void CheatTest() {
		Model model = new Model();
		SlidingPuzzleApp app = new SlidingPuzzleApp(model);
		//Selects the 1x1 piece in position 15
		
		
		CheatPuzzle cheat = new CheatPuzzle(model,app);
		cheat.cheat();
		
		//Should be a null space here now
		assertNull(model.getPuzzle().getBoard().get(6));	
	}
}

