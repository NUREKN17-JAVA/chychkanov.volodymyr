package ua.nure.kn.chychkanov.usermanagement.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.bind.DataBindingException;

public class ConnectionFactoryImpl implements ConnectionFactory {

	@Override
	public Connection createConnection() throws DatabaseException {
		String url = "jdbc:hsqldb:file:db/usermanagement"; 
		String user="sa"; 
		String password="";
		String driver=" org.hsqldb.jdbcDriver";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new DataBindingException(e);
		}
	}

}
