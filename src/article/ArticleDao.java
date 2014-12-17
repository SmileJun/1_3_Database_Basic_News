package article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Article;
import entity.Comment;

public class ArticleDao {
	Connection conn = null;
	PreparedStatement pstmt = null;	
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	String sql = null;

	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public Article getArticle(String seq) {
		
		int intSeq = Integer.parseInt(seq);
		
		Article article = null;
		ArrayList<Comment> commentList = new ArrayList<Comment>();
		
		try {
			sql = "select * from TB_ARTICLE WHERE ARTICLE_SEQ = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, intSeq);
			rs1 = pstmt.executeQuery();
			rs1.next();
			
			sql = "select * from TB_COMMENT WHERE COMMENT_ARTICLE_SEQ = ? ORDER BY CREATE_DATE DESC";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, intSeq);
			rs2 = pstmt.executeQuery();
			
			while (rs2.next()) {
				commentList.add(new Comment(
						rs2.getString("COMMENT_USR_NAME"),
						rs2.getString("COMMENT_CONTENTS"),
						rs2.getString("CREATE_DATE"),
						rs2.getString("UPDATE_DATE")));
			}
			
			article = new Article(
					rs1.getString("ARTICLE_SEQ"),
					rs1.getString("ARTICLE_USR_SEQ"),
					rs1.getString("ARTICLE_USR_NAME"),
					rs1.getString("ARTICLE_TITLE"),
					rs1.getString("ARTICLE_CONTENTS"),
					rs1.getString("CREATE_DATE"),
					rs1.getString("UPDATE_DATE"),
					commentList);
			
		} catch (Exception e) {
			System.out.println(e.toString());
			
		} finally {
			if(rs1 != null) try { rs1.close(); } catch (SQLException e) {}				
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
		}
		
		return article;
	}
	
	public ArrayList<Article> getArticleList() {
		
		sql = "select ARTICLE_SEQ, ARTICLE_TITLE, CREATE_DATE from TB_ARTICLE ORDER BY CREATE_DATE DESC LIMIT 50";
		
		ArrayList<Article> articleList = new ArrayList<Article>();
		
		try {		
			pstmt = conn.prepareStatement(sql);;
			rs1 = pstmt.executeQuery();
			
			while (rs1.next()) {
				articleList.add(new Article(
						rs1.getString("ARTICLE_SEQ"),
						rs1.getString("ARTICLE_TITLE"),
						rs1.getString("CREATE_DATE")));
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
			
		} finally {
			if(rs1 != null) try { rs1.close(); } catch (SQLException e) {}				
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
		}
		return articleList;
	}
}
