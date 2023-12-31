package board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Driver;

import member.MemberVO;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/board/insert")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/board/insert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		// JDBC 프로그래밍
		// 0. 드라이버 준비
		try {
			// 1. 드라이버 등록
//			DriverManager.registerDriver(new Driver());
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. 데이터베이스 접속 정보를 통해 연결
			Connection connection = DriverManager.getConnection("jdbc:mysql://nextit.or.kr:23306/hit15", "hit15", "hit15");
			// 3. 질의(Query) 전송 준비
			// 4. 쿼리 작성
			String sql = "insert into board (title, content, writer) values (?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, title);
			statement.setString(2, content);
			statement.setString(3, writer);
			
			// 5. 쿼리 전송 후 결과 받기
			int insertCount = statement.executeUpdate();// executeQuery: select,  executeUpdate(): insert, update, delete
			
			if (insertCount > 0) {
				response.sendRedirect(request.getContextPath() + "/board/list");
			}
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}













