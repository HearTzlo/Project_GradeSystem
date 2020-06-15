package MyProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class AnnoucmentPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnnoucmentPage frame = new AnnoucmentPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	JLabel label,label2,label3,label4;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	public void AnnoucmentPage(String un,String  stdn,String name ,String surname) {
		// TODO Auto-generated constructor stub
		label.setText(un);
		label3.setText(stdn);
		label2.setText(name);
		label4.setText(surname);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
/**
	 * Create the frame.
	 */
	public AnnoucmentPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 2000, 1000);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("รายวิชา");
		mnNewMenu.setFont(new Font("Angsana New", Font.BOLD, 34));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("แสดงรายวิชา");
		mntmNewMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
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
		mntmNewMenuItem.setFont(new Font("Angsana New", Font.BOLD, 30));
		mnNewMenu.add(mntmNewMenuItem);
		
		mnNewMenu_1 = new JMenu("ผลการเรียน");
		mnNewMenu_1.setFont(new Font("Angsana New", Font.BOLD, 34));
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_1 = new JMenuItem("แสดงผลการเรียน");
		mntmNewMenuItem_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
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
	
		mntmNewMenuItem_1.setFont(new Font("Angsana New", Font.BOLD, 30));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		 label = new JLabel("New label");
		 label.setFont(new Font("Angsana New", Font.PLAIN, 33));
		
		 label2 = new JLabel("New label");
		 label2.setFont(new Font("Angsana New", Font.PLAIN, 33));
		
		JButton Gradebtn = new JButton("ผลการเรียน");
		Gradebtn.setForeground(new Color(255, 255, 255));
		Gradebtn.setBackground(new Color(204, 51, 0));
		Gradebtn.setFont(new Font("Angsana New", Font.BOLD, 40));
		Gradebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		
		JButton btnNewButton_3 = new JButton("แสดงรายวิชา");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(204, 51, 0));
		btnNewButton_3.setFont(new Font("Angsana New", Font.BOLD, 40));
		btnNewButton_3.addActionListener(new ActionListener() {
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
		
		 label3 = new JLabel("New label");
		 label3.setHorizontalAlignment(SwingConstants.LEFT);
		 label3.setForeground(Color.BLACK);
		 label3.setFont(new Font("Angsana New", Font.PLAIN, 33));
		
		lblNewLabel = new JLabel("รหัสนักศึกษา");
		lblNewLabel.setFont(new Font("Angsana New", Font.BOLD, 34));
		
		lblNewLabel_1 = new JLabel("ชื่อ-สกุล");
		lblNewLabel_1.setFont(new Font("Angsana New", Font.BOLD, 34));
		
		lblNewLabel_2 = new JLabel("รหัสผู้ใช้");
		lblNewLabel_2.setFont(new Font("Angsana New", Font.BOLD, 34));
		
		 label4 = new JLabel("New label");
		 label4.setFont(new Font("Angsana New", Font.PLAIN, 33));
		
		btnNewButton = new JButton("ออกจากระบบ");
		btnNewButton.setFont(new Font("Angsana New", Font.BOLD, 40));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main(null);
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(502)
					.addComponent(Gradebtn, GroupLayout.PREFERRED_SIZE, 734, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(502)
					.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 734, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(502)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 734, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(679)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
						.addComponent(label3, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label2, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label4, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(122)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label)
							.addGap(18)
							.addComponent(label3)
							.addGap(33)
							.addComponent(label2))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addGap(18)
							.addComponent(lblNewLabel)
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(label4))))
					.addGap(39)
					.addComponent(Gradebtn, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
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
