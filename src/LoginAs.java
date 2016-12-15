import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/* 4x4 Image Segmentation Password
 * CPSC 525 - Principles of computer security
 * 
 * @Authors:
 * Abigail Oliver
 * Satara Cressy
 * Hannah Mudge 
 * 
 * */

public class LoginAs {

	private JFrame frmLoginStep;
	private JTextField usernameTextField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAs window = new LoginAs();
					window.frmLoginStep.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginAs() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginStep = new JFrame();
		frmLoginStep.setTitle("Login: Step 1");
		frmLoginStep.getContentPane().setBackground(Color.WHITE);
		frmLoginStep.getContentPane().setLayout(null);
		
		JLabel lblPleaseEnterUsername = new JLabel("Please Enter Username:");
		lblPleaseEnterUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPleaseEnterUsername.setBounds(10, 25, 208, 40);
		frmLoginStep.getContentPane().add(lblPleaseEnterUsername);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(10, 73, 208, 27);
		frmLoginStep.getContentPane().add(usernameTextField);
		usernameTextField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/* Start LoginWindow and initialize with username */		
				ResizeScramble window = new ResizeScramble(usernameTextField.getText());
				window.getFrmImageSegmentationPassword().setVisible(true);
				
			}
		});
		btnLogin.setBounds(129, 111, 89, 23);
		frmLoginStep.getContentPane().add(btnLogin);
		frmLoginStep.setBounds(100, 100, 262, 206);
		frmLoginStep.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
