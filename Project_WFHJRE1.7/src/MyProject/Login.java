package MyProject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import org.jdom.Parent;
public class Login {
	private JFrame loginframe;
	private JTextField Username;
	private JPasswordField Password;
	Connection conn,con,connect;
	PreparedStatement pre,pre2,pre3;
	ResultSet rs;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.loginframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		loginframe = new JFrame();
		loginframe.getContentPane().setFont(new Font("TH SarabunPSK", Font.PLAIN, 18));
		loginframe.getContentPane().setBackground(Color.LIGHT_GRAY);
		loginframe.getContentPane().setForeground(Color.WHITE);
		loginframe.setFont(new Font("Dialog", Font.PLAIN, 18));
		loginframe.setTitle("Login Page");
		loginframe.setBounds(0, 0, 2000, 1000);
		loginframe.setLocation(0, 0);
		loginframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel TextUsername = new JLabel("ชื่อผู้ใช้");
		TextUsername.setFont(new Font("Angsana New", Font.BOLD, 34));
		JLabel TextPassword = new JLabel("รหัสผ่าน");
		TextPassword.setFont(new Font("Angsana New", Font.BOLD, 34));
		JLabel TextTranscript = new JLabel("KKU Login");
		TextTranscript.setFont(new Font("Angsana New", Font.BOLD, 40));
		JLabel TextLogin = new JLabel("Reg KKU");
		TextLogin.setVerticalAlignment(SwingConstants.BOTTOM);
		TextLogin.setFont(new Font("Angsana New", Font.BOLD, 40));
		Username = new JTextField();
		Username.setFont(new Font("Angsana New", Font.PLAIN, 33));
		Username.setForeground(new Color(0, 0, 0));
		Username.setColumns(10);
		Password = new JPasswordField();
		Password.setFont(new Font("Angsana New", Font.PLAIN, 33));
		loginframe.getContentPane().add(Password);
		//Login button
		JButton LoginButton = new JButton("เข้าสู่ระบบ");
		LoginButton.setForeground(Color.WHITE);
		LoginButton.setFont(new Font("Angsana New", Font.BOLD, 34));
		LoginButton.setBackground(new Color(204, 51, 0));
		//Radio button1
		final JRadioButton StdChoice = new JRadioButton("นักศึกษา");
		StdChoice.setBackground(Color.LIGHT_GRAY);
		StdChoice.setFont(new Font("Angsana New", Font.BOLD, 34));
		StdChoice.setHorizontalAlignment(SwingConstants.LEFT);
		//Radio button2
		final JRadioButton AdminChoice = new JRadioButton("เจ้าหน้าที่");
		AdminChoice.setFont(new Font("Angsana New", Font.BOLD, 34));
		AdminChoice.setBackground(Color.LIGHT_GRAY);
		final JRadioButton ParentChoice = new JRadioButton("ผู้ปกครอง");
		ParentChoice.setBackground(Color.LIGHT_GRAY);
		ParentChoice.setFont(new Font("Angsana New", Font.BOLD, 34));
		

		ButtonGroup group = new ButtonGroup();
		group.add(StdChoice);
		group.add(AdminChoice);
		group.add(ParentChoice);
		LoginButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String uname = Username.getText();
				String pword = Password.getText();
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					connect =  DriverManager.getConnection("jdbc:mysql://localhost/project_gradesystem" +
							"?user=root&password=");
					String sql = " SELECT * FROM  student " +
							" WHERE Std_Code = ? " +
							" AND Std_ID = ? ";
					String sql2 = "SELECT parent.Pr_ID,Pr_name,Pr_NameTitle,Pr_surname,Pr_pass,student.std_Code FROM  parent,student "
							+" WHERE (Parent.Pr_ID = Student.Pr_ID)"
							+ "And Parent.Pr_ID= ? " 
							+ "AND Pr_Pass = ? ";
					String sql3 = " SELECT * FROM  admin " +
							" WHERE ad_Code = ? " +
							" AND ad_ID = ? ";
					pre = connect.prepareStatement(sql) ;
				
					pre2 = connect.prepareStatement(sql2);
					
					pre3 = connect.prepareStatement(sql3);
					
					pre.setString(1, uname);
					pre.setString(2, pword);
					pre2.setString(1, uname);
					pre2.setString(2, pword);
					pre3.setString(1, uname);
					pre3.setString(2, pword);
					ResultSet rec = pre.executeQuery();
					ResultSet rec2 = pre2.executeQuery();
					ResultSet rec3 = pre3.executeQuery();
					
				
					if(rec.next() && StdChoice.isSelected()) {
						String un = Username.getText();
						String stdn = rec.getString("std_code");
						String name = rec.getString("Std_Tname");
						String surname = rec.getString("Std_Tsurname");
						JOptionPane.showMessageDialog(null, "Student Login Successfully");
						AnnoucmentPage std = new AnnoucmentPage();
						std.AnnoucmentPage(un,stdn,name, surname);
						std.setVisible(true);						
						loginframe.dispose();
						
					}else if(rec2.next() && ParentChoice.isSelected()) {	
						String un = Username.getText();
						String stdn = rec2.getString("student.std_code");
						String name = rec2.getString("Pr_name");
						String surname = rec2.getString("Pr_surname");
						JOptionPane.showMessageDialog(null, "Parent Login Successfully");
						AnnoucmentPage std = new AnnoucmentPage();
						std.AnnoucmentPage(un,stdn,name, surname);		
						std.setVisible(true);
						loginframe.dispose();
					}else if(rec3.next() && AdminChoice.isSelected()) {	
						String un = Username.getText();
						String name = rec3.getString("Ad_name");
						String surname = rec3.getString("Ad_surname");
						JOptionPane.showMessageDialog(null, "Admin Login Successfully");
						AdminAnnoucmentPage ad = new AdminAnnoucmentPage();
						ad.AdminAnnoucmentPage(un,name,surname);
						ad.setVisible(true);
						loginframe.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Username and Password are Incorrect");
						}
					}
					
					catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage());
						e1.printStackTrace();
					}
					
					try {
						if(pre != null) {
							pre.close();
							
						}else if(pre2 != null) {
							pre2.close();
							connect.close();
						}else if(pre3 != null) {
							pre3.close();
							connect.close();
						}
					} catch (SQLException ex) {
						// TODO Auto-generated catch block
						System.out.println(ex.getMessage());
						ex.printStackTrace();
					}
					}
		});
		GroupLayout groupLayout = new GroupLayout(loginframe.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(827)
					.addComponent(TextTranscript, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(827)
					.addComponent(TextLogin))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(826)
					.addComponent(StdChoice))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(826)
					.addComponent(ParentChoice))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(826)
					.addComponent(AdminChoice))
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(558)
						.addComponent(TextUsername)
						.addGap(74)
						.addComponent(Username))
					.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
						.addGap(558)
						.addComponent(TextPassword)
						.addGap(54)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(LoginButton, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addComponent(Password))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(68)
					.addComponent(TextTranscript, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(TextLogin)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(78)
							.addComponent(TextUsername, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(67)
							.addComponent(Username, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(42)
							.addComponent(TextPassword))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(Password, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)))
					.addGap(53)
					.addComponent(StdChoice)
					.addGap(18)
					.addComponent(ParentChoice)
					.addGap(18)
					.addComponent(AdminChoice)
					.addGap(29)
					.addComponent(LoginButton, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(152))
		);
		loginframe.getContentPane().setLayout(groupLayout);
	}
}