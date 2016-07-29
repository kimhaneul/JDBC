package jdbc;
import java.sql.*;

public class JDBC_Test {

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
			String sql = "select employee_id, first_Name, last_name, salary from employees";
			rs = stmt.executeQuery(sql);

			//5. 결과처리
			while(rs.next()){
				int employeeID = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastNAme = rs.getString(3);
				int salary = rs.getInt(4);
				
				System.out.println(employeeID + "  " + firstName +  "  " + lastNAme +  "  " + salary);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
