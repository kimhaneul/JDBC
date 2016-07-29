package kr.ac.sungkyul.bookmall.dao.test;

import java.util.*;

import kr.ac.sungkyul.bookmall.dao.Book_Dao;
import kr.ac.sungkyul.bookmall.dao.Book_Dao;
import kr.ac.sungkyul.bookmall.vo.Book_Vo;
import util.InputValues;
import kr.ac.sungkyul.bookmall.vo.Book_Vo;

public class BookDao_Test {

	public static void main(String[] args) {
		testBookDagStatecode();
		// testBookDaoDeleteAll();
		// testBookDaoUpdate();
		// testBookDaoDelete();
		// testBookDaoInsert();
		testBookDaoGetList();
	}
	
	
	public static void testBookDagStatecode(){
		Book_Dao dao = new Book_Dao();
		Book_Vo vo = new Book_Vo();
		
		System.out.println("대여하고 싶은 책의 번호를 입력하세요 >> ");
		int num = InputValues.readInt();

		vo.setNo((long) num);
		vo.setState_code("대여중");

		int count = dao.Statecode(vo);
		System.out.println(count + "개의 책이 대어되었습니다");
		
		
	}

	public static void testBookDaoUpdate() {
		Book_Dao dao = new Book_Dao();
		Book_Vo vo = new Book_Vo();
		vo.setNo(2L);
		vo.setTitle("카레노래");
		vo.setRate(3);
		vo.setAuthorNo(3L);

		int count = dao.update(vo);
		System.out.println(count + "개의 row 가 업데이트됨");
	}

	public static void testBookDaoDeleteAll() {
		Book_Dao dao = new Book_Dao();
		int count = dao.delete();

		System.out.println(count + "개의 전체 row 가 삭제됨");

	}

	public static void testBookDaoDelete() {
		Book_Dao dao = new Book_Dao();
		int count = dao.delete(4L);

		System.out.println(count + "개의 row 가 삭제됨");

	}

	public static void testBookDaoGetList() {
		Book_Dao dao = new Book_Dao();
		List<Book_Vo> list = dao.getList();

		for (Book_Vo vo : list) {
			System.out.println(vo);
		}
	}

	public static void testBookDaoInsert() {
		Book_Vo vo = new Book_Vo();
		// vo.setNo(1L);
		vo.setTitle("title");
		vo.setRate(2);
		vo.setAuthorNo(1L);

		Book_Dao dao = new Book_Dao();
		dao.insert(vo);
	}

}
