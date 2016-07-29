package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Test_Count {

	public static final String ID = "hr";
	public static final String PWD = "hr";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. connection
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl, ID, PWD);

			System.out.println("연결성공");

			// 3. statement 생성
			 stmt = conn.createStatement();

			// 4. sql문 실행
			String sql = "select count(*) from employees";
			rs = stmt.executeQuery(sql);

			//5. 결과처리
			if(rs.next()){
				int count = rs.getInt(1);
				System.out.println("전체 " + count + "개의 row가 있습니다");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 " +e);
		} catch (SQLException ex) {
			System.out.println("error: " + ex);

		} finally {
			try {
				if(rs != null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
