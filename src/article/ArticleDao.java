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
	String sql = null;

	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int addArticle(String title, String contents) throws Exception {
		int updatedRows = 0;
		
		try {		
			sql = "insert TB_ARTICLE(ARTICLE_TITLE, ARTICLE_CONTENTS, CREATE_DATE) VALUES (?,?,NOW())";
			pstmt = conn.prepareStatement(sql);;
			pstmt.setString(1, title);
			pstmt.setString(2, contents);
			updatedRows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
		}
		return updatedRows;
	}
	
	public Article getArticle(String seq) throws Exception {
		ResultSet rs1 = null;
		ResultSet rs2 = null;

		int articleSeq = Integer.parseInt(seq);
		Article article = null;

		try {
			ArrayList<Comment> commentList = new ArrayList<Comment>();
			
			sql = "select * from TB_ARTICLE WHERE ARTICLE_SEQ=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, articleSeq);
			rs1 = pstmt.executeQuery();
			rs1.next();
			
			sql = "select * from TB_COMMENT WHERE COMMENT_ARTICLE_SEQ=? ORDER BY CREATE_DATE DESC";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, articleSeq);
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
			throw e;
				
		} finally {
			if(rs1 != null) try { rs1.close(); } catch (SQLException e) {}				
			if(rs2 != null) try { rs2.close(); } catch (SQLException e) {}				
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
		}
		
		return article;
	}
	
	public ArrayList<Article> getArticleList() throws Exception {
		ResultSet rs = null;
		
		ArrayList<Article> articleList = new ArrayList<Article>();
		
		try {		
			sql = "select ARTICLE_SEQ, ARTICLE_TITLE, CREATE_DATE from TB_ARTICLE ORDER BY CREATE_DATE DESC LIMIT 50";
			pstmt = conn.prepareStatement(sql);;
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				articleList.add(new Article(
						rs.getString("ARTICLE_SEQ"),
						rs.getString("ARTICLE_TITLE"),
						rs.getString("CREATE_DATE")));
			}
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			if(rs != null) try { rs.close(); } catch (SQLException e) {}				
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
		}
		return articleList;
	}
}
