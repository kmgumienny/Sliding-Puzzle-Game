package sliding.model;

public class PuzzlePiece {

	int width;
	int height;
	int id;

	public PuzzlePiece(int width, int height) {
		this.width = width;
		this.height = height;
	}
	Boolean isKeyPiece() {
	    return (this.width == 2 && this.height ==2);
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
}
