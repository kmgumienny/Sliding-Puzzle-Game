package EntityTests;

import static org.junit.Assert.assertEquals;

import java.awt.Component;
import java.awt.event.MouseEvent;

import org.junit.Test;

import sliding.boundary.SlidingPuzzleApp;
import sliding.controller.SelectPiece;
import sliding.model.Model;

public class SelectPieceTest {

	@Test
	public void selectTest() {
		Model model = new Model();
		SlidingPuzzleApp app = new SlidingPuzzleApp(model);
		
		SelectPiece select = new SelectPiece(model, app);
		//    public MouseEvent(Component source, int id, long when, int modifiers,
        //int x, int y, int clickCount, boolean popupTrigger,
        //int button)
		
		//Creates a mouse click over the first tile
		MouseEvent click = new MouseEvent(app, 1, 1, 1, 10, 10, 1, false);
		//This should be over the 0th tile
		select.mouseClicked(click);

		assertEquals(model.getPuzzle().getBoard().get(0), model.getPuzzle().getSelected());
	}
}
