package Jacky;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WordsDAO {
	
	public final String driver = "com.mysql.jdbc.Driver";
	public final String url = "jdbc:mysql://localhost:3306/myenglishwords?serverTimezone=UTC";
	public final String user = "root";
	public final String password = "2ws3ed234";
	
	Connection conn ;
	
	public WordsDAO(){
		
		try {
			
			//Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	public void addWord(String lessonID, String word, String explaination) {
		
		try {
			//Statement statement = conn.createStatement();
			String sql = "Insert into words(課程編號, 英文單字,中文意思) values (?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, lessonID);
			stmt.setString(2, word);
			stmt.setString(3, explaination);
			
			stmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public ResultSet getWordsResulSet() {
		
		ResultSet rs = null ;
		try {
			Statement statement = conn.createStatement();
			String sql = "select * from words";
			rs = statement.executeQuery(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}
	
public ResultSet getWordsResulSet(String lesson_Num) {
		
		ResultSet rs = null ;
		try {
			

			String sql = "select * from words where 課程編號 = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, lesson_Num);
			rs = stmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}
	
}
