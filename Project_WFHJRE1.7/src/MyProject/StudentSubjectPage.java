package MyProject;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import net.proteanit.sql.DbUtils;
import javax.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class StudentSubjectPage extends JFrame {

	/**
	 * 
	 */

	/**
	 * 
	 */
	/**
	 * 
	 */
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				StudentSubjectPage frame = new StudentSubjectPage();
				frame.setVisible(true);
			}
		});
	}
	Connection con, conn;
    Statement st;
    PreparedStatement pst;
    ResultSet rs, rs1;
    private JTable table;
    public TextField Subject_ID,Subject_Name,Subject_Descrip,SubCredit;
	JLabel label,label3,label2,label4;
	JMenuItem mntmNewMenuItem,mntmNewMenuItem_1;
	private JTextField textSubject;
	

    /**
	 * Create the frame.
	 */
    
    public void ClearField() {
    	Subject_ID.setText(null);
    	Subject_Name.setText(null);
    	Subject_Descrip.setText(null);
    	SubCredit.setText(null);
    	
    }

    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width +1 , width);
            }
            if(width > 300)
                width=300;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
	
	public void StudentSubjectPage(String un,String stdn,String name,String surname) {
		// TODO Auto-generated constructor stub
		label.setText(un);
		label3.setText(stdn);
		label2.setText(name);
		label4.setText(surname);
	}
	public StudentSubjectPage() {
		getContentPane().setFont(new Font("Angsana New", Font.BOLD, 34));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,2000,1000);
		
		setTitle("Subject");
		getContentPane().setLayout(null);
		
		JButton s = new JButton("หน้าหลัก");
		s.setFont(new Font("Angsana New", Font.BOLD, 28));
		s.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un = label.getText();
				String stdn = label3.getText();
				String name = label2.getText();
				String surname = label4.getText();
				AnnoucmentPage mainmenu = new AnnoucmentPage();
				mainmenu.AnnoucmentPage(un,stdn,name,surname);	
				mainmenu.setVisible(true);						
				dispose();
			}
		});
		
		JLabel lblNewLabel_11 = new JLabel("Khon Kaen University");
		lblNewLabel_11.setForeground(Color.WHITE);
		lblNewLabel_11.setFont(new Font("Angsana New", Font.BOLD, 30));
		lblNewLabel_11.setBounds(159, 36, 215, 30);
		getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_10 = new JLabel("มหาวิทยาลัยขอนแก่น");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setFont(new Font("Angsana New", Font.BOLD, 30));
		lblNewLabel_10.setBounds(156, 10, 218, 30);
		getContentPane().add(lblNewLabel_10);
		s.setBounds(10, 203, 137, 30);
		getContentPane().add(s);
		
		JLabel lblNewLabel_7 = new JLabel(new ImageIcon(getClass().getResource("pic14.GIF")));
		lblNewLabel_7.setBounds(34, 10, 96, 168);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel = new JLabel("แสดงข้อมูลรายวิชา");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Angsana New", Font.BOLD, 40));
		lblNewLabel.setBounds(1007, 27, 216, 42);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("รหัสวิชา");
		lblNewLabel_1.setFont(new Font("Angsana New", Font.BOLD, 34));
		lblNewLabel_1.setBounds(414, 282, 93, 26);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ชื่อวิชา");
		lblNewLabel_2.setFont(new Font("Angsana New", Font.BOLD, 34));
		lblNewLabel_2.setBounds(700, 280, 86, 30);
		getContentPane().add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(311, 465, 1268, 447);
		
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(table.getRowHeight() + 20);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		table.setFont(new Font("Angsana New",Font.BOLD,26));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String Selection= table.getModel().getValueAt(row, 0).toString();
				try {
					Class.forName("com.mysql.jdbc.Driver");
	                conn = DriverManager.getConnection("jdbc:mysql://localhost/project_gradesystem" +
	    					"?user=root&password=");
					String query="Select * from Subject where Sub_ID= '"+Selection+"'" ;		
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					if(rs.next()) {
						Subject_ID.setText(rs.getString("Sub_ID"));
						Subject_Name.setText(rs.getString("Sub_Name"));
						SubCredit.setText(rs.getString("Sub_Credit"));
						Subject_Descrip.setText(rs.getString("Sub_Description"));
					}
					
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
					
				}
				
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_5 = new JLabel("หน่วยกิต");
		lblNewLabel_5.setFont(new Font("Angsana New", Font.BOLD, 34));
		lblNewLabel_5.setBounds(414, 354, 89, 30);
		getContentPane().add(lblNewLabel_5);
		
		Subject_ID = new TextField();
		Subject_ID.setFont(new Font("Angsana New", Font.BOLD, 28));
		Subject_ID.setBounds(527, 266, 137, 42);
		getContentPane().add(Subject_ID);
		
		 Subject_Name = new TextField();
		 Subject_Name.setFont(new Font("Angsana New", Font.BOLD, 28));
		Subject_Name.setBounds(792, 268, 738, 42);
		getContentPane().add(Subject_Name);
		
		 Subject_Descrip = new TextField();
		 Subject_Descrip.setFont(new Font("Angsana New", Font.BOLD, 28));
		Subject_Descrip.setBounds(792, 348, 738, 36);
		getContentPane().add(Subject_Descrip);
		
		 SubCredit = new TextField();
		 SubCredit.setFont(new Font("Angsana New", Font.BOLD, 28));
		SubCredit.setBounds(527, 348, 137, 36);
		getContentPane().add(SubCredit);
		
		JLabel lblNewLabel_3 = new JLabel("คำอธิบาย");
		lblNewLabel_3.setFont(new Font("Angsana New", Font.BOLD, 34));
		lblNewLabel_3.setBounds(688, 361, 98, 23);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_3 = new JButton("ออกจากระบบ");
		btnNewButton_3.setFont(new Font("Angsana New", Font.BOLD, 28));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				dispose();
			}
		});
		btnNewButton_3.setBounds(0, 809, 151, 30);
		getContentPane().add(btnNewButton_3);
		
		label = new JLabel("New label");
		label.setFont(new Font("Angsana New", Font.BOLD, 34));
		label.setBounds(612, 148, 238, 30);
		getContentPane().add(label);
		
		JLabel lblNewLabel_4 = new JLabel(new ImageIcon(getClass().getResource("pic9 (1) (1).gif")));
		lblNewLabel_4.setBounds(0, 0, 161, 998);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel(new ImageIcon(getClass().getResource("pic9 (1) (1).gif")));
		lblNewLabel_6.setBounds(156, 0, 1890, 76);
		getContentPane().add(lblNewLabel_6);
		
		 label3 = new JLabel("New label");
		 label3.setBounds(64, 392, 22, 21);
		 getContentPane().add(label3);
		 label3.setFont(new Font("Angsana New", Font.BOLD, 20));
		 
		 JLabel lblNewLabel_8 = new JLabel("รหัสผู้ใช้");
		 lblNewLabel_8.setFont(new Font("Angsana New", Font.BOLD, 34));
		 lblNewLabel_8.setBounds(418, 157, 89, 21);
		 getContentPane().add(lblNewLabel_8);
		 
		 JLabel lblNewLabel_9 = new JLabel("ชื่อ-สกุล");
		 lblNewLabel_9.setFont(new Font("Angsana New", Font.BOLD, 34));
		 lblNewLabel_9.setBounds(421, 204, 86, 25);
		 getContentPane().add(lblNewLabel_9);
		 
		  label2 = new JLabel("New label");
		  label2.setFont(new Font("Angsana New", Font.BOLD, 34));
		 label2.setBounds(612, 203, 181, 30);
		 getContentPane().add(label2);
		 
		  label4 = new JLabel("New label");
		  label4.setFont(new Font("Angsana New", Font.BOLD, 34));
		 label4.setBounds(867, 207, 176, 26);
		 getContentPane().add(label4);
		 
		 JMenuBar menuBar = new JMenuBar();
		 menuBar.setFont(new Font("Angsana New", Font.PLAIN, 20));
		 menuBar.setBounds(159, 78, 1768, 42);
		 getContentPane().add(menuBar);
		 
		 JMenu mnNewMenu = new JMenu("รายวิชา");
		 mnNewMenu.setFont(new Font("Angsana New", Font.BOLD, 34));
		 menuBar.add(mnNewMenu);
		 
		  mntmNewMenuItem = new JMenuItem("แสดงผลรายวิชา");
		 mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String un = label.getText();
					String stdn = label3.getText();
					String name = label2.getText();
					String surname = label4.getText();
					StudentSubjectPage stdsub = new StudentSubjectPage();
					stdsub.StudentSubjectPage(un,stdn,name,surname);
					stdsub.setVisible(true);						
					dispose();	
				}
			});
			 
		 
		 mntmNewMenuItem.setFont(new Font("Angsana New", Font.PLAIN, 30));
		 mnNewMenu.add(mntmNewMenuItem);
		 
		 JMenu mnNewMenu_1 = new JMenu("ผลการเรียน");
		 mnNewMenu_1.setFont(new Font("Angsana New", Font.BOLD, 34));
		 menuBar.add(mnNewMenu_1);
		 
		  mntmNewMenuItem_1 = new JMenuItem("แสดงผลการเรียน");
			 mntmNewMenuItem_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String un = label.getText();
						String stdn = label3.getText();
						String name = label2.getText();
						String surname = label4.getText();
						StudentGradePage grade = new StudentGradePage();
						grade.StudentGradePage(un,stdn,name,surname);
						grade.setVisible(true);						
						dispose();
						
					}
				});
		 mntmNewMenuItem_1.setFont(new Font("Angsana New", Font.PLAIN, 30));
		 mnNewMenu_1.add(mntmNewMenuItem_1);
		 
		 JLabel lblNewLabel_12 = new JLabel("ค้นหารายวิชา");
		 lblNewLabel_12.setFont(new Font("Angsana New", Font.BOLD, 34));
		 lblNewLabel_12.setBounds(414, 410, 129, 30);
		 getContentPane().add(lblNewLabel_12);
		 
		 textSubject = new JTextField();
		 textSubject.setFont(new Font("Angsana New", Font.BOLD, 28));
		 textSubject.setBounds(553, 405, 216, 36);
		 getContentPane().add(textSubject);
		 textSubject.setColumns(10);
		 
		 JButton btnNewButton_1 = new JButton("ค้นหา");
		 btnNewButton_1.setFont(new Font("Angsana New", Font.BOLD, 34));
		 btnNewButton_1.setBounds(792, 406, 96, 36);
		 getContentPane().add(btnNewButton_1);
		 
		 JButton btnNewButton = new JButton("แสดงรายวิชาทั้งหมด");
		 btnNewButton.setFont(new Font("Angsana New", Font.BOLD, 34));
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		try {
					Class.forName("com.mysql.jdbc.Driver");
		            conn = DriverManager.getConnection("jdbc:mysql://localhost/project_gradesystem" +
							"?user=root&password=");
					String query="Select Sub_ID as รหัสวิชา , Sub_name as ชื่อวิชา , Sub_Credit as หน่วยกิต ,Sub_Description as รายละเอียด from Subject ";			
					PreparedStatement pst = conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					resizeColumnWidth(table);
				}catch (Exception e1) {
					e1.printStackTrace();
					
				}
				
				
			}
		});
		
		 btnNewButton.setBounds(971, 390, 251, 52);
		 getContentPane().add(btnNewButton);
		 btnNewButton_1.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
			try {
   			 Class.forName("com.mysql.jdbc.Driver");
   	            con = DriverManager.getConnection("jdbc:mysql://localhost/project_gradesystem" +
   						"?user=root&password=");
   	         String query="Select Sub_ID as รหัสวิชา , Sub_name as ชื่อวิชา , Sub_Credit as หน่วยกิต ,Sub_Description as รายละเอียด from Subject where sub_id=?";
   			 PreparedStatement pst = con.prepareStatement(query);
   			 pst.setString(1, textSubject.getText());
   			 ResultSet rs1 = pst.executeQuery();
   			 
   			 table.setModel(DbUtils.resultSetToTableModel(rs1));
   		}catch(Exception ex) {
   			ex.printStackTrace();
   		}
		}
	});
	}
}
