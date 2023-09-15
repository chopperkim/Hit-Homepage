package member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServelt
 */
@WebServlet("/register")
public class RegisterServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/join/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userId");
		String password = request.getParameter("userPw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		try {
			// 1. 드라이버 등록
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. 데이터베이스 접속 정보를 통해 연결
			Connection connection = DriverManager.getConnection("jdbc:mysql://nextit.or.kr:23306/hit15", "hit15", "hit15");
			// 3. 질의(Query) 전송 준비
			// 4. 쿼리 작성
			String sql = "insert into member (id, password, name, email, phone_number) values (?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, id);
			statement.setString(2, password);
			statement.setString(3, name);
			statement.setString(4, email);
			statement.setString(5, phoneNumber);
			
			// 5. 쿼리 전송 후 결과 받기
			int insertCount = statement.executeUpdate();// executeQuery: select,  executeUpdate(): insert, update, delete
			
			if (insertCount > 0) {
				response.sendRedirect(request.getContextPath() + "/login");
			}
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}














