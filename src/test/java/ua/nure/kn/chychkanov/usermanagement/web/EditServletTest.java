package ua.nure.kn.chychkanov.usermanagement.web;

import java.text.DateFormat;
import java.util.Date;

import ua.nure.kn.chychkanov.usermanagement.User;

public class EditServletTest extends MockServletTestCase {

	protected void setUp() throws Exception {
		super.setUp();
		createServlet(EditServlet.class);
	}

	public void testEdit() {
        User user = new User(new Long(1000), "John", "Doe", new Date());
        getMockUserDao().expect("update", user);
        addRequestParameter("id", user.getId().toString());
        addRequestParameter("firstName", user.getFirstName());
        addRequestParameter("lastName", user.getLastName());
        addRequestParameter("dateOfBirthd", DateFormat.getDateInstance().format(user.getDateOfBirth()));
        addRequestParameter("okButton", "Ok");
        doPost();
    }
}