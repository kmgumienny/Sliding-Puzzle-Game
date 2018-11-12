package sliding.controller;
import sliding.boundary.SlidingPuzzleApp;
import sliding.model.Model;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class SelectPiece extends MouseAdapter {

	SlidingPuzzleApp app;
	Model model;
	
	public SelectPiece(Model model, SlidingPuzzleApp app) {
		this.model = model;
		this.app = app;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int offSet = this.app.getPuzzleView().getOffSet();
		LinkedList<Integer> widthByHeight = this.app.getPuzzleView().getPiecePixelDimenstions();
		int row = (e.getY() - offSet) / (widthByHeight.getLast() + offSet);
		int column = (e.getX() - offSet) / (widthByHeight.getFirst() + offSet);
		this.model.getPuzzle().setSelected(4*row + column);
		this.app.repaint();
	}
	
	
}
