package ua.nure.kn.chychkanov.usermanagement;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

public class UserTest extends TestCase {
	
	private User user;
	protected void setUp() throws Exception {
		super.setUp();
		user = new User(1L, "Volodymyr", "Chychkanov", new SimpleDateFormat("d-MM-yyyy").parse("11-09-2000"));
	}

	public void testGetFullName() {
		assertEquals("Chychkanov Volodymyr", user.getFullName());
	}
	
	public void testGetAge() {
		assertEquals(19, user.getAge());
	}
	
    public void testGetAgeBirthdayToday() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        user.setDateOfBirth(calendar.getTime());
        assertEquals(0, user.getAge());
    }
    
    public void testGetAgeBirthdayLater() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, 1);
        user.setDateOfBirth(calendar.getTime());
        assertEquals(-1, user.getAge());
    }
    
    public void testGetAgeThisMonthEarlier() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -2);
        user.setDateOfBirth(calendar.getTime());
        assertEquals(0, user.getAge());
    }
    
    public void testGetAgeDayThisMonthLater() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 2);
        user.setDateOfBirth(calendar.getTime());
        assertEquals(0, user.getAge());
    }
}