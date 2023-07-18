/*
 * Class: CMSC203 
 * Instructor: Ashique Tanveer
 * Description: (Give a brief description for each Class)
 * Due: 7/17/2023
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Nguyen Tran
*/

public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;

    // Constructors

    public Plot() {
        this(0, 0, 1, 1); // Default plot with (0, 0) location and width=1, depth=1
    }

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public Plot(Plot otherPlot) {
        this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth);
    }

    // Getters and Setters

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    // Methods

    public boolean overlaps(Plot other) {
        // Check if this plot overlaps with the other plot
        boolean xOverlap = (this.x <= other.x && other.x < this.x + this.width) || (other.x <= this.x && this.x < other.x + other.width);
        boolean yOverlap = (this.y <= other.y && other.y < this.y + this.depth) || (other.y <= this.y && this.y < other.y + other.depth);
        return xOverlap && yOverlap;
    }

    public boolean encompasses(Plot other) {
        // Check if this plot encompasses the other plot
        boolean xEncompass = this.x <= other.x && this.x + this.width >= other.x + other.width;
        boolean yEncompass = this.y <= other.y && this.y + this.depth >= other.y + other.depth;
        return xEncompass && yEncompass;
    }

    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}
