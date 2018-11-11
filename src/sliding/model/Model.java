package sliding.model;


public class Model {
	Puzzle puzzle;
	int moves;
	
	public Model() {
		this.puzzle = new Puzzle();
		//CHANGE THIS TO 0
		this.moves = 1;
	}
	
	public Puzzle getPuzzle() {
		return this.puzzle;
	}
	
	public void setPuzzle(Puzzle puzzle) {
		this.puzzle = puzzle;
	}
	
	public void resetMoves() {
		this.moves=0;
	}
	
	public int getMoves() {
		return this.moves;
	}
	
	public void increaseMoves() {
		this.moves++;
	}
	
	public int getPieceIndex(PuzzlePiece aPiece) {
		for (int x = 0; x < this.puzzle.getBoard().size(); x++) {
			if (this.puzzle.getBoard().get(x) == aPiece)
				return x;
		}
		return -1;
	}
	
}
