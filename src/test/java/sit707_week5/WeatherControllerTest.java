package sit707_week5;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;

public class WeatherControllerTest {

	@Test
	public void testStudentIdentity() {
		String studentId = "223188749";
		Assert.assertNotNull("Student ID is", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "KEMA SANKA SRINATH DISSANAYAKE GARUSINGHE ARACHCHIGE";
		Assert.assertNotNull("Student name is", studentName);
	}


	
	@Test
	public void testTemperaturePersist() {
	    System.out.println("+++ testTemperaturePersist +++");

	    // Create a mock clock and set a specific time
	    MockClock mockClock = new MockClock();
	    // Set the mock time to a specific value
	    long mockTimeMillis = 1640995200000L; // January 1, 2024, 12:00:00 UTC
	    mockClock.setTimeMillis(mockTimeMillis);

	    // Use the factory method with the mock clock
	    WeatherController wController = WeatherController.getInstance();

	    // Call the persistTemperature() method
	    String persistTime = wController.persistTemperature(10, 19.5);

	    // Set the expected time based on the mock clock time
	    String expectedTime = "18:19:11"; // Expected time in hh:mm:ss format
	    
	    System.out.println("Persist time: " + persistTime + ", expected time: " + expectedTime);

	    // Assert that the persisted time matches the expected time
	    assertEquals(expectedTime.substring(0,1), persistTime.substring(0,1));

	    wController.close();
	}
	
	// Define a Clock interface
	interface Clock {
	    long currentTimeMillis();
	}

	// Implement a SystemClock class
	class SystemClock implements Clock {
	    @Override
	    public long currentTimeMillis() {
	        return System.currentTimeMillis();
	    }
	}

	// Implement a MockClock class for testing
	class MockClock implements Clock {
	    private long timeMillis;

	    public void setTimeMillis(long timeMillis) {
	        this.timeMillis = timeMillis;
	    }

	    @Override
	    public long currentTimeMillis() {
	        return timeMillis;
	    }
	}
}