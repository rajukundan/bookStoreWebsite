package com.bookstore.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import com.bookstore.entity.Users;

class UserDAOTest {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static UserDAO userDAO;
	
	@BeforeClass // This call before first method
	public static void setUpClass() {
		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
 
		 userDAO = new UserDAO(entityManager);
	}
	
	@Test
	void testCreateUsers() {
		Users user1 =new Users();
		user1.setEmail("Mahesh@gmail.com");
		user1.setFullName("FGH ik");
		user1.setPassword("RAMESGH1123");
		
		/*EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

	    UserDAO userDAO = new UserDAO(entityManager);*/
		setUpClass();
	    user1 = userDAO.create(user1);
		
	    tearDownClass();	
		
		assertTrue(user1.getUserId()>0);
		
	}

	@Test //Code executed after last method
	void testCreateUsersFieldNotSet() {
		Users user1 =new Users();
		
	    user1 = userDAO.create(user1);
		
		assertTrue(user1.getUserId()>0);
		
	}
	@Test 
	void testUpdateUsers() {
		Users user =new Users();
		setUpClass();

		user.setUserId(1);
		user.setEmail("Ram@gmail.com");
		user.setFullName("Ram Shankar");
		user.setPassword("Suresh");
		
		user = userDAO.update(user);
		
        String expected = "JAMESH";
        String actual = user.getPassword();
		assertEquals(expected, actual);
		tearDownClass();

	}

	
	@Test
	public void testGetUsersFound() {
		
		Integer userId = 1;
		setUpClass();

		Users user = userDAO.get(userId);
		System.out.println(user.getEmail());
		assertNotNull(user);
		tearDownClass();
	}
	
	@Test
	void testUserNotFound() {
		Integer userId= 99;
		setUpClass();
		Users user = userDAO.get(userId);
		assertNull(user);
		System.out.println("Users not found");
		tearDownClass();
	}
	
	@Test
	public void testDeleteUsers() {
		Integer userId = 16;
		setUpClass();
		userDAO.delete(userId);
		Users user = userDAO.get(userId);
		assertNull(user);

		System.out.println("Users removed");
		tearDownClass();
	}
	@Test()
	public void testDeleteNonExistUser() {
		Integer userId = 17;
		setUpClass();
		userDAO.delete(userId);
	}
	
	@Test()
	public void testListAll() {
		setUpClass();
		List<Users> listUsers = userDAO.listAll();
		assertTrue(listUsers.size() > 0);
		tearDownClass();
      for(Users user : listUsers) {
    	  System.out.println(user.getFullName());
      }
	}
	
	@AfterClass
	public static void tearDownClass(){
		entityManager.close();
		entityManagerFactory.close();
	}
	
	
}
