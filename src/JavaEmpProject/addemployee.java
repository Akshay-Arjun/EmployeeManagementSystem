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
	 String Eid , Ename ,Egender,Edesignation,Esalary,Enumber,Eemail;
	 EmployeeAdd(String Eid,String Ename ,String Egender,String Edesignation,String Esalary,String Enumber,String Eemail){
		 this.Eid = Eid ;
		 this.Ename = Ename;
		 this.Egender = Egender;
		 this.Edesignation = Edesignation;
		 this.Esalary = Esalary;
		 this.Enumber = Enumber;
		 this.Eemail = Eemail;
	 }
	public String getEid() {
		return Eid;
	}
	public String getEname() {
		return Ename;
	}
	public String getEgender() {
		return Egender;
	}
	public String getEdesignation() {
		return Edesignation;
	}
	public String getEsalary() {
		return Esalary;
	}
	public String getEnumber() {
		return Enumber;
	}
	public String getEemail() {
		return Eemail;
	}
} 
public class addemployee {

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
					addemployee window = new addemployee();
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
	public addemployee() {
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
		JLabel idLabel = new JLabel("Enter ID");
        idLabel.setFont(new Font("Times New Roman", Font.PLAIN, 21));
        idLabel.setBounds(51,72,111,34);
		frame.getContentPane().add(idLabel);
        
		 
		JTextField idField = new JTextField();
        idField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        idField.setBounds(448, 83, 420, 50);
        frame.getContentPane().add(idField);
        
        JLabel nameLabel = new JLabel("Enter Name");
        nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 21));
        nameLabel.setBounds(51,164,111,34);
		frame.getContentPane().add(nameLabel);
        
		JTextField nameField = new JTextField();
	      nameField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	      nameField.setBounds(448, 164, 420, 50);
	      frame.getContentPane().add(nameField);
	        
        JLabel genderLabel = new JLabel("Enter Gender");
        genderLabel.setFont(new Font("Times New Roman", Font.PLAIN, 21));
        genderLabel.setBounds(51,270,139,34);
		frame.getContentPane().add(genderLabel);
        
		JTextField genderField = new JTextField();
        genderField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        genderField.setBounds(452, 254, 420, 50);
        frame.getContentPane().add(genderField);
        
        JLabel designationLabel = new JLabel("Enter Designation");
        designationLabel.setFont(new Font("Times New Roman", Font.PLAIN, 21));
        designationLabel.setBounds(51, 354, 165, 34);
        frame.getContentPane().add(designationLabel);
        
        JTextField designationValue = new JTextField();
        designationValue.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        designationValue.setBounds(448, 347, 420, 50);
        frame.getContentPane().add(designationValue);
        
        JLabel salaryLabel = new JLabel("Enter Salary");
        salaryLabel.setFont(new Font("Times New Roman", Font.PLAIN, 21));
        salaryLabel.setBounds(51, 454, 165, 34);
        frame.getContentPane().add(salaryLabel);
        
        JTextField salaryValue = new JTextField();
        salaryValue.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        salaryValue.setBounds(448, 447, 420, 50);
        frame.getContentPane().add(salaryValue);
        
        JLabel phoneNumberLabel = new JLabel("Enter Phone Number");
        phoneNumberLabel.setFont(new Font("Times New Roman", Font.PLAIN, 21));
        phoneNumberLabel.setBounds(51, 552, 198, 34);
        frame.getContentPane().add(phoneNumberLabel);
        
        JLabel emailLabel = new JLabel("Enter Email");
        emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 21));
        emailLabel.setBounds(51, 630, 165, 34);
        frame.getContentPane().add(emailLabel);
        
        JTextField phonenumberValue = new JTextField();
        phonenumberValue.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        phonenumberValue.setBounds(448, 536, 420, 50);
        frame.getContentPane().add(phonenumberValue);
        
        JTextField emailValue = new JTextField();
        emailValue.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        emailValue.setBounds(448, 630, 420, 50);
        frame.getContentPane().add(emailValue);
		JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
   
  			  frame.getContentPane().setVisible(false);
          	  frame.dispose();
          	  menuscreen.main(null);
        	}
        });
        backButton.setBounds(51, 702, 232, 40);
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        frame.getContentPane().add(backButton);
        
        
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        		String Eid = idField.getText();
        		file = new File("./EmpDetails/"+Eid);
        		String Ename = nameField.getText();
        		String Egender = genderField.getText();
        		String Edesignation = designationValue.getText();
        		String Esalary = salaryValue.getText();
        		String Enumber = phonenumberValue.getText();
        		String Eemail = emailValue.getText();
        		 System.out.println(Eid);
        		 
        		al.add(new EmployeeAdd(Eid,Ename,Egender,Edesignation,Esalary,Enumber,Eemail));
        		System.out.println(al);
        		idField.setText("");
        		nameField.setText("");
        		genderField.setText("");
        		designationValue.setText("");
        		salaryValue.setText("");
        		phonenumberValue.setText("");
        		emailValue.setText("");
        		try {
        			
        			if(file.exists()) {
        				JOptionPane.showMessageDialog(null, "Employee with id "+Eid+" already exists");
        			}
        			else {
        				oos = new ObjectOutputStream(new FileOutputStream(file));
        			
        			
        			}
        			
        			oos.writeObject(al);
        			JOptionPane.showMessageDialog(null, "New Employee Data added sucessfully");
        			oos.close();
      			    
        		}
        		catch(Exception ae) {
        			ae.printStackTrace();
        		}
        	}
        });
        		
               
        saveButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        saveButton.setBounds(640, 702, 232, 40);
        frame.getContentPane().add(saveButton);
        
        JLabel AddEmployeeLabel = new JLabel("Add Employee");
        AddEmployeeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 31));
        AddEmployeeLabel.setBounds(362, 24, 198, 34);
        frame.getContentPane().add(AddEmployeeLabel);
        
	}

}
