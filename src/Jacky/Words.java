package Jacky;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Words extends JFrame {

	private JPanel contentPane;
	private JTable wordsTable;
	private JScrollPane scrollPane;
	private JTextField vocabulary;
	private JTextField explanation;
	private JTextField lesson;
	private JLabel label_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Words frame = new Words();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	
	public void showData() {
		
		int countRow = 0;
		WordsDAO d = new WordsDAO();
		
		ResultSet rs = d.getWordsResulSet();
		DefaultTableModel JTableModel = new DefaultTableModel();
		
		wordsTable.setModel(JTableModel);
		JTableModel.addColumn("單字編號");
		JTableModel.addColumn("課程編號");
		JTableModel.addColumn("英文單字");
		JTableModel.addColumn("中文意思");
		
		wordsTable.getColumnModel().getColumn(0).setPreferredWidth(25); //欄位寬度
		wordsTable.getColumnModel().getColumn(1).setPreferredWidth(25);
		
		try {
			
			while(rs.next()) {
				
				Vector<String> vc = new Vector<>();
				
				int id = rs.getInt("單字編號");
				vc.addElement(Integer.toString(id));
				
				vc.addElement(rs.getString("課程編號"));
				vc.addElement(rs.getString("英文單字"));
				vc.addElement(rs.getString("中文意思"));
				
				JTableModel.addRow(vc);
				countRow++;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		//System.out.print(countRow);
		//System.out.print(wordsTable.getRowCount());

		
		wordsTable.changeSelection(countRow-1 ,5,false, false); //選第幾欄第幾列的格子
		
		
		wordsTable.requestFocus(); //獲得焦點，

		wordsTable.setRowSelectionInterval(countRow-1, countRow-1);//選取範圍
		wordsTable.setSelectionBackground(new Color(234, 234, 239)); //設置顏色淡灰色
		
	}
	
	public Words() {
		setTitle("單字簿"); //標題是單字簿
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //打X能關閉程式
		setBounds(100, 100, 743, 515); //起始位置100,100 大小 743,515
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar); //放一個MenuBar
		
		JMenu menu = new JMenu("文章功能");
		menuBar.add(menu); //MenuBar 裡面放下拉式的Menu
		
		JMenuItem menuItem = new JMenuItem("文章"); //新增Memu菜單項目
		menuItem.addActionListener(new ActionListener() { //註冊菜單，點擊可顯示新視窗!
			public void actionPerformed(ActionEvent e) {
				Article article = new Article();
			}
		});
		menu.add(menuItem); //把菜單+到Menu裡面
		
		JMenuItem menuItem_1 = new JMenuItem("單字測驗");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Exam exam = new Exam();
				exam.setVisible(true);
				
			}
		});
		menu.add(menuItem_1);
		
		contentPane = new JPanel(); //來個畫布
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane(); //可捲動的畫布
		scrollPane.setBounds(70, 123, 564, 292);
		contentPane.add(scrollPane);
		
		wordsTable = new JTable(); //JTable!
		scrollPane.setViewportView(wordsTable);
		wordsTable.setRowHeight(24);
		
		JButton showWords = new JButton("顯示單字");
		showWords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				showData();
				
			}
		});
		showWords.setBounds(535, 67, 99, 27);
		contentPane.add(showWords);
		
		JButton addWord = new JButton("新增單字");
		addWord.addKeyListener(new KeyAdapter() { //快捷鍵功能，方便操作!
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					WordsDAO d = new WordsDAO();
					d.addWord(lesson.getText(),vocabulary.getText(),explanation.getText()); //新增單字
					
					showData(); //並查詢單字到最下層
					vocabulary.requestFocus(); //獲取焦點!
					vocabulary.setText("");
					explanation.setText("");
				}
			}
		});
		addWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				WordsDAO d = new WordsDAO();
				d.addWord(lesson.getText(),vocabulary.getText(),explanation.getText());
				
				showData();
				vocabulary.requestFocus();
				vocabulary.setText("");
				explanation.setText("");
			}
		});
		addWord.setBounds(420, 67, 99, 27);
		contentPane.add(addWord);
		
		vocabulary = new JTextField();
		vocabulary.setBounds(71, 67, 116, 25);
		contentPane.add(vocabulary);
		vocabulary.setColumns(10);
		
		explanation = new JTextField();
		explanation.setBounds(231, 67, 116, 25);
		contentPane.add(explanation);
		explanation.setColumns(10);
		
		JLabel label = new JLabel("輸入英文單字");
		label.setFont(new Font("新細明體", Font.PLAIN, 12));
		label.setBounds(70, 39, 116, 19);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("輸入中文字義");
		label_1.setFont(new Font("新細明體", Font.PLAIN, 12));
		label_1.setBounds(231, 39, 116, 19);
		contentPane.add(label_1);
		
		lesson = new JTextField();
		lesson.setText("02");
		lesson.setBounds(110, 0, 21, 25);
		contentPane.add(lesson);
		lesson.setColumns(10);
		
		label_2 = new JLabel("課程 :");
		label_2.setFont(new Font("新細明體", Font.PLAIN, 12));
		label_2.setBounds(71, 4, 51, 19);
		contentPane.add(label_2);
	}
}
