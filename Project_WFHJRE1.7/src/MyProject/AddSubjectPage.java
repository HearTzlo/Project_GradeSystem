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
import javax.swing.Icon;
import java.awt.Color;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JList;
import java.awt.List;
import java.awt.Choice;
import java.awt.Label;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingConstants;

public class AddSubjectPage extends JFrame {

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
				AddSubjectPage frame = new AddSubjectPage();
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
    private JTextField textSubject;
    JLabel label8;
	/**
	 * Create the frame.
	 */
	public  void AddSubjectPage(String un) {
		label8.setText(un);
		
		
	}

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
	public void refreshTable()
	{
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
	
	 
	public AddSubjectPage() {
		getContentPane().setFont(new Font("Angsana New", Font.BOLD, 30));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 2000, 1000);
		setTitle("Subject");
		getContentPane().setLayout(null);
		 
		 JButton btnNewButton_1 = new JButton("หน้าหลัก");
		 btnNewButton_1.setFont(new Font("Angsana New", Font.BOLD, 28));
		 btnNewButton_1.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
	        		String un = label8.getText();
	        		AdminAnnoucmentPage mainmenu = new AdminAnnoucmentPage();
					mainmenu.AdminAnnoucmentPage(un);	
					mainmenu.setVisible(true);						
					dispose();
	        	}
	        });
		 
		 JLabel lblNewLabel_10 = new JLabel("รหัสผู้ใช้งาน");
		 lblNewLabel_10.setForeground(Color.WHITE);
		 lblNewLabel_10.setFont(new Font("Angsana New", Font.BOLD, 34));
		 lblNewLabel_10.setBounds(1286, 30, 126, 38);
		 getContentPane().add(lblNewLabel_10);
		 btnNewButton_1.setBounds(10, 220, 163, 37);
		 getContentPane().add(btnNewButton_1);
		
		 label8 = new JLabel("New label");
		 label8.setForeground(Color.WHITE);
		 label8.setFont(new Font("Angsana New", Font.BOLD, 32));
		 label8.setBounds(1422, 26, 140, 42);
		 getContentPane().add(label8);
		
	
		
		JLabel lblNewLabel_9 = new JLabel("Khon Kaen University");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("Angsana New", Font.BOLD, 30));
		lblNewLabel_9.setBounds(199, 30, 263, 27);
		getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_8 = new JLabel("มหาวิทยาลัยขอนแก่น");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Angsana New", Font.BOLD, 30));
		lblNewLabel_8.setBounds(199, -1, 216, 27);
		getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_7 =  new JLabel(new ImageIcon(getClass().getResource("pic14.GIF")));
		lblNewLabel_7.setBounds(40, 10, 114, 157);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel = new JLabel("หน้ารายวิชา");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Angsana New", Font.BOLD, 40));
		lblNewLabel.setBounds(989, 23, 216, 42);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("รหัสวิชา");
		lblNewLabel_1.setFont(new Font("Angsana New", Font.BOLD, 35));
		lblNewLabel_1.setBounds(459, 241, 95, 37);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ชื่อวิชา");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Angsana New", Font.BOLD, 35));
		lblNewLabel_2.setBounds(783, 241, 114, 37);
		getContentPane().add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(420, 481, 1289, 466);
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
					String query="Select * from Subject where Sub_ID='"+Selection+"'";		
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
		lblNewLabel_5.setFont(new Font("Angsana New", Font.BOLD, 35));
		lblNewLabel_5.setBounds(459, 313, 107, 32);
		getContentPane().add(lblNewLabel_5);
		
		Subject_ID = new TextField();
		Subject_ID.setFont(new Font("Angsana New", Font.BOLD, 28));
		Subject_ID.setBounds(572, 236, 222, 42);
		getContentPane().add(Subject_ID);
		
		 Subject_Name = new TextField();
		 lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		 Subject_Name.setFont(new Font("Angsana New", Font.PLAIN, 28));
		Subject_Name.setBounds(900, 236, 738, 42);
		getContentPane().add(Subject_Name);
		
		 Subject_Descrip = new TextField();
		 Subject_Descrip.setFont(new Font("Angsana New", Font.PLAIN, 28));
		Subject_Descrip.setBounds(903, 308, 735, 37);
		getContentPane().add(Subject_Descrip);
		
		 SubCredit = new TextField();
		 SubCredit.setFont(new Font("Angsana New", Font.PLAIN, 28));
		SubCredit.setBounds(575, 308, 95, 37);
		getContentPane().add(SubCredit);
		
		JLabel lblNewLabel_3 = new JLabel("คำอธิบาย");
		lblNewLabel_3.setFont(new Font("Angsana New", Font.BOLD, 35));
		lblNewLabel_3.setBounds(802, 308, 95, 27);
		getContentPane().add(lblNewLabel_3);
		
		JButton Save = new JButton("Insert");
		Save.setFont(new Font("Angsana New", Font.BOLD, 35));
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(null, "ต้องการเพิ่มข้อมูลใช่หรือไม่?","เพิ่มข้อมูล",JOptionPane.YES_NO_OPTION);
				if(response==0) {
				try {
				Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost/project_gradesystem" +
    					"?user=root&password=");
                
				String query="INSERT INTO `subject` "
						+ "(Sub_ID, Sub_Name, Sub_Credit, Sub_Description)"
						+ " VALUES (?, ?, ?, ?);";			
				PreparedStatement pst = conn.prepareStatement(query);
				
				pst.setString(1,Subject_ID.getText());
				pst.setString(2,Subject_Name.getText());
				pst.setString(3,SubCredit.getText());
				pst.setString(4,Subject_Descrip.getText());
				pst.execute();
				JOptionPane.showMessageDialog(null, "Inserted Succesfully");
				pst.close();
				}catch(Exception e1) {
					e1.printStackTrace();	
					JOptionPane.showMessageDialog(null, e1);
				}
				refreshTable();
				ClearField();
				resizeColumnWidth(table);
				}
			}
		});
		Save.setBounds(480, 434, 107, 37);
		getContentPane().add(Save);
		
		JButton Update = new JButton("Update");
		Update.setFont(new Font("Angsana New", Font.BOLD, 35));
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(null, "ต้องการอัพเดตข้อมูลใช่หรือไม่?","อัพเดตข้อมูล",JOptionPane.YES_NO_OPTION);
				if(response==0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
	                conn = DriverManager.getConnection("jdbc:mysql://localhost/project_gradesystem" +
	    					"?user=root&password=");
	                
					String query="Update Subject set Sub_ID='"+Subject_ID.getText()+"'"
							+ ",Sub_Name='"+Subject_Name.getText()+"'"
							+ ",Sub_Credit='"+SubCredit.getText()+"'"
							+ ",Sub_Description='"+Subject_Descrip.getText()+"' "
							+ "where Sub_ID='"+Subject_ID.getText()+"' ";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Updated Succesfully");
					pst.close();
					}catch(Exception e1) {
						e1.printStackTrace();	
						JOptionPane.showMessageDialog(null, e1);
					}
					refreshTable();	
					ClearField();
					resizeColumnWidth(table);
			}
				}
		});
		Update.setBounds(783, 434, 114, 37);
		getContentPane().add(Update);
		
		JButton Delete = new JButton("Delete");
		Delete.setFont(new Font("Angsana New", Font.BOLD, 35));
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(null, "ต้องการลบข้อมูลใช่หรือไม่?","ลบข้อมูล",JOptionPane.YES_NO_OPTION);
				if(response==0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
	                conn = DriverManager.getConnection("jdbc:mysql://localhost/project_gradesystem" +
	    					"?user=root&password=");
	                
					String query="Delete from Subject where Sub_ID='"+Subject_ID.getText()+"' ";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Deleted Succesfully");
					pst.close();
					}catch(Exception e1) {
						e1.printStackTrace();	
						JOptionPane.showMessageDialog(null, e1);
					}
				refreshTable();
				ClearField();
				resizeColumnWidth(table);
				}
			}
		});
		Delete.setBounds(1084, 434, 100, 37);
		getContentPane().add(Delete);
		
		JButton btnNewButton_3 = new JButton("ออกจากระบบ");
		btnNewButton_3.setFont(new Font("Angsana New", Font.BOLD, 28));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				dispose();
			}
		});
		btnNewButton_3.setBounds(10, 798, 165, 37);
		getContentPane().add(btnNewButton_3);
	
		JLabel lblNewLabel_4 = new JLabel(new ImageIcon(getClass().getResource("pic9 (1) (1).gif")));
		lblNewLabel_4.setBounds(-3, 0, 201, 1309);
		getContentPane().add(lblNewLabel_4);
		
		JLabel label = new JLabel(new ImageIcon(getClass().getResource("pic8 (1) (1).gif")));
		label.setBounds(187, 0, 1730, 90);
		getContentPane().add(label);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Angsana New", Font.BOLD, 30));
		menuBar.setBounds(197, 89, 1738, 51);
		getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("รายวิชา");
		mnNewMenu.setFont(new Font("Angsana New", Font.BOLD, 34));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("เพิ่มรายวิชา");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un = label8.getText();
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
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("เพิ่มผลการเรียน");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un = label8.getText();
				AddStudentGradePage addgrade = new AddStudentGradePage();
				addgrade.AddStudentGradePage(un);
				addgrade.setVisible(true);						
				dispose();	
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Angsana New", Font.PLAIN, 30));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("รายงาน");
		mnNewMenu_2.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu_2.setFont(new Font("Angsana New", Font.BOLD, 34));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("ใบบันทึกผลการเรียน");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un = label8.getText();
				MyTranscript trans = new MyTranscript();
				trans.MyTranscript(un);
				trans.setVisible(true);
				dispose();
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Angsana New", Font.PLAIN, 30));
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JLabel lblNewLabel_6 = new JLabel("ค้นหารายวิชา");
		lblNewLabel_6.setFont(new Font("Angsana New", Font.BOLD, 34));
		lblNewLabel_6.setBounds(459, 376, 153, 37);
		getContentPane().add(lblNewLabel_6);
		
		textSubject = new JTextField();
		textSubject.setFont(new Font("Angsana New", Font.BOLD, 28));
		textSubject.setBounds(622, 369, 297, 42);
		textSubject.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(textSubject);
		textSubject.setColumns(10);
		
		JButton btnNewButton = new JButton("ค้นหา");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
       			 Class.forName("com.mysql.jdbc.Driver");
       	            con = DriverManager.getConnection("jdbc:mysql://localhost/project_gradesystem" +
       						"?user=root&password=");
       	         String query="Select Sub_ID as รหัสวิชา , Sub_name as ชื่อวิชา , Sub_Credit as หน่วยกิต ,Sub_Description as รายละเอียด from Subject where sub_id= ? ";
       			 PreparedStatement pst = con.prepareStatement(query);
       			 pst.setString(1, textSubject.getText()); 
       			 ResultSet rs1 = pst.executeQuery();
       			 table.setModel(DbUtils.resultSetToTableModel(rs1));
       			resizeColumnWidth(table);
       			 
       		}catch(Exception ex) {
       			ex.printStackTrace();
       			JOptionPane.showMessageDialog(null, ex);
       		}
			}
		});
		btnNewButton.setFont(new Font("Angsana New", Font.BOLD, 34));
		btnNewButton.setBounds(960, 370, 95, 42);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("แสดงวิชาทั้งหมด");
		btnNewButton_2.addActionListener(new ActionListener() {
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
		btnNewButton_2.setFont(new Font("Angsana New", Font.BOLD, 34));
		btnNewButton_2.setBounds(1126, 362, 233, 51);
		getContentPane().add(btnNewButton_2);
		refreshTable();
		
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
