package board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardViewServlet
 */
@WebServlet("/board/view")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardViewServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request에 no=1 파라미터를 넘기면
		int searchNo = Integer.parseInt(request.getParameter("no"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://nextit.or.kr:23306/hit15", "hit15", "hit15");
			String sql = "select no, title, content, writer, create_date, modify_date from board where no = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, searchNo);
			
			ResultSet resultSet = statement.executeQuery();
			BoardVO vo = null;
			if (resultSet.next()) {
				int no = resultSet.getInt("no");
				String title = resultSet.getString("title");
				String content = resultSet.getString("content");
				String writer = resultSet.getString("writer");
				Date createDate = resultSet.getDate("create_date");
				Date modifyDate = resultSet.getDate("modify_date");
				vo = new BoardVO(no, title, content, writer, createDate, modifyDate);
			}
			
			if (vo != null) {
				request.setAttribute("board", vo);
				request.getRequestDispatcher("/board/view.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}















