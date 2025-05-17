package db;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CarsTest {

    @Test
    public void testCarConstructorAndGetters() {
        Cars car = new Cars("Toyota", 2022, 75000, 5, "None");

        assertEquals("Toyota", car.getName());
        assertEquals(2022, car.getModel());
        assertEquals(75000, car.getPrice());
        assertEquals(5, car.getSeats());
        assertEquals("None", car.getIssues());
    }

    @Test
    public void testToStringFormat() {
        Cars car = new Cars("Honda", 2019, 65000, 4, "Engine issue");
        String expected = "Cars{name='Honda', model=2019, price=65000, seats=4, issues='Engine issue'}";
        assertEquals(expected, car.toString());
    }
}