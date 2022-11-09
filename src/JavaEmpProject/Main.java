package JavaEmpProject;

import java.awt.EventQueue;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

class EmployeeRegLogin implements Serializable{
	 String username,password;
	 EmployeeRegLogin(String username,String password){
		 this.username = username ;
		 this.password = password;

	 }
	public String getusername() {
		return username;
	}
	public String getpassword() {
		return password;
	}
	
} 
public class Main {

	private JFrame frame;
	private FileOutputStream fout;
	private ObjectOutputStream oos;
	private FileInputStream fin;
	private ObjectInputStream ois;

	File file;
    ArrayList<EmployeeRegLogin> al;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		al = new ArrayList<EmployeeRegLogin>();
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(106, 90, 205));
		frame.setBounds(100, 100, 927, 804);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel loginLabel = new JLabel("Login/Register");
		loginLabel.setFont(new Font("Times New Roman", Font.BOLD, 41));
		loginLabel.setBounds(327, 58, 266, 65);
		frame.getContentPane().add(loginLabel);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		usernameLabel.setForeground(new Color(0, 0, 0));
		usernameLabel.setBounds(200,150,141,50);
		frame.getContentPane().add(usernameLabel);
		
		JTextField usernameField = new JTextField();
        usernameField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        usernameField.setBounds(450,150,420,50);
        frame.getContentPane().add(usernameField);
		
		JLabel passwordlabel = new JLabel("Password");
		passwordlabel.setBounds(200,250,220,50);
		passwordlabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		frame.getContentPane().add(passwordlabel);
		
		
        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        passwordField.setBounds(450,250,420,50);
        frame.getContentPane().add(passwordField);
       
        JButton LoginButton=new JButton("Login");
        LoginButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		boolean flag = false;
        		try {
        			file = new File("LoginDetails.dat");
        			fin = new FileInputStream(file);
        			ois = new ObjectInputStream(fin);
        			ArrayList<EmployeeRegLogin> al = new ArrayList<EmployeeRegLogin>();
        			String username = usernameField.getText();
            		String password = passwordField.getText();
            		while((al = (ArrayList)ois.readObject())!=null) {
            			EmployeeRegLogin e1 = al.get(0);
            			if(username.equalsIgnoreCase(e1.getusername()) && password.equals(e1.getpassword())) {
            				flag = true;
            				break;
            				
            			}
            			else
            				flag = false;
           
            		}
            		if(flag = true) {
            		JOptionPane.showMessageDialog(null, "Login Success");
            		  frame.getContentPane().setVisible(false);
      	          	  frame.dispose();
      	          	  menuscreen.main(null);
            		}
            		else
            			JOptionPane.showMessageDialog(null, "Login Fail");
            		
        		}
        		catch(Exception ae) {
        			JOptionPane.showMessageDialog(null, "Login Fail");
        			ae.printStackTrace();
        			}
        		}
        		
        		
        		
        		
        });
        LoginButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        LoginButton.setBounds(620,398,250, 50);
        frame.getContentPane().add(LoginButton);
        
        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
          		
        		file = new File("LoginDetails.dat");
        		String username = usernameField.getText();
        		String password = passwordField.getText();
        		
        		 
        		al.add(new EmployeeRegLogin(username,password));
        		System.out.println(al);
        		usernameField.setText("");
        		passwordField.setText("");
        		
        		try {
        			
        			if(file.exists()) {
        		
        				oos = new ObjectOutputStream(new FileOutputStream(file,true)){
        					
        					protected void writeStreamHeader() throws java.io.IOException{
        						reset();
        					}
        				};
        				//JOptionPane.showMessageDialog(null, "if sucess");
        			}
        			else {
        				oos = new ObjectOutputStream(new FileOutputStream(file));
        				//JOptionPane.showMessageDialog(null, "else sucess");
        			
        			} 
        			oos.writeObject(al);
        			JOptionPane.showMessageDialog(null, "Registration sucess");
        		
        		}
        		catch(Exception ae) {
        			ae.printStackTrace();
        		}
        	}
        });
        registerButton.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        registerButton.setBounds(200, 398, 250, 50);
        frame.getContentPane().add(registerButton);
		
		
	}
}
