package ControllerTests;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import sliding.model.*;

public class ModelTest {

	/*
	assertEquals();
	assertTrue();
	 */
	
	@Test
	public void TestModelMoves() {
		Model someModel = new Model();
		someModel.increaseMoves();
		assertEquals(1, someModel.getMoves());
	}
	
	@Test
	public void TestModelMovesReset() {
		Model someModel = new Model();
		someModel.increaseMoves();
		someModel.newPuzzle();
		assertEquals(0, someModel.getMoves());
	}
	
	@Test
	public void TestNewPuzzle() {
		Model someModel = new Model();
		Puzzle aPuzzle = new Puzzle(true);
		someModel.setPuzzle(aPuzzle);
		assertEquals(aPuzzle, someModel.getPuzzle());
	}
	
	
}
