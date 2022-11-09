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
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class EmployeeAdd implements Serializable{
	 String Eid ;
	 EmployeeAdd(String Eid){
		 this.Eid = Eid ;
	 }
	public String getEid() {
		return Eid;
	}
	
} 

public class verifyEmployee {

	private JFrame frame;
	private FileOutputStream fout;
	private ObjectOutputStream oos;
	private FileInputStream fin;
	private ObjectInputStream ois;

	File file;
    ArrayList<EmployeeAdd> al;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					verifyEmployee window = new verifyEmployee();
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
	public verifyEmployee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		al = new ArrayList<EmployeeAdd>();
		frame = new JFrame();
		frame.setBounds(100, 100, 1036, 804);
		frame.getContentPane().setBackground(new Color(106, 90, 205));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel verifyLabel = new JLabel("Enter ID To Verify");
		verifyLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		verifyLabel.setBounds(140, 259, 278, 62);
		frame.getContentPane().add(verifyLabel);
		
		JTextField eidField = new JTextField();
		eidField.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		eidField.setBounds(541, 259, 295, 50);
		frame.getContentPane().add(eidField);
		eidField.setColumns(10);
		JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
   
  			  frame.getContentPane().setVisible(false);
          	  frame.dispose();
          	  menuscreen.main(null);
        	}
        });
        backButton.setBounds(140, 377, 232, 40);
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        frame.getContentPane().add(backButton);
        JButton verifyButton = new JButton("Verify");
        verifyButton.setBackground(new Color(248, 248, 255));
        verifyButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		boolean flag = false;
        		try {
        			String Eid = eidField.getText();
        			file = new File("./EmpDetails/"+Eid);
        			
            		if(file.exists()) {
            			JOptionPane.showMessageDialog(null, "Employee Is Working");
            		
            		}
            		else
            			JOptionPane.showMessageDialog(null, "Employee Is Not Working");
            		
        		}
        		
        		
        		catch(Exception ae) {
        			JOptionPane.showMessageDialog(null, "Employee Is Not Working");
        			ae.printStackTrace();
        			}
        		}
        		
        		
        	
        });
        verifyButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        verifyButton.setBounds(552, 377, 232, 40);
        frame.getContentPane().add(verifyButton);
	}

}
