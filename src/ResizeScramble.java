import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ResizeScramble {

private JFrame frmImageSegmentationPassword;
	
	
	private Client[] users;
	private String loginAs;
	private Client currUser;
	private List<ImgSeg> currPass = new ArrayList<ImgSeg>();
	
	private JLabel jumble1;
	private JLabel jumble2;
	private JLabel jumble3;
	private JLabel jumble4;
	private JLabel jumble5;
	private JLabel jumble6;
	private JLabel jumble7;
	private JLabel jumble8;
	private JLabel jumble9;
	private JLabel jumble10;
	private JLabel jumble11;
	private JLabel jumble12;
	private JLabel jumble13;
	private JLabel jumble14;
	private JLabel jumble15;
	private JLabel jumble16;
	private JPanel jumblePanel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResizeScramble window = new ResizeScramble("");
					window.getFrmImageSegmentationPassword().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResizeScramble(String loginAs) {
		
		this.loginAs = loginAs;
		createUsers();
		initialize();
	}
	
	
	/* createUsers():
	 * 
	 * Create test users and gives them a password image */
	private void createUsers()
	{
		users = new Client[4];
		
		Client user0 = new Client("Satara", "src//large02.jpg");
		users[0] = user0;
		
		Client user1 = new Client("Abigail", "src//exactFitEZ.jpg");
		users[1] = user1;
		
		Client user2 = new Client("Hannah", "src//large01.jpg");
		users[2] = user2;
		
		Client user3 = new Client("Brad", "src//smallEZPassword.jpg");
		users[3] = user3;
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmImageSegmentationPassword(new JFrame());
		getFrmImageSegmentationPassword().setTitle("Login: Step 2");
		getFrmImageSegmentationPassword().getContentPane().setBackground(Color.WHITE);
		getFrmImageSegmentationPassword().setBackground(Color.WHITE);
		getFrmImageSegmentationPassword().setBounds(100, 100, 820, 574);
		getFrmImageSegmentationPassword().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{147, 383, 116, 128, 0};
		gridBagLayout.rowHeights = new int[]{20, 442, 34, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		frmImageSegmentationPassword.getContentPane().setLayout(gridBagLayout);
		JButton btnCompleteLogin = new JButton("Complete Login"); 
		btnCompleteLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/* Check guessed password against Clients stored password */
				boolean loginSuccess = currUser.checkPassword(getPassProgress());
				if(loginSuccess)
				{
					JOptionPane.showMessageDialog(frmImageSegmentationPassword,
							"Successful login to: " + currUser.getUsername());
					System.exit(0);
				}
				else
				{
					/* Close upon login failure */
					JOptionPane.showMessageDialog(frmImageSegmentationPassword,
							"Invalid password. Login Failed.",
							"Not Successful",
							JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
			}
		});
		
		JLabel instructionLabel = new JLabel("Please solve the Image:");
		instructionLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_instructionLabel = new GridBagConstraints();
		gbc_instructionLabel.anchor = GridBagConstraints.WEST;
		gbc_instructionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_instructionLabel.gridx = 0;
		gbc_instructionLabel.gridy = 0;
		getFrmImageSegmentationPassword().getContentPane().add(instructionLabel, gbc_instructionLabel);	
		
		jumblePanel = new JPanel();
		jumblePanel.setBackground(new Color(245, 245, 245));
		GridBagConstraints gbc_jumblePanel = new GridBagConstraints();
		gbc_jumblePanel.insets = new Insets(0, 0, 5, 0);
		gbc_jumblePanel.gridwidth = 4;
		gbc_jumblePanel.gridx = 0;
		gbc_jumblePanel.gridy = 1;
		getFrmImageSegmentationPassword().getContentPane().add(jumblePanel, gbc_jumblePanel);
		jumblePanel.setLayout(new GridLayout(4, 4, 0, 0));
		JButton btnShowProgress = new JButton("Show Progress");
		btnShowProgress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/* Open progress window and initialize with Current password selection */		
				ProgressWindow window = new ProgressWindow(getPassProgress());
				window.getFrmCheckProgress().setVisible(true);
			}
		});
		btnShowProgress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_btnShowProgress = new GridBagConstraints();
		gbc_btnShowProgress.fill = GridBagConstraints.BOTH;
		gbc_btnShowProgress.insets = new Insets(0, 0, 0, 5);
		gbc_btnShowProgress.gridx = 2;
		gbc_btnShowProgress.gridy = 2;
		frmImageSegmentationPassword.getContentPane().add(btnShowProgress, gbc_btnShowProgress);
		btnCompleteLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_btnCompleteLogin = new GridBagConstraints();
		gbc_btnCompleteLogin.fill = GridBagConstraints.BOTH;
		gbc_btnCompleteLogin.gridx = 3;
		gbc_btnCompleteLogin.gridy = 2;
		frmImageSegmentationPassword.getContentPane().add(btnCompleteLogin, gbc_btnCompleteLogin);
		
		/* COMPLETE LOGIN BUTTON */
		
		/* SHOW PROGRESS BUTTON */
		

		/*====== Set up Challenge Password based on username =======*/
		Border border = BorderFactory.createLineBorder(Color.GREEN, 2);
		ImgSeg[] challengeImgs = setupChallenge(loginAs);
		
		if(challengeImgs != null)
		{
			jumble1 = new JLabel(new ImageIcon(challengeImgs[0].getImgSegment()));
			jumble1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					jumble1.setBorder(border);
					currPass.add(challengeImgs[0]);
				}
			});
			jumblePanel.add(jumble1);
			
			jumble2 = new JLabel(new ImageIcon(challengeImgs[1].getImgSegment()));
			jumble2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					jumble2.setBorder(border);
					currPass.add(challengeImgs[1]);
				}
			});
			jumblePanel.add(jumble2);
			
			jumble3 = new JLabel(new ImageIcon(challengeImgs[2].getImgSegment()));
			jumble3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					jumble3.setBorder(border);
					currPass.add(challengeImgs[2]);
				}
			});
			jumblePanel.add(jumble3);
			
			jumble4 = new JLabel(new ImageIcon(challengeImgs[3].getImgSegment()));
			jumble4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					jumble4.setBorder(border);
					currPass.add(challengeImgs[3]);
				}
			});
			jumblePanel.add(jumble4);
			
			jumble5 = new JLabel(new ImageIcon(challengeImgs[4].getImgSegment()));
			jumble5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					jumble5.setBorder(border);
					currPass.add(challengeImgs[4]);
				}
			});
			jumblePanel.add(jumble5);
			
			jumble6 = new JLabel(new ImageIcon(challengeImgs[5].getImgSegment()));
			jumble6.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					jumble6.setBorder(border);
					currPass.add(challengeImgs[5]);
				}
			});
			jumblePanel.add(jumble6);
			
			jumble7 = new JLabel(new ImageIcon(challengeImgs[6].getImgSegment()));
			jumble7.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					jumble7.setBorder(border);
					currPass.add(challengeImgs[6]);
				}
			});
			jumblePanel.add(jumble7);
			
			jumble8 = new JLabel(new ImageIcon(challengeImgs[7].getImgSegment()));
			jumble8.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					jumble8.setBorder(border);
					currPass.add(challengeImgs[7]);
				}
			});
			jumblePanel.add(jumble8);
			
			jumble9 = new JLabel(new ImageIcon(challengeImgs[8].getImgSegment()));
			jumble9.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					jumble9.setBorder(border);
					currPass.add(challengeImgs[8]);
				}
			});
			jumblePanel.add(jumble9);
			
			jumble10 = new JLabel(new ImageIcon(challengeImgs[9].getImgSegment()));
			jumble10.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					jumble10.setBorder(border);
					currPass.add(challengeImgs[9]);
				}
			});
			jumblePanel.add(jumble10);
			
			jumble11 = new JLabel(new ImageIcon(challengeImgs[10].getImgSegment()));
			jumble11.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					jumble11.setBorder(border);
					currPass.add(challengeImgs[10]);
				}
			});
			jumblePanel.add(jumble11);
			
			jumble12 = new JLabel(new ImageIcon(challengeImgs[11].getImgSegment()));
			jumble12.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					jumble12.setBorder(border);
					currPass.add(challengeImgs[11]);
				}
			});
			jumblePanel.add(jumble12);
			
			jumble13 = new JLabel(new ImageIcon(challengeImgs[12].getImgSegment()));
			jumble13.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					jumble13.setBorder(border);
					currPass.add(challengeImgs[12]);
				}
			});
			jumblePanel.add(jumble13);
			
			jumble14 = new JLabel(new ImageIcon(challengeImgs[13].getImgSegment()));
			jumble14.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					jumble14.setBorder(border);
					currPass.add(challengeImgs[13]);
				}
			});
			jumblePanel.add(jumble14);
			
			jumble15 = new JLabel(new ImageIcon(challengeImgs[14].getImgSegment()));
			jumble15.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					jumble15.setBorder(border);
					currPass.add(challengeImgs[14]);
				}
			});
			jumblePanel.add(jumble15);
			
			jumble16 = new JLabel(new ImageIcon(challengeImgs[15].getImgSegment()));
			jumble16.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					jumble16.setBorder(border);
					currPass.add(challengeImgs[15]);
				}
			});
			jumblePanel.add(jumble16);
		}
		else 
		{
			// Exit if no matching Client was found
			System.exit(0);
		}
		
	}
	
	
	/* setupChallenge():
	 * 
	 * Takes entered username and returns challenge password based
	 * on the users password image or returns null to close program */
	private ImgSeg[] setupChallenge(String username)
	{	
		currUser = null;
		
		/* Try to find user */
		for(int i = 0; i < users.length; i++)
		{
			if(username.toLowerCase().equals(users[i].getUsername().toLowerCase()))
			{
				currUser = users[i];
			}
		}
		
		/* If the user is not found, return null and close program */
		if(currUser == null)
		{
			JOptionPane.showMessageDialog(frmImageSegmentationPassword,
					"Did not find user. Please try again.",
					"404 Error",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
		/* return shuffled password */
		return currUser.getChallengePassword();
	}

	
	/* getPassProgress():
	 * 
	 * Creates a Current password sequence to be displayed based
	 * on the users selection. */
	private ImgSeg[] getPassProgress()
	{
		int i;
		ImgSeg[] currentPassword = new ImgSeg[16];
		
		/* Create the Question Mark for for blank spots */
		ImgSeg questionMark = null;	
		try {
			
			BufferedImage questionMarkImg = ImageIO.read(new FileInputStream(new File("src//questionMark.jpg")));
			questionMark = new ImgSeg(questionMarkImg, 65);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/* Start queuing the current password */
		for(i = 0; i < currPass.size(); i++)
		{
			currentPassword[i] = currPass.get(i);
		}
		
		/* Fill in the unused spaces with question marks */
		if(currPass.size() != 16)
		{
			int leftover = currentPassword.length - currPass.size();
			int pos = i;
			
			for(int j = 0; j < leftover; j++ )
			{	
				currentPassword[pos] = questionMark;
				pos++;
			}
		}
				
		return currentPassword;
	}
	
	
	/*===================  Getters and Setters ======================*/
	
	public JFrame getFrmImageSegmentationPassword() {
		return frmImageSegmentationPassword;
	}

	public void setFrmImageSegmentationPassword(JFrame frmImageSegmentationPassword) {
		this.frmImageSegmentationPassword = frmImageSegmentationPassword;
	}
}
