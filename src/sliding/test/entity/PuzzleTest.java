package sliding.test.entity;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

import sliding.model.*;


public class PuzzleTest{

	
	@Test
	public void TestPieceCell() {
		Puzzle aPuzzle = new Puzzle();
		aPuzzle.resetPuzzle(true);
		//The 0th piece (1x1) is the bottom right corner
		//when the puzzle is one piece 
		PuzzlePiece boardPiece = aPuzzle.cell(4, 3);
		assertEquals(aPuzzle.getBoard().get(19), boardPiece);
		
	}
	
	@Test
	public void SelectTest1() {
		Puzzle aPuzzle = new Puzzle();
		assertEquals(aPuzzle.getSelected(), null);
		
	}
	
	@Test
	public void SelectTest2() {
		Puzzle aPuzzle = new Puzzle();
		aPuzzle.resetPuzzle(true);
		PuzzlePiece piece = aPuzzle.getBoard().get(0);
		aPuzzle.setSelected(0);
		assertEquals(piece, aPuzzle.getSelected());
	}
	
	@Test
	public void InstancesTest() {
		Puzzle aPuzzle = new Puzzle();
		aPuzzle.resetPuzzle(true);
		PuzzlePiece piece = aPuzzle.getBoard().get(0);
		LinkedList<Integer> instances = aPuzzle.getInstanceOfPiece(piece);
		assertEquals((int) instances.get(0), 0);	
	}

	@Test
	public void ClearTest() {
		Puzzle aPuzzle = new Puzzle();
		aPuzzle.resetPuzzle(true);
		PuzzlePiece piece = aPuzzle.getBoard().get(0);
		LinkedList<Integer> instances = aPuzzle.getInstanceOfPiece(piece);
		assertEquals((int) instances.get(0), 0);	
	}
	
}
