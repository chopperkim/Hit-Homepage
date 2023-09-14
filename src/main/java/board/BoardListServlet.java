package board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://nextit.or.kr:23306/hit15", "hit15", "hit15");
			Statement statement = connection.createStatement();
			String sql = "select no, title, content, writer, create_date, modify_date from board";
			ResultSet resultSet = statement.executeQuery(sql);
			List<BoardVO> list = new ArrayList<BoardVO>();
			while (resultSet.next()) {
				int no = resultSet.getInt("no");
				String title = resultSet.getString("title");
				String content = resultSet.getString("content");
				String writer = resultSet.getString("writer");
				Date createDate = resultSet.getDate("create_date");
				Date modifyDate = resultSet.getDate("modify_date");
				list.add(new BoardVO(no, title, content, writer, createDate, modifyDate));
			}
			
			request.setAttribute("boards", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		// jsp 파일을 보여주기
		request.getRequestDispatcher("/board/list.jsp").forward(request, response);
	}

}















