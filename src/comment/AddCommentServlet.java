package comment;

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
import article.ArticleDao;

@WebServlet("/AddCommentServlet")
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		try {
			String articleSeq = request.getParameter("articleSeq");

			if(articleSeq == null)
			{
				ServletContext sc = this.getServletContext();
				Connection conn = (Connection)sc.getAttribute("conn");
				ArticleDao dao = new ArticleDao();
				dao.setConnection(conn);
				
				ArrayList<Article> articleList = dao.getArticleList();
				
				request.setAttribute("articleList", articleList);
				response.setContentType("text/html; charset=UTF-8");
				
				rd = request.getRequestDispatcher("/jsp/comment/selectArticle.jsp");
				rd.forward(request, response);	
				
			} else {
				request.setAttribute("articleSeq", articleSeq);
				rd = request.getRequestDispatcher("/jsp/comment/add.jsp");
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		
			request.setAttribute("error", e);
			
			rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String articleSeq = request.getParameter("articleSeq");
			String contents = request.getParameter("contents");
			ServletContext sc = this.getServletContext();
			Connection conn = (Connection)sc.getAttribute("conn");
			CommentDao dao = new CommentDao();
			dao.setConnection(conn);
			
			int updatedRows = dao.addComment(articleSeq, contents);
			
			if(updatedRows > 0) {
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/index.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/jsp/error.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		
			request.setAttribute("error", e);
			
			RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}	
}
