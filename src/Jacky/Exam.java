package Jacky;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Exam extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exam frame = new Exam();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Exam() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 728, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton radio1 = new JRadioButton("New radio button");
		buttonGroup.add(radio1);
		radio1.setBounds(55, 91, 127, 27);
		contentPane.add(radio1);
		
		JRadioButton radio2 = new JRadioButton("New radio button");
		buttonGroup.add(radio2);
		radio2.setBounds(188, 91, 127, 27);
		contentPane.add(radio2);
		
		JRadioButton radio3 = new JRadioButton("New radio button");
		buttonGroup.add(radio3);
		radio3.setBounds(320, 91, 127, 27);
		contentPane.add(radio3);
		
		JLabel question1 = new JLabel("New label");
		question1.setBounds(68, 63, 379, 19);
		contentPane.add(question1);
		
		textField = new JTextField();
		textField.setText("02");
		textField.setBounds(97, 28, 28, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("課編: ");
		label.setBounds(55, 31, 57, 19);
		contentPane.add(label);
		
		
		JLabel question2 = new JLabel("New label");
		question2.setBounds(68, 138, 379, 19);
		contentPane.add(question2);
		
		JRadioButton radio4 = new JRadioButton("New radio button");
		buttonGroup_1.add(radio4);
		radio4.setBounds(55, 166, 127, 27);
		contentPane.add(radio4);
		
		JRadioButton radio5 = new JRadioButton("New radio button");
		buttonGroup_1.add(radio5);
		radio5.setBounds(188, 166, 127, 27);
		contentPane.add(radio5);
		
		JRadioButton radio6 = new JRadioButton("New radio button");
		buttonGroup_1.add(radio6);
		radio6.setBounds(320, 166, 127, 27);
		contentPane.add(radio6);
		
		JLabel question3 = new JLabel("New label");
		question3.setBounds(68, 218, 379, 19);
		contentPane.add(question3);
		
		JRadioButton radio7 = new JRadioButton("New radio button");
		buttonGroup_2.add(radio7);
		radio7.setBounds(55, 246, 127, 27);
		contentPane.add(radio7);
		
		JRadioButton radio8 = new JRadioButton("New radio button");
		buttonGroup_2.add(radio8);
		radio8.setBounds(188, 246, 127, 27);
		contentPane.add(radio8);
		
		JRadioButton radio9 = new JRadioButton("New radio button");
		buttonGroup_2.add(radio9);
		radio9.setBounds(320, 246, 127, 27);
		contentPane.add(radio9);
		
		JLabel question4 = new JLabel("New label");
		question4.setBounds(68, 298, 379, 19);
		contentPane.add(question4);
		
		JRadioButton radio10 = new JRadioButton("New radio button");
		buttonGroup_3.add(radio10);
		radio10.setBounds(55, 326, 127, 27);
		contentPane.add(radio10);
		
		JRadioButton radio11 = new JRadioButton("New radio button");
		buttonGroup_3.add(radio11);
		radio11.setBounds(188, 326, 127, 27);
		contentPane.add(radio11);
		
		JRadioButton radio12 = new JRadioButton("New radio button");
		buttonGroup_3.add(radio12);
		radio12.setBounds(320, 326, 127, 27);
		contentPane.add(radio12);
		
		JLabel question5 = new JLabel("New label");
		question5.setBounds(68, 372, 379, 19);
		contentPane.add(question5);
		
		JRadioButton radio13 = new JRadioButton("New radio button");
		buttonGroup_4.add(radio13);
		radio13.setBounds(55, 400, 127, 27);
		contentPane.add(radio13);
		
		JRadioButton radio14 = new JRadioButton("New radio button");
		buttonGroup_4.add(radio14);
		radio14.setBounds(188, 400, 127, 27);
		contentPane.add(radio14);
		
		JRadioButton radio15 = new JRadioButton("New radio button");
		buttonGroup_4.add(radio15);
		radio15.setBounds(320, 400, 127, 27);
		contentPane.add(radio15);
		
		//答案陣列
		String[] answers = new String[5];
		
		
		JButton btnNewButton = new JButton("產生題目");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				radio1.setForeground(Color.black);
				radio2.setForeground(Color.black);
				radio3.setForeground(Color.black);
				radio4.setForeground(Color.black);
				radio5.setForeground(Color.black);
				radio6.setForeground(Color.black);
				radio7.setForeground(Color.black);
				radio8.setForeground(Color.black);
				radio9.setForeground(Color.black);
				radio10.setForeground(Color.black);
				radio11.setForeground(Color.black);
				radio12.setForeground(Color.black);
				radio13.setForeground(Color.black);
				radio14.setForeground(Color.black);
				radio15.setForeground(Color.black);
				
				/*
				//Label 和選項高差60 ，選項和選項差130
				int x = 60, y = 130, init_x = 50, init_y = 60;
				int questionNum = 1;
				
				//第一個Label(題目)
				JLabel j = new JLabel();
				
				*/
				WordsDAO dao = new WordsDAO();
				ResultSet rs = dao.getWordsResulSet(textField.getText());
				
				Map<String,String> map = new HashMap<>();
				String[] words = new String[100]; //英文單字
				int count = 0;
				try {
					int i = 0;
					while(rs.next()) {
						
						
						String word = rs.getString("英文單字");
						words[i] = word;
						i++;
						count = i ;
						String explanation = rs.getString("中文意思");
						map.put(word, explanation);
						
					}
					i = 0;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//隨機題目索引
				Random rand = new Random();
				int[] randNum = new int[5];
				for(int i =0 ; i<5; i++) {
					
					randNum[i] = rand.nextInt(count);
				}

				question1.setText("1. " + words[randNum[0]]);
				question2.setText("2. " + words[randNum[1]]);
				question3.setText("3. " + words[randNum[2]]);
				question4.setText("4. " + words[randNum[3]]);
				question5.setText("5. " + words[randNum[4]]);
				
				//答案陣列設值
				for(int i=0; i<5;i++) {
					answers[i] = map.get(words[randNum[i]]);
				}
				//隨機單字選項 - 第一題
				String[] choose = new String[3];
				choose[0] = map.get(words[randNum[0]]);
				choose[1] = map.get(words[rand.nextInt(count)]);
				choose[2] = map.get(words[rand.nextInt(count)]);
				List<String> list = Arrays.asList(choose);
				Collections.shuffle(list);

				radio1.setText(list.get(0));
				radio2.setText(list.get(1));
				radio3.setText(list.get(2));
				
				//隨機單字選項 - 第二題
				choose = new String[3];
				choose[0] = map.get(words[randNum[1]]);
				choose[1] = map.get(words[rand.nextInt(count)]);
				choose[2] = map.get(words[rand.nextInt(count)]);
				list = Arrays.asList(choose);
				Collections.shuffle(list);
				
				radio4.setText(list.get(0));
				radio5.setText(list.get(1));
				radio6.setText(list.get(2));
				
				//隨機單字選項 - 第三題
				choose = new String[3];
				choose[0] = map.get(words[randNum[2]]);
				choose[1] = map.get(words[rand.nextInt(count)]);
				choose[2] = map.get(words[rand.nextInt(count)]);
				list = Arrays.asList(choose);
				Collections.shuffle(list);
				
				radio7.setText(list.get(0));
				radio8.setText(list.get(1));
				radio9.setText(list.get(2));
				
				//隨機單字選項 - 第四題
				choose = new String[3];
				choose[0] = map.get(words[randNum[3]]);
				choose[1] = map.get(words[rand.nextInt(count)]);
				choose[2] = map.get(words[rand.nextInt(count)]);
				list = Arrays.asList(choose);
				Collections.shuffle(list);
				
				radio10.setText(list.get(0));
				radio11.setText(list.get(1));
				radio12.setText(list.get(2));
				
				//隨機單字選項 - 第五題
				choose = new String[3];
				choose[0] = map.get(words[randNum[4]]);
				choose[1] = map.get(words[rand.nextInt(count)]);
				choose[2] = map.get(words[rand.nextInt(count)]);
				list = Arrays.asList(choose);
				Collections.shuffle(list);
				
				radio13.setText(list.get(0));
				radio14.setText(list.get(1));
				radio15.setText(list.get(2));
				
			}
		});
		btnNewButton.setBounds(165, 27, 99, 27);
		contentPane.add(btnNewButton);
		
		
		JButton button = new JButton("送出答案");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//System.out.println(radio1.getText() + "  " +answers[0] );
				if(radio1.getText().equals(answers[0])) radio1.setForeground(Color.red);
				if(radio2.getText().equals(answers[0])) radio2.setForeground(Color.red);
				if(radio3.getText().equals(answers[0])) radio3.setForeground(Color.red);

				if(radio4.getText().equals(answers[1])) radio4.setForeground(Color.red);
				if(radio5.getText().equals(answers[1])) radio5.setForeground(Color.red);
				if(radio6.getText().equals(answers[1])) radio6.setForeground(Color.red);
				
				if(radio7.getText().equals(answers[2])) radio7.setForeground(Color.red);
				if(radio8.getText().equals(answers[2])) radio8.setForeground(Color.red);
				if(radio9.getText().equals(answers[2])) radio9.setForeground(Color.red);
				
				if(radio10.getText().equals(answers[3])) radio10.setForeground(Color.red);
				if(radio11.getText().equals(answers[3])) radio11.setForeground(Color.red);
				if(radio12.getText().equals(answers[3])) radio12.setForeground(Color.red);
				
				if(radio13.getText().equals(answers[4])) radio13.setForeground(Color.red);
				if(radio14.getText().equals(answers[4])) radio14.setForeground(Color.red);
				if(radio15.getText().equals(answers[4])) radio15.setForeground(Color.red);
				
			}
		});
		button.setBounds(287, 27, 99, 27);
		contentPane.add(button);
	}
}
