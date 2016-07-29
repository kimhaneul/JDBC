package kr.ac.sungkyul.bookmall.dao.test;

import java.util.List;

import kr.ac.sungkyul.bookmall.dao.Author_Dao;
import kr.ac.sungkyul.bookmall.vo.Author_Vo;

public class Author_Dao_Test {

	public static void main(String[] args) {

		// testAuthorDaoDeleteAll();
		// testAuthorDaoUpdate();
		// testAuthorDaoDelete();
		// testAuthorDaoInsert();
		testAuthorDaoGetList();
	}

	public static void testAuthorDaoUpdate() {
		Author_Dao dao = new Author_Dao();
		Author_Vo vo = new Author_Vo();
		vo.setNo(1L);
		vo.setName("박경리1");
		vo.setDescription("토지작가1");

		int count = dao.update(vo);
		System.out.println(count + "개의 row 가 업데이트됨");
	}

	public static void testAuthorDaoDeleteAll() {
		Author_Dao dao = new Author_Dao();
		int count = dao.delete();

		System.out.println(count + "개의 전체 row 가 삭제됨");

	}

	public static void testAuthorDaoDelete() {
		Author_Dao dao = new Author_Dao();
		int count = dao.delete(4L);

		System.out.println(count + "개의 row 가 삭제됨");

	}

	public static void testAuthorDaoGetList() {
		Author_Dao dao = new Author_Dao();
		List<Author_Vo> list = dao.getList();

		for (Author_Vo vo : list) {
			System.out.println(vo);
		}
	}

	public static void testAuthorDaoInsert() {
		Author_Vo vo = new Author_Vo();
		vo.setName("플라톤");
		vo.setDescription(" ");

		Author_Dao dao = new Author_Dao();
		dao.insert(vo);
	}
}
