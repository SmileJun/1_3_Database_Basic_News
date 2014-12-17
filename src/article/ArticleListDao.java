package article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Article;

public class ArticleListDao {
	Connection connection = null;
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public ArrayList<Article> getArticleList() {
		PreparedStatement pstmt = null;	
		ResultSet rs = null;
		String sql = null;
	
		try {	
			
		} catch (Exception e) {
			System.out.println(e.toString());
			
		} finally {
			if(rs != null) try { rs.close(); } catch (SQLException e) {}				
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
		}
		return null;
	}

}
