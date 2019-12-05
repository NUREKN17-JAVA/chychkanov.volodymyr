package ua.nure.kn.chychkanov.usermanagement.db;

import static ua.nure.kn.chychkanov.usermanagement.db.DaoFactory.getInstance;

import java.io.IOException;

import junit.framework.TestCase;

public class DaoFactoryTest extends TestCase {

	public void testGetUserDao() {
		try {
			DaoFactory daoFactory = DaoFactory.getInstance();
			assertNotNull("DaoFactory instance is null", daoFactory);
			UserDao userDao = daoFactory.getUserDao();
			assertNotNull("UserDao instance is null, userDao");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
}
