package member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/member/modify")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		try {
			// 1. 드라이버 등록
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. 데이터베이스 접속 정보를 통해 연결
			Connection connection = DriverManager.getConnection("jdbc:mysql://nextit.or.kr:23306/hit15", "hit15", "hit15");
			// 4. 쿼리 작성
			String sql = "select id, name, email, phone_number from member where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userId);
			// 5. 쿼리 전송 후 결과 받기
			ResultSet resultSet = statement.executeQuery();
			MemberVO vo = null;
			if (resultSet.next()) {
				String id = resultSet.getString("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String phoneNumber = resultSet.getString("phone_number");
				vo = new MemberVO(id, null, name, email, phoneNumber);
			}
			request.setAttribute("member", vo);
			if (vo != null) {
				request.getRequestDispatcher("/member/view.jsp").forward(request, response);
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		try {
			// 1. 드라이버 등록
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. 데이터베이스 접속 정보를 통해 연결
			Connection connection = DriverManager.getConnection("jdbc:mysql://nextit.or.kr:23306/hit15", "hit15", "hit15");
			// 3. 질의(Query) 전송 준비
			// 4. 쿼리 작성
			String sql = "update member set name = ?, email = ?, phone_number = ? where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userName);
			statement.setString(2, email);
			statement.setString(3, phoneNumber);
			statement.setString(4, userId);
			
			// 5. 쿼리 전송 후 결과 받기
			int insertCount = statement.executeUpdate();// executeQuery: select,  executeUpdate(): insert, update, delete
			
			if (insertCount > 0) {
				response.sendRedirect(request.getContextPath() + "/member/manage");
			}
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}















