package JavaEmpProject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class menuscreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuscreen window = new menuscreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public menuscreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1036, 804);
		frame.getContentPane().setBackground(new Color(106, 90, 205));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel welcomeLabel = new JLabel("Welcome to Employee Management System");
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 32));
        welcomeLabel.setBounds(250,50,800,50);
		frame.getContentPane().add(welcomeLabel);
		
		JButton viewEmpButton = new JButton("View Employee");
		viewEmpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().setVisible(false);
	          	  frame.dispose();
	          	  viewemployee.main(null);
			}
		});
	    viewEmpButton.setBounds(400, 200, 300, 40);
	    viewEmpButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        frame.getContentPane().add(viewEmpButton);
        
        JButton addEmpButton = new JButton("Add an employee");
        addEmpButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	  frame.getContentPane().setVisible(false);
          	  frame.dispose();
          	  addemployee.main(null);
        	}
        });
        addEmpButton.setBounds(400, 270, 300, 40);
        addEmpButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(addEmpButton);

		JButton editEmpButton = new JButton("Edit an employee");
		editEmpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().setVisible(false);
	          	  frame.dispose();
	          	  editemployee.main(null);
				
			}
		});
        editEmpButton.setBounds(400, 340, 300, 40);
        editEmpButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        frame.getContentPane().add(editEmpButton);
        
        JButton deleteEmpButton = new JButton("Delete an employee");
        deleteEmpButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.getContentPane().setVisible(false);
	          	  frame.dispose();
	          	  deleteemployee.main(null);
        	}
        });
        deleteEmpButton.setBounds(400, 410, 300, 40);
        deleteEmpButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        frame.getContentPane().add(deleteEmpButton);
        
        JButton exitButton = new JButton("Exit or Logout");
        exitButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	  JOptionPane.showMessageDialog(null, "Logout success");
  			  frame.getContentPane().setVisible(false);
          	  frame.dispose();
          	  Main.main(null);
        	}
        });
        exitButton.setBounds(400, 561, 300, 40);
        exitButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        frame.getContentPane().add(exitButton);
        
        JButton verifyButtom = new JButton("Verify Employee ID");
        verifyButtom.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		frame.getContentPane().setVisible(false);
            	  frame.dispose();
            	  verifyEmployee.main(null);
        		
        	}
        });
        verifyButtom.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        verifyButtom.setBounds(400, 486, 300, 40);
        frame.getContentPane().add(verifyButtom);
	}
}
