package ua.nure.kn.chychkanov.usermanagement.db;

import java.io.IOException;
import java.util.Properties;

public class DaoFactory {
	
	private static final String USER_DAO = "dao.knure.ctde.usermanagement.db.UserDao";
	private final Properties properties;
	
	private final static DaoFactory INSTANCE = new DaoFactory();
	
	public static DaoFactory getInstance() {
		return INSTANCE;
	}
	
	private DaoFactory() {
		properties = new Properties();
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream("settings.properties"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private ConnectionFactory getConnectionFactory() {
		String user = properties.getProperty("connection.user");		
		String password = properties.getProperty("connection.password");
		String url = properties.getProperty("connection.url");
		String driver = properties.getProperty("connection.driver");
		return new ConnectionFactoryImpl(driver,url,user,password);
	}
	
	public UserDao getUserDao()throws IOException {
		UserDao result = null;
		try {
			Class clazz = Class.forName(properties.getProperty(USER_DAO));
			result = (UserDao) clazz.newInstance();
			result.setConnectionFactory(getConnectionFactory());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
}
