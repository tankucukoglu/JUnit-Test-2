import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JUnitTests {
	
	// cal(int month1, int day1, int month2, int day2, int year)
	
	@Test
	public void testWithLeapYear() {
		int result = Cal.cal(2, 12, 5, 15, 2016);
		assertEquals(93, result);
	}
	
	@Test
	public void testWithoutLeapYear() {
		int result = Cal.cal(2, 12, 5, 15, 2017);
		assertEquals(92, result);
	}
	
	@Test
	public void testSameMonthFalse() {
		int result = Cal.cal(3, 20, 3, 15, 2017); // no precondition for day1 < day2
		assertEquals(-5, result); // incorrect result
		// if day1 < day2, code should either swap the numbers or make the final result positive
	}
	
	@Test
	public void testSameMonthTrue() {
		int result = Cal.cal(3, 15, 3, 20, 2017);
		assertEquals(5, result); // should pass
	}
	
	@Test
	public void testSameMonthSameDay() {
		int result = Cal.cal(2, 15, 2, 15, 1994);
		assertEquals(0, result);
	}
	
	@Test
	public void testFebNot28NonLeapYear() {
		int result = Cal.cal(1, 15, 2, 30, 2017);
		assertEquals(44, result); // should not pass because feb has 28 days in non-leap year
	}

	@Test
	public void testFebNot29LeapYear() {
		int result = Cal.cal(1, 15, 2, 31, 2016);
		assertEquals(45, result); // should not pass because feb has 29 days in leap year
	}
	
	@Test
	public void testWrongNumberOfDaysInMonth() {
		int result = Cal.cal(3, 31, 4, 31, 2017);
		assertEquals(30, result); // should not pass because april has 30 days
	}
	
	@Test
	public void testFullYear() {
		int result = Cal.cal(1, 1, 12, 31, 2016);
		assertEquals(365, result);
	}
	
	@Test
	public void testFebNonLeapYear() {
		int result = Cal.cal(2, 28, 2, 29, 2017);
		assertEquals(0, result);
	}

}
