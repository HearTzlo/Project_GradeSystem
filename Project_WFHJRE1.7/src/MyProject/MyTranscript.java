package MyProject;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.engine.util.ClassUtils;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MyTranscript extends JFrame {
	
	private JTextField txtStudentCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				MyTranscript frame = new MyTranscript();
				frame.setVisible(true);
			}
		});
	}
 JLabel lblNewLabel_5;
 JMenuItem mntmNewMenuItem_1,mntmNewMenuItem,mntmNewMenuItem_2; 
	/**
	 * Create the frame.
	 */
	public MyTranscript() {
		getContentPane().setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,2000,1000);
		setLocation(50, 0);
		setTitle("Print Transcript");
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("หน้าหลัก");
		btnNewButton.setFont(new Font("Angsana New", Font.BOLD, 28));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
        		String un = lblNewLabel_5.getText();
        		AdminAnnoucmentPage mainmenu = new AdminAnnoucmentPage();
				mainmenu.AdminAnnoucmentPage(un);	
				mainmenu.setVisible(true);						
				dispose();
        	}
        });
		 
		 JLabel lblNewLabel_7 = new JLabel("Khon Kaen Univesity");
		 lblNewLabel_7.setForeground(Color.WHITE);
		 lblNewLabel_7.setFont(new Font("Angsana New", Font.BOLD, 30));
		 lblNewLabel_7.setBounds(191, 42, 196, 28);
		 getContentPane().add(lblNewLabel_7);
		 
		 JLabel lblNewLabel_6 = new JLabel("มหาวิทยาลัยขอนแก่น");
		 lblNewLabel_6.setForeground(Color.WHITE);
		 lblNewLabel_6.setFont(new Font("Angsana New", Font.BOLD, 30));
		 lblNewLabel_6.setBounds(191, 0, 215, 32);
		 getContentPane().add(lblNewLabel_6);
		
		 lblNewLabel_5 = new JLabel("New label");
		 lblNewLabel_5.setForeground(Color.WHITE);
		 lblNewLabel_5.setFont(new Font("Angsana New", Font.BOLD, 32));
		 lblNewLabel_5.setBounds(1429, 31, 267, 32);
		 getContentPane().add(lblNewLabel_5);
		btnNewButton.setBounds(20, 235, 132, 36);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("จัดพิมพ์เอกสารผลการศึกษา");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Angsana New", Font.BOLD, 40));
		lblNewLabel_4.setBounds(936, 22, 402, 46);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel(new ImageIcon(getClass().getResource("pic14.GIF")));
		lblNewLabel_3.setBounds(34, 24, 101, 153);
		getContentPane().add(lblNewLabel_3);
		
		// Label Country Code
		JLabel lblCountryCode = new JLabel("รหัสนักศึกษา");
		lblCountryCode.setFont(new Font("Angsana New", Font.BOLD, 40));
		lblCountryCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblCountryCode.setBounds(958, 227, 229, 36);
		getContentPane().add(lblCountryCode);
		
		// Text Field CountryCode
		txtStudentCode = new JTextField();
		txtStudentCode.setFont(new Font("Angsana New", Font.BOLD, 38));
		txtStudentCode.setHorizontalAlignment(SwingConstants.CENTER);
		txtStudentCode.setBounds(934, 332, 391, 58);
		getContentPane().add(txtStudentCode);
		txtStudentCode.setColumns(10);
		setResizable (false);
		
		// Button Report
		JButton btnOpenReport = new JButton("แสดงผลการเรียน");
		btnOpenReport.setFont(new Font("Angsana New", Font.BOLD, 40));
		btnOpenReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Connection connect = null;
				
				try {
					Class.forName("com.mysql.jdbc.Driver");

					connect =  DriverManager.getConnection("jdbc:mysql://localhost/project_gradesystem" +
							"?user=root&password=");	
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// Application path
				String report = null;
				try {
					report = new File(".").getCanonicalPath()+ "\\Source2\\Grade.jrxml";
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					
					// Parameters
					Map<String, Object> param = new HashMap<String, Object>();
					param.put("sStd_Code", txtStudentCode.getText());
					
					// Report Viewer
					JasperReport ir = JasperCompileManager.compileReport(report);
					JasperPrint ip = JasperFillManager.fillReport(ir, param,connect);
					
					JFrame frame = new JFrame();
					frame.setTitle("Grade Report");
					frame.setBounds(100, 100, 800,600);
					frame.getContentPane().add(new JRViewer(ip));
					frame.setVisible(true);
					
				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					connect.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		btnOpenReport.setBounds(980, 452, 267, 67);
		getContentPane().add(btnOpenReport);
		
		JLabel lblNewLabel = new JLabel("\u0E01\u0E23\u0E38\u0E13\u0E32\u0E43\u0E2A\u0E48\u0E23\u0E2B\u0E31\u0E2A\u0E19\u0E31\u0E01\u0E28\u0E36\u0E01\u0E29\u0E32");
		lblNewLabel.setFont(new Font("Angsana New", Font.BOLD, 40));
		lblNewLabel.setBounds(652, 329, 259, 45);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("ออกจากระบบ");
		btnNewButton_3.setFont(new Font("Angsana New", Font.BOLD, 28));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				dispose();
			}
		});
		btnNewButton_3.setBounds(10, 798, 142, 46);
		getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon(getClass().getResource("pic9 (1) (1).gif")));
		lblNewLabel_1.setBounds(0, 0, 191, 1007);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(new ImageIcon(getClass().getResource("pic8 (1) (1).gif")));
		lblNewLabel_2.setBounds(191, 0, 1790, 88);
		getContentPane().add(lblNewLabel_2);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(188, 89, 1997, 36);
		getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("รายวิชา");
		mnNewMenu.setFont(new Font("Angsana New", Font.BOLD, 34));
		menuBar.add(mnNewMenu);
		
		 mntmNewMenuItem = new JMenuItem("เพิ่มวิชา");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un = lblNewLabel_5.getText();
				AddSubjectPage addsub = new AddSubjectPage();
				addsub.AddSubjectPage(un);
				addsub.setVisible(true);
				dispose();
			}
		});
		mntmNewMenuItem.setFont(new Font("Angsana New", Font.PLAIN, 30));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("ผลการเรียน");
		mnNewMenu_1.setFont(new Font("Angsana New", Font.BOLD, 34));
		menuBar.add(mnNewMenu_1);
		
		 mntmNewMenuItem_1 = new JMenuItem("เพิ่มผลการเรียน");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un = lblNewLabel_5.getText();
				AddStudentGradePage addgrade = new AddStudentGradePage();
				addgrade.AddStudentGradePage(un);
				addgrade.setVisible(true);						
				dispose();	
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Angsana New", Font.PLAIN, 30));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("รายงาน");
		mnNewMenu_2.setFont(new Font("Angsana New", Font.BOLD, 34));
		menuBar.add(mnNewMenu_2);
		
		 mntmNewMenuItem_2 = new JMenuItem("ใบันทึกผลการเรียน");
		 mntmNewMenuItem_2.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
					String un = lblNewLabel_5.getText();
					MyTranscript trans = new MyTranscript();
					trans.MyTranscript(un);
					trans.setVisible(true);
					dispose();
				}
			});
		mntmNewMenuItem_2.setFont(new Font("Angsana New", Font.PLAIN, 30));
		
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JLabel label = new JLabel("New label");
		label.setBounds(191, 10, 45, 13);
		getContentPane().add(label);
		
	}

	public void MyTranscript(String un) {
		// TODO Auto-generated method stub
		lblNewLabel_5.setText(un);
		
	}
}
