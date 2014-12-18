package comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommentDao {
	Connection conn = null;
	PreparedStatement pstmt = null;	
	String sql = null;

	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int addComment(String seq, String contents) throws Exception {
		int updatedRows = 0;
		
		int intSeq = Integer.parseInt(seq);
		
		try {		
			sql = "insert TB_COMMENT(COMMENT_ARTICLE_SEQ, COMMENT_CONTENTS, CREATE_DATE) VALUES (?,?,NOW())";
			pstmt = conn.prepareStatement(sql);;
			pstmt.setInt(1, intSeq);
			pstmt.setString(2, contents);
			updatedRows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
		}
		return updatedRows;
	}
}
