package sliding.model;


public class Model {
	Puzzle puzzle;
	int moves;
	
	public Model() {
		this.puzzle = new Puzzle(true);
		this.moves = 0;
	}
	
	public void setPuzzle(Puzzle puzzle) {
		this.puzzle = puzzle;
	}
	
	public Puzzle getPuzzle() {
		return this.puzzle;
	}
	
	public void newPuzzle() {
		this.puzzle.resetPuzzle();
		this.moves=0;
	}
	
	public int getMoves() {
		return this.moves;
	}
	
	public void increaseMoves() {
		this.moves++;
	}
	
}
