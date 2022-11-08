package JavaEmpProject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class deleteemployee {

	private JFrame frame;
    File file;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteemployee window = new deleteemployee();
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
	public deleteemployee() {
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
			JLabel deleteLabel = new JLabel("Enter ID To Delete");
			deleteLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
			deleteLabel.setBounds(106, 170, 234, 35);
			frame.getContentPane().add(deleteLabel);
			
			JTextField eidField = new JTextField();
			eidField.setFont(new Font("Times New Roman", Font.PLAIN, 21));
			eidField.setBounds(401, 163, 440, 56);
			frame.getContentPane().add(eidField);

			JButton backButton = new JButton("Back");
	        backButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	   
	  			  frame.getContentPane().setVisible(false);
	          	  frame.dispose();
	          	  menuscreen.main(null);
	        	}
	        });
	        backButton.setBounds(106, 360, 128, 56);
	        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        frame.getContentPane().add(backButton);
	        JButton deleteButton = new JButton("Delete");
	        deleteButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		try  
	        		{         
	        			
	        			String Eid = eidField.getText();
	        			
	        			file = new File("./EmpDetails/"+Eid);
	        			
	        			     
	        		if(file.delete())                       
	        		{  
	        			JOptionPane.showMessageDialog(null, "Employee Is Deleted");   
	        		}  
	        		else  
	        		{  
	        			JOptionPane.showMessageDialog(null, "Employee Is Not Working To Delete");
	        		}  
	        		}  
	        		catch(Exception ae)  
	        		{  
	        		ae.printStackTrace();  
	        		}  
	        		
	        	}
	        });
	        deleteButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        deleteButton.setBounds(713, 341, 128, 56);
	        frame.getContentPane().add(deleteButton);
	}

}
