package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Scanner sc = new Scanner(System.in);

		System.out.println("=== TEST 1: Department findById ===");
		Department dep = departmentDao.findById(3);

		System.out.println(dep);

		System.out.println("\n=== TEST 2: department findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: seller insert ===");
		Department newDep = new Department(null, "Musica");
		departmentDao.insert(newDep);
		System.out.println("Inserted! New id = " + newDep.getId());
		
		System.out.println("\n=== TEST 5: seller update ===");
		Department department = departmentDao.findById(1);
		department.setName("Engenharia sla");
		departmentDao.update(department);
		System.out.println("Update completed");
		System.out.println("\n=== TEST 6: seller delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteByID(id);
		System.out.println("Delete completed");
		sc.close();
	}
}
