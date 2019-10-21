package Jacky;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Article extends JFrame {

	private JPanel contentPane;
	JFrame frame = new JFrame();
	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Article frame = new Article();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public Article() {
		frame.setTitle("文章閱讀");
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100,743, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("1. 先聽三次KeySentences (不看句子)，並記下重點");
		lblNewLabel.setBounds(64, 13, 332, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblkeysentences = new JLabel("2. 再聽三次KeySentences (搭配英文句子和翻譯)");
		lblkeysentences.setBounds(64, 138, 332, 19);
		contentPane.add(lblkeysentences);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(74, 36, 295, 89);
		contentPane.add(textArea);
		
		JLabel lblkeysentences_1 = new JLabel("3. 念出KeySentences藍色字部分");
		lblkeysentences_1.setBounds(64, 169, 332, 19);
		contentPane.add(lblkeysentences_1);
		
		JLabel lblkeysentences_2 = new JLabel("4. 再聽三次KeySentences，並跟讀");
		lblkeysentences_2.setBounds(64, 201, 332, 19);
		contentPane.add(lblkeysentences_2);
		
		JLabel label = new JLabel("5. 聽文章朗讀2次(不看內容)，並跟讀。第一次發出正確的音，第二次試著理解聽到的內容");
		label.setBounds(64, 233, 595, 19);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("6. 看著文章跟讀2次(每個發音不能含糊)");
		label_1.setBounds(64, 265, 332, 19);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("7. 看翻譯確認意思，然後再聽一次");
		label_2.setBounds(64, 297, 332, 19);
		contentPane.add(label_2);
		
		JLabel lbldoubleCheck = new JLabel("8. 在Double Check 的部份把不理解的詞彙標上記號");
		lbldoubleCheck.setBounds(64, 329, 332, 19);
		contentPane.add(lbldoubleCheck);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBounds(27, 9, 25, 27);
		contentPane.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("");
		checkBox_1.setBounds(27, 134, 25, 27);
		contentPane.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("");
		checkBox_2.setBounds(27, 165, 25, 27);
		contentPane.add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("");
		checkBox_3.setBounds(27, 197, 25, 27);
		contentPane.add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("");
		checkBox_4.setBounds(27, 229, 25, 27);
		contentPane.add(checkBox_4);
		
		JCheckBox checkBox_5 = new JCheckBox("");
		checkBox_5.setBounds(27, 261, 25, 27);
		contentPane.add(checkBox_5);
		
		JCheckBox checkBox_6 = new JCheckBox("");
		checkBox_6.setBounds(27, 293, 25, 27);
		contentPane.add(checkBox_6);
		
		JCheckBox checkBox_7 = new JCheckBox("");
		checkBox_7.setBounds(27, 325, 25, 27);
		contentPane.add(checkBox_7);
		
		JButton btnNewButton = new JButton("全部完成!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(frame.getContentPane(), "恭喜完成!");
				
			}
		});
		btnNewButton.setBounds(64, 402, 99, 27);
		contentPane.add(btnNewButton);
		
		frame.setVisible(true);
	}
}
