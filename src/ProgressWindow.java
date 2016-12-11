import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class ProgressWindow {

	private JFrame frmCheckProgress;
	private ImgSeg[] currPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgressWindow window = new ProgressWindow(null);
					window.getFrmCheckProgress().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProgressWindow(ImgSeg[] currPassword) {
		this.currPassword = currPassword;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmCheckProgress(new JFrame());
		getFrmCheckProgress().setTitle("Check Password Progress");
		getFrmCheckProgress().getContentPane().setBackground(Color.WHITE);
		getFrmCheckProgress().getContentPane().setLayout(new GridLayout(4, 4, 0, 0));
		
		// Display current password
		JLabel lbl0 = new JLabel(new ImageIcon(currPassword[0].getImgSegment()));
		getFrmCheckProgress().getContentPane().add(lbl0);
		
		JLabel lbl1 = new JLabel(new ImageIcon(currPassword[1].getImgSegment()));
		getFrmCheckProgress().getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel(new ImageIcon(currPassword[2].getImgSegment()));
		getFrmCheckProgress().getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel(new ImageIcon(currPassword[3].getImgSegment()));
		getFrmCheckProgress().getContentPane().add(lbl3);
		
		JLabel lbl4 = new JLabel(new ImageIcon(currPassword[4].getImgSegment()));
		getFrmCheckProgress().getContentPane().add(lbl4);
		
		JLabel lbl5 = new JLabel(new ImageIcon(currPassword[5].getImgSegment()));
		getFrmCheckProgress().getContentPane().add(lbl5);
		
		JLabel lbl6 = new JLabel(new ImageIcon(currPassword[6].getImgSegment()));
		getFrmCheckProgress().getContentPane().add(lbl6);
		
		JLabel lbl7 = new JLabel(new ImageIcon(currPassword[7].getImgSegment()));
		getFrmCheckProgress().getContentPane().add(lbl7);
		
		JLabel lbl8 = new JLabel(new ImageIcon(currPassword[8].getImgSegment()));
		getFrmCheckProgress().getContentPane().add(lbl8);
		
		JLabel lbl9 = new JLabel(new ImageIcon(currPassword[9].getImgSegment()));
		getFrmCheckProgress().getContentPane().add(lbl9);
		
		JLabel lbl11 = new JLabel(new ImageIcon(currPassword[10].getImgSegment()));
		getFrmCheckProgress().getContentPane().add(lbl11);
		
		JLabel lbl12 = new JLabel(new ImageIcon(currPassword[11].getImgSegment()));
		getFrmCheckProgress().getContentPane().add(lbl12);
		
		JLabel lbl13 = new JLabel(new ImageIcon(currPassword[12].getImgSegment()));
		getFrmCheckProgress().getContentPane().add(lbl13);
		
		JLabel lbl10 = new JLabel(new ImageIcon(currPassword[13].getImgSegment()));
		getFrmCheckProgress().getContentPane().add(lbl10);
		
		JLabel lbl14 = new JLabel(new ImageIcon(currPassword[14].getImgSegment()));
		getFrmCheckProgress().getContentPane().add(lbl14);
		
		JLabel lbl15 = new JLabel(new ImageIcon(currPassword[15].getImgSegment()));
		getFrmCheckProgress().getContentPane().add(lbl15);
		
		
		getFrmCheckProgress().setBounds(10, 49, 800, 440);
		// Do not EXIT on close
		getFrmCheckProgress().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public JFrame getFrmCheckProgress() {
		return frmCheckProgress;
	}

	public void setFrmCheckProgress(JFrame frmCheckProgress) {
		this.frmCheckProgress = frmCheckProgress;
	}
}
