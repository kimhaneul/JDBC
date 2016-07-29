package kr.ac.sungkyul.hr.app;

import java.util.List;

import kr.ac.sungkyul.hr.dao.EmployeeDao;
import kr.ac.sungkyul.hr.vo.EmployeeVo;
import util.InputValues;

public class HRApp {
	public static void main(String[] args) {

		// searchByName();
		serachBySalary();
	}

	public static void searchByName() {

		System.out.println("이름입력");
		String name = InputValues.readString();

		EmployeeDao dao = new EmployeeDao();
		List<EmployeeVo> list = dao.getList(name);

		System.out.println("=============================");
		for (EmployeeVo vo : list) {
			System.out.println(vo);
		}
	}

	public static void serachBySalary() {
		System.out.println("임금(최저 최고)>> ");
		// int min = InputValues.readInt();
		// int max = InputValues.readInt();

		int min = 8000;
		int max = 10000;

		EmployeeDao dao = new EmployeeDao();
		List<EmployeeVo> list = dao.getList(min, max);

		System.out.println(min + "  " + max);

		System.out.println("=============================");
		for (EmployeeVo vo : list) {
			// System.out.println( vo );
			System.out.println(String.format("%-15s \t %d", vo.getFirstName(), vo.getSalary()));

		}
	}

}
