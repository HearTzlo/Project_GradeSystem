package MyProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import net.proteanit.sql.DbUtils;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JComboBox;


class StudentGradePage extends JFrame implements ActionListener {
	JLabel l1,l2,l3,l4;
    JButton b1, b2;
    String name;
    JTextField t1;
    Connection con, conn;
    Statement st;
    PreparedStatement pst;
    ResultSet rs, rs1;
    private JTable table;
    JMenuItem mntmNewMenuItem,mntmNewMenuItem_1;
    JComboBox YearBox,TermBox;
	public void StudentGradePage(String un,String stdn,String name,String surname) {
		// TODO Auto-generated constructor stub
		l1.setText(un);
		l2.setText(stdn);
		l3.setText(name);
		l4.setText(surname);
		
	}
	private void Termcombobox() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/project_gradesystem","root","");
			String sql ="select * from semester";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				String term = rs.getString("Semester_ID");
				TermBox.addItem(term);
			}
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, ex);
		}finally {
            try {
            	pst.close();
            	rs.close();
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR CLOSE");
            }
            }
	}
	private void Yearcombobox() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/project_gradesystem","root","");
			String sql ="select * from Year";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				String year = rs.getString("Year_ID");
				YearBox.addItem(year);
			}
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, ex);
		}finally {
            try {
            	pst.close();
            	rs.close();
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR CLOSE");
            }
            }
	}
	 private JComboBox getTermDataCombo() {
	        if (TermBox == null) {
	        	TermBox = new JComboBox();
	        	
	        	TermBox.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    JComboBox combo = (JComboBox) e.getSource();
	       
	                    //TODO: Do whatever you want with the data
	                }
	            });
	        }
	        return TermBox;
	    }
	 private JComboBox getYearDataCombo() {
	        if (YearBox == null) {
	        	YearBox = new JComboBox();
	        	
	        	YearBox.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    JComboBox combo = (JComboBox) e.getSource();
	       
	                    //TODO: Do whatever you want with the data
	                }
	            });
	        }
	        return YearBox;
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

    StudentGradePage() {
    	getContentPane().setFont(new Font("Angsana New", Font.BOLD, 34));
    	setBounds(0,0,2000,1000);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton btnNewButton_1 = new JButton("หน้าหลัก");
        btnNewButton_1.setFont(new Font("Angsana New", Font.BOLD, 28));
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		String un = l1.getText();
				String stdn = l2.getText();
				String name = l3.getText();
				String surname = l4.getText();
				AnnoucmentPage mainmenu = new AnnoucmentPage();
				mainmenu.AnnoucmentPage(un,stdn,name,surname);	
				mainmenu.setVisible(true);						
				dispose();
        	}
        });
        
         YearBox = new JComboBox();
         YearBox.setFont(new Font("Angsana New", Font.BOLD, 34));
        YearBox.setBounds(1443, 226, 97, 30);
        getContentPane().add(YearBox);
        
         TermBox = new JComboBox();
         TermBox.setFont(new Font("Angsana New", Font.BOLD, 34));
        TermBox.setBounds(1123, 226, 68, 30);
        getContentPane().add(TermBox);
        
        JLabel lblNewLabel_6 = new JLabel("มหาวิทยาลัยขอนแก่น");
        lblNewLabel_6.setForeground(Color.WHITE);
        lblNewLabel_6.setFont(new Font("Angsana New", Font.BOLD, 24));
        lblNewLabel_6.setBounds(187, 9, 145, 23);
        getContentPane().add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("Khon Kaen University");
        lblNewLabel_7.setForeground(Color.WHITE);
        lblNewLabel_7.setFont(new Font("Angsana New", Font.BOLD, 24));
        lblNewLabel_7.setBounds(187, 42, 204, 23);
        getContentPane().add(lblNewLabel_7);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(187, 85, 1891, 60);
        getContentPane().add(menuBar);
        
        JMenu mnNewMenu = new JMenu("รายวิชา");
        mnNewMenu.setFont(new Font("Angsana New", Font.BOLD, 34));
        menuBar.add(mnNewMenu);
        
         mntmNewMenuItem = new JMenuItem("แสดงผลรายวิชา");
        mntmNewMenuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String un = l1.getText();
				String stdn = l2.getText();
				String name = l3.getText();
				String surname = l4.getText();
				StudentSubjectPage stdsub = new StudentSubjectPage();
				stdsub.StudentSubjectPage(un,stdn,name,surname);
				stdsub.setVisible(true);						
				dispose();	
        	}
        	});
        
        
        mntmNewMenuItem.setFont(new Font("Angsana New", Font.PLAIN, 26));
        mnNewMenu.add(mntmNewMenuItem);
        
        JMenu mnNewMenu_1 = new JMenu("ผลการเรียน");
        mnNewMenu_1.setFont(new Font("Angsana New", Font.BOLD, 34));
        menuBar.add(mnNewMenu_1);
        
         mntmNewMenuItem_1 = new JMenuItem("ใบันทึกผลการเรียน");
         mntmNewMenuItem_1.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
 				String un = l1.getText();
 				String stdn = l2.getText();
 				String name = l3.getText();
 				String surname = l4.getText();
 				StudentGradePage grade = new StudentGradePage();
 				grade.StudentGradePage(un,stdn,name,surname);
 				grade.setVisible(true);						
 				dispose();
         	}
         	});
         
        mntmNewMenuItem_1.setFont(new Font("Angsana New", Font.PLAIN, 26));
        mnNewMenu_1.add(mntmNewMenuItem_1);
        btnNewButton_1.setBounds(30, 202, 145, 30);
        getContentPane().add(btnNewButton_1);
        
        JLabel lblNewLabel_3 = new JLabel("แสดงผลการเรียน");
        lblNewLabel_3.setForeground(Color.WHITE);
        lblNewLabel_3.setFont(new Font("Angsana New", Font.BOLD, 40));
        lblNewLabel_3.setBounds(712, 18, 316, 47);
        getContentPane().add(lblNewLabel_3);
        
        JLabel lblNewLabel_2 = new JLabel(new ImageIcon(getClass().getResource("pic14.GIF")));
        lblNewLabel_2.setBounds(46, 18, 97, 161);
        getContentPane().add(lblNewLabel_2);
        l1 = new JLabel("USER SELECTION :");
        l1.setFont(new Font("Angsana New", Font.BOLD, 34));
        l1.setBounds(683, 204, 316, 60);
        getContentPane().add(l1);
        t1 = new JTextField(10);
        t1.setFont(new Font("Angsana New", Font.BOLD, 34));
        t1.setBounds(1344, 777, 196, 36);
        getContentPane().add(t1);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(400, 337, 1278, 390);
        getContentPane().add(scrollPane);
        
        table = new JTable();
		table.setRowHeight(table.getRowHeight() + 20);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFont(new Font("Angsana New",Font.BOLD,26));
        scrollPane.setViewportView(table);
        
        JButton btnGrade = new JButton("ผลการเรียน");
        btnGrade.setFont(new Font("Angsana New", Font.BOLD, 34));
        btnGrade.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
    
     	            try {
     	                Class.forName("com.mysql.jdbc.Driver");
     	                conn = DriverManager.getConnection("jdbc:mysql://localhost/project_gradesystem" +
     	    					"?user=root&password=");

     	                String query = "SELECT(Round(SUM(gd_grade*sub_credit)/Sum(sub_credit),2))GPA "
     	                		+ "FROM student,subject,grade "
     	                		+ "WHERE (student.Std_Code = grade.Std_Code AND grade.sub_ID = subject.sub_ID) and student.std_code=?";
     	                PreparedStatement pst = conn.prepareStatement(query);
     	                pst.setString(1, l1.getText());
     	                pst.setString(1, l2.getText());
     	                
     	                ResultSet rs1 = pst.executeQuery();
     	                while (rs1.next()) {
     	                    String add = rs1.getString("GPA");
     	                    t1.setText(add);
     	           
     	                }

     	            } catch (Exception ex) {
     	                ex.printStackTrace();
     	                JOptionPane.showMessageDialog(null, "ERROR CLOSE");
     	        }
     	    }
     });
 
        btnGrade.setBounds(1142, 767, 170, 46);
        getContentPane().add(btnGrade);
        
        JButton btnLogout = new JButton("ออกจากระบบ");
        btnLogout.setFont(new Font("Angsana New", Font.BOLD, 28));
        btnLogout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				Login.main(null);
				dispose();
        	}
        });
        btnLogout.setBounds(30, 611, 145, 32);
        getContentPane().add(btnLogout);
        
        JButton ShowL = new JButton("แสดงผลการเรียน");
        ShowL.setFont(new Font("Angsana New", Font.BOLD, 34));
        ShowL.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
         		try {
         			 Class.forName("com.mysql.jdbc.Driver");
         	            con = DriverManager.getConnection("jdbc:mysql://localhost/project_gradesystem" +
         						"?user=root&password=");
         	         String query="select grade.sub_id as รหัสวิชา,subject.sub_name as ชื่อวิชา,semester_ID as เทอม,year_id as ปีการศึกษา,gd_grade as เกรด from grade,SUBJECT where (subject.sub_id=grade.sub_id) and std_code=?";
         			 PreparedStatement pst = con.prepareStatement(query);
         			 pst.setString(1, l1.getText());
         			  pst.setString(1, l2.getText());
         			 ResultSet rs1 = pst.executeQuery();
         			 
         			 table.setModel(DbUtils.resultSetToTableModel(rs1));
         			 resizeColumnWidth(table);
         		}catch(Exception ex) {
         			ex.printStackTrace();
         		}
         	   
         	}
         });
        ShowL.setBounds(414, 767, 246, 49);
        getContentPane().add(ShowL);
        
        JLabel lblNewLabel = new JLabel(new ImageIcon(getClass().getResource("pic9 (1) (1).gif")));
        lblNewLabel.setBounds(0, 0, 190, 963);
        getContentPane().add(lblNewLabel);
         
         JLabel lblNewLabel_1 = new JLabel(new ImageIcon(getClass().getResource("pic8 (1) (1).gif")));
         lblNewLabel_1.setBounds(187, 0, 1803, 85);
         getContentPane().add(lblNewLabel_1);
        
         l2 = new JLabel("New label");
         l2.setForeground(Color.LIGHT_GRAY);
         l2.setBackground(Color.LIGHT_GRAY);
         l2.setBounds(110, 400, 45, 13);
         getContentPane().add(l2);
        
        JLabel lblNewLabel_4 = new JLabel("รหัสผู้ใช้");
        lblNewLabel_4.setFont(new Font("Angsana New", Font.BOLD, 34));
        lblNewLabel_4.setBounds(398, 217, 97, 34);
        getContentPane().add(lblNewLabel_4);
        
         l4 = new JLabel("New label");
         l4.setFont(new Font("Angsana New", Font.BOLD, 34));
        l4.setBounds(970, 289, 316, 36);
        getContentPane().add(l4);
        
         l3 = new JLabel("New label");
         l3.setFont(new Font("Angsana New", Font.BOLD, 34));
        l3.setBounds(617, 282, 179, 45);
        getContentPane().add(l3);
        
        JLabel lblNewLabel_5 = new JLabel("ชื่อ-สกุล");
        lblNewLabel_5.setFont(new Font("Angsana New", Font.BOLD, 34));
        lblNewLabel_5.setBounds(401, 292, 83, 30);
        getContentPane().add(lblNewLabel_5);
        
        JButton btnNewButton = new JButton("ค้นหา");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost/project_gradesystem" +
        					"?user=root&password=");

                    String query = "select  grade.sub_id as รหัสวิชา,subject.sub_name as ชื่อวิชา,semester_ID as เทอม,year_id as ปีการศึกษา,gd_grade as เกรด from grade,subject where (subject.sub_id=grade.sub_id) and std_code =? and semester_ID=? and year_ID=?";
                    PreparedStatement pst = conn.prepareStatement(query);
                    
                    String tmp = (String) TermBox.getSelectedItem().toString();
                    String tmpyear = (String) YearBox.getSelectedItem().toString();
                   
                    
                    if (TermBox.getSelectedItem() != null && YearBox.getSelectedItem() != null) {
                    	pst.setString(1, l1.getText());
            			pst.setString(1, l2.getText());
                        pst.setString(2, tmp);
                        pst.setString(3, tmpyear);
                        
                    } 
                    ResultSet rs1 = pst.executeQuery();
                    
                        table.setModel(DbUtils.resultSetToTableModel(rs1));
                        resizeColumnWidth(table);
                    

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, ex);
                }
                
                
            }
        		
        	});
        
        btnNewButton.setFont(new Font("Angsana New", Font.BOLD, 34));
        btnNewButton.setBounds(1443, 289, 90, 36);
        getContentPane().add(btnNewButton);
        
        JLabel lblNewLabel_8 = new JLabel("เทอม");
        lblNewLabel_8.setFont(new Font("Angsana New", Font.BOLD, 34));
        lblNewLabel_8.setBounds(1009, 226, 52, 22);
        getContentPane().add(lblNewLabel_8);
        
        JLabel lblNewLabel_9 = new JLabel("ปีการศึกษา");
        lblNewLabel_9.setFont(new Font("Angsana New", Font.BOLD, 34));
        lblNewLabel_9.setBounds(1262, 227, 129, 29);
        getContentPane().add(lblNewLabel_9);
        
        setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Termcombobox();
        Yearcombobox();
    }


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	 public static void main(String[] args) throws IOException {
	        StudentGradePage td = new StudentGradePage();
	    }
}