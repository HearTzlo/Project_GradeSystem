package MyProject;

import java.sql.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.event.*;
import java.io.*;
import java.awt.Font;
import java.awt.Color;

class AddStudentGradePage extends JFrame implements ActionListener {

    JButton b1, b2;
    JLabel label7;
    String name;
    JTextField t1;
    Connection con, conn;
    Statement st;
    PreparedStatement pst;
    ResultSet rs, rs1;
    private JTable table;
    private JTextField Student_ID;
    private JTextField Subject_ID;
    private JTextField Term;
    private JTextField Year;
    private JTextField Grades;
    private JTextField TX;
//test    
    

		
    public AddStudentGradePage() {
    	getContentPane().setFont(new Font("Angsana New", Font.BOLD, 34));
    	setTitle("เพิ่มเกรดนักศึกษา");
    	getContentPane().setBackground(Color.WHITE);
    	setBounds(0,0,2000,1000);
    	setLocation(50, 0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        
        
        JButton ShowL = new JButton("แสดงผล");
        ShowL.setFont(new Font("Angsana New", Font.BOLD, 34));
        ShowL.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	String str = e.getActionCommand();
        	   if (str.equals("แสดงผล")) {
        		try {
        			 Class.forName("com.mysql.jdbc.Driver");
        	            con = DriverManager.getConnection("jdbc:mysql://localhost/project_gradesystem" +
        						"?user=root&password=");
        	         String query="select Std_code as รหัสนักศึกษา ,Sub_ID as รหัสวิชา , Semester_ID as เทอม  , Year_ID as ปีการศึกษา ,Gd_grade as เกรด from grade where std_code=?";
        			 PreparedStatement pst = con.prepareStatement(query);
        			 pst.setString(1, TX.getText());
        			 ResultSet rs1 = pst.executeQuery();
        			 
        			 table.setModel(DbUtils.resultSetToTableModel(rs1));
        		}catch(Exception ex) {
        			ex.printStackTrace();
        			JOptionPane.showMessageDialog(null, ex);
        		}
        	   }
        	}
        });
         
         JButton btnNewButton = new JButton("หน้าหลัก");
         btnNewButton.setFont(new Font("Angsana New", Font.BOLD, 28));
         btnNewButton.addActionListener(new ActionListener() {
        	 public void actionPerformed(ActionEvent arg0) {
         		String un = label7.getText();
         		AdminAnnoucmentPage mainmenu = new AdminAnnoucmentPage();
 				mainmenu.AdminAnnoucmentPage(un);	
 				mainmenu.setVisible(true);						
 				dispose();
         	}
         });
         
         JLabel lblNewLabel_7 = new JLabel("รหัสผู้ใช้งาน");
         lblNewLabel_7.setForeground(Color.WHITE);
         lblNewLabel_7.setFont(new Font("AngsanaUPC", Font.BOLD, 34));
         lblNewLabel_7.setBounds(1329, 26, 125, 38);
         getContentPane().add(lblNewLabel_7);
         btnNewButton.setBounds(10, 222, 158, 38);
         getContentPane().add(btnNewButton);
        
         label7 = new JLabel("New label");
         label7.setForeground(Color.WHITE);
        label7.setFont(new Font("Angsana New", Font.BOLD, 28));
        label7.setBounds(1464, 33, 86, 28);
        getContentPane().add(label7);
        
        JLabel lblNewLabel_6 = new JLabel("Khon Kaen University");
        lblNewLabel_6.setForeground(Color.WHITE);
        lblNewLabel_6.setFont(new Font("Angsana New", Font.BOLD, 22));
        lblNewLabel_6.setBounds(182, 49, 183, 13);
        getContentPane().add(lblNewLabel_6);
        
        JLabel lblNewLabel_5 = new JLabel("มหาวิทยาลัยขอนแก่น");
        lblNewLabel_5.setForeground(Color.WHITE);
        lblNewLabel_5.setFont(new Font("Angsana New", Font.BOLD, 22));
        lblNewLabel_5.setBounds(182, 10, 137, 13);
        getContentPane().add(lblNewLabel_5);
        
        JLabel lblNewLabel_4 = new JLabel("เพิ่มเกรดนักศึกษา");
        lblNewLabel_4.setForeground(Color.WHITE);
        lblNewLabel_4.setFont(new Font("Angsana New", Font.BOLD, 40));
        lblNewLabel_4.setBounds(525, 26, 393, 51);
        getContentPane().add(lblNewLabel_4);
        
        JLabel lblNewLabel_2 = new JLabel(new ImageIcon(getClass().getResource("pic14.GIF")));
        lblNewLabel_2.setBounds(27, 10, 125, 158);
        getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel(new ImageIcon(getClass().getResource("")));
        lblNewLabel_3.setBounds(21, 10, 131, 158);
        getContentPane().add(lblNewLabel_3);
        ShowL.setBounds(1170, 139, 170, 28);
        getContentPane().add(ShowL);
        
        TX = new JTextField();
        TX.setFont(new Font("Angsana New", Font.BOLD, 34));
        TX.setBounds(895, 138, 225, 45);
        getContentPane().add(TX);
        TX.setColumns(10);
		
		
        JLabel l1 = new JLabel("รหัสนักศึกษา");
        l1.setFont(new Font("Angsana New", Font.BOLD, 34));
        l1.setBounds(706, 123, 150, 60);
        getContentPane().add(l1);
        t1 = new JTextField(10);
        t1.setFont(new Font("Angsana New", Font.BOLD, 28));
        t1.setBounds(1329, 610, 238, 43);
        getContentPane().add(t1);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(508, 209, 1113, 391);
        getContentPane().add(scrollPane);
        
        table = new JTable();
        table.setRowHeight(table.getRowHeight() + 20);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        scrollPane.setViewportView(table);
        table.setFont(new Font("Angsana New",Font.BOLD,26));
        JButton btnGrade = new JButton("ผลการเรียน");
        btnGrade.setFont(new Font("Angsana New", Font.BOLD, 34));
        btnGrade.setBounds(1128, 623, 158, 30);
        btnGrade.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		 String str = ae.getActionCommand();
        	        if (str.equals("ผลการเรียน")) {
        	            try {
        	                Class.forName("com.mysql.jdbc.Driver");
        	                conn = DriverManager.getConnection("jdbc:mysql://localhost/project_gradesystem" +
        	    					"?user=root&password=");

        	                String query = "SELECT(Round(SUM(gd_grade*sub_credit)/Sum(sub_credit),2))GPA "
        	                		+ "FROM student,subject,grade "
        	                		+ "WHERE (student.Std_Code = grade.Std_Code AND grade.sub_ID = subject.sub_ID) and student.std_code=?";
        	                PreparedStatement pst = conn.prepareStatement(query);
        	                pst.setString(1, TX.getText());
        	                
        	                ResultSet rs1 = pst.executeQuery();
        	                while (rs1.next()) {
        	                    String add = rs1.getString("GPA");
        	                    t1.setText(add);
        	           
        	                }

        	            } catch (Exception ex) {
        	                ex.printStackTrace();
        	                JOptionPane.showMessageDialog(null,ex);
        	            }
        	            
        	            
        	        }
        	    }
        });
        getContentPane().add(btnGrade);
        
        JButton btnLogout = new JButton("ออกจากระบบ");
        btnLogout.setFont(new Font("Angsana New", Font.BOLD, 28));
        btnLogout.setBounds(10, 803, 158, 41);
        btnLogout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				Login.main(null);
				dispose();
        	}
        });
        getContentPane().add(btnLogout);
        
        JButton btnNewButton_1 = new JButton("Insert");
        btnNewButton_1.setFont(new Font("Angsana New", Font.BOLD, 34));
        btnNewButton_1.setBounds(555, 807, 125, 28);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int response = JOptionPane.showConfirmDialog(null, "ต้องการเพิ่มข้อมูลใช่หรือไม่?","เพิ่มข้อมูล",JOptionPane.YES_NO_OPTION);
				if(response==0) {
        		try {
    				Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost/project_gradesystem" +
        					"?user=root&password=");
                    
    				String query="INSERT INTO `Grade` "
    						+ "(Std_Code, Sub_ID, Semester_ID, Year_ID,Gd_grade)"
    						+ " VALUES (?, ?, ?, ?,?);";			
    				PreparedStatement pst = conn.prepareStatement(query);
    				
    				pst.setString(1,Student_ID.getText());
    				pst.setString(2,Subject_ID.getText());
    				pst.setString(3,Term.getText());
    				pst.setString(4,Year.getText());
    				pst.setString(5,Grades.getText());
    				pst.execute();
    				JOptionPane.showMessageDialog(null, "Inserted Succesfully");
    				pst.close();
    				}catch(Exception e1) {
    					e1.printStackTrace();	
    					JOptionPane.showMessageDialog(null, e1);
    					
    				}
				}
    				
    		
        	}});
        getContentPane().add(btnNewButton_1);
        
        JButton btnNewButton_1_1 = new JButton("Update");
        btnNewButton_1_1.setFont(new Font("Angsana New", Font.BOLD, 34));
        btnNewButton_1_1.setBounds(995, 807, 125, 30);
        btnNewButton_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int response = JOptionPane.showConfirmDialog(null, "ต้องการอัพเดตข้อมูลใช่หรือไม่?","อัพเดตข้อมูล",JOptionPane.YES_NO_OPTION);
				if(response==0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
	                conn = DriverManager.getConnection("jdbc:mysql://localhost/project_gradesystem" +
	    					"?user=root&password=");
	                
					String query="Update Grade set Std_Code='"+Student_ID.getText()+"'"
							+ ",Sub_ID='"+Subject_ID.getText()+"'"
							+ ",Semester_ID='"+Term.getText()+"'"
							+ ",Year_ID='"+Year.getText()+"' "
							+ ",Gd_grade='"+Grades.getText()+"' "
							+ "where Std_Code='"+Student_ID.getText()+"' "
							+ "and Sub_ID='"+Subject_ID.getText()+"'"
							+ "and Semester_ID='"+Term.getText()+"'"
							+ "and Year_ID='"+Year.getText()+"'";;
					PreparedStatement pst = conn.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Updated Succesfully");
					pst.close();
					}catch(Exception e1) {
						e1.printStackTrace();			
						JOptionPane.showMessageDialog(null, e1);
					}
			
				}
			
        	}	
        });
        getContentPane().add(btnNewButton_1_1);
        
        JButton btnNewButton_1_2 = new JButton("Delete");
        btnNewButton_1_2.setFont(new Font("Angsana New", Font.BOLD, 34));
        btnNewButton_1_2.setBounds(1415, 807, 125, 28);
        btnNewButton_1_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int response = JOptionPane.showConfirmDialog(null, "ต้องการลบข้อมูลใช่หรือไม่?","ลบข้อมูล",JOptionPane.YES_NO_OPTION);
				if(response==0) {
        		try {
					Class.forName("com.mysql.jdbc.Driver");
	                conn = DriverManager.getConnection("jdbc:mysql://localhost/project_gradesystem" +
	    					"?user=root&password=");
	                
					String query="Delete from grade where Std_code='"+Student_ID.getText()+"'"
							+ "and Sub_ID='"+Subject_ID.getText()+"'"
							+ "and Semester_ID='"+Term.getText()+"'"
							+ "and Year_ID='"+Year.getText()+"'";
							
					PreparedStatement pst = conn.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Deleted Succesfully");
					pst.close();
					}catch(Exception e1) {
						e1.printStackTrace();			
						JOptionPane.showMessageDialog(null, e1);
					}								
        	}
        	}
        });
        getContentPane().add(btnNewButton_1_2);
        
        Student_ID = new JTextField();
        Student_ID.setFont(new Font("Angsana New", Font.BOLD, 28));
        Student_ID.setBounds(555, 743, 238, 42);
        getContentPane().add(Student_ID);
        Student_ID.setColumns(10);
        
        Subject_ID = new JTextField();
        Subject_ID.setFont(new Font("Angsana New", Font.BOLD, 28));
        Subject_ID.setBounds(891, 743, 170, 42);
        Subject_ID.setColumns(10);
        getContentPane().add(Subject_ID);
        
        Term = new JTextField();
        Term.setFont(new Font("Angsana New", Font.BOLD, 28));
        Term.setBounds(1148, 743, 65, 42);
        Term.setColumns(10);
        getContentPane().add(Term);
        
        Year = new JTextField();
        Year.setFont(new Font("Angsana New", Font.BOLD, 28));
        Year.setBounds(1301, 743, 86, 42);
        Year.setColumns(10);
        getContentPane().add(Year);
        
        Grades = new JTextField();
        Grades.setFont(new Font("Angsana New", Font.BOLD, 28));
        Grades.setBounds(1444, 743, 106, 42);
        Grades.setColumns(10);
        getContentPane().add(Grades);
        
        JLabel lblNewLabel = new JLabel("รหัสนักศึกษา");
        lblNewLabel.setFont(new Font("Angsana New", Font.BOLD, 34));
        lblNewLabel.setBounds(551, 705, 134, 28);
        getContentPane().add(lblNewLabel);
        
        JLabel lblSubjectid = new JLabel("รหัสวิชา");
        lblSubjectid.setFont(new Font("Angsana New", Font.BOLD, 34));
        lblSubjectid.setBounds(885, 705, 123, 28);
        getContentPane().add(lblSubjectid);
        
        JLabel lblSemester = new JLabel("เทอม");
        lblSemester.setFont(new Font("Angsana New", Font.BOLD, 34));
        lblSemester.setBounds(1147, 705, 94, 28);
        getContentPane().add(lblSemester);
        
        JLabel lblYear = new JLabel("ปี");
        lblYear.setFont(new Font("Angsana New", Font.BOLD, 34));
        lblYear.setBounds(1295, 702, 65, 31);
        getContentPane().add(lblYear);
        
        JLabel lblGrade = new JLabel("เกรด");
        lblGrade.setFont(new Font("Angsana New", Font.BOLD, 34));
        lblGrade.setBounds(1444, 705, 106, 28);
        getContentPane().add(lblGrade);
        
        JLabel lblNewLabel_1 = new JLabel(new ImageIcon(getClass().getResource("pic9 (1) (1).gif")));
        lblNewLabel_1.setBounds(0, 0, 183, 1060);
        getContentPane().add(lblNewLabel_1);
        
        JLabel head = new JLabel(new ImageIcon(getClass().getResource("pic8 (1) (1).gif")));
        head.setBounds(182, 0, 1780, 90);
        getContentPane().add(head);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(182, 87, 1886, 38);
        getContentPane().add(menuBar);
        
        JMenu mnNewMenu = new JMenu("รายวิชา");
        mnNewMenu.setFont(new Font("Angsana New", Font.BOLD, 34));
        menuBar.add(mnNewMenu);
        
        JMenuItem mntmNewMenuItem = new JMenuItem("เพิ่มรายวิชา");
        mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un = label7.getText();
				AddSubjectPage addsub = new AddSubjectPage();
				addsub.AddSubjectPage(un);
				addsub.setVisible(true);
				dispose();
			}
		});
        
        mntmNewMenuItem.setFont(new Font("Angsana New", Font.BOLD, 28));
        mnNewMenu.add(mntmNewMenuItem);
        
        JMenu mnNewMenu_1 = new JMenu("ผลการเรียน");
        mnNewMenu_1.setFont(new Font("Angsana New", Font.BOLD, 34));
        menuBar.add(mnNewMenu_1);
        
        JMenuItem mntmNewMenuItem_1 = new JMenuItem("เพิ่มผลการเรียน");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				String un = label7.getText();
				AddStudentGradePage addgrade = new AddStudentGradePage();
				addgrade.AddStudentGradePage(un);
				addgrade.setVisible(true);						
				dispose();	
			}
		});        
        mntmNewMenuItem_1.setFont(new Font("Angsana New", Font.PLAIN, 27));
        mnNewMenu_1.add(mntmNewMenuItem_1);
        
        JMenu mnNewMenu_2 = new JMenu("รายงาน");
        mnNewMenu_2.setFont(new Font("Angsana New", Font.BOLD, 34));
        menuBar.add(mnNewMenu_2);
        
        JMenuItem mntmNewMenuItem_2 = new JMenuItem("ใบันทึกผลการเรียน");
        mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un = label7.getText();
				MyTranscript trans = new MyTranscript();
				trans.MyTranscript(un);
				trans.setVisible(true);
				dispose();
			}
		});
        
        
        mntmNewMenuItem_2.setFont(new Font("Angsana New", Font.PLAIN, 27));
        mnNewMenu_2.add(mntmNewMenuItem_2);
        
        setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    

    
    public void AddStudentGradePage(String un) {
    	label7.setText(un);
    }
    
    public static void main(String[] args) throws IOException {
        AddStudentGradePage td = new AddStudentGradePage();
    }




	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}