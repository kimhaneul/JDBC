package kr.ac.sungkyul.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.sungkyul.bookmall.vo.Author_Vo;

public class Author_Dao {

	public static final String ID = "skudb";
	public static final String PWD = "skudb";

	////////////////////////////////////////////
	public int delete() {
		Connection conn = null;
		Statement stmt = null;
		int count = 0;

		try {
			// 1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로딩");

			// 2. connection
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl, ID, PWD);
			System.out.println("2");
			// 3.statment 준비
			String sql = "delete from author";
			stmt = conn.createStatement();
			count = stmt.executeUpdate(sql);
			System.out.println("3");

			// pstmt의 1번째 자리에 no을 넣는다
			System.out.println(4);

			// 4. sql start
			System.out.println("5");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을수 없어요" + e);
		} catch (SQLException ex) {
			System.out.println("에러 : " + ex);
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println("에러 : " + ex);

			}
		}
		return count;
	}

	public int update(Author_Vo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			// 1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로딩");
			System.out.println(1);
			
			// 2. connection
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl, ID, PWD);
			System.out.println("2");
			
			// 3.statment 준비
			String sql = "update author set name=?, description=? where no = ?";
			pstmt = conn.prepareStatement(sql);
			System.out.println("3");

			// 4. 바인딩
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getDescription());
			pstmt.setLong(3, vo.getNo());

			System.out.println(4);

			// 5. sql start
			count = pstmt.executeUpdate();
			System.out.println("5");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을수 없어요" + e);
		} catch (SQLException ex) {
			System.out.println("에러 : " + ex);
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
		return count;
	}

	public int delete(long no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			// 1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로딩");

			// 2. connection
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl, ID, PWD);
			System.out.println("2");
			// 3.statment 준비
			String sql = "delete from author where no = ?";
			pstmt = conn.prepareStatement(sql);
			System.out.println("3");

			// 4. 바인딩
			pstmt.setLong(1, no);
			// pstmt의 1번째 자리에 no을 넣는다
			System.out.println(4);

			// 5. sql start
			count = pstmt.executeUpdate();
			System.out.println("5");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을수 없어요" + e);
		} catch (SQLException ex) {
			System.out.println("에러 : " + ex);
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
		return count;
	}

	public int insert(Author_Vo vo) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. connection
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dburl, ID, PWD);

			System.out.println("연결성공");

			// 3. statement 준비
			String sql = "insert into author values(seq_author.nextval, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			// seq_author.nextva 객체를 먼저 생성해주어야 사용할 수 있다.
			// CREATE SEQUENCE seq_book
			// START WITH 1
			// INCREMENT BY 1
			// MAXVALUE 1000000;
			System.out.println("준비");

			// 4. 바인딩
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getDescription());
			System.out.println("바인딩");

			// 5. query 실행
			count = pstmt.executeUpdate();
			System.out.println("쿼리");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 :" + e);
		} catch (SQLException ex) {
			System.out.println("error: " + ex);

		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}

	////////////////////////////////////////////
	public List<Author_Vo> getList() {
		List<Author_Vo> list = new ArrayList<Author_Vo>();

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

			// 3. statement 준비
			stmt = conn.createStatement();

			// 4. sql문 실행
			String sql = " select no, name, description from author";
			rs = stmt.executeQuery(sql);

			// 5. 결과처리
			while (rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String description = rs.getString(3);

				Author_Vo vo = new Author_Vo();
				vo.setNo(no);
				vo.setName(name);
				vo.setDescription(description);

				list.add(vo);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException ex) {
			System.out.println("error: " + ex);

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
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
		return list;
	}

}
