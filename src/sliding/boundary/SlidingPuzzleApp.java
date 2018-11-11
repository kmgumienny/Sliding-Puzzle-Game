package sliding.boundary;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sliding.controller.*;
import sliding.model.Model;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class SlidingPuzzleApp extends JFrame {

	private JPanel contentPane;
	Model model;
	PuzzleView puzzleView;
	
	JButton up, down, right, left, reset;
	
	JLabel moves, winLabel;


	
	public PuzzleView getPuzzleView() {
		return puzzleView;
	}
	
	public void reset() {
		this.up.setEnabled(true);
		this.down.setEnabled(true);
		this.left.setEnabled(true);
		this.right.setEnabled(true);
		this.winLabel.setVisible(false);
		updateMoves();
	}
	
	public void updateMoves() {
		this.moves.setText(Integer.toString(model.getMoves()));
	}
	
	public void gameWin() {
		this.winLabel.setVisible(true);
		this.up.setEnabled(false);
		this.down.setEnabled(false);
		this.left.setEnabled(false);
		this.right.setEnabled(false);
	}

	
	
	public SlidingPuzzleApp(Model model) {
		this.model = model;
		setResizable(false);
		setTitle("Klotski Sliding Puzzle App");
		//setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		this.puzzleView = new PuzzleView(model.getPuzzle());
		//this.puzzleView.setBackground(Color.GRAY);
		this.puzzleView.setSize(new Dimension(400, 500));
		
		this.puzzleView.addMouseListener(new SelectPiece(this.model, SlidingPuzzleApp.this));
		this.reset = new JButton("Reset");
		this.reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ResetPuzzle(model, SlidingPuzzleApp.this).reset();
				
			}
		});
		
		this.moves = new JLabel(Integer.toString(model.getMoves()));
		this.winLabel = new JLabel("<html> Congratulations! <br> You won \n the game champ! </html>");
		this.winLabel.setVisible(false);
		
		this.down = new JButton("v");
		this.down.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MovePiece(model, SlidingPuzzleApp.this).movePiece(down);
			}
		});
		this.up = new JButton("^");
		this.up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MovePiece(model, SlidingPuzzleApp.this).movePiece(up);
			}
		});
		this.left = new JButton("<");
		this.left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MovePiece(model, SlidingPuzzleApp.this).movePiece(left);
			}
		});
		this.right = new JButton(">");
		this.right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MovePiece(model, SlidingPuzzleApp.this).movePiece(right);
			}
		});
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(puzzleView, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(33)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(reset))
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(winLabel, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(left)
													.addGap(33)
													.addComponent(right)))))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(18)
										.addComponent(moves)
										.addGap(18)))
								.addContainerGap(31, Short.MAX_VALUE))
							.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(down)
								.addGap(80)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(up)
							.addGap(80))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(puzzleView, GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(moves))
							.addGap(59)
							.addComponent(winLabel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addGap(54)
							.addComponent(up)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(right)
								.addComponent(left))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(down)
							.addPreferredGap(ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
							.addComponent(reset)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
