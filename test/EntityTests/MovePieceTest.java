package EntityTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.awt.event.MouseEvent;

import javax.swing.JButton;

import org.junit.Test;

import sliding.boundary.SlidingPuzzleApp;
import sliding.controller.MovePiece;
import sliding.controller.SelectPiece;
import sliding.model.*;

public class MovePieceTest {

	@Test
	public void MoveTestFalse() {
		Model model = new Model();
		SlidingPuzzleApp app = new SlidingPuzzleApp(model);
		JButton button = new JButton("v");
		
		//Test with nothing selected
		MovePiece aMove = new MovePiece(model, app);
		
		assertFalse(aMove.movePiece(button));	
	}
	
	@Test
	public void MoveTest1() {
		Model model = new Model();
		SlidingPuzzleApp app = new SlidingPuzzleApp(model);
		JButton left = new JButton("<");
		
		model.getPuzzle().setSelected(7);
		//Test with nothing selected
		MovePiece aMove = new MovePiece(model, app);
		
		assertTrue(aMove.movePiece(left));	
	}
	
	@Test
	public void MoveTest2() {
		Model model = new Model();
		SlidingPuzzleApp app = new SlidingPuzzleApp(model);
		JButton left = new JButton("<");
		JButton right = new JButton(">");
		
		model.getPuzzle().setSelected(7);
		//Test with nothing selected
		MovePiece aMove = new MovePiece(model, app);
		aMove.movePiece(left);
		
		assertTrue(aMove.movePiece(right));	
	}
	
	@Test
	public void MoveTest3() {
		Model model = new Model();
		SlidingPuzzleApp app = new SlidingPuzzleApp(model);
		JButton left = new JButton("<");
		JButton down = new JButton("v");
		
		model.getPuzzle().setSelected(7);
		//Test with nothing selected
		MovePiece aMove = new MovePiece(model, app);
		aMove.movePiece(left);
		
		assertTrue(aMove.movePiece(down));	
	}
	
	@Test
	public void MoveTest4() {
		Model model = new Model();
		SlidingPuzzleApp app = new SlidingPuzzleApp(model);
		JButton left = new JButton("<");
		JButton up = new JButton("^");
		JButton down = new JButton("v");
		
		model.getPuzzle().setSelected(7);
		//Test with nothing selected
		MovePiece aMove = new MovePiece(model, app);
		aMove.movePiece(left);
		aMove.movePiece(down);
		
		assertTrue(aMove.movePiece(up));	
	}
	
}
