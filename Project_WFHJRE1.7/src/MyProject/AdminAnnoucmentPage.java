package MyProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class AdminAnnoucmentPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAnnoucmentPage frame = new AdminAnnoucmentPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	JLabel label,label2;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem_1;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem_2;
	private JLabel label3;
	private JLabel label_1;

	/**
	 * Create the frame.
	 */
	public AdminAnnoucmentPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 2000, 1000);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("รายวิชา");
		mnNewMenu.setFont(new Font("Angsana New", Font.BOLD, 34));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("เพิ่มรายวิชา");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un = label.getText();
				AddSubjectPage addsub = new AddSubjectPage();
				addsub.AddSubjectPage(un);
				addsub.setVisible(true);
				dispose();
			}
		});
		
		mntmNewMenuItem.setFont(new Font("Angsana New", Font.BOLD, 30));
		mnNewMenu.add(mntmNewMenuItem);
		
		mnNewMenu_1 = new JMenu("ผลการเรียน");
		mnNewMenu_1.setFont(new Font("Angsana New", Font.BOLD, 34));
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_1 = new JMenuItem("เพิ่มผลการเรียน");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un = label.getText();
				AddStudentGradePage addgrade = new AddStudentGradePage();
				addgrade.AddStudentGradePage(un);
				addgrade.setVisible(true);						
				dispose();	
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Angsana New", Font.BOLD, 30));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		mnNewMenu_2 = new JMenu("รายงาน");
		mnNewMenu_2.setFont(new Font("Angsana New", Font.BOLD, 34));
		menuBar.add(mnNewMenu_2);
		
		mntmNewMenuItem_2 = new JMenuItem("ใบันทึกผลการเรียน");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un = label.getText();
				MyTranscript trans = new MyTranscript();
				trans.MyTranscript(un);
				trans.setVisible(true);
				dispose();
			}
		});
		
		mntmNewMenuItem_2.setFont(new Font("Angsana New", Font.BOLD, 30));
		mnNewMenu_2.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		 label = new JLabel("New label");
		 label.setFont(new Font("Angsana New", Font.PLAIN, 30));
		
		 label2 = new JLabel("New label");
		 label2.setFont(new Font("Angsana New", Font.PLAIN, 30));
		
		btnNewButton = new JButton("เพิ่มรายวิชา");
		btnNewButton.setFont(new Font("Angsana New", Font.BOLD, 40));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un = label.getText();
				AddSubjectPage addsub = new AddSubjectPage();
				addsub.AddSubjectPage(un);
				addsub.setVisible(true);
				dispose();
			}
		});
		
		btnNewButton_1 = new JButton("ใบแสดงผลการเรียน");
		btnNewButton_1.setFont(new Font("Angsana New", Font.BOLD, 40));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un = label.getText();
				MyTranscript trans = new MyTranscript();
				trans.MyTranscript(un);
				trans.setVisible(true);
				dispose();
			}
		});
		
		btnNewButton_2 = new JButton("ออกจากระบบ");
		btnNewButton_2.setBackground(new Color(204, 51, 0));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Angsana New", Font.BOLD, 40));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				dispose();
			}
		});
		
		btnNewButton_3 = new JButton("เพิ่มผลการเรียน");
		btnNewButton_3.setFont(new Font("Angsana New", Font.BOLD, 40));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String un = label.getText();
				AddStudentGradePage addgrade = new AddStudentGradePage();
				addgrade.AddStudentGradePage(un);
				addgrade.setVisible(true);						
				dispose();	
			}
		});
		
		lblNewLabel = new JLabel("เจ้าหน้าที่");
		lblNewLabel.setFont(new Font("Angsana New", Font.BOLD, 44));
		
		label3 = new JLabel("รหัสผู้ใช้งาน");
		label3.setFont(new Font("Angsana New", Font.BOLD, 30));
		
		label_1 = new JLabel("ชื่อ-นามสกุล");
		label_1.setFont(new Font("Angsana New", Font.BOLD, 30));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(865)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(677)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 488, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(677)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 488, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(677)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 488, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(61)
							.addComponent(label3, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 716, Short.MAX_VALUE)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(677)
							.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 488, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addComponent(label2, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(66)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label2)
						.addComponent(label)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(label3))
					.addGap(78)
					.addComponent(lblNewLabel)
					.addGap(38)
					.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(76)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(91)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}


	public void AdminAnnoucmentPage(String un, String name, String surname) {
		// TODO Auto-generated method stub
		label.setText(un);
		label2.setText(name + "  " + surname);
		
	}


	public void AdminAnnoucmentPage(String un) {
		// TODO Auto-generated method stub
		label.setText(un);
		
	}
	
	
	
	
	

}
