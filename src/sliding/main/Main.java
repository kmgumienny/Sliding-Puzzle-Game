package sliding.main;

import sliding.boundary.*;
import sliding.model.*;

public class Main {
	public static void main (String args[]) {
		Model m = new Model();
		SlidingPuzzleApp app = new SlidingPuzzleApp(m);
		
		app.setVisible(true);
	}
}
