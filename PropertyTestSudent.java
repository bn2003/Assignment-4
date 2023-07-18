import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PropertyTestSudent {

    private Property property;

    @Before
    public void setUp() {
        property = new Property("House1", "City1", 1000, "John Doe", 1, 1, 3, 3);
    }

    @Test
    public void testGetPropertyName() {
        assertEquals("House1", property.getPropertyName());
    }

    @Test
    public void testGetCity() {
        assertEquals("City1", property.getCity());
    }

    @Test
    public void testGetRentAmount() {
        assertEquals(1000, property.getRentAmount(), 0.001);
    }

    @Test
    public void testGetOwner() {
        assertEquals("John Doe", property.getOwner());
    }

    @Test
    public void testGetPlot_Success() {
        Plot plot = property.getPlot();
        assertNotNull(plot);
        assertEquals(1, plot.getX());
        assertEquals(1, plot.getY());
        assertEquals(3, plot.getWidth());
        assertEquals(3, plot.getDepth());
    }

    @Test
    public void testToString() {
        assertEquals("House1,City1,John Doe,1000.0", property.toString());
    }
}
