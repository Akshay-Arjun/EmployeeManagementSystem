package JavaEmpProject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
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
public class editemployee {

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
					editemployee window = new editemployee();
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
	public editemployee() {
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
		
		JLabel editLabel = new JLabel("Enter ID To Edit");
		editLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		editLabel.setBounds(107, 21, 205, 40);
		frame.getContentPane().add(editLabel);
		
		JTextField idField = new JTextField();
		idField.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		idField.setBounds(366, 17, 431, 40);
		frame.getContentPane().add(idField);
		idField.setColumns(10);
		JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
   
  			  frame.getContentPane().setVisible(false);
          	  frame.dispose();
          	  menuscreen.main(null);
        	}
        });
        backButton.setBounds(107, 717, 116, 40);
        backButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        frame.getContentPane().add(backButton);
        JButton editButton = new JButton("Edit");
        editButton.setBackground(new Color(248, 248, 255));
        editButton.addActionListener(new ActionListener() {
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
						    
						    JTextField idVal = new JTextField(e1.getEid());
						    idVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
						    idVal.setBounds(448, 83, 420, 50);
						    frame.getContentPane().add(idVal);
						   
						    JLabel nameLabel = new JLabel(" Name");
						    nameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 21));
						    nameLabel.setBounds(51,164,111,34);
							frame.getContentPane().add(nameLabel);
						    
							JTextField nameVal = new JTextField(e1.getEname());
						      nameVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
						      nameVal.setBounds(448, 164, 420, 50);
						      frame.getContentPane().add(nameVal);
						        
						    JLabel genderLabel = new JLabel(" Gender");
						    genderLabel.setFont(new Font("Times New Roman", Font.PLAIN, 21));
						    genderLabel.setBounds(51,270,139,34);
							frame.getContentPane().add(genderLabel);
						    
							JTextField genderVal = new JTextField(e1.getEgender());
						    genderVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
						    genderVal.setBounds(452, 254, 420, 50);
						    frame.getContentPane().add(genderVal);
						    
						    JLabel designationLabel = new JLabel("Designation");
						    designationLabel.setFont(new Font("Times New Roman", Font.PLAIN, 21));
						    designationLabel.setBounds(51, 354, 165, 34);
						    frame.getContentPane().add(designationLabel);
						    
						    JTextField designationVal = new JTextField(e1.getEdesignation());
						    designationVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
						    designationVal.setBounds(448, 347, 420, 50);
						    frame.getContentPane().add(designationVal);
						    
						    JLabel salaryLabel = new JLabel(" Salary");
						    salaryLabel.setFont(new Font("Times New Roman", Font.PLAIN, 21));
						    salaryLabel.setBounds(51, 454, 165, 34);
						    frame.getContentPane().add(salaryLabel);
						    
						    JTextField salaryVal = new JTextField(e1.getEsalary());
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
						    
						    JTextField phonenumberVal = new JTextField(e1.getEnumber());
						    phonenumberVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
						    phonenumberVal.setBounds(448, 536, 420, 50);
						    frame.getContentPane().add(phonenumberVal);
						    
						    JTextField emailVal = new JTextField(e1.getEemail());
						    emailVal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
						    emailVal.setBounds(448, 630, 420, 50);
						    frame.getContentPane().add(emailVal);
						    frame.revalidate();
						    frame.repaint();
						    
						    JButton btnSave = new JButton("Save");
					        btnSave.addActionListener(new ActionListener() {
					        	public void actionPerformed(ActionEvent e) {
					        		
					        		try  
					        		{         
					        			
					        			String Eid = idVal.getText();
					        		
					        			file = new File("./EmpDetails/"+Eid);
					        			
					        			     
					        		if(file.delete())                       
					        		{  
					        			//String Eid = idVal.getText();
					            		file = new File("./EmpDetails/"+Eid);
					            		String Ename = nameVal.getText();
					            		String Egender = genderVal.getText();
					            		String Edesignation = designationVal.getText();
					            		String Esalary = salaryVal.getText();
					            		String Enumber = phonenumberVal.getText();
					            		String Eemail = emailVal.getText();
					            		ArrayList<EmployeeAdd> al = new ArrayList<EmployeeAdd>();
					            		 
					            		al.add(new EmployeeAdd(Eid,Ename,Egender,Edesignation,Esalary,Enumber,Eemail));
					            		System.out.println(al);
					            		idField.setText("");
					            		idVal.setText("");
					            		nameVal.setText("");
					            		genderVal.setText("");
					            		designationVal.setText("");
					            		salaryVal.setText("");
					            		phonenumberVal.setText("");
					            		emailVal.setText("");
					        			
					        			try {
					            			
					        				oos = new ObjectOutputStream(new FileOutputStream(file));
					            			oos.writeObject(al);
					            		    oos.close();
					            		    JOptionPane.showMessageDialog(null, "Employee Is Edited"); 
					            		    
					      
					            		
					            		}
					            		catch(Exception ae) {
					            			ae.printStackTrace();
					            		}
					        			
					        		}  
					        		else  
					        		{  
					        			JOptionPane.showMessageDialog(null, "Employee Not Edited Successfully");
					        		}
					        		
					        		}  
					        		catch(Exception ae)  
					        		{  
					        		ae.printStackTrace();  
					        		} 
					        		
					        	}
					        });
					        btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 20));
					        btnSave.setBounds(815, 717, 116, 40);
					        frame.getContentPane().add(btnSave);
						
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
        editButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        editButton.setBounds(832, 17, 99, 40);
        frame.getContentPane().add(editButton);
        
        
	}

}
