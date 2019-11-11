package ua.nure.kn.chychkanov.usermanagement.db;

import static ua.nure.kn.chychkanov.usermanagement.db.DaoFactory.getInstance;

import java.io.IOException;

import junit.framework.TestCase;

public class DaoFactoryTest extends TestCase {

	public void testGetUserDao() throws IOException {
		try {
			DaoFactory daoFactory = getInstance();
			assertNotNull("DaoFactory instance null", daoFactory);
			UserDao userDao = daoFactory.getUserDao();
			assertNotNull("UserDao instance is null", userDao);
		} catch (RuntimeException e) {
			e.printStackTrace();
            fail(e.toString());
		}
	}
}
