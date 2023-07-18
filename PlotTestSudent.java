import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PlotTestSudent {

    private Plot plot1;
    private Plot plot2;
    private Plot plot3;
    private Plot plot4;

    @Before
    public void setUp() {
        plot1 = new Plot(2, 2, 6, 6);
        plot2 = new Plot(3, 3, 4, 4);
        plot3 = new Plot(0, 0, 1, 1);
        plot4 = new Plot(7, 7, 2, 2);
    }

    @Test
    public void testGetX() {
        assertEquals(2, plot1.getX());
    }

    @Test
    public void testGetY() {
        assertEquals(2, plot1.getY());
    }

    @Test
    public void testGetWidth() {
        assertEquals(6, plot1.getWidth());
    }

    @Test
    public void testGetDepth() {
        assertEquals(6, plot1.getDepth());
    }

    @Test
    public void testOverlaps_Overlap() {
        assertTrue(plot1.overlaps(plot2));
    }
}

