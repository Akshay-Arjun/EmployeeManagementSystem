package JavaEmpProject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
public class viewemployee {

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
					viewemployee window = new viewemployee();
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
	public viewemployee() {
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
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().setVisible(false);
	          	  frame.dispose();
	          	  menuscreen.main(null);
			}
		});
		backButton.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		backButton.setBounds(187, 52, 109, 32);
		frame.getContentPane().add(backButton);
		JLabel idLabel = new JLabel("Enter ID");
		idLabel.setBackground(new Color(255, 255, 255));
        idLabel.setFont(new Font("Times New Roman", Font.PLAIN, 21));
        idLabel.setBounds(185,17,111,34);
		frame.getContentPane().add(idLabel);
        
		 
		JTextField idField = new JTextField();
		
		
        idField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        idField.setBounds(469, 10, 420, 50);
        frame.getContentPane().add(idField);
        
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Times New Roman", Font.PLAIN, 21));
        submitButton.setBounds(312, 53, 101, 30);
        frame.getContentPane().add(submitButton);
        submitButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String Eid = idField.getText();
        		try {
					file = new File("./EmpDetails/"+Eid);
					fin = new FileInputStream(file);
					ois = new ObjectInputStream(fin);
					
					ArrayList<EmployeeAdd> al = new ArrayList<EmployeeAdd>();
					try {
					while((al = (ArrayList)ois.readObject())!=null) {
		    			EmployeeAdd e1 = al.get(0);
		    			
		    			 JLabel idLabel = new JLabel("Employee ID");
							idLabel.setFont(new Font("Times New Roman", Font.PLAIN, 21));
						    idLabel.setBounds(51,72,111,34);
						    frame.getContentPane().add(idLabel);
						    
						    JLabel idVal = new JLabel(e1.getEid());
						    idVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
						    idVal.setBounds(448, 83, 420, 50);
						    frame.getContentPane().add(idVal);
						   
						    JLabel nameLabel = new JLabel(" Name");
						    nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 21));
						    nameLabel.setBounds(51,164,111,34);
							frame.getContentPane().add(nameLabel);
						    
							JLabel nameVal = new JLabel(e1.getEname());
						      nameVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
						      nameVal.setBounds(448, 164, 420, 50);
						      frame.getContentPane().add(nameVal);
						        
						    JLabel genderLabel = new JLabel(" Gender");
						    genderLabel.setFont(new Font("Times New Roman", Font.PLAIN, 21));
						    genderLabel.setBounds(51,270,139,34);
							frame.getContentPane().add(genderLabel);
						    
							JLabel genderVal = new JLabel(e1.getEgender());
						    genderVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
						    genderVal.setBounds(452, 254, 420, 50);
						    frame.getContentPane().add(genderVal);
						    
						    JLabel designationLabel = new JLabel("Designation");
						    designationLabel.setFont(new Font("Times New Roman", Font.PLAIN, 21));
						    designationLabel.setBounds(51, 354, 165, 34);
						    frame.getContentPane().add(designationLabel);
						    
						    JLabel designationVal = new JLabel(e1.getEdesignation());
						    designationVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
						    designationVal.setBounds(448, 347, 420, 50);
						    frame.getContentPane().add(designationVal);
						    
						    JLabel salaryLabel = new JLabel(" Salary");
						    salaryLabel.setFont(new Font("Times New Roman", Font.PLAIN, 21));
						    salaryLabel.setBounds(51, 454, 165, 34);
						    frame.getContentPane().add(salaryLabel);
						    
						    JLabel salaryVal = new JLabel(e1.getEsalary());
						    salaryVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
						    salaryVal.setBounds(448, 447, 420, 50);
						    frame.getContentPane().add(salaryVal);
						    
						    JLabel phoneNumberLabel = new JLabel(" Phone Number");
						    phoneNumberLabel.setFont(new Font("Times New Roman", Font.PLAIN, 21));
						    phoneNumberLabel.setBounds(51, 552, 198, 34);
						    frame.getContentPane().add(phoneNumberLabel);
						    
						    JLabel emailLabel = new JLabel(" Email");
						    emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 21));
						    emailLabel.setBounds(51, 630, 165, 34);
						    frame.getContentPane().add(emailLabel);
						    
						    JLabel phonenumberVal = new JLabel(e1.getEnumber());
						    phonenumberVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
						    phonenumberVal.setBounds(448, 536, 420, 50);
						    frame.getContentPane().add(phonenumberVal);
						    
						    JLabel emailVal = new JLabel(e1.getEemail());
						    emailVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
						    emailVal.setBounds(448, 630, 420, 50);
						    frame.getContentPane().add(emailVal);
						    frame.revalidate();
						    frame.repaint();
						
					}
					
					}
					
					catch(EOFException ae1) {
						ae1.printStackTrace();
					}
					fin.close();
					ois.close();
				}
		    		catch(Exception ae) {
		    			JOptionPane.showMessageDialog(null, "Employee Not Found");
		    			ae.printStackTrace();
		    			}
			
			
        	}
        	
        });
  
		
	}
}
		


