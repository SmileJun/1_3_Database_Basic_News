package article;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Article;
import entity.Comment;

@WebServlet("/SelectArticleServlet")
public class SelectArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ServletContext sc = this.getServletContext();
			Connection conn = (Connection)sc.getAttribute("conn");
			ArticleDao dao = new ArticleDao();
			dao.setConnection(conn);
			String seq = request.getParameter("articleSeq");

			Article article = dao.getArticle(seq);
			ArrayList<Comment> CommentList = article.getCommentList();
				
			request.setAttribute("article", article);
			request.setAttribute("CommentList", CommentList);
			response.setContentType("text/html; charset=UTF-8");
			
			System.out.println("article : " + article);
			System.out.println("commentList : " + CommentList);

			RequestDispatcher rd = request.getRequestDispatcher("/jsp/article/read.jsp");
			rd.forward(request, response);	
			
		} catch (Exception e) {
			e.printStackTrace();
		
			request.setAttribute("error", e);
			
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}
}
