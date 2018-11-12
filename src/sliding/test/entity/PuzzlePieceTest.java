package sliding.test.entity;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import sliding.model.PuzzlePiece;


public class PuzzlePieceTest{

	/*
	assertEquals();
	assertTrue();
	 */
	
	@Test
	public void TestPieceHeight() {
		PuzzlePiece somePiece = new PuzzlePiece(2,2);
		assertEquals(2, somePiece.getHeight());
	}
	
	@Test
	public void TestPieceWidth() {
		PuzzlePiece somePiece = new PuzzlePiece(2,2);
		assertEquals(2, somePiece.getWidth());
	}
	
}
