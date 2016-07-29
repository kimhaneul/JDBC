package kr.ac.sungkyul.hr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.sungkyul.bookmall.vo.Author_Vo;
import kr.ac.sungkyul.hr.vo.EmployeeVo;

public class EmployeeDao {
	public static final String ID = "hr";
	public static final String PWD = "hr";

	public List<EmployeeVo> getList(String name) {
		List<EmployeeVo> list = new ArrayList<EmployeeVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try { // 1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로딩");

			// 2. connection
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl, ID, PWD);
			System.out.println("2");

			// 3.statment 준비
			String sql = "select first_name, last_name,email,phone_number, to_char(hire_date, 'yyyy-mm-dd')"
					+ "  from employees where first_name like ? or last_name like ?";

			pstmt = conn.prepareStatement(sql);
			System.out.println("3");

			// 4. 바인딩
			pstmt.setString(1, "%" + name + "%");
			pstmt.setString(2, "%" + name + "%");

			System.out.println(4);

			// 5. 결과처리
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String firstName = rs.getString(1);
				String lastName = rs.getString(2);
				String email = rs.getString(3);
				String phoneNumber = rs.getString(4);
				String hireDate = rs.getString(5);

				EmployeeVo vo = new EmployeeVo();
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setEmail(email);
				vo.setPhoneNumber(phoneNumber);
				vo.setHireDate(hireDate);

				list.add(vo);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩할수 없음" + e);
		} catch (SQLException ex) {
			System.out.println("에러  : " + ex);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println("에러 : " + ex);
			}
		}
		return list;
	}

	public List<EmployeeVo> getList(int min, int max) {
		List<EmployeeVo> list = new ArrayList<EmployeeVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try { // 1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("임금로딩");

			// 2. connection
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl, ID, PWD);
			System.out.println("2");

			// 3.statment 준비
			String sql = "select first_name ,last_name, salary from employees "
					+ "where ? <salary and salary < ? order by salary";

			pstmt = conn.prepareStatement(sql);
			System.out.println("3");

			// 4. 바인딩
			pstmt.setLong(1, min);
			pstmt.setLong(2, max);

			System.out.println(4);

			// 5. 결과처리
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String firstName = rs.getString(1);
				String lastName = rs.getString(2);
				int salary = rs.getInt(3);

				EmployeeVo vo = new EmployeeVo();
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setSalary(salary);

				list.add(vo);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩할수 없음" + e);
		} catch (SQLException ex) {
			System.out.println("에러  : " + ex);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println("에러 : " + ex);
			}
		}
		return list;
	}
}
