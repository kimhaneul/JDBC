package kr.ac.sungkyul.bookmall.app;

import java.util.List;
import kr.ac.sungkyul.bookmall.dao.Author_Dao;
import kr.ac.sungkyul.bookmall.vo.Author_Vo;

public class Book_Mall {

	public static void main(String[] args) {
		
		// testAuthorDaoInsert();
		// testAuthorDaoGetList();
	}
	
	public static void testAuthorDaoSalaryAll(){
		
		
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
