import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ManagmentCompanyTestSudent {

    private ManagementCompany managementCompany;

    @Before
    public void setUp() {
        managementCompany = new ManagementCompany("ABC Management", "12345", 5.0, 0, 0, 10, 10);
    }

    @Test
    public void testAddProperty_Success() {
        assertEquals(0, managementCompany.addProperty("Property1", "City1", 1000, "John Doe", 1, 1, 3, 3));
        assertEquals(1, managementCompany.addProperty("Property2", "City2", 1200, "Jane Smith", 4, 4, 2, 2));
    }

    @Test
    public void testAddProperty_NullProperty() {
        assertEquals(-2, managementCompany.addProperty(null));
    }

    @Test
    public void testAddProperty_OutsideManagementCompanyPlot() {
        assertEquals(-3, managementCompany.addProperty("Property3", "City3", 1500, "Michael Johnson", 12, 12, 3, 3));
    }

    @Test
    public void testAddProperty_OverlappingProperties() {
        managementCompany.addProperty("Property1", "City1", 1000, "John Doe", 1, 1, 3, 3);
        assertEquals(-4, managementCompany.addProperty("Property4", "City4", 1800, "Emily Adams", 2, 2, 3, 3));
    }

   
    @Test
    public void testRemoveLastProperty_Success() {
        managementCompany.addProperty("Property1", "City1", 1000, "John Doe", 1, 1, 3, 3);
        managementCompany.addProperty("Property2", "City2", 1200, "Jane Smith", 4, 4, 2, 2);
        assertEquals(2, managementCompany.getPropertiesCount());
        managementCompany.removeLastProperty();
        assertEquals(1, managementCompany.getPropertiesCount());
        managementCompany.removeLastProperty();
        assertEquals(0, managementCompany.getPropertiesCount());
    }

    @Test
    public void testRemoveLastProperty_EmptyArray() {
        managementCompany.removeLastProperty(); // Removing from an empty array
        assertEquals(0, managementCompany.getPropertiesCount());
    }

    @Test
    public void testIsPropertiesFull_False() {
        assertFalse(managementCompany.isPropertiesFull());
    }

    @Test
    public void testGetTotalRent_NoProperties() {
        assertEquals(0.0, managementCompany.getTotalRent(), 0.001);
    }

    @Test
    public void testGetTotalRent() {
        managementCompany.addProperty("Property1", "City1", 1000, "John Doe", 1, 1, 3, 3);
        managementCompany.addProperty("Property2", "City2", 1200, "Jane Smith", 4, 4, 2, 2);
        managementCompany.addProperty("Property3", "City3", 1500, "Michael Johnson", 6, 6, 3, 3);
        assertEquals(3700, managementCompany.getTotalRent(), 0.001);
    }

    @Test
    public void testGetHighestRentProperty_NoProperties() {
        assertNull(managementCompany.getHighestRentPropperty());
    }

    @Test
    public void testGetHighestRentProperty_Success() {
        managementCompany.addProperty("Property1", "City1", 1000, "John Doe", 1, 1, 3, 3);
        managementCompany.addProperty("Property2", "City2", 1200, "Jane Smith", 4, 4, 2, 2);
        managementCompany.addProperty("Property3", "City3", 1500, "Michael Johnson", 6, 6, 3, 3);
        Property highestRentProperty = managementCompany.getHighestRentPropperty();
        assertNotNull(highestRentProperty);
        assertEquals("Property3", highestRentProperty.getPropertyName());
        assertEquals(1500, highestRentProperty.getRentAmount(), 0.001);
    }

    @Test
    public void testIsManagementFeeValid_True() {
        assertTrue(managementCompany.isManagementFeeValid());
    }

    @Test
    public void testIsManagementFeeValid_False() {
        managementCompany = new ManagementCompany("XYZ Management", "67890", -1.0, 0, 0, 10, 10);
        assertFalse(managementCompany.isManagementFeeValid());
    }
}
