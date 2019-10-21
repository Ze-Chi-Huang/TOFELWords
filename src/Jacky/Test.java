package Jacky;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Test extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
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
	public Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("課編: ");
		label.setBounds(55, 31, 57, 19);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setText("02");
		textField.setBounds(97, 28, 28, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//String[] answers = new String[5];
		
		JButton btnNewButton = new JButton("產生題目");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//contentPane.repaint();
				//取得單字，存在Map 跟String 陣列裡
				WordsDAO dao = new WordsDAO();
				ResultSet rs = dao.getWordsResulSet(textField.getText());
				
				Map<String, String> map = new HashMap<>();
				String[] words = new String[50];
				int count = 0;
				try {
					
					while(rs.next()) {
						
						String word = rs.getString("英文單字");
						words[count] = word;
						count++;
						String explanation = rs.getString("中文意思");
						map.put(word, explanation);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//隨機抽取單字索引
				Random rand = new Random();
				int[] randNum = new int[5];
				for(int i =0; i<5; i++) {
					randNum[i] = rand.nextInt(count);
				}
				
				
				
				for(int i = 0; i<5 ; i++) {
					
					JLabel lblNewLabel = new JLabel((i+1) + ". " + words[randNum[i]] );
					lblNewLabel.setBounds(68 , 63 + 65*i, 379, 19);
					contentPane.add(lblNewLabel);
					
					ButtonGroup buttonGroup = new ButtonGroup();
					
					//隨機選項
					String[] choose = new String[3];
					choose[0] = map.get(words[randNum[i]]);
					choose[1] = map.get(words[rand.nextInt(count)]);
					choose[2] = map.get(words[rand.nextInt(count)]);
					List<String> list = Arrays.asList(choose);
					Collections.shuffle(list);
					
					
					JRadioButton radio1 = new JRadioButton(list.get(0));
					buttonGroup.add(radio1);
					radio1.setBounds(55, 91 + 65*i, 127, 27);
					contentPane.add(radio1);
					
					JRadioButton radio2 = new JRadioButton(list.get(1));
					buttonGroup.add(radio2);
					radio2.setBounds(188, 91 + 65 * i, 127, 27);
					contentPane.add(radio2);
					
					JRadioButton radio3 = new JRadioButton(list.get(2));
					buttonGroup.add(radio3);
					radio3.setBounds(320, 91 + 65*i, 127, 27);
					contentPane.add(radio3);

					}

				setContentPane(contentPane);
			}
		});
		btnNewButton.setBounds(165, 27, 99, 27);
		contentPane.add(btnNewButton);
		
		
		
		JButton button = new JButton("送出答案");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		button.setBounds(287, 27, 99, 27);
		contentPane.add(button);
	}
}
